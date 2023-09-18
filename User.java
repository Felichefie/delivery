import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame{

    private JTextField ubicacionField;
    private JTextField direccionField;
    private JTextField emailField;
    private JTextField nombreField;
    private JTextField primerApellidoField;
    private JTextField segundoApellidoField;
    private JTextField telefonoField;
    

    /**
     * 
     */
    public User() {
        setTitle("Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

// Creamos un panel para organizar los componentes
        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(9, 2 ));

// Etiquetas y campos de texto para los datos del usuario
        JLabel ubicacionLabel = new JLabel("Ubicación:");
        ubicacionField = new JTextField();

        JLabel direccionLabel = new JLabel("Direccion:");
        direccionField = new JTextField();

        JLabel emailLabel = new JLabel("Correo Electronico:");
        emailField = new JTextField();

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel primerApellidoLabel = new JLabel("PrimerApellido:");
        primerApellidoField = new JTextField();

        JLabel segundoApellidoLabel = new JLabel("SegundoApellido:");
        segundoApellidoField = new JTextField();

        JLabel telefonoLabel = new JLabel("Telefono:");
        telefonoField = new JTextField();


 // Botón para guardar los datos
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ubicacion = ubicacionField.getText();
                String direccion = direccionField.getText();
                String email = emailField.getText();
                String nombre = nombreField.getText();
                String primerApellido = primerApellidoField.getText();
                String segundoApellido = segundoApellidoField.getText();
                String telefono = telefonoField.getText();


                System.out.println("Ubicación: " + ubicacion);
                System.out.println("Direccion: " + direccion);
                System.out.println("Correo Electronico: " + email);
                System.out.println("Nombre: " + nombre);
                System.out.println("Primer Apellido: " + primerApellido);
                System.out.println("Segundo Apellido: " + segundoApellido);
                System.out.println("Telefono: " + telefono);


                limpiarCampos();
            }
        });

        panel.add(ubicacionLabel);
        panel.add(ubicacionField);
        panel.add(direccionLabel);
        panel.add(direccionField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(primerApellidoLabel);
        panel.add(primerApellidoField);
        panel.add(segundoApellidoLabel);
        panel.add(segundoApellidoField);
        panel.add(telefonoLabel);
        panel.add(telefonoField);


        add(panel, BorderLayout.CENTER);

        JLabel propietario = new JLabel("DIEGO RAMIREZ L");
        propietario.setHorizontalAlignment((SwingConstants.RIGHT));
        propietario.setVerticalAlignment(SwingConstants.TOP);
        propietario.setForeground(Color.GREEN);

        JPanel Panel = new JPanel();
        Panel.setLayout(new BorderLayout());
        Panel.add(propietario, BorderLayout.EAST);
        add(Panel, BorderLayout.NORTH);

        
        JPanel boton = new JPanel();
        boton.add(guardarButton);
        add(boton, BorderLayout.SOUTH);


        setVisible(true);

    }

    private void limpiarCampos(){
        ubicacionField.setText("");
        direccionField.setText("");
        emailField.setText("");
        nombreField.setText("");
        primerApellidoField.setText("");
        segundoApellidoField.setText("");
        telefonoField.setText("");


    }

    public static void main (String[]args) {
        SwingUtilities.invokeLater(() -> {
            new User();

        });
    }
}


        

