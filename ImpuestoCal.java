import java.util.Scanner;

public class ImpuestoCal {
    private double ingresos;
    private double gastosuper;
    private double gastosCerveza;
    private double gastosCoca;
    private double gastosCigarros;
    private double gastosGasolina;
    private double gastosAvion;
    private double gastosHotel;
    private double comidaviaje;
    private double gastosElectricidad;
    private double gastosAgua;
    private double gastosInternet;
    private double gastosCelular;
    private double gastosServiciosDigitales;
    private double gastosNetflix;
    private double gastosDiversión;
    private double gastosRenta;
    private double gastosAutoMensualidad;
    private double gastosSeguroAuto;




    public ImpuestoCal(double ingresos, double impuIva, double impuISR, double impuIEPS) {
        this.ingresos = ingresos;
        this.gastosuper = gastosuper;
        this.gastosCerveza = gastosCerveza;
        this.gastosCoca = gastosCoca;
        this.gastosCigarros = gastosCigarros;
        this.gastosGasolina = gastosGasolina;
        this.gastosAvion = gastosAvion;
        this.gastosHotel = gastosHotel;
        this.comidaviaje = comidaviaje;
        this.gastosElectricidad = gastosElectricidad;
        this.gastosAgua = gastosAgua;
        this.gastosInternet = gastosInternet;
        this.gastosCelular = gastosCelular;
        this.gastosServiciosDigitales = gastosServiciosDigitales;
        this.gastosNetflix = gastosNetflix;
        this.gastosDiversión = gastosDiversión;
        this.gastosRenta = gastosRenta;
        this.gastosAutoMensualidad = gastosAutoMensualidad;
        this.gastosSeguroAuto = gastosSeguroAuto;
    }


    public double calcularIVA(double cantidad, double porcentaje) {
        return cantidad * porcentaje / 100;
    }

    public double calcularImpuestoNomina(double cantidad, double porcentaje) {
        return cantidad * porcentaje / 100;
    }

    public double calcularImpuestoHoteleria(double cantidad, double porcentaje) {
        return cantidad * porcentaje / 100;
    }

    public double calcularISR(double ingresos){
        double isr = 0;
        isr = (0.30 * (ingresos - (24292.66*2))) + (4557.75*2);
        return isr;
    };
    public double calcularIEPS(double cantidad, double porcentaje) {
        return cantidad * porcentaje / 100;
    }

    public double calcularImpuestos() {
        double impuestoIVA = calcularIVA(gastosuper, 16) 
                             + calcularIVA(gastosCerveza, 16)
                             + calcularIVA(gastosCoca, 16) 
                             + calcularIVA(gastosCigarros, 16) 
                             + calcularIVA(gastosGasolina, 16) 
                             + calcularIVA(gastosAvion, 16) 
                             + calcularIVA(gastosHotel, 8) 
                             + calcularIVA(comidaviaje, 8) 
                             + calcularIVA(gastosElectricidad, 16) 
                             + calcularIVA(gastosAgua, 0) 
                             + calcularIVA(gastosInternet, 16) 
                             + calcularIVA(gastosCelular, 16) 
                             + calcularIVA(gastosServiciosDigitales, 16) 
                             + calcularIVA(gastosNetflix, 16) 
                             + calcularIVA(gastosDiversión, 16) 
                             + calcularIVA(gastosRenta, 16) 
                             + calcularIVA(gastosAutoMensualidad, 16) 
                             + calcularIVA(gastosSeguroAuto, 16);
        double impuestoNomina = calcularImpuestoNomina(ingresos, 3);
        double impuestoHoteleria = calcularImpuestoHoteleria(gastosHotel, 4);
        double impuestoISR = calcularISR(ingresos);
        double impuestoIEPS = calcularIEPS(gastosCerveza, 26.5) 
                            + calcularIEPS(gastosCoca, 1.5)    
                            + calcularIEPS(gastosGasolina, 5.91 * 2) 
                            + calcularIEPS(gastosAvion, 0.16 * 2000) 
                            + calcularIEPS(gastosCigarros, 0.5911);
        double impuestoTotal = impuestoIVA + impuestoNomina + impuestoHoteleria + impuestoISR + impuestoIEPS;
        double total = ingresos - gastosuper - gastosCerveza - gastosCoca - gastosCigarros - gastosGasolina 
                     - gastosAvion - gastosHotel - comidaviaje - gastosElectricidad - gastosAgua - gastosInternet 
                     - gastosCelular - gastosServiciosDigitales - gastosNetflix - gastosDiversión - gastosRenta 
                     - gastosAutoMensualidad - gastosSeguroAuto - impuestoTotal;
        if (total < 0) {
            System.out.println("Los gastos superan los ingresos, ajustar/eliminar conceptos para no tener pérdidas.");
        }
        System.out.println("Ingresos: $" + ingresos);
        System.out.println("Gastos sin impuestos: $" + (gastosuper + gastosCerveza + gastosCoca + gastosCigarros + gastosGasolina + gastosAvion + gastosHotel + comidaviaje + gastosElectricidad + gastosAgua + gastosInternet + gastosCelular + gastosServiciosDigitales + gastosNetflix + gastosDiversión + gastosRenta + gastosAutoMensualidad + gastosSeguroAuto));
        System.out.println("Impuesto IVA: $" + impuestoIVA);
        System.out.println("Impuesto ISR: $" + impuestoISR);
        System.out.println("Impuesto IEPS: $" + impuestoIEPS);
        System.out.println("Impuesto de nómina: $" + impuestoNomina);
        System.out.println("Impuesto de hotelería: $" + impuestoHoteleria);
        System.out.println("Impuesto total: $" + impuestoTotal);
        System.out.println("Total: $" + total);
        return total;
    }

    public static void main(String[] args) {
        ImpuestoCal calculoImp = new ImpuestoCal(50000, 12000, 200, 240, 50, 2000, 4480, 6720, 1080, 250, 150, 500, 400, 275, 219, 320, 3480, 9280, 1160);
        calculoImp.calcularImpuestos();
    }
}
