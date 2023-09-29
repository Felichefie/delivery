import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ListenerButton {
    double lat;
    double lon;
    JFrame f,f2,f3;
    JLabel lNombre, lPrimerApeido, lSegundoApeido, lTelefono, lEmail,
    lCalleNumero, lColonia, lEstado, lCiudad, lPais, lCodigoPostal;

    JTextField  tf_nombre, tf_primerApeido, tf_segundoApeido,tf_telefono, tf_email,
    tf2_calleNumero, tf2_colonia, tf2_estado, tf2_ciudad, tf2_pais, tf2_codigoPostal,
    tf3_calleNumero, tf3_colonia, tf3_estado, tf3_ciudad, tf3_pais, tf3_codigoPostal,
    tf3_lat, tf3_lon;

    JButton btnAceptar, btnBorrar, btnMostrar, btnOcultar, btnUbication, btnCerrar;

    ListenerButton(){
        //CREA LA GUI DEL USUARIO
        f  = new JFrame("DATOS DEL USUARIO");
        f.setLayout(null); //asigna manualmente ubicaciones en X y en Y
        f.setSize(600,400);
        btnAceptar = new JButton("ACEPTAR");
        btnBorrar = new JButton("BORRAR");
        btnAceptar.setBounds(130, 200, 200, 20);
        btnBorrar.setBounds(340, 200, 200, 20);

        lNombre = new JLabel("NOMBRE");
        lPrimerApeido = new JLabel("PRIMER APEIDO");
        lSegundoApeido = new JLabel("SEGUNDO APEIDO");
        lTelefono = new JLabel("TeELEFONO");
        lEmail = new JLabel("EMAIL");

        lNombre.setBounds(20,28,120,20);
        lPrimerApeido.setBounds(20, 58, 120, 20);
        lSegundoApeido.setBounds(20, 90, 1800, 20);
        lTelefono.setBounds(20, 120, 180, 20);
        lEmail.setBounds(20, 150, 180, 20);
         
        tf_nombre = new JTextField("PERLA PAOLA");
        tf_primerApeido = new JTextField("PANTALEON");
        tf_segundoApeido = new JTextField("BEDOLLA");
        tf_telefono = new JTextField("4436433678");
        tf_email = new JTextField("2001285B@UMICH.MX");

        tf_nombre.setBounds(300, 28, 180, 20);
        tf_primerApeido.setBounds(300, 58, 180, 20);
        tf_segundoApeido.setBounds(300, 90, 180, 20);
        tf_telefono.setBounds(300, 120, 180, 20);
        tf_email.setBounds(300, 150, 180, 20);
    
        f.add(btnAceptar);
        f.add(btnBorrar);
        f.add(lNombre);
        f.add(lPrimerApeido);
        f.add(lSegundoApeido);
        f.add(lTelefono);
        f.add(lEmail);
        f.add(tf_nombre);
        f.add(tf_primerApeido);
        f.add(tf_segundoApeido);
        f.add(tf_telefono);
        f.add(tf_email);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREA LA GUI DE LA DIRECCION
        f2 = new JFrame("DIRECCION");
        f2.setLayout(null); 
        f2.setSize(600, 400);
        btnMostrar = new JButton("MOSTRAR");
        btnOcultar = new JButton("OCULTAR");
        btnMostrar.setBounds(240, 300, 100, 20);
        btnOcultar.setBounds(350, 300, 100, 20);

        lCalleNumero = new JLabel("CALLE Y NUMERO");
        lColonia = new JLabel("COLONIA");
        lCiudad = new JLabel("CUIDAD");
        lEstado = new JLabel("ESTADO");
        lPais = new JLabel("PAIS");
        lCodigoPostal = new JLabel("CODIGO POSTAL");

        lCalleNumero.setBounds(20, 28, 180, 20);
        lColonia.setBounds(20, 58, 180, 20);
        lCiudad.setBounds(20, 90, 180, 20);
        lEstado.setBounds(20, 120, 180, 20);
        lPais.setBounds(20, 150, 180, 20);
        lCodigoPostal.setBounds(20,180,180,20);

        tf2_calleNumero = new JTextField("Mariano Torres Aranda");
        tf2_colonia = new JTextField("Jose Maria Morelos");
        tf2_ciudad = new JTextField("Morelia");
        tf2_estado = new JTextField("MIchoacan");
        tf2_pais = new JTextField("Mexico");
        tf2_codigoPostal = new JTextField("58322");
        
        tf2_calleNumero.setBounds(300, 28, 180, 20);
        tf2_colonia.setBounds(300, 58, 180, 20);
        tf2_ciudad.setBounds(300, 90, 180, 20);
        tf2_estado.setBounds(300, 120, 180, 20);
        tf2_pais.setBounds(300, 150, 180, 20);
        tf2_codigoPostal.setBounds(300, 180, 180, 20);

        
        f2.add(btnMostrar);
        f2.add(btnOcultar);
        f2.add(lCalleNumero);
        f2.add(lColonia);
        f2.add(lCiudad);
        f2.add(lEstado);
        f2.add(lPais);
        f2.add(lCodigoPostal);
        f2.add(tf2_calleNumero);
        f2.add(tf2_colonia);
        f2.add(tf2_ciudad);
        f2.add(tf2_estado);
        f2.add(tf2_pais);
        f2.add(tf2_codigoPostal);
        
        //CREA LA GUI UBICACION
        f3 = new JFrame("Ubicacion");
        f3.setLayout(null); 
        f3.setSize(600, 400);
        btnUbication = new JButton("UBICACION");
        btnCerrar = new JButton("CANCELAR");
        btnUbication.setBounds(240, 300, 100, 20);
        btnCerrar.setBounds(350, 300, 100, 20);

        lCalleNumero = new JLabel("CALLE Y NUMERO");
        lColonia = new JLabel("COLONIA");
        lCiudad = new JLabel("CUIDAD");
        lEstado = new JLabel("ESTADO");
        lPais = new JLabel("PAIS");
        lCodigoPostal = new JLabel("CODIGO POSTAL");

        lCalleNumero.setBounds(20, 28, 180, 20);
        lColonia.setBounds(20, 58, 180, 20);
        lCiudad.setBounds(20, 90, 180, 20);
        lEstado.setBounds(20, 120, 180, 20);
        lPais.setBounds(20, 150, 180, 20);
        lCodigoPostal.setBounds(20,180,180,20);

        tf3_calleNumero = new JTextField("Eduardo Aldasoro Suarez");
        tf3_colonia = new JTextField("Jose Maria Morelos");
        tf3_ciudad = new JTextField("Morelia");
        tf3_estado = new JTextField("MIchoacan");
        tf3_pais = new JTextField("Mexico");
        tf3_codigoPostal = new JTextField("58140");
        
        tf3_calleNumero.setBounds(300, 28, 180, 20);
        tf3_colonia.setBounds(300, 58, 180, 20);
        tf3_ciudad.setBounds(300, 90, 180, 20);
        tf3_estado.setBounds(300, 120, 180, 20);
        tf3_pais.setBounds(300, 150, 180, 20);
        tf3_codigoPostal.setBounds(300, 180, 180, 20);

        
        f3.add(btnUbication);
        f3.add(btnCerrar);
        f3.add(lCalleNumero);
        f3.add(lColonia);
        f3.add(lCiudad);
        f3.add(lEstado);
        f3.add(lPais);
        f3.add(lCodigoPostal);
        f3.add(tf3_calleNumero);
        f3.add(tf3_colonia);
        f3.add(tf3_ciudad);
        f3.add(tf3_estado);
        f3.add(tf3_pais);
        f3.add(tf3_codigoPostal);


        //ESCUCHAR AL BOTON "UBICACION"
        btnUbication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Ubicacion ubicacion = new Ubicacion(tf3_calleNumero.getText(), tf3_colonia.getText(), tf3_ciudad.getText(), tf3_estado.getText(), tf3_pais.getText(), tf3_codigoPostal.getText());
                ubicacion.imprimir();
            }
        });
        //ESCUCHAR AL BOTON "CERRAR"
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tf3_calleNumero.setText(" ");
                tf3_colonia.setText(" ");
                tf3_ciudad.setText(" ");
                tf3_estado.setText(" ");
                tf3_pais.setText(" ");
                tf3_codigoPostal.setText(" ");

            }
            
        });



        //ESCUCHAR AL BOTON "MOSTRAR" DE LA GUI-DIRECCION
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Direccion direccion = new Direccion(tf2_calleNumero.getText(), tf2_colonia.getText(), tf2_ciudad.getText(), tf2_estado.getText(), tf2_pais.getText(), tf2_codigoPostal.getText());
                direccion.imprimir();
            }
        });
        

        //ESCUCHAR AL BOTON ACEPTAR DE LA GUI-USUARIO
        btnAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario(tf_nombre.getText(), tf_primerApeido.getText(), tf_segundoApeido.getText(), tf_telefono.getText(), tf_email.getText());

                usuario.imprimir_datos_personales();
            }

        });
         //ESCUCHAR AL BOTON BORRAR DE LA GUI-USUARIO
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
       

        //ESCUCHAR AL BOTTON "OCULTAR" DE LA GUI-DIRECCION
        btnOcultar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tf2_calleNumero.setText(" ");
                tf2_colonia.setText(" ");
                tf2_ciudad.setText(" ");
                tf2_estado.setText(" ");
                tf2_pais.setText(" ");
                tf2_codigoPostal.setText(" ");
            }
            
        });
        
    }

    public void mostrar(){
        f.setVisible(true);
        f2.setVisible(true);
        f3.setVisible(true);

    }
    //IMPRIME LA UBICACION
    void imprimir(){                                                    //IMPRIME LOS VALORES
        System.out.println(lat);
        System.out.println(lon);
        }


    public static void main(String[] args){
        ListenerButton lb;
        lb = new ListenerButton();
        lb.mostrar();
        
      
        
    }

    

    
}
