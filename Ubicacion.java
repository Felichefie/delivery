import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ubicacion {
    private JLabel lbl_latitud;
    private JLabel lbl_longitud;
    private JTextField tf_latitud;
    private JTextField tf_longitud;
    private JButton btn_aceptar;
    private JButton btn_cancelar; // Agregar botón "Cancelar"
    private JFrame frame;

    Ubicacion() {
        frame = new JFrame("Ubicación");
        frame.setLayout(null);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_latitud = new JLabel("Latitud:");
        lbl_latitud.setBounds(10, 10, 120, 20);
        tf_latitud = new JTextField();
        tf_latitud.setBounds(140, 10, 200, 20);

        lbl_longitud = new JLabel("Longitud:");
        lbl_longitud.setBounds(10, 40, 120, 20);
        tf_longitud = new JTextField();
        tf_longitud.setBounds(140, 40, 200, 20);

        btn_aceptar = new JButton("Aceptar");
        btn_aceptar.setBounds(10, 70, 100, 30);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirUbicacion();
            }
        });

        btn_cancelar = new JButton("Cancelar"); // Botón "Cancelar"
        btn_cancelar.setBounds(120, 70, 100, 30); // Posición del botón "Cancelar"

        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarUbicacion();
            }
        });

        frame.add(lbl_latitud);
        frame.add(tf_latitud);
        frame.add(lbl_longitud);
        frame.add(tf_longitud);
        frame.add(btn_aceptar);
        frame.add(btn_cancelar); // Agregar el botón "Cancelar"
    }

    void show() {
        frame.setVisible(true);
    }

    private void imprimirUbicacion() {
        String latitud = tf_latitud.getText();
        String longitud = tf_longitud.getText();

        System.out.println("Latitud: " + latitud);
        System.out.println("Longitud: " + longitud);
    }

    private void cancelarUbicacion() {
        tf_latitud.setText("");
        tf_longitud.setText("");
    }

    public static void main(String[] args) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.show();
    }

    public void imprimir() {
    }
}
