import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private int id;//poner todos los valores de las columnas de la database
    private String title;
    private String body;
    private String userName;
    private String name;
    private address direccion;

    public void setName(String name) {
        this.name = name;
    }
    
    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return userName;
    }
    public void setdireccion(address direccion){
        this.direccion = direccion;
    }
    public address getdireccion(){
        return this.direccion;
    }




    public User (){
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
        this.direccion = null;
    }

    public User(int userId, int id, String title, String body){
        this.userId= userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void cargar(String text, Dbconnection conn) {
     String query = "SELECT * FROM progra2.users u WHERE u.email='" + text + "' OR u.phone_number = '" + text + "'";
     ResultSet rset =  conn.select(query); 
     System.out.println(query);
    


     try {
        while(rset.next()){
         String s = rset.getString(1)
            + " " + rset.getString(2)
            + " " + rset.getString(3)
            + " " + rset.getString(4)
            + " " + rset.getString(5)
            + " " + rset.getString(6)
            + " " + rset.getString(7)
            + " " + rset.getString(8)
            + " " + rset.getString(9)
            + " " + rset.getString(10)
            + " " + rset.getString(11);

            System.out.println(s);

               

            this.setId(Integer.parseInt(rset.getString(1)));
            this.setName(rset.getString(5));
            this.setUsername(rset.getString(2));
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

     
        

        
        
        
        
        //hago un objeto en user, que recibe el texto del gui, y ademas la concexion de DBconnecntion 
        //ademas creo un query que la uso para realizar la busqueda
    }
    public boolean buscar(String text, Dbconnection conn) {
     String query = "SELECT COUNT(id) FROM progra2.users u WHERE u.email='" + text + "' OR u.phone_number = '" + text + "'";
     ResultSet rset =  conn.select(query); 
     System.out.println(query);
     int n;

     try {
         rset.next();
        n = Integer.parseInt(rset.getString(1));
        System.out.println(n +" registros ");
        
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        n=0;
    }
     return n>0;
}
}


    

 