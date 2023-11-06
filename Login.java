import java.sql.Connection;
import java.sql.SQLException;

public class Login {
   
    public static void main(String[] args) throws SQLException {
        String URL= "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user= "alumno";
        String pass = "alumnoPrueba1";
        
        String email = "1701450h@umich.mx";
        String password = "corona13";
        
        DbConnection dbconnection = new DbConnection(URL, user, pass);
        Connection conn = DbConnection.getConn();
        Response r = dbconnection.LogAuth(email, password, conn);
        if (r.isStatus()==true){
            System.out.println("Usuario Auntentificado");
            System.out.println("Sesion: " + r.getSession());
        } else {
            System.out.println("Usuario no autentificado");
            System.out.println("Sesion: " + r.getSession());
        }

        
   
    }





}
