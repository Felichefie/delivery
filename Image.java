import javax.swing.*;

public class Image {
    private JFrame frm_image;

    Image() { // es el constructor
        frm_image = new JFrame();
        JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("carrito.png"));
        lblImage.setBounds(20,10,400,400);

        frm_image.add(lblImage);
        frm_image.setSize(600, 700);
        frm_image.setLayout(null);
        frm_image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    void show() { //Metodo
        frm_image.setVisible(true);
    }
public static void main(String[] args) {
    Image im = new Image();
    im.show();
}
}