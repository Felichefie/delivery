public class UserExample {
    private int  userId;
    private int id;
    private String title;
    private String body;

  public UserExample(int userId, int id, String title, String body){
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  //METODOS GETTERS
  public int getUserId(){
    return userId;
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

  //METODOS SETTERS
  public void setUserId(int userId){
    this.userId = userId;
  }
  public void setId(int id){
    this.id = id;
  }
  public void setTitle(String title){
    this.title = title;
  }
  public void setBody(String body){
    this.body = body;
  }

}
