package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Guipay {
    JLabel l_metodo;
    JComboBox c_comBox;
    JButton btn_aceptar, btn_cancelar;
    static int metodo_pago = 0;

    public static JComboBox getpaymetodos() {
        Dbconnection dbConnection = new Dbconnection();
        Connection conn = dbConnection.getConn();

        String query = "SELECT type,id,account_number,clabe FROM progra2.type_pay WHERE id_user=112 AND id>10";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        JComboBox<Object> c_comBox = new JComboBox<Object>();
        try {

            statement = conn.createStatement();
            rset = statement.executeQuery(query);

            while (rset.next()) {

                Item_pago i = new Item_pago(Integer.parseInt(rset.getString(2)), rset.getString(1), rset.getString(3),
                        rset.getString(4));
                // public item_pago(int id, String type, String account_number, String clabe) {

                c_comBox.addItem(i);

            }
        } catch (SQLException e) {
            System.out.println("Error en la query");

        }

        c_comBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                metodo_pago = c_comBox.getSelectedIndex();
            }
        });
        return c_comBox;

    }

    public Guipay() {
        Carrito car = new Carrito();
        double d = car.getSubtotal();
        JFrame frame = new JFrame("Metodo");
        JComboBox c_combBox = getpaymetodos();

        c_combBox.setBounds(100, 100, 300, 50);

        JButton btn_pagar = new JButton();
        btn_pagar.setBounds(100, 200, 100, 40);
        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("metodo de pago " + metodo_pago);
                System.out.println("total a pagar " + d);

            }
        });

        JLabel l_cantidad_pagar = new JLabel();
        l_cantidad_pagar.setBounds(100, 20, 100, 100);
        l_cantidad_pagar.setText(Double.toString(d));

        frame.add(c_combBox);
        frame.add(btn_pagar);
        frame.add(l_cantidad_pagar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
