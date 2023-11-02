import javax.swing.JButton;
import javax.swing.JTextField;

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


public class guiuser{
    
static Connection conn;
static User u1;
//static address a1;

    
   

public guiuser(String text, String text2) {
  }  
    public static void main(String[] args) {
    JFrame f_users;
    JLabel l_user_name,l_first_lastname,l_second_lastname,l_name,l_birthday,l_email,l_gender,l_phone_number;
    JTextField txt_user_name,txt_first_name,txt_second_name,txt_name,txt_email,txt_birthday,txt_gender,txt_phone_number;
    JButton btn_buscar,btn_address;    
    JTextArea t_detalles_usuario;
    address a = new address();
    

    
    f_users = new JFrame("tgt");
        f_users.setSize(1000, 500);
      
        
        
        l_email = new JLabel("Email o telefono");
        l_email.setBounds(20, 170, 180, 20);
        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(20, 360, 80, 20);
        btn_address= new JButton("address");
        btn_address.setBounds(150, 360, 80, 20);
        btn_address.setVisible(false);
        txt_email = new JTextField();
        txt_email.setBounds(250, 170, 180, 20);
        t_detalles_usuario = new JTextArea();
        t_detalles_usuario.setBounds(20,400,600,300);
        f_users.add(btn_address);
        f_users.add(btn_buscar);
        f_users.add(l_email);
        f_users.add(txt_email);
        f_users.add(t_detalles_usuario);
           
    
        f_users.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_users.setLayout(null);
        f_users.setVisible(true);
        
      btn_address.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
        guidireccion gi = new guidireccion(u1.getId());//cuando se crea el objeto guidireccionse crea la segunda ventana
        //y esta guidireecionhereda al JFrame
       


       }});
        btn_buscar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          Dbconnection conn = new Dbconnection();
          u1 = new User();
          boolean existe = u1.buscar(txt_email.getText(),conn);
          
         //a1 =  new address();
         //boolean existe = a1.buscar("69", conn);
      
          
          if(existe){
            System.out.println("si existe");
            String x = u1.cargar(txt_email.getText(),conn);
            t_detalles_usuario.selectAll();
            t_detalles_usuario.replaceSelection("");
            t_detalles_usuario.append(x);
            btn_address.setVisible(true);
            

          } else{
          System.out.println("no existe");
          t_detalles_usuario.selectAll();
          t_detalles_usuario.replaceSelection("");
          t_detalles_usuario.append("No existe");
          btn_address.setVisible(false);


          }
          conn.disconnection();

        }});

      }
    }
        