import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class imagen {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton imageButton = createImageButton();
            frame.getContentPane().add(imageButton, BorderLayout.CENTER);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JButton createImageButton() {
        // Ruta de la imagen
        String imagePath = "263142.png";

        // Cargar la imagen
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();

        // Definir el tamaño deseado
        int newWidth = 100; // Nueva anchura en píxeles
        int newHeight = 100; // Nueva altura en píxeles

        // Escalar la imagen al nuevo tamaño
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Crear un ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Crear un botón con el ImageIcon escalado como icono
        JButton button = new JButton(scaledIcon);

        // Agregar un ActionListener para manejar eventos de clic en el botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Puedes agregar lógica aquí para manejar el evento de clic
                JOptionPane.showMessageDialog(null, "¡Hiciste clic en el botón!");
            }
        });

        return button;
    }
}
