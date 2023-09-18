
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listenerbutton {
    JFrame f;
    JTextField tf,tf2;
    JButton btn,btnborrar;
    
    Listenerbutton (){
        btn = new JButton ("press");
        tf = new JTextField("plis press me");
        btnborrar = new JButton("borrara");
        tf2 = new JTextField("otro text field");
        f = new JFrame ("buttontest");
        f.setSize(600,300);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btnborrar.setBounds(180, 180, 80, 20);
        f.add(btnborrar);
        f.add(tf2);
        f.add(btn);
        f.add(tf);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf2.getText());
                System.out.println(tf.getText());

            }
        });
        btnborrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent q){
                tf.setText("");
                tf2.setText("");
            }
        });
    }
    public void mostrar(){
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbutton lb;
        lb = new Listenerbutton();
        lb.mostrar();
        System.out.println(lb.tf.getText());
        

    }
}
