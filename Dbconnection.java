import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
    public static void main(String[] args) {
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String password = "alumnoPrueba1";

        
        String query = "SELECT * FROM progra2.users";
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                + "VALUES('Pepito', 'Chabelo', 'Monster', 'Jose','2023-10-20', '20b@umich.mx'))";
        
            try {
                conn = DriverManager.getConnection(URL, user, password);
                Statement statement = conn.createStatement();
                rset = statement.executeQuery(query);
                while(rset.next()){
                    System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                    + " " + rset.getString(7)
                    );
                    
                }
            //ESCRIBE EN LA BASE DE DATOS
            //PreparedStatement preState = conn.prepareStatement(queryInsert);
            //preState.execute();

            conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        
    }
    
}
