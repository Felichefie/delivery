public class Impuestos {
    private double IVA;
    private double IEPS;
    private double costo;
    private int cantidad;
    private int tipo;
    private double salario;

    Impuestos(double IVA, double IEPS, double costo){
        this.IVA = IVA;
        this.IEPS = IEPS;
        this.costo = costo;
        this.cantidad = 1;
        this.tipo = 0;
    }

    Impuestos(double IVA, double IEPS, double costo, int cantidad){
        this.IVA = IVA;
        this.IEPS = IEPS;
        this.costo = costo;
        this.cantidad = cantidad;
        this.tipo = 1;
    }
    Impuestos(double IVA, double IEPS, double costo, int cantidad, int tipo){
        this.IVA = IVA;
        this.IEPS = IEPS;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    Impuestos(double salario){
        this.salario = salario;
    }

    double calcularISR(){
        System.out.println("------------------");
        this.salario = this.salario/2;
        double ISR = this.salario - 24292.66;
        ISR = ISR * 0.30;
        ISR = ISR + 4557.75;
        ISR = ISR + ISR;
        System.out.println("------------------");
        return ISR;
        
    }

    double calcularImpuestos(){
        System.out.println("------------------");
        double impuestos = 0;
        if (this.tipo == 1 ){
            double normal = this.costo * (this.IVA/100);
            double especial = this.costo * (this.IEPS/100);
            System.out.println("IVA: " + normal);
            System.out.println("IEPS: " + especial);
            impuestos = normal + especial;
            impuestos = impuestos * this.cantidad;
        }
        else {
            double normal;
            double especial = this.IEPS * this.cantidad;
            if(this.tipo == 2){
                normal = ((this.IVA/100) * this.costo)*12;
            }else{
                normal = (this.IVA/100) * this.costo;
            }
            System.out.println("IVA: " + normal);
            System.out.println("IEPS: " + especial);
            impuestos = especial + normal;
        }
        System.out.println("------------------");
        return impuestos;
    }

}
