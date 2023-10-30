class IEPS extends Impuesto {
    private double tasaIEPS;

    public IEPS(double tasaIEPS) {
        this.tasaIEPS = tasaIEPS;
    }

    @Override
    public double calcularImpuesto(double ingresos) {
        return ingresos * tasaIEPS;
    }
}

public class Examn1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el salario base: ");
            double salarioBase = scanner.nextDouble();

            Impuesto iva = new IVA(0.16); // IVA con una tasa del 16%
            Impuesto isr = new ISR(0.32); // ISR con una tasa del 32%
            Impuesto nomina = new Nomina(0.03);

            Salario salario = new Salario(salarioBase);
            salario.aplicarImpuesto(iva);
            salario.aplicarImpuesto(isr);
            salario.aplicarImpuesto(nomina);

            // Calcular IEPS para productos y servicios específicos
            IEPS iepsCerveza = new IEPS(0.265); // Tasa de IEPS para cerveza
            IEPS iepsRefrescos = new IEPS(1.50); // Tasa de IEPS para refrescos
            IEPS iepsCigarros = new IEPS(0.5911); // Tasa de IEPS para cigarros
            IEPS iepsGasolinaPremium = new IEPS(4.99); // Tasa de IEPS para gasolina Premium

            double costoCervezas = 2 * 100; // Costo de 2 Six Pack de cervezas
            double costoRefrescos = 12 * 20; // Costo de 12 latas de refrescos
            double costoCigarros = 1; // Costo de una cajetilla de cigarros
            double costoGasolinaPremium = 2 * 40 * 4.99; // Costo de 2 tanques llenos de gasolina Premium

            salario.aplicarImpuesto(iepsCerveza.calcularImpuesto(costoCervezas));
            salario.aplicarImpuesto(iepsRefrescos.calcularImpuesto(costoRefrescos));
            salario.aplicarImpuesto(iepsCigarros.calcularImpuesto(costoCigarros));
            salario.aplicarImpuesto(iepsGasolinaPremium.calcularImpuesto(costoGasolinaPremium));

            // Agregar otros gastos y servicios

            // ...

            double salarioDespuesImpuestos = salario.obtenerSalarioDespuesImpuestos();
            double impuestoTotal = salario.obtenerImpuestoTotal();

            System.out.println("Salario después de impuestos: " + salarioDespuesImpuestos);
            System.out.println("Impuesto total: " + impuestoTotal);
        }
    }
}