
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


public class guidireccion extends JFrame{     
  

public guidireccion(int i){
  Connection conn;
    
  //  JFrame f_users;
    JLabel l_id_user,l_first_lastname,l_second_lastname,l_name,l_birthday,l_email,l_gender,l_phone_number;
    JTextField txt_ide_user,txt_first_name,txt_second_name,txt_name,txt_email,txt_birthday,txt_gender,txt_phone_number;
    JButton btn_buscar,btn_cancelar;    
    JTextArea t_detalles_direccion;

    

        this.setSize(1000, 500);
        l_id_user = new JLabel("id_user");
        l_id_user.setBounds(20, 170, 180, 20);
        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(20, 360, 80, 20);
        txt_ide_user = new JTextField("" + i);
        txt_ide_user.setBounds(250, 170, 180, 20);
        t_detalles_direccion = new JTextArea();
        t_detalles_direccion.setBounds(20,400,600,300);

        this.add(btn_buscar);
        this.add(l_id_user);
        this.add(txt_ide_user);
        this.add(t_detalles_direccion);
           
      
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        
        btn_buscar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          Dbconnection conn = new Dbconnection();
          address a1 = new address();
          boolean existe = a1.buscar(txt_ide_user.getText(),conn);
          
          if(existe){
            System.out.println("si existe");
           String x = a1.cargar(txt_ide_user.getText(),conn);
            t_detalles_direccion.selectAll();
            t_detalles_direccion.replaceSelection("");
            t_detalles_direccion.append(x);
            

          } else{
          System.out.println("no existe");
          t_detalles_direccion.selectAll();
          t_detalles_direccion.replaceSelection("");
          t_detalles_direccion.append("No existe");

          }
          conn.disconnection();

        }});
      }
    }
    
        

