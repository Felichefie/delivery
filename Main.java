public class Main {
    public static void main(String[] args) {
        System.out.println("prueba clase Ubicacion");
        Ubicacion morelia = new Ubicacion(19.70078,-101.18443);
        Ubicacion monterrey = new Ubicacion(25.68661,-100.31611);
        double distancia_km = morelia.distancia(monterrey)*111.12;
        System.out.println("Distancia entre Morelia y Monterrey: "+distancia_km+" km");
    }
}
