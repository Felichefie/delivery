public class Address{
    private int id;
    private int idUser;
    private String street;
    private int number;
    private String number_two;
    private String neighborhood;
    private String postal_code;
    private String gps_lat;
    private String gps_lon;

    Address(){

        id = 0;
        idUser = 0;
        street = "";
        number = 0;
        number_two = "";
        neighborhood = "";
        postal_code = "";
        gps_lat = "";
        gps_lon = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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