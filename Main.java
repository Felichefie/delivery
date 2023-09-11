package delivery;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba class ubicacion");

        Ubicacion morelia = new Ubicacion(16.5829400, -93.7821400);
        Ubicacion monterrey = new Ubicacion(25.67507, -100.31847);

        double ubicacion_km = morelia.distancia(monterrey) * 111.4652;

        System.out.println(ubicacion_km);
    }
}
