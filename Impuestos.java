
import java.util.ArrayList;

public class Impuestos{

    static double calcularIngresos(ArrayList<Gastos> gastos) {
        double ingresos;
        ingresos= 0;
        for (Gastos gasto : gastos) {
            ingresos = ingresos + gasto.getNeto();
        }
        return ingresos;
    }

    static double calcularGastosSinImpuestos(ArrayList<Gastos> gastos) {
        double gastosSinImpuestos;
        gastosSinImpuestos = 0;
        for (Gastos gasto : gastos) {
            if (gasto.getTipo().equals("IVA")) {
                gastosSinImpuestos = gastosSinImpuestos + gasto.getNeto();
            } else {
                gastosSinImpuestos = gastosSinImpuestos + (gasto.getNeto() / (1 + (gasto.getPorcentaje() / 100)));
            }
        }
        return gastosSinImpuestos;
    }

    static double calcularImpuestoIVA(ArrayList<Gastos> gastos) {
        double impuestoIVA;
        impuestoIVA = 0;
        for (Gastos gasto : gastos) {
            if (gasto.getTipo().equals("IVA")) {
                impuestoIVA =  impuestoIVA + ((gasto.getNeto() * gasto.getPorcentaje()) / 100);
            }
        }
        return impuestoIVA;
    }

    static double calcularImpuestoISR(ArrayList<Gastos> gastos) {
        double impuestoISR;
        impuestoISR = 0;
        for (Gastos gasto : gastos) {
            if (gasto.getTipo().equals("ISR")) {
                impuestoISR = impuestoISR + ((gasto.getNeto() * gasto.getPorcentaje()) / 100);
            }
        }
        return impuestoISR;
    }

    static double calcularImpuestoIEPS(ArrayList<Gastos> gastos) {
        double impuestoIEPS;
        impuestoIEPS = 0;
        for (Gastos gasto : gastos) {
            if (gasto.getTipo().equals("IEPS + IVA")) {
                double ieps = (gasto.getNeto() * gasto.getPorcentaje()) / 100;
                double iva = (gasto.getNeto() * gasto.getPorcentajeAdicional()) / 100;
                impuestoIEPS = impuestoIEPS + (ieps + iva);
            }
        }
        return impuestoIEPS;
    }
}


