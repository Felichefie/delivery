import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import javax.lang.model.util.ElementScanner6;



public class Dbconnection{

    static Connection conn= null;
    public static void main (String [] args) {
    
    //ResultSet rset;

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String pass ="alumnoPrueba1";
    String mail = "1578947d@umich.mx";
    String numero = "4432286692";
    int idUser = 1;
    String calle = "Nicolas Leon";
    int number = 109;

    System.out.println("Conectando a la base...");
    
    String query = "SELECT * FROM progra2.users";
    Dbconnection dbConn = new Dbconnection(URL, user, pass);
    UserExample u = dbConn.getUser(mail, numero);
    Direccion a = dbConn.getAddress(u.getId(), query, number);

    if (u.getId()== 0){
        System.out.println("No existe");
        dbConn.insertnewUser (u);
    }else{
            System.out.println(u.getId());
            System.out.println(u.getUsername());
        }

    if(a.getId() == 0){
            System.out.println("Este usurio no tiene direccion: ");
            dbConn.insertNewDireccion(u);
        }else{
            System.out.println(a.getId());
            System.out.println(a.getcalle());
            System.out.println(a.getnumero());
        }
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    boolean insertnewUser (UserExample user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                        + "VALUES('"+ user.getUsername() +"','Pantaleon','Bedolla',"+ user.getName() +",'2023-10-20','PPB@gmail.com'"+ user.getEmail() + "')'";
                        PreparedStatement preState;

                        try {
                            PreparedStatement preStatement = conn.prepareStatement(queryInsert);
                            preState.execute();
                            System.out.println("Se ha creado un nuevo usuario");
                            return true;
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("No se ha podido crear un nuevo usuario");
                                return false;
                                }
}
    
    /*try{
        conn = DriverManager.getConnection(URL, user, pass);
        Statement statement =conn.createStatement();
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
        
        conn.close();
        }
        
        catch (SQLException e) {
        e.printStackTrace();
        }
}*/

Dbconnection(String URL, String user, String pass){
    try{
        conn = DriverManager.gerConnection(URL, user pass);
    } 
    catch (SQLException e) {
        e.printStackTrace();
    }

}

UserExample getUser(String mail, String phone){
    UserExample user = new UserExample();
    String query = " SELECT * FROM progra2.users u WHERE u.email = '" + email + "' OR u.phone_number ='" + numero + "'";
    Statement statement;
    ResultSet rset;
    
    
    try{ 
        statement = conn.createStatement();
        rset = statement.executeQuery(query);
    
    while (rset.next ()){
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
        user.setUsername(rset.getString(2));
        user.setFirts_lastname(rset.getString(3));
        user.setSecond_lastname(rset.getString(4));
        user.setName(rset.getString(5));
        user.setName(rset.getString(6));
        user.setEmail(rset.getString(7));
        user.setGender(rset.getString(8));
        user.setPhone_number(rset.getString(9));
        
    }
}
    catch(SQLException e){
        System.out.print("Error en query");
        user.setId(1);
    }
    return user;
}

Direccion getAddress (int idUser, String calle, int numero){

    Direccion direc = new direc ();
    String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser + "AND a.street = ' Nicolas Leon ' AND a.number = 109";
    System.out.println(query);
    ResultSet rset;
    Statement statement;

    try{ 
        statement = conn.createStatement();
        rset = statement.executeQuery(query);

        while (rset.next ()){
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

        address.setId(Integer.parseInt(rset.getString(1)));
        address.setIdUser(Integer.getString(2));
        address.setStreet(rset.getString(3));
        address.setNumber(Integer.getString(4));
        address.setNumber_two(rset.getString(5));
        address.setNeighborhood(rset.getString(6));
        address.setCity(rset.getString(7));
        address.setState(rset.getString(8));
        address.setCountry(rset.getString(9));
        address.setPostal_code(rset.getString(10));
        address.setGps_lat(rset.getString(11));
        address.setGPs_lon(rset.getString(12));
    }
}
catch (Exception e){
    System.out.println("Error en query");
    address.setId(1);
}
}