import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class TiendaUI {
    static String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    static String user = "alumno";
    static String pass = "alumnoPrueba1";
    static Dbconnection conn = new Dbconnection(URL, user, pass);
    static List<Producto> productos = conn.getProduct();
    
    TiendaUI(){
        ImageNames();
        Descriptions();
        Prices();
        StockQuantities();
    }
    
    String[] IMAGE_NAMES;
    String[] DESCRIPTIONS;
    double[] PRICES;
    Integer[] STOCK_QUANTITIES;

    public void ImageNames() {
        
        List<String> imageNamesList = new ArrayList<>();
        
        for (Producto producto : productos) {
            String image = producto.getImg();
            imageNamesList.add(image);
        }

        
        IMAGE_NAMES = imageNamesList.toArray(new String[0]);
    }

    public void Descriptions() {
        
        List<String> descriptionsList = new ArrayList<>();
        
        for (Producto producto : productos) {
            String description = producto.getDesc();
            descriptionsList.add(description);
        }

        
        DESCRIPTIONS = descriptionsList.toArray(new String[0]);
    }

    public void Prices() {
        
        List<Double> pricesList = new ArrayList<>();
        
        try {

            
            
            for (Producto producto : productos) {
                double price = producto.getPrice();
                pricesList.add(price);
            }
    
            
            PRICES = pricesList.stream().mapToDouble(Double::doubleValue).toArray();
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    public void StockQuantities() {
       
    List<Integer> stockQuantitiesList = new ArrayList<>();
    
    try {
        
        
        for (Producto producto : productos) {
            int stockQuantity = producto.getStock();
            stockQuantitiesList.add(stockQuantity);
        }

        
        STOCK_QUANTITIES = stockQuantitiesList.toArray(new Integer[0]);
    } catch (Exception e) {
        e.printStackTrace();  
    }
    }

    private static double subtotal = 0.0;
    private static JLabel labelSubtotal;

    public void createAndShowGUI() {
        JFrame frame = new JFrame("GYM STORE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        labelSubtotal = new JLabel("Subtotal: $0.00");
        frame.add(labelSubtotal, BorderLayout.CENTER);

        frame.add(new JScrollPane(createMainPanel()));
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < IMAGE_NAMES.length; i++) {
            JPanel productPanel = createProductPanel(IMAGE_NAMES[i], DESCRIPTIONS[i], PRICES[i], STOCK_QUANTITIES[i]);
            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return mainPanel;
    }

    private static ImageIcon createImageIcon(String imagePath) {
        try {
            if (imagePath.startsWith("https")) {
                
                URL url = new URL(imagePath);
                return new ImageIcon(url);
            } else {
                
                return new ImageIcon(imagePath);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            
            return null;
        }
    }

    private static JPanel createProductPanel(String imageName, String description, double price, int stockQuantity) {
        JPanel productPanel = new JPanel(new BorderLayout(0, 0));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 0));
        
        ImageIcon imageIcon = createImageIcon(imageName);
        JLabel labelImage = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        productPanel.add(labelImage, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 

        JTextArea textAreaDescription = new JTextArea(description);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setOpaque(false);
        textAreaDescription.setEditable(false);
        textAreaDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(textAreaDescription);

        JLabel labelStockQuantity = new JLabel("Stock: " + stockQuantity);
        labelStockQuantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(labelStockQuantity);

        JLabel labelPrice = new JLabel(String.format("$%.2f MXN", price));
        labelPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(labelPrice);

        final JTextField fieldQuantity = new JTextField("0", 3); 
        fieldQuantity.setHorizontalAlignment(JTextField.CENTER);

        JButton buttonAdd = new JButton("+");
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                quantity++;
                fieldQuantity.setText(String.valueOf(quantity));
            }
        });

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

        ImageIcon cartIcon = new ImageIcon("delivery/Images/carrito.png");
        JButton buttonAddToCart = new JButton(new ImageIcon(cartIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        buttonAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(fieldQuantity.getText());
                subtotal += price * quantity;
                labelSubtotal.setText("Subtotal: $" + String.format("%.2f", subtotal));
            }
        });
        detailsPanel.add(buttonAddToCart);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0)); 

        //JButton buttonAdd = new JButton("+");
        //JButton buttonSubtract = new JButton("-");
        
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(buttonAdd);
        buttonsPanel.add(buttonSubtract);

        JPanel quantityPanel = new JPanel(new FlowLayout());
        quantityPanel.add(buttonsPanel);
        quantityPanel.add(fieldQuantity);

        controlPanel.add(quantityPanel, BorderLayout.CENTER);

        productPanel.add(detailsPanel, BorderLayout.CENTER);
        productPanel.add(controlPanel, BorderLayout.EAST);

        return productPanel;
    }
}
