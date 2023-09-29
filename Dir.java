import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class Dir {
    private JLabel lbl_yo, lbl_calle, lbl_colonia, lbl_ciudad, lbl_pais, lbl_referencia, lbl_codigoPostal;
    private JButton btn_cancel, btn_register, btn_ubicacion;
    private JFrame frm_User;
    private JTextField txt_calle, txt_colonia, txt_ciudad, txt_pais, txt_referencia, txt_codigoPostal;

    Dir() {
        frm_User = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 500, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 500, 100, 50);
        btn_ubicacion = new JButton("Ubicacion");
        btn_ubicacion.setBounds(145, 500, 100, 50);

        lbl_yo = new JLabel("Arturo Ruiz Garcia");
        lbl_yo.setBounds(280,0,300,30);
        lbl_calle = new JLabel("Calle:");
        lbl_calle.setBounds(10,20,300,30);
        lbl_calle.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_colonia = new JLabel("Colonia:");
        lbl_colonia.setBounds(10,90,300,30);
        lbl_colonia.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_ciudad = new JLabel("Ciudad:");
        lbl_ciudad.setBounds(10,160,300,30);
        lbl_ciudad.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_pais = new JLabel("Pais:");
        lbl_pais.setBounds(10,230,300,30);
        lbl_pais.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_referencia = new JLabel("Referencia:");
        lbl_referencia.setBounds(10,300,300,30);
        lbl_referencia.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_codigoPostal = new JLabel("Codigo Postal:");
        lbl_codigoPostal.setBounds(10,370,300,30);
        lbl_codigoPostal.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_calle = new JTextField();
        txt_calle.setBounds(10, 50, 250, 25);
        txt_pais = new JTextField();
        txt_pais.setBounds(10, 260, 250, 25);
        txt_colonia = new JTextField();
        txt_colonia.setBounds(10, 120, 250, 25);
        txt_ciudad = new JTextField();
        txt_ciudad.setBounds(10, 190, 250, 25);
        txt_referencia = new JTextField();
        txt_referencia.setBounds(10, 330, 250, 25);
        txt_codigoPostal = new JTextField();
        txt_codigoPostal.setBounds(10, 400, 250, 25);

        frm_User.add(lbl_calle);
        frm_User.add(lbl_yo);
        frm_User.add(btn_register);
        frm_User.add(btn_cancel);
        frm_User.add(lbl_colonia);
        frm_User.add(lbl_ciudad);
        frm_User.add(lbl_pais);
        frm_User.add(txt_pais);
        frm_User.add(txt_colonia);
        frm_User.add(txt_ciudad);
        frm_User.add(txt_calle);
        frm_User.add(txt_referencia);
        frm_User.add(lbl_referencia);
        frm_User.add(lbl_codigoPostal);
        frm_User.add(txt_codigoPostal);
        frm_User.add(btn_ubicacion);
                
        frm_User.setSize(400, 600);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int codigoPost = Integer.parseInt(txt_codigoPostal.getText().toString());
                Direccion dire = new Direccion(txt_calle.getText(), txt_colonia.getText(), txt_ciudad.getText(), codigoPost, txt_pais.getText(), txt_referencia.getText());
                dire.imprimir();
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

    void show() {
        frm_User.setVisible(true);
    }
}
