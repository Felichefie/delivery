public class Producto {
    private String nombre;
    private double precio;
    private double tasaIVA;
    private double impuestoEspecial;

    

    public Producto(String nombre, double precio, double tasaIVA, double impuestoAdicional){
        this.nombre = nombre;
        this.precio = precio;
        this.tasaIVA = tasaIVA;
        this.impuestoEspecial = impuestoEspecial;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTasaIVA() {
        return tasaIVA;
    }

    public void setTasaIVA(double tasaIVA) {
        this.tasaIVA = tasaIVA;
    }

    public double getImpuestoEspecial() {
        return impuestoEspecial;
    }

    public void setImpuestoEspecial(double impuestoEspecial) {
        this.impuestoEspecial = impuestoEspecial;
    }

  
    

    

}
