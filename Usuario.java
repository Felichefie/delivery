public class Usuario {
    private Ubicacion ubicacion;
    private Direccion direccion;
    private String email;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;

    Usuario(Ubicacion ubicacion, Direccion direccion, String nombre, String primer_apellido, String segundo_apellido,
            String telefono, String email) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
    }

    Usuario(String nombre, String primer_apellido, String segundo_apellido, String telefono, String email) {
        this.email = email;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
    }

    Usuario(Ubicacion ubicacion, Direccion direccion) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;

    }

    void imprimir_dirrecion() {
        direccion.imprimir();

    }

    void imprimir_ubicacion() {
        ubicacion.imprimir();

    }

    void imprimir_datos_personales() {
        System.out.println(nombre);
        System.out.println(telefono);
        System.out.println(email);
        System.out.println(primer_apellido);
        System.out.println(segundo_apellido);
    }

}
