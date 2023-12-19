import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Dir extends JPanel{
    private JTextField txt_street, txt_number, 
                       txt_number_two, txt_neighborhood, 
                       txt_city, txt_postal;
    private JButton btn_cancel, btn_register, btn_ubicacion, btn_calcular;
    public JComboBox<String> cmb_state , cmb_country;
    private Loc loc;
    public void mostrar(String street, int number, String number_two, String neighborhood,
                        String city, String state, String country, String postal_code){
                            txt_street.setText(street);
                            txt_number.setText(Integer.toString(number));
                            txt_number_two.setText(number_two);
                            txt_neighborhood.setText(neighborhood);
                            txt_city.setText(city);
                            cmb_state.setSelectedItem(state);
                            cmb_country.setSelectedItem(country);
                            txt_postal.setText(postal_code);    
                        }

    Dir() {

        setLayout(new GridLayout(10,2));
        
        btn_cancel = new JButton("CANCELAR");
        btn_register = new JButton("ACEPTAR");
        btn_ubicacion = new JButton("LOCATION");
        btn_calcular = new JButton("CALCULAR");
        

        add ( new JLabel("CALLE:"));
        txt_street = new JTextField();
        add(txt_street);

        add ( new JLabel("NUMERO:"));
        txt_number = new JTextField();
        add(txt_number);

        add ( new JLabel("NUMERO INTERIOR:"));
        txt_number_two = new JTextField();
        add(txt_number_two);

        add ( new JLabel("COLONIA:"));
        txt_neighborhood = new JTextField();
        add(txt_neighborhood);
        
        add ( new JLabel("CIUDAD:"));
        txt_city = new JTextField();
        add(txt_city);

        add ( new JLabel("ESTADO:"));
        String[] estados = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas",
        "Chihuahua", "Coahuila de Zaragoza", "Colima", "Durango", "Estado de México",
        "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán de Ocampo", "Morelos",
        "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo",
        "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala",
        "Veracruz de Ignacio de la Llave", "Yucatán", "Zacatecas"};
        cmb_state = new JComboBox<>(estados);
        add(cmb_state);

            add ( new JLabel("PAIS:"));
        String[] paises = {"Mexico"};
        cmb_country = new JComboBox<>(paises);
        add(cmb_country);

        add ( new JLabel("CODIGO POSTAL:"));
        txt_postal = new JTextField();
        add(txt_postal);

        loc = new Loc();

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(btn_register,"DATOS AGREGADOS DE MANERA EXITOSA.");
            }
        });
        add(btn_register);
        btn_ubicacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loc.show();
            }
        });
        add(btn_ubicacion);
        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        add(btn_cancel);
        btn_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedState = (String) cmb_state.getSelectedItem();
                if ("Aguascalientes".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria de 3 a 2 Dias Aprox");
                }
                else if("Baja California".equals(selectedState)) {
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8 o 9 Dias ");
                }
                else if ("Baja California Sur".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8-9 Dias");
                }
                else if ("Campeche".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 7-8 Dias");
                }
                else if ("Chiapas".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 7-8 Dias");
                }
                else if ("Chihuahua".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8-9 Dias");
                }
                else if ("Coahuila de Zaragoza".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8-9 Dias");
                }
                else if ("Colima".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Durango".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 6-7 Dias");
                }
                else if ("Estado de México".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Guanajuato".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Guerrero".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Hidalgo".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 4-5 Dias");
                }
                else if ("Jalisco".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Michoacán de Ocampo".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 1-2 Dias");
                }
                else if ("Morelos".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 3-4 Dias");
                }
                else if ("Nayarit".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 3-4 Dias");
                }
                else if ("Nuevo León".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8-9 Dias");
                }
                else if ("Oaxaca".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 5-6 Dias");
                }
                else if ("Puebla".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 4-5 Dias");
                }
                else if ("Querétaro".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 2-3 Dias");
                }
                else if ("Quintana Roo".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 7-8 Dias");
                }
                else if ("San Luis Potosí".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 4-5 Dias");
                }
                else if ("Sinaloa".equals (selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 6-7 Dias");
                }
                else if ("Sonora".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 8-9 Dias");
                }
                else if ("Tabasco".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 6-7 Dias");
                }
                else if ("Tamaulipas".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 9-10 Dias");
                }
                else if ("Tlaxcala".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 3-4 Dias");
                }
                else if ("Veracruz de Ignacio de la Llave".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 5-6 Dias");
                }
                else if ("Yucatán".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 7-8 Dias");
                }
                else if ("Zacatecas".equals(selectedState)){
                    JOptionPane.showMessageDialog(btn_calcular, "Su paquete llegaria en 4-5 Dias");
                }
                else {
                    JOptionPane.showMessageDialog(btn_calcular, "Estado no seleccionado");
                }
            }
        });
        add(btn_calcular);
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("DirPanel Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Dir dirPanel = new Dir();
            frame.getContentPane().add(dirPanel);

            frame.setSize(400,800);
            frame.setVisible(true);
            
        });
    }
}
