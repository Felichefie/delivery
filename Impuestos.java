public class Impuestos {
    
        // VARIABLES PARA DETERMINAR EL VALOR DE CADA UNO DE LOS IMPUESTOS:
        private double iva_general = 0.16;
        private double iva_salud_educacion = 0.0;
        private double iva_fronteriza = 0.08;
        private double impuesto_nomina_mich = 0.03;
        private double impuesto_hoteleria_bc = 0.04;
        private double impuesto_cigarro = 0.5911;
        private double impuesto_cerveza = 0.265;
        private double impuesto_refrescos = 1.50;
        private double impuesto_gasolina_m = 5.91;
        private double impuesto_gasolina_p = 4.99;
        private double impuesto_diesel = 5.50;

        private double salarioMensual = 50000;
    
        // Constructor principal
        public Impuestos() {
        }
    
        // Métodos para el cálculo del impuesto de IVA
        public double calcIva(double monto, String tipoProducto) {
            double gastoSuper = 12000; // Gasto mensual en el supermercado
            double ivaSuper = gastoSuper * 0.16; // IVA del supermercado
            return ivaSuper;
        }
    
        public double calcularImpuestoNomina(double salario, String estado) {
            if ("Michoacán".equalsIgnoreCase(estado)) {
                return salario * impuesto_nomina_mich;
            } else {
                return 0.0;
            }
        }
    
        public double calcularImpuestoHoteleria(double monto, String estado) {
            if ("Baja California".equalsIgnoreCase(estado)) {
                return monto * impuesto_hoteleria_bc;
            } else {
                return 0.0;
            }
        }
    
        public double calcularImpuestoRenta(double salario) {
            // Implementa aquí la lógica de cálculo de impuesto sobre la renta
            // basado en la tabla de tasas y rangos.

                       // Tabla de ISR
                       if (salarioMensual <= 10000) {
                        return salarioMensual * 0.1; // 10%
                    } else if (salarioMensual <= 20000) {
                        return salarioMensual * 0.15; // 15%
                    } else {
                        return salarioMensual * 0.2; // 20%
                    }
        }
    
        public double calcularIEPS(String tipoProducto, double cantidad) {
            double ieps = 0.0;
            switch (tipoProducto) {
                case "tabaco":
                    ieps = cantidad * impuesto_cigarro;
                    break;
                case "cerveza":
                    ieps = cantidad * impuesto_cerveza;
                    break;
                case "refrescos":
                    ieps = cantidad * impuesto_refrescos;
                    break;
                case "gasolina_magna":
                    ieps = cantidad * impuesto_gasolina_m;
                    break;
                case "gasolina_premium":
                    ieps = cantidad * impuesto_gasolina_p;
                    break;
                case "diesel":
                    ieps = cantidad * impuesto_diesel;
                    break;
            }
            return ieps;
        }
    
        public static void main(String[] args) {
            Impuestos calculadora = new Impuestos();
            double monto = 1000.0;
            String tipoProducto = "general";
            String estado = "Michoacán";
            double salario = 50000.0;
            String productoIEPS = "cerveza";
            double cantidadIEPS = 10.0;
    
            double iva = calculadora.calcIva(monto, tipoProducto);
            double impuestoNomina = calculadora.calcularImpuestoNomina(salario, estado);
            double impuestoHoteleria = calculadora.calcularImpuestoHoteleria(monto, estado);
            double impuestoRenta = calculadora.calcularImpuestoRenta(salario);
            double ieps = calculadora.calcularIEPS(productoIEPS, cantidadIEPS);
    
            System.out.println("EL IVA TOTAL (AL MES) ES DE: " + iva);
            System.out.println("EL IMPUESTO DE NOMINA TOTAL (AL MES) ES: " + impuestoNomina);
            System.out.println("EL IMPUESTO DE HOTELERIA TOTAL (AL MES) ES DE: " + impuestoHoteleria);
            System.out.println("EL IMPUESTO TOTAL (AL MES) SOBRE LA RENTA ES DE: " + impuestoRenta);
            System.out.println("EL IMPUESTO DE IEPS TOTAL (AL MES) E DE: " + ieps);
        }
    }
