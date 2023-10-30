public class IEPS {

private double base;
private double porcentaje;

    
    public double obtenerIva(double b, double p) {

    this.base = b;
    return this.porcentaje = p;

    }
    
   public double impuesto(){
        return this.base * this.porcentaje/100;
    }

}

