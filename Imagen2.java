import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Imagen2 {
    public static void main(String[] args) {
        // Crear un JFrame
        JFrame frame = new JFrame("Ejemplo de Imagen Escalada en JFrame");

        // Crear un ImageIcon con la imagen original
        ImageIcon imagenOriginal = new ImageIcon("0bb5bb9c9e0d9b750db82601c4e1531.jpg"); // Cambia la ruta por la ubicación de tu imagen

        // Escalar la imagen a un nuevo tamaño
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        ImageIcon imagenEscalada = new ImageIcon(imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        // Crear un JLabel con la imagen escalada
        JLabel label = new JLabel(imagenEscalada);
        // Establecer la posición del JLabel
        label.setBounds(250, 50, nuevoAncho, nuevoAlto);



        
        // Añadir el JLabel al JFrame
        frame.add(label);
        // Configurar el JFrame
        frame.setSize(400, 400);
        frame.setLayout(null); // Desactivar el diseño predeterminado para establecer manualmente las posiciones
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
