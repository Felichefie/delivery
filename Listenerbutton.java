package delivery;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listenerbutton{
    JFrame f;
    JTextField tf, tf2;
    JButton btn, btnborrar;
        /**
         * 
         */
        Listenerbutton(){
        btn = new JButton("Press");
        btn.setBounds(160, 160, 80, 20);
        btnborrar = new JButton("Borrar");
        btnborrar.setBounds(180, 180, 80, 20);
        tf = new JTextField("Please press me");
        tf.setBounds(20, 20, 180, 20);
        tf2 = new JTextField("Please press me");
        tf2.setBounds(20, 40, 180, 20);
        f = new JFrame("Buttontest");
        f.setSize(600, 300);

        f.add(btnborrar);
        f.add(btn);
        f.add(tf);   
        f.add(tf2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(tf.getText());
            System.out.println(tf2.getText());

        }
    });
    btn.addActionListener(new ActionListener(){
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