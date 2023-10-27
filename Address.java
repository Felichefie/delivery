public class Address {
    private int id;
    private int id_user;
    private String street;
    private int number;
    private int number_two;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private int postal_code;
    private String GPS;
    //public int getId_user;
    private float gps_lat;
    private float gps_lon;


    public float getGps_lat() {
        return gps_lat;
    }
    public void setGps_lat(float gps_lat) {
        this.gps_lat = gps_lat;
    }
    public float getGps_lon() {
        return gps_lon;
    }
    public void setGps_lon(float gps_lon) {
        this.gps_lon = gps_lon;
    }
    public Address(){
        
    }
////////////////////////////////////////  CONSTRUCTOR   ////////////////////////////////////////////////////////
    public Address(int id, int id_user, String street,int number, int number_two,
    String neighborhood, String city, String state, String country, int postal_code, String GPS){
        this.id = id;
        this.id_user = id_user;
        this.street = street;
        this.number = number;
        this.number_two = number_two;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
        this.GPS = GPS;
    } 

//////////////////////////////////////  METODOS  GETTERS   ///////////////////////////////// 

    public int getId() {
        return id;
    }
    public int getId_user() {
        return id_user;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getNumber_two() {
        return number_two;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public String getGPS() {
        return GPS;
    }



//////////////////////////////////////  METODOS SETTERS   ///////////////////////////////////
    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber_two(int number_two) {
        this.number_two = number_two;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public void setGPS(String gPS) {
        GPS = gPS;
    }
    





}
