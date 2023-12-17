import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Login {

    private String emailUI;
    private String passwordUI;
    private static String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    private static String user = "alumno";
    private static String pass = "alumnoPrueba1";

    public static void main(String[] args) {

        String email = "felix.jimenez@umich.mx";
        String password = "$2b$10$V8efW0/fbrJrX2d/YGXzr.AyYnme8g6xCOyHdURhFQw/I5BR4kWCO";

        System.out.println("Login:");
        
        //Obtener conexion a la base de datos
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);

        Connection conn = dbconnection.getConn();

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            new LoginUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    Login(String emailUI, String passwordUI){
        this.emailUI = emailUI;
        this.passwordUI = passwordUI;
    }

    public boolean registro(String email, String pwd){
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        String pwd_hash = "";        
        pwd_hash = BCrypt.hashpw(pwd, BCrypt.gensalt());
        return dbconnection.registerUser(email, pwd_hash);
    }

}
