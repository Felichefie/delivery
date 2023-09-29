public class Ubicacion {
    //PROPIEDADES DEL OBJETO
double lat;
double lon;

Ubicacion ( double lat,  double lon){                               
    
    //VARIABLES DEL CONSTRUCTOR
this.lat = lat;
this.lon = lon;
}

double distancia (Ubicacion a, Ubicacion b){                         
    
    //CALCULA UNA DISTANCIA
double d = (a.lat - b.lat)*(a.lat - b.lat) + (a.lon - b.lon)*(a.lon - b.lon);
d = Math.sqrt(d);
return d;
}

void imprimir(){                                                    
    
    //IMPRIME LOS VALORES
System.out.println(lat);
System.out.println(lon);
}
}
