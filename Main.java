
public class Main {

    public static void main(String[] args) {

        Direccion mi_direccion = new Direccion();
        mi_direccion.imprimir();

        Ubicacion ubicacion = new Ubicacion(19, -101);
        Usuario freddy = new Usuario(ubicacion, mi_direccion);
        freddy.imprimir_dirreccion();
        freddy.imprimir_dirreccion();

        System.out.println("Prueba class Ubicacion");
        Ubicacion morelia = new Ubicacion(19.7007800, -101.1844300);
        Ubicacion monterrey = new Ubicacion(25.67507, -100.31847);

        double distancia_km = (morelia.distancia(monterrey) * 111.319);
        System.out.println(distancia_km + " km");

    }
}