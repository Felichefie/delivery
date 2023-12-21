package Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CrearSession {
    public void crearSesion(Connection conn, int userId, String token, String expiration) {
        String queryInsertSession = "INSERT INTO progra2.sessions(id_user, session, timeout, created) VALUES (?, ?, ?, ?)";
        try (PreparedStatement prepStateSession = conn.prepareStatement(queryInsertSession)) {
            prepStateSession.setInt(1, userId); // id_user
            prepStateSession.setString(2, token); // session
            prepStateSession.setTimestamp(3, Timestamp.valueOf(expiration)); // timeout
            prepStateSession.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // created
            prepStateSession.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al crear la session");
            
        }
    }
}
