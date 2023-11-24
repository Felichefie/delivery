import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageCarousel extends JFrame {

    private static final String[] IMAGE_PATHS = {"image1.jpg", "image2.jpg", "image3.jpg"};
    private int currentIndex = 0;
    private JLabel imageLabel;

    public ImageCarousel() {
        setTitle("Image Carousel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        imageLabel = new JLabel();
        add(imageLabel);

        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        timer.start();
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % IMAGE_PATHS.length;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(IMAGE_PATHS[currentIndex]));
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageCarousel().setVisible(true);
            }
        });
    }
}
