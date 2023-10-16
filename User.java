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

    
//METODOS GET
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

}
