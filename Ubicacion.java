public class Ubicacion {
    // Propiedades del objeto 
    double lat;
    double lon;

    Ubicacion(double lat, double lon) { //Variables del constructor
        this.lat = lat;
        this.lon = lon;
    }
        double distancia (Ubicacion b){
        double d = (lat - b.lat) * (lat - b.lat) + (lon - b.lon) * (lon - b.lon);
        d = Math.sqrt(d);
        return d;

    }
    void imprimir(){
        System.out.println(lat);
        System.out.println(lon);
    }
}
