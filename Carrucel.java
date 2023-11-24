  import java.awt.Image;
    import java.io.IOException;
    import java.net.URL;
    import javax.imageio.ImageIO;
    import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

public class Carrucel{ 
  
    public static void main( String[] args ){
//Arreglo de Strings para imagenes
        int posicion = 3;
        String[] imagenes = new String[4]; 
        imagenes[0] = "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png";
        imagenes[1] = "https://elegifruta.com.ar/wp-content/uploads/2017/07/manzana_roja.jpg";
        imagenes[2] = "https://phantom-telva.unidadeditorial.es/334f6116c19a3d7caf267b6e9e629faa/resize/828/f/jpg/assets/multimedia/imagenes/2023/03/05/16780029716658.jpg";
        imagenes[3] = "https://consumer.huawei.com/content/dam/huawei-cbg-site/latam/mx/mkt/plp/new/desktops-new/matestation-x-series/matestation-x-series-1.jpg";

        Image[] images =  new Image[4];
        for(posicion = 0; posicion < 4; posicion++){
            try {
                URL url = new URL(imagenes[posicion]);
               images[posicion] = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
                images[posicion] = null;
            }

        }


        Image image = null;
            JFrame frame = new JFrame();
            frame.setSize(300, 300);
            
            Image imageScaled = null;
            JLabel label = null;

//Ciclo para que se repitan las imagenes
    while (true) {
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

}
