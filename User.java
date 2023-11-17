public class User {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String userName;
    private String name;
    private String password;

    public User(String string, String string2, String string3, String string4, String string5, String string6) {
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    public User(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    // METODOS GET
    public int getUserId() {
        return this.userId;
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

    // METODOS SET

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return null;
    }

    public void setemail(String text) {
    }

    public void setFirst_lastname(String string) {
    }

    public void setBirthday(String string) {
    }

}