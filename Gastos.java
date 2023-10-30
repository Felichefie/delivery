class Gastos{
    private String concepto;
    private double neto;
    private double porcentaje;
    private String tipo;
    private double porcentajeAdicional;

    public Gastos(String concepto, double neto, double porcentaje, String tipo) {
        this.concepto = concepto;
        this.neto = neto;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }
//Hay unos que si llevan porcentaje adicional 
    public Gastos(String concepto, double neto, double porcentaje, String tipo, double porcentajeAdicional) {
        this.concepto = concepto;
        this.neto = neto;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
        this.porcentajeAdicional = porcentajeAdicional;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public double getNeto() {
        return neto;
    }
    public void setNeto(double neto) {
        this.neto = neto;
    }
    public double getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getPorcentajeAdicional() {
        return porcentajeAdicional;
    }
    public void setPorcentajeAdicional(double porcentajeAdicional) {
        this.porcentajeAdicional = porcentajeAdicional;
    }

}