import javax.swing.*;

public class User {
    private JLabel l_nombre, l_materno, l_paterno;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;

    User() {
        frm_user = new JFrame();
        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(10, 50, 150, 100);
        
        btn_register = new JButton("Registrar");
        btn_register.setBounds(0, 0, 0, 0);

        
        l_nombre = new JLabel("Nombre");
        l_nombre.setBounds(10,20,300,30);

        frm_user.add(l_nombre);
        frm_user.add(btn_cancel);
        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frm_user.setVisible(true);
    }


    
}
