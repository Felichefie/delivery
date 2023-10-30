import java.util.Scanner;

public class Impuestos {

    private double monto;
    private int tipoImpuesto;

    public Impuestos(double monto, int tipoImpuesto) {
        this.monto = monto;
        this.tipoImpuesto = tipoImpuesto;
    }

    public double calcularImpuesto() {
        double impuesto = 0;
        double lim_inf = 0, porcentaje = 0, cuota_fija = 0;
        double ml = 0, cantidadL = 0;
        int cantidadCigarros = 0, L = 0;
        switch (tipoImpuesto) {
            //IVA
            case 1:
                impuesto = monto * 0.16;
                break;
            //Salud / Educacion / Agua
            case 2:
                impuesto = 0;
                break;
            //Fronterizo
            case 3:
                impuesto = monto * 0.08;
                break;
            //Nomina
            case 4:
                impuesto = monto * 0.03;
                break;
            //Hoteleria
            case 5:
            double H;
            System.out.println("Ingrese el hospedaje: ");
            Scanner scannerHospe = new Scanner(System.in);
            H = scannerHospe.nextInt();  
            if (H <= 0) {
                System.out.println("El hospedaje debe ser mayor a 0");
                break;
            }
            impuesto = (monto*0.08)+H;
            break;
            //Renta
            case 6:
                monto = monto / 2;
                if (monto >= 0.01 && monto <=368.10) {
                    lim_inf = 0.01;
                    porcentaje = 0.0192;
                    cuota_fija = 0;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 368.10 && monto <= 3124.35) {
                    lim_inf = 368.10;
                    porcentaje = 0.0640;
                    cuota_fija = 7.05;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 3124.35 && monto <= 5490.75) {
                    lim_inf = 3124.35;
                    porcentaje = 0.1088;
                    cuota_fija = 183.45;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 5490.75 && monto <= 6382.8) {
                    lim_inf = 5490.75;
                    porcentaje = 0.16;
                    cuota_fija = 441;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 6382.8 && monto <= 7641.91) {
                    lim_inf = 6382.8;
                    porcentaje = 0.1792;
                    cuota_fija = 583.65;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 7641.91 && monto <= 15412.81){
                    lim_inf = 7641.91;
                    porcentaje = 0.2136;
                    cuota_fija = 809.25;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 15412.81 && monto <= 24292.65) {
                    lim_inf = 15412.81;
                    porcentaje = 0.2352;
                    cuota_fija = 2469.15;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 24292.65 && monto <= 46378.5) {
                    lim_inf = 24292.65;
                    porcentaje = 0.30;
                    cuota_fija = 4557.75;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 46378.5 && monto <= 61838.11){
                    lim_inf = 46378.5;
                    porcentaje = 0.32;
                    cuota_fija = 11183.40;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 61838.11 && monto <= 185514.31){
                    lim_inf = 61838.11;
                    porcentaje = 0.34;
                    cuota_fija = 16130.55;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                } else if (monto > 185514.31){
                    lim_inf = 185514.31;
                    porcentaje = 0.35;
                    cuota_fija = 58180.35;
                    impuesto = ((monto - lim_inf) * porcentaje) + cuota_fija;
                    impuesto = impuesto * 2;
                }
                break;
            // Impuesto de tabaco
            case 7:
            System.out.println("Ingrese la cantidad de cigarros: (1 Cajetilla = 20 cigarros): ");
            Scanner scannerTabaco = new Scanner(System.in);
            cantidadCigarros = scannerTabaco.nextInt();  
            if (cantidadCigarros <= 0) {
                System.out.println("La cantidad de cigarros debe ser mayor a cero.");
                break;
            }
                impuesto = (monto*0.16)+(cantidadCigarros * 0.5911); 
                break;
            // Impuesto de alcohol (cerveza)
            case 8:
            impuesto = (monto*0.16) + (monto * 0.265); 
            break;
            // Impuesto de bebidas saborizadas
            case 9:
            System.out.println("Ingrese los mililitros del producto (1 litro = 1000 mililitros): ");
            Scanner scannerCerveza = new Scanner(System.in);
            ml = scannerCerveza.nextDouble();  
            if (ml <= 0) {
                System.out.println("La cantidad de mililitros debe ser mayor a cero.");
                break;
            }
            cantidadL = (ml/1000);
            impuesto = (monto*0.16)+(cantidadL * 1.50); 
            break;
            // Impuesto de gasolina Magna
            case 10:
            System.out.println("Ingrese la cantidad de litros de gasolina: ");
            Scanner scannerGasM = new Scanner(System.in);
            L = scannerGasM.nextInt();  
            if (L <= 0) {
                System.out.println("La cantidad de litros debe ser mayor a cero.");
                break;
            }
            impuesto = (monto*0.16)+(L * 5.91); 
                break;
            // Impuesto de gasolina Premium
            case 11:
            System.out.println("Ingrese la cantidad de litros de gasolina: ");
            Scanner scannerGasP = new Scanner(System.in);
            L = scannerGasP.nextInt();  
            if (L <= 0) {
                System.out.println("La cantidad de litros debe ser mayor a cero.");
                break;
            }
            impuesto = (monto*0.16)+(L * 4.99);
            break;
            // Impuesto de diesel
            case 12:
            System.out.println("Ingrese la cantidad de litros de gasolina: ");
            Scanner scannerGasD = new Scanner(System.in);
            L = scannerGasD.nextInt();  
            if (L <= 0) {
                System.out.println("La cantidad de litros debe ser mayor a cero.");
                break;
            }
            impuesto = (monto*0.16)+(L * 5.5);
            break;
            case 13:
            double TUA = 1000;
            impuesto = (monto*0.16)+TUA;
            break;
            default:
                System.out.println("Tipo de impuesto no válido");
        }

        return impuesto;
    }
}
