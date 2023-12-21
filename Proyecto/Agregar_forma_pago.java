package Proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Agregar_forma_pago {
    public Agregar_forma_pago() {
        JFrame metods;
        metods = new JFrame("Métodos de Pago");

        JButton btn_aceptar, btn_cancelar;
        btn_aceptar = new JButton("Aceptar");
        btn_cancelar = new JButton("Cancelar");
        btn_aceptar.setBounds(20, 200, 100, 30);
        btn_cancelar.setBounds(150, 200, 100, 30);

        JTextField txt_metodo = new JTextField();
        txt_metodo.setBounds(130, 50, 150, 30);

        JLabel l_metodo = new JLabel("Cuenta o Clabe");
        l_metodo.setBounds(140, 20, 150, 30);

        JComboBox<String> c_comBox = new JComboBox<String>();
        c_comBox.addItem("Tarjeta de Crédito");
        c_comBox.addItem("Tarjeta de Débito");
        c_comBox.addItem("Transferencia");
        c_comBox.addItem("Efectivo");
        c_comBox.setBounds(20, 50, 100, 30);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Agregando tipo de pago a la base de datos");
                Dbconnection dbConnection = new Dbconnection();
                Connection conn = dbConnection.getConn();

                String query = "INSERT INTO progra2.type_pay (id_user, type, account_number, clabe)";

                if (c_comBox.getSelectedItem().equals("Tarjeta de Crédito")
                        || c_comBox.getSelectedItem().equals("Tarjeta de Débito")) {

                    query += " VALUES (112,'" + c_comBox.getSelectedItem()
                            + "','" + txt_metodo.getText()
                            + "','" + "NULL"
                            + "' )";

                    System.out.println(query);
                } else if (c_comBox.getSelectedItem().equals("Efectivo")) {

                    query = "INSERT INTO progra2.type_pay (id_user, type)" +
                            " VALUES (112, 'Efectivo')";

                    System.out.println(query);
                } else {
                    query += " VALUES (112,'" + c_comBox.getSelectedItem()
                            + "','" + "NULL"
                            + "','" + txt_metodo.getText()
                            + "' )";

                    System.out.println(query);
                }

                try {
                    PreparedStatement preState = conn.prepareStatement(query);
                    preState.execute();
                    System.out.println("Tipo de pago agregado exitosamente");
                } catch (SQLException q) {
                    q.printStackTrace();
                    System.out.println("Error en la query Insert");
                }
            }
        });

        btn_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metods.dispose();
            }
        });

        metods.add(btn_aceptar);
        metods.add(btn_cancelar);
        metods.add(l_metodo);
        metods.add(c_comBox);
        metods.add(txt_metodo);

        metods.setSize(300, 300);
        metods.setLayout(null);
        metods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        metods.setVisible(true);
    }
}
