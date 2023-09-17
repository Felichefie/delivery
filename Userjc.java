import javax.swing.*;

public class Userjc {
    private JLabel labelu;
    private JButton button;
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