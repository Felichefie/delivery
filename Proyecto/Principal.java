package Proyecto;

import javax.swing.JFrame;

public class Principal {
    public void mostrar() {
        JFrame frame = new JFrame("Principal con pestañas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dbconnection dbConnection = new Dbconnection();

        Pestañas pestañas = new Pestañas(dbConnection);
        frame.add(pestañas);

        frame.setBounds(250, 20, 800, 640);
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
