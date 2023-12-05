import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class Loc {
    private JLabel lbl_nom, lbl_lat, lbl_lon;
    private JButton btn_cancel, btn_register;
    private JFrame frm_User;
    private JTextField txt_lat, txt_lon;

    Loc() {
        frm_User = new JFrame();

        btn_cancel = new JButton("CANCEL");
        btn_cancel.setBounds(80, 200, 100, 50);
        btn_register = new JButton("ACCEPT");
        btn_register.setBounds(200, 200, 100, 50);

        lbl_nom = new JLabel("Hernandez Marin Maria Itzel.");
        lbl_nom.setBounds(70,0,300,30);
        lbl_lon = new JLabel("LONGITUDE:");
        lbl_lon.setBounds(70,20,300,30);
        lbl_lon.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_lat = new JLabel("LATITUDE:");
        lbl_lat.setBounds(70,90,300,30);
        lbl_lat.setFont(new Font("Impact", Font.PLAIN, 14));

        txt_lon = new JTextField();
        txt_lon.setBounds(70, 50, 250, 25);
        txt_lat = new JTextField();
        txt_lat.setBounds(70, 120, 250, 25);

        frm_User.add(lbl_lon);
        frm_User.add(lbl_nom);
        frm_User.add(btn_register);
        frm_User.add(btn_cancel);
        frm_User.add(lbl_lat);
        frm_User.add(txt_lon);
        frm_User.add(txt_lat);
                
        frm_User.setSize(400, 300);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double lat = Double.parseDouble(txt_lat.getText().toString());
                double lon = Double.parseDouble(txt_lon.getText().toString());
                JOptionPane.showMessageDialog(btn_register,"DATOS AGREGADOS DE MANERA CORRECTA!");
            }
        });

        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frm_User.setVisible(false);
            }
        });
    } 

    void show() {
        frm_User.setVisible(true);
    }

}
