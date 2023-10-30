import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionMain {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbConn = new Dbconnection(URL, user, pass);

        JFrame frame = new JFrame("Consulta de Usuario");
        JLabel label = new JLabel("Ingrese un email o número de teléfono:");
        JTextField inputField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                User userResult = dbConn.getUser(input, input);

                if (userResult != null) {
                    resultArea.setText("Usuario encontrado:\n" +
                            "ID: " + userResult.getId() + "\n" +
                            "Nombre de usuario: " + userResult.getUserName());

                    Address userAddress = dbConn.getAddress(userResult.getId());
                    if (userAddress != null) {
                        resultArea.append("\n\nDirección encontrada:\n" +
                                "ID de usuario: " + userAddress.getId_user() + "\n" +
                                "Calle: " + userAddress.getStreet() + "\n" +
                                "Número: " + userAddress.getNumber());
                    } else {
                        resultArea.append("\n\nDirección no encontrada para este usuario.");
                    }
                } else {
                    resultArea.setText("Usuario no encontrado.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(searchButton);

        frame.setLayout(new GridLayout(2, 1));

        frame.add(panel);
        frame.add(resultArea);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
