public class Usuario {

    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String email;
    private Ubicacion ubicacion;
    private Direccion direccion;
   
    Usuario(String nombre, String primer_apellido, String segundo_apellido, String telefono, String email,
            Ubicacion ubicacion, Direccion direccion) {

        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
        this.email = email;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
      
    }
Usuario(Ubicacion ubicacion, Direccion direccion){
    this.ubicacion = ubicacion;
    this.direccion = direccion;

}
    void imprimir_direccion(){
        direccion.imprimir_datos_personales();
    }
    void imprimir_ubicacion(){
        ubicacion.imprimir();;
    }
    void imprimir_datos_personales(){
        System.out.println(nombre);
        System.out.println(primer_apellido);
        System.out.println(segundo_apellido);
        System.out.println(telefono);
        System.out.println(email);

    }
    //NUEVO USUARIO PARA OBJETO USUARIO EN ListenerButton
    Usuario(String nombre,String primer_apellido, String segundo_apellido, String telefono,String email) {
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
         this.email = email;
      
    }


}
