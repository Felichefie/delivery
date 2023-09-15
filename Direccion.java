public class Direccion {
    private String calle_numero;
    private String colonia;
    private String ciudad;
    private String pais;
    private String referencia;
    private int codigo_postal;

    Direccion(String calle_numero, String colonia, String ciudad, int codigo_postal){
        this.calle_numero = calle_numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = "Mexico";
        this.referencia = "";
        this.codigo_postal = codigo_postal;
    }
    Direccion(String calle_numero, String colonia, String ciudad, String referencia, int codigo_postal, String pais){
        this.calle_numero = calle_numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = pais;
        this.referencia = referencia;
        this.codigo_postal = codigo_postal;
    }
    Direccion(){
        this.calle_numero = "";
        this.colonia = "";
        this.ciudad = "";
        this.pais = "";
        this.referencia = "";
        this.codigo_postal = 0;
    }
    void imprimir(){
        System.out.println(this.calle_numero);
        System.out.println(this.colonia);
        System.out.println(this.pais);
        System.out.println(this.codigo_postal);
        System.out.println(this.referencia);
        System.out.println(this.ciudad);

    }

    
}
