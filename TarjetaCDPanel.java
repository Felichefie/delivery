import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarjetaCDPanel extends JPanel {

    private JTextField Titular;
    private JTextField Banco;
    private JComboBox <String> Tipo;
    private JTextField NumeroTarjeta;
    private JTextField FechaVencimiento;
    private JButton validar;

    public TarjetaCDPanel(){
        setLayout(new GridLayout(6,2));

        add (new JLabel("Titular:"));
        Titular = new JTextField();
        add(Titular);

        add (new JLabel("Banco:"));
        Banco = new JTextField();
        add(Banco);

        add (new JLabel("Credito/Debito:"));
        String [] tipos = {"Credito","Debito"};
        Tipo = new JComboBox<>(tipos);
        add(Tipo);

        add (new JLabel("Numero de Tarjeta:"));
        NumeroTarjeta = new JTextField();
        add(NumeroTarjeta);

        add (new JLabel("Fecha de Vencimiento"));
        FechaVencimiento = new JTextField();
        add(FechaVencimiento);

        validar = new JButton("Validar");
        validar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String titular = Titular.getText();
                String banco = Banco.getText();
                String numeroTarjeta = NumeroTarjeta.getText();

                if (titular.isEmpty() || banco.isEmpty() || numeroTarjeta.length() !=16 ){
                    JOptionPane.showMessageDialog(null, "Porfavor, introduce los datos correctamente.");
                }
                else
                {JOptionPane.showMessageDialog(null, "Los datos son validos.");
            }
                }
            
        });
        add(validar);

    }
    public String getTitular() {
        return Titular.getText();
    }

    public String getBanco() {
        return Banco.getText();
    }

    public String getTipo() {
        return (String) Tipo.getSelectedItem();
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta.getText();
    }

    public String getFechaVencimiento() {
        return FechaVencimiento.getText();
    }

    public static void  main (String [] args) {
        TarjetaCDPanel tarjetaPanel = new TarjetaCDPanel();

        JPanel mainPanel = new JPanel();

        mainPanel.add(tarjetaPanel);

        JFrame frame = new JFrame ("Tajerta de Credito/Debito");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}