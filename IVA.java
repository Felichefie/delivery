public class IVA {

private double base;
private double porcentaje;

    

    public iva(double b, double p) {

    this.base = b;
    return this.porcentaje= p;
    
    }
    
   public double impuesto(){
        return this.base * this.porcentaje/100;
    }

}


