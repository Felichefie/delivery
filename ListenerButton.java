import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerButton {
    JFrame f;
    JTextField tf_nombre, tf_primer_apellido, tf_segundo_apellido,
                tf_email, tf_telefono;
    JButton btn_aceptar, btn_cancelar;
    ListenerButton(){
        btn_aceptar = new JButton("Aceptar");
        btn_cancelar =  new JButton("Cancelar");
        tf_nombre = new JTextField("");
        tf_primer_apellido = new JTextField("");
        tf_segundo_apellido = new JTextField("");
        tf_email = new JTextField("");
        tf_telefono = new JTextField("");
        f = new JFrame("button test");
        
        btn_aceptar.setBounds(160, 200, 80, 20);
        btn_cancelar.setBounds(180, 200, 80, 20);
        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido.setBounds(20, 80, 180, 20);
        tf_email.setBounds(20, 110, 180, 20);
        tf_telefono.setBounds(20, 180, 180, 20);
        f.setSize(600, 300);
        
       
        f.add(btn_aceptar);
        f.add(btn_cancelar);
        f.add(tf_nombre);
        f.add(tf_primer_apellido);
        f.add(tf_segundo_apellido);
        f.add(tf_email);
        f.add(tf_telefono);
        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn_aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario(tf_nombre.getText(), 
                tf_primer_apellido.getText(), tf_segundo_apellido.getText(), 
                tf_email.getText(), tf_telefono.getText());
                
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
    public void show(){
       f.setVisible(true);
    }
    public static void main(String[] args) {
        ListenerButton lb;
        lb = new ListenerButton();
        lb.show();
        System.out.println(lb.tf_nombre.getText());
    }
}
