import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.net.MalformedURLException;
import java.net.URL;

public class TiendaSwing extends JPanel {

    private String contraseña;
    private Pago pagoVentana;


    public TiendaSwing (String constraseña){
        this.contraseña = contraseña;
        setLayout(new BorderLayout());
        createMainPanel();
    }
    

    private static final String[] IMAGE_URLS = {
        "https://gobeef.mx/cdn/shop/products/GoBeef_ProductShot_PechugaPollo_800x.png",
        "https://notitotal.com/wp-content/uploads/2020/06/panintegralfinaalfinaaal.jpg",
        "https://th.bing.com/th/id/OIP.-Q622cEzXpYluF_jk7F_bwHaHa?rs=1&pid=ImgDetMain",
        "https://http2.mlstatic.com/D_NQ_NP_2X_803237-MLA48551207726_122021-F.jpg",
        "https://i5.walmartimages.com/asr/3268d77a-4b14-46a1-9eff-78709e4eb02d.df3e1a4ac9ed37823f9889bc2a95d4bf.jpeg",
        "https://images-na.ssl-images-amazon.com/images/I/71UnD6gYfFL.jpg",
        "https://peruviannutrition.com/wp-content/uploads/2022/06/PSICHOTYC-GOLD.png"
    };

    private static ImageIcon loadImageFromURL(String imageUrl) {
    try {
        return new ImageIcon(new URL(imageUrl));
    } catch (MalformedURLException e) {
        System.err.println("Error al cargar la imagen desde la URL: " + imageUrl);
        e.printStackTrace();
        return null;
    }
}

    private static final String[] DESCRIPTIONS = {
        "Pechuga de pollo: 100% carne magra y saludable.",
        "Pan integral: Rico en fibra y nutrientes esenciales.",
        "Proteina: Suplemento para el desarrollo muscular.",
        "Creatina: Mejora el rendimiento en actividades físicas intensas.",
        "Omega 3: Ácidos grasos esenciales para la salud cardiovascular.",
        "Straps: Accesorio para levantamiento de pesas.",
        "Pre-workout: Suplemento para mejorar el rendimiento antes del entrenamiento."
    };

    private static final double[] PRICES = {
        180,
        65,
        1500,
        850,
        620,
        150,
        480
    };

  private static final String[] STOCK_QUANTITIES = {
        "100 KG",
        "29 unidades",
        "16 unidades",
        "65 unidades",
        "49 unidades",
        "37 pares",
        "13 unidades",
    };

    private static double subtotal = 0.0;
    private static JLabel labelSubtotal = new JLabel("Subtotal:");
    public double getSubtotal(){
        return subtotal;
    }

    /*public static void createmain(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TiendaSwing frame = new TiendaSwing();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPantallaCompleta();


            labelSubtotal = new JLabel("Subtotal: $0.00");
            frame.add(labelSubtotal, BorderLayout.NORTH);

            JScrollPane scrollPane =  new JScrollPane (createMainPanel());
            frame.add(scrollPane);
            
            frame.setVisible(true);
        });
    }/* */

    private void createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < IMAGE_URLS.length; i++) {
            JPanel productPanel = createProductPanel(IMAGE_URLS[i], DESCRIPTIONS[i], PRICES[i], STOCK_QUANTITIES[i]);
            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        add(mainPanel,BorderLayout.CENTER);
    }
    

    private JPanel createProductPanel(String imageUrl, String description, double price, String stockQuantity) {
        JPanel productPanel = new JPanel(new BorderLayout(10, 10));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        ImageIcon imageIcon = loadImageFromURL(imageUrl);
        if (imageIcon != null ) {
            JLabel labelImage = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            productPanel.add(labelImage, BorderLayout.WEST);
        }
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

        JLabel labelPrice = new JLabel(String.format("$%.1f MXN", price));
        labelPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        quantityAndPricePanel.add(labelPrice);

        detailsPanel.add(quantityAndPricePanel);

        final JTextField fieldQuantity = new JTextField("0", 3); 
        fieldQuantity.setHorizontalAlignment(JTextField.CENTER);
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

        //JButton buttonAdd = new JButton("+");
        //JButton buttonSubtract = new JButton("-");
        
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
}