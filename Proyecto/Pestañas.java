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
    ArrayList<String> carrito;
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

                int id = rs.getInt("id");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                double sizeX = rs.getDouble("size_x");
                double sizeY = rs.getDouble("size_y");
                double sizeZ = rs.getDouble("size_z");

                buttonCarrito.addActionListener(e -> {
                    // Obtén toda la información del producto
                    String productInfo = "ID: " + id + ", Price: " + price
                            + ", Description: " + description + ", Stock: " + stock
                            + ", Size X: " + sizeX + ", Size Y: " + sizeY
                            + ", Size Z: " + sizeZ;

                    // Obtiene la cantidad del producto que se quiere agregar al carrito
                    int fieldQuantityValue = Integer.parseInt(fieldQuantity.getText());
                    if (fieldQuantityValue > 0) {
                        // Agrega el producto al carrito fieldQuantityValue veces
                        for (int i = 0; i < fieldQuantityValue; i++) {
                            carrito.add(productInfo);
                        }

                        // Aquí debes obtener la cantidad del producto en el carrito
                        int quantity = getQuantity(productInfo);

                        // Crea un JPanel para el producto y añádelo al panel del carrito
                        JPanel productPanelInLambda = createProductPanel(productInfo, quantity);
                        carritoPanel.add(productPanelInLambda);

                        // Actualiza la pestaña Carrito
                        carritoPanel.revalidate();
                        carritoPanel.repaint();
                    }
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

                // Crear un JLabel para la imagen del producto
                String imagePath = rs.getString("image");
                System.out.println("Image path: " + imagePath);
                ImageIcon imageIcon = new ImageIcon(
                        new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                JLabel imageLabel = new JLabel(imageIcon);
                productPanel.add(imageLabel, BorderLayout.CENTER);

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

        // Luego, puedes agregar productos a carrito y iterar sobre ellos:
        for (String product : carrito) {
            // Aquí debes obtener la cantidad del producto en el carrito
            int quantity = getQuantity(product);
            JPanel productPanel = createProductPanel(product, quantity);
            carritoPanel.add(productPanel);
        }
        addTab("Pestaña Carrito", carritoPanel);

    }

    public void updateCarrito() {
        // Limpia el panel del carrito
        carritoPanel.removeAll();

        // Configura el layout del panel del carrito
        int rowCount = (int) Math.ceil(carrito.size() / 3.0); // Ajusta el número 3 según el número de columnas que
                                                              // desees
        carritoPanel.setLayout(new GridLayout(rowCount, 2)); // Ajusta el número 3 según el número de columnas que
                                                             // desees

        // Luego, puedes agregar productos a carrito y iterar sobre ellos:
        for (String product : carrito) {
            // Aquí, necesitarías determinar la cantidad de alguna manera
            int quantity = getQuantity(product);

            JPanel productPanel = createProductPanel(product, quantity);
            carritoPanel.add(productPanel);
        }

        // Actualiza la pestaña Carrito
        carritoPanel.revalidate();
        carritoPanel.repaint();
    }

    private JPanel createProductPanel(String productInfo, int quantity) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel(productInfo);
        panel.add(label);

        // Crear un panel para los botones
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        buttonsPanel.add(plusButton);
        buttonsPanel.add(minusButton);

        // Crear un panel para la cantidad
        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        quantityPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Establecer un borde vacío para el
                                                                                  // espaciado
        quantityPanel.setBackground(Color.WHITE); // Establecer un color de fondo
        quantityPanel.add(buttonsPanel);

        final int[] quantityArray = { quantity };
        JTextField quantityField = new JTextField(String.valueOf(quantityArray[0]));
        Dimension preferredSize = quantityField.getPreferredSize();
        preferredSize.width = preferredSize.width * 3; // Ajusta esto al tamaño que prefieras
        quantityField.setPreferredSize(preferredSize);
        quantityField.setMaximumSize(new Dimension(Integer.MAX_VALUE, quantityField.getPreferredSize().height));
        quantityPanel.add(quantityField);

        plusButton.addActionListener(e -> {
            quantityArray[0]++;
            quantityField.setText(String.valueOf(quantityArray[0]));
        });

        minusButton.addActionListener(e -> {
            if (quantityArray[0] > 0) {
                quantityArray[0]--;
                quantityField.setText(String.valueOf(quantityArray[0]));
            }
        });

        panel.add(quantityPanel);

        return panel;
    }

    private int getQuantity(String product) {
        int count = 0;
        for (String item : carrito) {
            if (item.equals(product)) {
                count++;
            }
        }
        return count;
    }
}