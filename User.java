public class User {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String userName;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getName(){
        return name;
    }

    public String getUserName(){
        return userName;
    }

    public User (){
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    //nuevo constructor.
    public User(int userId, int id, String title, String body){
        this.userId = userId;
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

