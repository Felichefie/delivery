//INICIO DE SESION

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LogInPizza {
    public static void LogInPizza(){
        JFrame lp = new JFrame("LOGIN");
        lp.setSize(800,600);
        lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lp.getContentPane().setBackground(new Color(255,216,0));
        lp.setLocationRelativeTo(lp);
        lp.setLayout(new BorderLayout());
        lp.setResizable(false);

        
        ImageIcon IconoOriginal = new ImageIcon("a1c404bea49c0143058bc4dd9da79d33.jpg");
        int ancho1 = 100;
        int alto1 = 100;
        ImageIcon iconoEscalado = new ImageIcon(IconoOriginal.getImage().getScaledInstance(alto1, ancho1, java.awt.Image.SCALE_SMOOTH));
        JLabel LabelIcono = new JLabel(iconoEscalado);
        LabelIcono.setBounds(10,5,ancho1,alto1);
        lp.add(LabelIcono);


        //ETIQUETAS
        Font newFont = new Font("Monospaced", Font.BOLD, 20);
        JLabel label = new JLabel("Ingrese Sus Datos");
        label.setFont(newFont);
        label.setForeground(Color.BLACK);
        //label.setPreferredSize(new Dimension(100,60));
        label.setBounds(150,20,300,30);
        lp.add(label);

        Font newFont2 = new Font("Times New Roman", Font.ITALIC,12);
        JLabel label2 = new JLabel("Tel: 4433245678");
        JLabel label3 = new JLabel("Tel: 4432356789");
        label2.setFont(newFont2); 
        label3.setFont(newFont2);
        label2.setForeground(Color.BLACK);
        label3.setForeground(Color.BLACK);
        label2.setBounds(500, 20, 100, 10);
        label3.setBounds(500,30,100,10);
        lp.add(label2);
        lp.add(label3);

        //ICONOS
        ImageIcon icon = new ImageIcon("d67e85fb0c6c21d06b5a0209d15c8755.jpg");
        int ancho = 40;
        int alto = 40;
        ImageIcon iconEscaled = new ImageIcon(icon.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));

        JLabel labelIcon = new JLabel(iconEscaled);
        labelIcon.setBounds(630, 15, alto, ancho);
        lp.add(labelIcon);

        ImageIcon icon2 = new ImageIcon("72aee2cb6b31100ea2370ea304868f45.jpg");
        ImageIcon iconEscaled2 = new ImageIcon(icon2.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon2 = new JLabel(iconEscaled2);
        labelIcon2.setBounds(680, 15, alto, ancho);
        lp.add(labelIcon2);

        ImageIcon icon3 = new ImageIcon("b8d69bfad379fbc0c7163b08e2928f67.jpg");
        ImageIcon iconEscaled3 = new ImageIcon(icon3.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon3 = new JLabel(iconEscaled3);
        labelIcon3.setBounds(730, 15, ancho, alto);
        lp.add(labelIcon3);


        JPanel panelLOgIn = new JPanel(new FlowLayout());

        panelLOgIn.setOpaque(false);
        panelLOgIn.setBounds(50,160,240,160);

        JLabel usuario = new JLabel("Usuario ");
        usuario.setForeground(Color.WHITE);
        JTextField tfUsuario = new JTextField(24);


        JLabel contrasena = new JLabel("Contrasena");
        contrasena.setForeground(Color.WHITE);
        JPasswordField tfContrasena = new JPasswordField(22);


        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(new Color(229,97,84));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                
            }
        });

        panelLOgIn.add(usuario);
        panelLOgIn.add(tfUsuario);
        panelLOgIn.add(contrasena);
        panelLOgIn.add(tfContrasena);
        panelLOgIn.add(btnLogin);


        lp.add(panelLOgIn);

        ImageIcon imagenFonde = new ImageIcon("robinson.jpg");
        JLabel LabelFonde = new JLabel(imagenFonde);
        LabelFonde.setBounds(0,60,800,550);
        lp.add(LabelFonde);
        
        JPanel panelPrincipal = new JPanel();
        Color ye1 = new Color(255,216,0);
        panelPrincipal.setBackground(ye1);
        panelPrincipal.setBounds(10, 10, 960, 530);

        lp.add(panelPrincipal);
        lp.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                 LogInPizza();
            }
    
        });
    
    }

}
