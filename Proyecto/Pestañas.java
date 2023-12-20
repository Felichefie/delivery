package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Pestañas extends JTabbedPane {
    Dbconnection dbConnection;
    JPanel productos; // Cambiado a un campo de la clase
    JPanel carritoPanel; // Cambiado a un campo de la clase
    private List<JPanel> productosEnCarrito = new ArrayList<>();
    private List<Producto> listaDeProductos = new ArrayList<>();

    public Pestañas(Dbconnection dbConnection) {
        this.dbConnection = dbConnection;

        // Pestaña Productos
        productos = new JPanel(new GridLayout(0, 1)); // GridLayout con una única columna
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS));
        productos.setBorder(new EmptyBorder(0, 10, 0, 10)); // Ajusta los márgenes según tus necesidades

        JScrollPane scrollPane = new JScrollPane(productos);
        // Establece las políticas de desplazamiento
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        addTab("Pestaña Productos", scrollPane);
        cargarProductos();

        // Pestaña Perfil
        JPanel perfil = new JPanel();
        addTab("Pestaña Perfil", perfil);

        // Pestaña Carrito

        carritoPanel = new JPanel(new GridLayout(0, 1)); // GridLayout con una única columna
        carritoPanel.setLayout(new BoxLayout(carritoPanel, BoxLayout.Y_AXIS));
        carritoPanel.setBorder(new EmptyBorder(0, 10, 0, 10)); // Ajusta los márgenes según tus necesidades
        JScrollPane carritoScrollPane = new JScrollPane(carritoPanel);
        // Establece las políticas de desplazamiento
        carritoScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Añade carritoScrollPane a la pestaña "Carrito"
        addTab("Pestaña Carrito", carritoScrollPane);
        cargarCarrito();

    }

    private void cargarProductos() {
        try {
            Connection conexion = dbConnection.getConn();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM progra2.products WHERE id >= 10");

            while (rs.next()) {
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                double size_x = rs.getDouble("size_x");
                double size_y = rs.getDouble("size_y");
                double size_z = rs.getDouble("size_z");
                int stock = rs.getInt("stock");
                String image = rs.getString("image");

                JPanel productoPanel = new JPanel();
                productoPanel.setLayout(new BorderLayout());
                productoPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(4, 4, 4, 4))); // Reduce el borde vacío a 5 píxeles
                productoPanel.setBackground(new Color(60, 255, 50, 90)); // Más rojo y más transparente

                VisualizarImagen visualizarImagen = new VisualizarImagen(image);
                JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                imagePanel.add(visualizarImagen);
                productoPanel.add(imagePanel, BorderLayout.WEST);

                JPanel textPanel = new JPanel();
                textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
                textPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 0)); // Agrega un borde vacío a la
                                                                                   // izquierda

                // Crea las etiquetas con la fuente, el tamaño y el color deseados
                JLabel descriptionLabel = new JLabel(description);
                descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
                descriptionLabel.setForeground(new Color(0, 45, 255));

                JLabel priceLabel = new JLabel("Precio: " + price);
                priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                priceLabel.setForeground(Color.BLACK);

                JLabel stockLabel = new JLabel("Stock disponible: " + stock);
                stockLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                stockLabel.setForeground(Color.BLACK);

                JLabel sizeXLabel = new JLabel("Size X: " + size_x);
                sizeXLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                sizeXLabel.setForeground(Color.BLACK);

                JLabel sizeYLabel = new JLabel("Size Y: " + size_y);
                sizeYLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                sizeYLabel.setForeground(Color.BLACK);

                JLabel sizeZLabel = new JLabel("Size Z: " + size_z);
                sizeZLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                sizeZLabel.setForeground(Color.BLACK);

                // Agrega las etiquetas al panel de texto
                textPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                textPanel.add(descriptionLabel);
                textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
                textPanel.add(priceLabel);
                textPanel.add(stockLabel);
                textPanel.add(Box.createRigidArea(new Dimension(0, 15)));
                textPanel.add(sizeXLabel);
                textPanel.add(sizeYLabel);
                textPanel.add(sizeZLabel);
                productoPanel.add(textPanel, BorderLayout.CENTER); // Agrega el panel de texto al panel del producto

                JButton ButtonCarrito = new JButton("Agregar al Carrito");
                ButtonCarrito.setBackground(new Color(7, 164, 121));
                ButtonCarrito.setForeground(Color.WHITE);
                ButtonCarrito.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));

                // Crea un borde compuesto con el borde original y el borde vacío
                Border line = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
                Border margin = BorderFactory.createEmptyBorder(0, 0, 10, 0);
                ButtonCarrito.setBorder(new CompoundBorder(line, margin));

                // Establecer el tamaño máximo del botón para controlar el ancho del botón
                ButtonCarrito.setMaximumSize(new Dimension(800, 35));

                // Crea un nuevo panel para contener el botón y el espacio extra
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
                buttonPanel.add(ButtonCarrito);
                buttonPanel.add(Box.createRigidArea(new Dimension(0, 4))); // Agrega un espacio extra debajo del botón

                productoPanel.add(buttonPanel, BorderLayout.SOUTH);
                productos.add(productoPanel);
                productos.add(Box.createRigidArea(new Dimension(0, 10)));

                // Crea los botones y el campo de texto
                JButton ButtonAgregar = new JButton("+");
                JButton ButtonQuitar = new JButton("-");
                JTextField textField_cantidad = new JTextField(4); // 3 columnas de ancho

                // Agrega un ActionListener al botón "+"
                ButtonAgregar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int cantidad = Integer.parseInt(textField_cantidad.getText());
                            if (cantidad < stock) {
                                cantidad++;
                                textField_cantidad.setText(String.valueOf(cantidad));
                            }
                        } catch (NumberFormatException ex) {
                            // El texto ingresado no es un número, puedes manejar este caso como prefieras
                            textField_cantidad.setText("0");
                        }
                    }
                });

                // Agrega un ActionListener al botón "-"
                ButtonQuitar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int cantidad = Integer.parseInt(textField_cantidad.getText());
                            if (cantidad > 0) {
                                cantidad--;
                                textField_cantidad.setText(String.valueOf(cantidad));
                            }
                        } catch (NumberFormatException ex) {
                            // El texto ingresado no es un número, puedes manejar este caso como prefieras
                            textField_cantidad.setText("0");
                        }
                    }
                });

                ButtonCarrito.addActionListener(e -> {
                    int cantidad = Integer.parseInt(textField_cantidad.getText());
                    if (cantidad > 0) {
                        // Create a new Producto with the description and quantity
                        Producto producto = new Producto(description, price, cantidad, size_x, size_y, size_z, image,
                                cantidad);
                        // Add the new Producto to the list
                        listaDeProductos.add(producto);

                        // Update the cart
                        actualizarCarrito();
                    }
                    textField_cantidad.setText("0");
                });

                // Configura los botones y el campo de texto
                ButtonAgregar.setFont(new Font("Arial", Font.BOLD, 16));
                ButtonQuitar.setFont(new Font("Arial", Font.BOLD, 16));
                textField_cantidad.setHorizontalAlignment(JTextField.CENTER);
                textField_cantidad.setText("0");

                // Establece un tamaño preferido para los botones
                Dimension buttonSize = new Dimension(44, 44); // Ajusta el tamaño según sea necesario
                ButtonAgregar.setPreferredSize(buttonSize);
                ButtonQuitar.setPreferredSize(buttonSize);

                // Crea un panel para los botones y el campo de texto
                JPanel Panel = new JPanel();
                Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                Panel.add(Box.createVerticalStrut(200)); // Ajusta el valor según sea necesario

                // Agrega los botones y el campo de texto al panel
                Panel.add(ButtonQuitar);
                Panel.add(textField_cantidad);
                Panel.add(ButtonAgregar);
                Panel.add(Box.createHorizontalStrut(20));

                // Agrega el panel al panel del producto
                productoPanel.add(Panel, BorderLayout.EAST);

            }

            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    double subtotal = 0;
    double iva = 0;
    double total = 0;
    JLabel subtotalValueLabel;

    private void cargarCarrito() {

        Iva i = new Iva(subtotal);
        iva = iva + i.getimpuesto();
        subtotal = subtotal + i.getbase();
        total = total + subtotal + iva;

        JLabel l_iva = new JLabel("IVA " + String.valueOf(iva));
        JLabel l_total = new JLabel("Total " + String.valueOf(total));

        // Crear un botón para pagar
        JButton pagarButton = new JButton("PAGAR");
        pagarButton.setBackground(new Color(7, 164, 121));
        pagarButton.setForeground(Color.WHITE);
        pagarButton.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        pagarButton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24)); // Establecer la fuente y el tamaño del
                                                                                 // texto
        pagarButton.setPreferredSize(new Dimension(400, 45)); // Establecer el tamaño preferido del botón

        pagarButton.addActionListener(e -> {
            Guipay pago = new Guipay();
        });

        // Crear una etiqueta para el título "SUBTOTAL"
        JLabel subtotalLabel = new JLabel("SUBTOTAL");
        subtotalLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        // Crear una etiqueta para mostrar el valor del subtotal
        subtotalValueLabel = new JLabel("$" + subtotal);
        subtotalValueLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 22));
        subtotalValueLabel.setOpaque(true); // Necesario para que el color de fondo sea visible
        subtotalValueLabel.setBackground(new Color(0, 255, 90)); // Establece el color de fondo en azul
        subtotalValueLabel.setForeground(Color.BLACK); // Establece el color del texto en blanco para que sea visible en
                                                       // el fondo azul

        // Agrega un borde del mismo color que el fondo para hacer que el fondo parezca
        // más grande
        int borderSize = 10; // Ajusta este valor según tus necesidades
        subtotalValueLabel.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));

        // Crear un nuevo JPanel con BorderLayout para el subtotal
        JPanel subtotalPanel = new JPanel(new BorderLayout());
        subtotalPanel.add(Box.createVerticalStrut(20), BorderLayout.NORTH); // Agrega espacio vertical antes de la
                                                                            // etiqueta subtotal
        subtotalPanel.add(subtotalLabel, BorderLayout.WEST);
        subtotalPanel.add(Box.createHorizontalStrut(10), BorderLayout.CENTER); // Espacio entre el título y el valor del
                                                                               // subtotal
        subtotalPanel.add(subtotalValueLabel, BorderLayout.EAST);

        // Agregar un borde vacío para actuar como un margen
        subtotalPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); // 10 pixels de margen a la izquierda

        // Crear un nuevo JPanel con BorderLayout para contener el botón y el
        // subtotalPanel
        JPanel buttonAndSubtotalPanel = new JPanel(new BorderLayout());
        buttonAndSubtotalPanel.add(pagarButton, BorderLayout.WEST); // Coloca el botón a la izquierda
        buttonAndSubtotalPanel.add(Box.createHorizontalStrut(50), BorderLayout.CENTER); // Agrega espacio horizontal
                                                                                        // entre el botón y el
                                                                                        // subtotalPanel
        buttonAndSubtotalPanel.add(subtotalPanel, BorderLayout.EAST); // Coloca el subtotalPanel a la derecha

        // Crear un nuevo JPanel con FlowLayout alineado a la izquierda
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(buttonAndSubtotalPanel);
        buttonAndSubtotalPanel.add(subtotalLabel.add(l_iva));
        buttonAndSubtotalPanel.add(subtotalLabel.add(l_total));

        // Añadir el panel del botón al panel del carrito
        carritoPanel.add(buttonPanel);
    }

    private JPanel crearPanelProducto(Producto producto) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); // Cambia a BoxLayout.X_AXIS

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        // Crea un VisualizarImagen con la imagen del producto
        String imagePath = producto.getImagePath();
        VisualizarImagen imagePanel = new VisualizarImagen(imagePath);
        infoPanel.add(imagePanel);

        JLabel descripcionLabel = new JLabel(producto.getDescription());
        descripcionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        descripcionLabel.setForeground(new Color(0, 45, 255));

        JLabel precioLabel = new JLabel("Precio: $" + producto.getPrice());
        precioLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        precioLabel.setForeground(Color.BLACK);

        JLabel cantidadLabel = new JLabel("Cantidad: " + producto.getQuantity());
        cantidadLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        cantidadLabel.setForeground(Color.BLACK);

        // Calcula el total del producto y crea una etiqueta para él
        double totalProducto = producto.getPrice() * producto.getQuantity();
        JLabel totalProductoLabel = new JLabel("Total: $" + totalProducto);
        totalProductoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        totalProductoLabel.setForeground(Color.BLACK);

        // Agrega las etiquetas al panel de información
        infoPanel.add(descripcionLabel);
        infoPanel.add(precioLabel);
        infoPanel.add(cantidadLabel);
        infoPanel.add(totalProductoLabel); // Agrega la etiqueta del total del producto al panel

        // Crea los botones "+" y "-" y el campo de texto de la cantidad
        JButton buttonAgregar = new JButton("+");
        JButton buttonQuitar = new JButton("-");

        // Ajusta el tamaño de los botones
        Dimension buttonSize = new Dimension(60, 60); // Ajusta estos valores según tus necesidades
        buttonAgregar.setMinimumSize(buttonSize);
        buttonAgregar.setMaximumSize(buttonSize);
        buttonAgregar.setSize(buttonSize);

        buttonQuitar.setMinimumSize(buttonSize);
        buttonQuitar.setMaximumSize(buttonSize);
        buttonQuitar.setSize(buttonSize);

        JTextField cantidadTextField = new JTextField(String.valueOf(producto.getQuantity()));
        cantidadTextField.setColumns(4); // Ajusta el tamaño del campo de texto según tus necesidades

        // Ajusta el tamaño máximo y mínimo del campo de texto
        Dimension textFieldSize = new Dimension(50, 25); // Ajusta estos valores según tus necesidades
        cantidadTextField.setMaximumSize(textFieldSize);
        cantidadTextField.setMinimumSize(textFieldSize);

        // Crea un panel para los botones y el campo de texto de la cantidad
        JPanel cantidadPanel = new JPanel();
        cantidadPanel.setLayout(new BoxLayout(cantidadPanel, BoxLayout.X_AXIS));

        // Agrega un ActionListener a los botones
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para incrementar la cantidad
                int cantidad = Integer.parseInt(cantidadTextField.getText());
                cantidad++;
                cantidadTextField.setText(String.valueOf(cantidad));

                // Actualiza la etiqueta de cantidad
                cantidadLabel.setText("Cantidad: " + cantidad);

                // Actualiza el subtotal
                subtotal += producto.getPrice(); // Asume que "producto" es el producto actual

                // Verifica si subtotalValueLabel es null antes de usarlo
                if (subtotalValueLabel == null) {
                    subtotalValueLabel = new JLabel();
                }
                subtotalValueLabel.setText("$" + subtotal); // Actualiza la etiqueta del subtotal
            }
        });

        buttonQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para decrementar la cantidad
                int cantidad = Integer.parseInt(cantidadTextField.getText());
                if (cantidad > 0) {
                    cantidad--;
                    cantidadTextField.setText(String.valueOf(cantidad));

                    // Actualiza la etiqueta de cantidad
                    cantidadLabel.setText("Cantidad: " + cantidad);

                    // Actualiza el subtotal
                    subtotal -= producto.getPrice(); // Asume que "producto" es el producto actual
                    if (subtotal < 0)
                        subtotal = 0; // Asegura que el subtotal no sea negativo
                    subtotalValueLabel.setText("$" + subtotal); // Actualiza la etiqueta del subtotal
                }
            }
        });

        // Agrega los botones y el campo de texto al panel de la cantidad
        cantidadPanel.add(buttonQuitar);
        cantidadPanel.add(Box.createHorizontalStrut(6)); // Agrega espacio entre los botones
        cantidadPanel.add(cantidadTextField);
        cantidadPanel.add(Box.createHorizontalStrut(6)); // Agrega espacio entre los botones
        cantidadPanel.add(buttonAgregar);

        // Agrega el panel de información y el panel de la cantidad al panel principal
        panel.add(infoPanel);
        panel.add(Box.createHorizontalGlue()); // Agrega un Box.Filler
        panel.add(cantidadPanel); // Agrega el panel de la cantidad al panel

        return panel;
    }

    private void actualizarCarrito() {
        // Borra todos los productos actuales en el carritoPanel
        carritoPanel.removeAll();
        carritoPanel.setLayout(new BoxLayout(carritoPanel, BoxLayout.Y_AXIS));

        // Inicializa el subtotal a 0 al principio de cada actualización
        subtotal = 0;

        // Agrega los productos actuales al carritoPanel
        for (Producto producto : listaDeProductos) {
            JPanel productoEnCarrito = crearPanelProducto(producto);
            productoEnCarrito.setMaximumSize(new Dimension(850, 600));
            productoEnCarrito.setPreferredSize(new Dimension(400, 263));
            productoEnCarrito.setMinimumSize(new Dimension(400, 50));
            productoEnCarrito.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLACK, 2),
                    BorderFactory.createEmptyBorder(4, 4, 4, 4)));
            carritoPanel.add(productoEnCarrito); // Agrega el producto al carritoPanel

            // Suma el total del producto al subtotal
            subtotal += producto.getPrice() * producto.getQuantity();

            // Añade un separador entre productos
            JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
            separator.setPreferredSize(new Dimension(400, 10)); // Ajusta el tamaño del separador según tus necesidades
            carritoPanel.add(separator);
        }

        // Elimina el último separador agregado al final
        if (carritoPanel.getComponentCount() > 0) {
            carritoPanel.remove(carritoPanel.getComponentCount() - 1);
        }
        // Añade el botón de pagar
        cargarCarrito();

        // Actualiza la interfaz gráfica
        revalidate();
        repaint();
    }
}