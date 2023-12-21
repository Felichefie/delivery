import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Main {

    static String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    static String user = "alumno";
    static String passw = "alumnoPrueba1";
    static Dbconnection dbconn = new Dbconnection(URL, user, passw);
    static List<Pizza> productos = dbconn.getProduct();

    public static String[] getImageNames() {
        
        List<String> imageNamesList = new ArrayList<>();
        
        for (Pizza producto : productos) {
            String image = producto.getImg();
            imageNamesList.add(image);
        }
        
        return imageNamesList.toArray(new String[0]);
    }

    public static String[] getDescriptions() {
        
        List<String> descriptionsList = new ArrayList<>();
        
        for (Pizza producto : productos) {
            String description = producto.getDesc();
            descriptionsList.add(description);
        }

        
        return descriptionsList.toArray(new String[0]);
    }

    public static double[] getPrices() {
        
        List<Double> pricesList = new ArrayList<>();
            
        for (Pizza producto : productos) {
            double price = producto.getPrice();
            pricesList.add(price);
        }
            
        return pricesList.stream().mapToDouble(Double::doubleValue).toArray();
    }

    static public String[] getStockQuantities() {
       
        List<String> stockQuantitiesList = new ArrayList<>();
        
        for (Pizza producto : productos) {
            int stockQuantity = producto.getStock();
            // Agregar "Cantidad Disponible: " seguido del stock al resultado
            stockQuantitiesList.add("Cantidad Disponible: " + stockQuantity);
        }

        return stockQuantitiesList.toArray(new String[0]);
    
    }

    public static boolean inicio(String userName, String pass){

        if(dbconn.LogAuth(userName, pass)){
            return true;
        }else{
            return false;
        }

    }

    public static boolean registro(Users user){

        String name = user.getName();
        String ape1 = user.getApe1();
        String ape2 = user.getApe2();
        String email = user.getEmail();
        String pass = user.getPass();
        String userName = user.getUserName();
        String tel = user.getTel();

        String pwd_hash = BCrypt.hashpw(pass, BCrypt.gensalt());

        if(dbconn.registerUser(name, ape1, ape2, email, pwd_hash, userName, tel)){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbconn = new Dbconnection(URL, user, pass);

        String userName = "JUANPL";

        String name = "Juan";
        String ape1 = "Perez";
        String ape2 = "Lopez";
        String email = "";
        String password = "12345678";
        String user2 = "JuanPL";
        String tel = "1234567890";

        String pwd_hash = BCrypt.hashpw(password, BCrypt.gensalt());

        dbconn.registerUser(name, ape1, ape2, email, pwd_hash, user2, tel);

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
