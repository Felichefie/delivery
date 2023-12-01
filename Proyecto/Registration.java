package Proyecto;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Registration {

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String pass = "alumnoPrueba1";

    private JFrame frame;
    private JLabel label_username, label_nombre, label_primerApellido, label_segundoApellido,
            label_pass, label_fechaNacimiento, label_correoElectronico, label_genero, label_telefono,
            label_usuario;
    private JTextField textField_username, textField_nombre, textField_primerApellido,
            textField_segundoApellido, textField_correoElectronico, textField_telefono;
    private JDateChooser dateChooser_fechaNacimiento;
    private JComboBox<String> type_user, comboBox_genero;
    private JPasswordField field_pass;
    private JButton button_register;

    public Registration() {
        frame = new JFrame("GUI Registration");
        frame.setBounds(600, 90, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Container container = frame.getContentPane();
        container.setLayout(null);

        // Tipo de usuario
        String[] options = { "Cliente", "Vendedor" };
        label_usuario = new JLabel("Tipo de usuario");
        label_usuario.setBounds(50, 70, 100, 30);
        type_user = new JComboBox<>(options);
        type_user.setBounds(200, 70, 200, 30);

        // Username
        label_username = new JLabel("Username");
        label_username.setBounds(50, 110, 100, 30);
        textField_username = new JTextField();
        textField_username.setBounds(200, 110, 150, 30);

        // Primer apellido
        label_primerApellido = new JLabel("Primer Apellido");
        label_primerApellido.setBounds(50, 150, 100, 30);
        textField_primerApellido = new JTextField();
        textField_primerApellido.setBounds(200, 150, 150, 30);

        // Segundo apellido
        label_segundoApellido = new JLabel("Segundo Apellido");
        label_segundoApellido.setBounds(50, 190, 100, 30);
        textField_segundoApellido = new JTextField();
        textField_segundoApellido.setBounds(200, 190, 150, 30);

        // Nombre
        label_nombre = new JLabel("Nombre");
        label_nombre.setBounds(50, 230, 100, 30);
        textField_nombre = new JTextField();
        textField_nombre.setBounds(200, 230, 150, 30);

        // Fecha de Nacimiento
        label_fechaNacimiento = new JLabel("Fecha de Nacimiento");
        label_fechaNacimiento.setBounds(50, 270, 150, 30);
        dateChooser_fechaNacimiento = new JDateChooser();
        dateChooser_fechaNacimiento.setBounds(200, 270, 150, 30);

        // Correo Electrónico
        label_correoElectronico = new JLabel("Correo Electrónico");
        label_correoElectronico.setBounds(50, 310, 150, 30);
        textField_correoElectronico = new JTextField();
        textField_correoElectronico.setBounds(200, 310, 150, 30);

        // Por si es hombre o mujer
        String[] generos = { "", "Hombre", "Mujer" };
        label_genero = new JLabel("Género");
        label_genero.setBounds(50, 350, 100, 30);
        comboBox_genero = new JComboBox<>(generos);
        comboBox_genero.setBounds(200, 350, 150, 30);

        // Telefono
        label_telefono = new JLabel("Teléfono");
        label_telefono.setBounds(50, 390, 100, 30);
        textField_telefono = new JTextField();
        textField_telefono.setBounds(200, 390, 150, 30);

        // Contraseña
        label_pass = new JLabel("Contraseña");
        label_pass.setBounds(50, 430, 100, 30);
        // Esto hará que se muestren asteriscos en lugar de puntos
        field_pass = new JPasswordField();
        field_pass.setBounds(200, 430, 150, 30);
        field_pass.setEchoChar('*');
        field_pass.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        field_pass.setBackground(Color.LIGHT_GRAY);

        // Boton registrar
        button_register = new JButton("Registrar");
        button_register.setBounds(140, 480, 100, 30);

        // Agregar un ActionListener al botón
        button_register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para insertar datos en la base de datos
                InsertarEnDB();

                // Cerrar la GUI de Registration
                frame.dispose();
                // Volver a abrir la GUI de Login
                new Login();
            }
        });

        // Boton de cancelar
        JButton button_cancel = new JButton("Cancelar");
        button_cancel.setBounds(280, 480, 100, 30);

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

        // Preparar y ejecutar la consulta de inserción
        String queryInsert = "INSERT INTO progra2.users(type_user, user_name, first_lastname, second_lastname, name, birthday, email, gender, phone_number, password, created)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, user, pass);
                PreparedStatement prepState = conn.prepareStatement(queryInsert)) {

            prepState.setString(1, tipoUsuario);
            prepState.setString(2, username);
            prepState.setString(3, primerApellido);
            prepState.setString(4, segundoApellido);
            prepState.setString(5, nombre);
            prepState.setDate(6, new java.sql.Date(fechaNacimiento.getTime()));
            prepState.setString(7, correoElectronico);
            prepState.setString(8, genero);
            prepState.setString(9, telefono);
            prepState.setString(10, password);
            prepState.setDate(11, new java.sql.Date(System.currentTimeMillis())); // created

            prepState.execute();
            System.out.println("Datos insertados exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
