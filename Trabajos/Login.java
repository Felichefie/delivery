/*
 * import java.sql.Connection;
 * 
 * public class Login {
 * 
 * public static void main(String[] args) {
 * String URL =
 * "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
 * String user = "alumno";
 * String pass = "alumnoPrueba1";
 * System.out.println("Login");
 * Password p = new Password("pass");
 * 
 * String email = "";
 * String password = "";
 * 
 * // obtener conexión a la base de datos
 * Dbconnection dbconnection = new Dbconnection(URL, user, pass);
 * Connection conn = dbconnection.getConexion();
 * Response r = dbconnection.logAuth(email, password, conn);
 * 
 * if (r.isStatus() == true) {
 * System.out.println("Usuario autentificado");
 * System.out.println("sesion : " + r.getSession());
 * } else {
 * System.out.println("Usuario NO autentificado");
 * System.out.println("sesion : " + r.getSession());
 * }
 * }
 * 
 * public boolean inicioSesion() {
 * return false;
 * }
 * }
 */