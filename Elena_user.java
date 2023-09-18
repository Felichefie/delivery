import javax.swing.*;

public class Elena_user {
    private JLabel lbl_nombre;
    private JLabel lbl_minombre;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;

    private JTextField texto;
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JTextField texto4;
    private JTextField texto5;
    private JTextField texto6; 

    private JButton button;
    private JButton button1;
    private JFrame frame;

    Elena_user() {

        frame = new JFrame();
        button = new JButton("Aceptar");
        button.setBounds(5, 300, 100, 20);

        button1 = new JButton("Cancelar");
        button1.setBounds(250, 300, 100, 20);
        frame.add(button1);

        lbl_nombre = new JLabel("Nombre:");
        lbl_nombre.setBounds(10,50,300,30);


        lbl_minombre = new JLabel("María Elena gabriel Nicolás");
        lbl_minombre.setBounds(200,10,200,30);

        texto = new JTextField(40);
        texto.setBounds(140, 60, 200, 20);
        frame.add(texto);

        label3 = new JLabel("Apellido paterno:");
        label3.setBounds(10, 80, 300, 30);

        texto1 = new JTextField(40);
        texto1.setBounds(140, 90, 200, 20);
        frame.add(texto1);
        label4 = new JLabel("Apellido materno:");
        label4.setBounds(10, 110, 300, 30);

        texto2 = new JTextField(40);
        texto2.setBounds(140, 120, 200, 20);
        frame.add(texto2);
        frame.add(label3);
        frame.add(label4);

        label5 = new JLabel("Teléfono:");
        label5.setBounds(10, 140, 300, 30);
        frame.add(label5);

        texto3 = new JTextField(10);
        texto3.setBounds(140, 150, 200, 20);
        frame.add(texto3);

        label6 = new JLabel("E-mail:");
        label6.setBounds(10, 170, 300, 30);
        frame.add(label6);

        texto4 = new JTextField(60);
        texto4.setBounds(140, 180, 200, 20);
        frame.add(texto4);

        label7 = new JLabel("Dirección:");
        label7.setBounds(10, 200, 300, 30);
        frame.add(label7);

        texto5 = new JTextField(40);
        texto5.setBounds(140, 210, 200, 20);
        frame.add(texto5);

        label8 = new JLabel("Ubicación:");
        label8.setBounds(10, 230, 300, 30);
        frame.add(label8);

        texto6 = new JTextField(200);
        texto6.setBounds(140, 240, 200, 20);
        frame.add(texto6);

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