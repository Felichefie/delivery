import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
    static Connection conexion;

    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection conexion_db = new Dbconnection(URL, user, pass);
        User u = conexion_db.getUser("freddy51@gmail.com");
        if (u.getId() == 0) {
            System.out.println("No existe");
            String nuevaContraseña = "Jamon857*";
            conexion_db.insertNewUser(u, nuevaContraseña);
        } else {
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        }

        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean insertNewUser(User user, String password) {
        Password verificar = new Password(password);
        verificar.setPass(password);

        if (!verificar.isPasswordOk()) {
            System.out.println("Contraseña no válida. Por favor, cumple con las condiciones de la contraseña.");
            // Agregar mensajes de impresión para depuración
            System.out.println("Contraseña proporcionada: " + password);
            System.out.println("Longitud de la contraseña: " + password.length());
            System.out.println("Contiene mayúsculas: " + password.matches(".*[A-Z].*"));
            System.out.println("Contiene minúsculas: " + password.matches(".*[a-z].*"));
            System.out.println("Contiene números: " + password.matches(".*\\d.*"));
            System.out.println("Contiene caracteres especiales: " + password.matches(".*[$%&_#*@].*"));
            return false;
        }

        String queryInsert = "INSERT INTO progra2.users(type_user, user_name, first_lastname, second_lastname, name, birthday, email, gender, phone_number, password, created)"
                + " VALUES (1,Freddy,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preState = conexion.prepareStatement(queryInsert);

            preState.setString(1, user.getType());
            preState.setString(2, user.getUserName());
            preState.setString(3, user.getFirstLastName());
            preState.setString(4, user.getSecondLastName());
            preState.setString(5, user.getName());
            preState.setDate(6, user.getBirthday());
            preState.setString(7, user.getEmail());
            preState.setString(8, user.getGender());
            preState.setString(9, user.getPhone());
            preState.setString(10, password);
            preState.setDate(11, user.getCreated());
            preState.executeUpdate();

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
                password.matches(".*[$%&_#*@].*");
    }

    public Connection getConexion() {
        return conexion;
    }

    Dbconnection(String URL, String user, String pass) {
        try {
            conexion = DriverManager.getConnection(URL, user, pass);

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
            statement = conexion.createStatement();
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
        String passwordDB = "audhj*585sa";

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