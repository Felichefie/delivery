import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestImages {

   private static final String IMG_PATH = "Logo.png";

   public static void main(String[] args) {
      try {
         BufferedImage img = ImageIO.read(new File(IMG_PATH));
         ImageIcon icon = new ImageIcon(img);
         JLabel label = new JLabel(icon);
         JOptionPane.showMessageDialog(null, label);
      } catch (IOException e) {
         e.printStackTrace();
         System.err.println("Error cargando la imagen: " + e.getMessage());
      }
   }
}
