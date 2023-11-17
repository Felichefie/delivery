package Imagen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imagen {

    Imagen() {

        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        JLabel label1;
        ImageIcon imagen = new ImageIcon("avicii.png");
        label1 = new JLabel(imagen);
        label1.setBounds(0, 0, 100, 100);
        f.setSize(500, 500);
        f.add(panel);
    }

    void show() {
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Imagen image = new Imagen();
        image.show();
    }
}
