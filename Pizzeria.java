import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pizzeria {

    private static int cantidadProducto1 = 0;
    private static int cantidadProducto2 = 0;
    private static int cantidadProducto3 = 0;


    public Pizzeria(){
//CONFURA EL FRAME PRINCIPAL
        JFrame frame = new JFrame( "PIZZERIA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);
        frame.setLayout(null);
        Color gray= new Color(177, 213, 222); 
        Color purp = new Color(220, 191, 223);
        Color purp2 = new Color(145,43,212);
        Color pink = new Color(228, 184, 209);
        Color pink2 = new Color(255,8,154);
        ImageIcon imagenDeFondo = new ImageIcon("c86bc700d88da495c88ea0a6c9f0f241.jpg");
        JLabel labelFondo = new JLabel(imagenDeFondo);
       


        
//CREACION DE LOS PANELES
        
        JPanel p3 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel p4 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };


//PANEL 1
        JPanel p1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        int nuevoAncho1 = 100;
        int nuevoAlto1 = 100;
        ImageIcon imagenOriginal1 = new ImageIcon("ea6474607ee7721229130ebb1c893b6f.jpg");
        ImageIcon  imagenEscalada1 = new ImageIcon(imagenOriginal1.getImage().getScaledInstance(nuevoAncho1, nuevoAlto1, java.awt.Image.SCALE_SMOOTH));
        JLabel imagenFinal1 = new JLabel(imagenEscalada1);

        JLabel stock1 = new JLabel("Cantidad en stock: 100          " );
        stock1.setForeground(Color.WHITE);
        JButton boton1Agregar = new JButton();
        JButton aumentarProducto1 = new JButton("+");
        JButton disminuirProducto1 = new JButton("-");
        JLabel cantidadP1Label = new JLabel("Cantidad: " + cantidadProducto1);
        cantidadP1Label.setForeground(Color.WHITE);
        JLabel precio1 = new JLabel("$100.00 MXN");
        precio1.setForeground(Color.white);

        //agrega imagen a boton
        ImageIcon carrito1 = new ImageIcon("fd48bc14d8c637699a2ef134fb88eead.jpg");
        int cAncho = 20;
        int cAlto = 20;
        ImageIcon carritoEscalada = new ImageIcon(carrito1.getImage().getScaledInstance(cAncho, cAlto, java.awt.Image.SCALE_SMOOTH));
        boton1Agregar.setIcon(carritoEscalada);

        //Escucha los botones
        boton1Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "\"¡Se ha anadido este producto a tu carrito!\"");
                cantidadProducto1++;
                cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
                
            }
        });

        aumentarProducto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cantidadProducto1++;
                cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
            }
        });
        disminuirProducto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(cantidadProducto1 > 0){
                cantidadProducto1--;
                cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
                }
            }
        });

        
        p1.add(stock1);
        p1.add(imagenFinal1);
        p1.add(precio1);
        p1.add(cantidadP1Label);
        p1.add(boton1Agregar); 
        p1.add(aumentarProducto1);
        p1.add(disminuirProducto1);
       


//PANEL2
        JPanel p2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        int nuevoAncho2 = 100;
        int nuevoAlto2 = 120;
        ImageIcon imagenOriginal2 = new ImageIcon("f086c2b68c7bc41d5371815fb4e0fc58.jpg");
        ImageIcon  imagenEscalada2 = new ImageIcon(imagenOriginal2.getImage().getScaledInstance(nuevoAncho2, nuevoAlto2, java.awt.Image.SCALE_SMOOTH));
        JLabel imagenFinal2 = new JLabel(imagenEscalada2);


        p2.add(imagenFinal2);

       


//PANEL3
        p3.setBackground(pink);
        p3.setLayout(new FlowLayout());
        


//PANEL 4
        p4.setLayout(new FlowLayout());
       




// Configuración del layout del frame principal (FILAS, COLUMNAS)
    frame.setLayout(new GridLayout(1, 4));  





        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);


        frame.setVisible(true);

    }
   


     public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pizzeria();
            }
        });
    }
}
