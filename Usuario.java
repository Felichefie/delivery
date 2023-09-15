public class Usuario {
    Ubicacion ubicacion;
  Direccion direccion;
     String email;
     String nombre;
     String primer_apellido;
     String segundo_apaellido;
     String telefono;

    Usuario(Ubicacion ubicacion, Direccion direccion){
        this.ubicacion = ubicacion;
        this.direccion = direccion;

    }
    void imprimir_direccion(){
        direccion.imprimir();
    }

void imprimir_ubicacion(){
        ubicacion.imprimir();
    }

}