import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrusel {
    
public static void main(String[] args )
{
        int posicion;

        String[] imagenes = new String[4];
        imagenes[0] = "https://i.pinimg.com/736x/05/f3/78/05f3783f95e31a96d20b79a52461e434.jpg";
        imagenes[1] = "https://i.ytimg.com/vi/sFIlEY8NZhA/maxresdefault.jpg";
        imagenes[2] = "https://i.pinimg.com/736x/21/69/33/216933685f2529fad9b821ab062ee7ad.jpg";
        imagenes[3] = "https://i.pinimg.com/236x/84/07/76/840776a51a31d9e50e1d0fc2ca019260.jpg";
        Image[] images = new Image[4];
        
    for(posicion = 0; posicion < 4; posicion++){
            try{
        URL url = new URL(imagenes[posicion]);
        images[posicion] = ImageIO.read(url);
        }catch (IOException e){
        e.printStackTrace();
        images[posicion] = null;
        }
    }
        
JFrame frame = new JFrame();
Image imageScaled = null;
JLabel label = null;
frame.setSize(300, 300);

while(true){
for(posicion = 0; posicion < 4; posicion++){

imageScaled = images[posicion].getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
label = new JLabel(new ImageIcon(imageScaled));
frame.add(label);
frame.setVisible(true);
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    
    e.printStackTrace();
}
frame.remove(label);

}

        }
    }
}
