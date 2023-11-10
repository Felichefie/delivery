import java.sql.ResultSet;
import java.sql.SQLException;

public class address {
    private int Id;//1
    private int id_user;//2
    private String street;//3
    private int number;//4
    private String number_two;//5
    private String neighborhood;//6
    private String city;//7
    private String state;//8
    private String country;//9
    private String postal_code;//10
    private String gps_lat;//11
    private String gps_lon;//12
    private String created;//13

    public address(){

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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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
     private void setnumber_two(String number_two){ 
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

    private void setpostal_code(String postal_code){
        this.postal_code = postal_code;
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

    public String getnumber_two(){
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
    public String getpostal_code(){
        return this.postal_code;
    }

 public String cargar(String text, Dbconnection conn) {
     String query = "SELECT * FROM progra2.address a WHERE a.id_user=" + text;
     ResultSet rset =  conn.select(query); 
     System.out.println(query);

    String stal_address = new String();


     try {
        while(rset.next()){
         String s = rset.getString(1)
            + " " + rset.getString(2)
            + " " + rset.getString(3)
            + " " + rset.getString(4)
            + " " + rset.getString(5)
            + " " + rset.getString(6)
            + " " + rset.getString(7)
            + " " + rset.getString(8)
            + " " + rset.getString(9)
            + " " + rset.getString(10)
            + " " + rset.getString(11)
            + " " + rset.getString(12)
            + " " + rset.getString(13);


            stal_address=stal_address + '\n' + s;
            System.out.println(s);

               

            this.setId(Integer.parseInt(rset.getString(1)));
            this.setid_user(Integer.parseInt(rset.getString(2)));
            this.setstreet(rset.getString(3));
            this.setnumber(Integer.parseInt(rset.getString(4)));
            this.setnumber_two(rset.getString(5));
            this.setneighborhood(rset.getString(6));
            this.setcity(rset.getString(7));
            this.setstate(rset.getString(8));
            this.setcountry(rset.getString(9));
            this.setpostal_code(rset.getString(10));
            this.setGps_lat(rset.getString(11));
            this.setGps_lon(rset.getString(12));
            this.setCreated(rset.getString(13));
            System.out.println(""+ "lat" + rset.getString(11));
           


        }

        System.out.println(stal_address);
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
        return stal_address;
        
    }

    public boolean buscar(String text, Dbconnection conn) {
     String query = "SELECT COUNT(id) FROM progra2.address a WHERE a.id_user=" + text ;
     ResultSet rset =  conn.select(query); 
     System.out.println(query);
     int n;

     try {
         rset.next();
        n = Integer.parseInt(rset.getString(1));
        System.out.println(n +" registros ");
        
     } catch (SQLException e) {
 
        e.printStackTrace();
        n=0;
     }
     return n>0;
    }
}