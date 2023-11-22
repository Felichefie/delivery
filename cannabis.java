import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
 import javax.swing.*; 
public class cannabis {

        JFrame f;    
        cannabis(){    
        f=new JFrame();    
        String data[][]={ {"imagen 1","Descripcion 1","Costo 1","Cantidad 1", "Carrito 1"},    
                              {"imagen 2","Descripcion 2","Costo 2", "Cantidad 2", "Carrito 2"},    
                              {"imagen 3","Descripcion 3","Costo 3", "Cantidad 3","Carrito 3"}};    
        String column[]={"Imagen","Descripcion ","Costo","Cantidad","Carrito"};         
        JTable jt=new JTable(data,column);    
        jt.setBounds(30,40,200,300);          
        JScrollPane sp=new JScrollPane(jt);    
        f.add(sp);          
        f.setSize(300,400);    
        f.setVisible(true);    
    }     
    public static void main(String[] args) {    
        new cannabis();    
    }    
    }  







   
