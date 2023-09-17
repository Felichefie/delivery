import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class usuario {
    private JFrame frame;
    private JLabel nombreLabel, paternoLabel, maternoLabel, telefonoLabel, correoLabel, direccionLabel, ubicacionLabel, minombreLabel;
    private JTextField nombreField, paternoField, maternoField, telefonoField, correoField, direccionField, ubicacionField;
    private JButton aceptarButton, cerrarButton; 

    usuario() {
        frame = new JFrame("Interfaz de usuario");
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(220, 198, 224));

        minombreLabel = new JLabel("Francisco Duran");
        minombreLabel.setBounds(200, 10, 180, 25);
        minombreLabel.setHorizontalAlignment(JLabel.RIGHT);

        nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 50, 80, 25);
        nombreField = new JTextField();
        nombreField.setBounds(150, 50, 150, 25);
        nombreField.setHorizontalAlignment(JTextField.LEFT);

        paternoLabel = new JLabel("Apellido paterno:");
        paternoLabel.setBounds(10, 80, 150, 25);
        paternoField = new JTextField();
        paternoField.setBounds(150, 80, 150, 25);
        paternoField.setHorizontalAlignment(JTextField.LEFT);

        maternoLabel = new JLabel("Apellido materno:");
        maternoLabel.setBounds(10, 110, 150, 25);
        maternoField = new JTextField();
        maternoField.setBounds(150, 110, 150, 25);
        maternoField.setHorizontalAlignment(JTextField.LEFT);

        telefonoLabel = new JLabel("Telefono:");
        telefonoLabel.setBounds(10, 140, 150, 25);
        telefonoField = new JTextField();
        telefonoField.setBounds(150, 140, 150, 25);
        telefonoField.setHorizontalAlignment(JTextField.LEFT);

        correoLabel = new JLabel("Correo electronico:");
        correoLabel.setBounds(10, 170, 150, 25);
        correoField = new JTextField();
        correoField.setBounds(150, 170, 150, 25);
        correoField.setHorizontalAlignment(JTextField.LEFT);

        direccionLabel = new JLabel("Direccion:");
        direccionLabel.setBounds(10, 200, 150, 25);
        direccionField = new JTextField();
        direccionField.setBounds(150, 200, 150, 25);
        direccionField.setHorizontalAlignment(JTextField.LEFT);

        ubicacionLabel = new JLabel("Ubicacion:");
        ubicacionLabel.setBounds(10, 230, 150, 25);
        ubicacionField = new JTextField();
        ubicacionField.setBounds(150, 230, 150, 25);
        ubicacionField.setHorizontalAlignment(JTextField.LEFT);

        aceptarButton = new JButton("Aceptar");
        aceptarButton.setBounds(100, 270, 100, 30);

        cerrarButton = new JButton("Cerrar");
        cerrarButton.setBounds(220, 270, 100, 30);

        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
            }
        });

        frame.add(minombreLabel);
        frame.add(nombreLabel);
        frame.add(nombreField);
        frame.add(paternoLabel);
        frame.add(paternoField);
        frame.add(maternoLabel);
        frame.add(maternoField);
        frame.add(telefonoLabel);
        frame.add(telefonoField);
        frame.add(correoLabel);
        frame.add(correoField);
        frame.add(direccionLabel);
        frame.add(direccionField);
        frame.add(ubicacionLabel);
        frame.add(ubicacionField);
        frame.add(aceptarButton);
        frame.add(cerrarButton);

        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new usuario();
    }
}
