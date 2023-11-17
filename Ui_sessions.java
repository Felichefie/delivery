import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ui_sessions{
    public static void main(String[] args){
        Connection conn;
        ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.sessions";
        //String queryInsert = "INSERT INTO progra2.sessions(id, id_user, session, timeout, created)";

        try {
            conn = DriverManager.getConnection(URL, user, pass);
            Statement statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                System.out.println(rset.getInt(1) // id
                + " " + rset.getInt(2) // id_user
                + " " + rset.getString(3) // session
                + " " + rset.getDate(4) // timeout
                + " " + rset.getDate(5) // created
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