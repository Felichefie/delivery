import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Dbconnection {

    static Connection conn = null;

    
    public List<Producto> getProduct(){
        List<Producto> listaProductos = new ArrayList<>();

        String query = "SELECT id, price, image, description, stock FROM progra2.products WHERE id IN (13, 14, 15);";
       // System.out.println(query);
        ResultSet rset;
        Statement statement;

        try {
            
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                int id = rset.getInt(1);
                double price = rset.getDouble(2);
                String image = rset.getString(3);
                String desc = rset.getString(4);
                int stock = rset.getInt(5);
                

                Producto producto = new Producto(id, price, image, desc, stock);
                listaProductos.add(producto);
            }
                        
        } catch (Exception e) {

            System.out.println("Error en la query");
        }
        return listaProductos;
    }

    public Connection getConn() {
        return conn;
    }

    Dbconnection(String URL, String user, String pass){

        try {

            conn = DriverManager.getConnection(URL, user, pass);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    boolean insertAddress(int idUser, String street, int number, String number_two, String neighborhood, String postal_code, String gps_lat, String gps_lon){

        String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, postal_code, gps_lat, gps_lon)"
                + "VALUES('" + idUser
                + "', '" + street
                + "', '" + number
                + "', '" + number_two
                + "', '" + neighborhood
                + "', '" + postal_code
                + "', '" + gps_lat
                + "', '" + gps_lon
                + "')";

        if(getAddress(idUser, street, number)){
            System.out.println("Direccion ya registrada");
            return false;
        }

        PreparedStatement preState;

        try {

            preState = conn.prepareStatement(queryInsert);
            preState.execute();
            System.out.println("Direccion de usuario Insertada");
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Error al insertar la direccion del usuario");
            return false;

        }
    
    }

    boolean getAddress(int idUser, String street, int num){
        String query = "SELECT id FROM progra2.address a WHERE a.id_User = " + idUser + " AND a.street = '" + street +  "' AND a.number = "+ num;
        
        ResultSet rset;
        Statement statement;

        try {
            
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

             if (rset.next()) {
                System.out.println("Direccion encontrada: " + rset.getString(1));
                return true;
            } else {
                System.out.println("Direccion no encontrada.");
                return false;
            }
            
        } catch (Exception e) {

            System.out.println("Error en la query");
            return false;

        }
    }

    boolean LogAuth(String user, String passwordLogin){
        String query = "SELECT u.password FROM progra2.users u WHERE u.user_name ='" + user + "'";
        
        ResultSet rset;
        Statement statement;
        String passwordDB = "";

        try{

            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                passwordDB = rset.getString(1);
                //System.out.println(rset.getString(1));
            }
            boolean passwordMatch = false;
            //System.out.println(passwordLogin);
            try{
                passwordMatch = BCrypt.checkpw(passwordLogin, passwordDB);
            }catch(Exception e){
                System.out.println("Error al comparar contraseñas");
            }

            if(passwordMatch){
                return true;
            }
            
        }catch(SQLException e){   
            System.out.print("Error en la query");
            return false;
        }

        return false;

    }

    boolean registerUser(String name, String ape1, String ape2, String email, String pwd, String user, String tel){

        String queryInsert = "INSERT INTO progra2.users (user_name, first_lastname, second_lastname, name, email, phone_number, password) " 
        + "VALUES('"+ user +"' , '"+ ape1 +"' , '"+ ape2 +"' , '"+ name +"' , '"+ email +"' , '"+ tel +"' , '"+ pwd +"')";

        PreparedStatement preState;

        if(searchUser(user)){
            return false;
        }

        try {

            preState = conn.prepareStatement(queryInsert);
            preState.execute();
            System.out.println("Usuario registrado");
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("Error al insertar usuario");
            return false;

        }
        
    }

    boolean searchUser(String user){
        String query = "SELECT u.email FROM progra2.users u WHERE u.user_name ='" + user + "'";
        ResultSet rset;
        Statement statement;
        
        try {
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
    
            if (rset.next()) {
                System.out.println("Usuario encontrado: " + rset.getString(1));
                return true;
            } else {
                System.out.println("Usuario no encontrado.");
                return false;
            }
    
        } catch (SQLException e) {
            System.out.println("Error en la query");
            e.printStackTrace(); 
        }
        return false;
    }

    int getUserId(String email){
        String query = "SELECT id FROM progra2.users u WHERE u.email ='" + email + "'" ;
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        int id_user = 0;
        try{

            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                    System.out.println(rset.getString(1)
                );
                id_user = Integer.parseInt(rset.getString(1));
            }
        }catch(SQLException e){    
            System.out.println("Error en la query del id");
        }
        return id_user;

    }
    
}
