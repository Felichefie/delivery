import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Image {
   private static int SCALE_SMOOTH;

public static void main(String[] args) {
        // Crear un JFrame
        JFrame f = new JFrame("JFrame con Imagen");
        ImageIcon imagen = new ImageIcon("1ee998975544d478ebb947fb348e4f30.jpg");

        // Escalar la imagen al nuevo tamaño deseado
        java.awt.Image imagenEscalada = imagen.getImage().getScaledInstance(200, 350, Image.SCALE_SMOOTH);

        // Crear un ImageIcon con la imagen escalada
        ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);

        // Crear un JLabel para mostrar la imagen escalada
        JLabel etiquetaImagen = new JLabel(imagenEscaladaIcon);

        // Agregar el JLabel al JFrame
        f.add(etiquetaImagen);

        // Configurar las propiedades del JFrame
        f.setLayout(new FlowLayout());
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); // Centrar en la pantalla
        f.setVisible(true);
    }
    

}
