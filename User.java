import javax.swing.*;

public class User {
    private JLabel lbl_name, lbl_first, lbl_last, e_mail;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;

    User() {
        frm_user = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 50, 150, 100);

        btn_register = new JButton("Registrar")
        btn_register.setBounds(0, 0, 0, 0);
        
        lbl_name = new JLabel("Nombre");
        lbl_name.setBounds(10,20,300,30);

        frm_user.add(lbl_name);
        frm_user.add(btn_cancel);
        
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frame.setVisible(true);
    }
}

 