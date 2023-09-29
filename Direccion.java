//CLASE DIRECCION
public class Direccion {
    private String calleNumero;
    private String colonia;
    private String ciudad;
    private String pais;
    private String estado;
    private String codigoPostal;


    Direccion(String calleNumero, String colonia, String ciudad, String estado,String pais, String codigoPostal){
        this.calleNumero = calleNumero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.pais = pais;
        this.estado = estado;
        this.codigoPostal = codigoPostal;

    }




	//Metodo para imprimir la direccion
    void imprimir(){
        System.out.println(this.calleNumero);
        System.out.println(this.colonia);
        System.out.println(this.ciudad);
        System.out.println(this.pais);
        System.out.println(this.estado);
        System.out.println(this.codigoPostal);
        
    }



}

