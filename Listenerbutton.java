import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listenerbutton {
    JFrame f;
    JTextField tf_nombre, tf_primer_apellido, tf_segundo_apellido, tf_telefono, tf_email;
    JButton btn_aceptar, btn_cancelar;

    Listenerbutton() {

        btn_aceptar = new JButton("Aceptar");
        btn_cancelar = new JButton("Cancelar");
        tf_nombre = new JTextField("Alfredo");
        tf_primer_apellido = new JTextField("Pineda");
        tf_segundo_apellido = new JTextField("Prado");
        tf_telefono = new JTextField("4251327494");
        tf_email = new JTextField("2100602f@umich.mx");
        f = new JFrame("Button test");

        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido.setBounds(20, 80, 180, 20);
        tf_telefono.setBounds(20, 110, 180, 20);
        tf_email.setBounds(20, 140, 180, 20);

        btn_aceptar.setBounds(170, 120, 110, 40);
        btn_cancelar.setBounds(170, 180, 110, 40);
        f.setSize(500, 300);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(tf_nombre);
        f.add(tf_primer_apellido);
        f.add(tf_segundo_apellido);
        f.add(tf_telefono);
        f.add(tf_email);
        f.add(btn_aceptar);
        f.add(btn_cancelar);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(tf_nombre.getText(), tf_primer_apellido.getText(),
                        tf_segundo_apellido.getText(), tf_telefono.getText(), tf_email.getText());

                usuario.imprimir_datos_personales();
            }
        });
        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf_nombre.setText("");
                tf_primer_apellido.setText("");
            }
        });
    }

    public void mostrar() {
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbutton lb;
        lb = new Listenerbutton();
        lb.mostrar();

    }
}