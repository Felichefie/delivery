public class UserExample {
    private int userId;
    private int id;
    private String title;
    private String body;
    
    public UserExample(){
            this.userId = 0;
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
        this.userId = userId;
    }
     public void setId(int Id){
        this.id = Id;
    }
     public void setTitle(String title){
        this.title = title;
    }
     public void setBody(String Body){
        this.body = Body;



    }
}
