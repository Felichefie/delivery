import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Dbconnection{
static Connection conn;
    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String email = "felix.jimenez@umich.mx";
        String num = "4431234567";


        Dbconnection dbConn = new Dbconnection(URL, user, pass);
        User u = dbConn.getUser("felix.jimenez@umich.mx");
        
        if(u.getId()==0){ 
            System.out.println("No existe");
            dbConn.insertnewUser(u);
        }
        else{ 
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }

        if(dbConn.adressExists(u.getId(), "Privada Jacarandas", 109)){
            System.out.println("La direccion ya existeen la base de datos");
        }
        else{
            System.out.println("La nueva direccion se puede subir");
        }

        try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }

    boolean insertnewUser(User user){

    String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                        + "VALUES('"+ user.getUserName() 
                        + "', 'Chabelo', 'Monster','" 
                        + user.getName() 
                        + "', '2023-10-20', 'pepitoalcachofa@chabelo.com')";
        try{
            PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
        return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }

    Dbconnection(String URL, String user, String pass){

        try {
            conn = DriverManager.getConnection(URL, user, pass);
         
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* Direccion direccion(int idUser){

    } */

    User getUser(String email){
        User user = new User();
        String query = "SELECT * FROM progra2.users u WHERE u.email ='" + email + "'";
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
            System.out.println("Error en la querry");
            user.setId(1);
        }
            return user;
    }

    boolean adressExists(int idUser, String street, int number){
        String query = "SELECT * FROM progra2.adress a WHERE a.id_user = ? AND a.street = ? AND a.number = ?";
        try{
            PreparedStatement preState = conn.prepareStatement(query);
            preState.setInt(1, idUser);
            preState.setString(2, street);
            preState.setInt(3, number);
            ResultSet resSet = preState.executeQuery();
            return resSet.next();
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            } 
    }

    Response LogAuth(String email, String password){
        //res inicial statys = false, user " -1, sesion = """
        Response res = new Response();
        //Solo regresa password 
        String query = "SELECT u.password FROM progra2.users u WHERE u.email ='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDb = "";
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);

            while(rset.next()){
                password = rset.getString(1);
                System.out.println(password);

               
            }
            if(password == passwordDb){
                res.setStatus(true);
            }
            return res;
        }catch(SQLException e){
            System.out.println("Error en la querry");
            return res;
        }
    }
        

    }
