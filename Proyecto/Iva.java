package Proyecto;

public class Iva {
    private float base;
    private float impuesto;

    public Iva(float b) {
        this.base = b; // constructor para calcular el impuesto

        this.impuesto = b * 16 / 100;

    }

    public float getimpuesto() { // metodo o funcion de la clase para regresar el impuesto
        return this.impuesto;
    }

    public float getbase() { // metodo o funcion de la clase para regresar la base;
        return this.base;
    }

}//