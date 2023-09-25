import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ListenerButton {
    JFrame f;
    JTextField tf_nombre, tf_primerApeido, tf_segundoApeido,tf_telefono, tf_email;
    JButton btnAceptar, btnBorrar;

    ListenerButton(){
        f  = new JFrame("BUTTON TEST");
        f.setLayout(null); //asigna manualmente ubicacion en X y en Y
        f.setSize(600,400);
        btnAceptar = new JButton("ACEPTAR");
        btnBorrar = new JButton("BORRAR");
        btnAceptar.setBounds(240, 160, 100, 20);
        btnBorrar.setBounds(240, 180, 100, 20);

                     //DATOS PERSONALES
        tf_nombre = new JTextField("PERLA PAOLA");
        tf_primerApeido = new JTextField("PANTALEON");
        tf_segundoApeido = new JTextField("BEDOLLA");
        tf_telefono = new JTextField("4436433678");
        tf_email = new JTextField("2001285B@UMICH.MX");

        
        tf_nombre.setBounds(20, 28, 180, 20);
        tf_primerApeido.setBounds(20, 58, 180, 20);
        tf_segundoApeido.setBounds(20, 90, 180, 20);
        tf_telefono.setBounds(20, 120, 180, 20);
        tf_email.setBounds(20, 150, 180, 20);

        
        f.add(btnAceptar);
        f.add(btnBorrar);
        f.add(tf_nombre);
        f.add(tf_primerApeido);
        f.add(tf_segundoApeido);
        f.add(tf_telefono);
        f.add(tf_email);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ESCUCHAR AL BOTON ACEPTAR
        btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario(tf_nombre.getText(), tf_primerApeido.getText(), tf_segundoApeido.getText(), tf_telefono.getText(), tf_email.getText());

                usuario.imprimir_datos_personales();
            }

        });


        //ESCUCHAR AL BOTON BORRAR
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tf_nombre.setText(" ");
                tf_primerApeido.setText(" ");
                tf_segundoApeido.setText(" ");
                tf_telefono.setText(" ");
                tf_email.setText(" ");

            }
            
        });
        
    }
    public void mostrar(){
        f.setVisible(true);

    }

    public static void main(String[] args){
        ListenerButton lb;
        lb = new ListenerButton();
        lb.mostrar();
        
      
        
    }

    

    
}
