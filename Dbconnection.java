import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {

    static Connection conn = null;

    void closeConnection(){

        try {

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    boolean InsertNewAddress(Usuario user){
        
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

    boolean InsertNewUser(Usuario user){

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

        String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser + " AND a.street = 'Privada Jacarandas ' AND a.number = 109";
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

    Usuario getUser(String email, String phone){
        Usuario user = new Usuario();
        
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
                user.setUserName(rset.getString(2));
                user.setFirst_lastname(rset.getString(3));
                user.setSecond_lastname(rset.getString(4));
                user.setName(rset.getString(5));
                user.setBirthday(rset.getString(6));
                user.setEmail(rset.getString(7));
                user.setGender(rset.getString(8));
                user.setPhone_number(rset.getString(9));

            }
        }catch(SQLException e){    
            System.out.println("Error en la query");
            //e.printStackTrace();
            user.setId(1);
        }
        return user;

    }

    
}
