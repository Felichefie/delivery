package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Pestañas extends JTabbedPane {
    Dbconnection dbConnection;
    ArrayList<Producto> carrito = new ArrayList<>();
    JPanel carritoPanel; // Hacer carritoPanel un campo de la clase

    public Pestañas(Dbconnection dbConnection) {
        this.dbConnection = dbConnection;
        this.carrito = new ArrayList<>(); // Inicializa 'carrito' aquí
        this.carritoPanel = new JPanel(); // Inicializa 'carritoPanel' aquí

        // Pestaña para Productos
        JPanel productos = new JPanel();
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS)); // Cambiado a Y_AXIS
        // Crear un JScrollPane y agregar el panel de productos a él
        JScrollPane scrollPane = new JScrollPane(productos);
        addTab("Pestaña Productos", scrollPane); // Agregar el JScrollPane en lugar del JPanel

        // Cargar los productos desde la base de datos
        try {
            Statement stmt = dbConnection.getConn().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM progra2.products");

            int count = 0;
            while (rs.next() && count < 3) {
                // Crear un JPanel para el producto
                JPanel productPanel = new JPanel(new BorderLayout());

                // Crear un JPanel para la descripción del producto
                JPanel descriptionPanel = new JPanel();
                descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

                // Agregar cada pieza de información como un JLabel separado

                JLabel priceLabel = new JLabel("Price: " + rs.getDouble("price"));
                priceLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(priceLabel);
                JLabel descriptionLabel = new JLabel("Description: " + rs.getString("description"));
                descriptionLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(descriptionLabel);
                JLabel stockLabel = new JLabel("Stock: " + rs.getInt("stock"));
                stockLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(stockLabel);
                JLabel sizeXLabel = new JLabel("Size X: " + rs.getDouble("size_x"));
                sizeXLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(sizeXLabel);
                JLabel sizeYLabel = new JLabel("Size Y: " + rs.getDouble("size_y"));
                sizeYLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(sizeYLabel);
                JLabel sizeZLabel = new JLabel("Size Z: " + rs.getDouble("size_z"));
                sizeZLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
                descriptionPanel.add(sizeZLabel);

                // Crear un JPanel para los controles del producto
                JPanel controlPanel = new JPanel(new BorderLayout());
                controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                // Crear botones para agregar y restar cantidad
                JButton buttonAgregar = new JButton("+");
                JButton buttonQuitar = new JButton("-");
                JButton buttonCarrito = new JButton("Agregar al carrito");

                // Crear un campo de texto para la cantidad
                int stock = rs.getInt("stock");
                JTextField fieldQuantity = new JTextField("0", 3);

                // Agregar ActionListeners a los botones
                buttonAgregar.addActionListener(e -> {
                    int currentQuantity = Integer.parseInt(fieldQuantity.getText());
                    if (currentQuantity < stock) {
                        fieldQuantity.setText(String.valueOf(currentQuantity + 1));
                    }
                });

                buttonQuitar.addActionListener(e -> {
                    int currentQuantity = Integer.parseInt(fieldQuantity.getText());
                    if (currentQuantity > 0) {
                        fieldQuantity.setText(String.valueOf(currentQuantity - 1));
                    }
                });

                // Captura la información del producto
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int productStock = rs.getInt("stock");
                double sizeX = rs.getDouble("size_x");
                double sizeY = rs.getDouble("size_y");
                double sizeZ = rs.getDouble("size_z");
                // Captura la ruta de la imagen del producto
                final String[] imagePath = new String[1];
                try {
                    imagePath[0] = rs.getString("image");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                buttonCarrito.addActionListener(e -> {
                    // ...
                    // Crea un nuevo Producto con la información capturada
                    Producto producto = new Producto(description, price, productStock, sizeX, sizeY, sizeZ,
                            imagePath[0]);

                    // Obtener la cantidad de productos del campo de texto
                    int quantity = Integer.parseInt(fieldQuantity.getText());

                    // Si la cantidad es mayor que 0, añade el producto al carrito
                    if (quantity > 0) {
                        // Verificar si el producto ya está en el carrito
                        boolean isProductInCart = false;
                        for (Producto productoCarrito : carrito) {
                            if (productoCarrito.equals(producto)) { // Asegúrate de tener un método equals() adecuado en
                                                                    // tu clase Producto
                                // Si el producto ya está en el carrito, aumenta su cantidad
                                int currentQuantity = productoCarrito.getQuantity();
                                productoCarrito.setQuantity(currentQuantity + quantity);
                                isProductInCart = true;
                                break;
                            }
                        }

                        // Si el producto no está en el carrito, agrega una nueva instancia del producto
                        if (!isProductInCart) {
                            producto.setQuantity(quantity);
                            carrito.add(producto);
                        }

                        // Actualiza la pestaña "Carrito"
                        updateCarrito();
                    }

                    // Restablecer el campo de texto a "0"
                    fieldQuantity.setText("0");
                });

                // Agregar el botón al panel de control
                controlPanel.add(buttonCarrito, BorderLayout.SOUTH);

                // Crear un panel para los botones
                JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
                buttonsPanel.add(buttonAgregar);
                buttonsPanel.add(buttonQuitar);

                // Crear un panel para la cantidad
                JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                quantityPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer un borde vacío
                // para el espaciado
                quantityPanel.setBackground(Color.WHITE); // Establecer un color de fondo
                quantityPanel.add(buttonsPanel, BorderLayout.EAST);
                quantityPanel.add(fieldQuantity, BorderLayout.CENTER);

                // Agregar el panel de descripción al panel de control
                controlPanel.add(descriptionPanel, BorderLayout.NORTH);
                descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer un borde
                                                                                             // vacío para el espaciado
                descriptionPanel.setBackground(Color.WHITE); // Establecer un color de fondo

                // Agregar el panel de control al panel del producto
                controlPanel.add(quantityPanel, BorderLayout.CENTER);
                productPanel.add(controlPanel, BorderLayout.SOUTH);
                controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                controlPanel.setBackground(Color.LIGHT_GRAY);

                // Agregar el JPanel del producto al panel de productos
                productos.add(productPanel);

                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Pestaña Perfil
        JPanel perfil = new JPanel();
        addTab("Pestaña Perfil", perfil);

        // Pestaña Carrito
        JPanel carritoPanel = new JPanel();
        JScrollPane carritoScrollPane = new JScrollPane(carritoPanel); // Envuelve carritoPanel en un JScrollPane
        addTab("Pestaña Carrito", carritoScrollPane); // Añade el JScrollPane a la pestaña en lugar del JPanel

    }

    public void updateCarrito() {
        // Limpia el panel del carrito
        carritoPanel.removeAll();
        carritoPanel.setLayout(new BorderLayout()); // Establecer el layout a BorderLayout

        // Crear un nuevo panel para los productos
        JPanel productosPanel = new JPanel();
        productosPanel.setLayout(new BoxLayout(productosPanel, BoxLayout.Y_AXIS));

        // Añade los productos en el carrito al panel de productos
        for (Producto producto : carrito) {
            // Crea un panel para el producto y añádelo al panel de productos
            JPanel productPanel = createProductPanel(producto);
            productPanel.setPreferredSize(new Dimension(productosPanel.getWidth(), 100)); // Establecer el tamaño del
                                                                                          // panel del producto
            productosPanel.add(productPanel);
        }

        // Agregar el panel de productos al panel del carrito
        carritoPanel.add(productosPanel, BorderLayout.CENTER);

        // Crear un botón para pagar
        JButton pagarButton = new JButton("PAGAR");
        pagarButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24)); // Establecer la fuente y el tamaño del
                                                                                 // texto
        pagarButton.setPreferredSize(new Dimension(carritoPanel.getWidth(), 65)); // Establecer el tamaño del botón
        carritoPanel.add(pagarButton, BorderLayout.SOUTH); // Añadir el botón al panel del carrito

        // Actualiza la pestaña "Carrito"
        carritoPanel.revalidate();
        carritoPanel.repaint();

        // Añade carritoPanel a la pestaña "Carrito"
        int index = this.indexOfTab("Pestaña Carrito");
        if (index != -1) {
            this.setComponentAt(index, carritoPanel); // Modificado para añadir carritoPanel en lugar de un JScrollPane
        }
    }

    public JPanel createProductPanel(Producto producto) {

        // Crear un JPanel para el producto
        JPanel productPanel = new JPanel(new BorderLayout());

        // Establecer el tamaño preferido del panel del producto
        productPanel.setPreferredSize(new Dimension(300, 150)); // Ajusta estos valores según tus necesidades

        // Crear un JPanel para la descripción del producto
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

        // Agregar un borde vacío para desplazar la descripción a la derecha
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 170, 0, 0));
        descriptionPanel.setBackground(Color.WHITE); // Establecer un color de fondo

        // Obtener la ruta de la imagen del producto
        String imagePath = producto.getImagePath();
        System.out.println("Image path: " + imagePath);
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(imagePath).getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon);
        productPanel.add(imageLabel, BorderLayout.WEST); // Añadir la imagen al panel del producto

        // Agregar cada pieza de información como un JLabel separado
        JLabel priceLabel = new JLabel("Price: " + producto.getPrice());
        priceLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(priceLabel);
        JLabel descriptionLabel = new JLabel("Description: " + producto.getDescription());
        descriptionLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(descriptionLabel);
        JLabel stockLabel = new JLabel("Stock: " + producto.getStock());
        stockLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(stockLabel);
        JLabel sizeXLabel = new JLabel("Size X: " + producto.getSizeX());
        sizeXLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(sizeXLabel);
        JLabel sizeYLabel = new JLabel("Size Y: " + producto.getSizeY());
        sizeYLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(sizeYLabel);
        JLabel sizeZLabel = new JLabel("Size Z: " + producto.getSizeZ());
        sizeZLabel.setForeground(Color.BLACK); // Establecer el color del texto a negro
        descriptionPanel.add(sizeZLabel);

        // Crear un JPanel para los controles del producto
        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Borde vacío
                BorderFactory.createLineBorder(Color.BLACK, 2) // Borde negro
        ));

        // Crear botones para agregar y restar cantidad
        JButton buttonAgregar = new JButton("+");
        JButton buttonQuitar = new JButton("-");

        // Crear un campo de texto para la cantidad
        JTextField fieldQuantity = new JTextField("0", 3);

        // Agregar ActionListeners a los botones
        buttonAgregar.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(fieldQuantity.getText());
            if (currentQuantity < producto.getStock()) {
                fieldQuantity.setText(String.valueOf(currentQuantity + 1));
            }
        });

        buttonQuitar.addActionListener(e -> {
            int currentQuantity = Integer.parseInt(fieldQuantity.getText());
            if (currentQuantity > 0) {
                fieldQuantity.setText(String.valueOf(currentQuantity - 1));
            }
        });

        // Crear un JPanel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE);

        // Crear un JPanel para cada botón y el campo de cantidad con un FlowLayout
        JPanel agregarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel quitarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Agregar un borde vacío a cada JPanel para crear un espacio intermedio
        int space = 5; // Espacio en píxeles
        agregarPanel.setBorder(BorderFactory.createEmptyBorder(space, space, space, space));
        quantityPanel.setBorder(BorderFactory.createEmptyBorder(space, space, space, space));
        quitarPanel.setBorder(BorderFactory.createEmptyBorder(space, space, space, space));

        // Agregar cada botón y el campo de cantidad a su propio JPanel
        agregarPanel.add(buttonAgregar);
        quantityPanel.add(fieldQuantity);
        quitarPanel.add(buttonQuitar);

        // Agregar los JPanel al panel de botones
        buttonPanel.add(agregarPanel);
        buttonPanel.add(quantityPanel);
        buttonPanel.add(quitarPanel);

        // Agregar el panel de botones al panel de control
        controlPanel.add(buttonPanel, BorderLayout.EAST);

        // Agregar el panel de descripción al panel de control
        controlPanel.add(descriptionPanel, BorderLayout.CENTER);

        // Agregar el panel de control al panel del producto
        productPanel.add(controlPanel, BorderLayout.CENTER);

        // Devuelve el panel
        return productPanel;
    }
}