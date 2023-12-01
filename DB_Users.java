import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Users{
    public static void main(String[] args){
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

            while(rset.next()){
                //Columnas
                System.out.println(rset.getInt(1) // id_user
                + " " + rset.getString(2) // type_user
                + " " + rset.getString(3) // user_name
                + " " + rset.getString(4) // first_lastname
                + " " + rset.getString(5) // second_lastname
                + " " + rset.getString(6) // name
                + " " + rset.getDate(7)   // birthday
                + " " + rset.getString(8) // email
                + " " + rset.getString(9) // gender    
                + " " + rset.getString(10)// phone_number
                + " " + rset.getString(11)// password
                + " " + rset.getDate(12)  // created
                );
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}