import javax.swing.*;

public class user {
    private JLabel lbl_name; 
    private JLabel lbl_first; 
    private JLabel lbl_last;
    private JLabel lbl_email;
    private JTextField txtf_name;
    private JTextField txtf_first;
    private JTextField txtf_last;
    private JTextField txtf_email;
    private JButton btn_cancel, btn_registrer;
    private JFrame frm_user;

    user() {
        frm_user = new JFrame();

        btn_cancel= new JButton("Cancelar");
        btn_cancel.setBounds(40,400,120,30);
        
        btn_registrer = new JButton("Registrar");
        btn_registrer.setBounds(240, 400, 120, 30);

        lbl_name = new JLabel("Nombre:");
        lbl_name.setBounds(10,20,300,30);
        txtf_name = new JTextField("Anibal",10);
        txtf_name.setBounds(10,55,180,30);
        
        lbl_first = new JLabel("Primer Apellido:"); //primer digito es para la posicion en el eje de las y y el ulrtimo en el eje de las x
        lbl_first.setBounds(10,100,400,30);
        txtf_first = new JTextField("Zavala",10);
        txtf_first.setBounds(10,135,180,30);

        lbl_last = new JLabel("Segundo Apellido:");
        lbl_last.setBounds(10,180,500,30);
        txtf_last = new JTextField("Herrera",10);
        txtf_last.setBounds(10,215,180,30);

        lbl_email = new JLabel("E-mail:");
        lbl_email.setBounds(10,260,600,30);
        txtf_email = new JTextField("1911690k@umich.mx",10);
        txtf_email.setBounds(10,295,180,30);

        

        frm_user.add(lbl_name);
        frm_user.add(lbl_first);
        frm_user.add(lbl_last);
        frm_user.add(lbl_email);
        frm_user.add(btn_registrer);
        frm_user.add(btn_cancel);
        frm_user.add(txtf_name);
        frm_user.add(txtf_first);
        frm_user.add(txtf_last);
        frm_user.add(txtf_email);
        frm_user.setSize(400, 500);
        frm_user.setLayout(null);
        frm_user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frm_user.setVisible(true);
    }


    public static void main(String[] args) {
        user user = new user();
        user.show();
    }
}
