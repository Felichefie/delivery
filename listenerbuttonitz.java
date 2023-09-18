import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class listenerbuttonitz {
 
    JFrame f;
    JTextField tf;
    JButton btn;
    listenerbuttonitz () {
        btn = new JButton("Press");
        tf = new JTextField("Please press me");
        
        f = new JFrame("BUTTON TEST");
        f.setSize(400, 200);
        f.setVisible(true);

        tf.setBounds(20, 20, 180, 20);
        btn.setBounds(160, 160, 80, 20);

    }

}
