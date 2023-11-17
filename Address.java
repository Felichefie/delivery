import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {
    private int Id;// 1
    private int UserId;// 2
    private String Street;// 3
    private int Number;// 4
    private String Numbertwo;// 5
    private String Neighborhood;// 6
    private String City;// 7
    private String State;// 8
    private String Country;// 9
    private String PostalCode;// 10
    private String gps_lat;// 11
    private String gps_lon;// 12
    private String created;// 13

    public Address() {

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

    void setId(int id) {
        this.Id = id;
    }

    private void setUserId(int UserId) {
        this.UserId = UserId;
    }

    private void setStreet(String street) {
        this.Street = Street;
    }

    private void setNumber(int number) {
        this.Number = Number;
    }

    private void setNumberTwo(String number_two) {
        this.Numbertwo = Numbertwo;
    }

    private void setNeighborhood(String neighborhood) {
        this.Neighborhood = Neighborhood;
    }

    private void setCity(String city) {
        this.City = City;
    }

    private void setState(String state) {
        this.State = State;
    }

    private void setCountry(String country) {
        this.Country = country;
    }

    void setPostalCode(String postalcode) {
        this.PostalCode = PostalCode;
    }

    public int getId() {
        return this.Id;
    }

    public int getUserId() {
        return this.UserId;
    }

    public String getStreet() {
        return this.Street;
    }

    public int getNumber() {
        return this.Number;
    }

    public String getNumbertwo() {
        return this.Numbertwo;
    }

    public String getNeighborhood() {
        return this.Neighborhood;
    }

    public String getCity() {
        return this.City;
    }

    public String getState() {
        return this.State;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getPostalCode() {
        return this.PostalCode;
    }

    public String cargar(String text, DbConnection conn) {
        String query = "SELECT * FROM progra2.address a WHERE a.id_user=" + text;
        ResultSet rset = conn.select(query);
        System.out.println(query);

        String stal_address = new String();

        try {
            while (rset.next()) {
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

                stal_address = stal_address + '\n' + s;
                System.out.println(s);

                this.setId(Integer.parseInt(rset.getString(1)));
                this.setUserId(Integer.parseInt(rset.getString(2)));
                this.setStreet(rset.getString(3));
                this.setNumber(Integer.parseInt(rset.getString(4)));
                this.setNumberTwo(rset.getString(5));
                this.setNeighborhood(rset.getString(6));
                this.setCity(rset.getString(7));
                this.setState(rset.getString(8));
                this.setCountry(rset.getString(9));
                this.setPostalCode(rset.getString(10));
                this.setGps_lat(rset.getString(11));
                this.setGps_lon(rset.getString(12));
                this.setCreated(rset.getString(13));
                System.out.println("" + "lat" + rset.getString(11));

            }

            System.out.println(stal_address);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return stal_address;

    }

    public boolean buscar(String text, DbConnection conn) {
        String query = "SELECT COUNT(id) FROM progra2.address a WHERE a.id_user=" + text;
        ResultSet rset = conn.select(query);
        System.out.println(query);
        int n;

        try {
            rset.next();
            n = Integer.parseInt(rset.getString(1));
            System.out.println(n + " registros ");

        } catch (SQLException e) {

            e.printStackTrace();
            n = 0;
        }
        return n > 0;
    }
}