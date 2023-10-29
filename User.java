public class User {
    private int id;
    private String userName;
    private String first_lastname;
    private String second_lastname;
    private String name;
    private String birthday;
    private String email;
    private String gender;
    private String phone_number;
    private int userId;
    private String title;
    private String body;




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

    public String getName() {
        return name;
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

    public void setEmail(int i) {
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

    public User(){
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    public User(int userId, int id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    
//METODOS GET

    public String getUserName(){
        return this.userName;
    }
    public String getname(){
        return this.name;
    }
    public int getUserId(){
        return this.userId;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }


    //METODOS SET
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }
    public void setId(int id){
        this.id= id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }

    public static void setId_user(String string) {
    }

    public static void setStreet(String string) {
    }

    public void show() {
    }

    public void setDbConn(Dbconnection dbConn) {
    }

}
