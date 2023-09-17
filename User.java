import javax.swing.*;

public class User {

    private JFrame frm_user;
    private JButton btn_cancel, btn_register;
    private JLabel lbl_name, lbl_firts, lbl_last, lbl_emai, lbl_number;
    private JTextField text_name, text_firts, text_last, text_email, text_number;

    User() {
        frm_user = new JFrame("Datos del usuario");
        btn_cancel = new JButton("CANCEL");
        btn_cancel.setBounds(50, 350, 120, 80);
        btn_register = new JButton("REGISTER");
        btn_register.setBounds(220, 350, 120, 80);

        lbl_name = new JLabel("Nombre");
        lbl_name.setBounds(10, 20, 300, 30);
        lbl_firts = new JLabel("Primer Apellido");
        lbl_firts.setBounds(10, 80, 300, 30);
        lbl_last = new JLabel("Segundo Apellido");
        lbl_last.setBounds(10, 140, 300, 30);
        lbl_emai = new JLabel("Correo electronico");
        lbl_emai.setBounds(10, 200, 300, 30);
        lbl_number = new JLabel("Numero");
        lbl_number.setBounds(10, 260, 300, 30);

        text_name = new JTextField(null, null, 0);
        text_name.setBounds(10, 45, 350, 30);
        text_firts = new JTextField(null, null, 0);
        text_firts.setBounds(10, 105, 350, 30);
        text_last = new JTextField(null, null, 0);
        text_last.setBounds(10, 165, 350, 30);
        text_email = new JTextField(null, null, 0);
        text_email.setBounds(10, 225, 350, 30);
        text_number = new JTextField(null, null, 0);
        text_number.setBounds(10, 285, 350, 30);

        frm_user.add(btn_cancel);
        frm_user.add(btn_register);

        frm_user.add(lbl_name);
        frm_user.add(lbl_firts);
        frm_user.add(lbl_last);
        frm_user.add(lbl_emai);
        frm_user.add(lbl_number);

        frm_user.add(text_name);
        frm_user.add(text_firts);
        frm_user.add(text_last);
        frm_user.add(text_email);
        frm_user.add(text_number);

        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metodo show que sirve para msotrar el frame
    void show() {
        frm_user.setVisible(true);
    }
}
