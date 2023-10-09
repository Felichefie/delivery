public class UserExample {
    private int  userId;
    private int id;
    private String title;
    private String body;

    

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
