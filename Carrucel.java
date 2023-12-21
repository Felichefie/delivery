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
        imagenes[0]="https://www.comedera.com/wp-content/uploads/2022/03/pizza-gbbcd06f95_1920.jpg";
        imagenes[1]="https://www.lanacion.com.ar/resizer/v2/la-pizza-de-peperoni-estilo-nueva-OSJYHXRML5DUTEMJRYUCZTIALI.jpg?auth=d9055e78e29b9c01d9a68e317f946c6500983d85e9378ddf56e1a0a0d3e63f72&width=880&height=586&quality=70&smart=true";
        imagenes[2]="https://www.asaucykitchen.com/wp-content/uploads/2016/09/Gluten-Free-Pizza-with-Chorizo-Sausage_.jpg";
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

