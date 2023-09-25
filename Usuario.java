

public class Usuario {
    private Ubicacion ubicacion;
    private Direccion direccion;
    private String email;
    private String nombre;
    private String primer_apeido;
    private String segundo_apeido;
    private String telefono;
   
    Usuario(Ubicacion ubicacion, Direccion direccion, String email,String nombre,String primer_apeido, String segundo_apeido, String telefono) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.primer_apeido = primer_apeido;
        this.segundo_apeido = segundo_apeido;
        this.telefono = telefono;
      
    }
Usuario(Ubicacion ubicacion, Direccion direccion){
    this.ubicacion = ubicacion;
    this.direccion = direccion;

}
    void imprimir_direccion(){
        direccion.imprimir();
    }
    void imprimir_ubicacion(){
        ubicacion.imprimir();;
    }
    void imprimir_datos_personales(){
        System.out.println(nombre);
        System.out.println(primer_apeido);
        System.out.println(segundo_apeido);
        System.out.println(telefono);
        System.out.println(email);

    }
    //NUEVO USUARIO PARA OBJETO USUARIO EN ListenerButton
    Usuario(String nombre,String primer_apeido, String segundo_apeido, String telefono,String email) {
        this.nombre = nombre;
        this.primer_apeido = primer_apeido;
        this.segundo_apeido = segundo_apeido;
        this.telefono = telefono;
         this.email = email;
      
    }


}