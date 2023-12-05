import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {

    private JFrame Jframe;
    private JTextField txt_Usuario, txt_UsuarioRegistro;
    private JPasswordField txt_Contraseña, txt_ContraseñaRegistro;

    public LoginUI() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        Jframe = new JFrame("AUTENTICACIÓN/REGISTRO GYM STORE");
        Jframe.setBounds(100, 100, 400, 250);
        Jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jframe.setLayout(new BorderLayout(0, 0));

        JTabbedPane pestañas = new JTabbedPane();
        
        // Panel de Inicio de Sesión
        JPanel JLogin = new JPanel();
        JLogin.setLayout(new GridLayout(3, 2, 5, 5));
        
        JLogin.add(new JLabel("Usuario:"));
        txt_Usuario = new JTextField();
        JLogin.add(txt_Usuario);
        
        JLogin.add(new JLabel("Contraseña:"));
        txt_Contraseña = new JPasswordField();
        JLogin.add(txt_Contraseña);
        
        JButton Btn_Login = new JButton("Iniciar Sesión");
        Btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica de inicio de sesión
                String usuario = txt_Usuario.getText();
                char[] password = txt_Contraseña.getPassword();
                String contraseña = new String(password);
                 
                Login login = new Login(usuario, contraseña);

                if(login.inicioSesion()){
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    TiendaSwing tiendaSwing = new TiendaSwing(contraseña);
                    tiendaSwing.setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Inicio de sesión fallido");
                }
            } 
            // Aquí se crea una instancia de la otra ventana (TIENDASWING) y la hacemos visible

        });
        JLogin.add(Btn_Login);

        // Panel de Registro
        JPanel JRegistro = new JPanel();
        JRegistro.setLayout(new GridLayout(3, 2, 5, 5));
        
        JRegistro.add(new JLabel("Usuario:"));
        txt_UsuarioRegistro = new JTextField();
        JRegistro.add(txt_UsuarioRegistro);
        
        JRegistro.add(new JLabel("Contraseña:"));
        txt_ContraseñaRegistro = new JPasswordField();
        JRegistro.add(txt_ContraseñaRegistro);
        
        JButton Btn_Registro = new JButton("Registrarse");
        Btn_Registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica de registro
                char[] password = txt_ContraseñaRegistro.getPassword();
                String contraseña = new String(password);
                if (validarContraseña(password)) {
                    JOptionPane.showMessageDialog(null, "Contraseña válida: " + contraseña);

                    char[] password2 = txt_ContraseñaRegistro.getPassword();
                    String contraseña2 = new String(password2);

                    String email = txt_UsuarioRegistro.getText();
                    Login login = new Login(email, contraseña);
                    if(login.registro(email, contraseña2)){
                        System.out.println("Usuario registrado");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña inválida : " + contraseña);
                }
            }
        });
        JRegistro.add(Btn_Registro);

        

        pestañas.addTab("Iniciar Sesión", JLogin);
        pestañas.addTab("Registrarse", JRegistro);

        Jframe.add(pestañas, BorderLayout.CENTER);

        Jframe.setVisible(true);
    }

    private boolean validarContraseña(char[] contraseña) {
        String contraseñaStr = new String(contraseña);
        
        if (contraseñaStr.length() < 8) {
            return false;
        }
        
        if (!contraseñaStr.matches(".*[A-Z].*")) {
            return false; 
        }
        
        if (!contraseñaStr.matches(".*[a-z].*")) {
            return false; 
        }
        
        if (!contraseñaStr.matches(".*[0-9].*")) {
            return false;
        }
        
        if (!contraseñaStr.matches(".*[$,%&_#].*")) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginUI();
        });
    }
}
