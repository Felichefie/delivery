import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Registro {

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
        panelInicioSesion.setBounds(50, 100, 350, 350);
        panelInicioSesion.setBorder(new LineBorder(Color.BLACK, 2));
        inicio.add(panelInicioSesion);

        JPanel panelFormulario = new JPanel(new GridLayout(11, 3, 5, 5)); 
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

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setForeground(Color.BLACK);
        btnAceptar.setBackground(b);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setBackground(b);

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
        panelFormulario.add(btnCancelar);
        panelFormulario.add(btnAceptar);

        panelInicioSesion.add(panelFormulario, BorderLayout.CENTER);

        // ...

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Users user = new Users();
                user.setUserName(campoUserName.getText());
                user.setName(campoNombre.getText());
                user.setApe1(campoPrimerApellido.getText());
                user.setApe2(campoSegundoApellido.getText());
                user.setBirthday(dateSpinner.getValue().toString());
                user.setEmail(campoCorreo.getText());
                user.setTel(campoTelefono.getText());
                user.setSex(comboGenero.getSelectedItem().toString());
                char[] password = campoContraseña.getPassword();
                String contraseña = new String(password);
                char[] password2 = campoRepetirContraseña.getPassword();
                String contraseña2 = new String(password2);
                if(user.getUserName().equals("") || user.getName().equals("") || user.getApe1().equals("") || user.getApe2().equals("") || user.getBirthday().equals("") || user.getEmail().equals("") || user.getTel().equals("") || user.getSex().equals("") || contraseña.equals("") || contraseña2.equals("")){
                    JOptionPane.showMessageDialog(inicio, "¡Faltan campos por llenar!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(contraseña.equals(contraseña2)){
                    user.setPass(contraseña);
                    if(Main.registro(user)){
                    JOptionPane.showMessageDialog(inicio, "¡Registrado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    inicio.dispose();
                    }else{
                    JOptionPane.showMessageDialog(inicio, "¡Error al registrar!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(inicio, "¡Las contraseñas no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoUserName.setText("");
                campoNombre.setText("");
                campoPrimerApellido.setText("");
                campoSegundoApellido.setText("");
                campoCorreo.setText("");
                campoTelefono.setText("");
                campoContraseña.setText("");
                campoRepetirContraseña.setText("");
            }
        });

        ImageIcon imageFondo = new ImageIcon("img/background/BackgroundRegistro.jpg");
        JLabel labelFondo = new JLabel(imageFondo);
        inicio.add(labelFondo);

        inicio.setVisible(true);
    }

}