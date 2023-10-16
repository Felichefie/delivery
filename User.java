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
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
    }

}
