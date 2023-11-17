import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class Imagen extends JFrame {

    public Imagen() {
        try {
            // Establecer el título de la ventana
            setTitle("Ventana con Imagen");

            // Crear un JLabel y cargar la imagen desde un archivo
            ImageIcon icono = new ImageIcon("delivery/Images/Carrito.png");

            JLabel etiqueta = new JLabel(icono);

            // Agregar la etiqueta al contenido de la ventana
            getContentPane().add(etiqueta);

            // Ajustar el tamaño de la ventana según el tamaño de la imagen
            setSize(new Dimension(icono.getIconWidth(), icono.getIconHeight()));

            // Establecer la operación de cierre por defecto
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Hacer visible la ventana
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        new Imagen();
    }
}
