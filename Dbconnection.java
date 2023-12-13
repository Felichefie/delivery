import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
    static Connection conn;
    static String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    static String user = "alumno";
    static String pass = "alumnoPrueba1";
    public static void main(String[] args) {


        Dbconnection dbConn = new Dbconnection(URL,user,pass);
        User u = dbConn.getUser("felix.jimenez@umich.mx");
        if(u.getUserId()==0){ 
            System.out.println("No existe");
            dbConn.insertNewUser(u);
        }
        else {
            System.out.println(u.getUserId());
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

    User getUser(String email){
        User user = new User();
        
        String query = "SELECT * FROM progra2.users u WHERE u.email='" + email + "'" + " LIMIT 1";
        //System.out.println(query);
        ResultSet rset;
        Statement statement;
        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                user.setUserId(Integer.parseInt(rset.getString(1)));
                user.setTypeUser(rset.getString(2));
                user.setUserName(rset.getString(3));
                user.setFirstLastname(rset.getString(4));
                user.setSecondLastname(rset.getString(5));
                user.setName(rset.getString(6));
                user.setBirthday(rset.getString(7));
                user.setEmail(rset.getString(8));
                user.setGender(rset.getString(9));
                user.setPhoneNumber(rset.getString(10));
                user.setPassword(rset.getString(11));
                user.setCreated(rset.getString(12));
            }
        }catch(SQLException e){
            System.out.println("Error en la query");
            user.setUserId(1);
        }
        return user;
    }

    Response logAuth(String email, String passwordLogin, Connection conn) {
        // res inicial status= false, user= -1 session = ""
        Response res = new Response();
        
        // solo regresa el password del usuario
        String query = "SELECT u.password FROM progra2.users u WHERE u.email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDB = "";

        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                passwordDB = rset.getString(1);
            };
            System.out.println(passwordDB);
            System.out.println(passwordLogin);

            if(passwordDB.equals(passwordLogin)){
                res.setStatus(true);
                res.setSession("test_session");
            }
        }catch(SQLException e){
            System.out.println("Error en la query");
        }
        return res;
    }

    boolean deleteToken(int userId){
        // DELETE current session
        String queryDelete = "DELETE FROM progra2.sessions s WHERE s.id_user = ? LIMIT 1;";
        //System.out.println(queryDelete);
        try{
            PreparedStatement preState = conn.prepareStatement(queryDelete);
            preState.setInt(1, userId);
            preState.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    boolean updateToken(int userId, String token, String expiration){
        // INSERT current session
        String queryInsert = "INSERT INTO progra2.sessions(id_user, session, timeout) "
                            + "VALUES(" + userId + ",'" + token + "','" + expiration + "');";
        // System.out.println(queryInsert);
        try{
            PreparedStatement preState = conn.prepareStatement(queryInsert);
            preState.execute();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    Token getToken(int idUser){
        Token t = new Token();
        String query = "SELECT s.session, s.timeout FROM progra2.sessions s WHERE s.id_user=" + idUser + " LIMIT 1;";
        //System.out.println(query);
        ResultSet rset;
        Statement statement;
        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            while(rset.next()){
                System.out.println(rset.getString(1)
                + " " + rset.getString(2));
                t.setToken(rset.getString(1));
                t.setExpiration(rset.getString(2));
            }
        }catch(SQLException e){
            System.out.println("Error en la query" + query);
        }
        return t;
    }
}
