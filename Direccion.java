//CLASE DIRECCION

public class Direccion {
    private String calle_numero;
    private String colonia;
    private String ciudad;
    private String pais;
    private String referencia;
    private int codigo_postal;


    Direccion(String calle_numero, String colonia, String ciudad, String pais,String referencia, 
                int codigo_postal){
        this.calle_numero = calle_numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = pais;
        this.referencia = referencia;
        this.codigo_postal = codigo_postal;

    }
    
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
