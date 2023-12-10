import javax.swing.*;
import java.awt.*;

public class TarjetaCDPanel extends JPanel {

    private JTextField Titular;
    private JTextField Banco;
    private JTextField Tipo;
    private JTextField NumeroTarjeta;
    private JTextField FechaVencimiento;

    public TarjetaCDPanel(){
        setLayout(new GridLayout(5,2));

        add (new JLabel("Titular:"));
        Titular = new JTextField();
        add(Titular);

        add (new JLabel("Banco:"));
        Banco = new JTextField();
        add(Banco);

        add (new JLabel("Credito/Debito:"));
        Tipo = new JTextField();
        add(Tipo);

        add (new JLabel("Numero de Tarjeta:"));
        NumeroTarjeta = new JTextField();
        add(NumeroTarjeta);

        add (new JLabel("Fecha de Vencimiento"));
        FechaVencimiento = new JTextField();
        add(FechaVencimiento);

    }
    public String getTitular() {
        return Titular.getText();
    }

    public String getBanco() {
        return Banco.getText();
    }

    public String getTipo() {
        return Tipo.getText();
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta.getText();
    }

    public String getFechaVencimiento() {
        return FechaVencimiento.getText();
    }

    
}
