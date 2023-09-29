import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class Loc {
    private JLabel lbl_yo, lbl_lat, lbl_lon;
    private JButton btn_cancel, btn_register;
    private JFrame frm_User;
    private JTextField txt_lat, txt_lon;

    Loc() {
        frm_User = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 200, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 200, 100, 50);

        lbl_yo = new JLabel("Arturo Ruiz Garcia");
        lbl_yo.setBounds(280,0,300,30);
        lbl_lon = new JLabel("Longitud:");
        lbl_lon.setBounds(10,20,300,30);
        lbl_lon.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_lat = new JLabel("Latitud:");
        lbl_lat.setBounds(10,90,300,30);
        lbl_lat.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_lon = new JTextField();
        txt_lon.setBounds(10, 50, 250, 25);
        txt_lat = new JTextField();
        txt_lat.setBounds(10, 120, 250, 25);

        frm_User.add(lbl_lon);
        frm_User.add(lbl_yo);
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
                double latitud = Double.parseDouble(txt_lat.getText().toString());
                double longitud = Double.parseDouble(txt_lon.getText().toString());
                Ubicacion ubi = new Ubicacion(longitud, latitud);
                ubi.imprimir();
                JOptionPane.showMessageDialog(btn_register,"Datos Ingresados");
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
