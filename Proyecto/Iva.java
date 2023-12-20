package Proyecto;

public class Iva {
    private double base;
    private double impuesto;

    public Iva(double b) {
        this.base = b; // constructor para calcular el impuesto

        this.impuesto = b * 16 / 100;

    }

    public double getimpuesto() { // metodo o funcion de la clase para regresar el impuesto
        return this.impuesto;
    }

    public double getbase() { // metodo o funcion de la clase para regresar la base;
        return this.base;
    }

}
