
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;

public class Dbconnection {

    static Connection conn =null;
    public static void main(String[] args) {
        //Connection conn;
       // ResultSet rset;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String password = "alumnoPrueba1";
        String email = "felix.jimenez@umich.mx";
        String  phone = "4431234567";
        int idUser = 1;
        String street = "Privada Jacarandas";
        int number = 109;

       System.out.println("CONECTANDO A LA BASE DE DATOS...");

        String query = "SELECT * FROM progra2.users";
        Dbconnection dbConn = new Dbconnection(URL, user, password);
        UserExample u = dbConn.getUser(email, phone);
        Address a = dbConn.getAddress(u.getId(), query, number);

        //User u = dbConn.getUser("felix.jimenez@umich.mx");
        if(u.getId() == 0){
            System.out.print("NO EXISTE");
            dbConn.InsertnewUser(u);
        }else{
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        
        }

        if(a.getId() ==0 ){
            System.out.println("EL USUARIO NO TIENE DIRECCIONES :() ");
            dbConn.InsertnewUser(u);
        }else{
            System.out.println(a.getId());
            System.out.println(a.getStreet());
            System.out.println(a.getNumber());
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
//INSERTA UN NUEVO USUARIO
    boolean InsertnewUser(UserExample user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                + "VALUES('" + user.getUserName() + "', 'Chabelo', 'Monster', '" + user.getName() + "', '2023-10-22', '" + user.getEmail() + "' )";
            PreparedStatement preState;

        try {
            PreparedStatement preStatement = conn.prepareStatement(queryInsert);
            preStatement.execute();
            System.out.println("SE HA INSERTADO UN NUEVO USUARIO!!!!!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NO SE HA PODIDO INSERTAR EL NUEVO USUARIO :() ");
            return false;
        }
    }




    Dbconnection(String URL, String user,String password){       
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
                e.printStackTrace();
        }        

    }


    public static Connection getConn(){
        return conn;
    }


    //OBTIONE UN NUEVO USUARIO
    UserExample getUser(String email, String phone ){
        UserExample user = new UserExample();

        String query = "SELECT *  FROM progra2.users u WHERE u.email = '" + email + "' OR u.phone_number ='" + phone + "'";
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
                user.setFirst_lastname(rset.getString(3));
                user.setSecond_lastname(rset.getString(4));
                user.setName(rset.getString(6));
                user.setEmail(rset.getString(7));
                user.setPhone_number(rset.getString(9));
                user.setGender(rset.getString(8));
            }
        }catch(SQLException e){    
            System.out.print("Error en la query");
            user.setId(1);
        }
        return user;
    }


    //ONBITIENE NUEVA DIRECCION
    Address getAddress(int idUser, String street, int number){
        Address address = new Address();
        String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser + " AND a.street = 'Privada Jacarandas' AND a.number = 109";
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

        } catch (Exception e){
            System.out.println("Error en la query");
            address.setId(1);
        }

        return address;
    }

    //REGRESA EL PASSWORD DEL USUARIO
    Response LogAuth(String email, String password, Connection conn){
        //res inicial status = false; user = -1; sesion = " ";
        Response res = new Response();

        String query = "SELECT u.password FROM progra2.users u WHERE u.email = '" + email + "'";
        ResultSet rset;
        Statement statement;
        String passwordDb = " ";

        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            
            
            while(rset.next()){
                passwordDb = rset.getString(1);
                    System.out.println(passwordDb);
                
            }
            if(passwordDb == password){
                res.setStatus(true);

            }

        }catch(SQLException e){    
            System.out.print("Error en la query");
            return res;
            
        }
        return res;

    }
    
   
}