public class Examn1 {
   double salario = 50000;
    double despensa=12000;
    int precio_cervezas=200;
    int precio_refrescos=240;
    int cantidad_refrescos=12;
    double mililitros refrescos=.355;
    double IEPS litro_refresco=1.5;
    int cigarros=20;
    int precio_cigarros=50;
    int precio_gasolina=2000;
    int litros_gasolina=40;
    int precio_boleto_Avion=3000;
    int precio_hotel=6000;
    int comida_fuera=1000;
    int luz=250;
    int agua=150;
    int telefono=400;
    int servicios_digitales=275;
    int netflix=219;
    int varios=2000;
    int renta=3000;
    int mensualidad_auto=8000;
    int seguro_auto=1000;
    int porcentaje_ISR = 30;
    int porcentaje_IVA = 16;
    int porcentaje_IVA_FRONTERIZO = 8;
    int porcentaje_hotelero=4;
    int TUA = 1000;
    double IEPS_tabaco_unidad = 0.5911;
    double porcentaje_IEPS_alcohol = 26.5;
    double IEPS_gasolina_litro_premium = 4.99;

    public double ISR(double salario, double porcentaje_ISR) {
    return salario * porcentaje_ISR / 100 ;
}
    public double IVA_despensa(double despensa, double porcentaje_IVA) {
    return despensa * porcentaje_IVA / 100 ;
}

    public double IEPS_cervezas(int cantidad_cervezas, int precio_cervezas, double porcentaje_IEPS_alcohol) {
    return precio_cervezas + precio_cervezas * porcentaje_IEPS_alcohol/ 100 + precio_cervezas*porcentaje_IVA/100; ;

    public double IEPS_refrescos(int cantidad_refrescos, int precio_refrescos, double mililitros_refrescos, double IEPS_litro_refresco){
        return precio_refrescos + precio_refrescos*porcentaje_IVA/100; + (cantidad_refrescos*mililitros_refrescos*IEPS_litro_refresco){

        }
    
    public double IEPS_tabaco(int cigarros, int precio_cigarros, double IEPS_tabaco_unidad){
        return precio_cigarros + precio_cigarros*porcentaje_IVA/100; + (cigarros*IEPS_tabaco_unidad){

        }

    public double IEPS_gasolina(int litros_gasolina, int precio_gasolina, double IEPS_gasolina_litro_premium){
        return precio_gasolina + precio_gasolina*porcentaje_IVA/100; + (litros_gasolina*IEPS_gasolina_litro_premium){

        }

    public double IVA_avion(int precio_boleto_Avion,int TUA, int porcentaje_IVA){
        return precio_boleto_Avion + TUA + precio_boleto_Avion*porcentaje_IVA/100;{

            public double IVA_Fronteriza_HOtel(int porcentaje_IVA_FRONTERIZO, int porcentaje_hotelero, int precio_hotel)
            return precio_hotel + precio_hotel*porcentaje_IVA_FRONTERIZO/10 + precio_hotel*porcentaje_hotelero;
        }
}
}

