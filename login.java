import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {

    public static void login() {
        JFrame inicio = new JFrame("LOGIN");
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

        JLabel label1 = new JLabel("INICIAR SESION");
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
        panelInicioSesion.setBounds(50, 100, 300, 100);
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2));
        inicio.add(panelInicioSesion);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 3, 5, 5)); // Cambié el número de columnas a 3
        panelFormulario.setBackground(Color.WHITE);

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setForeground(Color.BLACK);
        JTextField campoUsuario = new JTextField();

        JLabel labelContraseña = new JLabel("Clave:");
        labelContraseña.setForeground(Color.BLACK);
        JPasswordField campoContraseña = new JPasswordField();

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.BLACK);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.BLACK);

        panelFormulario.add(labelUsuario);
        panelFormulario.add(campoUsuario);
        panelFormulario.add(labelContraseña);
        panelFormulario.add(campoContraseña);
        panelFormulario.add(btnCancelar);
        panelFormulario.add(btnAceptar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(inicio, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose();
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundLogin.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                login();
            }
        });
    }
}
