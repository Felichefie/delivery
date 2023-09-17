import javax.swing.*;

public class Userjc {

//codigo para las etiquetas que se necesitan
    private JLabel labelu;
    private JLabel labeld;
    private JLabel labelt;
    private JLabel labelc;
    private JLabel labelci;
    private JLabel labels;
    private JLabel labelsi;
    private JLabel labelo;
    private JLabel labeln;

//codigo para los dos botones que necesitamos
    private JButton button;
    private JButton buttonu;

//codigo para los textos que necesitamos ingresar.
    private JTextField textu;
    private JTextField textd;
    private JTextField textt;
    private JTextField textc;
    private JTextField textci;
    private JTextField texts;
    private JTextField textsi;

//codigo necesario para que nos aparezca la ventana del form
    private JFrame frame;

    Userjc() {
        frame = new JFrame();

//damos nombre y dimensiones a las etiquetas que apareceran.
        labelu = new JLabel("Jaime Jaír Raya Castellón");
        labelu.setBounds(229, 5, 250, 25);
        frame.add(labelu);

        labeld = new JLabel("DATOS DEL USUARIO:");
        labeld.setBounds(145, 35, 250, 25);
        frame.add(labeld);

        labelt = new JLabel("Nombre completo:");
        labelt.setBounds(5, 75, 250, 25);
        frame.add(labelt);
        textu = new JTextField(30);
        textu.setBounds(5, 100, 320, 15);
        frame.add(textu);

        labelc = new JLabel("Primer apellido:");
        labelc.setBounds(5, 130, 250, 25);
        frame.add(labelc);
        textd = new JTextField(20);
        textd.setBounds(5, 150, 320, 15);
        frame.add(textd);

        labelc = new JLabel("Segundo apellido:");
        labelc.setBounds(5, 180, 250, 25);
        frame.add(labelc);
        textt = new JTextField(30);
        textt.setBounds(5, 200, 320, 15);
        frame.add(textt);

        labelci = new JLabel("Numero telefonico:");
        labelci.setBounds(5, 230, 250, 25);
        frame.add(labelci);
        textc= new JTextField(12);
        textc.setBounds(5, 250, 320, 15);
        frame.add(textc);

        labels = new JLabel("Email:");
        labels.setBounds(5, 280, 250, 25);
        frame.add(labels);
        textc = new JTextField(30);
        textc.setBounds(5, 300, 320, 15);
        frame.add(textc);

        labelsi = new JLabel("Dirección:");
        labelsi.setBounds(5, 330, 250, 25);
        frame.add(labelsi);
        textci = new JTextField(80);
        textci.setBounds(5, 350, 320, 15);
        frame.add(textci);

        labelo = new JLabel("Ubicación:");
        labelo.setBounds(5, 380, 250, 25);
        frame.add(labelo);
        texts = new JTextField(60);
        texts.setBounds(5, 400, 320, 15);
        frame.add(texts);

        button = new JButton("Test");
        button.setBounds(500, 1000, 150, 100);

        frame.add(button);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void show() {
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Userjc user = new Userjc();
        user.show();
    }
}