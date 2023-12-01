import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class Imagen extends JFrame {

    public Imagen() {
        try {
            
            setTitle("Ventana con Imagen");

            
            ImageIcon icono = new ImageIcon("delivery/Images/Carrito.png");

            JLabel etiqueta = new JLabel(icono);

            
            getContentPane().add(etiqueta);

            
            setSize(new Dimension(icono.getIconWidth(), icono.getIconHeight()));

            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        new Imagen();
    }
}
