import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Direccion {
    private JFrame frame;
    private JLabel lbl_calleNumero;
    private JLabel lbl_colonia;
    private JLabel lbl_ciudad;
    private JLabel lbl_codigoPostal;
    private JLabel lbl_referencia;
    private JLabel lbl_pais;

    private JTextField tfCalleNumero;
    private JTextField tfColonia;
    private JTextField tfCiudad;
    private JTextField tfCodigoPostal;
    private JTextField tfReferencia;
    private JTextField tfPais;

    private JButton btnImprimir;
    private JButton btnCancelar; 

    Direccion() {
        frame = new JFrame("Dirección");
        frame.setLayout(null);
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl_calleNumero = new JLabel("Calle y Número:");
        lbl_calleNumero.setBounds(10, 10, 120, 20);
        tfCalleNumero = new JTextField();
        tfCalleNumero.setBounds(140, 10, 200, 20);

        lbl_colonia = new JLabel("Colonia:");
        lbl_colonia.setBounds(10, 40, 120, 20);
        tfColonia = new JTextField();
        tfColonia.setBounds(140, 40, 200, 20);

        lbl_ciudad = new JLabel("Ciudad:");
        lbl_ciudad.setBounds(10, 70, 120, 20);
        tfCiudad = new JTextField();
        tfCiudad.setBounds(140, 70, 200, 20);

        lbl_codigoPostal = new JLabel("Código Postal:");
        lbl_codigoPostal.setBounds(10, 100, 120, 20);
        tfCodigoPostal = new JTextField();
        tfCodigoPostal.setBounds(140, 100, 200, 20);

        lbl_referencia = new JLabel("Referencia:");
        lbl_referencia.setBounds(10, 130, 120, 20);
        tfReferencia = new JTextField();
        tfReferencia.setBounds(140, 130, 200, 20);

        lbl_pais = new JLabel("País:");
        lbl_pais.setBounds(10, 160, 120, 20);
        tfPais = new JTextField();
        tfPais.setBounds(140, 160, 200, 20);

        btnImprimir = new JButton("Aceptar");
        btnImprimir.setBounds(10, 190, 150, 30);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 190, 150, 30); 


        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimir();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        frame.add(lbl_calleNumero);
        frame.add(tfCalleNumero);
        frame.add(lbl_colonia);
        frame.add(tfColonia);
        frame.add(lbl_ciudad);
        frame.add(tfCiudad);
        frame.add(lbl_codigoPostal);
        frame.add(tfCodigoPostal);
        frame.add(lbl_referencia);
        frame.add(tfReferencia);
        frame.add(lbl_pais);
        frame.add(tfPais);
        frame.add(btnImprimir);
        frame.add(btnCancelar); 
        
    }

    public Direccion(String calleNumero, String colonia, String ciudad, String referencia, int codigoPostal,
            String pais) {
    }

    void show() {
        frame.setVisible(true);
    }

    void imprimir() {
        String calleNumero = tfCalleNumero.getText();
        String colonia = tfColonia.getText();
        String ciudad = tfCiudad.getText();
        int codigoPostal = Integer.parseInt(tfCodigoPostal.getText());
        String referencia = tfReferencia.getText();
        String pais = tfPais.getText();

        Direccion direccion = new Direccion(calleNumero, colonia, ciudad, referencia, codigoPostal, pais);
        direccion.imprimir();
    }

    void cancelar() {
        tfCalleNumero.setText("");
        tfColonia.setText("");
        tfCiudad.setText("");
        tfCodigoPostal.setText("");
        tfReferencia.setText("");
        tfPais.setText("");
    }

    public static void main(String[] args) {
        Direccion direccion = new Direccion();
        direccion.show();
    }
}