import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
    static Connection conn;

    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbCon = new Dbconnection(URL, user, pass);
        User u = dbCon.getUser("felix.jimenez@umich.mx");

        if (u.getId() == 0) {
            System.out.println("No existe");
        } else {
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean insertNewUser(User user) {
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname,second_lastname, name, birthday, email)"
                + "VALUES(" + user.getUserName()
                + ", 'chabelo', 'monster', "
                + user.getName()
                + ", '2023-10-20', 'pepito@chabelo.com')";
        try {
            PreparedStatement prepState = conn.prepareStatement(queryInsert);
            prepState.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    Dbconnection(String URL, String user, String pass) {

        try {
            conn = DriverManager.getConnection(URL, user, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    User getUser(String email) {
        User user = new User();
        String query = "SELECT * FROM progra2.users u WHERE u.email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        try {
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5)
                        + " " + rset.getString(6)
                        + " " + rset.getString(7));
                user.setId(Integer.parseInt(rset.getString(1)));
                user.setName(rset.getString(4));
                user.setUserName(rset.getString(5));
            }
        } catch (SQLException e) {
            System.out.println("error en la query");
            user.setId(1);
        }
        return user;
    }

    public boolean direccionExists(int userId) {
        String query = "SELECT 1 FROM direccion WHERE user_id = 1";
        try (PreparedStatement prepStmt = conn.prepareStatement(query)) {
            prepStmt.setInt(1, userId);
            try (ResultSet rset = prepStmt.executeQuery()) {
                return rset.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertDireccion(Direccion direccion, int userId) {
        if (direccionExists(userId)) {
            System.out.println("Ya existe una dirección para este usuario.");
            return false;

        }
        return false;
    }
}