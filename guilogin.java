import javax.swing.JButton;
import javax.swing.JTextField;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class guilogin {
    

    public static void main(String[] args) {
    JFrame f_login;
    JLabel l_password,l_usuario,l_autenticacion,l_session;
    JTextField txt_password,txt_usuario;
    JButton btn_buscar,btn_cancelar,btn_dar_de_alta;    

        f_login = new JFrame("tgt");
        f_login.setSize(1000, 500);
        l_password= new JLabel("Password");
        l_password.setBounds(20, 170, 180, 20);
        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(20, 360, 80, 20);
        btn_cancelar= new JButton("cancelar");
        btn_cancelar.setBounds(150, 360, 80, 20);
        btn_dar_de_alta= new JButton("autentificar");
        btn_dar_de_alta.setBounds(280, 360, 80, 20);
        l_password= new JLabel("Password");
        l_password.setBounds(20, 200, 180, 20);
        txt_password = new JTextField("Anibal1234,");
        txt_password.setBounds(250, 200, 180, 20);
        l_usuario = new JLabel("User");
        l_usuario.setBounds(20, 170, 180, 20);
        txt_usuario = new JTextField("anibal1234@gmail.com");
        txt_usuario.setBounds(250, 170, 180, 20);
        l_autenticacion = new JLabel("No autenticado");
        l_autenticacion.setBounds(20, 230, 380, 20);
        l_session = new JLabel("Null");
        l_session.setBounds(20, 260, 180, 20);

      
        f_login.add(btn_cancelar);
        f_login.add(btn_buscar);
        f_login.add(l_password);
        f_login.add(txt_password);
        f_login.add(txt_usuario);
        f_login.add(l_usuario);
        f_login.add(l_autenticacion);
        f_login.add(l_session);
        f_login.add(btn_dar_de_alta);


        btn_buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
                Connection conn = dbconnection.getConn();
                Response r = dbconnection.logAuth(txt_usuario.getText(),txt_password.getText() , conn);
                /*System.out.println("contrasena " + txt_password.getText());
                System.out.println("usuario " + txt_usuario.getText());


                if(r.isStatus() == true){
                    System.out.println("Usuario autentificado");
                    System.out.println("sesion : " + r.getSession());
                    l_autenticacion.setText("usuario autenticado");
                    l_session.setText(r.getSession());

                } else {
                    System.out.println("Usuario NO autentificado");
                    System.out.println("sesion : " + r.getSession()); 
                     l_autenticacion.setText("usuario NO autenticado");
                    l_session.setText("Null");
                }

                try{
                    conn.close();
                }catch (SQLException q) {
                    q.printStackTrace();
                }*/

            
           }});
           btn_dar_de_alta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            String t = txt_password.getText();
            
                //longitud>=8, mayusculas, minúsculas, número y caracter especial $,%&_#
                if(t.length()<8){
                    l_autenticacion.setText(" el password no cumple con las longitud minima");
                    return;
                }
              int i;
              boolean mayusculas=false;
              boolean minúsculas = false, numeros = false,simbolos = false;//son banderas, y al terminar el for todas tienen que ser verdaderas sino no se cumple las politicas del password

                
              for(i=0;i<t.length();i++){
                if(t.charAt(i)>='A' && t.charAt(i)<='Z'){
                    mayusculas=true;
                }
                if(t.charAt(i)>='a' && t.charAt(i)<='z'){
                    minúsculas=true;
                }
                if(t.charAt(i)>='0' && t.charAt(i)<='9'){
                    numeros=true;
               }
               if(t.charAt(i)=='$'||t.charAt(i)==','||t.charAt(i)=='%'||t.charAt(i)=='&'||t.charAt(i)=='_'||t.charAt(i)=='#'){
                    simbolos=true;
               }
              }

               if(!mayusculas||!minúsculas||!numeros||!simbolos){
                l_autenticacion.setText("el password no cumple con los tipos de caracteres");
                    return;
               }

               String psw_hash=BCrypt.hashpw(t, BCrypt.gensalt());
               System.out.println(psw_hash);

              



                Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
                Connection conn = dbconnection.getConn();
                User u1 = new User();
                u1.setEmail(txt_usuario.getText());
                u1.setUserName("Anibal1");
                u1.setName("Anibal");
                u1.setFirst_lastname("Zavala");
                u1.setSecond_lastname("Herrera");
                u1.setBirthday("2023-06-17");
                u1.setPassword(psw_hash);
                dbconnection.insertNewUser(u1);

                try{
                    conn.close();
                }catch (SQLException q) {
                    q.printStackTrace();
                }
                


            }
           });
       
    
        f_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_login.setLayout(null);
        f_login.setVisible(true);
        
    }

}