import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Dbconnection {
    static Connection conn;
    public static void main(String[]args){
        

        String URL="jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user="alumno";
        String pass="alumnoPrueba1";

        
       Dbconnection dbConn = new Dbconnection(URL,user,pass);
       Userexample u = dbConn.getUser("felix.jimenez@umich.mx");
       if(u.getId()==0){
        System.out.println("No existe");
        dbConn.insertnewUSer(u);
       }
     else {
        System.out.println(u.getId());
        System.out.println(u.getUserName());
     }
     try{conn.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
    }

    boolean insertnewUSer(Userexample userexample){
        String queryInsert="INSERT INTO progra2.users(user_name,first_lastname,second_lastname,name,birthday, email)"
                                            + "VALUES("+ userexample.getUserName() +"+'Lopez','Piña',"+ userexample.getName()+",'2001-05-02','1917663k@umich.mx')";
        try{
            PreparedStatement preState= conn.prepareStatement(queryInsert);
        preState.execute(queryInsert);
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    Dbconnection(String URL,String user, String pass ){
        try {
            conn=DriverManager.getConnection(URL,user,pass);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Direccion direccion (int iduser){};


    Userexample getUser(String email){
        Userexample user=new Userexample();
        ResultSet rset;
        String query="SELECT * FROM progra2.users u WHERE u.email='" + email +"'";
        Statement statement;
        try{
        statement = conn.createStatement();

            rset=statement.executeQuery(query);
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
    }
} catch(SQLException e){
System.out.println("Error en la query");
user.setId(1);
}   return user;
}
}