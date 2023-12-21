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
    // esta es una gui para registrar una forma de pago del usuario
    // las formas acepatadas de pago son, tarjeta de credito, debito y transferencia
    // si es tarjeta se requiere el numero de cuenta, si es transferencia se
    // requiere la cuenta clabe
    // habra un boton que cuando lo presionas se agrega el metodo de pago a la base
    // de datos
    // boton cancelar, no hace nada
    // ventana dos

    public Agregar_forma_pago() {
        JFrame metods;
        metods = new JFrame("metods");

        JButton btn_aceptar, btn_cancelar;
        btn_aceptar = new JButton("Aceptar");
        btn_cancelar = new JButton("Cancelar");
        btn_aceptar.setBounds(20, 200, 60, 30);
        btn_cancelar.setBounds(100, 200, 60, 30);

        JTextField txt_metodo = new JTextField("");
        txt_metodo.setBounds(130, 50, 100, 30);

        JLabel l_metodo = new JLabel("Cuenta o Clabe");
        l_metodo.setBounds(140, 20, 100, 30);

        JComboBox<String> c_comBox = new JComboBox<String>();
        c_comBox.addItem("credit_card");
        c_comBox.addItem("debit_card");
        c_comBox.addItem("transfer");
        c_comBox.addItem("Efective");
        c_comBox.setBounds(20, 50, 100, 30);

        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("agregando tipo de pagos a la base de datos");
                Dbconnection dbConnection = new Dbconnection();
                Connection conn = dbConnection.getConn();

                String query = "INSERT INTO progra2.type_pay (id_user, type, account_number, clabe)";

                if (c_comBox.getSelectedItem().equals("credit_card")
                        || c_comBox.getSelectedItem().equals("debit_card")) {

                    query = query + " VALUES (112,'" + c_comBox.getSelectedItem()
                            + "','" + txt_metodo.getText()
                            + "','" + "NULL"
                            + "' )";

                    System.out.println(query);
                } else if (c_comBox.getSelectedItem().equals("Efective")) {

                    query = "INSERT INTO progra2.type_pay (id_user, type)" +
                            " VALUES (112, 'Efective')";

                    System.out.println(query);
                } else {
                    query = query + " VALUES (112,'" + c_comBox.getSelectedItem()
                            + "','" + "NULL"
                            + "','" + txt_metodo.getText()
                            + "' )";

                    System.out.println(query);
                }

                try {
                    PreparedStatement preState = conn.prepareStatement(query);
                    preState.execute();

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

        metods.setSize(400, 400);
        metods.setLayout(null);
        metods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        metods.setVisible(true);
    }
}