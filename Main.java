public class Main{
   

    public static void main(String argumentos[]){
        /*System.out.println("prueba clase Ubicacion");
        Ubicacion morelia = new Ubicacion(19.7007800, -101.1844300);
        Ubicacion monterrey = new Ubicacion(25.67507, -101.31847);
        double distancia_km = morelia.distancia(monterrey)*111.319;
        System.out.println(distancia_km);
        Persona p1=new Persona();
        p1.setEdad(20);
        p1.setNombre("Feliche");
        System.out.println(p1.getEdad());
        System.out.println(p1.getNombre());
        Trabajador t1=new Trabajador();
        t1.setEdad(30);
        t1.setNombre("Anibal");
        t1.setTelefono(443484218);
        t1.setCosto_de_envio(56.80);
        System.out.println(t1.getEdad());
        System.out.println(t1.getNombre());
        System.out.println(t1.getTelefono());
        System.out.println(t1.getCosto_de_envio());*/

        Direccion mi_direccion = new Direccion();
        mi_direccion.imprimir();

        //Direccion direccion_feliche = new Direccion("Jacarandas 109b", "Las Huertas", "Morelia", 58195);
       // direccion_feliche.imprimir();

        Ubicacion ubicacion = new Ubicacion(19.0, -101);
        Usuario juan = new Usuario(ubicacion, mi_direccion);
        juan.imprimir_direccion();
        juan.imprimir_ubicacion();



    }
}
