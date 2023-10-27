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
        String password = "alumnoPrueba1";
       System.out.println("CONECTANDO A LA BASE DE DATOS...");


        Dbconnection dbConn = new Dbconnection(URL, user, password);
        User u = dbConn.getUser("felix.jimenez@umich.mx");
        if(u.getId() == 0){
            System.out.print("NO EXISTE");
            dbConn.InsertnewUser(u);
        }else{
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

///////////////////para direccion
        Dbconnection dbconn1 = new Dbconnection(URL, user, password);
        //Address a = dbconn1.getAddress("1","Privada Jacarandas","109");
       Address a = dbconn1.getAddress("1", "Privada Jacarandas", "109");
        if(a.getId() == 0){
        System.out.println("ESTA DIRECCION NO EXISTE...");
        dbconn1.insertNewAddress(a);
       }else{
        System.out.print(a.getId_user());
        System.out.println(a.getStreet());
        System.out.println(a.getNumber());
       }
       try{
            conn.close();
       }catch(SQLException e){
            e.printStackTrace();
       }

    }

    boolean InsertnewUser(User user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)" 
        + "VALUES('" + user.getUserName() + "', 'Chabelo', 'Monster','" + user.getname() + "', '2023-10-20', 'pepitoalcachofa@chabelo.com')";
        try {
            PreparedStatement preStatement = conn.prepareStatement(queryInsert);
            preStatement.executeUpdate();
            preStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Otra opcion
    


    /////////////////////para direccion
    boolean insertNewAddress(Address address){

        String queryInsert1 = "INSERT INTO progra2.address(id, id_user, street, number, number_two, neighborhood, city, state, country, postal_code, gps_lat, gps_lon)"
        + "VALUES('" + address.getId_user() + "','1','" + address.getStreet() + "', '" + address.getNumber() + "', '332', 'colonias', 'morelia', 'michoacan', 'mexico', '58322','2.2', '2.3')";

        try {
            PreparedStatement preStatement = conn.prepareStatement(queryInsert1);
            preStatement.execute();
            preStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    Dbconnection(String URL, String user,String password){       
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
                e.printStackTrace();
        }        

    }

    User getUser(String email){
        User user = new User();
        String query = "SELECT * FROM progra2.users u WHERE u.email ='" + email + "'";
        //(ResultSet), recupera el resultado de la consulta SQL
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
                );
                user.setId(Integer.parseInt(rset.getString(1)));  
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));
            }
        }catch(SQLException e){    
            System.out.print("Error en la query");
            user.setId(1);
        }
        return user;
    }

//////////////////para direccion
     /**
     * @param id_user
     * @return
     */
    Address getAddress(String id_user, String street, String number){
        Address address2 = new Address();
        String query = "SELECT * FROM progra2.address a WHERE a.id_user = '" + id_user + "' AND a.street = '" + street + "' AND a.number = '" + number + "'";
        ResultSet rSet;
        Statement statement;
        try {
            statement = conn.createStatement();
            rSet = statement.executeQuery(query);
            while(rSet.next()){
                System.out.println(rSet.getString(1)
                //+ " " + rSet.getString(1) 
                + " " + rSet.getString(2)
                + " " + rSet.getString(3)
                + " " + rSet.getString(4)
                + " " + rSet.getString(5)
                + " " + rSet.getString(6)
                + " " + rSet.getString(7)
                + " " + rSet.getString(8)
                + " " + rSet.getString(9)
                + " " + rSet.getString(10)
                + " " + rSet.getString(11)
                + " " + rSet.getString(12)
                );
               // User.setId_user(rSet.getString(2));
                address2.setId_user(Integer.parseInt(rSet.getString(1)));
                address2.setStreet(rSet.getString(2));
                address2.setNumber(Integer.parseInt(rSet.getString(3)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Error en la query");
            address2.setId_user(2);
            //address2.setStreet("3");    
        }       
        return address2;
     }
     

}
