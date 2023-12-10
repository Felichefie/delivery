public class Main {
    public static void main(String[] args) {
       //BASE DE DATOS.
       //GUI. 
        

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbConn = new Dbconnection(URL, user, pass);

        TarjetaPanel interfaz = new TarjetaPanel();
        interfaz.setDbConn(dbConn);
        interfaz.show();

                
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            // Cierra la conexión de la base de datos.
            if (dbConn != null) {
            try {
                dbConn.closeConnection();
                System.out.println("DATABASE CONNECTION CLOSE.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }));
        
    }
}