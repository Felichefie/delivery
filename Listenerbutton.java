
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listenerbutton{
    JFrame f;
    JTextField tf_nombre, tf_primer_apellido, tf_email, tf_segundo_apellido, tf_telefono;
    JButton btn_aceptar, btn_cancelar;
        

        Listenerbutton(int i){
        btn_aceptar = new JButton("Press");
        btn_aceptar.setBounds(20, 200, 80, 20);
        btn_cancelar = new JButton("Borrar");
        btn_cancelar.setBounds(150, 200, 80, 20);
        tf_nombre = new JTextField("Anibal");
        tf_nombre.setBounds(20, 20, 180, 20);
        tf_primer_apellido = new JTextField("Zavala");
        tf_primer_apellido.setBounds(20, 50, 180, 20);
        tf_segundo_apellido = new JTextField("Herrera");
        tf_segundo_apellido.setBounds(20, 80, 180, 20);
        tf_email = new JTextField("1911690k@umich.mx");
        tf_email.setBounds(20, 110, 180, 20);
        tf_telefono = new JTextField("445432r2");
        tf_telefono.setBounds(20, 140, 180, 20 ); 
       

        f = new JFrame("Buttontest");
        f.setSize(450, 400);

        f.add(btn_cancelar);
        f.add(btn_aceptar);
        f.add(tf_nombre);   
        f.add(tf_primer_apellido);
        f.add(tf_segundo_apellido);
        f.add(tf_email);
        f.add(tf_telefono);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_aceptar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Usuario usuario = new Usuario(tf_nombre.getText(), tf_primer_apellido.getText(), tf_segundo_apellido.getText(), tf_email.getText(),tf_telefono.getText());
            
            usuario.imprimir_datos_personales();

        }
    });
    btn_cancelar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent q){
            tf_nombre.setText("");
            tf_primer_apellido.setText("");     
            tf_segundo_apellido.setText("");
            tf_email.setText("");  
            tf_telefono.setText("");     

    }
        });
    }
    public void mostrar(){
          f.setVisible(true);

    }
      public static void main(String[] args) {
    Listenerbutton lb;
     lb = new Listenerbutton(20);
        lb.mostrar();

    System.out.println(lb.tf_nombre.getText());
    

}


}