import java.util.Scanner;

//Calcula impuestos del salario
class Impuesto {
    public double calcularImpuesto(double ingresos) {
        return 0;
    }
}

// IVA
class IVA extends Impuesto {
    private double tasaIVA;

    public IVA(double tasaIVA) {
        this.tasaIVA = tasaIVA;
    }

    @Override
    public double calcularImpuesto(double ingresos) {
        return Double.parseDouble(String.format("%.2f", ingresos * tasaIVA));
    }
}

// ISR
class ISR extends Impuesto {
    private double tasaISR;

    public ISR(double tasaISR) {
        this.tasaISR = tasaISR;
    }

    @Override
    public double calcularImpuesto(double ingresos) {
        return Double.parseDouble(String.format("%.2f", ingresos * tasaISR));
    }
}

// Nomina
class Nomina extends Impuesto {
    private double tasaNomina;

    public Nomina(double tasaNomina) {
        this.tasaNomina = tasaNomina;
    }

    @Override
    public double calcularImpuesto(double ingresos) {
        return Double.parseDouble(String.format("%.2f", ingresos * tasaNomina));
    }
}

// IEPS
class IEPS extends Impuesto {
    private double tasaIEPS;

    public IEPS(double tasaIEPS) {
        this.tasaIEPS = tasaIEPS;
    }

    @Override
    public double calcularImpuesto(double ingresos) {
        return Double.parseDouble(String.format("%.2f", ingresos * tasaIEPS));
    }
}

// Salario
class Salario {
    public double salarioBase;
    public double impuestoTotal;

    public Salario(double salarioBase) {
        this.salarioBase = salarioBase;
        this.impuestoTotal = 0;
    }

    public void aplicarImpuesto(Impuesto impuesto) {
        double impuestoCalculado = Double.parseDouble(String.format("%.2f", impuesto.calcularImpuesto(salarioBase)));
        impuestoTotal += impuestoCalculado;
        salarioBase = Double.parseDouble(String.format("%.2f", salarioBase - impuestoCalculado));
    }

    public double obtenerSalarioDespuesImpuestos() {
        return salarioBase;
    }

    public double obtenerImpuestoTotal() {
        return impuestoTotal;
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce el salario base mensual: ");
            double salarioBase = scanner.nextDouble();

            Impuesto iva = new IVA(0.16); // IVA con una tasa del 16%
            Impuesto isr = new ISR(0.32); // ISR con una tasa del 32%
            Impuesto nomina = new Nomina(0.03); // Nomina con una tasa del 3%

            Salario salario = new Salario(salarioBase);
            salario.aplicarImpuesto(iva);
            salario.aplicarImpuesto(isr);
            salario.aplicarImpuesto(nomina);

            IEPS iepsCerveza = new IEPS(0.16); // Chelas con una tasa del 16%
            IEPS iepsRefrescos = new IEPS(0.16); // Chescos con una tasa del 16%
            IEPS iepsCigarros = new IEPS(0.16); // Cigarros con una tasa del 16%
            IEPS iepsGasolinaPremium = new IEPS(0.16); // Gasolina Premium con una tasa del 16%

            // Costos de los productos
            double costoCervezas = 2 * 100;
            double costoRefrescos = 12 * 20;
            double costoCigarros = 1;
            double costoGasolinaPremium = 2 * 40 * 4.99;
            double costoTotalProductos = costoCervezas + costoRefrescos + costoCigarros + costoGasolinaPremium;

            salario.aplicarImpuesto(iepsCerveza);
            salario.aplicarImpuesto(iepsRefrescos);
            salario.aplicarImpuesto(iepsCigarros);
            salario.aplicarImpuesto(iepsGasolinaPremium);

            double salarioDespuesImpuestos = salario.obtenerSalarioDespuesImpuestos();
            double impuestoTotal = salario.obtenerImpuestoTotal();

            System.out.println("Salario despues de impuestos: " + String.format("%.2f", salarioDespuesImpuestos));
            System.out.println("Impuesto total: " + String.format("%.2f", impuestoTotal + costoTotalProductos));
        }
    }
}