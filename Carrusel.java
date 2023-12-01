import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrusel {
    public static void main(String[] args) {

        int posicion = 3;

        String[] imagenes = new String[4];
        imagenes[0] = "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png";
        imagenes[1] = "https://www.lavanguardia.com/andro4all/hero/2023/04/6d8841b6-9d24-457a-95c5-0d3de1d7bf5f.png?width=768&aspect_ratio=16:9&format=nowebp";
        imagenes[2] = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE7CTVHh7xCDlb8QSIG1BdvxYYN6OijnakkA&usqp=CAU";
        imagenes[3] = "https://previews.123rf.com/images/aprillrain/aprillrain2212/aprillrain221200638/196354278-imagen-de-caricatura-de-un-astronauta-sentado-en-una-luna-ilustraci%C3%B3n-de-alta-calidad.jpg";

        Image[] images = new Image[4];
        for (posicion = 0; posicion < 4; posicion++) {
            try {
                URL url = new URL(imagenes[posicion]);
                images[posicion] = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
                imagenes[posicion] = null;
            }
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image imageScaled = null;
        JLabel label = null;
        while (true) {

            for (posicion = 0; posicion < 4; posicion++) {

                imageScaled = images[posicion].getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
                label = new JLabel(new ImageIcon(imageScaled));
                frame.add(label);
                frame.setVisible(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.remove(label);
            }
        }
    }
}
