package Trabajos;

import java.sql.Date;

public class User {
    private String type_user;
    private String userName;
    private String fist_name;
    private String second_name;
    private String name;
    private Date birthday;
    private String email;
    private String gender;
    private String phone_number;
    private String password;
    private Date created;
    private int id;
    private int userId;
    private String title;
    private String body;

    public User(String string, String string2, String string3, String string4, String string5, Date date6,
            String string7, String string8, String string9, String string10, Date date11) {
        this.type_user = "";
        this.userName = "";
        this.fist_name = "";
        this.second_name = "";
        this.name = "";
        this.birthday = null;
        this.email = "";
        this.gender = "";
        this.phone_number = "";
        this.password = "";
        this.created = null;

        this.id = 0;
        this.userId = 0;
        this.title = "";
        this.body = "";
    }

    public User(int userId, int id, String title, String body) {
        this.type_user = type_user;
        this.userName = userName;
        this.fist_name = fist_name;
        this.second_name = second_name;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.phone_number = phone_number;
        this.password = password;
        this.created = created;

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFist_name() {
        return fist_name;
    }

    public void setFist_name(String fist_name) {
        this.fist_name = fist_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
