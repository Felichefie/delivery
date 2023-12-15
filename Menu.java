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
    private JButton botonTienda, botonTarjetas,botonDir, botonPagar;
    private TiendaPanel tiendaPanel;
    private Dir dirPanel;
    private Pago pagoVentana;
    private TarjetaCDPanel metodoPanel;

    public Menu() {
        // Configuración del JFrame principal
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 400);

        //Centramos la ventana en la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);

        // Inicialización del CardLayout y del panel principal
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Creación de los paneles que se mostrarán
        tiendaPanel = new TiendaPanel(contraseña);
        dirPanel = new Dir();
        metodoPanel = new TarjetaCDPanel();

        // Agregar los paneles al panel principal con un nombre identificador
        panelPrincipal.add(tiendaPanel, "TiendaPanel");
        panelPrincipal.add(dirPanel, "Dir");
        panelPrincipal.add(metodoPanel, "TarjetaCDPanel");

        // Botones para cambiar entre paneles
        botonTienda = new JButton("Tienda");
        botonTienda.addActionListener(this);
        botonTarjetas = new JButton("Tarjetas");
        botonTarjetas.addActionListener(this);
        botonDir = new JButton("Direccion");
        botonDir.addActionListener(this);
        botonPagar = new JButton("Pagar");
        botonPagar.addActionListener(this);
        


        // Agregar botones al panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonTienda);
        panelBotones.add(botonTarjetas);
        panelBotones.add(botonDir);
        panelBotones.add(botonPagar);


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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu ventana = new Menu();
            ventana.setVisible(true);
        });
    }
}

