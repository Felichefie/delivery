import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        
        // Configuración del JFrame principal
        setTitle("Login Frame");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(290, 300));
        panel.setBounds(455, 100, 290, 180);
        panel.setBackground(Color.decode("#787B81")); // Ejemplo de color azul en formato hexadecimal
        // Panel raya
        JPanel panelr = new JPanel();
        panelr.setLayout(null);
        panelr.setPreferredSize(new Dimension(290, 300));
        panelr.setBounds(0, 0, 290, 5);
        panelr.setBackground(Color.decode("#003BCD"));
        
        
        //panel.setLayout(new GridLayout(3, 2));

        // Componentes del panel
        JLabel usuarioLabel = new JLabel("Usuario:");
        JTextField usuarioField = new JTextField();
        JLabel contrasenaLabel = new JLabel("Contraseña:"), x= new JLabel("");
        JPasswordField contrasenaField = new JPasswordField();
        JButton entrarButton = new JButton("Entrar");
        JButton registrarseButton = new JButton("Registrarse");
        //Posición de los objetos
        add(panel);
        usuarioLabel.setBounds(20, 20,80, 20);          usuarioField.setBounds(100, 20, 170, 20);
        contrasenaLabel.setBounds(20, 60, 80, 20);      contrasenaField.setBounds(100, 60, 170, 20);
        registrarseButton.setBounds(20, 110, 125, 50);  entrarButton.setBounds(145, 110, 125, 50);
        x.setBounds(0, 0, 0, 0);
        usuarioLabel.setForeground(Color.decode("#FFFFFF"));            contrasenaLabel.setForeground(Color.decode("#FFFFFF"));
        registrarseButton.setForeground(Color.decode("#FFFFFF"));       entrarButton.setForeground(Color.decode("#FFFFFF"));   
        // Color de fondo (Menu)
        registrarseButton.setBackground(Color.decode("#395FB8")); entrarButton.setBackground(Color.decode("#395FB8"));      
        
        // Agregar componentes al panel
        panel.add(panelr);
        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(contrasenaLabel);
        panel.add(contrasenaField);
        panel.add(entrarButton);
        panel.add(registrarseButton);/**/
        

        // Manejadores de eventos para los botones
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón "Entrar"
                String user, pass;
                char[] passwordChars = contrasenaField.getPassword();
                pass= new String(passwordChars);
                user=usuarioField.getText();

                Controlador autentisar= new Controlador(user, pass);
                boolean Exito = autentisar.check();
                if(Exito){
                    dispose(); // Cierra el frame actual
                    new ReproductorFrame(1, user).setVisible(true); // Abre el nuevo frame
                }
                

            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar el botón "Registrarse"
                dispose(); // Cierra el frame actual
                new RegistroFrame().setVisible(true); // Abre el nuevo frame
            }
        });

        // Agregar el panel al contenido del JFrame
        
        /*add(usuarioLabel);      add(usuarioField);
        add(contrasenaLabel);   add(contrasenaField);
        add(registrarseButton); add(entrarButton);*/
        

        // Hacer visible el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }
        });
    }
}
