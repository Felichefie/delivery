import javax.swing.*;
import java.awt.*;

 

public class BotonConImagen extends JFrame {

    public BotonConImagen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Botón con Imagen");
        setSize(500, 300);
        setLocationRelativeTo(null);
        //aqui se pone la imagen entre las comillas
        ImageIcon icono = new ImageIcon(""); 

        JButton boton = new JButton(icono);
        boton.setPreferredSize(new Dimension(icono.getIconWidth(), icono.getIconHeight()));
        add(boton);
        setVisible(true);
    }

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(() -> new BotonConImagen());
    }
}
