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



        button = new JButton("Test");
        button.setBounds(10, 50, 150, 100);

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