import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
    static Connection conn;
    public static void main(String[] args) {
        
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        
        Dbconnection dbConn = new Dbconnection(URL,user,pass);
        User u = dbConn.getUser("felix.jimenez@umich.mx");
        if(u.getId()==0){ 
            System.out.println("No existe");
            dbConn.insertNewUser(u);
        }
        else {
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }

        try{
            conn.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    boolean insertNewUser(User user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                            + "VALUES('" + user.getUserName()
                            + "', 'Chabelo', 'Monster','" 
                            + user.getName() 
                            + "', '2023-10-20','pepito@chabelo.com')";
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
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Direccion direccion(int idUser){

    }*/

    User getUser(String email){
        User user = new User();
        
        String query = "SELECT * FROM progra2.users u WHERE u.email='" + email + "'";
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
                );
                user.setId(Integer.parseInt(rset.getString(1)));
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));
            }
        }catch(SQLException e){
            System.out.println("Error en la query");
            user.setId(1);
        }
        return user;
    }
}
