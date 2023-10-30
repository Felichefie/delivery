public class User {
    private int userId;
    private int id;
    private int phone_number;
    private int birthday;
    private String userName;
    private String first_lastname;
    private String second_lastname;
    private String email;
    private String title;
    private String body;
    private String name;

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
    
    public void setPhone_number(int phone_number) {
    this.phone_number = phone_number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthday() {
        return birthday;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
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

}
