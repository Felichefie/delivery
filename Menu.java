import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    private static final String contraseña = null;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonTienda, botonUser, botonDir, botonPagar;
    private TiendaPanel carritoPanel;
    private User userPanel;
    private Dir dirPanel;
    private Pago pagoVentana;

    public Menu() {
        // Configuración del JFrame principal
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);

        // Inicialización del CardLayout y del panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Creación de los paneles que se mostrarán
        carritoPanel = new TiendaPanel(contraseña);
        userPanel = new User();
        dirPanel = new Dir();

        // Agregar los paneles al panel principal con un nombre identificador
        panelPrincipal.add(carritoPanel, "CarritoTienda");
        panelPrincipal.add(userPanel, "User Panel");
        panelPrincipal.add(dirPanel, "Direccion");

        // Botones para cambiar entre paneles
        botonTienda = new JButton("Tienda");
        botonTienda.addActionListener(this);
        botonUser = new JButton("Datos");
        botonUser.addActionListener(this);
        botonDir = new JButton("Direccion");
        botonDir.addActionListener(this);
        botonPagar = new JButton("Pagar");
        botonPagar.addActionListener(this);

        // Agregar botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonTienda);
        panelBotones.add(botonUser);
        panelBotones.add(botonDir);
        panelBotones.add(botonPagar);


        // Agregar componentes al JFrame principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);

        pagoVentana = new Pago(carritoPanel);
        carritoPanel.setPagoVentana(pagoVentana);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonTienda) {
            // Mostrar el Panel 1 al presionar el botón 1
            cardLayout.show(panelPrincipal, "CarritoTienda");
        } else if (e.getSource() == botonUser) {
            // Mostrar el Panel de User al presionar el botón de User
            cardLayout.show(panelPrincipal, "User Panel");
        }
         else if (e.getSource() == botonDir){
            cardLayout.show(panelPrincipal, "Direccion");
         }
         else if (e.getSource() == botonPagar){
            pagoVentana.setVisible(true);
         }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu ventana = new Menu();
            ventana.setVisible(true);
        });
    }
}

