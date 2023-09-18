import javax.swing.*;

public class User {
    private JLabel lbl_name, lbl_first, lbl_last;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;
    JLabel lbl_nameD, lbl_apellidos;

    User() {
        frm_user = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(25, 380, 100, 55);

        btn_register = new JButton("Registrar");
        btn_register.setBounds(270, 380, 100, 55);
        
        lbl_name = new JLabel("Nombre");
        lbl_name.setBounds(15,25,300,45);

        lbl_first = new JLabel("Apellido_Paterno");
        lbl_first.setBounds(15, 100, 300, 45);

        lbl_last = new JLabel("Apellido_Materno");
        lbl_last.setBounds(15, 200, 300, 45);

        frm_user.add(btn_cancel);
        frm_user.add(btn_register);
        frm_user.add(lbl_name);
        frm_user.add(lbl_first);
        frm_user.add(lbl_last);

        lbl_nameD = new JLabel("Daniel");
        lbl_nameD.setBounds(200, 25, 300, 50);

        lbl_apellidos = new JLabel("Villicaña Escamilla");
        lbl_apellidos.setBounds(250, 25, 300, 50);

        frm_user.add(lbl_nameD);
        frm_user.add(lbl_apellidos);

        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frm_user.setVisible(true);
    }
}

 