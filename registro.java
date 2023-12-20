import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class registro {

    public static void registro() {
        JFrame inicio = new JFrame("REGISTRO");
        inicio.setSize(800, 600);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color b = new Color(255, 216, 0);
        inicio.getContentPane().setBackground(b);
        inicio.setLayout(new BorderLayout());
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);

        ImageIcon iconoApp = new ImageIcon("img/iconos/logo.png");
        inicio.setIconImage(iconoApp.getImage());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(b);
        inicio.add(panelSuperior, BorderLayout.NORTH);

        JLabel label1 = new JLabel("REGISTRO");
        label1.setFont(new Font("Monospaced", Font.BOLD, 16));
        label1.setForeground(Color.BLACK);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setPreferredSize(new Dimension(100, 60));
        panelSuperior.add(label1, BorderLayout.CENTER);

        JButton btnAtras = new JButton("Atras");
        btnAtras.setForeground(Color.BLACK);
        btnAtras.setBackground(b);
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.dispose();
            }
        });
        btnAtras.setPreferredSize(new Dimension(80, 30));
        panelSuperior.add(btnAtras, BorderLayout.WEST); 

        JPanel panelInicioSesion = new JPanel(new BorderLayout());
        panelInicioSesion.setBackground(Color.WHITE); 
        panelInicioSesion.setBounds(50, 100, 300, 300);
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2)); 
        inicio.add(panelInicioSesion);


        JPanel panelFormulario = new JPanel(new GridLayout(11, 2, 5, 5));
        panelFormulario.setBackground(Color.WHITE); 

        JLabel labelUserName = new JLabel("Nombre de usuario:");
        labelUserName.setForeground(Color.BLACK);
        JTextField campoUserName = new JTextField();

        JLabel labelNombre = new JLabel("Nombre:");
        labelNombre.setForeground(Color.BLACK);
        JTextField campoNombre = new JTextField();

        JLabel labelPrimerApellido = new JLabel("Primer apellido:");
        labelPrimerApellido.setForeground(Color.BLACK);
        JTextField campoPrimerApellido = new JTextField();     

        JLabel labelSegundoApellido = new JLabel("Segundo apellido:");
        labelSegundoApellido.setForeground(Color.BLACK);
        JTextField campoSegundoApellido = new JTextField();  

        JLabel labelFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        labelFechaNacimiento.setForeground(Color.BLACK);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        dateSpinner.setValue(new Date());

        JLabel labelCorreo = new JLabel("Email:");
        labelCorreo.setForeground(Color.BLACK);
        JTextField campoCorreo = new JTextField();

        JLabel labelTelefono = new JLabel("Teléfono:");
        labelTelefono.setForeground(Color.BLACK);
        JTextField campoTelefono = new JTextField();

        JLabel labelGenero = new JLabel("Género:");
        labelGenero.setForeground(Color.BLACK);
        String[] opcionesGenero = {"Hombre", "Mujer"};
        JComboBox<String> comboGenero = new JComboBox<>(opcionesGenero);


        JLabel labelContraseña = new JLabel("Clave:");
        labelContraseña.setForeground(Color.BLACK);
        JPasswordField campoContraseña = new JPasswordField();

        JLabel labelRepetirContraseña = new JLabel("Repetir Clave:");
        labelRepetirContraseña.setForeground(Color.BLACK);
        JPasswordField campoRepetirContraseña = new JPasswordField();

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setForeground(Color.BLACK);
        btnRegistrar.setBackground(b);

        panelFormulario.add(labelUserName);
        panelFormulario.add(campoUserName);
        panelFormulario.add(labelNombre);
        panelFormulario.add(campoNombre);
        panelFormulario.add(labelPrimerApellido);
        panelFormulario.add(campoPrimerApellido);
        panelFormulario.add(labelSegundoApellido);
        panelFormulario.add(campoSegundoApellido);
        panelFormulario.add(labelFechaNacimiento);
        panelFormulario.add(dateSpinner);
        panelFormulario.add(labelCorreo);
        panelFormulario.add(campoCorreo);
        panelFormulario.add(labelTelefono);
        panelFormulario.add(campoTelefono);
        panelFormulario.add(labelGenero);
        panelFormulario.add(comboGenero);
        panelFormulario.add(labelContraseña);
        panelFormulario.add(campoContraseña);
        panelFormulario.add(labelRepetirContraseña);
        panelFormulario.add(campoRepetirContraseña);
        panelFormulario.add(btnRegistrar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(inicio, "Introduce tu direccion", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundRegistro.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                registro();
            }
        });
    }
}
