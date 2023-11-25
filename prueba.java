import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class prueba
{
public static void main( String[] args )
{
    int posicion;
   String[] imagenes = new String[4];
   imagenes[0]= "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png"; 
   imagenes[1] ="https://previews.123rf.com/images/kongvector/kongvector1707/kongvector170700610/81725770-tenga-una-idea-caricatura-del-car%C3%A1cter-de-la-pera.jpg";
   imagenes[2] ="https://m.media-amazon.com/images/I/81pM+T5uRrS._AC_SL1500_.jpg";
   imagenes[3]=" https://www.ipp.edu.pe/blog/wp-content/uploads/2020/05/shutterstock_1489158410.jpg";

   Image[] images = new Image[4];
   for(posicion=0; posicion<4; posicion++){
    try {
    URL url = new URL(imagenes[posicion]);
    images[posicion] = ImageIO.read(url);
    } catch (IOException e) {
    e.printStackTrace();
    images[posicion]= null;
    }
   }
JFrame frame = new JFrame();
frame.setSize(300, 300);
while (true) {
Image imageScaled = null;
JLabel label;
for(posicion=0;posicion<4;posicion++){
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