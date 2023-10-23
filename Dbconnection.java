import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Dbconnection {
    public static void main(String[] args) {

        Connection conn = null;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.users";
        String queryInsert = "INSERT INTO progra2.users (user_name, first_lastname, second_lastname, name, birthday, email)"
        + "VALUES ('pepito', 'Chabelo', 'Monster', 'José', '2023-10-20', 'pepito@chabelo.com')";

        try {

            conn = DriverManager.getConnection(URL, user, pass);
            Statement stmt = conn.createStatement();

            /*PreparedStatement pstmt = conn.prepareStatement(queryInsert);
            pstmt.execute();*/

            rset = stmt.executeQuery(query);

            while(rset.next()){
                System.out.println(rset.getString(1) + " " + rset.getString(2)
                + " " + rset.getString(3) + " " + rset.getString(4) + " " + rset.getString(5) 
                + " " + rset.getString(6) + " " + rset.getString(7) + " " + rset.getString(8));
            }
            
            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
