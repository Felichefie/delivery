import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameConTresPaneles{
    private static int cantidadProducto1 = 0;
    private static int cantidadProducto2 = 0;
    private static int cantidadProducto3 = 0;

    public FrameConTresPaneles() {
        

// Configuración del frame principal

        

// Creación de los paneles
        JPanel panelSuperior = new JPanel();
        JPanel panelCentral = new JPanel();
        JPanel panelInferior = new JPanel();


// AGREGAR BOTONES E IMAGEN AL PANEL SUPERIOR
        panelSuperior.setBackground(bluee);
        JButton botonSuperiorAgregar = new JButton("Agregar al carrito de compras");
        JButton AumentarProductoSUP = new JButton("+");
        JButton disminuirProductoSUP = new JButton("-");
        JLabel cantidadProducto1Label = new JLabel("Cantidad: " + cantidadProducto1);
        JLabel stock1 = new JLabel("Cantidad en stock: 100          " );
        JLabel precio1 = new JLabel("$100.00 MXN");

        ImageIcon imagenOriginal = new ImageIcon("a0d8521a2bcca6566b08839aa759de40.jpg");
        int nuevoAncho = 100;
        int nuevoAlto = 100;
        ImageIcon imagenEscalada = new ImageIcon(imagenOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        JLabel imagenFinal = new JLabel(imagenEscalada);
    

        botonSuperiorAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "¡Se ha anadido este producto a tu carrito!");
                cantidadProducto1++;
                cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
            }
        });

        AumentarProductoSUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cantidadProducto1++;
                cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
            }
        });
        disminuirProductoSUP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(cantidadProducto1 > 0){
                cantidadProducto1--;
                cantidadProducto1Label.setText("Cantidad: " + cantidadProducto1);
                }
            }
        });
       
        panelSuperior.add(botonSuperiorAgregar);
        panelSuperior.add(AumentarProductoSUP);
        panelSuperior.add(disminuirProductoSUP);
        panelSuperior.add(cantidadProducto1Label);
        panelSuperior.add(stock1);
        panelSuperior.add(precio1);
        panelSuperior.add(imagenFinal);




// AGREGAR BOTONES E IMAGEN AL PANEL CENTRAL
        panelCentral.setBackground(bluee);
        JButton botonCentralAgregar = new JButton("Agregar al carrito de compras");
        JButton botonaumentarProductoCEN = new JButton("+");
        JButton botondisminuirProductoCEN = new JButton("-");
        JLabel cantidadProducto2Label = new JLabel("Cantidad: " + cantidadProducto2);
        JLabel stock2 = new JLabel("Cantidad en stock: 100          ");
        JLabel precio2 = new JLabel("$150.60 MXN");

        ImageIcon imagenCentral = new ImageIcon("896cb7994f825c07ccdefab31ca94e49.jpg"); 
        int nuevoAncho2 = 100;
        int nuevoAlto2 = 100;
        ImageIcon imagenEscalada2 = new ImageIcon(imagenCentral.getImage().getScaledInstance(nuevoAlto2, nuevoAncho2, java.awt.Image.SCALE_SMOOTH));
        JLabel imagenFinal2 = new JLabel(imagenEscalada2);


        botonCentralAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "¡Se ha agregado este producto a tu carrito de compras!");
                cantidadProducto2++;
                cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
            }
        });
        botonaumentarProductoCEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cantidadProducto2++;
                cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
            }
        });
        botondisminuirProductoCEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(cantidadProducto2 > 0 ){
                    cantidadProducto2--;
                    cantidadProducto2Label.setText("Cantidad: " + cantidadProducto2);
                }
            }
        });


        panelCentral.add(botonCentralAgregar);
        panelCentral.add(botonaumentarProductoCEN);
        panelCentral.add(botondisminuirProductoCEN);
        panelCentral.add(cantidadProducto2Label);
        panelCentral.add(stock2);
        panelCentral.add(precio2);
        panelCentral.add(imagenFinal2);




 // Agregar botón e imagen al panel inferior
        panelInferior.setBackground(bluee);
        JButton botonInferiorAgregar = new JButton("Agregar al carrito de compras");
        JButton botonaumentarProductoINF = new JButton("+");
        JButton botondisminuirProductoINF = new JButton("-");
        JLabel cantidadProducto3Label = new JLabel("Cantidad: " + cantidadProducto3);
        JLabel stock3 = new JLabel("Cantidad en stock: 100          ");
        JLabel precio3 = new JLabel("$98.99 MXN");

        ImageIcon imagenInferior = new ImageIcon("43a8db2d986ca90654cc8f42c2503e95.jpg"); 
        int nuevoAncho3 = 100;
        int nuevoAlto3 = 100;
        ImageIcon imagenEscalada3 = new ImageIcon(imagenInferior.getImage().getScaledInstance(nuevoAlto3, nuevoAncho3,java.awt.Image.SCALE_SMOOTH));
        JLabel imagenFinal3 = new JLabel(imagenEscalada3);


        //INFERIOR
        botonInferiorAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "¡Se ha agregado este producto a tu carrito de compras!");
                cantidadProducto3++;
                cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
            }
        });
        botonaumentarProductoINF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cantidadProducto3++;
                cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
            }
        });

       
        botondisminuirProductoINF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(cantidadProducto3 > 0 ){
                    cantidadProducto3--;
                    cantidadProducto3Label.setText("Cantidad: " + cantidadProducto3);
                }
            }
        });


        panelInferior.add(botonInferiorAgregar);
        panelInferior.add(botonaumentarProductoINF);
        panelInferior.add(botondisminuirProductoINF);
        panelInferior.add(cantidadProducto3Label);
        panelInferior.add(stock3);
        panelInferior.add(precio3);
        panelInferior.add(imagenFinal3);


// Configuración del layout del frame principal
        frame.setLayout(new GridLayout(3, 1));


// Agregar los paneles al frame principal
        frame.add(panelSuperior);
        frame.add(panelCentral);
        frame.add(panelInferior);

// Hacer visible el frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameConTresPaneles();
            }
        });
    }
}
