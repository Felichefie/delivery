import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Visualizar {
    public static void main(String[] args) {
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.users";
        // String queryInsert = "INSERT INTO progra2.address(id_user, street, number,
        // number_two, neighborhood, city, state, country, postal_code, gps_lat,
        // gps_lon)";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {
                // Columnas
                System.out.println(rset.getInt(1) // id_user
                        + " " + rset.getString(2) // type_user
                        + " " + rset.getString(3) // user_name
                        + " " + rset.getString(4) // first_lastname
                        + " " + rset.getString(5) // second_lastname
                        + " " + rset.getString(6) // name
                        + " " + rset.getDate(7) // birthday
                        + " " + rset.getString(8) // email
                        + " " + rset.getString(9) // gender
                        + " " + rset.getString(10)// phone_number
                        + " " + rset.getString(11)// password
                        + " " + rset.getDate(12) // created
                );
            }
            // Escriben en la base de dato, como estan comentadas, solo lee
            // PreparedStatement prepState = conn.prepareStatement(queryInsert);
            // prepState.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}