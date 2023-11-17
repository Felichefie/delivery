import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Session {
    public void Log (){
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
                //(id, id_user, session, timeout, created)
                String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8,13);
                String sessionUUID = UUID.randomUUID().toString().substring(1,10);
                String session = sessionTime + sessionUUID;
                System.out.println("Session: " + session);

                LocalDateTime nowDate = LocalDateTime.now();
                System.out.println("Created: " + nowDate);

                LocalDateTime endTimeSession = nowDate.plusMinutes(20);
                System.out.println("Timeout: " + endTimeSession);
                
                

            } else {
               // System.out.println("Error en el inicio de sesión");
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

            // Generar la cadena de sesión
            String sessionId = UUID.randomUUID().toString();

            // Insertar la sesión en la tabla sessions
            String queryInsert = "INSERT INTO progra2.sessions(id_user, session, timeout, created) VALUES (?, ?, 630, NOW())";
            PreparedStatement prepStateInsert = conn.prepareStatement(queryInsert);
            prepStateInsert.setInt(1, res.getIdUser());
            prepStateInsert.setString(2, sessionId);
            prepStateInsert.executeUpdate();

            // Establecer el ID de sesión en el objeto Response
            res.setSession(sessionId);

            // Recuperar la sesión generada
            String querySelect = "SELECT session FROM progra2.sessions WHERE id_user=" + res.getIdUser() + " ORDER BY created DESC LIMIT 1";
            Statement statementSelect = conn.createStatement();
            ResultSet rsetSelect = statementSelect.executeQuery(querySelect);

            while (rsetSelect.next()) {
                String generatedSessionId = rsetSelect.getString(1);
                System.out.println("Sesión generada: " + generatedSessionId);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error en la query");
    }

    return res;
}

}
