package Proyecto;

import javax.swing.JFrame;

public class Principal {
    public void mostrar() {
        // Crear un nuevo JFrame
        JFrame frame = new JFrame("Principal con pestañas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de Dbconnection
        Dbconnection dbConnection = new Dbconnection();

        // Crear una instancia de Pestañas y agregarla al JFrame
        Pestañas pestañas = new Pestañas(dbConnection);
        frame.add(pestañas);

        // Configurar el tamaño del JFrame y hacerlo visible
        frame.setBounds(280, 75, 800, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.mostrar();
            }
        });
    }
}