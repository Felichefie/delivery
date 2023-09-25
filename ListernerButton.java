import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ListernerButton {
    JFrame f;
    JTextField tf_nombre,tf2_primer_apellido, tf3_segundo_apellido, tf4_email, tf5_telefono;
    JButton btn_accept,btn_cancel;

    ListernerButton(){ // C O N S T R U C T O R
        btn_accept = new JButton("Aceptar");
        tf_nombre = new JTextField("Alesos");
        f = new JFrame("Button Example");
        btn_cancel = new JButton("Cancelar");
        f.setSize(600,300);
        tf_nombre.setBounds(20,20,180,20);
        tf2_primer_apellido = new JTextField("Coronao");
        tf2_primer_apellido.setBounds(20,40,180,20);        
        btn_accept.setBounds(160,160,120,20);
        btn_cancel.setBounds(180,180,80,20);
        tf3_segundo_apellido = new JTextField("Perez");
        tf3_segundo_apellido.setBounds(20,60,180,20);
        tf4_email = new JTextField("alesos@gmail.com");
        tf4_email.setBounds(20,80,180,20);
        tf5_telefono = new JTextField("+52 729 515 9174");
        tf5_telefono.setBounds(20,100,180,20);
        f.add(btn_accept);
        f.add(tf_nombre);
        f.add(tf2_primer_apellido);
        f.add(btn_cancel);
        f.add(tf3_segundo_apellido);
        f.add(tf4_email);
        f.add(tf5_telefono);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn_accept.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Usuario usuario = new Usuario(tf_nombre.getText(), tf2_primer_apellido.getText());
                System.out.println(tf2_primer_apellido.getText());
                System.out.println(tf_nombre.getText());

        }
    });
    btn_cancel.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent q){
            tf_nombre.setText("");
            tf2_primer_apellido.setText("");
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
        System.out.println(lb.tf_nombre.getText());
        
    }
    
    
}
