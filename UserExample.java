public class UserExample {
    private int userId;
    private int id;
    private String title;
    private String body;
    public int getUserId() {
        return userId;
    }
    
    public UserExample() {
        super();
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    public UserExample(int userId, int id, String title, String body) {
        super();
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
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
