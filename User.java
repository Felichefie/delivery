import javax.swing.*;

public class User {
    private JLabel lbl_name, lbl_first, l_last, e_mail, l_num, l_dir;
    private JLabel nombre;
    private JButton btn_cancel, btn_register;
    private JFrame frm_user;
    private JTextField t_name, t_first, t_last, t_email, t_num, t_dir;

    User() {
        frm_user = new JFrame();

        nombre = new JLabel("Luis Francisco Ramirez Ortiz");
        nombre.setBounds(200,5,200,20);

        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(250, 400, 100, 15);

        btn_register = new JButton("Registrar");
        btn_register.setBounds(5, 400, 100, 15);

        lbl_name = new JLabel("Nombre:");
        lbl_name.setBounds(10,20,300,30);

        t_name = new JTextField();
        t_name.setBounds(10, 50, 300, 30);

        lbl_first = new JLabel("Apellido paterno:");
        lbl_first.setBounds(10,80,300,30);

        t_first = new JTextField();
        t_first.setBounds(10, 110, 300, 30);

        l_last = new JLabel("Apellido materno:");
        l_last.setBounds(10,140,300,30);

        t_last = new JTextField();
        t_last.setBounds(10,170,300,30);

        e_mail = new JLabel("Correo Electronico:");
        e_mail.setBounds(10,200,300,30);

        t_email = new JTextField();
        t_email.setBounds(10,230,300,30);

        l_num = new JLabel("Numero:");
        l_num.setBounds(10,260,300,30);

        t_num = new JTextField();
        t_num.setBounds(10,290,300,30);

        l_dir = new JLabel("Direccion:");
        l_dir.setBounds(10,320,300,30);

        t_dir = new JTextField();
        t_dir.setBounds(10,350,300,30);


        frm_user.add(nombre);
        frm_user.add(lbl_name);
        frm_user.add(t_name);
        frm_user.add(lbl_first);
        frm_user.add(t_first);
        frm_user.add(l_last);
        frm_user.add(t_last);
        frm_user.add(e_mail);
        frm_user.add(t_email);
        frm_user.add(l_num);
        frm_user.add(t_num);
        frm_user.add(l_dir);
        frm_user.add(t_dir);
        frm_user.add(btn_cancel);
        frm_user.add(btn_register);
        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void mostrar() {
        frm_user.setVisible(true);
    }

}