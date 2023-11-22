import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.*;

public class tabla1 extends JPanel
{
      public static ImageIcon resize(ImageIcon image, int width, int height) {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(//  ww  w  . jav  a2 s. c o m
                    new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(image.getImage(), 0, 0, width, height, null);
            g2d.dispose();
            return new ImageIcon(bi);
        }
    public tabla1()
    {
        

        /*ImageIcon f3 = new ImageIcon("/home/hyundi/Downloads/imagen3.jpg");
        ImageIcon f2 = new ImageIcon("/home/hyundi/Downloads/imagen2.jpg");
        ImageIcon f1 = new ImageIcon("/home/hyundi/Downloads/imagen1.png");
        Icon figura1 = resize (f1,60,60);
        Icon figura2 = resize (f2,60,60);
        Icon figura3 = resize (f3,60,60);
*/
        String[] columnNames = {"Picture", "Description","Costo", "Cantidad","Carrito"};
        /*Object[][] data =
        {
            {figura1, "About","chana","dato","dat0"},
            {figura2, "Add","1","2","3",},
            {figura3, "Copy","3","4","6"},
            
        };
*/
         //DefaultTableModel model = new DefaultTableModel(data, columnNames)
        DefaultTableModel model = new DefaultTableModel()

        {
           /*  //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            
            {
                return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class<?> getColumnClass(int column) {
            switch (column) {
            case 0: return Icon.class;
            default: return String.class;
        }
    }
        };


    
        Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
        Connection conn = dbconnection.getConn();

        String query = "SELECT image FROM progra2.products ";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

         ArrayList<renglon_tabla> al = new ArrayList<>();
        try{
           
          //  al.add(new renglon_tabla("1", "2", "3", "4", "5"));
           
        
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            Object[][] data;
            while(rset.next()){
             //   System.out.println(rset.getString(1));
                al.add(new renglon_tabla(rset.getString(1), "2", "3", "4", "5"));

                
            }
            for(int i=0;i<4;i++){
             renglon_tabla r = al.get(i);
            r.imprimir();
            }
        }
        catch(SQLException e){
            System.out.println("Error en la query");
           // user.setId(1);
        }

        /*Object[][] data =
        {
            {figura1, "About","chana","dato","dat0"},
            {figura2, "Add","1","2","3",},
            {figura3, "Copy","3","4","6"},
            
        };*/
        model.addColumn("Figura"); 
        model.addColumn("Descripcion"); 
        model.addColumn("Costo");
        model.addColumn("Cantidad");
        model.addColumn("Carrito");

        model.addRow(new Object[]{al.get(0).getfigura(),al.get(0).getDescripcion(),al.get(0).getCosto(),al.get(0).getCantidad(),al.get(0).getCarrito()});
        JTable table = new JTable( model );
        

        //table.setSize(1024,1024);
        table.setPreferredSize(new Dimension(1024,1024));
       // table.setPreferredScrollableViewportSize(getSize());
       // table.setBounds(0,0,1024,1024);
       TableColumnModel columnModel = table.getColumnModel();
       columnModel.getColumn(0).setPreferredWidth(70);
       table.setRowHeight(70);


        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );
      



    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1500);
        frame.add(new tabla1());
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }


    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
    
}

