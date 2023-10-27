public class Main {
    public static void main(String[] args) {
       //Tarea Databse -> GUI
        

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbConn = new Dbconnection(URL, user, pass);

        Userexample interfaz = new Userexample(0, pass, pass, pass, pass, pass, pass, pass, pass);
        interfaz.setDbConn(dbConn);
        interfaz.show();

                
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Cierra la conexión de la base de datos
            if (dbConn != null) {
            try {
                dbConn.closeConnection();
                System.out.println("Conexión de la base de datos cerrada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }));
        
    }
}
