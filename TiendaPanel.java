import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TiendaPanel extends JPanel {

    private String contraseña;
    private Pago pagoVentana;
    private JTextField[] quantityFields;
    private int index;
    private static double subtotal = 0.0;
    private static JLabel labelSubtotal = new JLabel("Subtotal:");
    
    public TiendaPanel (String constraseña){
        this.contraseña = constraseña;
        setLayout(new BorderLayout());
        createMainPanel();
    }   
   
    public double getSubtotal(){
        return subtotal;
    }

    private void createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        List<Productos> productos = Productos.getProductos();
        
        quantityFields = new JTextField[productos.size()];
        

        for (Productos producto : productos) {
            JPanel productPanel = createProductPanel(producto.getImageUrl(), producto.getDescription(), producto.getPrice(), producto.getStockQuantity(), producto.getStockDescription());
            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        if (mainPanel.getPreferredSize().width > getWidth()){
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
        setLayout(new BorderLayout());
        add(Box.createVerticalGlue(), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(Box.createVerticalGlue(), BorderLayout.SOUTH);
    }
    

    private JPanel createProductPanel(String imageUrl, String description, double price, int stockQuantity, String stockDescripcion) {
        JPanel productPanel = new JPanel(new BorderLayout(10, 10));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        ImageIcon imageIcon = Productos.loadImageFromURL(imageUrl);

        JLabel labelImage = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        productPanel.add(labelImage, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4)); 

        JTextArea textAreaDescription = new JTextArea(description);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setOpaque(false);
        textAreaDescription.setEditable(false);
        textAreaDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(textAreaDescription);

        JPanel quantityAndPricePanel = new JPanel();
        quantityAndPricePanel.setLayout(new BoxLayout(quantityAndPricePanel, BoxLayout.X_AXIS));

        JLabel labelStockQuantity = new JLabel("Stock: " + stockQuantity);
        labelStockQuantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        quantityAndPricePanel.add(labelStockQuantity);

        JLabel labelStockDescripcion = new JLabel(" " + stockDescripcion);
        labelStockDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        quantityAndPricePanel.add(labelStockDescripcion);

        JLabel labelPrice = new JLabel(String.format("$%.1f MXN", price));
        labelPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        quantityAndPricePanel.add(labelPrice);

        detailsPanel.add(quantityAndPricePanel);

        final JTextField fieldQuantity = new JTextField("0", 3); 
        quantityFields[index] = fieldQuantity;
//BOTON DE AUMENTAR LA CANTIDAD
        JButton buttonAdd = new JButton("+");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                quantity++;
                fieldQuantity.setText(String.valueOf(quantity));
            }
        });
//BOTON DE DISMINUIR LA CANTIDAD 
        JButton buttonSubtract = new JButton("-");
        buttonSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                if (quantity > 0) {
                    quantity--;
                    fieldQuantity.setText(String.valueOf(quantity));
                }
            }
        });
//BOTOTN DE AGREGAR AL SUBTOTAL
        JButton buttonAddToCart = new JButton("Agregar");
        buttonAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                subtotal += price * quantity;
                labelSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
                actualizarSubtotalEnPago(subtotal);
            }

        });
        detailsPanel.add(buttonAddToCart);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.yellow,0)); 

        
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(buttonAdd);
        buttonsPanel.add(buttonSubtract);
        controlPanel.add(buttonAddToCart);

        JPanel quantityPanel = new JPanel(new FlowLayout());
        quantityPanel.add(buttonsPanel);
        quantityPanel.add(fieldQuantity);

        controlPanel.add(quantityPanel, BorderLayout.CENTER);

        productPanel.add(detailsPanel, BorderLayout.CENTER);
        productPanel.add(controlPanel, BorderLayout.EAST);

        

        return productPanel;
    }
    public void setPagoVentana(Pago pagoVentana) {
        this.pagoVentana = pagoVentana;
    }

    public void actualizarSubtotalEnPago (double nuevoSubtotal){
        if(pagoVentana!= null){
            pagoVentana.actualizarSubtotalEnPago(nuevoSubtotal);
        }
    }

    public String getCantidadProducto(int index){
        return quantityFields[index].getText();
    }

}