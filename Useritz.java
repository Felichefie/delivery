import java.awt.Color;
import java.awt.Dialog;

import javax.swing.*;

public class Useritz {
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;

    private JButton button;
    private JButton button1;
    private JFrame frame;

    Useritz() {

        frame = new JFrame();
        button = new JButton("ACEPTAR");
        button.setBounds(5, 400, 100, 15);

        button1 = new JButton("BORRAR");
        button1.setBounds(250, 400, 100, 15);
        frame.add(button1);

        label1 = new JLabel("INTERFAZ DE USUARIO");
        label1.setBounds(150,30,200,20);
        label1.setForeground(Color.blue);

        //ETIQUETA PARA EL NOMBRE.
        label2 = new JLabel("HERNÁNDEZ MARÍN MARÍA ITZEL");
        label2.setBounds(200,5,200,20);
        label2.setForeground(Color.pink);
        //label2.setFont(Font.arial);

        //ETIQUETA PARA EL NOMBRE DE USUARIO.
        label = new JLabel("NOMBRE:");
        label.setBounds(10,50,300,30);

        //ETIQUETA PARA LOS APELLIDOS DEL USUARIO.
        label3 = new JLabel("APELLIDO PATERNO:");
        label3.setBounds(10, 80, 300, 30);
        label4 = new JLabel("APELLIDO MATERNO:");
        label4.setBounds(10, 110, 300, 30);
        frame.add(label3);
        frame.add(label4);

        //ETIQUETA PARA EL TELEFONO DEL USUARIO.
        label5 = new JLabel("TELEFONO:");
        label5.setBounds(10, 140, 300, 30);
        frame.add(label5);

        //ETIQUETA PARA EL EMAIL DEL USUARIO.
        label6 = new JLabel("CORREO ELÉCTRONICO:");
        label6.setBounds(10, 170, 300, 30);
        frame.add(label6);

        //ETIQUETA PARA LA DIRECCION DEL USUARIO.
        label7 = new JLabel("DIRECCIÓN:");
        label7.setBounds(10, 200, 300, 30);
        frame.add(label7);

        //ETIQUETA PARA LA UBICACIÓN DEL USUARIO.
        label8 = new JLabel("UBICACIÓN:");
        label8.setBounds(10, 230, 300, 30);
        frame.add(label8);

        frame.add(label);
        frame.add(label1);
        frame.add(button);
        frame.add(label2);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Useritz user = new Useritz();
        user.show();
    }
}