import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonEnVariosPaneles {
    private JButton botonCompartido;

    public BotonEnVariosPaneles() {
//frame
        JFrame f = new JFrame();
        f.setSize(400,400);
        f.setTitle("Botón en Varios Paneles");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        
        ImageIcon imageFondo = new ImageIcon("c86bc700d88da495c88ea0a6c9f0f241.jpg");
        JLabel lablefondo = new JLabel(imageFondo);


//Crea el boton
        botonCompartido = new JButton("Botón Compartido");
        botonCompartido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog( f,"\"¡Se ha anadido este producto a tu carrito!\"");

            }
        });

        f.setLayout(new GridLayout(1, 3));  

 // Crear paneles y agregar el mismo botón a cada uno
        JPanel panel1 = crearPanel();
        JPanel panel2 = crearPanel();
        JPanel panel3 = crearPanel();

// Agregar el botón a cada panel
        panel1.add(crearBotonConMismaAccion());
        panel2.add(crearBotonConMismaAccion());
        panel3.add(crearBotonConMismaAccion());

        // Agregar los paneles al marco
        f.add(panel1, BorderLayout.NORTH);
        f.add(panel2, BorderLayout.CENTER);
        f.add(panel3, BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JPanel crearPanel() {
        JPanel panel = new JPanel();
        
        return panel;
    }
    private JButton crearBotonConMismaAccion(){
        JButton nuevoBoton = new JButton(botonCompartido.getText());
        nuevoBoton.addActionListener(botonCompartido.getActionListeners()[0]);
        return nuevoBoton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BotonEnVariosPaneles());
    }
}
