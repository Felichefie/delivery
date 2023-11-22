import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Login {

    private String emailGUI;
    private String passwordGUI;
    private static String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    private static String user = "alumno";
    private static String pass = "alumnoPrueba1";

    public static void main(String[] args) {

        String email = "felix.jimenez@umich.mx";
        String password = "$2b$10$V8efW0/fbrJrX2d/YGXzr.AyYnme8g6xCOyHdURhFQw/I5BR4kWCO";

        System.out.println("LOGIN:");
        
        
//Establece la conexion a la base de datos
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        Connection conn = dbconnection.getConn(); 
        Response r = dbconnection.LogAuth(email, password);

        if(r.isStatus()){
            System.out.println("Usuario Autenticado");
            System.out.println("Id: " + r.getIduserr());
            System.out.println("Sesion: " + r.getSesion());
        }else{
            System.out.println("Usuario no Autenticado");
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            new LoginGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
//Constructror
    Login(String emailUI, String passwordUI){
        this.emailGUI = emailUI;
        this.passwordGUI = passwordUI;
    }


//INICIAR SESION
    public boolean inicioSesion(){
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        Response r = dbconnection.LogAuth(emailGUI, passwordGUI);

        if(r.isStatus()){
            

            String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
            String sessionUUID = UUID.randomUUID().toString().substring(1, 10);
            String session = sessionTime + sessionUUID;
            System.out.println(session);

            LocalDateTime nowDate = LocalDateTime.now();
            System.out.println(nowDate);

            if(dbconnection.createSession(dbconnection.getUser(emailGUI), session, nowDate)){
                return true;    
            }
            return false;
            
        }else{
            return false;
        }
    }



//REGISTRARSE
    public boolean registro(String email, String pwd){
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        String pwd_hash = "";        
        pwd_hash = BCrypt.hashpw(pwd, BCrypt.gensalt());
        return dbconnection.registerUser(email, pwd_hash);
    }

}
