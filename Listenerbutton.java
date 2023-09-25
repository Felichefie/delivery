import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Listenerbutton {
    JFrame f;
    JTextField tf_nombre, tf_primer_apellido, tf_segundo_apellido, tf_telefono, tf_email;
    JButton btn_aceptar, btn_cancelar;

    Listenerbutton() {
        btn_aceptar = new JButton("Aceptar");
        tf_nombre = new JTextField("Juan");
        btn_cancelar = new JButton("Cancelar");
        tf_primer_apellido = new JTextField("Ramirez");
        tf_segundo_apellido = new JTextField("Pérez");
        tf_telefono = new JTextField("4436714774");
        tf_email = new JTextField("1627908C@umich.mx");
        f = new JFrame("Button Test");
        f.setSize(600, 300);

        // Asignación de posiciones
        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido.setBounds(20, 68, 180, 20);
        tf_email.setBounds(40, 110, 240, 20);
        tf_telefono.setBounds(20, 140, 180, 20);
        btn_aceptar.setBounds(160, 170, 120, 20);
        btn_cancelar.setBounds(180, 200, 120, 20);

        f.add(tf_nombre);
        f.add(tf_primer_apellido);
        f.add(tf_segundo_apellido);
        f.add(tf_email);
        f.add(tf_telefono);
        f.add(btn_cancelar);
        f.add(btn_aceptar);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(tf_nombre.getText(), tf_primer_apellido.getText(),
                        tf_segundo_apellido.getText(), tf_telefono.getText(),
                        tf_email.getText());
                usuario.imprimir_datos_personales();
            }
        });
        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent q) {
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