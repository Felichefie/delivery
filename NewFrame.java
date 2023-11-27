import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

public class NewFrame {
    

    public static void main(String[] args) {
        crearJPanelConImagen1();
    }
    private static JPanel crearJPanelConImagen1(){
        JFrame frame = new JFrame("FRAME CON TRES PANELES");
        JPanel panel = new JPanel();
        ImageIcon imagenOriginal= new ImageIcon("0bb5bb9c9e0d9b750db82601c4e1531.jpg");
        int nuevoAlto = 102;
        int nuevoAncho = 102;
        ImageIcon imagenEscalada = new ImageIcon(imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH)); 
        JLabel label = new JLabel(imagenEscalada);
        label.setBounds(60, 50, nuevoAncho, nuevoAlto);

        frame.add(label);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());


        return panel;
        }
}
