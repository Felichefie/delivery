import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Visualizar {
    public static void main(String[] args) {
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.users";
        String queryInsert = "INSERT INTO progra2.users(first_lastname, second_lastname, name, birthday, email, gender, phone_number,password, created) VALUES ('gabriel', 'Nicolas', 'Elena', '2004-08-18', 'ele@gmail.com', 'Female', '1234567891', ?, NOW())";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);

            // Insercion
            PreparedStatement prepState = conn.prepareStatement(queryInsert);

            //   1. Antes de guardar la información en la base de datos, 
            //    convertir la contraseña en una cadena HASH y almacenar esta cadena en la base de datos.
            //    Se almacena en la tabla users, la columna password.
            String p = "elenaGabriel123#"; 
            String hash_Password = BCrypt.hashpw(p, BCrypt.gensalt());
            prepState.setString(1, hash_Password);

            int rowsAffected = prepState.executeUpdate();

            // Mensajes mostrados en la terminal
            if (rowsAffected > 0) {
                System.out.println("Nuevo usuario registrado");
            } else {
                System.out.println("No se pudo registrar el nuevo usuario");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
