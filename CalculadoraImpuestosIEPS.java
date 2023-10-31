import java.util.ArrayList;
import java.util.List;

public class CalculadoraImpuestosIEPS {
    public static void main(String[] args) {
        double salarioMensual = 50000.0; 
        double impuestosTotales = 0.0;
        double GastosSinImpuestos = 4028400;
        System.out.println("INGRESOS: " + salarioMensual);
        System.out.println("Gastos sin impuestos: " + GastosSinImpuestos);

        // Impuesto de tabaco
        double impuestoTabaco = 0.5911;
        double cajetilla = 20 *impuestoTabaco;

        // Impuesto de alcohol (cerveza)
        double impuestoCerveza = 0.265;
        double gastosCerveza = 2 * 100.0;


        // IMPUESTO A BEBIDABAS SABORIZADAS
        double impuestoBebidasSaborizadas = 1.50; // por litro

        // IMPUESTO A GASOLINAS
        double impuestoGasolinaMagna = 5.91; // por litro
        double impuestoGasolinaPremium = 4.99; // por litro
        double impuestoDiesel = 5.50; // por litro

        // GASTOS MENSUALES
        double gastosSuper = 12000.0;
        double gastosCoca = 12 * 20.0; 
        double gastosTabaco = 1 *cajetilla;
        double gastosGasolina = 2 * 40 * impuestoGasolinaPremium; 
        double gastosBoletoAvion = 3000.0 + 1000.0 + (0.16 * 2000.0); 
        double gastosHotel = 3 * 2000.0; 
        double gastosViveresTijuana = 1000.0; 
        double gastosServicios = 250.0 + 150.0 + 500.0 + 400.0 + 275.0 + 219.0; 
        double gastosAdicionales = 2000.0 + 3000.0 + 8000.0 + 1000.0; 
       
        

        // Calcula los impuestos totales
        impuestosTotales = gastosSuper * 0.16 + gastosCerveza * impuestoCerveza + gastosCoca * impuestoBebidasSaborizadas
                + gastosTabaco + gastosGasolina + gastosBoletoAvion + gastosHotel + gastosViveresTijuana
                + gastosServicios * 0.16;
        double salarioDespuesImpuestos = salarioMensual - impuestosTotales;

        // Imprime los resultados
        System.out.println("Impuestos Totales: " + impuestosTotales + " pesos");
        System.out.println("Salario después de impuestos: " + salarioDespuesImpuestos + " pesos");


//CALCULA EL IMPUESTO DEL IVA   
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("VIveres", 12000.0, 0.16));  
        productos.add(new Producto("Cerveza", 200.0, 0.16)); 
        productos.add(new Producto("Refrescos", 240, 0.16));
        productos.add(new Producto("Cigarros", 50, 0.16));
        productos.add(new Producto("Gasolina", 2000, 0.16));
        productos.add(new Producto("Avion", 3000, 0.16));
        productos.add(new Producto("Hotel", 6000, 0.16));
        productos.add(new Producto("Comida fuera", 1000, 0.16));
        productos.add(new Producto("Energia electrica", 250, 0.16));
        productos.add(new Producto("Agua", 150, 0.16));
        productos.add(new Producto("Internet", 500, 0.16));
        productos.add(new Producto("Celular", 400, 0.16));
        productos.add(new Producto("Servivios digitales", 275, 0.16));
        productos.add(new Producto("Netflix", 219, 0.16));
        productos.add(new Producto("Diversion",2000, 0.16));
        productos.add(new Producto("Renta", 3000, 0.16));
        productos.add(new Producto("Aunto mensualidad", 8000, 0.16));
        productos.add(new Producto("Seguro auto", 1000, 0.16));
        double ImpuestoIva = calculadoraImpuestos(productos);
        System.out.println("IMPUESTO DEL IVA ES: " + ImpuestoIva);

        double impuestosIepsTotales = CalculadoraImpuestosIEPS();
        System.out.println("Impuestos IEPS: " + impuestosIepsTotales);
        


        

    }
    
    
    //metodo para calcular el Impuesto iva
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

        //CALCULO DE IEPS
        public static double CalculadoraImpuestosIEPS(){
            double impuestoTabaco = 0.5911;
            double cajetilla = 20 *impuestoTabaco;
            double impuestoCerveza = 200 * 0.265;
            double impuestoBebidasSaborizadas = 240 * 1.50;
            double impuestoGasolina = 2 * 40 * 4.99; 

                double ivaHotel = 6000 * 0.04;
                double ivaBoleto = (1000/3000)*100;
                double iepsTabaco = cajetilla;
                double iepsCerveza = impuestoCerveza;
                double iepsRefrescos =  impuestoBebidasSaborizadas;
                double iepsGasolina =  impuestoGasolina;
                
                double impuestosIepsTotales = ivaHotel + ivaBoleto + iepsTabaco + iepsCerveza + iepsRefrescos + iepsGasolina;
                return impuestosIepsTotales;

        }

        

        
        
        }



