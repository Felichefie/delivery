//INDICE
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class InicioPizza {


    public static void InicioPizza(){

        JFrame inicio = new JFrame("INICIO");
        inicio.setSize(800,600);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color b = new Color(255,216,0);
        inicio.getContentPane().setBackground(b);
        inicio.setLayout(new BorderLayout());
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);
        

        ImageIcon IconoOriginal = new ImageIcon("a1c404bea49c0143058bc4dd9da79d33.jpg");
        int ancho1 = 100;
        int alto1 = 100;
        ImageIcon iconoEscalado = new ImageIcon(IconoOriginal.getImage().getScaledInstance(alto1, ancho1, java.awt.Image.SCALE_SMOOTH));
        JLabel LabelIcono = new JLabel(iconoEscalado);
        LabelIcono.setBounds(10,5,ancho1,alto1);
        inicio.add(LabelIcono);





        //ETIQUETAS
        Font newFont = new Font("Monospaced", Font.BOLD, 20);
        JLabel label1 = new JLabel("            BIENVENIDO");
        label1.setFont(newFont);
        label1.setForeground(Color.black);
        label1.setPreferredSize(new Dimension(100,60));
        inicio.add(label1, BorderLayout.PAGE_START);

        Font newFont2 = new Font("Times New Roman", Font.ITALIC,12);
        JLabel label2 = new JLabel("Tel: 4433245678");
        JLabel label3 = new JLabel("Tel: 4432356789");
        label2.setFont(newFont2); 
        label3.setFont(newFont2);
        label2.setForeground(Color.BLACK);
        label3.setForeground(Color.BLACK);
        label2.setBounds(500, 20, 100, 10);
        label3.setBounds(500,30,100,10);
        inicio.add(label2);
        inicio.add(label3);


        //ICONOS
        ImageIcon icon = new ImageIcon("d67e85fb0c6c21d06b5a0209d15c8755.jpg");
        int ancho = 40;
        int alto = 40;
        ImageIcon iconEscaled = new ImageIcon(icon.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));

        JLabel labelIcon = new JLabel(iconEscaled);
        labelIcon.setBounds(630, 15, alto, ancho);
        inicio.add(labelIcon);

        ImageIcon icon2 = new ImageIcon("72aee2cb6b31100ea2370ea304868f45.jpg");
        ImageIcon iconEscaled2 = new ImageIcon(icon2.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon2 = new JLabel(iconEscaled2);
        labelIcon2.setBounds(680, 15, alto, ancho);
        inicio.add(labelIcon2);

        ImageIcon icon3 = new ImageIcon("b8d69bfad379fbc0c7163b08e2928f67.jpg");
        ImageIcon iconEscaled3 = new ImageIcon(icon3.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon3 = new JLabel(iconEscaled3);
        labelIcon3.setBounds(730, 15, ancho, alto);
        inicio.add(labelIcon3);

        

        //PANEL INICIO
        JPanel panelInicio = new JPanel(new FlowLayout());
        panelInicio.setOpaque(false);
        panelInicio.setBounds(50,130,240,100);
        inicio.add(panelInicio);

        //BOTONES
        JButton btnInicio = new JButton("Iniciar Sesion");
        JButton btnRegistro = new JButton("Registrar nuevo usuario");

        btnInicio.setForeground(Color.white);
        btnInicio.setBackground(new Color(179,54,28));
        btnRegistro.setForeground(Color.white);
        btnRegistro.setBackground(new Color(179,54,28));

        panelInicio.add(btnInicio);
        panelInicio.add(btnRegistro);

        ImageIcon imageFondo = new ImageIcon("robinson.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);
        inicio.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                InicioPizza();
            }
        });

        
    }




}
