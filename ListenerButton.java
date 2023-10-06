/*indice
 registro
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListenerButton {
    
    JFrame f_registro, f_ubicacion, f_prinsipal;
    JLabel tx_nombre, tx_primer_apellido, tx_segundo_apellido,
            tx_email, tx_telefono, tx_calle_numero, tx_colonia,
            tx_ciudad, tx_referencia, tx_codigo_postal, tx_pais,
            tx_lat, tx_long, tx_Mensaje_principal, h;   
    JTextField tf_nombre, tf_primer_apellido, tf_segundo_apellido,
                tf_email, tf_telefono, tf_calle_numero, tf_colonia,
                tf_ciudad, tf_referencia, tf_codigo_postal, tf_pais,
                tf_lat, tf_long;
    JButton btn_aceptar_registro, btn_cancelar_registro,btn_aceptar_ubicacion,
            btn_cancelar_ubicacion,btn_atras_ubicacion;
    //int fuccion=1;
    ListenerButton(){
        //registro
        btn_aceptar_registro = new JButton("Aceptar");
        btn_cancelar_registro = new JButton("Cancelar");
        btn_aceptar_ubicacion = new JButton("Aceptar");
        btn_cancelar_ubicacion = new JButton("Cancelar");
        btn_atras_ubicacion = new JButton("<== Atras");
        

        tx_lat= new JLabel("Latitud:");//Latitud y longutud
        tx_long= new JLabel("Logitud:");//----------------------------------------
        tx_nombre = new JLabel("Nombre:");
        tx_primer_apellido = new JLabel("Primer apellido:");//Registro
        tx_segundo_apellido = new JLabel("Segundo apellido:");
        tx_email = new JLabel("Gmai:");
        tx_telefono = new JLabel("Cell:");
        tx_calle_numero = new JLabel("Numero de calle:");
        tx_colonia = new JLabel("Colonia:");
        tx_ciudad = new JLabel("Ciudad:");
        tx_referencia = new JLabel("Referencia:");
        tx_codigo_postal = new JLabel("Codigo postal:");
        tx_pais = new JLabel("Pais:");//----------------------------------------
        tx_Mensaje_principal = new JLabel("HOLA MUNDO");//prinsipal
        h = new JLabel("");//Relleno
        
        tf_lat= new JTextField("");//Latitud y longutud
        tf_long= new JTextField("");//----------------------------------------
        tf_nombre = new JTextField("");//Registro
        tf_primer_apellido = new JTextField("");
        tf_segundo_apellido = new JTextField("");
        tf_email = new JTextField("");
        tf_telefono = new JTextField("");
        tf_calle_numero = new JTextField("");
        tf_colonia = new JTextField("");
        tf_ciudad = new JTextField("");
        tf_referencia = new JTextField("");
        tf_codigo_postal = new JTextField("");
        tf_pais = new JTextField("");//----------------------------------------

        f_registro = new JFrame("Registro");
        f_ubicacion = new JFrame("ubicacion");
        f_prinsipal = new JFrame("Prinsipal");
        btn_aceptar_registro.setBounds(350, 200, 80, 20);;//Registro
        btn_cancelar_registro.setBounds(350, 230, 80, 20);//----------------------------------------
        btn_aceptar_ubicacion.setBounds(350, 200, 80, 20);;//Latitud y longutud
        btn_cancelar_ubicacion.setBounds(350, 230, 80, 20);
        btn_atras_ubicacion.setBounds(350, 260, 80, 20);//----------------------------------------
        tf_nombre.setBounds(140, 20, 180, 20);               tx_nombre.setBounds(20, 20, 140, 20);//Registro
        tf_primer_apellido.setBounds(140, 50, 180, 20);      tx_primer_apellido.setBounds(20, 50, 140, 20); 
        tf_segundo_apellido.setBounds(140, 80, 180, 20);     tx_segundo_apellido.setBounds(20, 80, 140, 20); 
        tf_email.setBounds(140, 110, 180, 20);               tx_email.setBounds(20, 110, 140, 20);//----------Direcion----------------------
        tf_telefono.setBounds(140, 140, 180, 20);            tx_telefono.setBounds(20, 140, 140, 20);
        tf_colonia.setBounds(140, 200, 180, 20);             tx_colonia.setBounds(20, 200, 140, 20);            
        tf_ciudad.setBounds(140, 220, 180, 20);              tx_ciudad.setBounds(20, 220, 140, 20);
        tf_calle_numero.setBounds(140, 240, 180, 20);        tx_calle_numero.setBounds(20, 240, 140, 20);
        tf_referencia.setBounds(140, 260, 180, 20);          tx_referencia.setBounds(20, 260, 140, 20);
        tf_codigo_postal.setBounds(140, 280, 180, 20);       tx_codigo_postal.setBounds(20, 280, 140, 20);
        tf_pais.setBounds(140, 300, 180, 20);                tx_pais.setBounds(20, 300, 140, 20);//----------------------------------------
        tf_lat.setBounds(140, 140, 180, 20);                 tx_lat.setBounds(20, 140, 140, 20);//Latitud y longutud
        tf_long.setBounds(140, 200, 180, 20);                tx_long.setBounds(20, 200, 140, 20);//----------------------------------------

        tx_Mensaje_principal.setBounds(140, 140, 180, 20); 
        h.setBounds(20, 400, 0, 0); 
        f_registro.setSize(600, 400);
        f_ubicacion.setSize(600, 400);
        f_prinsipal.setSize(600, 400);

        f_registro.add(btn_aceptar_registro);//Registro
        f_registro.add(btn_cancelar_registro);
        f_registro.add(tf_nombre);                           f_registro.add(tx_nombre);
        f_registro.add(tf_primer_apellido);                  f_registro.add(tx_primer_apellido);
        f_registro.add(tf_segundo_apellido);                 f_registro.add(tx_segundo_apellido);
        f_registro.add(tf_email);                            f_registro.add(tx_email);
        f_registro.add(tf_telefono);                         f_registro.add(tx_telefono);
        f_registro.add(tf_colonia);                          f_registro.add(tx_colonia);
        f_registro.add(tf_ciudad);                           f_registro.add(tx_ciudad);
        f_registro.add(tf_referencia);                       f_registro.add(tx_referencia);
        f_registro.add(tf_calle_numero);                     f_registro.add(tx_calle_numero);
        f_registro.add(tf_codigo_postal);                    f_registro.add(tx_codigo_postal);    
        f_registro.add(tf_pais);                             f_registro.add(tx_pais);//----------------------------------------
        f_registro.add(h);
        f_ubicacion.add(btn_aceptar_ubicacion);//Latitud y longutud
        f_ubicacion.add(btn_cancelar_ubicacion);
        f_ubicacion.add(btn_atras_ubicacion);
        f_ubicacion.add(tf_lat);                             f_ubicacion.add(tx_lat);    
        f_ubicacion.add(tf_long);                            f_ubicacion.add(tx_long);//----------------------------------------
        f_ubicacion.add(h);
        f_prinsipal.add(tx_Mensaje_principal);;//prinsipal
        f_prinsipal.add(h);//----------------------------------------
        f_registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_ubicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_prinsipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn_aceptar_registro.addActionListener(new ActionListener(){//Registro
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario(tf_nombre.getText(), 
                tf_primer_apellido.getText(), tf_segundo_apellido.getText(), 
                tf_email.getText(), tf_telefono.getText());
                usuario.imprimir_datos_personales();
                int int_codigo_postal;
                int_codigo_postal = Integer.parseInt(tf_codigo_postal.getText());
                Direccion direccion = new Direccion(tf_calle_numero.getText(),
                tf_colonia.getText(), tf_ciudad.getText(), tf_referencia.getText(),
                int_codigo_postal, tf_pais.getText());  
                direccion.imprimir();
                f_registro.setVisible(false);
                f_ubicacion.setVisible(true);/**/
               
            }
        }); 
        btn_cancelar_registro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q){
                tf_nombre.setText("");              tf_primer_apellido.setText("");
                tf_segundo_apellido.setText("");    tf_email.setText("");
                tf_telefono.setText("");            tf_colonia.setText("");
                tf_ciudad.setText("");              tf_calle_numero.setText("");
                tf_referencia.setText("");          tf_codigo_postal.setText("");
                tf_pais.setText("");
            }
        });//----------------------------------------
        btn_aceptar_ubicacion.addActionListener(new ActionListener(){//Latitud y longutud
            @Override
            public void actionPerformed(ActionEvent e){
                int int_latitud, int_Logitud;
                int_latitud = Integer.parseInt(tf_lat.getText());
                int_Logitud = Integer.parseInt(tf_long.getText());
                Ubicacion ubicacion=new Ubicacion(int_latitud, int_Logitud);
                ubicacion.imprimir();
                f_ubicacion.setVisible(false);
                f_prinsipal.setVisible(true);
            }
        });
        btn_cancelar_registro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q){
                tf_lat.setText("");              
                tf_long.setText("");
            }
        });
        btn_atras_ubicacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent w){
                f_ubicacion.setVisible(false);
                f_registro.setVisible(true);
            }
        }); //----------------------------------------
    }
    public void show(){
       f_registro.setVisible(true);
    }
    public static void main(String[] args) {
        ListenerButton lb;
        lb = new ListenerButton();
        lb.show();
        System.out.println(lb.tf_nombre.getText());
    }
}
