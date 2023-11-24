import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Carrusel {
    public static void main(String[] args) {
        int posicion;
        String[] imagenes = new String[4];
        imagenes[0] = "https://www.fie.umich.mx/wp-content/uploads/2023/08/FIE-Logo-Oro.png";
        imagenes[1] = "https://i.kym-cdn.com/entries/icons/facebook/000/046/058/freddyfazbearharharhar.jpg";
        imagenes[2] = "https://static.wikia.nocookie.net/backyardigans/images/3/33/Cientifico_Pablo_infobox.png/revision/latest?cb=20211126012542&path-prefix=es";
        imagenes[3] = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7665603f-28c2-4844-a8d1-ddf3e0debf55/dgcbdng-9e6685af-7432-4244-9543-cd625c5ac285.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzc2NjU2MDNmLTI4YzItNDg0NC1hOGQxLWRkZjNlMGRlYmY1NVwvZGdjYmRuZy05ZTY2ODVhZi03NDMyLTQyNDQtOTU0My1jZDYyNWM1YWMyODUuanBnIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.YtLPJ_-oWaGK7dYbEiIiLIgt7Gyhpg97MQzESl9DWCU";
        Image[] images = new Image[4];
        for (posicion = 0; posicion < 4; posicion++) {
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
        while (true) {
            for (posicion = 0; posicion < 4; posicion++) {

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