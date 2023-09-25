import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerButton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btnborrar;
    ListenerButton(){
        btn = new JButton("Press");
        tf = new JTextField("Please press me");
        f = new JFrame("button test");
        tf2 = new JTextField("Another text field");
        btnborrar =  new JButton("Borrar");
        
        f.setSize(600, 300);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btnborrar.setBounds(180, 180, 80, 20);
       
        f.add(btn);
        f.add(tf);
        f.add(tf2);
        f.add(btnborrar);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
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
    public void show(){
       f.setVisible(true);
    }
    public static void main(String[] args) {
        ListenerButton lb;
        lb = new ListenerButton();
        lb.show();
        System.out.println(lb.tf.getText());
    }
}
