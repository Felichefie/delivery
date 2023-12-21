public class Address{
    private String street;
    private int number;
    private String number_two;
    private String neighborhood;
    private String postal_code;

    Address(){

        street = "";
        number = 0;
        number_two = "";
        neighborhood = "";
        postal_code = "";

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
    
}