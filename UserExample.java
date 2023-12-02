public class UserExample {
    private int  userId;
    private int id;
    private String title;
    private String body;
    private String name;
    private String userName;
    private String email;
    public String getCorreo() {
      return correo;
    }

    public void setCorreo(String correo) {
      this.correo = correo;
    }

    public int getPhone() {
      return phone;
    }

    public void setPhone(int phone) {
      this.phone = phone;
    }
    private int phoneNumber;
    private String first_lastname;
    private String second_lastname;
    private String birthday;
    private String gender;
    private String phone_number;
    private String correo;
    private int phone;

    public UserExample(){
      userId = 0; 
      id = 0;
      title = "";
      body = "";
      name = " ";
      userName = " ";
      email =" ";
      phoneNumber = 0;
      first_lastname = " ";
      second_lastname = " ";
      birthday = " ";
      gender = " ";
      phone_number = " ";
      correo = " ";
      phone = 0;

    }

  public UserExample(int userId, int id, String title, String body){
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }



    public String getFirst_lastname() {
      return first_lastname;
    }

    public void setFirst_lastname(String first_lastname) {
      this.first_lastname = first_lastname;
    }

    public String getSecond_lastname() {
      return second_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
      this.second_lastname = second_lastname;
    }

    public String getBirthday() {
      return birthday;
    }

    public void setBirthday(String birthday) {
      this.birthday = birthday;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public String getPhone_number() {
      return phone_number;
    }

    public void setPhone_number(String phone_number) {
      this.phone_number = phone_number;
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

  public String getName() {
      return name;
    }
  
  public String getUserName() {
      return userName;
    }

  public String getEmail() {
      return email;
    }
  public int getPhoneNumber() {
      return phoneNumber;
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
  public void setName(String name) {
    this.name = name;
  }
  public void setUserName(String userName) {
  this.userName = userName;
  }
  public void setEmail(String email) {
  this.email = email;
  }
  public void setPhoneNumber(int phoneNumber) {
  this.phoneNumber = phoneNumber;
  }

}