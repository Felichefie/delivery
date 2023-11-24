import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class CarritoDeCompras {
    private static int cantidadProducto1 = 0;
    private static int cantidadProducto2 = 0;
    private static int cantidadProducto3 = 0;

    public static void main(String[] args) {
        createCarrito();

        BufferedImage image = null;
        try {
            URL url = new URL("https://www.freepik.es/fotos-vectores-gratis/tomate-dibujo");
            image = ImageIO.read(url);
        } catch (Exception e) {
            
        }
    }

    public static void createCarrito() {
        
        
//............................  CREA LA INTERFAZ.........................
    JFrame carrito = new JFrame("PRODUCTO");
    carrito.setSize(700,600);
    Color bluee = new Color(182, 240, 255 );
    Color bluus = new Color(76, 218, 255);
    Color greene = new Color(72, 179, 178 );
    carrito.getContentPane().setBackground(bluee);
    carrito.setLayout(null);

  

//imagenes de productos
    ImageIcon producto1Icon = new ImageIcon("P1");
    //java.awt.Image Imagen1Escalada = producto1Icon.getImage().getScaledInstance(60, 100, Image.SCALE_SMOOTH);
    //ImageIcon Imagen1EscaladaIcon = new ImageIcon(Imagen1Escalada);
    //JLabel etiqueta1imagen = new JLabel(Imagen1EscaladaIcon);

    ImageIcon producto2Icon = new ImageIcon("P2");
    ImageIcon producto3Icon = new ImageIcon("p3");

//botones para productos
    JButton producto1Button = new JButton("Agregar al carrito");
    producto1Button.setBounds(20, 20, 200, 20);
    producto1Button.setBackground(bluus);
    JButton producto2Button = new JButton("Agregar al carrito");
    producto2Button.setBounds(20,200, 200,20);
    producto2Button.setBackground(bluus);
    JButton producto3Button = new JButton("Agregar al carrito");
    producto3Button.setBounds(20,360,200,20);
    producto3Button.setBackground(bluus);


//Etiqueta para msotar la cantidad de cada producto
    JLabel cantidadProducto1Label = new JLabel("Cantidad: " + cantidadProducto1);
    cantidadProducto1Label.setBounds(240,100,200,20);
    JLabel cantidadProducto2Label = new JLabel("Cantidad: " + cantidadProducto2);
    cantidadProducto2Label.setBounds(240,300,100,20);
    JLabel cantidadProducto3Label = new JLabel("Cantidad: " + cantidadProducto3);
    cantidadProducto3Label.setBounds(240,470,100,20);

//Botones para aumentar o disminuir la cantidad de cada producto

    JButton aumentarProducto1Button = new JButton(" + ");
    JButton disminuirProducto1Button = new JButton(" - ");
    aumentarProducto1Button.setBounds(40, 60, 50,50);
    disminuirProducto1Button.setBounds(110,60,50,50);
    aumentarProducto1Button.setBackground(greene);
    disminuirProducto1Button.setBackground(greene);

    JButton aumentarProducto2Button = new JButton(" + ");
    JButton disminuirProducto2Button = new JButton(" - ");
    aumentarProducto2Button.setBounds(40,240, 50,50);
    disminuirProducto2Button.setBounds(110,240,50,50);
    aumentarProducto2Button.setBackground(greene);
    disminuirProducto2Button.setBackground(greene);

    JButton aumentarProducto3Button = new JButton(" + ");
    JButton disminuirProducto3Button = new JButton(" - ");
    aumentarProducto3Button.setBounds(40,420,50,50);
    disminuirProducto3Button.setBounds(110,420,50,50);
    aumentarProducto3Button.setBackground(greene);
    disminuirProducto3Button.setBackground(greene);

// Acciones para los botones "AGREGAR AL CARRITO"
        producto1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto1++;
                cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
            }
        });

        producto2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto2++;
                cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
            }
        });

        producto3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto3++;
                cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
            }
        });

// Acciones para botones de aumentar o disminuir cantidades
        aumentarProducto1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto1++;
                cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
            }
        });
        disminuirProducto1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cantidadProducto1 > 0) {
                    cantidadProducto1--;
                    cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
                }
            }
        });

        aumentarProducto2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto2++;
                cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
            }
        });
        disminuirProducto2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cantidadProducto2 > 0) {
                    cantidadProducto2--;
                    cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
                }
            }
        });

        aumentarProducto3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadProducto3++;
                cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
            }
        });
        disminuirProducto3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cantidadProducto3 > 0) {
                    cantidadProducto3--;
                    cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
                }
            }
        });

        

//Agregar componentes a la interfaz
   carrito.add(new JLabel(producto1Icon));
   carrito.add(producto1Button);
   carrito.add(producto2Button);
   carrito.add(producto3Button);
   carrito.add(cantidadProducto1Label);
   carrito.add(cantidadProducto2Label);
   carrito.add(cantidadProducto3Label);
   //boton agrega y disminuye
   carrito.add(aumentarProducto1Button);
   carrito.add(disminuirProducto1Button);
   carrito.add(aumentarProducto2Button);
   carrito.add(disminuirProducto2Button);
   carrito.add(aumentarProducto3Button);
   carrito.add(disminuirProducto3Button);
   //agrega imagenes
  // carrito.add(etiqueta1imagen);

    carrito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    carrito.setVisible(true);
  


    }
}
