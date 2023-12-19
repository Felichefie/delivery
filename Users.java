public class Users {

    private int id;
    private String email;
    private String password;
    private String phone;
    private Address address;
    private String pay;

    public Users() {
        this.id = 0;
        this.email = "";
        this.password = "";
        this.phone = "";
        this.address = new Address();
        this.pay = "";
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public Address getAddress() {
        return address;
    }



    public void setAddress(Address address) {
        this.address = address;
    }



    public String getPay() {
        return pay;
    }



    public void setPay(String pay) {
        this.pay = pay;
    }

}