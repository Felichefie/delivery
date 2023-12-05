import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioDeFrame extends JFrame implements ActionListener {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonTienda, botonUser;
    private TiendaSwing tiendaPanel;
    private User userPanel;

    public CambioDeFrame() {
        // Configuración del JFrame principal
        setTitle("Ejemplo de Cambio de Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);

        // Inicialización del CardLayout y del panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Creación de los paneles que se mostrarán
        tiendaPanel = new TiendaSwing();
        userPanel = new User();

        // Agregar los paneles al panel principal con un nombre identificador
        panelPrincipal.add(tiendaPanel, "Tienda Panel");
        panelPrincipal.add(userPanel, "User Panel");

        // Botones para cambiar entre paneles
        botonTienda = new JButton("Panel 1");
        botonTienda.addActionListener(this);
        botonUser = new JButton("Panel 2");
        botonUser.addActionListener(this);

        // Agregar botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonTienda);
        panelBotones.add(botonUser);


        // Agregar componentes al JFrame principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonTienda) {
            // Mostrar el Panel 1 al presionar el botón 1
            cardLayout.show(panelPrincipal, "TiendaSwing");
        } else if (e.getSource() == botonUser) {
            // Mostrar el Panel de User al presionar el botón de User
            cardLayout.show(panelPrincipal, "User Panel");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CambioDeFrame ventana = new CambioDeFrame();
            ventana.setVisible(true);
        });
    }
}

