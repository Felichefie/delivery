
public class User {
    private int userId;
    private int id;
     private String name;
    

    private String user_name;
    private String first_name;
    private String second_name;
    private String birtday;
    private String email;
    private String gender;
    private String phone_number;

    public User(String name, String user_name, String first_name, String second_name, String birtday, String email,
            String gender, String phone_number) {
        this.name = name;
        this.user_name = user_name;
        this.first_name = first_name;
        this.second_name = second_name;
        this.birtday = birtday;
        this.email = email;
        this.gender = gender;
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
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
    public void imprimiruse(){
        System.out.println(this.user_name + " " + this.first_name + " " + this.second_name + " " + this.name + " " + this.birtday + " " + this.email + " " + this.gender+ " " + this.phone_number );
    }

    private String title;
    private String body;
    private String userName;
    private address direccion;

    

   
    
    
    public void setUsername(String userName) {
        this.userName = userName;
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
    

