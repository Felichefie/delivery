import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ui{
    public static void main(String[] args){
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.address";
        //String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, city, state, country, postal_code, gps_lat, gps_lon)";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                System.out.println(rset.getInt(1)
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)
                + " " + rset.getString(7)
                + " " + rset.getString(8)
                + " " + rset.getString(9)             
                + " " + rset.getFloat(10)
                + " " + rset.getFloat(11)
                );
            }
            //Escriben en la base de dato, como estan comentadas, solo lee
           // PreparedStatement prepState = conn.prepareStatement(queryInsert);
           // prepState.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

}