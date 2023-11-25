import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;


    public class tabla1 extends JPanel {

    JButton btn_carrito;
 
    public static ImageIcon resize(ImageIcon image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image.getImage(), 0, 0, width, height, null);
        g2d.dispose();
        return new ImageIcon(bi);
    }



    public tabla1() {
        String[] columnNames = {"Picture", "Description", "Costo", "Stock", "Carrito"};
        
      
        Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
        Connection conn = dbconnection.getConn();

        String query = "SELECT image,description,price,stock FROM progra2.products ";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        ArrayList<Object[]> al = new ArrayList<Object[]>();

        try{
                    
        
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            
           
            
            
            while(rset.next()){
           
                al.add(new renglon_tabla(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), "5").toArray());
            }
            
        }
        catch(SQLException e){
            System.out.println("Error en la query");
         
        }
        

       Object[][] data = new Object[al.size()][];
       for (int i = 0; i < data.length; i++) {
        Object[] row = al.get(i);
        data[i] = row;
    }

       DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return ImageIcon.class;
                default:
                    return String.class;
            }
        }
    };

       JTable table = new JTable(model);
       table.setPreferredSize(new Dimension(1024,1024));
       TableColumnModel columnModel = table.getColumnModel();
       columnModel.getColumn(0).setPreferredWidth(70);
       table.setRowHeight(70);


        JScrollPane scrollPane = new JScrollPane( table );
        add(scrollPane);

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


