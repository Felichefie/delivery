import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame implements ActionListener {
    private static final String contraseña = null;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private JButton botonTienda, botonTarjeta, botonTarjetas,botonDir, botonPagar, botonSiguiente;
    private int currentIndex = 0;
    private TiendaPanel tiendaPanel;
    private TarjetaPanel tarjetaPanel;
    private Dir dirPanel;
    private Pago pagoVentana;
    private TarjetaCDPanel metodoPanel;
    private String [] ordenPaneles = {"Tienda Panel", "TarjetaPanel","TarjetaCDPanel", "Dir"};

    public Menu() {
        // Configuración del JFrame principal
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);

        // Inicialización del CardLayout y del panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Creación de los paneles que se mostrarán
        tiendaPanel = new TiendaPanel(contraseña);
        tarjetaPanel = new TarjetaPanel();
        dirPanel = new Dir();
        metodoPanel = new TarjetaCDPanel();

        // Agregar los paneles al panel principal con un nombre identificador
        panelPrincipal.add(tiendaPanel, "TiendaPanel");
        panelPrincipal.add(tarjetaPanel, "TarjetaPanel");
        panelPrincipal.add(dirPanel, "Dir");
        panelPrincipal.add(metodoPanel, "TarjetaCDPanel");

        // Botones para cambiar entre paneles
        botonTienda = new JButton("Tienda");
        botonTienda.addActionListener(this);
        botonTarjeta = new JButton("Tarjeta");
        botonTarjeta.addActionListener(this);
        botonTarjetas = new JButton("Tarjetas");
        botonTarjetas.addActionListener(this);
        botonDir = new JButton("Direccion");
        botonDir.addActionListener(this);
        botonPagar = new JButton("Pagar");
        botonPagar.addActionListener(this);
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.addActionListener(this);
        botonSiguiente.setVisible(true);
        


        // Agregar botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonTienda);
        panelBotones.add(botonTarjeta);
        panelBotones.add(botonTarjetas);
        panelBotones.add(botonDir);
        panelBotones.add(botonPagar);
        panelBotones.add(botonSiguiente);


        // Agregar componentes al JFrame principal
        add(panelBotones, BorderLayout.NORTH);
        add(panelPrincipal, BorderLayout.CENTER);

        pagoVentana = new Pago(tiendaPanel);
        tiendaPanel.setPagoVentana(pagoVentana);

        pagoVentana.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing (WindowEvent e) {
            JOptionPane.showMessageDialog(Menu.this, "Compra cancelada");
            pagoVentana.dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonTienda) {
            // Mostrar el Panel 1 al presionar el botón 1
            cardLayout.show(panelPrincipal, "TiendaPanel");
        } else if (e.getSource() == botonTarjeta) {
            // Mostrar el Panel de User al presionar el botón de User
            cardLayout.show(panelPrincipal, "TarjetaPanel");
        }
         else if (e.getSource() == botonTarjetas) {
            cardLayout.show(panelPrincipal, "TarjetaCDPanel");
         }
         else if (e.getSource() == botonDir){
            cardLayout.show(panelPrincipal, "Dir");
         }
         else if (e.getSource() == botonPagar){
            pagoVentana.setVisible(true);
         }
         else if (e.getSource() == botonSiguiente) {
            if (currentIndex < ordenPaneles.length -1){
                cardLayout.show(panelPrincipal, ordenPaneles[++currentIndex]);
            }

         }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu ventana = new Menu();
            ventana.setVisible(true);
        });
    }
}

