import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {

    public static void registro() {
        JFrame inicio = new JFrame("REGISTRO");
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

        JLabel label1 = new JLabel("REGISTRO");
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


        JPanel panelFormulario = new JPanel(new GridLayout(8, 2, 5, 5));
        panelFormulario.setBackground(Color.WHITE); 

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setForeground(Color.BLACK);
        JTextField campoNombre = new JTextField();

        JLabel labelCorreo = new JLabel("Correo:");
        labelCorreo.setForeground(Color.BLACK);
        JTextField campoCorreo = new JTextField();

        JLabel labelDireccion = new JLabel("Dirección:");
        labelDireccion.setForeground(Color.BLACK);
        JTextField campoDireccion = new JTextField();

        JLabel labelTelefono = new JLabel("Teléfono:");
        labelTelefono.setForeground(Color.BLACK);
        JTextField campoTelefono = new JTextField();

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setForeground(Color.BLACK);
        JTextField campoUsuario = new JTextField();

        JLabel labelContraseña = new JLabel("Clave:");
        labelContraseña.setForeground(Color.BLACK);
        JPasswordField campoContraseña = new JPasswordField();

        JLabel labelRepetirContraseña = new JLabel("Repetir Clave:");
        labelRepetirContraseña.setForeground(Color.BLACK);
        JPasswordField campoRepetirContraseña = new JPasswordField();

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(Color.BLACK);
        btnRegistrar.setBackground(b);

        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(labelCorreo);
        panelFormulario.add(campoCorreo);
        panelFormulario.add(labelDireccion);
        panelFormulario.add(campoDireccion);
        panelFormulario.add(labelTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(labelUsuario);
        panelFormulario.add(campoUsuario);
        panelFormulario.add(labelContraseña);
        panelFormulario.add(campoContraseña);
        panelFormulario.add(labelRepetirContraseña);
        panelFormulario.add(campoRepetirContraseña);
        panelFormulario.add(btnRegistrar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(inicio, "Registro de usuario exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundRegistro.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                registro();
            }
        });
    }
}
