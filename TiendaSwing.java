import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaSwing {

    private static final String[] IMAGE_NAMES = {
        "https://mandolina.co/wp-content/uploads/2020/10/Rebanada-de-tarta-de-queso.jpg",
        "delivery/Images/imagen2.png",
        "delivery/Images/imagen3.png",
        "delivery/Images/imagen4.png",
        "delivery/Images/imagen5.png",
        "delivery/Images/imagen6.png",
        "delivery/Images/imagen7.png",
    };

    private static final String[] DESCRIPTIONS = {
        "Pay de queso",
        "Pastel de zanahoria",
        "Flan",
        "Pastel de elote",
        "Brownie",
        "Helado",
        "Galletas"
    };

    private static final double[] PRICES = {
        80,
        80,
        55,
        85,
        60,
        100,
        50
    };

  private static final String[] STOCK_QUANTITIES = {
        "1 rebanada",
        "1 rebanada",
        "1 rebanada",
        "1 rebanada",
        "1 pieza",
        "1 bote",
        "10 piezas",
    };

    private static double subtotal = 0.0;
    private static JLabel labelSubtotal;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("LA PASTELERIA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            labelSubtotal = new JLabel("Subtotal: $0.00");
            frame.add(labelSubtotal, BorderLayout.NORTH);

            frame.add(new JScrollPane(createMainPanel()));
            frame.setVisible(true);
        });
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < IMAGE_NAMES.length; i++) {
            JPanel productPanel = createProductPanel(IMAGE_NAMES[i], DESCRIPTIONS[i], PRICES[i], STOCK_QUANTITIES[i]);
            mainPanel.add(productPanel);
            mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return mainPanel;
    }

    private static JPanel createProductPanel(String imageName, String description, double price, String stockQuantity) {
        JPanel productPanel = new JPanel(new BorderLayout(10, 10));
        productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        ImageIcon imageIcon = new ImageIcon(imageName);
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

        JLabel labelStockQuantity = new JLabel("Cantidad: " + stockQuantity);
        labelStockQuantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(labelStockQuantity);

        JLabel labelPrice = new JLabel(String.format("$%.1f MXN", price));
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

        JButton buttonAddToCart = new JButton("Agregar");
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
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2)); 

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
