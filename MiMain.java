import javax.swing.*;

public class MiMain {
    private JLabel lbl_name, lbl_first, lbl_last, lbl_email,a_name;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;
    private JTextField txt_name, txt_first, txt_last, txt_email;

    MiMain() {
        frm_user = new JFrame();
        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 50, 150, 100);
        btn_register = new JButton("Registrar");
        btn_register.setBounds(10, 50, 150, 100);

        lbl_name = new JLabel("Nombre");
        lbl_name.setBounds(10,20,300,30);
        JTextField txt_name = new JTextField();

        lbl_first = new JLabel("Apellido Paterno");
        lbl_first.setBounds(10,20,300,30);
        JTextField txt_first = new JTextField();

        lbl_last = new JLabel("Apellido Materno");
        lbl_last.setBounds(10,20,300,30);
        JTextField txt_last = new JTextField();

        lbl_email = new JLabel("Correo");
        lbl_email.setBounds(10,20,300,30);
        JTextField txt_email = new JTextField();

        frm_user.add(btn_cancel);
        frm_user.add(btn_register);
        frm_user.add(lbl_name);
        frm_user.add(lbl_first);
        frm_user.add(lbl_last);
        frm_user.add(lbl_email);
        frm_user.add(txt_name);
        frm_user.add(txt_first);
        frm_user.add(txt_last);
        frm_user.add(txt_email);
        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    } 

    void show() {
        frm_user.setVisible(true);
    }

}

