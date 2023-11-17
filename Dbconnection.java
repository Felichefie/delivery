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

        Dbconnection dbConn = new Dbconnection(URL, user, pass);
        User u = dbConn.getUser("");
        if (u.getId() == 0) {
            System.out.println("No existe");
            dbConn.insertNewUser(u, "Newpassword123");
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

    boolean insertNewUser(User user, String password) {
        if (!validaPassword(password)) {
            System.out.println("Contraseña no válida. Por favor, cumple con las condiciones de la contraseña.");
            return false;
        }

        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email, password)"
                + "VALUES('Freddy', 'Pineda', 'Prado', 'Alfredo', '2003-05-01', 'freddy51@gmail.com', 'Quesadilla51*')";
        try {
            PreparedStatement preState = conn.prepareStatement(queryInsert);
            preState.setString(1, user.getUserName());
            preState.setString(2, user.getName());
            preState.setString(3, user.getEmail());
            preState.setString(4, password);
            preState.execute();
            System.out.println("Usuario insertado correctamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    boolean validaPassword(String password) {
        // Implementa la lógica de validación de contraseña aquí
        // Por ejemplo: longitud >= 8, mayúsculas, minúsculas, número y caracter
        // especial
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[$%&_#].*");
    }

    public Connection getConn() {
        return conn;
    }

    Dbconnection(String URL, String user, String pass) {
        try {
            conn = DriverManager.getConnection(URL, user, pass);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    User getUser(String email) {
        User user = new User(0, 0, email, email);

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
        Response res = new Response();

        String query = "SELECT u.password FROM progra2.users u WHERE u.email='" + email + "'";
        System.out.println(query);
        ResultSet rset;
        Statement statement;
        String passwordDB = "";

        try {
            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {
                passwordDB = rset.getString(1);
            }

            if (passwordDB.equals(passwordLogin)) {
                res.setStatus(true);
                res.setSession("test_session");
                System.out.println("Autenticacion valida!");
            } else {
                System.out.println("Autenticacion fallida. Contraseña incorrecta");
            }
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return res;
    }

}