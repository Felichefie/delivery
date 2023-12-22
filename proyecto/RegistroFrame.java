import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class RegistroFrame extends JFrame {
    public RegistroFrame() {
        setTitle("Registro Frame");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        // Panel raya
        JPanel panelr = new JPanel();
        panelr.setLayout(null);
        panelr.setPreferredSize(new Dimension(360, 5));
        panelr.setBounds(0, 0, 360, 5);
        panelr.setBackground(Color.decode("#003BCD"));
        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(360, 550));
        panel.setBounds(420, 30, 360, 550);
        panel.setBackground(Color.decode("#787B81")); // Ejemplo de color azul en formato hexadecimal

        JLabel tx_nombre = new JLabel("Nombre"), tx_primer_apellido = new JLabel("Primer apellido"), tx_segundo_apellido = new JLabel("Segundo apellido"),
                tx_NomberUs= new JLabel("Nombre de usuario"), tx_cumpleaños= new JLabel("Fecha de nacimiento"), tx_email= new JLabel("Email"),
                tx_genero=new JLabel("Genero"),tx_numroTelefono=new JLabel("Numero telefonico"), tx_contraseña=new JLabel("Contraseña"),tx_contraseñaCon=new JLabel("Confirma tu contraseña"),
                tx_Alerta=new JLabel(""), tx_causas=new JLabel();
        JTextField tf_nombre = new JTextField(),tf_primer_apellido = new JTextField(),tf_segundo_apellido = new JTextField(),tf_NomberUs = new JTextField(),tf_cumpleaños = new JTextField(),
                tf_email = new JTextField(),tf_genero = new JTextField(),tf_numroTelefono = new JTextField();
        JPasswordField tfo_contraseña = new JPasswordField(), tfo_contraseñaCon = new JPasswordField();
        JButton btn_canselar=new JButton("Cancela"), btn_confirmar=new JButton("Confirmar registro");
        //Posición de los objetos--------------------------------------------
        tx_nombre           .setBounds(20, 20 ,150, 20);     tf_nombre           .setBounds(170, 20, 170, 20);
        tx_primer_apellido  .setBounds(20, 60 ,150, 20);     tf_primer_apellido  .setBounds(170, 60, 170, 20);
        tx_segundo_apellido .setBounds(20, 100 ,150, 20);    tf_segundo_apellido .setBounds(170, 100, 170, 20);
        tx_NomberUs         .setBounds(20, 140 ,150, 20);    tf_NomberUs         .setBounds(170, 140, 170, 20);
        tx_cumpleaños       .setBounds(20, 180 ,150, 20);    tf_cumpleaños       .setBounds(170, 180, 170, 20);
        tx_email            .setBounds(20, 220 ,150, 20);    tf_email            .setBounds(170, 220, 170, 20);
        tx_genero           .setBounds(20, 260 ,150, 20);    tf_genero           .setBounds(170, 260, 170, 20);
        tx_numroTelefono    .setBounds(20, 300 ,150, 20);    tf_numroTelefono    .setBounds(170, 300, 170, 20);
        tx_contraseña       .setBounds(20, 340 ,150, 20);    tfo_contraseña      .setBounds(170, 340, 170, 20);
        tx_contraseñaCon    .setBounds(20, 380 ,150, 20);    tfo_contraseñaCon   .setBounds(170, 380, 170, 20);
        btn_canselar        .setBounds(20, 430 ,160, 50);    btn_confirmar       .setBounds(180, 430, 160, 50);
        tx_Alerta           .setBounds(20, 490, 320, 20);    tx_causas           .setBounds(30, 520, 320, 20);
        // Color de fondo 
        btn_canselar.setBackground(Color.decode("#395FB8")); btn_confirmar.setBackground(Color.decode("#395FB8"));
        // Color de letras 
        tx_nombre           .setForeground(Color.decode("#FFFFFF"));    tf_nombre           .setForeground(Color.decode("#002CDD"));
        tx_primer_apellido  .setForeground(Color.decode("#FFFFFF"));    tf_primer_apellido  .setForeground(Color.decode("#002CDD"));
        tx_segundo_apellido .setForeground(Color.decode("#FFFFFF"));    tf_segundo_apellido .setForeground(Color.decode("#002CDD"));
        tx_NomberUs         .setForeground(Color.decode("#FFFFFF"));    tf_NomberUs         .setForeground(Color.decode("#002CDD"));
        tx_cumpleaños       .setForeground(Color.decode("#FFFFFF"));    tf_cumpleaños       .setForeground(Color.decode("#002CDD"));
        tx_email            .setForeground(Color.decode("#FFFFFF"));    tf_email            .setForeground(Color.decode("#002CDD"));
        tx_genero           .setForeground(Color.decode("#FFFFFF"));    tf_genero           .setForeground(Color.decode("#002CDD"));
        tx_numroTelefono    .setForeground(Color.decode("#FFFFFF"));    tf_numroTelefono    .setForeground(Color.decode("#002CDD"));
        tx_contraseña       .setForeground(Color.decode("#FFFFFF"));    tfo_contraseña      .setForeground(Color.decode("#002CDD"));
        tx_contraseñaCon    .setForeground(Color.decode("#FFFFFF"));    tfo_contraseñaCon   .setForeground(Color.decode("#002CDD"));
        btn_canselar        .setForeground(Color.decode("#FFFFFF"));    btn_confirmar       .setForeground(Color.decode("#FFFFFF"));
        tx_Alerta           .setForeground(Color.decode("#F30801"));    tx_causas           .setForeground(Color.decode("#F30801"));
        // Agregar componentes al panel--------------------------------------
        panel.add(tx_nombre);           panel.add(tf_nombre);           panel.add(tx_primer_apellido);          panel.add(tf_primer_apellido);          
        panel.add(tx_segundo_apellido); panel.add(tf_segundo_apellido); panel.add(tx_NomberUs);                 panel.add(tf_NomberUs);
        panel.add(tx_cumpleaños);       panel.add(tf_cumpleaños);       panel.add(tx_email);                    panel.add(tf_email);                    
        panel.add(tx_genero);           panel.add(tf_genero);           panel.add(tx_numroTelefono);            panel.add(tf_numroTelefono);
        panel.add(tx_contraseña);       panel.add(tfo_contraseña);      panel.add(tx_contraseñaCon);            panel.add(tfo_contraseñaCon);             
        panel.add(btn_canselar);        panel.add(btn_confirmar);       panel.add(panelr);                      panel.add(tx_Alerta);
        panel.add(tx_causas);
        //Funciones Botones-------------------------------------------------
        btn_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón "Entrar"
                String pass, passCon, Alerta, causas;
                char[] passwordChars = tfo_contraseña.getPassword();
                pass= new String(passwordChars);
                char[] passwordConChars = tfo_contraseñaCon.getPassword();
                passCon= new String(passwordConChars);
                System.out.println(passCon);
                System.out.println(pass);

                
                Comparator reviews = new Comparator(pass);
                boolean Vacio =reviews.isEmpty(tf_nombre.getText(), tf_primer_apellido.getText(), 
                    tf_segundo_apellido.getText(), tf_NomberUs.getText());
                if(Vacio){
                    System.out.println("Los espacios del 1 al 4 estan bien.");
                    boolean Fech =reviews.isFech(tf_cumpleaños.getText());
                    if(Fech){
                        System.out.println("Si es cumple(Fech)");
                        boolean Gmail =reviews.isGmail(tf_email.getText());
                        if(Gmail){
                            System.out.println("Si es Gmail");
                            boolean Genero =reviews.isGender(tf_genero.getText());
                            if(Genero){
                                
                                System.out.println("Si es cumple");
                                boolean NumCell =reviews.isNumCell(tf_numroTelefono.getText());
                                if(NumCell){
                                    System.out.println("Si es cumple(CELL)");
                                    if(pass.equals(passCon)){
                                        boolean tamaño = reviews.isSizeOk(pass);
                                        if(tamaño){
                                            boolean Numeros = reviews.isNumberOk(pass);
                                            if(Numeros){
                                                boolean Minusculas = reviews.isMinOk(pass);
                                                if(Minusculas){
                                                    boolean Mayusculas = reviews.isMayOk(pass);
                                                    if(Mayusculas){
                                                        boolean espesial= reviews.isEspesialOk(pass);
                                                        if(espesial){
                                                            String pwd_hash=BCrypt.hashpw(pass, BCrypt.gensalt());
                                                            Controlador reguistro= new Controlador(tf_nombre.getText(), tf_primer_apellido.getText(), tf_segundo_apellido.getText(), tf_NomberUs.getText(), tf_cumpleaños.getText(), tf_email.getText(),
                                                            tf_genero.getText(), tf_numroTelefono.getText(), pwd_hash);
                                                            boolean Exito=reguistro.Record();
                                                            tx_Alerta.setText("");tx_causas.setText("");
                                                            if(Exito){
                                                                /*System.out.println("Funciona");*/
                                                                dispose(); // Cierra el frame actual
                                                                new LoginFrame().setVisible(true); // Abre el nuevo frame
                                                            }     
                                                        }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" No cuenta con caracteres espesiales"; 
                                                        tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                                    }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" No cuenta con mayusculas"; 
                                                    tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                                }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" No cuenta con minusculas"; 
                                                tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                            }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" No cuenta con numeros"; 
                                            tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                        }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" El tamaño esta mal"; 
                                        tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                    }else{Alerta="Los campos de \"Contraseña\" esta mal.\n";    causas=" No son igules"; 
                                    tx_Alerta.setText(Alerta);tx_causas.setText(causas);}
                                }else{Alerta="El campo \"Numero telefonico\" esta mal";tx_Alerta.setText(Alerta);}
                            }else{Alerta="El campo Genero esta mal";tx_Alerta.setText(Alerta);}
                        }else{Alerta="El campo Gmail No tiene un correo:\"Gmail\"";tx_Alerta.setText(Alerta);}
                    }else{Alerta="El campo fecha esta mal";tx_Alerta.setText(Alerta);}
                }else{Alerta="Los campos 1 al 4 estan basios";tx_Alerta.setText(Alerta);}
            }
        });
        btn_canselar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón "Entrar"
                dispose(); // Cierra el frame actual
                new LoginFrame().setVisible(true); // Abre el nuevo frame
            }
        });
        //------------------------------------------------------------------

        // Agregar el panel al contenido del JFrame
        add(panel);

        // Hacer visible el JFrame
        setVisible(true);
    }

    /**/public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroFrame();
            }
        });
    }
}