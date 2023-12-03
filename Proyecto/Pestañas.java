package Proyecto;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pestañas extends JTabbedPane {

    public Pestañas() {
        // Crear los paneles para pestaña 1
        JPanel panel1 = new JPanel();
        panel1.add(new JButton("Button 1"));
        addTab("Pestaña 1", panel1);

        // Crear los paneles para pestaña 2
        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Button 2"));
        addTab("Pestaña 2", panel2);
    }
}