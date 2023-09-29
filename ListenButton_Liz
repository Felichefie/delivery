import java.awt.event.ActionListener;//bibliotecas
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
public class ListenerButton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btnborrar;

    ListenerButton(){
        btn = new JButton("press");
        tf = new JTextField("please press me");
        btnborrar = new JButton("borrar");
        tf2 = new JTextField("otro text field");
        f = new JFrame("button test");
        f.setSize(400, 400);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btnborrar.setBounds(200, 180, 80, 20);
        f.add(btn);
        f.add(tf);
        f.add(tf2);
        f.add(btnborrar);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para cerrar todo cuando nos salimos
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
                
            }
        });
        btnborrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q) {
                tf.setText("");
                tf2.setText("");
                
            }
        });
    }
    public void mostrar(){
    f.setVisible(true);

    }
    public static void main(String[] args) {
        ListenerButton lb;
        lb = new ListenerButton();   
        lb.mostrar();
        System.out.println(lb.tf.getText());
                System.out.println(lb.tf.getText());
    }
}
