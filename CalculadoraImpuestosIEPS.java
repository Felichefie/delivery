import java.util.ArrayList;
import java.util.List;

public class CalculadoraImpuestosIEPS {
    public static void main(String[] args) {
        double salarioMensual = 50000.0; // Salario mensual de 50,000 pesos
        double impuestosTotales = 0.0;

        // Impuesto de tabaco
        double impuestoTabaco = 0.5911;
        double cajetilla = 20 *impuestoTabaco;

        // Impuesto de alcohol (cerveza)
        double impuestoCerveza = 0.265; // 26.5%


        // IMPUESTO A BEBIDABAS SABORIZADAS
        double impuestoBebidasSaborizadas = 1.50; // por litro

        // IMPUESTO A GASOLINAS
        double impuestoGasolinaMagna = 5.91; // por litro
        double impuestoGasolinaPremium = 4.99; // por litro
        double impuestoDiesel = 5.50; // por litro

        // GASTOS MENSUALES
        double gastosSuper = 12000.0; // 16% de IVA
        double gastosCerveza = 2 * 100.0; // 2 Six Pack de cervezas
        double gastosCoca = 12 * 20.0; // 12 latas de coca
        //double gastosTabaco = 1 * impuestoTabaco; // 1 cajetilla de cigarros
        double gastosTabaco = 1 *cajetilla;
        double gastosGasolina = 2 * 40 * impuestoGasolinaPremium; // 2 llenados de gasolina Premium
        double gastosBoletoAvion = 3000.0 + 1000.0 + (0.16 * 2000.0); // Boleto de avión
        double gastosHotel = 3 * 2000.0; // 3 noches de habitación en hotel
        double gastosViveresTijuana = 1000.0; // 16% de IVA
        double gastosServicios = 250.0 + 150.0 + 500.0 + 400.0 + 275.0 + 219.0; // Servicios mensuales
        double gastosAdicionales = 2000.0 + 3000.0 + 8000.0 + 1000.0; // Otros gastos

        // Calcula los impuestos totales
        impuestosTotales = gastosSuper * 0.16 + gastosCerveza * impuestoCerveza + gastosCoca * impuestoBebidasSaborizadas
                + gastosTabaco + gastosGasolina + gastosBoletoAvion + gastosHotel + gastosViveresTijuana
                + gastosServicios * 0.16;

        // Resta los impuestos del salario mensual
        double salarioDespuesImpuestos = salarioMensual - impuestosTotales;

        // Imprime los resultados
        System.out.println("Impuestos Totales: " + impuestosTotales + " pesos");
        System.out.println("Salario después de impuestos: " + salarioDespuesImpuestos + " pesos");

        List<Producto> productos = new ArrayList<>();
        //productos.add(new Producto("VIveres", 100.0, 0.16, 0.05)); // 16% de IVA y 5% de impuesto especial
        //productos.add(new Producto("Cerveza", 50.0, 0.08, 0.0)); // 8% de IVA y sin impuesto especial

        double totalImpuestos = calculadoraImpuestos(productos);

        System.out.println("El total de impuestos es: $" + totalImpuestos);


    }
    public static double calculadoraImpuestos(List<Producto> productos){
            double totalImpuestos = 0.0;

            for(Producto producto: productos){
                double precio = producto.getPrecio();
                double tasaIVA = producto.getTasaIVA();
                double impuestoEspecial = producto.getImpuestoEspecial();
                double iva = precio * tasaIVA;
                double impuestoAdicional = precio * impuestoEspecial;
                totalImpuestos += iva + impuestoAdicional;


            }
            return totalImpuestos;

        }
}
