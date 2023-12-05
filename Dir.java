import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;

public class Dir extends JPanel{
    private JTextField txt_street, txt_number, txt_number_two, txt_neighborhood, txt_city, txt_state, 
                       txt_country, txt_postal;
    private JLabel lbl_nom, lbl_street, lbl_number, lbl_number_two, lbl_neighborhood, lbl_city, lbl_state, 
                   lbl_country, lbl_postal;
    private JButton btn_cancel, btn_register, btn_ubicacion;
    private Loc loc;
    public void mostrar(String street, int number, String number_two, String neighborhood,
                        String city, String state, String country, String postal_code){
                            txt_street.setText(street);
                            txt_number.setText(Integer.toString(number));
                            txt_number_two.setText(number_two);
                            txt_neighborhood.setText(neighborhood);
                            txt_city.setText(city);
                            txt_state.setText(state);
                            txt_country.setText(country);
                            txt_postal.setText(postal_code);    
                        }

    Dir() {

        setLayout(null);
        
        btn_cancel = new JButton("CANCELAR");
        btn_cancel.setBounds(10, 600, 100, 50);
        btn_register = new JButton("ACCEPT");
        btn_register.setBounds(145, 600, 100, 50);
        btn_ubicacion = new JButton("LOCATION");
        btn_ubicacion.setBounds(275, 600, 100, 50);
        

        lbl_nom = new JLabel("Hernandez Marin Maria Itzel.");
        lbl_nom.setBounds(150,645,300,30);
        lbl_nom.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_street = new JLabel("STREET:");
        lbl_street.setBounds(140,20,300,30);
        lbl_number = new JLabel("NUMBER:");
        lbl_number.setBounds(140,90,300,30);
        lbl_number_two = new JLabel("NUMBER TWO:");
        lbl_number_two.setBounds(140,160,300,30);
        lbl_neighborhood = new JLabel("COLONY:");
        lbl_neighborhood.setBounds(140,230,300,30);
        lbl_city = new JLabel("CITY:");
        lbl_city.setBounds(140,300,300,30);
        lbl_state = new JLabel("STATE:");
        lbl_state.setBounds(140,370,300,30);
        lbl_country = new JLabel("COUNTRY:");
        lbl_country.setBounds(140,440,300,30);
        lbl_postal = new JLabel("POSTAL CODE:");
        lbl_postal.setBounds(140,510,300,30);
        
        txt_street = new JTextField();
        txt_street.setBounds(140, 50, 250, 25);
        txt_number = new JTextField();
        txt_number.setBounds(140, 120, 250, 25);
        txt_number_two = new JTextField();
        txt_number_two.setBounds(140, 190, 250, 25);
        txt_neighborhood = new JTextField();
        txt_neighborhood.setBounds(140, 260, 250, 25);
        txt_city = new JTextField();
        txt_city.setBounds(140, 330, 250, 25);
        txt_state = new JTextField();
        txt_state.setBounds(140, 400, 250, 25);
        txt_country = new JTextField();
        txt_country.setBounds(140, 470, 250, 25);
        txt_postal = new JTextField();
        txt_postal.setBounds(140, 540, 250, 25);
    
        add(lbl_nom);
        add(lbl_street);
        add(lbl_number);
        add(lbl_number_two);
        add(lbl_neighborhood);
        add(lbl_city);
        add(lbl_state);
        add(lbl_country);
        add(lbl_postal);
        add(txt_street);
        add(txt_number);
        add(txt_number_two);
        add(txt_neighborhood);
        add(txt_city);
        add(txt_state);
        add(txt_country);
        add(txt_postal);
        add(btn_register);
        add(btn_cancel);
        add(btn_ubicacion);

        loc = new Loc();

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(btn_register,"DATOS AGREGADOS DE MANERA EXITOSA.");
            }
        });

        btn_ubicacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loc.show();
            }
        });

        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
    } 

    /* void mostrar(String street, int number, String number_two, String neighborhood, 
                 String city, String state, String country, String postal_code){
        txt_street.setText(street);
        txt_number.setText(Integer.toString(number));
        txt_number_two.setText(number_two);
        txt_neighborhood.setText(neighborhood);
        txt_city.setText(city);
        txt_state.setText(state);
        txt_country.setText(country);
        txt_postal.setText(postal_code);
    }/* */

   /*  private JPanellabel, JTextField textField){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Impact", Font.PLAIN, 14));
        panel.add(lbl);
        panel.add(textField);
        return panel;
    }
 /* */
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