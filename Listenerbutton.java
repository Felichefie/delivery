import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listenerbutton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btn_borrar;

    Listenerbutton() {

        btn = new JButton("Click Me");
        btn_borrar = new JButton("Borrar");
        btn_borrar.setBounds(180, 180, 20, 20);
        tf = new JTextField("Please prees me");
        f = new JFrame("Button test");
        tf2 = new JTextField("otro text field");

        f.setSize(600, 400);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(tf);
        f.add(tf2);
        f.add(btn);
        f.add(btn_borrar);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
            }
        });
        btn_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
                tf2.setText("");
            }
        });

    public void mostrar() {
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbutton lb;
        lb = new Listenerbutton();
        lb.mostrar();
        // System.out.println(lb.tf.getText());
        // System.out.println(lb.tf2.getText());

    }
}