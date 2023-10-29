import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbconnection {
    static Connection conn;
    public static void main(String[] args){
    
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbConn = new Dbconnection(URL, user, pass);
        User u = dbConn.getUser("felix.jimenez@umich.mx", "4431234567");
        if (u.getId() == 0){
            System.out.println("No existe");
            dbConn.insertNewUser(u);
        }
        else{
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }
        try {
            conn.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        Dbconnection dbConnadd = new Dbconnection(URL, user, pass);


        Address addr = dbConnadd.getAddress(1,"Privada Jacarandas", 109);

        if (addr.getId_user() == 0){
            System.out.println("No existe");
            //dbConn.insertNewUser(u);
        }
        else{
            System.out.println(addr.getId_user());
            System.out.println(addr.getStreet());
            System.out.println(" existe");
        }
        try {
            conn.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
 System.out.println("id_user en Address: " + addr.getId_user());

    }

    boolean insertNewUser(User user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)" 
                    + " VALUES('" + user.getUserName() 
                    + "', 'chabelo', 'monster','"  
                    + user.getName() 
                    + "', '2023-10-20', 'ele@.com')";
        //Escriben en la base de dato
        
        try{
            PreparedStatement prepState = conn.prepareStatement(queryInsert);
            prepState.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

        Dbconnection(String URL, String user, String pass ){
        try {
            conn = DriverManager.getConnection(URL, user, pass);
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        User getUser(String email, String phone_number){
            User user = new User();
           // SELECT *  FROM progra2.users u WHERE u.email = 'felix.jimenez@umich.mx' OR u.phone_number = '4431234567';

            String query = "SELECT * FROM progra2.users u WHERE u.email = '" 
                            + email + "' OR u.phone_number = '" + phone_number + "'";
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
                );
                user.setId(Integer.parseInt(rset.getString(1)));
                user.setName(rset.getString(4));
                user.setUserName(rset.getString(5));
            }
            }catch(SQLException e){
                System.out.println("Error en la query");
                user.setId(1);
            }
            return user;
        }


        Address getAddress(Integer id_user, String street, Integer number){
            Address address = new Address();
           // SELECT * FROM progra2.address WHERE id_user = 1;
            //SELECT * FROM progra2.address a WHERE a.id_user = 1 AND a.street = 'Privada Jacarandas ' AND a.number = 109;"
            String query = "SELECT * FROM progra2.address a WHERE a.id_user = " + id_user +
               " AND a.street = '" + street + "' AND a.number = " + number;

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
                    + " " + rset.getFloat(10)
                    + " " + rset.getFloat(11)
                );
                address.setId_user(Integer.parseInt(rset.getString(1)));
                address.setStreet(rset.getString(2));
                address.setNumber(Integer.parseInt(rset.getString(3)));
            }
            }catch(SQLException e){
                System.out.println("Error en la query");
                address.setId_user(1);
            }
            return address;
        }
}

