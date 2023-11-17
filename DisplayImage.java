import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DisplayImage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon icon = createImageIcon("/home/alumno/Escritorio/pablo.jpg");
                    if (icon != null) {
                        g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                    } else {
                        System.err.println("No se pudo cargar la imagen");
                    }
                }
            };

            Dimension imageSize = new Dimension(1280, 720);
            imagePanel.setPreferredSize(imageSize);
            imagePanel.setMaximumSize(imageSize);
            imagePanel.setMinimumSize(imageSize);
            imagePanel.setSize(imageSize);

            frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = DisplayImage.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + path);
            return null;
        }
    }
}
