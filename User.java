public class User {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String username;
    private String name;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User (){
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }
        public User(int userId,int id,String title,String body){
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

