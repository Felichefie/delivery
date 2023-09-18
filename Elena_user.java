import javax.swing.*;

public class Elena_user {
    private JLabel lbl_nombre;
    private JLabel lbl_minombre;
    private JLabel lbl_paterno;
    private JLabel lbl_materno;
    private JLabel lbl_telefono;
    private JLabel lbl_mail;
    private JLabel lbl_ubicacion;

    private JTextField tf_name;
    private JTextField tf_pat;
    private JTextField tf_mat;
    private JTextField tf_tel;
    private JTextField tf_mail;
    private JTextField tf_ubicaciob; 

    private JButton button;
    private JButton button1;
    private JFrame frame;

    Elena_user() {

        frame = new JFrame();
        button = new JButton("Aceptar");
        button.setBounds(5, 300, 100, 30);

        button1 = new JButton("Cancelar");
        button1.setBounds(250, 300, 100, 30);
        frame.add(button1);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(10,50,300,30);


        lbl_minombre = new JLabel("María Elena gabriel Nicolás");
        lbl_minombre.setBounds(200,10,200,30);

        tf_name = new JTextField(40);
        tf_name.setBounds(140, 60, 200, 20);
        frame.add(tf_name);

        lbl_paterno = new JLabel("Apellido paterno:");
        lbl_paterno.setBounds(10, 80, 300, 30);

        tf_pat = new JTextField(40);
        tf_pat.setBounds(140, 90, 200, 20);
        frame.add(tf_pat);
        lbl_materno = new JLabel("Apellido materno:");
        lbl_materno.setBounds(10, 110, 300, 30);

        tf_mat = new JTextField(40);
        tf_mat.setBounds(140, 120, 200, 20);
        frame.add(tf_mat);
        frame.add(lbl_paterno);
        frame.add(lbl_materno);

        lbl_telefono = new JLabel("Teléfono:");
        lbl_telefono.setBounds(10, 140, 300, 30);
        frame.add(lbl_telefono);

        tf_tel = new JTextField(10);
        tf_tel.setBounds(140, 150, 200, 20);
        frame.add(tf_tel);

        lbl_mail = new JLabel("E-mail:");
        lbl_mail.setBounds(10, 170, 300, 30);
        frame.add(lbl_mail);

        tf_mail = new JTextField(60);
        tf_mail.setBounds(140, 180, 200, 20);
        frame.add(tf_mail);

        lbl_ubicacion = new JLabel("Ubicación:");
        lbl_ubicacion.setBounds(10, 200, 300, 30);
        frame.add(lbl_ubicacion);

        tf_ubicaciob = new JTextField(200);
        tf_ubicaciob.setBounds(140, 210, 200, 20);
        frame.add(tf_ubicaciob);

        frame.add(lbl_nombre);
        frame.add(button);
        frame.add(lbl_minombre);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frame.setVisible(true);
    }

}