public class Main {
    public static void main(String[] args) {
        Impuestos salario = new Impuestos(50000.0);
        Impuestos cervezaSix = new Impuestos(16, 26.5, 100 , 2);  
        Impuestos coca = new Impuestos(16, 0.5325, 20, 12, 2);
        Impuestos cajetillaCigarros = new Impuestos(16, 0.5911, 20);
        Impuestos gasolina = new Impuestos(16, 5.91, 2000, 80, 0);
        Impuestos avion = new Impuestos(16, 0, 2000.0);
        Impuestos hotel = new Impuestos(4, 0, 2000 , 3);
        Impuestos viveres = new Impuestos(8, 0, 1000.0);
        Impuestos energiaElectrica = new Impuestos(16, 0, 250.0);
        Impuestos agua = new Impuestos(16, 0, 150.0);
        Impuestos internet = new Impuestos(16, 0, 500.0);
        Impuestos telefono = new Impuestos(16, 0, 300.0);
        Impuestos plataformasDigitales = new Impuestos(16, 0, 275.0);
        Impuestos netflix = new Impuestos(16, 0, 219.0);
        Impuestos cineRestaurant = new Impuestos(16, 0, 2000.0);
        Impuestos renta = new Impuestos(16, 0, 3000.0);
        Impuestos auto = new Impuestos(16, 0, 8000.0);
        Impuestos seguroAuto = new Impuestos(16, 0, 1000.0);

        System.out.println("Cerveza: " + cervezaSix.calcularImpuestos());
        System.out.println("Coca: " + (coca.calcularImpuestos()));
        System.out.println("Cajetilla de cigarros: " + cajetillaCigarros.calcularImpuestos());
        System.out.println("Gasolina: " + gasolina.calcularImpuestos());
        System.out.println("Avion: " + avion.calcularImpuestos());
        System.out.println("Hotel: " + hotel.calcularImpuestos());
        System.out.println("Viveres: " + viveres.calcularImpuestos());
        System.out.println("Energia electrica: " + energiaElectrica.calcularImpuestos());
        System.out.println("Agua: " + agua.calcularImpuestos());
        System.out.println("Internet: " + internet.calcularImpuestos());
        System.out.println("Telefono: " + telefono.calcularImpuestos());
        System.out.println("Plataformas digitales: " + plataformasDigitales.calcularImpuestos());
        System.out.println("Netflix: " + netflix.calcularImpuestos());
        System.out.println("Cine y restaurantes: " + cineRestaurant.calcularImpuestos());
        System.out.println("Renta: " + renta.calcularImpuestos());
        System.out.println("Auto: " + auto.calcularImpuestos());
        System.out.println("Seguro de auto: " + seguroAuto.calcularImpuestos());

        System.out.println("ISR: " + salario.calcularISR());

        double impuestosTotales = cervezaSix.calcularImpuestos() + coca.calcularImpuestos() + cajetillaCigarros.calcularImpuestos() 
        + gasolina.calcularImpuestos() + avion.calcularImpuestos() + hotel.calcularImpuestos() + viveres.calcularImpuestos() 
        + energiaElectrica.calcularImpuestos() + agua.calcularImpuestos() + internet.calcularImpuestos() + telefono.calcularImpuestos() 
        + plataformasDigitales.calcularImpuestos() + netflix.calcularImpuestos() + cineRestaurant.calcularImpuestos() 
        + renta.calcularImpuestos() + auto.calcularImpuestos() + seguroAuto.calcularImpuestos() + salario.calcularISR();

        System.out.println("Impuestos totales: " + impuestosTotales);

    }
}
