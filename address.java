
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
    private String gps_lat;
    private String gps_lon;





    public address(String text1, int text2, int text3, String text4, String text5, String text6, String text7,
            int text8, String text9, String text10) {
                this.street = text1;
                this.number = text2;
                this.number_two = text3;
                this.neighborhood = text4;
                this.city = text5;
                this.state = text6;
                this.country= text7;
                this.postal_code = text8;
                this.gps_lat = text9;
                this.gps_lon = text10;

    }

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
     private void setgps_lat(String gps_lat){ 
        this.gps_lat = gps_lat;
    }
      private void setgps_lon(String gps_lon){ 
        this.gps_lon = gps_lon;
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

    public String getgps_lat(){
        return this.gps_lat;
    }
     public String getgps_lon(){
        return this.gps_lon;
    }

    public void imprimir(){
        System.out.println(this.street + " " + this.number + " " + this.number_two + " " + this.number + " " + this.neighborhood + " " + this.city + " " + this.state + " " + this.country + " " + this.postal_code + " " + this.gps_lat + " " + this.gps_lon + " " + this.number);//una funcion para imprimir toda la informacion del objeto
    }
}

    
