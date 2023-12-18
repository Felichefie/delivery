import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarjetaCDPanel extends JPanel {

    private JTextField Titular;
    private JComboBox <String> Banco;
    private JComboBox <String> Tipo;
    private JTextField NumeroTarjeta;
    private JButton validar;
    private JComboBox <String> Fechas;

    public TarjetaCDPanel(){
        setLayout(new GridLayout(7,2));

        add (new JLabel("Titular:"));
        Titular = new JTextField();
        add(Titular);

        add (new JLabel("Banco:"));
        String [] bancos = {"BBVA", "HSBC", "Santander", "Banco Azteca", "Banamex", "Banorte", "Scotiabank", "Banregio", "Banco del Bajio", "Banco Inbursa", "Banco Mifel", "Banco Famsa", "Banco Afirme", "Banco Compartamos", "Banco Multiva", "Banco Ve por Mas", "Banco Forjadores", "Banco Ahorro Famsa", "Banco Autofin", "Banco Base", "Banco Monex", "Banco Bancrea", "Banco Actinver", "Banco Bansefi", "Banco Inmobiliario Mexicano", "Banco Inmobiliario Mexicano", "Banco Regional de Monterrey", "Banco Sabadell", "Banco S3", "Banco Wal-Mart de Mexico", "Banco Ahorro Walmart", "Banco Ahorro"};
        Banco = new JComboBox<>(bancos);
        add(Banco);

        add (new JLabel("Credito/Debito:"));
        String [] tipos = {"Credito","Debito"};
        Tipo = new JComboBox<>(tipos);
        add(Tipo);

        add (new JLabel("Numero de Tarjeta:"));
        NumeroTarjeta = new JTextField();
        add(NumeroTarjeta);

        add (new JLabel("Fecha de Vencimiento"));
        String [] fechas = {"01/23","02/23","03/23","04/23","05/23","06/23","07/23","08/23","09/23","10/23","11/23","12/23"};
        Fechas = new JComboBox<>(fechas);
        add(Fechas);

        validar = new JButton("Validar");
        validar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String titular = Titular.getText();
                String banco = Banco.getSelectedItem().toString();
                String numeroTarjeta = NumeroTarjeta.getText();

                if (titular.isEmpty() || banco.isEmpty() || numeroTarjeta.length() !=16 || !numeroTarjeta.matches("[0-9]+")){
                    JOptionPane.showMessageDialog(null, "Por favor, introduce los datos correctamente.");
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
        return (String) Banco.getSelectedItem();
    }

    public String getTipo() {
        return (String) Tipo.getSelectedItem();
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta.getText();
    }

    public String getFecha() {
        return (String) Fechas.getSelectedItem();
    }

    public static void  main (String [] args) {

        TarjetaCDPanel  tarjetaPanel = new TarjetaCDPanel();

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