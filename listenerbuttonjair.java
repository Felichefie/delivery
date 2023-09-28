
import java.awt.event.AdjustmentEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class listenerbuttonjair {

    JFrame f;
    JTextField ft, tf2;
    JButton btn, btnborrar;
    listenerbuttonjair () {
        btn = new JButton("puchurrar");
        btnborrar = new JButton("borrar:)");
        ft = new JTextField("push my");
        tf2 = new JTextField("otro gato");

        f = new JFrame("BUTTON TEST");
        f.setSize(600, 300);

        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btnborrar.setBounds(180, 180, 80, 20);
        f.add(btn);
        f.add(btnborrar);
        f.add(tf);
        f.add(tf2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
