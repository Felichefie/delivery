
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Listenerbutton 
    {
    double lat;
    double lon;
    JFrame frame1,
            frame2,
            frame3;
    JLabel LNombre, 
            LPrimerApellido, 
            LSegundoApellido, 
            LTelefono, 
            LEmail, 
            LCalleNumero, 
            LColonia, 
            LEstado, 
            LCiudad, 
            LPais, 
            LCodigoPostal;
    JTextField tf_nombre, tf_primer_apellido, 
                tf_segundo_apellido, tf_telefono, 
                tf_gmail,  
                    
                tf2_calleNumero, tf2_colonia,
                tf2_estado,tf2_ciudad,
                tf2_pais, tf2_codigoPostal,

                tf3_calleNumero,tf3_colonia,
                tf3_estado,tf3_ciudad,
                tf3_pais,tf3_codigoPostal,
                tf3_lat,tf2_lon;

    JButton btn_Aceptar, 
            btn_Borrar, 
            btn_Mostrar, 
            btn_Oculta, 
            btn_Ubicacion, 
            btn_Cerrar;

    Listenerbutton (){

        //VENTANA PARA INTRODUCIR LOS DATOS DE USUARIO

        frame1 = new JFrame ("DATOS DE USUARIO");
        frame1.setSize(600,400);
        frame1.setLayout(null);
        btn_Aceptar = new JButton ("Aceptar");
        btn_Borrar = new JButton("Borrar");
        
        LNombre = new JLabel("NOMBRE");
        LPrimerApellido = new JLabel("PRIMER APELLIDO");
        LSegundoApellido = new JLabel("SEGUNDO APELLIDO");
        LTelefono = new JLabel("TELEFONO");
        LEmail = new JLabel("EMAIL");
        
        tf_nombre = new JTextField("Nombre:");
        tf_primer_apellido = new JTextField("Tu Primer Apellido:");
        tf_segundo_apellido=new JTextField("Tu Segundo Apellido:");
        tf_telefono=new JTextField("Telefono:");
        tf_gmail=new JTextField("email:");
        
        btn_Aceptar.setBounds(130, 200, 200, 20);
        btn_Borrar.setBounds(340, 200, 200, 20);

        LNombre.setBounds(20, 28, 180, 20);
        LPrimerApellido.setBounds(20, 58, 180, 20);
        LSegundoApellido.setBounds(20, 90, 180, 20);
        LTelefono.setBounds(20, 120, 180, 20);
        LEmail.setBounds(20, 150, 180, 20);

        tf_nombre.setBounds(300, 28, 180, 20);
        tf_primer_apellido.setBounds(300, 58, 180, 20);
        tf_segundo_apellido.setBounds(300, 90, 180, 20);
        tf_telefono.setBounds(300, 120, 180, 20);
        tf_gmail.setBounds(300, 150, 180, 20);

        frame1.add(btn_Aceptar);
        frame1.add(btn_Borrar);
        frame1.add(LNombre);
        frame1.add(LPrimerApellido);
        frame1.add(LSegundoApellido);
        frame1.add(LTelefono);
        frame1.add(LEmail);
        frame1.add(tf_gmail);
        frame1.add(tf_primer_apellido);
        frame1.add(tf_nombre);
        frame1.add(tf_segundo_apellido);
        frame1.add(tf_telefono);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //VENTANA PARA INTRODUCIR NUESTRA DIRECCION
        frame2 = new JFrame("DATOS DE DIRECCION");
        frame2.setLayout(null);
        frame2.setSize(600,400);
        btn_Aceptar = new JButton ("Aceptar");
        btn_Borrar = new JButton("Borrar");

        LCalleNumero = new JLabel("CALLE Y NUMERO");
        LColonia = new JLabel("COLONIA");
        LCiudad = new JLabel("CIUDAD");
        LEstado = new JLabel("ESTADO");
        LPais = new JLabel("PAIS");
        LCodigoPostal = new JLabel("CP");

        tf2_calleNumero = new JTextField("Introduce tu calle con numero:");
        tf2_colonia = new JTextField("Introduce tu colonia:");
        tf2_ciudad = new JTextField("Introduce tu ciudad:");
        tf2_estado = new JTextField("Introduce tu estado:");
        tf2_pais = new JTextField("Introduce tu pais:");
        tf2_codigoPostal= new JTextField("Introduce tu CP:");

        btn_Aceptar.setBounds(240, 300, 100, 20);
        btn_Borrar.setBounds(350, 300, 100, 20);

        LCalleNumero.setBounds(20, 28, 180, 20);
        LColonia.setBounds(20, 58, 180, 20);
        LCiudad.setBounds(20, 90, 180, 20);
        LEstado.setBounds(20, 120, 180, 20);
        LPais.setBounds(20, 150, 180, 20);
        LCodigoPostal.setBounds(20, 180, 180, 20);

        tf2_calleNumero.setBounds(3000, 28, 180, 20);
        tf2_colonia.setBounds(300, 58, 180, 20);
        tf2_ciudad.setBounds(300, 90, 180, 20);
        tf2_estado.setBounds(300, 120, 180, 20);
        tf2_pais.setBounds(300, 150, 180, 20);
        tf2_codigoPostal.setBounds(300, 180, 180, 20);

        frame2.add(btn_Aceptar);
        frame2.add(btn_Borrar);
        frame2.add(LCalleNumero);
        frame2.add(LColonia);
        frame2.add(LCiudad);
        frame2.add(LEstado);
        frame2.add(LPais);
        frame2.add(LCodigoPostal);
        frame2.add(tf2_calleNumero);
        frame2.add(tf2_colonia);
        frame2.add(tf2_ciudad);
        frame2.add(tf2_estado);
        frame2.add(tf2_pais);
        frame2.add(tf2_codigoPostal);

        //VENTANA PARA INTRODUCIR NUESTRA UBICACION
        frame3 = new JFrame("DATOS DE UBICACION");
        frame3.setLayout(null);
        frame3.setSize(600,400);
        btn_Aceptar = new JButton ("Aceptar");
        btn_Borrar = new JButton("Borrar");

        LCalleNumero = new JLabel("CALLE Y NUMERO");
        LColonia = new JLabel("COLONIA");
        LCiudad = new JLabel("CIUDAD");
        LEstado = new JLabel("ESTADO");
        LPais = new JLabel("PAIS");
        LCodigoPostal = new JLabel("CP");

        tf3_calleNumero = new JTextField("Introduce tu calle con numero:");
        tf3_colonia = new JTextField("Introduce tu colonia:");
        tf3_ciudad = new JTextField("Introduce tu ciudad:");
        tf3_estado = new JTextField("Introduce tu estado:");
        tf3_pais = new JTextField("Introduce tu pais:");
        tf3_codigoPostal= new JTextField("Introduce tu CP:");

        btn_Aceptar.setBounds(240, 300, 100, 20);
        btn_Borrar.setBounds(350, 300, 100, 20);

        LCalleNumero.setBounds(20, 28, 180, 20);
        LColonia.setBounds(20, 58, 180, 20);
        LCiudad.setBounds(20, 90, 180, 20);
        LEstado.setBounds(20, 120, 180, 20);
        LPais.setBounds(20, 150, 180, 20);
        LCodigoPostal.setBounds(20, 180, 180, 20);

        tf3_calleNumero.setBounds(3000, 28, 180, 20);
        tf3_colonia.setBounds(300, 58, 180, 20);
        tf3_ciudad.setBounds(300, 90, 180, 20);
        tf3_estado.setBounds(300, 120, 180, 20);
        tf3_pais.setBounds(300, 150, 180, 20);
        tf3_codigoPostal.setBounds(300, 180, 180, 20);

        frame3.add(btn_Aceptar);
        frame3.add(btn_Borrar);
        frame3.add(LCalleNumero);
        frame3.add(LColonia);
        frame3.add(LCiudad);
        frame3.add(LEstado);
        frame3.add(LPais);
        frame3.add(LCodigoPostal);
        frame3.add(tf3_calleNumero);
        frame3.add(tf3_colonia);
        frame3.add(tf3_ciudad);
        frame3.add(tf3_estado);
        frame3.add(tf3_pais);
        frame3.add(tf3_codigoPostal);





        btn_Aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario=new Usuario(tf_nombre.getText(),
                                tf_primer_apellido.getText(), tf_segundo_apellido.getText(), 
                                tf_telefono.getText(), tf_gmail.getText());
                usuario.imprimir_datos_personales();
            }
        });
        btn_Borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q){
                tf_nombre.setText("");
                tf_primer_apellido.setText("");
            }
        });
    }

    public void mostrar() {
        frame1.setVisible(true);
        frame2.setVisible(true);
        frame3.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbutton lb;
        lb = new Listenerbutton();
        lb.mostrar();
        

    }
}
