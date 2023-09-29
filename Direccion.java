import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;

public class Direccion {
    private JLabel lbl_calle, lbl_colonia, lbl_ciudad, lbl_pais, lbl_referencia, lbl_codigoPostal;
    private JButton btn_borrar, btn_register, btn_ubicacion;
    private JFrame frm_User;
    private JTextField txt_calle, txt_colonia, txt_ciudad, txt_pais, txt_referencia, txt_codigoPostal;

    private String calle;
    private String colonia;
    private String ciudad;
    private int codigoPostal;
    private String pais;
    private String referencia;

    public Direccion() {
        frm_User = new JFrame();

        btn_borrar = new JButton("Borrar");
        btn_borrar.setBounds(10, 500, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 500, 100, 50);
        btn_ubicacion = new JButton("Ubicacion");
        btn_ubicacion.setBounds(145, 500, 100, 50);

        lbl_calle = new JLabel("Calle:");
        lbl_calle.setBounds(10, 20, 300, 30);
        lbl_calle.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_colonia = new JLabel("Colonia:");
        lbl_colonia.setBounds(10, 90, 300, 30);
        lbl_colonia.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_ciudad = new JLabel("Ciudad:");
        lbl_ciudad.setBounds(10, 160, 300, 30);
        lbl_ciudad.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_pais = new JLabel("Pais:");
        lbl_pais.setBounds(10, 230, 300, 30);
        lbl_pais.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_referencia = new JLabel("Referencia:");
        lbl_referencia.setBounds(10, 300, 300, 30);
        lbl_referencia.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_codigoPostal = new JLabel("Codigo Postal:");
        lbl_codigoPostal.setBounds(10, 370, 300, 30);
        lbl_codigoPostal.setFont(new Font("Arial", Font.PLAIN, 18));

        txt_calle = new JTextField();
        txt_calle.setBounds(10, 50, 250, 25);
        txt_pais = new JTextField();
        txt_pais.setBounds(10, 260, 250, 25);
        txt_colonia = new JTextField();
        txt_colonia.setBounds(10, 120, 250, 25);
        txt_ciudad = new JTextField();
        txt_ciudad.setBounds(10, 190, 250, 25);
        txt_referencia = new JTextField();
        txt_referencia.setBounds(10, 330, 250, 25);
        txt_codigoPostal = new JTextField();
        txt_codigoPostal.setBounds(10, 400, 250, 25);

        frm_User.add(lbl_calle);
        frm_User.add(btn_register);
        frm_User.add(btn_borrar);
        frm_User.add(lbl_colonia);
        frm_User.add(lbl_ciudad);
        frm_User.add(lbl_pais);
        frm_User.add(txt_pais);
        frm_User.add(txt_colonia);
        frm_User.add(txt_ciudad);
        frm_User.add(txt_calle);
        frm_User.add(txt_referencia);
        frm_User.add(lbl_referencia);
        frm_User.add(lbl_codigoPostal);
        frm_User.add(txt_codigoPostal);
        frm_User.add(btn_ubicacion);
                
        frm_User.setSize(400, 600);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    codigoPostal = Integer.parseInt(txt_codigoPostal.getText());
                    // Actualizar variables con los datos ingresados
                    calle = txt_calle.getText();
                    colonia = txt_colonia.getText();
                    ciudad = txt_ciudad.getText();
                    pais = txt_pais.getText();
                    referencia = txt_referencia.getText();
        
                    // No crees una nueva instancia de Direccion, ya que estás en la instancia actual
                    imprimir(); // Llama al método imprimir() de la instancia actual
                } catch (NumberFormatException ex) {
                    // Manejo de excepciones
                }
            }
        });
        
        btn_ubicacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Crear una instancia de Ubicacion
                Ubicacion ubicacion = new Ubicacion();
                ubicacion.show();
            }
        });

        btn_borrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Limpiar los campos de entrada
                txt_calle.setText("");
                txt_colonia.setText("");
                txt_ciudad.setText("");
                txt_pais.setText("");
                txt_referencia.setText("");
                txt_codigoPostal.setText("");
            }
        });
        
    } 

    void show() {
        frm_User.setVisible(true);
    }

    // Método para imprimir datos de dirección
    void imprimir() {
        System.out.println("Calle: " + calle);
        System.out.println("Colonia: " + colonia);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("País: " + pais);
        System.out.println("Referencia: " + referencia);
        System.out.println("Código Postal: " + codigoPostal);

    }

    public static void main(String[] args) {
        Direccion direccion = new Direccion();
        direccion.show();
    }
}