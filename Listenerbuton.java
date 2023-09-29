import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Listenerbuton {
    JFrame f;
    JTextField tf,tf2;
    JButton btn,btn_borrar;
    Listenerbuton(){
        btn=new JButton("press");
        tf =new JTextField("plis press me");
        btn_borrar=new JButton("Borrar");
        tf2 =new JTextField("otro text field");
        f  =new JFrame("Buttontest");
        f.setSize(600,300);        
        tf.setBounds(20, 20, 180, 20);
        tf2.setBounds(20, 40, 180, 20);
        btn.setBounds(160, 160, 80, 20);
        btn_borrar.setBounds(180, 180, 80, 20);
        f.add(btn_borrar);
        f.add(tf2);
        f.add(btn);
        f.add(tf);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(tf.getText());
                System.out.println(tf2.getText());
            }
        });
        btn_borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tf.setText(null);
                tf2.setText(null);
                
            }
        });

    }
    public void mostrar(){
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Listenerbuton lb;
        lb=new Listenerbuton();
        lb.mostrar(); 
        System.out.println(lb.tf.getText());
        
    }
}
