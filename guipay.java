import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class guipay {
    JLabel l_metodo;
    JComboBox c_comBox;
    JButton btn_aceptar,btn_cancelar;
    static int metodo_pago = 0;

    public static JComboBox getpaymetodos(){   
        Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
        Connection conn = dbconnection.getConn();
        
        String query = "SELECT type FROM progra2.type_pay WHERE id_user=112 AND id>10";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        JComboBox<String> c_comBox = new JComboBox<String>();
        try{
                    
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            
            while(rset.next()){
                
                c_comBox.addItem(rset.getString(1));
            
        }
    }
        catch(SQLException e){
            System.out.println("Error en la query");
         
        }
        
        
        c_comBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				metodo_pago=c_comBox.getSelectedIndex();
			}
		});
        return c_comBox;

    }

    public static void main(String[] args) {
        carrito car = new carrito();
        double d = car.getSubtotal();
        JFrame frame = new JFrame("Metodo");
        JComboBox c_combBox = getpaymetodos();
        c_combBox.setBounds(100,100,100,100);
        
        JButton btn_pagar = new JButton();
        btn_pagar.setBounds(100,200,100,100);
        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("metodo de pago " + metodo_pago);
                System.out.println("total a pagar " + d);
                /*if(metodo_pago==0){
                    JOptionPane.showMessageDialog(null, "Seleccione un metodo de pago");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Pagado con exito");
                }*/
            }
        });

        JLabel l_cantidad_pagar = new JLabel() ;
        l_cantidad_pagar.setBounds(100,20,100,100);
        l_cantidad_pagar.setText(Double.toString(d));



        
        frame.add(c_combBox);
        frame.add(btn_pagar);
        frame.add(l_cantidad_pagar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible( true );
    }

}
    

