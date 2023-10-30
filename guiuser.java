import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class guiuser{
    public static void main(String[] args) {
    JFrame f_users;
    JLabel l_user_name,l_first_lastname,l_second_lastname,l_name,l_birthday,l_email,l_gender,l_phone_number;
    JTextField txt_user_name,txt_first_name,txt_second_name,txt_name,txt_email,txt_birthday,txt_gender,txt_phone_number;
    JButton btn_buscar,btn_cancelar;    

    f_users = new JFrame("tgt");
        f_users.setSize(1000, 500);
      
        
        /*l_user_name = new JLabel("User name");
        l_user_name.setBounds(20, 20, 180, 20);
        l_first_lastname= new JLabel("First lastname");
        l_first_lastname.setBounds(20, 50, 180, 20);
        l_second_lastname = new JLabel("Second lastname");
        l_second_lastname.setBounds(20, 80, 180, 20);
        l_name= new JLabel("Name");
        l_name.setBounds(20, 110, 180, 20);
        l_birthday= new JLabel("Birtday");
        l_birthday.setBounds(20, 140, 180, 20 ); */
        l_email = new JLabel("Email");
        l_email.setBounds(20, 170, 180, 20);
        /*l_gender= new JLabel("Fender");
        l_gender.setBounds(20, 200, 180, 20);*/
        l_phone_number = new JLabel("Phone Number");
        l_phone_number.setBounds(20, 230, 180, 20);
        btn_buscar = new JButton();
        btn_buscar.setBounds(20, 360, 80, 20);
        btn_cancelar = new JButton();
        btn_cancelar.setBounds(150, 360, 80, 20);
       /*  txt_user_name = new JTextField();
        txt_user_name.setBounds(250, 20, 180, 20);
        txt_first_name= new JTextField();
        txt_first_name.setBounds(250, 50, 180, 20);
        txt_second_name = new JTextField();
        txt_second_name.setBounds(250, 80, 180, 20);
        txt_name = new JTextField();
        txt_name.setBounds(250, 110, 180, 20);
        txt_birthday= new JTextField();
        txt_birthday.setBounds(250, 140, 180, 20 ); */
        txt_email = new JTextField();
        txt_email.setBounds(250, 170, 180, 20);
        /*txt_gender = new JTextField();
        txt_gender.setBounds(250, 200, 180, 20);*/
        txt_phone_number= new JTextField();
        txt_phone_number.setBounds(250, 230, 180, 20);  
        
       

        

        f_users.add(btn_cancelar);
        f_users.add(btn_buscar);
        /*f_users.add(l_user_name);
        f_users.add(l_first_lastname);
        f_users.add(l_second_lastname);
        f_users.add(l_name);
        f_users.add(l_birthday);*/
        f_users.add(l_email);
        //f_users.add(l_gender);
        f_users.add(l_phone_number);
        /*f_users.add(txt_user_name);
        f_users.add(txt_first_name);
        f_users.add(txt_second_name);
        f_users.add(txt_name);
        f_users.add(txt_birthday);*/
        f_users.add(txt_email);
      //  f_users.add(txt_gender);
        f_users.add(txt_phone_number);
           

        f_users.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_users.setLayout(null);
        f_users.setVisible(true);
        
        btn_buscar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            

           

        }
    });
  
      /*btn_cancelar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent q){
            txt_street.setText("");     
            txt_number.setText("");     
            txt_number_two.setText("");
            txt_neighborhood.setText("");  
            txt_city.setText("");   
            txt_state.setText("");     
            txt_country.setText("");     
            txt_postal_code.setText("");
            txt_gps_lat.setText("");  
            txt_gps_lon.setText("");

            }
        });*/
    
}

    
    }









