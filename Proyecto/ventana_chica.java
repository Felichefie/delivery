package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ventana_chica {
    public static void main(String[] args) {
        JFrame ventana3;
        ventana3 = new JFrame("Ventana Chica");
        JButton boton = new JButton("Metodos de pago");
        boton.setBounds(20, 50, 180, 30);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                 agregar_forma_pago a = new agregar_forma_pago();
            }
        });

        ventana3.setVisible(true);
        ventana3.add(boton);
        ventana3.setLayout(null);
        ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana3.setSize(500, 500);
    }
}
