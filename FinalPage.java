
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class FinalPage {

    public static void FinalPage(){

        JFrame finalPage = new JFrame();
        finalPage.setSize(800,600);
        finalPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finalPage.getContentPane().setBackground(new Color(255,216,0));
        finalPage.setLayout(null);
        finalPage.setResizable(false);
        finalPage.setLocationRelativeTo(null);


        ImageIcon IconoOriginal = new ImageIcon("a1c404bea49c0143058bc4dd9da79d33.jpg");
        int ancho = 100;
        int alto = 100;
        ImageIcon iconoEscalado = new ImageIcon(IconoOriginal.getImage().getScaledInstance(alto, ancho, java.awt.Image.SCALE_SMOOTH));
        JLabel LabelIcono = new JLabel(iconoEscalado);
        LabelIcono.setBounds(340,5,ancho,alto);
        finalPage.add(LabelIcono);


        
        
        JLabel label = new JLabel("MUCHAS GRACIAS POR SU COMPRA!");
        Font newFont = new Font("Monospaced", Font.BOLD, 15);
        label.setFont(newFont);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.setBounds(10,160,765,100);
        panel1.setBackground(new Color(255,252,224));
        panel1.add(label);
        finalPage.add(panel1, BorderLayout.CENTER);

        String label2Text = "Recibiras tu pedido en 30 minutos, \n" +
        "si no esta en la puerta de tu casa en ese tiempo, es gratis!!!";

        JLabel label2 = new JLabel(label2Text);
        Font font = new Font("ARIAL", Font.BOLD, 15);
        label2.setFont(font);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        //label2.setBounds(30,70,300,30);
        panel1.add(label2);

  


        String label3Text2 = "Siguenos tambien en nuestras redes sociales :)";
        JLabel label3 = new JLabel(label3Text2);
        label3.setFont(font);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        //label3.setBounds(320,400,500,30);
   


        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.setBounds(50,300,705,120);
        panel2.setBackground(new Color(255,252,224));
        panel2.add(label3, BorderLayout.CENTER);
        finalPage.add(panel2, BorderLayout.CENTER);





          //ICONOS
        ImageIcon icon = new ImageIcon("d67e85fb0c6c21d06b5a0209d15c8755.jpg");
        int ancho1 = 40;
        int alto1 = 40;
        ImageIcon iconEscaled = new ImageIcon(icon.getImage().getScaledInstance(alto1, ancho1, java.awt.Image.SCALE_SMOOTH));

        JLabel labelIcon = new JLabel(iconEscaled);
        labelIcon.setBounds(300, 450, alto1, ancho1);
        finalPage.add(labelIcon);

        ImageIcon icon2 = new ImageIcon("72aee2cb6b31100ea2370ea304868f45.jpg");
        ImageIcon iconEscaled2 = new ImageIcon(icon2.getImage().getScaledInstance(alto1, ancho1, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon2 = new JLabel(iconEscaled2);
        labelIcon2.setBounds(360, 450, alto1, ancho1);
        finalPage.add(labelIcon2);

        ImageIcon icon3 = new ImageIcon("b8d69bfad379fbc0c7163b08e2928f67.jpg");
        ImageIcon iconEscaled3 = new ImageIcon(icon3.getImage().getScaledInstance(alto1, ancho1, java.awt.Image.SCALE_SMOOTH));
        JLabel labelIcon3 = new JLabel(iconEscaled3);
        labelIcon3.setBounds(420, 450, ancho1, alto1);
        finalPage.add(labelIcon3);


        ImageIcon imagenFonde2 = new ImageIcon("robinson.jpg");
        JLabel LabelFonde2 = new JLabel(imagenFonde2);
        LabelFonde2.setBounds(0,60,800,550);
        finalPage.add(LabelFonde2);
        
        

        
        finalPage.setVisible(true);

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                FinalPage();
            }
        });
        
    }

}
