package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana_chica {
    public static void main(String[] args) {
        JFrame ventana3;
        ventana3 = new JFrame("Ventana Chica");
        JButton boton = new JButton("Metodos de pago");
        JButton boton2 = new JButton("Direccion");
        boton.setBounds(20, 50, 180, 30);
        boton2.setBounds(20, 100, 180, 30);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agregar_forma_pago a = new Agregar_forma_pago();
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Guidistancia g1 = new Guidistancia();

            }
        });

        ventana3.setVisible(true);
        ventana3.add(boton);
        ventana3.add(boton2);
        ventana3.setLayout(null);
        ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana3.setSize(500, 500);

    }
}