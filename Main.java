import org.springframework.security.crypto.bcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbconn = new Dbconnection(URL, user, pass);

        String userName = "1903458g@umich.mx";
        String password = "12345678";

        String pwd_hash = BCrypt.hashpw(password, BCrypt.gensalt());

        dbconn.registerUser(userName,pwd_hash);

        if(dbconn.LogAuth(userName, password)){
            System.out.println("Incio de sesion exitoso");
        }else{
            System.out.println("Usuario o contraseña incorrectos");
        }

        int idUser = dbconn.getUserId(userName);
        String street = "Calle 1";
        int number = 1001;
        String number_two = "A";
        String neighborhood = "Centro";
        String postal_code = "59600";
        String gps_lat = "19.7000";
        String gps_lon = "-10.18";

        dbconn.insertAddress(idUser, street, number, number_two, neighborhood, postal_code, gps_lat, gps_lon);

    }
}
