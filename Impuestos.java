public class Impuestos {
    // Atributos
    private double salarioMensual;

    // Constructor
    public Impuestos(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    // Método para calcular el impuesto IVA
    public double calcularIVA() {
        double gastoSuper = 29700; // Gasto mensual en el supermercado
        double ivaSuper = gastoSuper * 0.16; // IVA del supermercado
        return ivaSuper;
    }

    // Método para calcular el impuesto de nómina (solo para Michoacán)
    public double calcularImpuestoNomina() {
        // Impuesto de nómina en Michoacán (3%)
        double impuestoNomina = salarioMensual * 0.03;
        return impuestoNomina;
    }

    // Método para calcular el impuesto de hotelería (solo para Baja California)
    public double calcularImpuestoHoteleria() {
        // Impuesto de hotelería en Baja California (4% sobre el cobro del hospedaje)
        double costoHospedaje = 3 * 2000; // 3 noches de hospedaje a 2000 pesos por noche
        double impuestoHoteleria = costoHospedaje * 0.04;
        return impuestoHoteleria;
    }

    // Método para calcular el impuesto sobre la renta
    public double calcularISR() {
        // Tabla de ISR
        if (salarioMensual <= 10000) {
            return salarioMensual * 0.1; // 10%
        } else if (salarioMensual <= 20000) {
            return salarioMensual * 0.15; // 15%
        } else {
            return salarioMensual * 0.2; // 20%
        }
    }

    // Método para calcular el impuesto IEPS
    public double calcularIEPS() {
        double impuestoTabaco = 1 * 0.5911; // 1 cajetilla de cigarros
        double impuestoCerveza = 2 * 100 * 0.265; // 2 Six Pack de cervezas
        double impuestoRefrescos = 12 * 0.355 * 20 * 1.5; // 12 latas de refrescos
        return impuestoTabaco + impuestoCerveza + impuestoRefrescos;
    }

    // Método para calcular el impuesto a la gasolina
    public double calcularImpuestoGasolina() {
        double litrosGasolina = 2 * 40; // 2 llenadas de gasolina Premium a 40 litros por llenada
        double impuestoGasolina = litrosGasolina * 4.99; // Impuesto de gasolina Premium
        return impuestoGasolina;
    }

    // Método para calcular el impuesto total
    public double calcularImpuestoTotal() {
        double impuestoTotal = calcularIVA() + calcularImpuestoNomina() + calcularImpuestoHoteleria() + calcularISR() + calcularIEPS() + calcularImpuestoGasolina();
        return impuestoTotal;
    }

    public static void main(String[] args) {
        Impuestos calculadora = new Impuestos(50000);

        double impuestoTotal = calculadora.calcularImpuestoTotal();
        System.out.println("Impuesto Total a pagar: " + impuestoTotal);
    }
}
