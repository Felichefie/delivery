//ESTE SI ES EL BUENOOOOO, JAJA.

public class Totalimpuestos {

        // VARIABLES
        private double salarioMensual;
    
        // CONSTRUCTOR PRINCIPAL
        public Totalimpuestos(double salarioMensual) {
            this.salarioMensual = salarioMensual;
        }
    
        // METODO PARA CALCULAR EL IMPUESTO DEL IVA.
        public double calcularIVA() {
            double gastoSuper = 29784; // GASTO MENSUAL DE SUPER Y OTRAS COSAS QUE LLEVAN IVA.
            double ivaSuper = gastoSuper * 0.16; // IVA DE SUPERRRR.
            return ivaSuper;

        }
    
        // METODO PARA CALCULAR EL IMPUESTO DE NOMINA EN MICHOACAN.
        public double calcularImpuestoNomina() {
            double impuestoNomina = salarioMensual * 0.03; //.3%.
            return impuestoNomina;
        }

    
        // METODO PARA CALCULAR LOS IMPUESTOS DE HOTELERIA EN BAJA CALIFORNIA.
        public double calcularImpuestoHoteleria() {
            double costoHospedaje = 3 * 2000; // 3 noches de hospedaje.
            double impuestoHoteleria = costoHospedaje * 0.04; //4%
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
    
        // METODO PARA CALCULAR EL IMPUESTO IEPS.
        public double calcularIEPS() {
            double impuestoTabaco = 1 * 0.5911; // cigarros
            double impuestoCerveza = 2 * 100 * 0.265; // Six de cervezas
            double impuestoRefrescos = 12 * 0.355 * 20 * 1.5; //refrescos
            return impuestoTabaco + impuestoCerveza + impuestoRefrescos;
        }
    
        // METODO PARA CALCULAR EL IMPUESTO DE LA GASOLINA.
        public double calcularImpuestoGasolina() {
            double litrosGasolina = 2 * 40; // Gasolina Premium
            double impuestoGasolina = litrosGasolina * 4.99;
            return impuestoGasolina;
        }
    
        // METODO PARA CALCULAR EL IMPUESTO TOTAL A PAGAR AL MES.
        public double calcularImpuestoTotal() {
            double impuestoTotal = calcularIVA() + calcularImpuestoNomina() 
                                   + calcularImpuestoHoteleria() + calcularISR() + calcularIEPS() 
                                   + calcularImpuestoGasolina();
            return impuestoTotal;
        }
    
        public static void main(String[] args) {
            Totalimpuestos calculadora = new Totalimpuestos(50000);
    
            double impuestoTotal = calculadora.calcularImpuestoTotal();
            System.out.println("Impuesto Total a pagar: " + impuestoTotal);
            
            
        }
    }
    