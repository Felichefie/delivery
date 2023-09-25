import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Listenerbutton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btnborrar;

    Listenerbutton() {
        btn = new JButton("Press");
        tf = new JTextField("Please Press Me");
        btnborrar = new JButton("Borrar");
        tf2 = new JTextField("Otro text field");
        f = new JFrame("Button Test");
        f.setSize(600, 300);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btnborrar.setBounds(180, 180, 80, 20);
        f.add(tf2);
        f.add(btn);
        f.add(tf);
        f.add(btnborrar);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
            }
        });
        btnborrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent q) {
                tf.setText("");
                tf2.setText("");
            }
        });
    }

    public void mostrar() {
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbutton lb;
        lb = new Listenerbutton();
        lb.mostrar();
        System.out.println(lb.tf.getText());
        System.out.println(lb.tf2.getText());
    }
}