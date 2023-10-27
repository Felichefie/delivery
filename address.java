
public class address {
    private int Id;
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

    private void setId(int id){ 
        this.Id = id;
    }

    private void setid_user(int id_user){
        this.id_user = id_user;
    }
    
     private void setstreet(String street){ 
        this.street = street;
    }

    private void setnumber(int number){
        this.number = number;
    }
     private void setnumber_two(int number_two){ 
        this.number_two = number_two;
    }

    private void setneighborhood(String neighborhood){
        this.neighborhood = neighborhood;
    }
     private void setcity(String city){ 
        this.city = city;
    }

    private void setstate(String state){
        this.state = state;
    }
     private void setcountry(String country){ 
        this.country = country;
    }

    private void setpostal_code(int postal_code){
        this.postal_code = postal_code;
    }
     private void setGPS(String GPS){ 
        this.GPS = GPS;
    }

    public int getid(){
        return this.Id;
    }

    public int getid_user(){
        return this.id_user;
    }

    public String getsreet(){
        return this.street;
    }
    public int getnumber(){
        return this.number;
    }

    public int getnumber_two(){
        return this.number_two;
    }

    public String getneighborhood(){
        return this.neighborhood;
    }
    public String getcity(){
        return this.city;
    }

    public String getstate(){
        return this.state;
    }

    public String getcountry(){
        return this.country;
    }
    public int getpostal_code(){
        return this.postal_code;
    }

    public String getGPS(){
        return this.GPS;
    }

}

    
