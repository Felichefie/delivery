public class User {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String userName;
    private String name;


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

    public String getUserName(){
        return this.userName;
    }
    public String getname(){
        return this.name;
    }
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
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setName(String name){
        this.name = name;
    }

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
