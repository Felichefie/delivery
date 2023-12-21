import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class Index {

    public static void inicioPizza() {
        JFrame inicio = new JFrame("INICIO");
        inicio.setSize(800, 600);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color b = new Color(255, 216, 0);
        inicio.getContentPane().setBackground(b);
        inicio.setLayout(new BorderLayout());
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);
        ImageIcon iconoApp = new ImageIcon("img/iconos/logo.png");
        inicio.setIconImage(iconoApp.getImage());

        Font newFont = new Font("Monospaced", Font.BOLD, 20);
        JLabel label1 = new JLabel("            BIENVENIDO");
        label1.setFont(newFont);
        label1.setForeground(Color.black);
        label1.setPreferredSize(new Dimension(100, 60));
        inicio.add(label1, BorderLayout.PAGE_START);

        Font newFont2 = new Font("Times New Roman", Font.ITALIC, 12);
        JLabel label2 = new JLabel("Tel: 4433245678");
        JLabel label3 = new JLabel("Tel: 4432356789");
        label2.setFont(newFont2);
        label3.setFont(newFont2);
        label2.setForeground(Color.BLACK);
        label3.setForeground(Color.BLACK);
        label2.setBounds(500, 20, 100, 10);
        label3.setBounds(500, 30, 100, 10);
        inicio.add(label2);
        inicio.add(label3);

        ImageIcon icon = new ImageIcon("img/iconos/Instagram.png");
        int ancho = 40;
        int alto = 40;
        ImageIcon iconEscaled = new ImageIcon(icon.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));

        JLabel labelIcon = new JLabel(iconEscaled);
        labelIcon.setBounds(630, 15, alto, ancho);
        inicio.add(labelIcon);

        ImageIcon icon2 = new ImageIcon("img/iconos/Facebook.png");
        ImageIcon iconEscaled2 = new ImageIcon(icon2.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon2 = new JLabel(iconEscaled2);
        labelIcon2.setBounds(680, 15, alto, ancho);
        inicio.add(labelIcon2);

        ImageIcon icon3 = new ImageIcon("img/iconos/Twitter.png");
        ImageIcon iconEscaled3 = new ImageIcon(icon3.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon3 = new JLabel(iconEscaled3);
        labelIcon3.setBounds(730, 15, ancho, alto);
        inicio.add(labelIcon3);

        JLabel mensajeBienvenida = new JLabel("             PIZZERIA");
        Font mensajeFont = new Font("Arial", Font.BOLD, 24);
        mensajeBienvenida.setFont(mensajeFont);
        mensajeBienvenida.setForeground(Color.WHITE);
        mensajeBienvenida.setBounds(50, 200, 300, 50);
        inicio.add(mensajeBienvenida);

        JPanel panelInicio = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelInicio.setOpaque(false);
        panelInicio.setBounds(50, 300, 700, 50);
        inicio.add(panelInicio);

        JButton btnInicio = new JButton("Iniciar Sesión");
        JButton btnRegistro = new JButton("Registrar nuevo usuario");

        btnInicio.setForeground(Color.white);
        btnInicio.setBackground(new Color(179, 54, 28));
        btnRegistro.setForeground(Color.white);
        btnRegistro.setBackground(new Color(179, 54, 28));

        panelInicio.add(btnInicio);
        panelInicio.add(btnRegistro);

        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la función Login() al hacer clic en el botón
                Login.login();
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundInicio.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo, BorderLayout.CENTER);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> inicioPizza());
    }
}
