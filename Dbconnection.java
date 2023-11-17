import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;
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
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email, password)"
                            + " VALUES('" + user.getUserName()
                            + "', '" + user.getFirst_lastname() + "', '" + user.getSecond_lastname() + "','" 
                            + user.getName() 
                            + "', '2023-10-20','"+ user.getEmail() + "'" + ",'" + user.getPassword() + "')";

                            System.out.println(queryInsert);
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

    Response logAuth(String email, String passwordLogin, Connection conn) {
        // res inicial status= false, user= -1 session = ""
        Response res = new Response();

        // solo regresa el password del usuario
        String query = "SELECT u.password, u.id FROM progra2.users u WHERE u.email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDB = "";
        String id_u = "";
        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                passwordDB = rset.getString(1);
                id_u = rset.getString(2);
                System.out.println(passwordDB);
            };
            //System.out.println("db " + passwordDB);
           // System.out.println("log" + passwordLogin);

           //el == no funciono para comparar las siguientes cadenas
            /*if(passwordDB.equals(passwordLogin)) {
              //  System.out.println("son iguales");
                res.setStatus(true);
                res.setSession("test_session");
            }else{
                System.out.println("el password no coincide");

            }*/

           
            System.out.println(passwordDB);
            System.out.println(passwordLogin);


      if(BCrypt.checkpw(passwordLogin, passwordDB)==true){
        System.out.println("Coincide ");
      String sessiontime = String.valueOf(System.currentTimeMillis()).substring(8,13);
      String sessionuuid = UUID.randomUUID().toString().substring(1,10);
      String session = sessiontime + sessionuuid;
      System.out.println(session);
      LocalDateTime nowdate = LocalDateTime.now();
      System.out.println(nowdate);
      LocalDateTime endtimesession = nowdate.plusMinutes(30);
      System.out.println(endtimesession);

      //aqui metemos la sesion a la tabla de labase de datos
      //INSERT INTO sessions (id_user, session, timeout, created)
      //VALUES('id_u','session','endtimesession','nowdate')
      String queryInsert = "INSERT INTO progra2.sessions(id, id_user, session, timeout, created)"
                            + " VALUES(4,'" + id_u
                            + "','" + session
                            + "', '" + endtimesession
                            + "','" + nowdate
                            + "')";

                            System.out.println(queryInsert);
        try{
            PreparedStatement preState = conn.prepareStatement(queryInsert);
          preState.execute();
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la query Insert");
           
        }


      }else{
        System.out.println("No coincide ");
      }
        }catch(SQLException e){
            System.out.println("Error en la query Select");
        }
        return res;
    }
}
       /*  String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
     
        String correo = "1911690k@umich.mx";
        String numero = "4434842118";
        Dbconnection dbConn = new Dbconnection(URL,user,pass);
     

        User u = dbConn.getUser(correo);//busca por medio del email(si esta o no), 
        //declara una variable u de la clase User
        if(u.getId()==0){ 
            System.out.println("No existe");//comprobar si existe el usario por medio del email o telefono
            dbConn.insertNewUser(u);// en caso de no encontrarlo,mete un nuevo usuario
        }
        else {
            System.out.println(u.getUsername());
            int uid = u.getId();

             System.out.println(u.getId());// en caso de que exista imprime el username-id
            //ahora debemos buscar si tengo direccion o no
            String query = "SELECT * FROM progra2.address a WHERE a.id_user = " + 1 + " AND a.street =" + "'Privada Jacarandas '" + " AND a.number = 109";
            System.out.println(query);
            ResultSet rset;//conjunto de resultados/ para recibir la respuesta de la base de datos
            Statement statement;

              try{
             
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            boolean existe_direccion = false;    
            while(rset.next()){
                existe_direccion = true;
                System.out.println(rset.getString(1)//se muestra como la llave
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)//la tabla tiene 13 campos
                + " " + rset.getString(7)
                + " " + rset.getString(8)
                + " " + rset.getString(9)
                + " " + rset.getString(10)
                + " " + rset.getString(11)
                + " " + rset.getString(12)
                + " " + rset.getString(13)

                );
                
            }
            if(existe_direccion){
                System.out.println("existe una direccion");
            }else{
                System.out.println("no existe una direccion");
                String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, city, state, country, postal_code)"
                            + "VALUES('" + uid  
                            + "','toma de granaditas', '124', '', 'independencia', 'morelia',"
                            + "'michoacan',"
                            + "'mexico', '58210')";
                          //  System.out.println(queryInsert);
        try{
            PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
        //return true;
        }catch(SQLException e){
            e.printStackTrace();
          //  return false;// si sale bien, se ejecuta y regresa el true, en caso contrario regresa falso
        }
       
            }

          
    }catch(SQLException e){
        System.out.println("Error en la query");
      

    }
        }
       try {
        conn.close();
    } catch (SQLException e) {
       
        e.printStackTrace();
    }
    }
    

    boolean insertNewUser(User user){
       /*  String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                            + "VALUES('" + user.getUsername() 
                            + "','chabelo', 'monster','"
                            + user.getName() 
                            + "', '2023-10-20', 'pepitoalcachofa@chabelo.com')";
          String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                            + "VALUES('" + "Anibal1"
                            + "','Zavala', 'Herrera','"
                            + "Anibal"
                            + "', '2004-06-17', '1911690k@umich.mx')";
        try{
            PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;// si sale bien, se ejecuta y regresa el true, en caso contrario regresa falso
        }
       
    }
*/

//a partir de aqui es la conexion que hice en la tarea con sam
  
/*public Dbconnection(){//cotructor de la conexion a la bse de datos
    //  Dbconnection(String URL, String user, String pass){//cotructor de la conexion a la bse de datos
    URL ="jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    user ="alumno";
    pass = "alumnoPrueba1";
       try {
            conn = DriverManager.getConnection(URL, user, pass);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnection(){
        try {
        conn.close();
    } catch (SQLException e) {
       
        e.printStackTrace();
    }
    }
    
   // Direccion direccion(int idUSer){}

    public ResultSet select(String q){
       
        System.out.println(q);
        ResultSet rset;//conjunto de resultados/ para recibir la respuesta de la base de datos
        Statement statement;

        try{
             
            statement = conn.createStatement();
            rset = statement.executeQuery(q);
            return rset;
        }
        catch (SQLException e) {
       
            e.printStackTrace();
            return null;
         }

    }
    public void insertselect(String q){

     try{
            PreparedStatement preState = conn.prepareStatement(q);
            preState.execute();
            //return true;
        }catch(SQLException e){
            e.printStackTrace();
          //  return false;// si sale bien, se ejecuta y regresa el true, en caso contrario regresa falso
        }
    }

}*/


