
    import java.awt.Image;
    import java.io.IOException;
    import java.net.URL;
    import javax.imageio.ImageIO;
    import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

public class Carrusel{
        public static void main( String[] args )
    {

        int posicion;

        String[] imagenes = new String[4]; 
        imagenes[0] = "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png";
        imagenes[1] = "https://s1.eestatic.com/2021/09/17/ciencia/nutricion/612699746_208614860_1706x960.jpg";
        imagenes[2] = "https://phantom-telva.unidadeditorial.es/334f6116c19a3d7caf267b6e9e629faa/resize/828/f/jpg/assets/multimedia/imagenes/2023/03/05/16780029716658.jpg";
        imagenes[3] = "https://img.freepik.com/vector-premium/hombre-montando-tractor-dibujos-animados-trabajo-agricola-vehiculo-agricola_543062-2559.jpg";
        Image[] images = new Image[4];
        for (posicion = 0; posicion < 4; posicion++){
             try {
                URL url = new URL(imagenes[posicion]);
                images[posicion] = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
                images[posicion] = null;
            }

        }


       
        JFrame frame = new JFrame();
        Image imageScaled = null;
        JLabel label = null;
        frame.setSize(300, 300); 
        
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
    }
    }

