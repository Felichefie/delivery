import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListernerButton {
    JFrame f;
    JTextField tf,tf2;
    JButton btn,btn2;

    ListernerButton(){ // C O N S T R U C T O R
        btn = new JButton("Press");
        tf = new JTextField("Please press me");
        f = new JFrame("Button Example");
        btn2 = new JButton("Borrar");
        f.setSize(600,300);
        tf.setBounds(20,20,180,20);
        tf2 = new JTextField("otro text field");
        tf2.setBounds(20,40,180,20);        
        btn.setBounds(160,160,80,20);
        btn2.setBounds(180,180,80,20);
        f.add(btn);
        f.add(tf);
        f.add(tf2);
        f.add(btn2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(tf2.getText());
                System.out.println(tf.getText());


        }
    });
    btn2.addActionListener(new ActionListener(){
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

    public static void main(String[] args) { //M A I N
        ListernerButton lb;
        lb = new ListernerButton();
        lb.mostrar();
        
        System.out.println(lb.tf.getText());
        
    }
    
    
}
