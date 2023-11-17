import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Buscar {
    public static void main(String[] args) {
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.users";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);

            //login
            String email = "ele@gmail.com";
            String passwordLogin = "elenaGabriel123#";

            Response res = logAuth(email, passwordLogin, conn);
            if (res.isStatus()) {
                System.out.println("Inicio de sesión exitoso");
                System.out.println("Usuario: " + email);
                System.out.println("Sesión: " + res.getSession());
            } else {
                System.out.println("Error en el inicio de sesión");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static Response logAuth(String email, String passwordLogin, Connection conn) {
        // res inicial status= false, user= -1 session = ""
        Response res = new Response();
        String query = "SELECT password FROM progra2.users WHERE email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDB = "";

        try {
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {
                passwordDB = rset.getString(1);
            }

            if (BCrypt.checkpw(passwordLogin, passwordDB)) {
                
                res.setStatus(true);
                res.setSession("test_session");
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return res;
    }
}
