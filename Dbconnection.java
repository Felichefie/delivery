/* 
 * Se tienen 2 metodos, uno para encontrar usuarios y uno para encontrar direcciones
 * En este caso no se necesita insertar, solo verificar si existe un usuario y mostrar sus datos
 * y si existe una direccion y mostrar sus datos.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {

    static Connection conn = null;


    Dbconnection(String URL, String user, String pass){

        try {

            conn = DriverManager.getConnection(URL, user, pass);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    void closeConnection(){

        try {

            conn.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    User getUser(String email, String phone){
        User user = null;
        
        String query = "SELECT * FROM progra2.users u WHERE u.email ='" + email + "' OR u.phone_number = '" + phone + "'";
        //System.out.println(query);
        ResultSet rset;
        Statement statement;

        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            while(rset.next()){

                    /*System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                    + " " + rset.getString(7)
                    + " " + rset.getString(8)
                    + " " + rset.getString(9)

                );*/
                user = new User();
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
            System.out.println("ERROR");
        }
        return user;
    }
    
    Address getAddress(int idUser){
        Address address = null;

        String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser;
        //System.out.println(query);
        ResultSet rset;
        Statement statement;

        try {
            
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
            /*  System.out.println(rset.getString(1)
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
            );*/
            address  = new Address();
            address.setId(Integer.parseInt(rset.getString(1)));
            address.setId_user(Integer.parseInt(rset.getString(2)));
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
            System.out.println("ERROR");

        }
        return address;
    }
}