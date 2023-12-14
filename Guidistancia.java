import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Guidistancia {
    
    public static void main(String[] args) {
        
    
    
        JFrame frame = new JFrame("Guidistancia");
        JLabel l_origen = new JLabel("Origen");
        JTextField txt_origen = new JTextField("Ciudad Universitaria, Morelia, Mexico");
        JLabel l_destino = new JLabel("Destino");
        JTextField txt_destino = new JTextField();
        JLabel l_tiempo = new JLabel("Tiempo");
        JTextField txt_tiempo = new JTextField();
        JLabel l_distancia = new JLabel("Distancia");
        JTextField txt_distancia = new JTextField();
        JButton btn_calcular = new JButton("Calcular");
        JButton btn_cancelar = new JButton("Cancelar");



        l_origen.setBounds(20, 20, 100, 30);
        txt_origen.setBounds(20,60,100,30);
        l_destino.setBounds(20, 100, 100, 30);
        txt_destino.setBounds(20, 140, 100, 30);
        btn_calcular.setBounds(20, 180, 60, 30);
        btn_cancelar.setBounds(100, 180, 60, 30);
        l_tiempo.setBounds(20, 220, 100, 30);
        txt_tiempo.setBounds(20, 260, 100, 30);
        l_distancia.setBounds(20, 300, 100, 30);
        txt_distancia.setBounds(20, 340, 100, 30);


        frame.add(l_destino);
        frame.add(l_origen);
        frame.add(l_tiempo);
        frame.add(l_distancia);
        frame.add(txt_destino);
        frame.add(txt_distancia);
        frame.add(txt_tiempo);
        frame.add(txt_origen);
        frame.add(btn_calcular);
        frame.add(btn_cancelar);






        
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

