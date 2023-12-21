package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pagar {

    public void mostrarVentanaPago() {

        double subtotal = 0;
        double iva = 0;
        double total = 0;
        JFrame frame;
        JButton btn_cerrar;
        JLabel l_agradecimiento, l_subtotal, l_total, l_iva;

        Iva i = new Iva(0);
        iva = iva + i.getimpuesto();
        subtotal = subtotal + i.getbase();
        frame = new JFrame();
        total = total + subtotal + iva;

        btn_cerrar = new JButton("cerrar");
        l_agradecimiento = new JLabel("Agradecemos su preferencia, vuelva pronto");
        l_subtotal = new JLabel("Subtotal " + String.valueOf(subtotal));

        l_total = new JLabel("Total " + String.valueOf(total));
        l_iva = new JLabel("IVA " + String.valueOf(iva));

        btn_cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        l_agradecimiento.setBounds(20, 20, 500, 30);
        l_subtotal.setBounds(20, 60, 200, 30);
        l_iva.setBounds(20, 100, 200, 30);
        l_total.setBounds(20, 140, 200, 30);
        btn_cerrar.setBounds(20, 180, 200, 30);

        frame.add(l_agradecimiento);
        frame.add(l_subtotal);
        frame.add(l_iva);
        frame.add(l_total);
        frame.add(btn_cerrar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}