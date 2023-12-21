package Proyecto;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Autenticacion {
    private String correoElectronico;
    private String password;
    private JFrame loginFrame;

    public Autenticacion(String correoElectronico, String password, JFrame loginFrame) {
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.loginFrame = loginFrame; // Almacenar la referencia a la ventana de Login
    }

    public String autenticar() {
        String mensaje = "";

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        try (Connection connection = DriverManager.getConnection(URL, user, pass)) {
            // Preparar la consulta SQL para obtener el ID y la contraseña del usuario por
            // correo
            String query = "SELECT id, password FROM progra2.users WHERE email = ? ORDER BY id DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, correoElectronico);

                try (ResultSet resultSet = statement.executeQuery()) {
                    // Verificar si se encontró un resultado
                    if (resultSet.next()) {
                        int idUsuario = resultSet.getInt("id");
                        String contraseñaHash = resultSet.getString("password");

                        // Consultar la tabla sessions para verificar la existencia del ID y obtener el
                        // timeout
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
                                            String token = Auth.calculateToken();
                                            String expiration = Auth.calculateExpiration(10);
                                            // Escribir en token.txt
                                            try (FileWriter writer = new FileWriter("token.txt")) {
                                                writer.write(token + "," + expiration);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }

                                            CrearSession nuevo = new CrearSession();
                                            nuevo.crearSesion(connection, idUsuario, token, expiration);
                                            mensaje = "Autenticación exitosa";
                                        }
                                    } else {
                                        // Contraseñas no coinciden
                                        mensaje = "Contraseña incorrecta";
                                        // loginFrame.dispose(); // Cerrar la ventana de Login
                                        // new GuiErrores(mensaje).setVisible(true);

                                    }
                                } else {
                                    mensaje = "Usuario no registrado";
                                    // loginFrame.dispose(); // Cerrar la ventana de Login
                                    // new GuiErrores(mensaje).setVisible(true);
                                }
                            }
                        }
                    } else {
                        mensaje = "Correo electrónico no encontrado";
                        // loginFrame.dispose(); // Cerrar la ventana de Login
                        // new GuiErrores(mensaje).setVisible(true);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

            // Mostrar un mensaje de error al usuario
            String mensajeError = "Error al conectar con la base de datos";
            JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);

            mensaje = "Error de autenticación"; // Actualizar el mensaje para no entrar en el if
        }

        System.out.println(mensaje);
        return mensaje;
    }
}