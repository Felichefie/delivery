import java.util.Scanner;

public class evaluacion1 {
    private double ingresoMensual;
    private String concepto;
    private double porcentajeImpuesto;
    private double impuestoEspecial;
    private String tipoImpuesto;

    private double[][] tabla = {
        {0.01, 0.02, 0, 1.92},
        {368.11, 736.22, 7.05, 6.4},
        {3124.36, 6248.72, 183.45, 10.88},
        {5490.76, 10981.52, 441, 16},
        {6382.81, 12765.62, 583.65, 17.92},
        {7641.91, 15283.82, 809.25, 21.36},
        {15412.81, 30825.62, 2469.15, 23.52},
        {24292.66, 48585.32, 4557.75, 30},
        {46378.51, 92757.02, 11183.40, 32},
        {61838.11, 123676.22, 16130.55, 34},
        {185514.31, 371028.62, 58180.35, 35}
    };


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

