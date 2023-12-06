package Proyecto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

//
public class Registration {

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String pass = "alumnoPrueba1";

    private JFrame frame;
    private JLabel label_username, label_nombre, label_primerApellido, label_segundoApellido,
            label_pass, label_fechaNacimiento, label_correoElectronico, label_genero, label_telefono,
            label_usuario, etiqueta;
    private JTextField textField_username, textField_nombre, textField_primerApellido,
            textField_segundoApellido, textField_correoElectronico, textField_telefono;
    private JDateChooser dateChooser_fechaNacimiento;
    private JComboBox<String> type_user, comboBox_genero;
    private JPasswordField field_pass;
    private JButton button_register, button_cancel;

    public Registration() {
        frame = new JFrame("GUI Registration");
        frame.setBounds(600, 90, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Cargar la imagen de fondo
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Registration_Fondo.jpg"));
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

        etiqueta = new JLabel("REGISTRO");
        etiqueta.setBounds(180, 20, 200, 30);
        etiqueta.setFont(new Font("sansserif", 1, 30));
        etiqueta.setForeground(new Color(10, 10, 10));

        // Tipo de usuario
        String[] options = { "Cliente", "Vendedor" };
        label_usuario = new JLabel("Tipo de usuario");
        label_usuario.setBounds(50, 70, 100, 30);
        label_usuario.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_usuario.setForeground(Color.BLACK);
        type_user = new JComboBox<>(options);
        type_user.setBounds(200, 70, 200, 30);
        BorderFactory.createEmptyBorder(5, 5, 5, 5);
        type_user.setBackground(new Color(205, 220, 205));
        type_user.setFont(new Font("Arial", Font.PLAIN, 16));

        // Username
        label_username = new JLabel("Username");
        label_username.setBounds(50, 110, 100, 30);
        label_username.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_username.setForeground(Color.BLACK);
        textField_username = new JTextField();
        textField_username.setBounds(200, 110, 200, 30);
        textField_username.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_username.setBackground(new Color(205, 220, 205));
        textField_username.setFont(new Font("Arial", Font.PLAIN, 16));

        // Primer apellido
        label_primerApellido = new JLabel("Primer Apellido");
        label_primerApellido.setBounds(50, 150, 100, 30);
        label_primerApellido.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_primerApellido.setForeground(Color.BLACK);
        textField_primerApellido = new JTextField();
        textField_primerApellido.setBounds(200, 150, 200, 30);
        textField_primerApellido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_primerApellido.setBackground(new Color(205, 220, 205));
        textField_primerApellido.setFont(new Font("Arial", Font.PLAIN, 16));

        // Segundo apellido
        label_segundoApellido = new JLabel("Segundo Apellido");
        label_segundoApellido.setBounds(50, 190, 100, 30);
        label_segundoApellido.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_segundoApellido.setForeground(Color.BLACK);
        textField_segundoApellido = new JTextField();
        textField_segundoApellido.setBounds(200, 190, 200, 30);
        textField_segundoApellido.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_segundoApellido.setBackground(new Color(205, 220, 205));
        textField_segundoApellido.setFont(new Font("Arial", Font.PLAIN, 16));

        // Nombre
        label_nombre = new JLabel("Nombre");
        label_nombre.setBounds(50, 230, 100, 30);
        label_nombre.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_nombre.setForeground(Color.BLACK);
        textField_nombre = new JTextField();
        textField_nombre.setBounds(200, 230, 200, 30);
        textField_nombre.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_nombre.setBackground(new Color(205, 220, 205));
        textField_nombre.setFont(new Font("Arial", Font.PLAIN, 16));

        // Fecha de Nacimiento
        label_fechaNacimiento = new JLabel("Fecha de Nacimiento");
        label_fechaNacimiento.setBounds(50, 270, 150, 30);
        label_fechaNacimiento.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_fechaNacimiento.setForeground(Color.BLACK);
        dateChooser_fechaNacimiento = new JDateChooser();
        dateChooser_fechaNacimiento.setBounds(200, 270, 200, 30);
        dateChooser_fechaNacimiento.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        dateChooser_fechaNacimiento.setBackground(new Color(205, 220, 205));
        dateChooser_fechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 16));

        // Correo Electrónico
        label_correoElectronico = new JLabel("Correo Electrónico");
        label_correoElectronico.setBounds(50, 310, 150, 30);
        label_correoElectronico.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_correoElectronico.setForeground(Color.BLACK);
        textField_correoElectronico = new JTextField();
        textField_correoElectronico.setBounds(200, 310, 200, 30);
        textField_correoElectronico.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_correoElectronico.setBackground(new Color(205, 220, 205));
        textField_correoElectronico.setFont(new Font("Arial", Font.PLAIN, 16));

        // Por si es hombre o mujer
        String[] generos = { "Hombre", "Mujer" };
        label_genero = new JLabel("Género");
        label_genero.setBounds(50, 350, 100, 30);
        label_genero.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_genero.setForeground(Color.BLACK);
        comboBox_genero = new JComboBox<>(generos);
        comboBox_genero.setBounds(200, 350, 200, 30);
        BorderFactory.createEmptyBorder(5, 5, 5, 5);
        comboBox_genero.setBackground(new Color(205, 220, 205));
        comboBox_genero.setFont(new Font("Arial", Font.PLAIN, 16));

        // Telefono
        label_telefono = new JLabel("Teléfono");
        label_telefono.setBounds(50, 390, 100, 30);
        label_telefono.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_telefono.setForeground(Color.BLACK);
        textField_telefono = new JTextField();
        textField_telefono.setBounds(200, 390, 200, 30);
        textField_telefono.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textField_telefono.setBackground(new Color(205, 220, 205));
        textField_telefono.setFont(new Font("Arial", Font.PLAIN, 16));

        // Contraseña
        label_pass = new JLabel("Contraseña");
        label_pass.setBounds(50, 430, 100, 30);
        label_pass.setFont(new Font("Segoe UI Semibold", 1, 14));
        label_pass.setForeground(Color.BLACK);
        // Esto hará que se muestren asteriscos en lugar de puntos
        field_pass = new JPasswordField();
        field_pass.setBounds(200, 430, 200, 30);
        field_pass.setEchoChar('*');
        field_pass.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        field_pass.setBackground(new Color(205, 220, 205));
        field_pass.setFont(new Font("Arial", Font.PLAIN, 16));

        // Boton registrar
        button_register = new JButton("Registrar");
        button_register.setBounds(100, 490, 150, 40);
        button_register.setBackground(new Color(7, 164, 121));
        button_register.setForeground(Color.WHITE);
        button_register.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        // Agregar un ActionListener al botón
        button_register.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Llama al método para insertar datos en la base de datos
                    InsertarEnDB();
            
                    // Cerrar la GUI de Registration
                    frame.dispose();
                    // Volver a abrir la GUI de Login
                    //new Principal();
                   JFrame principalFrame = new JFrame("Principal con pestañas");
                    Pestañas pestañas = new Pestañas();
                    principalFrame.add(pestañas);
                    principalFrame.setBounds(280, 75, 800, 600);
                    principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    principalFrame.setVisible(true);
                }
            });

        // Boton de cancelar
        button_cancel = new JButton("Cancelar");
        button_cancel.setBounds(350, 490, 150, 40);
        button_cancel.setBackground(new Color(7, 164, 121));
        button_cancel.setForeground(Color.WHITE);
        button_cancel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

        // Agregar un ActionListener al botón
        button_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la GUI de Registration
                frame.dispose();
                // Volver a abrir la GUI de Login
                new Login();
            }
        });

        container.add(type_user);
        container.add(etiqueta);
        container.add(label_usuario);

        container.add(label_username);
        container.add(textField_username);

        container.add(label_primerApellido);
        container.add(textField_primerApellido);

        container.add(label_segundoApellido);
        container.add(textField_segundoApellido);

        container.add(label_nombre);
        container.add(textField_nombre);

        container.add(label_fechaNacimiento);
        container.add(dateChooser_fechaNacimiento);

        container.add(label_correoElectronico);
        container.add(textField_correoElectronico);

        container.add(label_genero);
        container.add(comboBox_genero);

        container.add(label_telefono);
        container.add(textField_telefono);

        container.add(label_pass);
        container.add(field_pass);

        container.add(button_register);
        container.add(button_cancel);

        frame.setVisible(true);

    }

    private void InsertarEnDB() {
        // Obtener los valores ingresados en la GUI
        String tipoUsuario = (String) type_user.getSelectedItem();
        String username = textField_username.getText();
        String primerApellido = textField_primerApellido.getText();
        String segundoApellido = textField_segundoApellido.getText();
        String nombre = textField_nombre.getText();
        Date fechaNacimiento = new Date(dateChooser_fechaNacimiento.getDate().getTime());
        String correoElectronico = textField_correoElectronico.getText();
        String genero = (String) comboBox_genero.getSelectedItem();
        String telefono = textField_telefono.getText();
        String password = String.valueOf(field_pass.getPassword());
        //String password = String.valueOf(field_pass.getPassword());
        String pwd_hash = BCrypt.hashpw(password, BCrypt.gensalt());

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime endTimeSession = nowDate.plusMinutes(5);

        String queryInsertUser = "INSERT INTO progra2.users(type_user, user_name, first_lastname, second_lastname, name, birthday, email, gender, phone_number, password, created)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String queryInsertSession = "INSERT INTO progra2.sessions(id_user, session, timeout, created) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, user, pass);
                PreparedStatement prepStateUser = conn.prepareStatement(queryInsertUser, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement prepStateSession = conn.prepareStatement(queryInsertSession)) {

                conn.setAutoCommit(false);

        prepStateUser.setString(1, tipoUsuario);
        prepStateUser.setString(2, username);
        prepStateUser.setString(3, primerApellido);
        prepStateUser.setString(4, segundoApellido);
        prepStateUser.setString(5, nombre);
        prepStateUser.setDate(6, new java.sql.Date(fechaNacimiento.getTime()));
        prepStateUser.setString(7, correoElectronico);
        prepStateUser.setString(8, genero);
        prepStateUser.setString(9, telefono);
        prepStateUser.setString(10, pwd_hash);
        prepStateUser.setDate(11, new java.sql.Date(System.currentTimeMillis())); // created

        prepStateUser.executeUpdate();

        // Recupera ID del usuario generado
        ResultSet generatedKeys = prepStateUser.getGeneratedKeys();
        int userId = -1;
        if (generatedKeys.next()) {
                userId = generatedKeys.getInt(1);
        }
        String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8,13);
        String sessionUUID = UUID.randomUUID().toString().substring(1,10);
        String session = sessionTime + sessionUUID;

        prepStateSession.setInt(1, userId); // id_user
        prepStateSession.setString(2, session); // session
        Timestamp timeoutTimestamp = Timestamp.valueOf(endTimeSession);
        Timestamp createdTimestamp = Timestamp.valueOf(nowDate);
        prepStateSession.setTimestamp(3, timeoutTimestamp); // timeout
        prepStateSession.setTimestamp(4, createdTimestamp); // created

        prepStateSession.executeUpdate();

        conn.commit();
        System.out.println("Usuario y session ingresado correctamente");

        conn.setAutoCommit(true);

        } catch (SQLException e) {
        e.printStackTrace();
        } catch (Exception ex) {
                ex.printStackTrace();
        }
}
}
 
