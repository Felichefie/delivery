import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class Dir {
    private JLabel lbl_yo, lbl_street, lbl_number, lbl_number_two, lbl_neighborhood, lbl_city, lbl_state, lbl_country, lbl_postal;
    private JButton btn_cancel, btn_register, btn_ubicacion;
    private JFrame frm_User;
    private JTextField txt_street, txt_number, txt_number_two, txt_neighborhood, txt_city, txt_state, txt_country, txt_postal;

    Dir() {
        frm_User = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 650, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 650, 100, 50);
        btn_ubicacion = new JButton("Ubicacion");
        btn_ubicacion.setBounds(145, 650, 100, 50);

        lbl_yo = new JLabel("Arturo Ruiz Garcia");
        lbl_yo.setBounds(280,0,300,30);
        lbl_street = new JLabel("Calle:");
        lbl_street.setBounds(10,20,300,30);
        lbl_street.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_number = new JLabel("Numero:");
        lbl_number.setBounds(10,90,300,30);
        lbl_number.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_number_two = new JLabel("Numero 2:");
        lbl_number_two.setBounds(10,160,300,30);
        lbl_number_two.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_neighborhood = new JLabel("Colonia:");
        lbl_neighborhood.setBounds(10,230,300,30);
        lbl_neighborhood.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_city = new JLabel("Ciudad:");
        lbl_city.setBounds(10,300,300,30);
        lbl_city.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_state = new JLabel("Estado:");
        lbl_state.setBounds(10,370,300,30);
        lbl_state.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_country = new JLabel("Pais:");
        lbl_country.setBounds(10,440,300,30);
        lbl_country.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_postal = new JLabel("Codigo Postal:");
        lbl_postal.setBounds(10,510,300,30);
        lbl_postal.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_street = new JTextField();
        txt_street.setBounds(10, 50, 250, 25);
        txt_number = new JTextField();
        txt_number.setBounds(10, 120, 250, 25);
        txt_number_two = new JTextField();
        txt_number_two.setBounds(10, 190, 250, 25);
        txt_neighborhood = new JTextField();
        txt_neighborhood.setBounds(10, 260, 250, 25);
        txt_city = new JTextField();
        txt_city.setBounds(10, 330, 250, 25);
        txt_state = new JTextField();
        txt_state.setBounds(10, 400, 250, 25);
        txt_country = new JTextField();
        txt_country.setBounds(10, 470, 250, 25);
        txt_postal = new JTextField();
        txt_postal.setBounds(10, 540, 250, 25);
    
        frm_User.add(lbl_yo);
        frm_User.add(lbl_street);
        frm_User.add(lbl_number);
        frm_User.add(lbl_number_two);
        frm_User.add(lbl_neighborhood);
        frm_User.add(lbl_city);
        frm_User.add(lbl_state);
        frm_User.add(lbl_country);
        frm_User.add(lbl_postal);
        frm_User.add(txt_street);
        frm_User.add(txt_number);
        frm_User.add(txt_number_two);
        frm_User.add(txt_neighborhood);
        frm_User.add(txt_city);
        frm_User.add(txt_state);
        frm_User.add(txt_country);
        frm_User.add(txt_postal);
        frm_User.add(btn_register);
        frm_User.add(btn_cancel);
        frm_User.add(btn_ubicacion);
        
        frm_User.setSize(400, 800);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(btn_register,"Datos Ingresados");
            }
        });

        btn_ubicacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Loc loc = new Loc();
                loc.show();
            }
        });

        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frm_User.setVisible(false);
            }
        });
    } 

    void mostrar(String street, int number, String number_two, String neighborhood, String city, String state, String country, String postal_code){
        txt_street.setText(street);
        txt_number.setText(Integer.toString(number));
        txt_number_two.setText(number_two);
        txt_neighborhood.setText(neighborhood);
        txt_city.setText(city);
        txt_state.setText(state);
        txt_country.setText(country);
        txt_postal.setText(postal_code);
    }

    void show() {
        frm_User.setVisible(true);
    }
}
