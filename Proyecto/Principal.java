package Proyecto;

import javax.swing.JFrame;

public class Principal {
    public static void main(String[] args) {
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Principal con pestañas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de Pestañas y agregarla al JFrame
        Pestañas pestañas = new Pestañas();
        frame.add(pestañas);

        // Configurar el tamaño del JFrame y hacerlo visible
        frame.setBounds(280, 75, 800, 600);
        frame.setVisible(true);
    }
}