import java.awt.Font;
import javax.swing.*;

public class User {
    private JLabel lbl_creador, lbl_name, lbl_first, lbl_last, lbl_email;
    private JButton btn_cancel, btn_register;
    private JFrame frm_User;
    private JTextField txt_nombre, txt_first, txt_last, txt_email;

    User() {
        frm_User = new JFrame();

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 400, 100, 50);
        btn_register = new JButton("Registrar");
        btn_register.setBounds(275, 400, 100, 50);

        lbl_creador = new JLabel("Israel López Piña");
        lbl_creador.setBounds(280,0,300,30);
        lbl_name = new JLabel("Nombre:");
        lbl_name.setBounds(10,20,300,30);
        lbl_name.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_first = new JLabel("Primer Apellido:");
        lbl_first.setBounds(10,90,300,30);
        lbl_first.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_last = new JLabel("Segundo Apellido:");
        lbl_last.setBounds(10,160,300,30);
        lbl_last.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_email = new JLabel("Email:");
        lbl_email.setBounds(10,230,300,30);
        lbl_email.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_nombre = new JTextField();
        txt_nombre.setBounds(10, 50, 250, 25);
        txt_email = new JTextField();
        txt_email.setBounds(10, 120, 250, 25);
        txt_first = new JTextField();
        txt_first.setBounds(10, 190, 250, 25);
        txt_last = new JTextField();
        txt_last.setBounds(10, 260, 250, 25);

        frm_User.add(lbl_name);
        frm_User.add(lbl_creador);
        frm_User.add(btn_register);
        frm_User.add(btn_cancel);
        frm_User.add(lbl_first);
        frm_User.add(lbl_last);
        frm_User.add(lbl_email);
        frm_User.add(txt_email);
        frm_User.add(txt_first);
        frm_User.add(txt_last);
        frm_User.add(txt_nombre);
                
        frm_User.setSize(400, 500);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frm_User.setVisible(true);
    }
    
    public static void main(String[] args) {
        User user = new User();
        user.show();
    }
}