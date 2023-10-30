import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui{
   public static void main(String[] args) {
    JFrame f_address;
    JLabel l_street,l_number,l_number_two,l_neighborhood,l_city,l_state,l_country,l_postal_code,l_gps_lat,l_gps_lon;
    JTextField txt_street,txt_number,txt_number_two,txt_neighborhood,txt_city,txt_state,txt_country,txt_postal_code,txt_gps_lat,txt_gps_lon;
    JButton btn_aceptar, btn_cancelar;
        

    
        
        l_street = new JLabel("Street");
        l_street.setBounds(20, 20, 180, 20);
        l_number= new JLabel("Number");
        l_number.setBounds(20, 50, 180, 20);
        l_number_two = new JLabel("Numbre_two");
        l_number_two.setBounds(20, 80, 180, 20);
        l_neighborhood= new JLabel("Neighborhood");
        l_neighborhood.setBounds(20, 110, 180, 20);
        l_city= new JLabel("City");
        l_city.setBounds(20, 140, 180, 20 ); 
        l_state = new JLabel("State");
        l_state.setBounds(20, 170, 180, 20);
        l_country= new JLabel("Country");
        l_country.setBounds(20, 200, 180, 20);
        l_postal_code = new JLabel("PC");
        l_postal_code.setBounds(20, 230, 180, 20);
        l_gps_lat= new JLabel("Lat");
        l_gps_lat.setBounds(20, 260, 180, 20);
        l_gps_lon= new JLabel("Lon");
        l_gps_lon.setBounds(20, 290, 180, 20 ); 
        btn_aceptar = new JButton();
        btn_aceptar.setBounds(20, 360, 80, 20);
        btn_cancelar = new JButton();
        btn_cancelar.setBounds(150, 360, 80, 20);
        txt_street = new JTextField();
        txt_street.setBounds(250, 20, 180, 20);
        txt_number= new JTextField();
        txt_number.setBounds(250, 50, 180, 20);
        txt_number_two = new JTextField();
        txt_number_two.setBounds(250, 80, 180, 20);
        txt_neighborhood= new JTextField();
        txt_neighborhood.setBounds(250, 110, 180, 20);
        txt_city= new JTextField();
        txt_city.setBounds(250, 140, 180, 20 ); 
        txt_state = new JTextField();
        txt_state.setBounds(250, 170, 180, 20);
        txt_country= new JTextField();
        txt_country.setBounds(250, 200, 180, 20);
        txt_postal_code = new JTextField();
        txt_postal_code.setBounds(250, 230, 180, 20);
        txt_gps_lat= new JTextField();
        txt_gps_lat.setBounds(250, 260, 180, 20);
        txt_gps_lon= new JTextField();
        txt_gps_lon.setBounds(250, 290, 180, 20 ); 

        
       

        f_address = new JFrame("Buttontest");
        f_address.setSize(1000, 500);
      

        f_address.add(btn_cancelar);
        f_address.add(btn_aceptar);
        f_address.add(l_street);
        f_address.add(l_number);
        f_address.add(l_number_two);
        f_address.add(l_neighborhood);
        f_address.add(l_city);
        f_address.add(l_state);
        f_address.add(l_country);
        f_address.add(l_postal_code);
        f_address.add(l_gps_lat);
        f_address.add(l_gps_lon);
        f_address.add(txt_street);
        f_address.add(txt_number);
        f_address.add(txt_number_two);
        f_address.add(txt_neighborhood);
        f_address.add(txt_city);
        f_address.add(txt_state);
        f_address.add(txt_country);
        f_address.add(txt_postal_code);
        f_address.add(txt_gps_lat);
        f_address.add(txt_gps_lon);


        f_address.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_address.setLayout(null);
        f_address.setVisible(true);
        
        btn_aceptar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            address address = new address(txt_street.getText(), Integer.parseInt(txt_number.getText()),  Integer.parseInt(txt_number_two.getText()), txt_neighborhood.getText(),txt_city.getText(),txt_state.getText(), txt_country.getText(),  Integer.parseInt(txt_postal_code.getText()), txt_gps_lat.getText(),txt_gps_lon.getText());
            address.imprimir();


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

public static void gettxt_email() {
}
}







