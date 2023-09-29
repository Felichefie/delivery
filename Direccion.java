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
