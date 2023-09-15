public class Direccion {
    //Propiedades de la dirección
    //requiere un objeto, el constructor debe tener el mismo nombre que la clase
     String calle_numero;
   String colonia;
    String ciudad;
     String pais;
     String referencia;
   int codigo_postal;

    Direccion(String calle_numero, String colonia, String ciudad, int codigo_postal){

        this.calle_numero = calle_numero;
        this.colonia= colonia;
        this.ciudad = ciudad;
        this.pais = "México";
        this.referencia = "";
        this.codigo_postal = codigo_postal;
    }// es una funcion, en este caso son metodos 

     Direccion(String calle_numero, String colonia, String ciudad, int codigo_postal, String pais, String referencia){

        this.calle_numero = calle_numero;
        this.colonia= colonia;
        this.ciudad = ciudad;
        this.pais = pais;
        this.referencia = referencia;
        this.codigo_postal = codigo_postal;
    }// es una funcion, en este caso son metodos 

    Direccion(){//No va a recibir nada 

        this.calle_numero = "";
        this.colonia= "";
        this.ciudad = "";
        this.pais = "";
        this.referencia = "";
        this.codigo_postal = 0;
    }

   void imprimir();//no recibe nada porque ya conoce todo, estanos dentro de la fabrica


}