import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tres{
    public static void main(String[] args){
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.sessions";
        String queryInsert = "INSERT INTO progra2.sessions(id, id_user, session, timeout, created) VALUES (5, 1, ?, NOW(), NOW())";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);
           
           PreparedStatement prepState = conn.prepareStatement(queryInsert);
           prepState.setString(1, Log.session());
           prepState.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}