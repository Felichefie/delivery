public class Direccion {
    private String calle_numero;
    private String colonia;
    private String ciudad;
    private String pais;
    private String referencia;
    private int codigo_postal;

    Direccion(String calle_numero, 
              String colonia,  
              String ciudad, 
              int codigo_postal)
        {
        this.calle_numero = calle_numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = "Mexico";
        this.referencia = "";
        this.codigo_postal = codigo_postal;
        }
    void imprimir()
        {
        System.out.println(this.calle_numero);
        System.out.println(this.colonia);
        System.out.println(this.pais);
        System.out.println(this.codigo_postal);
        System.out.println(this.referencia);
        System.out.println(this.ciudad);
        }

    
}
