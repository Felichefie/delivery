import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class renglon_tabla {
    Icon figura;
    String fig, Descripcion,costo,cantidad,carrito;


    public String getDescripcion() {return Descripcion;}
    public String getCosto() {return costo;}
    public String getCantidad() {return cantidad;}
    public String getCarrito() {return carrito;}
    public Icon getfigura(){
        
        return this.figura;
    }

    //public static ImageIcon resize(ImageIcon image, int width, int height) {
            public static ImageIcon resize(String f, int width, int height) {
                ImageIcon f1 = new ImageIcon(f);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
            Graphics2D g2d = (Graphics2D) bi.createGraphics();
            g2d.addRenderingHints(//  ww  w  . jav  a2 s. c o m
                    new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
            g2d.drawImage(f1.getImage(), 0, 0, width, height, null);
            g2d.dispose();
            return new ImageIcon(bi);
        }


    public renglon_tabla(String f, String d, String c,String can, String car){
        this.fig = f;
        this.Descripcion = d;
        this.costo = c;
        this.cantidad = can;
        this.carrito = car;
        this.figura = resize(fig, 60, 60);


    }

    public void imprimir(){
        System.out.println(this.figura + this.Descripcion);
    }


    
}
