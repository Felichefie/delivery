import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListenerButton {
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btnBorrar;

    ListenerButton(){
        btn = new JButton("press");
        btnBorrar = new JButton("BORRAR");
        tf = new JTextField("please, press me");
        tf2 = new JTextField("OTROO TEXTFIELD");
        f  = new JFrame("BUTTON TEST");
        f.setLayout(null);
        f.setSize(600,400);
        tf.setBounds(200, 10, 180, 20);
        tf2.setBounds(200, 300, 180, 20);
        btn.setBounds(240, 160, 80, 20);
        btnBorrar.setBounds(240, 180, 80, 20);
        f.add(btn);
        f.add(btnBorrar);
        f.add(tf);
        f.add(tf2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ESCUCHAR AL BOTON 1
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
            }

        });
        //ESCUCHAR AL BOTON 2
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                tf.setText(" ");
                tf2.setText(" ");

            }
            
        });
        
    }
    public void mostrar(){
        f.setVisible(true);

    }

    public static void main(String[] args){
        ListenerButton lb;
        lb = new ListenerButton();
        lb.mostrar();
        System.out.println(lb.tf.getText());
        System.out.println(lb.tf2.getText());
        
    }

    

    
}
