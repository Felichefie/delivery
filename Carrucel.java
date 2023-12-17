import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrucel {
    public static void main( String[] args ) {
        int posicion = 0;

        String [] imagenes = new String[4];
        imagenes[0]="https://media-cdn.tripadvisor.com/media/photo-p/15/2d/23/07/domino-s-pizza.jpg";
        imagenes[1]="https://www.opportimes.com/wp-content/uploads/2022/02/pizza-Dominos-Pizza-686x470.png";
        imagenes[2]="https://th.bing.com/th/id/R.1e3c2c90801234987403274284ca057f?rik=a7XlfBaZQZd8yQ&pid=ImgRaw&r=0";
        imagenes[3]="https://th.bing.com/th/id/R.85810da5523edb9b2b99f3517ac0caca?rik=%2f5GnZpazL4f%2bGQ&pid=ImgRaw&r=0";

        Image [] images = new Image[4];

        for(posicion = 0; posicion < 4; posicion++){
            try {
                URL url = new URL(imagenes[posicion]);
                images[posicion] = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
                images[posicion] = null;
            }
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);  
        JLabel label = null;
        Image imageScaled = null;

        for(posicion = 0; posicion < 4; posicion++){

            imageScaled = images[posicion].getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
            label = new JLabel(new ImageIcon(imageScaled));
            frame.add(label);
            frame.setVisible(true);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.remove(label);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

