public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba class ubicacion");

        Ubicacion morelia = new Ubicacion(16.5829400, -93.7821400);
        Ubicacion monterrey = new Ubicacion(25.67507, -100.31847);
        Ubicacion ubicacion = new Ubicacion(19.0, -101);

        double ubicacion_km = morelia.distancia(monterrey) * 111.4652;

        System.out.println(ubicacion_km);

        Direccion miDireccion = new Direccion();
        
        miDireccion.imprimir();

        Direccion direccion_feliche = new Direccion("Jacarandas 109b", "Las huertas", "Morelia", 58195);
        
        direccion_feliche.imprimir();

        Usuario juan = new Usuario(ubicacion, miDireccion);

        juan.imprimir_Direccion();
        juan.imprimir_ubicacion();
        //esto es un usuario
        Usuario arturo = new Usuario("2001293d@umich.mx", "Arturo", "Ruiz", "Garcia", "9999999999");
        arturo.imprimir_datos_personales();
       
        System.out.println("");
        System.out.println("");
        User user = new User();
        user.show();
    }
}
