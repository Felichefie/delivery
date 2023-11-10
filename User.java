import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;//3
    private int id;//poner todos los valores de las columnas de la database 1
   // private String title;
   // private String body;

    private String userName;//3
    private String name;//4

    private String first_lastname;//5
    private String second_lastname;//6
    private String birthday;//7
    private String email;//8
    private String gender;//9
    private String phone_number;//10
    private String created;//numero once de la tabla
    private String type_user;//2
    private address direccion;
    private String password;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
  
 

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
       // this.title = "";
        //this.body = "";
        this.direccion = null;
    }

    /*public User(int userId, int id, String title, String body){
        this.userId= userId;
        this.id = id;
       // this.title = title;
        //this.body = body;
    }*/

    //public User(int i, int j, String string, String string2) {
   // }

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
}

   /*  public String getTitle() {
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
*/
    /*public String cargar(String text, Dbconnection conn) {
     String query = "SELECT * FROM progra2.users u WHERE u.email='" + text + "' OR u.phone_number = '" + text + "'";
     ResultSet rset =  conn.select(query); 
     System.out.println(query);

    String stal = new String();


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

            stal=stal + '\n' + s;
            System.out.println(s);

               

            this.setId(Integer.parseInt(rset.getString(1)));
            this.setType_user(rset.getString(2));
            this.setUsername(rset.getString(3));
            this.setFirst_lastname(rset.getString(4));
            this.setSecond_lastname(rset.getString(5));
            this.setName(rset.getString(6));
            this.setBirthday(rset.getString(7));
            this.setEmail(rset.getString(8));
            this.setGender(rset.getString(9));
            this.setPhone_number(rset.getString(10));
            this.setCreated(rset.getString(11));
           


            

        }

        System.out.println(stal);
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

     
        

        
        
        
        return stal;
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
}*/


    

 