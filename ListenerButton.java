import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerButton {
    JFrame f, f_ubi, f_dir;
    JTextField tf_nombre, tf_primer_apellido, tf_segundo_apellido,
                tf_email, tf_telefono;
    JTextField tf_calle_numero, tf_colonia, tf_ciudad, tf_pais, tf_referencia,
                tf_codigo_postal;
    JButton btn_aceptar, btn_cancelar;
    ListenerButton(){
        // Variables para añadirlas al constructor //
        btn_aceptar = new JButton("Aceptar");
        btn_cancelar =  new JButton("Cancelar");
        tf_nombre = new JTextField("");
        tf_primer_apellido = new JTextField("");
        tf_segundo_apellido = new JTextField("");
        tf_email = new JTextField("");
        tf_telefono = new JTextField("");
        f = new JFrame("button test");

        tf_calle_numero = new JTextField("");
        tf_colonia = new JTextField("");
        tf_ciudad =  new JTextField("");
        tf_pais =  new JTextField("");
        tf_referencia = new JTextField("");
        tf_codigo_postal = new JTextField("");
        f_dir = new JFrame("Direction test");


        f_ubi = new JFrame("Ubication test");
        
        // Codigo para darle forma a el frame, textfield y buttons //
        btn_aceptar.setBounds(150, 200, 80, 20);
        btn_cancelar.setBounds(250, 200, 80, 20);
        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido.setBounds(20, 80, 180, 20);
        tf_email.setBounds(20, 110, 180, 20);
        tf_telefono.setBounds(20, 180, 180, 20);
        f.setSize(600, 300);

        tf_calle_numero.setBounds(20, 20, 180, 20);
        tf_colonia.setBounds(20, 0, 180, 20);
        tf_ciudad.setBounds(20, 0, 180, 20);
        tf_pais.setBounds(20, 0, 180, 20);
        tf_referencia.setBounds(20, 0, 180, 20);
        tf_codigo_postal.setBounds(20, 0, 180, 20);        
        f_dir.setSize(600, 300);


        f_ubi.setSize(600, 300);
       
        // Añade los botones y textfield al frame //
        f.add(btn_aceptar);
        f.add(btn_cancelar);
        f.add(tf_nombre);
        f.add(tf_primer_apellido);
        f.add(tf_segundo_apellido);
        f.add(tf_email);
        f.add(tf_telefono);

        f_dir.add(tf_calle_numero);
        f_dir.add(tf_colonia);
        f_dir.add(tf_ciudad);
        f_dir.add(tf_pais);
        f_dir.add(tf_referencia);
        f_dir.add(tf_codigo_postal);


        

        // Cierra el Frame en su totalida sin que este siga corriendo //
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_dir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_ubi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
                tf_segundo_apellido.setText("");
                tf_telefono.setText("");
                tf_email.setText("");
            }
        });
    }
    public void show(){
       f.setVisible(true);
       f_dir.setVisible(true);
       f_ubi.setVisible(true);

    }
    public static void main(String[] args) {
        ListenerButton lb;
        lb = new ListenerButton();
        lb.show();
        System.out.println(lb.tf_nombre.getText());
    }
}
