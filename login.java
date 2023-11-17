import java.sql.Connection;


public class login {
    public static void main(String[] args){
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String email = "felix.jimenez@umich.mx";
        String password = "Moni123?";

        System.out.println("login");
        //obtener conexion a la base de datos
        DBconnection dBconnection = new DBconnection(URL, user, pass);
        Connection conn = dBconnection.getConn();
        Response r = dBconnection.logAuth(email, password, conn);

        if(r.isStatus()==true){
            System.out.println("usuario autentificado");
            System.out.println("sesion : " + r.getSesion());
        }else {
            System.out.println("usuario no autenticado");
            System.out.println("Sesion : " + r.getSesion());
        }

    }
}
