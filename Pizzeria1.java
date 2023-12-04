import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Pizzeria1 {
    private JButton botonCompartido;
    private JButton aumentarProducto1;
    private JButton disminuirProducto1;
    private static int cantidadProducto1 = 0;


    public Pizzeria1(){
        JFrame f = new JFrame();
        f.setTitle("Botón en Varios Paneles");
        f.setSize(1000,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        ImageIcon imagenDeFondo = new ImageIcon("c86bc700d88da495c88ea0a6c9f0f241.jpg");
        JLabel labelFondo = new JLabel(imagenDeFondo);

        JLabel cantidadP1Label = new JLabel("Cantidad: " + cantidadProducto1);
        cantidadP1Label.setForeground(Color.WHITE);
        JLabel precio1 = new JLabel("$100.00 MXN");
        precio1.setForeground(Color.white);


//CREAR BOTON PARA AGREGAR AL CARRITO

    botonCompartido = new JButton();
    botonCompartido.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog( f,"\"¡Se ha anadido este producto a tu carrito!\"");
            cantidadProducto1++;
            cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
        }
    });

    aumentarProducto1 = new JButton("+");
    aumentarProducto1.addActionListener((new ActionListener() {
        @Override 
        public void actionPerformed(ActionEvent e){
                cantidadProducto1++;
                cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
        }
    }));
    disminuirProducto1 = new JButton("-");
    disminuirProducto1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            cantidadProducto1--;
            cantidadP1Label.setText("Cantidad: " + cantidadProducto1);
        }
    });
    
       
        

//Creacion de los paneles
        JPanel panel1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
            
        };
        JLabel cantidad1 = new JLabel("Cantidad: " + cantidadProducto1);
        cantidad1.setForeground(Color.WHITE);
        
       

        panel1.add(crearBotonParaAgregarAlCarrito());
        panel1.add(crearBotonAumento());
        panel1.add(crearBotonDisminucuion());
        panel1.add(cantidad1);



//PANEL2
        JPanel panel2 = new JPanel(){
             @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel2.add(crearBotonParaAgregarAlCarrito());
        panel2.add(crearBotonAumento());
        panel2.add(crearBotonDisminucuion());


//PANEL3
        JPanel panel3 = new JPanel(){
             @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel3.add(crearBotonParaAgregarAlCarrito());
        panel3.add(crearBotonAumento());
        panel3.add(crearBotonDisminucuion());




//PANEL4
        JPanel panel4 = new JPanel(){
             @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(imagenDeFondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel4.add(crearBotonParaAgregarAlCarrito());
        panel4.add(crearBotonAumento());
        panel4.add(crearBotonDisminucuion());

        
// Configuración del layout del frame principal (FILAS, COLUMNAS)
    f.setLayout(new GridLayout(1, 4));  







        f.add(panel1);
        f.add(panel2);
        f.add(panel3);
        f.add(panel4);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
//Boton que realiza la accion de agregar al carrito para cada uno de los paneles
    private JButton crearBotonParaAgregarAlCarrito(){
        JButton nuevoBoton = new JButton(botonCompartido.getText());
        ImageIcon carrito1 = new ImageIcon("89145264e2267d52e7460787cb6793b3.jpg");
        int cAncho = 30;
        int cAlto = 30;
        ImageIcon carritoEscalada = new ImageIcon(carrito1.getImage().getScaledInstance(cAlto, cAncho, java.awt.Image.SCALE_SMOOTH));

    nuevoBoton.setIcon(carritoEscalada);
        nuevoBoton.addActionListener(botonCompartido.getActionListeners()[0]);
        return nuevoBoton;
    }

    private JButton crearBotonAumento(){
        JButton nuevoAumento = new JButton(aumentarProducto1.getText());
        nuevoAumento.addActionListener(aumentarProducto1.getActionListeners()[0]);
        return nuevoAumento;
    }
    private JButton crearBotonDisminucuion(){
        JButton nuevoDisminucion = new JButton(disminuirProducto1.getText());
        nuevoDisminucion.addActionListener(disminuirProducto1.getActionListeners()[0]);
        return nuevoDisminucion;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Pizzeria1());
    }
}
