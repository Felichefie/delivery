public class Userexample {

    private int id;
    private String userName;
    private String first_lastname;
    private String second_lastname;
    private String name;
    private String birthday;
    private String email;
    private String gender;
    private String phone_number;

    public Userexample(int id, String userName, String first_lastname, String second_lastname, String name, String birthday, String email, String gender, String phone_number) {
        this.id = id;
        this.userName = userName;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.phone_number = phone_number;
    }

    public Userexample(int i, int j, String string, String string2) {
    }

    public int getUserId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setDbConn(Dbconnection dbConn) {
    }

    public void show() {
    }
}
