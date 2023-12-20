package Proyecto;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualizarImagen extends JPanel {

    public VisualizarImagen(String imageUrl) {
        try {
            // Crea un ImageIcon a partir de la URL de la imagen
            ImageIcon imageIcon = new ImageIcon(new URL(imageUrl));

            // Escala la imagen a 100x100
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            imageIcon = new ImageIcon(image);

            // Crea un JLabel y establece el ImageIcon escalado como su icono
            JLabel label = new JLabel(imageIcon);

            // Añade el JLabel al JPanel
            this.add(label);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}