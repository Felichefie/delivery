public class Address{
    private int id;
    private int id_user;
    private String street;
    private int number;
    private String number_two;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String postal_code;
    private String gps_lat;
    private String gps_lon;

    Address(){
        id = 0;
        id_user = 0;
        street = "";
        number = 0;
        number_two = "";
        neighborhood = "";
        city = "";
        state = "";
        country = "";
        postal_code = "";
        gps_lat = "";
        gps_lon = "";
    }

    Address(int id, int idUser, String street, int number, String number_two, String neighborhood, String city, String state, String country, String postal_code, String gps_lat, String gps_lon){
        
        this.id = id;
        this.id_user = idUser;
        this.street = street;
        this.number = number;
        this.number_two = number_two;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
        this.gps_lat = gps_lat;
        this.gps_lon = gps_lon;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int idUser) {
        this.id_user = idUser;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNumber_two() {
        return number_two;
    }

    public void setNumber_two(String number_two) {
        this.number_two = number_two;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public String getGps_lat() {
        return gps_lat;
    }

    public void setGps_lat(String gps_lat) {
        this.gps_lat = gps_lat;
    }

    public String getGps_lon() {
        return gps_lon;
    }

    public void setGps_lon(String gps_lon) {
        this.gps_lon = gps_lon;
    }
    
}