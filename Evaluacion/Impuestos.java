package Evaluacion;

public class Impuestos {

    private double salario;
    private double gastosSinImpuestos;
    private double totalImpuestoIVA;
    private double totalImpuestoISR;
    private double totalImpuestoIEPS;

    public Impuestos(double salario) {
        this.salario = salario;
        this.gastosSinImpuestos = 0;
        this.totalImpuestoIVA = 0;
        this.totalImpuestoISR = 0;
        this.totalImpuestoIEPS = 0;
    }

    public double calcularIVA(double monto, double porcentaje) {
        double impuesto = monto * (porcentaje / 100);
        totalImpuestoIVA += impuesto;
        return impuesto;
    }

    public double calcularIEPS(double monto, double porcentaje) {
        double impuesto = monto * (porcentaje / 100);
        totalImpuestoIEPS += impuesto;
        return impuesto;
    }

    public static void main(String[] args) {
        Impuestos calculador = new Impuestos(50000);
        double impuesto;
        double especial;
        double total;

        System.out.println("*************VIVERES************");
        double gastoSuper = 12000;
        impuesto = calculador.calcularIVA(gastoSuper, 16);
        especial = calculador.calcularIEPS(gastoSuper, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoSuper + total));

        System.out.println("*************CERVEZA************");
        double gastocerveza = 100 * 2;
        impuesto = calculador.calcularIVA(gastocerveza, 16);
        especial = calculador.calcularIEPS(gastocerveza, 26.5);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastocerveza + total));

        System.out.println("*************REFRESCOS************");
        double gastoCoca = 12 * 20;
        impuesto = calculador.calcularIVA(gastoCoca, 16);
        especial = (1.5 * (12 * 0.355));
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoCoca + total));

        System.out.println("*************CIGARROS************");
        double gastoCigarros = 50;
        impuesto = calculador.calcularIVA(gastoCigarros, 16);
        especial = 20 * 0.5911;
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoCigarros + total));

        System.out.println("*************GASOLINA************");
        double gastoGasolina = 2000;
        impuesto = calculador.calcularIVA(gastoGasolina, 16);
        especial = 40 * 2 * 4.99;
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoGasolina + total));

        System.out.println("*************AVION************");
        double gastoAvion = 3000;
        impuesto = calculador.calcularIVA(gastoAvion, 16);
        especial = 1000;
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoAvion + total));

        System.out.println("*************Hotel************");
        double gastoHotel = 6000;
        impuesto = calculador.calcularIVA(gastoHotel, 8);
        especial = 240;
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoHotel + total));

        System.out.println("*************Comida************");
        double gastoComida = 1000;
        impuesto = calculador.calcularIVA(gastoComida, 8);
        especial = calculador.calcularIEPS(gastoComida, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoComida + total));

        System.out.println("*************Energia************");
        double gastoEnergia = 250;
        impuesto = calculador.calcularIVA(gastoEnergia, 16);
        especial = calculador.calcularIEPS(gastoEnergia, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoEnergia + total));

        System.out.println("*************AGUA************");
        double gastoAgua = 150;
        impuesto = calculador.calcularIVA(gastoAgua, 0);
        especial = calculador.calcularIEPS(gastoAgua, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoAgua + total));

        System.out.println("*************INTERNET************");
        double gastoInternet = 500;
        impuesto = calculador.calcularIVA(gastoInternet, 16);
        especial = calculador.calcularIEPS(gastoInternet, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoInternet + total));

        System.out.println("*************CELULAR************");
        double gastoCelular = 400;
        impuesto = calculador.calcularIVA(gastoCelular, 16);
        especial = calculador.calcularIEPS(gastoCelular, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoCelular + total));

        System.out.println("*************SERVICIOS DIGITALES************");
        double gastoServicios = 275;
        impuesto = calculador.calcularIVA(gastoServicios, 16);
        especial = calculador.calcularIEPS(gastoServicios, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoServicios + total));

        System.out.println("*************NETFLIX************");
        double gastoNetflix = 219;
        impuesto = calculador.calcularIVA(gastoNetflix, 16);
        especial = calculador.calcularIEPS(gastoNetflix, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoNetflix + total));

        System.out.println("*************Diversion************");
        double gastoDiversion = 2000;
        impuesto = calculador.calcularIVA(gastoDiversion, 16);
        especial = calculador.calcularIEPS(gastoDiversion, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoDiversion + total));

        System.out.println("*************RENTA************");
        double gastoRenta = 3000;
        impuesto = calculador.calcularIVA(gastoRenta, 16);
        especial = calculador.calcularIEPS(gastoRenta, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoRenta + total));

        System.out.println("*************AUTO MENSUALIDAD************");
        double gastoAuto = 8000;
        impuesto = calculador.calcularIVA(gastoAuto, 16);
        especial = calculador.calcularIEPS(gastoAuto, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoAuto + total));

        System.out.println("*************SEGURO************");
        double gastoSeguro = 1000;
        impuesto = calculador.calcularIVA(gastoSeguro, 16);
        especial = calculador.calcularIEPS(gastoSeguro, 0);
        System.out.println("Impuesto:" + impuesto);
        System.out.println("Especial:" + especial);
        System.out.println("Impuesto total:" + (impuesto + especial));
        total = impuesto + especial;
        System.out.println("Total:" + (gastoSeguro + total));
    }

}