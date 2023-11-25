import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class frame {
   
    

    public static ImageIcon resize(String f, int width, int height) {
                //ImageIcon f1 = new ImageIcon(f);
                ImageIcon f1 = loadImage(f);
            BufferedImage fi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
            Graphics2D g2d = (Graphics2D) fi.createGraphics();
            g2d.addRenderingHints(//  ww  w  . jav  a2 s. c o m
                    new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(f1.getImage(), 0, 0, width, height, null);
            g2d.dispose();
            return new ImageIcon(fi);
    }
    private static ImageIcon loadImage(String path) {
        try {
            if (path.startsWith("http")) {
                URL url = new URL(path);
                return new ImageIcon(ImageIO.read(url));
            } else {
                return new ImageIcon(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
    
    carrito carro = new carrito();
    JFrame f_tienda;
    JLabel l_subtotal;
    
    l_subtotal = new JLabel("subtotal " + carro.getSubtotal());
    l_subtotal.setBounds(20, 5, 200, 20);
    f_tienda = new JFrame("tienda");
    f_tienda.setSize(700, 300);
    f_tienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f_tienda.setLayout(null);
    f_tienda.setVisible(true);
    f_tienda.add(l_subtotal);
    Dbconnection dbconnection = new Dbconnection("jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno", "alumnoPrueba1");
    Connection conn = dbconnection.getConn();
    String query = "SELECT image,description,price,stock FROM progra2.products ";
    System.out.println(query);
    ResultSet rset;
    Statement statement;
    try{
        statement = conn.createStatement();
        rset = statement.executeQuery(query);
        int i=0;
        while(rset.next()){
        dibujando(l_subtotal, carro, i++, f_tienda,rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
        }
    }
    catch(SQLException e){
        System.out.println("Error en la query");
         
    }
                
    try{
        conn.close();
    }catch (SQLException q) {
        q.printStackTrace();
    }

  
        
    }


    static void dibujando(JLabel l_subtotal, carrito carro,int i, JFrame f_tienda,String image, String descripcion, String precio, String stock){
        
    JButton btn_carrito,btn_mas,btn_menos,btn_aceptar,btn_cacelar;
    JLabel l_descripcion,l_imagen,l_precio,l_stock;
    JTextField txt_cantidad;
    int margen_superior = 30;
    int t_imagen = 80;

    
  
    
        Icon icon = resize(image ,t_imagen,t_imagen );
    l_imagen = new JLabel(icon);
    
    //f_tienda.getContentPane().add(label);
    Border line = BorderFactory.createLineBorder(Color.RED, 2);
    l_imagen.setBorder(line);
    l_descripcion = new JLabel(descripcion);
    l_precio = new JLabel(precio);
    l_stock = new JLabel(stock);
    Icon car = new ImageIcon("/home/hyundi/Downloads/carrito.png");
    btn_carrito = new JButton(car);

    btn_mas = new JButton(" + ");
    txt_cantidad = new JTextField("0");


    btn_mas.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String mas = txt_cantidad.getText();
            int cantidad = Integer.parseInt(mas);
            cantidad++;
            txt_cantidad.setText(String.valueOf(cantidad));
        }});

    btn_menos = new JButton(" - ");
    
    btn_menos.addActionListener(new ActionListener(){
     @Override
        public void actionPerformed(ActionEvent e){
            String menos = txt_cantidad.getText();
            int cantidad = Integer.parseInt(menos);
            if(cantidad!=0)cantidad--;
            txt_cantidad.setText(String.valueOf(cantidad));
        }});

         btn_carrito.addActionListener(new ActionListener(){

     @Override
        public void actionPerformed(ActionEvent e){
            String cantiString = txt_cantidad.getText();
            int cantidad = Integer.parseInt(cantiString);
            if(cantidad!=0){
                double s = cantidad * Double.parseDouble(l_precio.getText());
                carro.agregar(s);
                System.out.println("agregar " + s +  " subtotal " + carro.getSubtotal());
                l_subtotal.setText(" subtotal " + carro.getSubtotal());
            }
           
        }});

        
   
    int x_imagen = 20, y_imagen = margen_superior + i*(t_imagen+20);
    int x_desc = x_imagen+t_imagen+10, y_desc = y_imagen, w_desc = 150, h_desc = 30;
    int x_precio = x_desc,  y_precio=y_desc+h_desc, w_precio = 150, h_precio = 30;
    int x_stock = x_desc, y_stock = y_precio+h_precio, w_stock = 150, h_stock = 30;
    int x_btn_carrito = w_desc+x_desc+10, y_btn_carrito = y_desc+h_desc, w_btn_carrito = 80, h_btn_carrito = 50;

    //int x_cantidad = 360, y_cantidad = 40, w_cantidad = 40, h_cantidad = 20;
    int x_btn_mas = x_btn_carrito+w_btn_carrito+10, y_btn_mas = y_imagen, w_btn_mas = 80, h_btn_mas = 20;
    int w_txt_cantidad = 40,x_txt_cantidad = x_btn_mas+w_btn_mas/2-w_txt_cantidad/2, y_txt_cantidad=y_btn_mas+h_btn_mas+10, h_txt_cantidad=20;
    int x_btn_menos = x_btn_mas, y_btn_menos = y_txt_cantidad+h_txt_cantidad+10, w_btn_menos = 80, h_btn_menos = 20;
    

    l_imagen.setBounds(x_imagen,y_imagen, t_imagen, t_imagen);
    l_descripcion.setBounds(x_desc, y_desc, w_desc, h_desc);
    l_precio.setBounds(x_precio, y_precio, w_precio, h_precio);
    l_stock.setBounds(x_stock, y_stock, w_stock, h_stock);
    btn_carrito.setBounds(x_btn_carrito, y_btn_carrito, w_btn_carrito,h_btn_carrito);
    btn_mas.setBounds(x_btn_mas, y_btn_mas, w_btn_mas, h_btn_mas);
    btn_menos.setBounds(x_btn_menos,y_btn_menos,w_btn_menos,h_btn_menos);
    txt_cantidad.setBounds(x_txt_cantidad,y_txt_cantidad,w_txt_cantidad,h_txt_cantidad);


    f_tienda.add(btn_carrito);
    f_tienda.add(btn_mas);
    f_tienda.add(btn_menos);
    f_tienda.add(l_descripcion);
    f_tienda.add(l_imagen);
    f_tienda.add(l_precio);
    f_tienda.add(l_stock);
    f_tienda.add(txt_cantidad);
    
    }
 
    

}


