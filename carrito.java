public class carrito {
    double subtotal;

    public carrito(){
        this.subtotal = 0;
    }

    public void agregar(double c){
        subtotal = subtotal + c;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
