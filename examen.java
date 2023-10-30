public class examen {

    public static void main(String[] args) {
        /*Guia de cases
         * 1 - IVA
         * 2 - Salud / Educacion / Agua
         * 3 - Fronterizo
         * 4 - Nomina
         * 5 - Hoteleria
         * 6 - Renta
         * 7 - Impuesto de tabaco
         * 8 - Impuesto de alcohol (cerveza)
         * 9 - Impuesto de bebidas saborizadas
         * 10 - Impuesto de gasolina Magna
         * 11 - Impuesto de gasolina Premium
         * 12 - Impuesto de gasolina Diesel
         */

         //Para calcular un impuesto se debe crear un objeto de la clase Impuestos
         //El constructor de la clase Impuestos recibe dos parametros: monto y tipo de impuesto
         //El tipo de impuesto se debe ingresar como un entero
         //El monto se puede ingresar como un double
         //Ejemplo: Impuestos Iva = new Impuestos(1000, 1);
        Impuestos Salario = new Impuestos(50000, 6);
        Impuestos Viveres = new Impuestos(12000, 1);
        Impuestos Cerveza = new Impuestos(200, 8);
        Impuestos Refresco = new Impuestos(240, 9);
        Impuestos Cigarros = new Impuestos(50, 7);
        Impuestos Gasolina = new Impuestos(2000, 11);
        Impuestos IvaFronterizo = new Impuestos(1000, 3);
        Impuestos IvaEnergia = new Impuestos(250, 1);
        Impuestos IvaAgua = new Impuestos(150, 2);
        Impuestos IvaInternet = new Impuestos(500, 1);
        Impuestos IvaTelefonia = new Impuestos(400, 1);
        Impuestos IvaServiciosD = new Impuestos(275, 1);
        Impuestos IvaNetflix = new Impuestos(219, 1);
        Impuestos IvaDiversion = new Impuestos(2000, 1);
        Impuestos IvaRenta = new Impuestos(3000, 1);
        Impuestos IvaAuto = new Impuestos(8000, 1);
        Impuestos IvaSeguroA = new Impuestos(1000, 1);


        System.out.println("Salario - Impuesto: $" + Salario.calcularImpuesto());
        System.out.println("Viveres - Impuesto: $" + Viveres.calcularImpuesto());
        System.out.println("Cerveza - Impuesto: $" + Cerveza.calcularImpuesto());
        System.out.println("Refrescos - Impuesto: $" + Refresco.calcularImpuesto());
        System.out.println("Cigarros - Impuesto: $" + Cigarros.calcularImpuesto());
        System.out.println("Gasolina - Impuesto: $" + Gasolina.calcularImpuesto());
        System.out.println("Comida Fuera - Impuesto: $" + IvaFronterizo.calcularImpuesto());
        System.out.println("Energia electrica - Impuesto: $" + IvaEnergia.calcularImpuesto());
        System.out.println("Agua - Impuesto: $" + IvaAgua.calcularImpuesto());
        System.out.println("Internet - Impuesto: $" + IvaInternet.calcularImpuesto());
        System.out.println("Celular - Impuesto: $" + IvaTelefonia.calcularImpuesto());
        System.out.println("Servicios Digitales - Impuesto: $" + IvaServiciosD.calcularImpuesto());
        System.out.println("Netflix - Impuesto: $" + IvaNetflix.calcularImpuesto());
        System.out.println("Diversion - Impuesto: $" + IvaDiversion.calcularImpuesto());
        System.out.println("Renta - Impuesto: $" + IvaRenta.calcularImpuesto());
        System.out.println("Auto mensualidad - Impuesto: $" + IvaAuto.calcularImpuesto());
        System.out.println("Seguro auto - Impuesto: $" + IvaSeguroA.calcularImpuesto());
    }
}