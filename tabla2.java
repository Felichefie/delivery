import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.table.*;

public class tabla2 extends JPanel
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
    public tabla2()
    {
      

        ImageIcon f3 = new ImageIcon("/home/hyundi/Downloads/imagen3.jpg");
        ImageIcon f2 = new ImageIcon("/home/hyundi/Downloads/imagen2.jpg");
        ImageIcon f1 = new ImageIcon("/home/hyundi/Downloads/imagen1.png");
        Icon figura1 = resize (f1,60,60);
        Icon figura2 = resize (f2,60,60);
        Icon figura3 = resize (f3,60,60);

       
       

        /*String[] columnNames = {"Picture", "Description","Costo", "Cantidad","Carrito"};
        Object[][] data =
        {
            {figura1, "About","chana","dato","dat0"},
            {figura2, "Add","1","2","3",},
            {figura3, "Copy","3","4","6"},
            
        };*/

       /*  DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };*/
        DefaultTableModel model2 = new DefaultTableModel(); 
        JTable table = new JTable(model2); 

        // Create a couple of columns 
        model2.addColumn("Col1"); 
        model2.addColumn("Col2"); 
        model2.addColumn("Col3");

        // Append a row 
        model2.addRow(new Object[]{figura1, "v2","dato3"});

        /*//JTable table = new JTable( model );
        //table.setSize(1024,1024);
        table.setPreferredSize(new Dimension(1024,1024));
       // table.setPreferredScrollableViewportSize(getSize());
       // table.setBounds(0,0,1024,1024);
       TableColumnModel columnModel = table.getColumnModel();
       columnModel.getColumn(0).setPreferredWidth(70);
       table.setRowHeight(70);*/
      


        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Table Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1500);
        frame.add(new tabla2());
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


