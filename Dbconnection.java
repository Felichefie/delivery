import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.lang.model.util.ElementScanner6;



public class Dbconnection{
    static Connection conn;
public static void main (String [] args) {
    ResultSet rset;

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String pass ="alumnoPrueba1";

    
    Dbconnection dbConn = new Dbconnection(URL, user, pass);
    User u = dbConn.getUser("perlaPP@umich.mx");
    if (u.getId()== 0){
        System.out.println("No existe");
        dbConn.insertnewUser (u);
    }
        else {
            System.out.println(u.getId());
            System.out.println(u.getUsername());
        }
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

boolean insertnewUser (User user){
    String queryInsert = "INSERT INTO progra2.users (user_name, first_lastname, second_lastname, birthday, email)"
                        + "VALUES("+ user.getUsername() +",'Pantaleon','Bedolla',"+ user.getName() +",'2023-10-20','PPB@gmail.com')";
                        try {
                            PreparedStatement preState = conn.prepareStatement(queryInsert);
                            preState.execute();
                            return true;}
                            catch (SQLException e) {
                                e.printStackTrace();
                                return false;
                                }
}
    
    try{
        conn = DriverManager.getConnection(URL, user, pass);
        /*Statement statement =conn.createStatement();
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
        }
        PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
        
        conn.close();*/
        }
        
        catch (SQLException e) {
        e.printStackTrace();
        }
}
Dbconnection(String URL, String user, String pass){

}

Direccion direccion(int idUser){


}
User getUser(String email){
    User user=

    String query = "SELECT * FROM progra2.users WHERE progra2.users.email=" + email;
    Statement statement = conn.createStatement();
    ResultSet rset;
    rset = statement.executeQuery(query);
    


    while (rset.next ()){
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
        user.setUsername(rset.getString(2));
    }
    catch(SQLException e){

    }
    return user;


}
}