import javax.swing.*;

public class Userjc {
    private JLabel label;
    private JButton button;
    private JFrame frame;

    Userjc() {
        frame = new JFrame();
        button = new JButton("Test");
        button.setBounds(10, 50, 150, 100);
        label = new JLabel("test");
        label.setBounds(10,20,300,30);

        frame.add(label);
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