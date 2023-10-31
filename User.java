
public class User {
    private int userId;
    private int id;
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

} 
    

 User user = new User();

      String query = "SELECT * FROM progra2.users u WHERE u.email='" + email + "'";
      //user_name, first_lastname, second_lastname, name, birthday, email
      System.out.println(query);
              ResultSet rset;//conjunto de resultados/ para recibir la respuesta de la base de datos
            Statement statement;

              try{
             
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while(rset.next()){
                System.out.println(rset.getString(1)//se muestra como la llave
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)//la tabla tiene 7 campos
                + " " + rset.getString(7)
                );
                user.setId(Integer.parseInt(rset.getString(1)));
                user.setName(rset.getString(5));
                user.setUsername(rset.getString(2));
            }
          
    }catch(SQLException e){
        System.out.println("Error en la query");
        user.setId(1);

    }
    
    return user;
}