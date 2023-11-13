public class Login {
    public static void main(String[] args) {
        System.out.println("Login");

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        
        String email = "felix.jimenez@umich.mx";
        String password = "Moni123?";
        //Conectar a la Base de datos
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        Response r = dbconnection.LogAuth(email, password);
        
        if(r.isStatus()==true){
            System.out.println("Usuario identificado");
            System.out.println("sesion: "+r.getSesion());
        }else{
             System.out.println("Usuario NO identificado");
            System.out.println("sesion: "+r.getSesion());
        }
        

    
        
    }
    
}
