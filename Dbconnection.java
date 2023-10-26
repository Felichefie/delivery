import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {

    static Connection conn = null;

    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        String correo = "562561@umich.mx";
        int phone = 1234567890;

        Dbconnection dbConn = new Dbconnection(URL, user, pass);
        UserExample u = dbConn.getUser(correo, phone);
        Address a = dbConn.getAddress(u.getId());

        if(u.getId() == 0){

            System.out.println("NO EXISTE");
            dbConn.InsertNewUser(u);

        }else{

            System.out.println(u.getUserName());
            System.out.println(u.getId());
            System.out.println(u.getEmail());
            System.out.println(u.getPhoneNumber());

        }

        if(a.getId() == 0){

            System.out.println("El usuario no tiene direcciones");
            dbConn.InsertNewAddress(u);

        }else{

            System.out.println(a.getStreet());
            System.out.println(a.getNumber());
            
        }

        try {

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    boolean InsertNewAddress(UserExample user){
        
        String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, city, state, country, postal_code, gps_lat, gps_lon)"
                + "VALUES(" + user.getId() + ", 'Calle' , 5000, '' , 'Colonia' , 'Morelia' , 'Michoacan' , 'Mexico' , '58000' , 19.7008 , 1.2)";
        
        System.out.println(queryInsert);
        PreparedStatement preState;

        try {
                
                preState = conn.prepareStatement(queryInsert);
                preState.execute();
                System.out.println("Direccion insertada");
                return true;
    
            } catch (SQLException e) {
    
                e.printStackTrace();
                System.out.println("Error al insertar direccion");
                return false;
            }
    }

    boolean InsertNewUser(UserExample user){

        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                + "VALUES('" + user.getUserName()
                + "', 'Chabelo', 'Monster', '" 
                + user.getName() 
                + "', '2023-10-20', '"
                + user.getEmail() + "')";

        PreparedStatement preState;

        try {

            preState = conn.prepareStatement(queryInsert);
            preState.execute();
            System.out.println("Usuario insertado");
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Error al insertar usuario");
            return false;

        }
        
    }

    Dbconnection(String URL, String user, String pass){

        try {

            conn = DriverManager.getConnection(URL, user, pass);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    Address getAddress(int idUser){
        Address address = new Address();

        String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser;
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        try {
            
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                System.out.println(rset.getString(1)
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)
                + " " + rset.getString(7)
                + " " + rset.getString(8)
                + " " + rset.getString(9)
                + " " + rset.getString(10)
                + " " + rset.getString(11)
                + " " + rset.getString(12)
            );

            address.setId(Integer.parseInt(rset.getString(1)));
            address.setIdUser(Integer.parseInt(rset.getString(2)));
            address.setStreet(rset.getString(3));
            address.setNumber(Integer.parseInt(rset.getString(4)));
            address.setNumber_two(rset.getString(5));
            address.setNeighborhood(rset.getString(6));
            address.setCity(rset.getString(7));
            address.setState(rset.getString(8));
            address.setCountry(rset.getString(9));
            address.setPostal_code(rset.getString(10));
            address.setGps_lat(rset.getString(11));
            address.setGps_lon(rset.getString(12));
            }
            
        } catch (Exception e) {

            System.out.println("Error en la query");
            address.setId(1);

        }
        return address;
    }

    UserExample getUser(String email, int phone){
        UserExample user = new UserExample();
        
        String query = "SELECT * FROM progra2.users u WHERE u.email ='" + email + "' OR u.phone_number = '" + phone + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        try{

            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){

                    System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                    + " " + rset.getString(7)
                    + " " + rset.getString(8)
                    + " " + rset.getString(9)

                );

                user.setId(Integer.parseInt(rset.getString(1)));  
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));
                user.setEmail(rset.getString(7));
                user.setPhoneNumber(Integer.parseInt(rset.getString(9)));

            }
        }catch(SQLException e){    
            System.out.print("Error en la query");
            user.setId(1);
        }
        return user;

    }

    
}
