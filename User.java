import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class User {
    private JLabel lbl_name, lbl_firts, lbl_last, lbl_emai;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;

    User() {
        frm_user = new JFrame();
        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(10, 50, 150, 100);

        btn_register = new JButton("Register");
        btn_register.setBounds(10, 50, 150, 100);

        lbl_name = new JLabel("Nombre");
        lbl_name.setBounds(10, 20, 300, 30);
        lbl_firts = new JLabel("Primer Apellido");
        lbl_firts.setBounds(10, 20, 300, 30);
        lbl_last = new JLabel("Segundo Apellido");
        lbl_last.setBounds(10, 20, 300, 30);
        lbl_emai = new JLabel("Correo electronico");
        lbl_emai.setBounds(10, 20, 300, 30);

        frm_user.add(btn_cancel);
        frm_user.add(btn_register);

        frm_user.add(lbl_name);
        frm_user.add(lbl_firts);
        frm_user.add(lbl_last);
        frm_user.add(lbl_emai);

        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Metodo show que sirve para msotrar el frame
    void show() {
        frm_user.setVisible(true);
    }
}
