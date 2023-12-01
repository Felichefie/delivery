import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ProductoGUI extends JFrame {
    private JLabel imagenLabel;
    private JLabel descripcionLabel;
    private JLabel costoLabel;
    private JButton agregarUnidadButton;
    private JButton disminuirUnidadButton;
    private JTextField unidadesTextField;
    private JButton agregarAlCarritoButton;
    private JButton cambiarProductoButton;

    private int cantidadUnidades = 0;
    private int productoActual = 0;

    private Producto[] productos = {
            new Producto("https://i.ytimg.com/vi/otkrvn4d0U8/maxresdefault.jpg", "Espada del Legendario ninja Genji", 19.99),
            new Producto("https://m.media-amazon.com/images/I/61nGnOwXWyL._AC_UY1000_.jpg", "Outfit usado por El Calmao Martinez", 29.99),
            
    };

    public ProductoGUI() {
        setTitle("Tienda en Línea");
        setSize(1100,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imagenLabel = new JLabel();
        cargarImagen(productos[productoActual].getImagen()); 
        descripcionLabel = new JLabel("Descripción: " + productos[productoActual].getDescripcion());
        costoLabel = new JLabel("Costo: $" + productos[productoActual].getCosto());
        agregarUnidadButton = new JButton("Agregar");
        disminuirUnidadButton = new JButton("Disminuir");
        unidadesTextField = new JTextField("0", 5);
        agregarAlCarritoButton = new JButton("Agregar al carrito");
        cambiarProductoButton = new JButton("Cambiar Producto");


        setLayout(new GridLayout(3, 2));
        add(imagenLabel);
        add(descripcionLabel);
        add(costoLabel);

        // Tamaño personalizado para cada botón
        agregarUnidadButton.setPreferredSize(new Dimension(150, 30));
        add(agregarUnidadButton);

        disminuirUnidadButton.setPreferredSize(new Dimension(150, 30));
        add(disminuirUnidadButton);

        add(unidadesTextField);

        agregarAlCarritoButton.setPreferredSize(new Dimension(150, 30));
        add(agregarAlCarritoButton);

        cambiarProductoButton.setPreferredSize(new Dimension(150, 30));
        add(cambiarProductoButton);


        agregarUnidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadUnidades++;
                actualizarCantidadUnidades();
            }
        });

        disminuirUnidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cantidadUnidades > 0) {
                    cantidadUnidades--;
                    actualizarCantidadUnidades();
                }
            }
        });

        agregarAlCarritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Producto agregado al carrito: " + productos[productoActual].getDescripcion());
            }
        });

        cambiarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productoActual = (productoActual + 1) % productos.length;
                actualizarProducto();
            }
        });
    }

    private void cargarImagen(String url) {
        try {
            URL imageUrl = new URL(url);
            ImageIcon icon = new ImageIcon(imageUrl);
            Image image = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarCantidadUnidades() {
        unidadesTextField.setText(String.valueOf(cantidadUnidades));
    }

    private void actualizarProducto() {
        
        cargarImagen(productos[productoActual].getImagen());
        descripcionLabel.setText("Descripción: " + productos[productoActual].getDescripcion());
        costoLabel.setText("Costo: $" + productos[productoActual].getCosto());
        cantidadUnidades = 0; 
        actualizarCantidadUnidades();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductoGUI tienda = new ProductoGUI();
                tienda.setVisible(true);
            }
        });
    }
}

class Producto {
    private String imagen;
    private String descripcion;
    private double costo;

    public Producto(String imagen, String descripcion, double costo) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }
}
