import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class ListenerButton {
    public static void main(String[] args) {
        createGUI();
        
    }

public static void createGUI(){
    JFrame window = new JFrame("INICIO DE SESION O REGISTRO");
    window.setSize(600, 600);
    Color colorRosa = new Color(255, 175,175);
    Color colorCafe = new Color(169,135,127);
    window.getContentPane().setBackground(colorRosa);
    window.setLayout(null); 

    JButton login = new JButton("LOGIN");
    JButton registro = new JButton("REGISTER");
    login.setBounds(130, 200, 200, 60);
    login.setBackground(colorCafe);
    registro.setBounds(340, 200, 200, 60);
    registro.setBackground(colorCafe);

    window.setVisible(true);
    window.add(login);
    window.add(registro);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//ESCUCHA AL BOTON LOGIN 
    login.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            window.dispose();
            showLoginForm();
        }
    });

//ESCUCHA AL BOTON DE REGISTRO
    registro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            window.dispose();
            showRegisterForm();
        }
    });

}
// MUESTRA LA VENTANA DE INICIAR SESION
public static void showLoginForm(){
        JFrame loginFrame = new JFrame("INICIO DE SESION");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }
public static void showRegisterForm(){
    JFrame registerForm = new JFrame("REGISTRO");
    registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registerForm.pack();
    registerForm.setVisible(true);
}

}