public class Userexample {
    
    private int userId;
    private int id;
    private String title;
    private String body;
    private String name;
    private String userName;
    private String email;
    private int phoneNumber;

    public Userexample(){
        userId = 0;
        id = 0;
        title = "";
        body = "";
    }

    public Userexample(int userId, int id, String title, String body){
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
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

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getFirst_lastname() {
        return null;
    }

    public String getSecond_lastname() {
        return null;
    }

    public String getBirthday() {
        return null;
    }

    public String getPhone_number() {
        return null;
    }
}
