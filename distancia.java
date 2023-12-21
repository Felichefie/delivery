import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class distancia {

    public static void distanciaATiempo() {
        JFrame inicio = new JFrame("Distancia a Tiempo");
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

        JLabel label1 = new JLabel("Distancia a Tiempo");
        label1.setFont(new Font("Monospaced", Font.BOLD, 16));
        label1.setForeground(Color.BLACK);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(200, 60));
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
        panelInicioSesion.setBounds(50, 100, 300, 350); 
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2));
        inicio.add(panelInicioSesion);

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5)); 
        panelFormulario.setBackground(Color.WHITE);

        JLabel labelOrigen = new JLabel("Origen:");
        labelOrigen.setForeground(Color.BLACK);
        JTextField campoOrigen = new JTextField();

        JLabel labelDestino = new JLabel("Destino:");
        labelDestino.setForeground(Color.BLACK);
        JTextField campoDestino = new JTextField();

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose(); 
            }
        });

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setForeground(Color.BLACK);

        JLabel labelDistancia = new JLabel("Distancia:");
        labelDistancia.setForeground(Color.BLACK);
        JTextField campoDistancia = new JTextField();
        campoDistancia.setEditable(false);

        JLabel labelTiempo = new JLabel("Tiempo:");
        labelTiempo.setForeground(Color.BLACK);
        JTextField campoTiempo = new JTextField();
        campoTiempo.setEditable(false);

        panelFormulario.add(labelOrigen);
        panelFormulario.add(campoOrigen);
        panelFormulario.add(labelDestino);
        panelFormulario.add(campoDestino);
        panelFormulario.add(btnCancelar);
        panelFormulario.add(btnCalcular);
        panelFormulario.add(labelDistancia);
        panelFormulario.add(campoDistancia);
        panelFormulario.add(labelTiempo);
        panelFormulario.add(campoTiempo);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundDistancia.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoDistancia.setText("Distancia calculada");
                campoTiempo.setText("Tiempo calculado");
            }
        });
        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                distanciaATiempo();
            }
        });
    }
}
