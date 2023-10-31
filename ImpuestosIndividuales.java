public class ImpuestosIndividuales {
    private double SalarioMensual;
    private double GastoSuper;
    private double Cervezas;
    private double Coca;
    private double Cigarros;
    private double Gas;
    private double TicketAvion;
    private double Hotel;
    private double ComidaTij;
    private double Electricidad;
    private double Agua;
    private double Internet;
    private double Celular;
    private double Suscripciones;
    private double Netflix;
    private double Salidas;
    private double Renta;
    private double Auto;
    private double SeguroAuto;

    public ImpuestosIndividuales (double SalarioMensual, double GastoSuper, double Cervezas,
                        double Coca, double Cigarros , double Gas,
                        double TicketAvion, double Hotel, double ComidaTij,
                        double Electricidad, double Agua, double Internet,
                        double Celular, double Suscripciones, double Netflix,
                        double Salidas, double Renta , double Auto,
                        double SeguroAuto) {
        this.SalarioMensual = SalarioMensual;
        this.GastoSuper = GastoSuper;
        this.Cervezas = Cervezas;
        this.Coca = Coca;
        this.Cigarros = Cigarros;
        this.Gas = Gas;
        this.TicketAvion = TicketAvion;
        this.Hotel = Hotel;
        this.ComidaTij = ComidaTij;
        this.Electricidad = Electricidad;
        this.Agua = Agua;
        this.Internet = Internet;
        this.Celular = Celular;
        this.Suscripciones = Suscripciones;
        this.Netflix = Netflix;
        this.Salidas = Salidas;
        this.Renta = Renta;
        this.Auto = Auto;
        this.SeguroAuto = SeguroAuto;
    }

    public double calcularIVA() {
        double iva = GastoSuper * 0.16;
        return iva;
    }

    public double calcularImpuestonomina() {
        double gastosT = GastoSuper + Cervezas + Coca + Cigarros + Gas;
        double ingresosFis = SalarioMensual - gastosT;
        double impuestonomina = ingresosFis * 0.1; 
        return impuestonomina;
    }

    public double calcularImpuestoHotel() {
        double impuestoHotel = Hotel * 0.05; 
        return impuestoHotel;
    }

    public double calcularISR() {
        double gastosT = GastoSuper + Cervezas+ Coca + Cigarros + Gas
                + TicketAvion + Hotel + ComidaTij + Electricidad + Agua
                + Internet + Celular + Suscripciones + Netflix + Salidas
                + Renta + Auto + SeguroAuto;
        double taxableIncome = SalarioMensual - gastosT;
        double isr = taxableIncome * 0.25; 
        return isr;
    }

    public double calcularIEPS() {
        double ieps = Cigarros * 0.05;
        return ieps;
    }

    public static void main(String[] args) {
        ImpuestosIndividuales Calculadora = new ImpuestosIndividuales (50000, 12000, 200, 240, 100, 80, 3000, 6000, 1000, 250, 150, 500, 400, 275, 219, 2000, 3000, 8000, 1000);

        double iva = Calculadora.calcularIVA();
        double impuestonomina = Calculadora.calcularImpuestonomina();
        double impuestoHotel = Calculadora.calcularImpuestoHotel();
        double isr = Calculadora.calcularISR();
        double ieps = Calculadora.calcularIEPS();

        System.out.println("IVA: " + iva);
        System.out.println("Impuesto de Nomina: " + impuestonomina);
        System.out.println("Impuesto de Hotel: " + impuestoHotel);
        System.out.println("ISR: " + isr);
        System.out.println("IEPS: " + ieps);
    }
}