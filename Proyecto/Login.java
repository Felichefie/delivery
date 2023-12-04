package Proyecto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {

    private JFrame frame;
    private JLabel label_user, label_pass, etiqueta;
    private JTextField textField_user;
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

        label_user = new JLabel("Correo electronico");
        label_user.setBounds(70, 80, 200, 30);
        label_user.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_user.setForeground(Color.BLACK);

        textField_user = new JTextField();
        textField_user.setBounds(230, 80, 200, 30);
        textField_user.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_user.setBackground(new Color(205, 220, 205));
        textField_user.setFont(new Font("Arial", Font.PLAIN, 16));

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
                // Aquí puedes implementar la lógica de autenticación

                // Cerramos la GUI loguin
                frame.dispose();
                // Abrimos GUI principal
                new Principal();
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
        container.add(label_user);
        container.add(textField_user);
        container.add(label_pass);
        container.add(field_pass);
        container.add(button_login);
        container.add(button_register);
        container.add(etiqueta);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}