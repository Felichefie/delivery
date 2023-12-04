import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioDeFrame extends JFrame implements ActionListener {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton boton1, boton2;
    private JPanel panel1, panel2;

    public CambioDeFrame() {
        // Configuración del JFrame principal
        setTitle("Ejemplo de Cambio de Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Inicialización del CardLayout y del panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Creación de los paneles que se mostrarán
        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        // Agregar los paneles al panel principal con un nombre identificador
        panelPrincipal.add(panel1, "Panel 1");
        panelPrincipal.add(panel2, "Panel 2");

        // Botones para cambiar entre paneles
        boton1 = new JButton("Panel 1");
        boton1.addActionListener(this);
        boton2 = new JButton("Panel 2");
        boton2.addActionListener(this);

        // Agregar botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(boton1);
        panelBotones.add(boton2);

        // Agregar componentes al JFrame principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            // Mostrar el Panel 1 al presionar el botón 1
            cardLayout.show(panelPrincipal, "Panel 1");
        } else if (e.getSource() == boton2) {
            // Mostrar el Panel 2 al presionar el botón 2
            cardLayout.show(panelPrincipal, "Panel 2");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CambioDeFrame ventana = new CambioDeFrame();
            ventana.setVisible(true);
        });
    }
}

