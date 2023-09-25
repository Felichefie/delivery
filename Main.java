public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba de la ubicacion en clase");
        Ubicacion morelia = new Ubicacion(19.70078 , -101.18443);
        Ubicacion monterrey = new Ubicacion(25.67507, -100.31847);
     
        double distancia_km = morelia.distancia(monterrey) * 111.319; 
        System.out.println(distancia_km);

        Direccion mi_direccion = new Direccion();
        mi_direccion.imprimir();

        Direccion direccion_daniel = new Direccion("Virrey de Mendoza 1517", "Felix Ireta", "Morelia",58070 );
        direccion_daniel.imprimir();
        
        
    }
    
}
