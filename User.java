public class User {
    private int userId;
    private int id;
    private String title;
    private String body;

    public User(){
        this.userId = 0;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    public User(int userId, int id, String title, String body){
        this.userId = 1;
        this.id = 0;
        this.title = "";
        this.body = "";
    }

    public int getUserId(){
        return this.userId;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getBody(){
        return this.body;
    }
    public void setUserId(int userId){
        this.userId=userId;
    }
    public void setId(int Id){
        this.id=Id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setBody(String body ){
        this.body=body;
    }

}
