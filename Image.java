import javax.swing.*;

public class Image {
    private JFrame frm_image;

    Image
() { // es el constructor
        frm_image = new JFrame();
        

         frm_image.setSize(400, 500);
         frm_image.setLayout(null);
         frm_image.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() { //Metodo
        frm_image.setVisible(true);
    }

}