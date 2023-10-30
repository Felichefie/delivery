import java.util.Scanner;

public class evaluacion1 {
    private double ingresoMensual;
    private String concepto;
    private double porcentajeImpuesto;
    private double impuestoEspecial;
    private String tipoImpuesto;

    // Constructor
    public evaluacion1(double ingresoMensual, String concepto, double porcentajeImpuesto, double impuestoEspecial, String tipoImpuesto) {
        this.ingresoMensual = ingresoMensual;
        this.concepto = concepto;
        this.porcentajeImpuesto = porcentajeImpuesto;
        this.impuestoEspecial = impuestoEspecial;
        this.tipoImpuesto = tipoImpuesto;
    }

    // Método para calcular impuestos especiales
    public double calcularImpuestoEspecial() {
        return ingresoMensual * (porcentajeImpuesto / 100) + impuestoEspecial;
    }

    // Método para obtener el tipo de impuesto
    public String obtenerTipoImpuesto() {
        return tipoImpuesto;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ingreso mensual: ");
        double ingresoMensual = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el concepto: ");
        String concepto = scanner.nextLine();

        System.out.print("Ingrese el porcentaje de impuesto: ");
        double porcentajeImpuesto = scanner.nextDouble();

        System.out.print("Ingrese el impuesto especial: ");
        double impuestoEspecial = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el tipo de impuesto: ");
        String tipoImpuesto = scanner.nextLine();

        evaluacion1 calculadora = new evaluacion1(ingresoMensual, concepto, porcentajeImpuesto, impuestoEspecial, tipoImpuesto);
        double impuestoEspecialCalculado = calculadora.calcularImpuestoEspecial();
        String tipoImpuestoObtenido = calculadora.obtenerTipoImpuesto();

        System.out.println("Impuesto especial calculado: " + impuestoEspecialCalculado);
        System.out.println("Tipo de impuesto: " + tipoImpuestoObtenido);
    }
}

