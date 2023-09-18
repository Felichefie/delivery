import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ListenerButton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btn_borrar;

    ListenerButton (){
        btn = new JButton("Press");
        tf = new JTextField("Please press me");
        btn_borrar = new JButton("Borrar") ;
        tf2 = new JTextField("Otro text Field");
        f = new JFrame("Button test");
        f.setSize(600, 300);
        //f.setVisible(true);
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btn.setBounds(180, 180, 80, 20);
        f.add(tf);
        f.add(tf2);
        f.add(btn);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
            }
        });
        btn_borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent f){
                tf.setText("");
                tf2.setText("");
            }
        });

    }
    public void mostrar() {
        f.setVisible(true);
    }
    public static void main(String[]args){
    ListenerButton lb;
    lb  = new ListenerButton();
    lb.mostrar();
    System.out.println(lb.tf.getText());
    System.out.println(lb.tf2.getText());
    }

}
