import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class metodopago {

    public static void metodoPago() {
        JFrame inicio = new JFrame("MÉTODO DE PAGO");
        inicio.setSize(800, 600);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color b = new Color(255, 216, 0);
        inicio.getContentPane().setBackground(b);
        inicio.setLayout(new BorderLayout());
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);

        ImageIcon iconoApp = new ImageIcon("img/iconos/logo.png");
        inicio.setIconImage(iconoApp.getImage());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(b);
        inicio.add(panelSuperior, BorderLayout.NORTH);

        JLabel label1 = new JLabel("MÉTODO DE PAGO");
        label1.setFont(new Font("Monospaced", Font.BOLD, 16));
        label1.setForeground(Color.BLACK);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(100, 60));
        panelSuperior.add(label1, BorderLayout.CENTER);

        JButton btnAtras = new JButton("Atras");
        btnAtras.setForeground(Color.BLACK);
        btnAtras.setBackground(b);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose();
            }
        });
        btnAtras.setPreferredSize(new Dimension(80, 30));
        panelSuperior.add(btnAtras, BorderLayout.WEST);

        JPanel panelInicioSesion = new JPanel(new BorderLayout());
        panelInicioSesion.setBackground(Color.WHITE);
        panelInicioSesion.setBounds(50, 100, 300, 200);
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2));
        inicio.add(panelInicioSesion);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5)); // Cambié el número de filas a 3
        panelFormulario.setBackground(Color.WHITE);

        JLabel labelMetodoPago = new JLabel("Seleccione Método de Pago:");
        labelMetodoPago.setForeground(Color.BLACK);

        String[] opcionesMetodoPago = {"Efectivo", "Transferencia", "Tarjeta"};
        JComboBox<String> comboMetodoPago = new JComboBox<>(opcionesMetodoPago);

        JLabel labelClabe = new JLabel("CLABE:");
        labelClabe.setForeground(Color.BLACK);
        JTextField campoClabe = new JTextField();
        campoClabe.setEnabled(false);

        JLabel labelNumCuenta = new JLabel("Número de Cuenta:");
        labelNumCuenta.setForeground(Color.BLACK);
        JTextField campoNumCuenta = new JTextField();
        campoNumCuenta.setEnabled(false);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(b);

        JButton btnPagar = new JButton("Pagar");
        btnPagar.setForeground(Color.BLACK);
        btnPagar.setBackground(b);

        panelFormulario.add(labelMetodoPago);
        panelFormulario.add(comboMetodoPago);
        panelFormulario.add(labelClabe);
        panelFormulario.add(campoClabe);
        panelFormulario.add(labelNumCuenta);
        panelFormulario.add(campoNumCuenta);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Nuevo panel para los botones
        panelBotones.setBackground(Color.WHITE);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnPagar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);
        panelInicioSesion.add(panelBotones, BorderLayout.SOUTH); // Agregado el panel de botones en la parte inferior

        comboMetodoPago.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String metodoSeleccionado = (String) comboMetodoPago.getSelectedItem();
                    if ("Transferencia".equals(metodoSeleccionado)) {
                        campoClabe.setEnabled(true);
                        campoNumCuenta.setEnabled(false);
                    } else if ("Tarjeta".equals(metodoSeleccionado)) {
                        campoClabe.setEnabled(false);
                        campoNumCuenta.setEnabled(true);
                    } else {
                        campoClabe.setEnabled(false);
                        campoNumCuenta.setEnabled(false);
                    }
                }
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoSeleccionado = (String) comboMetodoPago.getSelectedItem();
                if ("Transferencia".equals(metodoSeleccionado)) {
                    String clabe = campoClabe.getText();
                    JOptionPane.showMessageDialog(inicio, "Realizando transferencia con CLABE: " + clabe, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else if ("Tarjeta".equals(metodoSeleccionado)) {
                    String numCuenta = campoNumCuenta.getText();
                    JOptionPane.showMessageDialog(inicio, "Realizando pago con Tarjeta, Número de Cuenta: " + numCuenta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(inicio, "Pago en efectivo", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose();
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundPago.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                metodoPago();
            }
        });
    }
}
