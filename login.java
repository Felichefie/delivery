import java.sql.Connection;

public class login {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        String email = "feliz.jimenez@umich.mx";
        String password = "Mony123?";
        
        System.out.println("LOGIN");


        //CONECTAR A LA BASE DE DATOS
        Dbconnection dbconnection = new Dbconnection(URL, user, pass); 
        Connection conn = dbconnection.getConn();
        Response r = dbconnection.LogAuth(email, password, conn);


        if(r.isStatus() == true){
            System.out.println("USUARIO ATENTIFICADO!");
            System.out.println("SESION" + r.getSesion());

        }else{
            System.out.println("USUARIO NO AUTENTIFICADO");
            System.out.println("SESION" + r.getSesion());
        }

    }
}
