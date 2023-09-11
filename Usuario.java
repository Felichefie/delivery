public class Usuario {
    private Ubicacion ubicacion;
    private Direccion direccion;

    Usuario(Ubicacion ubicacion, Direccion direccion){

        this.ubicacion = ubicacion;
        this.direccion = direccion;

    }

    void imprimir_Direccion(){
        
        direccion.imprimir();

    }

    void imprimir_ubicacion(){

        ubicacion.imprimir();

    }
}
