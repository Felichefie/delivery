import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.gson.JsonElement;

public class Guidistancia {
static ArrayList<String> a;
    public Guidistancia() {
        

        JFrame frame = new JFrame("Guidistancia");
        JLabel l_origen = new JLabel("Origen");
        JTextField txt_origen = new JTextField("CiudadUniversitaria,Morelia,Mexico");
        JLabel l_destino = new JLabel("Destino");
        JTextField txt_destino = new JTextField("Uruapan,Mexico");
        JLabel l_datos = new JLabel("Tiempo y Distancia del Pedido");
        JLabel l_recomendacion = new JLabel("Favor de solamente ingresar comas; sin acentos,espacio o ñ");

        /*JTextField txt_tiempo = new JTextField();
        JTextField txt_distancia = new JTextField();*/
        JTextArea t_info = new JTextArea();
        JButton btn_calcular = new JButton("Calcular");
        JButton btn_cancelar = new JButton("Cancelar");

        l_origen.setBounds(20, 20, 100, 30);
        txt_origen.setBounds(20,60,100,30);
        l_destino.setBounds(20, 100, 100, 30);
        txt_destino.setBounds(20, 140, 100, 30);
        l_recomendacion.setBounds(20, 180, 500, 70);
        btn_calcular.setBounds(20, 260, 100, 30);
        btn_cancelar.setBounds(150, 260, 100, 30);
        l_datos.setBounds(20, 300, 400, 30);

        t_info.setBounds(20, 340, 300, 100);

        btn_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ConnectionMain c = new ConnectionMain(txt_origen.getText(),txt_destino.getText());
                c.geta();
                
                /*for (String s: a) {
                    System.out.println(s);
                    t_info.setText(s);
                }*/
                for(int i=0; i < c.geta().size(); i++){
                System.out.println(c.geta().get(i));
                t_info.setText(c.geta().get(i));                  
                }
               
                
            }
        });

        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        /*txt_tiempo.setBounds(20, 260, 100, 30);
        txt_distancia.setBounds(20, 340, 100, 30);*/


        frame.add(l_destino);
        frame.add(l_origen);
        frame.add(l_datos);
        frame.add(l_recomendacion);
        frame.add(txt_destino);
       // frame.add(txt_distancia);
       // frame.add(txt_tiempo);
        frame.add(txt_origen);
        frame.add(btn_calcular);
        frame.add(btn_cancelar);
        frame.add(t_info);






        
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
}

