import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class direccionButton {
    JFrame direccion;
    JTextField tf_numcalle, tf_colonia, tf_ciudad, tf_pais, tf_codigopostal, tf_referencias;
    JButton btnAceptar, btnBorrar;

    direccionButton(){
        direccion  = new JFrame("GUI DIRECCIÓN");
        direccion.setLayout(null); //asigna manualmente ubicacion en X y en Y
        direccion.setSize(600,400);
        btnAceptar = new JButton("ACEPTAR/SIGUIENTE");
        btnBorrar = new JButton("BORRAR");
        btnAceptar.setBounds(240, 160, 100, 20);
        btnBorrar.setBounds(240, 180, 100, 20);

                     //DATOS PERSONALES
        tf_numcalle = new JTextField("23");
        tf_colonia = new JTextField("HIDALGO");
        tf_ciudad = new JTextField("MORELIA");
        tf_pais = new JTextField("MEXICO");
        tf_codigopostal = new JTextField("68066");
        tf_referencias = new JTextField("COLOR VERDE");
        
        tf_numcalle.setBounds(20, 28, 180, 20);
        tf_colonia.setBounds(20, 58, 180, 20);
        tf_ciudad.setBounds(20, 90, 180, 20);
        tf_pais.setBounds(20, 120, 180, 20);
        tf_codigopostal.setBounds(20, 150, 180, 20);
        tf_referencias.setBounds(20, 150, 180, 20);

        

        direccion.add(btnAceptar);
        direccion.add(btnBorrar);
        direccion.add(tf_numcalle);
        direccion.add(tf_colonia);
        direccion.add(tf_ciudad);
        direccion.add(tf_pais);
        direccion.add(tf_codigopostal);
        direccion.add(tf_referencias);

        direccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        //ESCUCHAR AL BOTON ACEPTAR
        btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Direccion direccion = new Direccion(tf_numcalle.getText(), tf_colonia.getText(), 
                tf_ciudad.getText(), tf_pais.getText(), tf_codigopostal.getText(), tf_referencias.getText());

                usuario.imprimir_datos_personales();

                ubicacion = new JFrame("GUI UBICACIÓN");
                //aqui
                ubicacion.setLayout(null); //asigna manualmente ubicacion en X y en Y
                ubicacion.setSize(600,400);

                JButton btnsig, btnborrar1;
                JTextField tf_latitud, tf_longitud;

                btnsig = new JButton("SIGUIENTE");
                btnborrar1 = new JButton("BORRAR");
                btnsig.setBounds(240, 160, 100, 20);
                btnborrar1.setBounds(240, 180, 100, 20);

                tf_latitud = new JTextField("123.843");
                tf_longitud = new JTextField("987.6543");
                tf_latitud.setBounds(20, 28, 180, 20);
                tf_longitud.setBounds(20, 58, 180, 20);

                ubicacion.add(tf_latitud);
                ubicacion.add(tf_longitud);
                ubicacion.add(btnsig);
                ubicacion.add(btnborrar1);
                ubicacion.setVisible(true);
                
            }

        });

        //ESCUCHAR AL BOTON BORRAR
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tf_nombre.setText(" ");
                tf_primerApellido.setText(" ");
                tf_segundoApellido.setText(" ");
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
