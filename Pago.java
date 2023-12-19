import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pago extends JFrame {

    private JLabel lblSubtotal;
    private JButton btnRealizarPago;
    private TiendaPanel tiendaSwing;
    private JComboBox<String> cmbMetodoPago;

    public Pago(TiendaPanel tiendaSwing) {
        this.tiendaSwing = tiendaSwing;

        // Configuración del JFrame de Pago
        setTitle("Proceso de Pago");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Inicialización de componentes
        lblSubtotal = new JLabel("Subtotal: $" + tiendaSwing.getSubtotal());
        btnRealizarPago = new JButton("Realizar Pago");
        String [] opcionesPago = {"Efectivo", "Tarjeta de Debito", "Tarjeta de Credito"};
        cmbMetodoPago = new JComboBox<>(opcionesPago);

        // Agregar componentes al panel
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(lblSubtotal);
        panel.add(cmbMetodoPago);
        panel.add(btnRealizarPago);

        // Agregar el panel al JFrame
        add(panel, BorderLayout.CENTER);

        // Manejador de eventos para el botón de pago
        btnRealizarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPago();
            }
        });
    }

    public void actualizarSubtotalEnP(double nuevoSubtotal){
        lblSubtotal.setText("Subtotal:  $"+ String.format("%.2f",nuevoSubtotal));
    }

    public void realizarPago() {
        
        double subtotal = tiendaSwing.getSubtotal();
        String metodoPago = (String) cmbMetodoPago.getSelectedItem();

        JOptionPane.showMessageDialog(this, "Pago realizado por un monto de $" + subtotal + "con"+ metodoPago);
        // Cerrar la ventana de Pago
        dispose();
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        SwingUtilities.invokeLater(() -> {
            // Supongamos que ya tienes una instancia de TiendaSwing
            TiendaPanel tiendaSwing = new TiendaPanel("contraseña");
            double subtotal = tiendaSwing.getSubtotal();
            System.out.println("Subtotal: $"+ String.format("%.2f", subtotal));
            Pago pagoVentana = new Pago (tiendaSwing);
            pagoVentana.setVisible(true);
            tiendaSwing.setPagoVentana(pagoVentana);
        });
    }

    public void actualizarSubtotalEnPago(double nuevoSubtotal) {
        SwingUtilities.invokeLater(() -> {
        lblSubtotal.setText("Subtotal: $" + String.format("%.2f",nuevoSubtotal));
        });
    }   
}