import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    private JFrame frame;
    private JLabel label_user;
    private JTextField textField_user;
    private JLabel label_pass;
    private JPasswordField Field_pass;
    private JButton button_login;
    private JButton button_register; // Nuevo botón de registro

    public Login() {
        frame = new JFrame("GUI Login");
        frame.setBounds(300, 90, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Container container = frame.getContentPane();
        container.setLayout(null);

        label_user = new JLabel("Username");
        label_user.setBounds(50, 30, 100, 30);
        textField_user = new JTextField();
        textField_user.setBounds(150, 30, 150, 30);

        label_pass = new JLabel("Password");
        label_pass.setBounds(50, 70, 100, 30);

        // Esto hará que se muestren asteriscos en lugar de puntos
        Field_pass = new JPasswordField();
        Field_pass.setBounds(150, 70, 150, 30);
        Field_pass.setEchoChar('*');

        button_login = new JButton("Login");
        button_login.setBounds(50, 110, 100, 30);

        // Nuevo botón de registro
        button_register = new JButton("Register");
        button_register.setBounds(160, 110, 100, 30);

        button_register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la GUI de Login
                frame.dispose();
                // Crear una nueva instancia de la GUI de registro
                new Registration();
            }
        });

        button_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica de autenticación
                String userName = textField_user.getText();
                String password = String.valueOf(Field_pass.getPassword());
            }
        });
        // Agregar todos los elementos al contenedor
        container.add(label_user);
        container.add(textField_user);
        container.add(label_pass);
        container.add(Field_pass);
        container.add(button_login);
        container.add(button_register);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}