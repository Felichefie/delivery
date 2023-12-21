import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class direccion {

    public static void direccion() {
        JFrame inicio = new JFrame("DIRECCION");
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

        JLabel label1 = new JLabel("DIRECCION");
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
        panelInicioSesion.setBounds(50, 100, 300, 300);
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2));
        inicio.add(panelInicioSesion);

        JPanel panelFormulario = new JPanel(new GridLayout(6, 3, 5, 5));
        panelFormulario.setBackground(Color.WHITE);

        JLabel labelCalle = new JLabel("Calle:");
        labelCalle.setForeground(Color.BLACK);
        JTextField campoCalle = new JTextField();

        JLabel labelColonia = new JLabel("Colonia:");
        labelColonia.setForeground(Color.BLACK);
        JTextField campoColonia = new JTextField();

        JLabel labelNumExterior = new JLabel("Número Exterior:");
        labelNumExterior.setForeground(Color.BLACK);
        JTextField campoNumExterior = new JTextField();

        JLabel labelNumInterior = new JLabel("Número Interior:");
        labelNumInterior.setForeground(Color.BLACK);
        JTextField campoNumInterior = new JTextField();

        JLabel labelCodigoPostal = new JLabel("Código Postal:");
        labelCodigoPostal.setForeground(Color.BLACK);
        JTextField campoCodigoPostal = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(b);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(b);

        panelFormulario.add(labelCalle);
        panelFormulario.add(campoCalle);
        panelFormulario.add(labelColonia);
        panelFormulario.add(campoColonia);
        panelFormulario.add(labelNumExterior);
        panelFormulario.add(campoNumExterior);
        panelFormulario.add(labelNumInterior);
        panelFormulario.add(campoNumInterior);
        panelFormulario.add(labelCodigoPostal);
        panelFormulario.add(campoCodigoPostal);
        panelFormulario.add(btnCancelar);
        panelFormulario.add(btnAceptar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(inicio, "¡Registrado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose();
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundDir.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                direccion();
            }
        });
    }
}
