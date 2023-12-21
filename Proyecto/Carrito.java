package Proyecto;

public class Carrito {
    double subtotal;

    public Carrito() {
        this.subtotal = 0;
    }

    public void agregar(double c) {
        subtotal = subtotal + c;
    }

    public double getSubtotal() {
        return subtotal;
    }
}// a