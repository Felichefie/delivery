import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Gastos> gastos = new ArrayList<>();
        
        gastos.add(new Gastos("Salario", 50000, 30, "ISR"));
        gastos.add(new Gastos("Viveres", 12000, 16, "IVA"));
        gastos.add(new Gastos("Cerveza", 200, 16, "IEPS + IVA", 26.5));
        gastos.add(new Gastos("Refrescos", 240, 16, "IEPS + IVA", 1.5));
        gastos.add(new Gastos("Cigarros", 50, 16, "IEPS + IVA", 0.5911));
        gastos.add(new Gastos("Gasolina", 2000, 16, "IEPS + IVA", 5.91));
        gastos.add(new Gastos("Avión", 3000, 16, "TUA + IVA", 1000));
        gastos.add(new Gastos("Hotel", 6000, 8, "IVA F + HOSPEDAJE", 4));
        gastos.add(new Gastos("Comida fuera", 1000, 8, "IVA F"));
        gastos.add(new Gastos("Energía Eléctrica", 250, 16, "IVA"));
        gastos.add(new Gastos("Agua", 150, 0, "IVA"));
        gastos.add(new Gastos("Internet", 500, 16, "IVA"));
        gastos.add(new Gastos("Celular", 400, 16, "IVA"));
        gastos.add(new Gastos("Servicios Digitales", 275, 16, "IVA"));
        gastos.add(new Gastos("Netflix", 219, 16, "IVA"));
        gastos.add(new Gastos("Diversión", 2000, 16, "IVA"));
        gastos.add(new Gastos("Renta", 3000, 16, "IVA"));
        gastos.add(new Gastos("Auto mensualidad", 8000, 16, "IVA"));
        gastos.add(new Gastos("Seguro auto", 1000, 16, "IVA"));

        
        double ingresos = Impuestos.calcularIngresos(gastos);
        double gastosSinImpuestos = Impuestos.calcularGastosSinImpuestos(gastos);
        double impuestoIVA = Impuestos.calcularImpuestoIVA(gastos);
        double impuestoISR = Impuestos.calcularImpuestoISR(gastos);
        double impuestoIEPS = Impuestos.calcularImpuestoIEPS(gastos);
        double total = ingresos - gastosSinImpuestos - impuestoIVA - impuestoISR - impuestoIEPS;

        System.out.println("Ingresos: $" + ingresos);
        System.out.println("Gastos sin impuestos: $" + gastosSinImpuestos);
        System.out.println("Impuesto IVA: $" + impuestoIVA);
        System.out.println("Impuesto ISR: $" + impuestoISR);
        System.out.println("Impuesto IEPS: $" + impuestoIEPS);
        System.out.println("Total: $" + total);
    }
    
}

   