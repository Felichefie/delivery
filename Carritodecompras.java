import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Carritodecompras {
    private static int CantidadProducto1 = 0;
    private static int CantidadProducto2 = 0;
    private static int CantidadProducto3 = 0;
    private static final double PrecioProducto1 = 2799.89;
    private static final double PrecioProducto2 = 1204.68;
    private static final double PrecioProducto3 = 1499.99;
    
     
    public static void main (String[] args){
        crearcarrito();

        BufferedImage image = null;
        try {
            URL url = new URL("https://m.media-amazon.com/images/I/71W06bExp0S.__AC_SX300_SY300_QL70_ML2_.jpg");
            image = ImageIO.read(url);
        } catch(Exception e) {
        }
    }

    public static void crearcarrito(){

        JFrame carrito = new JFrame("Carrito de compras");
        carrito.setSize( 1000 , 1200);
        Color blue = new Color (133, 193, 233);
        Color gray = new Color (149, 165, 166);
        Color green = new Color (234, 236, 238);
        carrito.getContentPane().setBackground(blue);
        carrito.setLayout(null);

            ImageIcon producto1Icon = new ImageIcon("image1.jpg");
            ImageIcon producto2Icon = new ImageIcon("image2.jpg");
            ImageIcon producto3Icon = new ImageIcon("image3.jpg");

            ImagePanel producto1Panel = new ImagePanel(producto1Icon.getImage());
            ImagePanel producto2Panel = new ImagePanel(producto2Icon.getImage());
            ImagePanel producto3Panel = new ImagePanel(producto3Icon.getImage());

            producto1Panel.setBounds(700,20,200,300);
            producto2Panel.setBounds(700,400,150,300);
            producto3Panel.setBounds(700,760,150,150);



        JButton producto1Button = new JButton("Agregar al carrito");
        JButton producto2Button = new JButton("Agregar al carrito");
        JButton producto3Button = new JButton("Agregar al carrito");
        producto1Button.setBounds(20,20,200,20);
        producto2Button.setBounds(20, 400,200,20);
        producto3Button.setBounds(20,760,200,20);
        producto1Button.setBackground(gray);
        producto2Button.setBackground(gray);
        producto3Button.setBackground(gray);

        JLabel Piezasp1Label = new JLabel("Cantidad:" + CantidadProducto1);
        JLabel Piezasp2Label = new JLabel("Cantidad:" + CantidadProducto2);
        JLabel Piezasp3Label = new JLabel("Cantidad:" + CantidadProducto3);
        Piezasp1Label.setBounds(70,110,200,20);
        Piezasp2Label.setBounds(70,490,200,20);
        Piezasp3Label.setBounds(70,850,200,20);

        JLabel Descrip1Label = new JLabel("Revoltech: 032 Eva-01 New Movie Edition Action Figure by Kaiyodo" );
        JLabel Descrip2Label = new JLabel("Bandai Hobby #2 Model HG EVA-02 Production Model Neon Genesis Evangelion Action Figure (Limited Edition)");
        JLabel Descrip3Label = new JLabel("Sega Evangelion: 1.0: You are (Not) Alone Rei Ayanami Limited Premium Figura");
        Descrip1Label.setBounds(240,60,400,30);
        Descrip2Label.setBounds(240,440,400,20);
        Descrip3Label.setBounds(240,760,400,20);
        
        JLabel precio1Label = new JLabel("$MX" + PrecioProducto1);
        JLabel precio2Label = new JLabel("$MX" + PrecioProducto2);
        JLabel precio3Label = new JLabel("$MX" + PrecioProducto3);
        precio1Label.setBounds(400, 130, 100, 20);
        precio2Label.setBounds(400, 520, 100, 20);
        precio3Label.setBounds(400, 870, 100, 20);

        JLabel subtotalLabel = new JLabel("Subtotal: $" + calcularSubtotal());
        subtotalLabel.setBounds(70, 900, 150, 20);
        

        JButton MasP1button = new JButton("+");
        JButton MenosP1button = new JButton("-");
        JButton MasP2button = new JButton("+");
        JButton MenosP2button = new JButton("-");
        JButton MasP3button = new JButton("+");
        JButton MenosP3button = new JButton("-");
        MasP1button.setBounds(40,60,50,50);
        MenosP1button.setBounds(110,60,50,50);
        MasP2button.setBounds(40,440,50,50);
        MenosP2button.setBounds(110,440,50,50);
        MasP3button.setBounds(40,800,50,50);
        MenosP3button.setBounds(110,800,50,50);
        MasP1button.setBackground(green);
        MenosP1button.setBackground(green);
        MasP2button.setBackground(green);
        MenosP2button.setBackground(green);
        MasP3button.setBackground(green);
        MenosP3button.setBackground(green);

        producto1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                CantidadProducto1++;
                Piezasp1Label.setText("Cantidad: " + CantidadProducto1);
                subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                producto1Button.removeActionListener(this);
            }
        });
        producto2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                CantidadProducto2++;
                Piezasp2Label.setText("Cantidad: " + CantidadProducto2);
                producto2Button.removeActionListener(this);
            }
        });
        producto3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                CantidadProducto3++;
                Piezasp3Label.setText("Cantidad: " + CantidadProducto3);
                producto3Button.removeActionListener(this);
            }
        });
        MasP1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                CantidadProducto1++;
                Piezasp1Label.setText("Cantidad:" + CantidadProducto1);
                subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                }
            });
        MasP2button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                CantidadProducto2++;
                Piezasp2Label.setText("Cantidad:" + CantidadProducto2);
                subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                }
            });
        MasP3button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                CantidadProducto3++;
                Piezasp3Label.setText("Cantidad:" + CantidadProducto3);
                subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
            }
            });
        MenosP1button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (CantidadProducto1 > 0) {
                    CantidadProducto1--;
                    Piezasp1Label.setText("Cantidad:" + CantidadProducto1);
                    subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                }
            }

        });
        MenosP2button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (CantidadProducto2 > 0) {
                    CantidadProducto2--;
                    Piezasp2Label.setText("Cantidad:" + CantidadProducto2);
                    subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                }
            }

        });
        MenosP3button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (CantidadProducto3 > 0) {
                    CantidadProducto3--;
                    Piezasp3Label.setText("Cantidad:" + CantidadProducto3);
                    subtotalLabel.setText("Subtotal: $" + calcularSubtotal());
                }
            }

        });

        carrito.add(new JLabel(producto1Icon));
        carrito.add(producto1Button);
        carrito.add(producto2Button);
        carrito.add(producto3Button);
        carrito.add(Piezasp1Label);
        carrito.add(Piezasp2Label);
        carrito.add(Piezasp3Label);
        carrito.add(MasP1button);
        carrito.add(MasP2button);
        carrito.add(MasP3button);
        carrito.add(MenosP1button);
        carrito.add(MenosP2button);
        carrito.add(MenosP3button);
        carrito.add(Descrip1Label);
        carrito.add(Descrip2Label);
        carrito.add(Descrip3Label);
        carrito.add(producto1Panel);
        carrito.add(producto2Panel);
        carrito.add(producto3Panel);
        carrito.add(producto1Panel);
        carrito.add(producto2Panel);
        carrito.add(producto3Panel);
        carrito.add(precio1Label);
        carrito.add(precio2Label);
        carrito.add(precio3Label);
        carrito.add(subtotalLabel);

        carrito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carrito.setVisible(true);
        
    }

    private static double calcularSubtotal() {
        return CantidadProducto1 * PrecioProducto1 +
               CantidadProducto2 * PrecioProducto2 +
               CantidadProducto3 * PrecioProducto3;
    }

    static class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(Image image) {
            this.image = image;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0,0,getWidth(), getHeight(),this);
            }
        }
    }
}