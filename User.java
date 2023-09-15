import javax.swing.*;

public class User {
    private JLabel lbl_name, lbl_first, l_last, e_mail;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;

    User() {
        frm_user = new JFrame();

        btn_cancel = new JButton("Canelar");
        btn_cancel.setBounds(10, 50, 150, 100);

        btn_register = new JButton("Registrar");
        btn_register.setBounds(0, 0, 0, 0);

        lbl_name = new JLabel("Nombre:");
        lbl_name.setBounds(10,20,300,30);

        frm_user.add(lbl_name);
        frm_user.add(btn_cancel);
        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void mostrar() {
        frm_user.setVisible(true);
    }

}
