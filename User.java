public class User {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String userName;
    private String name;

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

public int getUserId(){

}

}
