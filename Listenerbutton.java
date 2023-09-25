
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listenerbutton {
    JFrame f;
    JTextField tf_nombre, tf_primer_apellido, 
                tf_segundo_apellido, tf_telefono, tf_gmail;
    JButton btn_aceptar, btn_cancelar;

    Listenerbutton (){
        btn_aceptar = new JButton ("aceptar");
        tf_nombre = new JTextField("Felix");
        btn_cancelar = new JButton("cancelar");
        tf_primer_apellido = new JTextField("Jimenez");
        tf_segundo_apellido=new JTextField("Perez");
        tf_telefono=new JTextField("4431234567");
        tf_gmail=new JTextField("felix.jimenez@gmail.com");
        f = new JFrame ("buttontest");
        f.setSize(600,300);

        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido.setBounds(20, 80, 180, 20);
        tf_telefono.setBounds(20, 110, 180, 20);
        tf_gmail.setBounds(40, 140, 240, 20);

        btn_aceptar.setBounds(160, 170, 120, 20);
        btn_cancelar.setBounds(180, 200, 120, 20);
        f.add(tf_gmail);
        f.add(btn_cancelar);
        f.add(tf_primer_apellido);
        f.add(btn_aceptar);
        f.add(tf_nombre);
        f.add(tf_segundo_apellido);
        f.add(tf_telefono);
       
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn_aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario=new Usuario(tf_nombre.getText(),
                                tf_primer_apellido.getText(), tf_segundo_apellido.getText(), 
                                tf_telefono.getText(), tf_gmail.getText());
                usuario.imprimir_datos_personales();
            }
        });
        btn_cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q){
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
