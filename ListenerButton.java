import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.*;

public class ListenerButton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btn2;

    ListenerButton(){

        btn = new JButton("press");
        btn2 = new JButton("Limpiar");
        tf = new JTextField("please press me");
        tf2 = new JTextField("Otro text field");
        f = new JFrame("button test");
        f.setSize(600, 300);
        tf.setBounds(20,20,180,20);
        tf2.setBounds(20,40,180,20);
        btn.setBounds(160, 160, 80, 20);
        btn2.setBounds(300, 160, 80, 20);
        f.add(btn);
        f.add(btn2);
        f.add(tf);
        f.add(tf2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(btn, tf.getText());
                JOptionPane.showMessageDialog(btn, tf2.getText());
            }
        });
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tf.setText("");
                tf2.setText("");
            }
        });

    }
    
    public void  mostrar(){

        f.setVisible(true);

    }
    public static void main(String[] args) {
        
        ListenerButton lb;
        lb = new ListenerButton();
        lb.mostrar();
        System.out.println(lb.tf.getText());

    }

}
