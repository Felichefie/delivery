public class Ubicacion {//nombre de la clase
    //propiedades del objeto 
    double lat;
    double lon;


    Ubicacion(double lat, double lon){//quien la construye con los materiales; lat y long
        //Variables del constructor, y no son las mismas
        this.lat = lat;
        this.lon = lon;
    }
    double distancia(Ubicacion b){
        double d = (lat - b.lat )*(lat - b.lat )+(lon - b.lon)*(lon - b.lon);
        d = Math.sqrt(d);
        return d;
    }
    void imprimir(){
        System.out.println(lat);
        System.out.println(lon);
    }
} 