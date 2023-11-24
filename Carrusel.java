import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrusel
{
public static void main( String[] args )
{
    int posicion;
    String [] imagenes = new String[4];
    imagenes [0] = "https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2022/06/06/16545437734127.jpg";
    imagenes [1] = "https://hips.hearstapps.com/hmg-prod/images/elle-mejores-frutas-adelgazar-mango-1644767455.jpg";
    imagenes [2] = "https://www.eluniversal.com.mx/resizer/IYgBoq2fRMkeAcI0tchdpTX1_Ms=/1100x666/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/BK26FXORLVGZRJONDTEBZJSYT4.jpg";
    imagenes [3] = "https://www.viveusa.mx/resizer/JP-wRO76e5-9Yv1ciVm8WgLi5hE=/1100x666/cloudfront-us-east-1.images.arcpublishing.com/eluniversal/O4ZGB225OBGVLA5AQDIMJVD4EM.jpg";
    Image[] images = new Image[4];
    for ( posicion= 0; posicion < 4; posicion++){
        try {
            URL url = new URL (imagenes[posicion]);
            images [posicion]= ImageIO.read(url);
            } catch (IOException e) {
            e.printStackTrace();
            images [posicion] = null;
            }

    }

JFrame frame = new JFrame();
Image imageScaled = null;
JLabel label = null;
frame.setSize(300, 300);
while (true) {
for (posicion =0; posicion < 4; posicion++){
 imageScaled = images[posicion].getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
 label = new JLabel(new ImageIcon(imageScaled));
frame.add(label);
frame.setVisible(true);
try{
    Thread.sleep(2000);
}catch (InterruptedException e) {
    e.printStackTrace();
    }
    frame.remove(label);
}
}
}
}