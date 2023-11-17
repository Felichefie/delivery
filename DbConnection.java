import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DbConnection {
    static Connection conn;

    public static void main(String[] args) {

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        DbConnection dbConn = new DbConnection(URL, user, pass);
        User u = dbConn.getUser("felix.jimenez@umich.mx");
        if (u.getId() == 0) {
            System.out.println("No existe");
            dbConn.insertNewUser(u);
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
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email, password)"
                + " VALUES('" + user.getUserName()
                + "', '" + user.getFirst_lastname() + "', '" + user.getSecond_lastname() + "','"
                + user.getName()
                + "', '2023-10-20','" + user.getEmail() + "'" + ",'" + user.getPassword() + "')";

        System.out.println(queryInsert);
        try {
            PreparedStatement preState = conn.prepareStatement(queryInsert);
            preState.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Connection getConn() {
        return conn;
    }

    DbConnection(String URL, String user, String pass) {
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
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
            user.setId(1);
        }
        return user;
    }

    Response logAuth(String email, String passwordLogin, Connection conn) {
        // res inicial status= false, user= -1 session = ""
        Response res = new Response();

        // solo regresa el password del usuario
        String query = "SELECT u.password, u.id FROM progra2.users u WHERE u.email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDB = "";
        String id_u = "";
        try {
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {
                passwordDB = rset.getString(1);
                id_u = rset.getString(2);
                System.out.println(passwordDB);
            }

            System.out.println(passwordDB);
            System.out.println(passwordLogin);

            if (BCrypt.checkpw(passwordLogin, passwordDB) == true) {
                System.out.println("Coincide ");
                String sessiontime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
                String sessionuuid = UUID.randomUUID().toString().substring(1, 10);
                String session = sessiontime + sessionuuid;
                System.out.println(session);
                LocalDateTime nowdate = LocalDateTime.now();
                System.out.println(nowdate);
                LocalDateTime endtimesession = nowdate.plusMinutes(30);
                System.out.println(endtimesession);

                String queryInsert = "INSERT INTO progra2.sessions(id, id_user, session, timeout, created)"
                        + " VALUES(4,'" + id_u
                        + "','" + session
                        + "', '" + endtimesession
                        + "','" + nowdate
                        + "')";

                System.out.println(queryInsert);
                try {
                    PreparedStatement preState = conn.prepareStatement(queryInsert);
                    preState.execute();

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error en la Query Insert");

                }

            } else {
                System.out.println("Error: No coincide.");
            }
        } catch (SQLException e) {
            System.out.println("Error en la query Select");
        }
        return res;
    }

    public ResultSet select(String query) {
        return null;
    }
}