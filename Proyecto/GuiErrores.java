package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiErrores extends JFrame {

    public GuiErrores(String mensajeError) {
        setTitle("Error de autenticacion");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel para mostrar el mensaje de error
        JLabel mensajeLabel = new JLabel(mensajeError);
        mensajeLabel.setBounds(10, 10, 380, 20);

        // JButton para volver a la pantalla de Login
        JButton volverButton = new JButton("Aceptar");
        volverButton.setBounds(100, 100, 100, 20);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });

        // Agregar los elementos al JFrame
        add(mensajeLabel);
        add(volverButton);
    }
}