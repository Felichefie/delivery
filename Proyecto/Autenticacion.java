package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Autenticacion {
    private String correoElectronico;
    private String password;

    public Autenticacion(String correoElectronico, String password) {
        this.correoElectronico = correoElectronico;
        this.password = password;
    }

    public String autenticar() {
        String mensaje = "";

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        try (Connection connection = DriverManager.getConnection(URL, user, pass)) {
            // Preparar la consulta SQL para obtener el ID y la contraseña del usuario por correo
            String query = "SELECT id, password FROM progra2.users WHERE email = ? ORDER BY id DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, correoElectronico);

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Verificar si se encontró un resultado
                    if (resultSet.next()) {
                        int idUsuario = resultSet.getInt("id");
                        String contraseñaHash = resultSet.getString("password");

                        // Consultar la tabla sessions para verificar la existencia del ID y obtener el timeout
                        String sessionQuery = "SELECT timeout FROM progra2.sessions WHERE id_user = ?";
                        try (PreparedStatement sessionStatement = connection.prepareStatement(sessionQuery)) {
                            sessionStatement.setInt(1, idUsuario);
                            try (ResultSet sessionResultSet = sessionStatement.executeQuery()) {
                                if (sessionResultSet.next()) {
                                    if (BCrypt.checkpw(password, contraseñaHash)) {
                                        // Si las contraseñas coinciden
                                        Timestamp timeout = sessionResultSet.getTimestamp("timeout");

                                        // Obtener el tiempo actual en milisegundos y convertirlo a Timestamp
                                        long tiempoActualMillis = System.currentTimeMillis();
                                        Timestamp tiempoActual = new Timestamp(tiempoActualMillis);

                                        if (timeout.after(tiempoActual)) {
                                            // Autenticación exitosa y la sesión no ha expirado
                                            mensaje = "Autenticación exitosa";
                                            System.out.println(timeout);
                                            System.out.println(tiempoActual);


                                        } else {
                                            // La sesión ha expirado, mostrar mensaje
                                            mensaje = "Tu sesión ha expirado, regístrate nuevamente";
                                        }
                                    } else {
                                        // Contraseñas no coinciden
                                        mensaje = "Contraseña incorrecta";
                                    }

                                } else {
                                    mensaje = "Usuario no registrado";
                                }
                            }
                        }
                    } else {
                        mensaje = "Correo electrónico no encontrado";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al conectar con la base de datos";
        }

        System.out.println(mensaje);
        return mensaje;
    }
}
