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

    private JFrame frame;

    Userjc() {
        frame = new JFrame();
        button = new JButton("Test");
        button.setBounds(10, 50, 150, 100);
        labelu = new JLabel("JAIRRR");
        labelu.setBounds(10,20,300,30);
        frame.add(labelu);

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