package Proyecto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class Principal extends JFrame {
    public Principal() {
        // Crear un nuevo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pestaña principal
        JPanel panelPrincipal = new JPanel();
        tabbedPane.addTab("Principal", panelPrincipal);

        // Pestaña perfil
        JPanel panelPerfil = new JPanel();
        tabbedPane.addTab("Perfil", panelPerfil);

        // Pestaña carrito
        JPanel panelCarrito = new JPanel();
        tabbedPane.addTab("Carrito", panelCarrito);

        // Agregar botón "Metodos de pago" a la pestaña carrito
        JButton botonMetodosPago = new JButton("Metodos de pago");
        botonMetodosPago.setBounds(20, 50, 180, 30);
        botonMetodosPago.addActionListener(e -> {
            // Acciones cuando se hace clic en el botón
            agregar_forma_pago a = new agregar_forma_pago();
        });
        panelCarrito.setLayout(null);
        panelCarrito.add(botonMetodosPago);

        // Configurar el diseño principal
        setLayout(new BorderLayout());
        add(tabbedPane);

        // Configurar el JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(280, 75);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase Principal (que extiende JFrame)
        Principal principalFrame = new Principal();
    }
}
