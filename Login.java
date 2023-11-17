import java.sql.Connection;

public class Login {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        System.out.println("Login");

        String email = "freddy51@gmail.com";
        String password = "uFtut72wEYwhms4Gwtjfr5ys9UyJRhAfhdDtzeDsEOy1jmSJMYQc8K/g8vPu2LBf+RgMmBQqDUK64w2T35aEgGI0ACmKeWjw/vuWJAWXxug";

        // obtener conexión a la base de datos
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        Connection conn = dbconnection.getConn();
        Response r = dbconnection.logAuth(email, password, conn);

        if (r.isStatus() == true) {
            System.out.println("Usuario autentificado");
            System.out.println("sesion : " + r.getSession());
        } else {
            System.out.println("Usuario NO autentificado");
            System.out.println("sesion : " + r.getSession());
        }
    }

    public boolean inicioSesion() {
        return false;
    }
}
