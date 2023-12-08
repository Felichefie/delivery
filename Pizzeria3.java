import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Pizzeria3 {
    
    private static final String[] IMAGENES = {
        "f87a3436438f9f0e2b24ea11c8529da6.jpg",
        "4f10ba47f5989c4761bf62297c884b24.jpg",
        "d2a3d234b21f3ff7efe2d940df358dd2.jpg",
        "763ec8232506290f84b8fac15968042e.jpg",
        "f8a777235b0e8ebd4853d33ab32b182c.jpg",
        "MEXICANA.jpeg"

    };
    private static final String[] DESCRIPCION= {
        "Pizza de Mole",
        "NO es una pizza, son quesadillas",
        "Pizza Especial Halloween",
        "Pizza de asada",
        "Pizza de chilaquiles",
        "Pizza MEXICANA"
    };
    private static final double[] PRECIO = {
        200,
        230,
        370,
        416,
        240,
        320
    };
    private static final String[] STOCK = {
        "Cantidad Disponible: 40",
        "Cantidad Disponible: 10",
        "Cantidad Disponible: 15",
        "Cantidad Disponible: 34",
        "Cantidad Disponible: 33",
        "Cantidad Disponible: 63"
    };

    private static double subtotal = 0.0;
    private static JLabel labelSubTotal;
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            JFrame f = new JFrame("Pizzeria");
            Font fon = new Font("TimesRoman", Font.PLAIN, 16);
           // Color b = new Color(255,169,0);
           // f.setBackground(b);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(800,600);

            labelSubTotal = new JLabel("EL SUBTOTAL ES: $0.00");
            labelSubTotal.setFont(fon);
            f.add(labelSubTotal, BorderLayout.NORTH);

            f.add(new JScrollPane(createPrincipalPanel()));

            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
        
    }


//METODO PARA CREAR EL PANEL PRINCIPAL
    private static JPanel createPrincipalPanel(){
        JPanel PrincipalPanel = new JPanel();
        PrincipalPanel.setLayout(new BoxLayout(PrincipalPanel, BoxLayout.Y_AXIS));
     
        for(int i = 0; i < IMAGENES.length; i++){
            JPanel PanelProductos = createPanel(IMAGENES[i], DESCRIPCION[i], PRECIO[i], STOCK[i]);
            Color b = new Color(255,216,0);
            PrincipalPanel.setBackground(b);
            PrincipalPanel.setFont(new Font("Arial", Font.PLAIN,14));
            //PrincipalPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
            PrincipalPanel.add(PanelProductos);
            PrincipalPanel.add(Box.createRigidArea(new Dimension(0,10)));
        }

        return PrincipalPanel;
    }



    private static JPanel createPanel(String imagenes, String descripcion, double precio, String stock) {
        JPanel productoPanel = new JPanel(new BorderLayout(10,10));
        Color b = new Color(255,216,0);
        productoPanel.setBackground(Color.white);

        ImageIcon iamgeIcon = new ImageIcon(imagenes);
        JLabel labelImage = new JLabel(new ImageIcon(iamgeIcon.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        productoPanel.add(labelImage,BorderLayout.WEST);

//crea panel de detalles
        JPanel detallesPanel = new JPanel();
        detallesPanel.setLayout(new BoxLayout(detallesPanel, BoxLayout.Y_AXIS));
        detallesPanel.setBackground(Color.white);
       
        

//Crea un area de texto para la descripcion y configuraciones
        Font font = new Font("TimesRoman", Font.PLAIN, 16);
        JTextArea TextAreaDeDescripcion = new JTextArea(descripcion);
        TextAreaDeDescripcion.setFont(font);

        TextAreaDeDescripcion.setWrapStyleWord(true);
        TextAreaDeDescripcion.setLineWrap(true);
        TextAreaDeDescripcion.setOpaque(false);
        TextAreaDeDescripcion.setEditable(false);
        TextAreaDeDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        JLabel LabelStock = new JLabel("" + stock);
        LabelStock.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel LabelPrice = new JLabel(String.format("$%.2f MXN", precio));
        LabelPrice.setAlignmentX(Component.CENTER_ALIGNMENT);


        final JTextField Cantidad = new JTextField("0", 2);
        Cantidad.setHorizontalAlignment(JTextField.CENTER);


//CREA BOTONES CON ACTIONLISTENER
        JButton AgregarAlCarrito = new JButton("Agregar al carrito");
        AgregarAlCarrito.setForeground(Color.white);
        AgregarAlCarrito.setBackground(new Color(229,97,84));
        //AgregarAlCarrito.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        ImageIcon carrito1 = new ImageIcon("89145264e2267d52e7460787cb6793b3.jpg");
        int cAncho = 30;
        int cAlto = 30;
        ImageIcon carritoEscalada = new ImageIcon(carrito1.getImage().getScaledInstance(cAlto, cAncho, java.awt.Image.SCALE_SMOOTH));
        AgregarAlCarrito.setIcon(carritoEscalada);

        AgregarAlCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                //covvierte "cantidad", que es un texto a un int y esa cantidad lo almacena en "cantidades"
                int Cantidades = Integer.parseInt(Cantidad.getText());
                subtotal += precio * Cantidades;
                Cantidades++;
                Cantidad.setText(String.valueOf(Cantidades));
                labelSubTotal.setText("Subtotal: $" + String.format("%.2f", subtotal) );
            }
        });

        JButton AumentarCantidad = new JButton("+");
        AumentarCantidad.setForeground(Color.white);
        AumentarCantidad.setBackground(new Color(229,97,84));
        AumentarCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                int cantidades = Integer.parseInt(Cantidad.getText());
                cantidades++;
                Cantidad.setText(String.valueOf(cantidades));


            }
        });

        JButton DisminuirCantidad = new JButton("-");
        DisminuirCantidad.setForeground(Color.white);
        DisminuirCantidad.setBackground(new Color(229,97,84));
        DisminuirCantidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                int Cantidades = Integer.parseInt(Cantidad.getText());
                if(Cantidades > 0 ){
                Cantidades--;
                Cantidad.setText(String.valueOf(Cantidades));
                }
            }
        });
        detallesPanel.add(TextAreaDeDescripcion);
        detallesPanel.add(LabelStock);
        detallesPanel.add(LabelPrice);
        detallesPanel.add(AgregarAlCarrito);
        detallesPanel.add(AumentarCantidad);
        detallesPanel.add(DisminuirCantidad);

        JPanel controlPanel = new JPanel(new BorderLayout());
        

//panel de los botones
        JPanel botonesPanel = new JPanel(new GridLayout(2,1));
        botonesPanel.add(AumentarCantidad);
        botonesPanel.add(DisminuirCantidad);

//Panel de los botones y cantidadd, agrega el panel "botonePanel" al Panel "CantidadPanel"
        JPanel CantidadPanel = new JPanel(new FlowLayout());
        CantidadPanel.setBackground(Color.white);
        CantidadPanel.add(botonesPanel);
        CantidadPanel.add(Cantidad);

//agrega el panel "CantidadPanel" al Panel "controlPanel" y los centra
        controlPanel.add(CantidadPanel, BorderLayout.CENTER);

//agrega los Paneles "detallesPanel" y "controlPanel" al Panel de ProductosPanel
        productoPanel.add(detallesPanel, BorderLayout.CENTER);
        productoPanel.add(controlPanel, BorderLayout.EAST);

        return productoPanel;
    }

}

