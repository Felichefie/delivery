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
int posicion = 4;
String[] imagenes = new String[4];
imagenes[0] = "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png";
imagenes[1] = "https://i.ytimg.com/vi/i_7N5SU2sa4/hqdefault.jpg";
imagenes[2] = "https://static.wikia.nocookie.net/backyardigans/images/3/33/Cientifico_Pablo_infobox.png/revision/latest?cb=20211126012542&path-prefix=es";
imagenes[3] = "https://scontent-qro1-2.xx.fbcdn.net/v/t1.18169-9/23032807_10212459687281321_6008744076687757339_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=9a8829&_nc_ohc=mgDUByeGH5oAX_V930T&_nc_ht=scontent-qro1-2.xx&oh=00_AfBn5g6XhHEANW48ZLpvujbjVpzKhgE4tmhduccox3NriA&oe=65880AEE";

Image image = null;
JFrame frame = new JFrame();
Image imageScaled = null;
frame.setSize(300, 300);
JLabel label;

for (posicion =0 ; posicion < 4; posicion++){
try {
URL url = new URL(imagenes[posicion]);
image = ImageIO.read(url);
} catch (IOException e) {
e.printStackTrace();
}


imageScaled = image.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
label = new JLabel(new ImageIcon(imageScaled));
frame.add(label);
frame.setVisible(true);
try {
    Thread.sleep(500);
} catch (InterruptedException e) {
    e.printStackTrace();}
    frame.remove(label);
}
}
}