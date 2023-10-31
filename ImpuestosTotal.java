public class ImpuestoTotal {
    public static void main(String[] args) {
        double SalarioMensual = 50000;
        double GastoSuper = 12000;
        double Cervezas = 2 * 100; 
        double Coca = 12 * 20; 
        double Cigarros = 1 * 100; 
        double Gas = 2 * 40 * 20; 
        double TicketAvion = 3000;
        double GastoTUA = 1000;
        double GastosVuelo = 2000;
        double Hotel = 3 * 2000; 
        double ComidaTij = 1000;
        double Electricidad = 250;
        double Agua = 150;
        double Internet = 500;
        double Celular = 400;
        double Suscripciones = 275;
        double Netflix = 219;
        double Salidas = 2000;
        double Renta = 3000;
        double Auto = 8000;
        double SeguroAuto = 1000;
        double TasaIVA = 0.16; 
        double TasaISR = 0.25; 

        double iva = (GastoSuper  + GastoTUA  + (GastosVuelo * TasaIVA )) * TasaIVA ;

        
        double gastosTotales = GastoSuper + Cervezas + Coca + Cigarros + Gas +
                TicketAvion + Hotel + ComidaTij + Electricidad + Agua +
                Internet + Celular + Suscripciones + Netflix + Salidas +
                Renta + Auto + SeguroAuto;

        double impuestos = SalarioMensual - gastosTotales ;

        
        double isr = impuestos * TasaISR;

        
        double impuestosTotales = iva + isr;

        System.out.println("Total Impuestos Pagados: " + impuestosTotales + " pesos");
    }
}