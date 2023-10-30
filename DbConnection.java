import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
public class DbConnection {
    static Connection conn ;
    public static void main(String[] args) throws SQLException {

     String URL= "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user= "alumno";
        String pass = "alumnoPrueba1";
        
            DbConnection dbConn = new DbConnection(URL, user, pass);
           User u = dbConn.getUser("1701450h@umich.mx");
           if (u.getId()==0){
               System.out.println("No existe el usuario");
                dbConn.insertnewUser(u);
            }
              else{ 
                System.out.println(u.getId());
                System.out.println(u.getUserName());}
                try{
                    conn.close();
                }catch (SQLException e) {
                }
            }

            
            boolean insertnewUser(User user){
                String queryInsert= "INSERT INTO progra2.users (user_name,first_lastname,second_lastname,name,birthday,email)"
        + "VALUES ("+ user.getUserName() + "'Birria','Tatemada',"+ user.getName()+",'2023-10-20','taxistafogoz69@gmail.com')";
        try{
        PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
                return true;
            }catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
            DbConnection(String URL, String user, String pass){
       try {
            conn = DriverManager.getConnection(URL, user, pass);
        
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    User getUser(String email) throws SQLException{
        User user = new User();
        
        String query = "SELECT * FROM progra2.users u WHERE u.email='" + email+"'";
        ResultSet rset ;
       Statement statement = conn.createStatement();
        try {
        rset = statement.executeQuery(query);

            while (rset.next()) {
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
         
        }catch (SQLException e) {
            System.out.println("Error en la query");
            user.setId(1);
        }
        return user;
    }
}