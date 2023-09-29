import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class Ubicacion {
    private JLabel lbl_lat, lbl_lon;
    private JButton btn_borrar, btn_register;
    private JFrame frm_User;
    private JTextField txt_lat, txt_lon;

    // Variables para almacenar latitud y longitud
    private double latitud;
    private double longitud;

    public Ubicacion() {
        frm_User = new JFrame();

        btn_borrar = new JButton("Borrar");
        btn_borrar.setBounds(10, 200, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 200, 100, 50);
        lbl_lon = new JLabel("Longitud:");
        lbl_lon.setBounds(10, 20, 300, 30);
        lbl_lon.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_lat = new JLabel("Latitud:");
        lbl_lat.setBounds(10, 90, 300, 30);
        lbl_lat.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_lon = new JTextField();
        txt_lon.setBounds(10, 50, 250, 25);
        txt_lat = new JTextField();
        txt_lat.setBounds(10, 120, 250, 25);


        frm_User.add(lbl_lon);
        frm_User.add(btn_register);
        frm_User.add(btn_borrar);
        frm_User.add(lbl_lat);
        frm_User.add(txt_lon);
        frm_User.add(txt_lat);
                
        frm_User.setSize(400, 300);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Obtener los valores de latitud y longitud desde los campos de texto
                try {
                    latitud = Double.parseDouble(txt_lat.getText());
                    longitud = Double.parseDouble(txt_lon.getText());
                    // Llamar al método para imprimir
                    imprimir();
                } catch (NumberFormatException ex) {
                }
            }
        });

        btn_borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txt_lat.setText("");
                txt_lon.setText("");
            }
        });
    } 

    void show() {
        frm_User.setVisible(true);
    }

    // Método para imprimir latitud y longitud
    void imprimir() {
        System.out.println("Latitud: " + latitud);
        System.out.println("Longitud: " + longitud);
    }

    public static void main(String[] args) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.show();
    }
}
