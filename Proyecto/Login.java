package Proyecto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String pass = "alumnoPrueba1";

    private JFrame frame;
    private JLabel label_correoElectronico, label_pass, etiqueta;
    private JTextField textField_correoElectronico;
    private JPasswordField field_pass;
    private JButton button_login, button_register;

    public Login() {
        this.add(new JLabel("Login Panel"));

        frame = new JFrame("GUI Login");
        frame.setBounds(300, 90, 495, 370);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Cargar la imagen de fondo
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Login_Fondo.jpeg"));
        Image image = imageIcon.getImage();
        // Escalar la imagen
        Image scaledImage = image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);

        // Crear un JPanel personalizado que pinte la imagen de fondo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(scaledImage, 0, 0, this);
            }
        };
        panel.setLayout(null);
        // Agregar el panel al JFrame
        frame.setContentPane(panel);
        frame.setVisible(true);

        Container container = frame.getContentPane();
        container.setLayout(null);

        etiqueta = new JLabel("BIENVENIDO");
        etiqueta.setBounds(150, 20, 200, 30);
        etiqueta.setFont(new Font("sansserif", 1, 30));
        etiqueta.setForeground(new Color(10, 10, 10));

        label_correoElectronico = new JLabel("Correo electronico");
        label_correoElectronico.setBounds(70, 80, 200, 30);
        label_correoElectronico.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_correoElectronico.setForeground(Color.BLACK);

        textField_correoElectronico = new JTextField();
        textField_correoElectronico.setBounds(230, 80, 200, 30);
        textField_correoElectronico.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_correoElectronico.setBackground(new Color(205, 220, 205));
        textField_correoElectronico.setFont(new Font("Arial", Font.PLAIN, 16));

        label_pass = new JLabel("Contraseña");
        label_pass.setBounds(70, 130, 200, 30);
        label_pass.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_pass.setForeground(Color.BLACK);

        field_pass = new JPasswordField();
        field_pass.setBounds(230, 130, 200, 30);
        field_pass.setEchoChar('*');
        field_pass.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        field_pass.setBackground(new Color(205, 220, 205));
        field_pass.setFont(new Font("Arial", Font.PLAIN, 16));

        button_login = new JButton("Login");
        button_login.setBounds(65, 200, 150, 40);
        button_login.setBackground(new Color(7, 164, 121));
        button_login.setForeground(Color.WHITE);
        button_login.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        button_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí lógica de autenticación
                String correoElectronico = textField_correoElectronico.getText();
                String contraseña = String.valueOf(field_pass.getPassword());
                Autenticacion autenticacion = new Autenticacion(correoElectronico, contraseña);
                // Obtener y mostrar el mensaje devuelto por Autenticacion
                String mensajeResultado = autenticacion.autenticar();

                if (mensajeResultado.startsWith("Autenticación exitosa")) {
                    Principal principal = new Principal();
                    principal.mostrar();
                    frame.dispose();

                }
            }
        });

        button_register = new JButton("Registrarte");
        button_register.setBounds(280, 200, 150, 40);
        button_register.setBackground(new Color(7, 164, 121));
        button_register.setForeground(Color.WHITE);
        button_register.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        button_register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la GUI de Login
                frame.dispose();
                // Crear una nueva instancia de la GUI de registro
                new Registration();
            }
        });

        // Agregar todos los elementos al contenedor
        container.add(label_correoElectronico);
        container.add(textField_correoElectronico);
        container.add(label_pass);
        container.add(field_pass);
        container.add(button_login);
        container.add(button_register);
        container.add(etiqueta);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // lee token y hora de expiracion
        try (BufferedReader reader = new BufferedReader(new FileReader("token.txt"))) {
            String[] datos = reader.readLine().split(",");
            String token = datos[0];
            String expiration = datos[1];
            Timestamp expiracionTimestamp = Timestamp.valueOf(expiration);

            // Obtener el tiempo actual en milisegundos y convertirlo a Timestamp
            long tiempoActualMillis = System.currentTimeMillis();
            Timestamp tiempoActual = new Timestamp(tiempoActualMillis);

            // Si la fecha de expiración no ha pasado
            if (expiracionTimestamp.after(tiempoActual)) {

                // El usuario está autenticado
                Principal principal = new Principal();
                principal.mostrar();
            } else {

                // La sesión ha expirado, tienen que hacer login de nuevo
                new Login();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}