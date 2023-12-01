package Proyecto;

import javax.swing.JFrame;

public class Principal {
    private JFrame frame;

    public Principal() {
        // Crear un nuevo JFrame
        frame = new JFrame("Principal");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}