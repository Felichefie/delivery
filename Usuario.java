public class Usuario {
  private Ubicacion ubicacion;
    private Direccion direccion;
    private String email;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;

    Usuario(Ubicacion ubicacion, Direccion direccion){
        this.ubicacion=ubicacion;
        this.direccion=direccion;
    }
    void imprimir_direccion(){
        direccion.imprimir();
        
    }
    void imprimir_ubicacion(){
        ubicacion.imprimir();
    }
}
