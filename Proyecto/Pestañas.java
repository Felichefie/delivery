package Proyecto;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pestañas extends JTabbedPane {

    public Pestañas() {
        // Crear los paneles para pestaña 1
        JPanel principal = new JPanel();
        addTab("Pestaña Principal", principal);

        // Pestaña Perfil
        JPanel perfil = new JPanel();
        addTab("Pestaña Perfil", perfil);

        // Pestaña del carrito
        JPanel carrito = new JPanel();
        addTab("Pestaña Carrito", carrito);
    }
}