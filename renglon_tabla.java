import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class renglon_tabla {
    Icon figura;
    String fig, Descripcion,costo,cantidad,carrito;

    public String getDescripcion() {return Descripcion;}
    public String getCosto() {return costo;}
    public String getCantidad() {return cantidad;}
    public String getCarrito() {return carrito;}

    public Object[] toArray(){
	Object[] a= {this.figura, this.Descripcion, this.costo, this.cantidad, this.carrito};
	//Object[] a= {this.fig, this.Descripcion, this.costo, this.cantidad, this.carrito};
	return a;
    }
    public Icon getfigura(){
        
        return this.figura;
    }

    //public static ImageIcon resize(ImageIcon image, int width, int height) {
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

    public renglon_tabla(String f, String d, String c,String can, String car){//constructor que recibe strings
        this.fig = f;
        this.Descripcion = d;
        this.costo = c;
        this.cantidad = can;
        this.carrito = car;
        this.figura = resize(fig, 60, 60);
    }

    public void imprimir(){
        System.out.println(this.fig + " " + this.Descripcion);
    }
    
}