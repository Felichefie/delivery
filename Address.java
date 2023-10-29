public class Address {
    private int id;
    private int id_user;
    private String street;
    private Integer number;
    private String number_two;
    private String nieghborhood;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private Float gps_lat;
    private Float gps_lon;
    
    public Address(){
    }

    public Address(int id, int id_user, String street, Integer number, String number_two, String nieghborhood,
            String city, String state, String country, String postal_code, Float gps_lat, Float gps_lon) {
        this.id = id;
        this.id_user = id_user;
        this.street = street;
        this.number = number;
        this.number_two = number_two;
        this.nieghborhood = nieghborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
        this.gps_lat = gps_lat;
        this.gps_lon = gps_lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNumber_two() {
        return number_two;
    }

    public void setNumber_two(String number_two) {
        this.number_two = number_two;
    }

    public String getNieghborhood() {
        return nieghborhood;
    }

    public void setNieghborhood(String nieghborhood) {
        this.nieghborhood = nieghborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public Float getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(Float gps_lat) {
        this.gps_lat = gps_lat;
    }

    public Float getGps_lon() {
        return gps_lon;
    }

    public void setGps_lon(Float gps_lon) {
        this.gps_lon = gps_lon;
    }

    
    

}