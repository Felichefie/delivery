package delivery;

public class Ubicacion {
    double lon;
    double lat;

    Ubicacion(double lon, double lat){
        this.lon = lon;
        this.lat = lat;
    }

    double distancia(Ubicacion a){
        double d = (a.lon - lon) * (a.lon - lon) + (a.lat - lat) * (a.lat - lat); 
        d = Math.sqrt(d);
        return d;
    }
}
