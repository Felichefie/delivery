import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class login {
    
    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        String email = "felix.jimenez@umich.mx";
        String password = "Mony123?";
        createGUI();
        System.out.println("LOGIN");
        
        //CONECTAR A LA BASE DE DATOS
        Dbconnection dbconnection = new Dbconnection(URL, user, pass); 
        Connection conn = dbconnection.getConn();
        Response r = dbconnection.LogAuth(email, password, conn);
        if(r.isStatus() == true){
            System.out.println("USUARIO ATENTIFICADO!");
            System.out.println("SESION" + r.getSesion());
        }else{
            System.out.println("USUARIO NO AUTENTIFICADO");
            System.out.println("SESION" + r.getSesion());
        };       
}
    //CREA LA GUI
    public static void createGUI(){
    JFrame window = new JFrame("INICIO DE SESION O REGISTRO");
    window.setSize(600, 600);
    Color bluee = new Color(227,252,255);
    Color blue1 = new Color(6,193,220);
    window.getContentPane().setBackground(bluee);
    window.setLayout(null); 

    JLabel etiqueta1 = new JLabel("HAGA CLICK PARA INICIAR SESION REGISTRARSE");
    etiqueta1.setBounds(30,50,400,100);
    //etiqueta1.setForeground(blue1); COLOR
    Font newE = new Font("Arial", Font.TYPE1_FONT, 16);
    etiqueta1.setFont(newE);

    JButton login = new JButton("LOGIN");
    JButton registro = new JButton("REGISTER");
    login.setBounds(130, 200, 200, 60);
    //login.setBackground(blue1);
    registro.setBounds(340, 200, 200, 60);
    //registro.setBackground(blue1);

    window.setVisible(true);
    window.add(login);
    window.add(registro);
    window.add(etiqueta1);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//ESCUCHA AL BOTON LOGIN 
    login.addActionListener((ActionListener) new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            window.dispose();
            showLoginForm();
           // String email = userna.getText();
            //tring password = new String(passwordText.getPassword());
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
    loginFrame.setSize(400, 400);
    Color bluee = new Color(227,252,255);
    loginFrame.getContentPane().setBackground(bluee);
    loginFrame.setLayout(null); 
    JButton cancel = new JButton("Cancel");
    JButton ingresar = new JButton("Ingresar");
    JLabel usern = new JLabel("Email: ");
    JLabel passn = new JLabel("Password: ");
    JTextField userna = new JTextField();
    JPasswordField passwordText = new JPasswordField(20);
    passwordText.setBounds(120,130,200,25);

    cancel.setBounds(150,250,80,20);
    ingresar.setBounds(240,250,80,20);
    usern.setBounds(30,100,80,20);
    passn.setBounds(30, 130, 80, 20);
    userna.setBounds(120, 100, 200, 20);

    loginFrame.setVisible(true);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.add(cancel);
    loginFrame.add(ingresar);
    loginFrame.add(usern);
    loginFrame.add(passn);
    loginFrame.add(userna);
    loginFrame.add(passwordText);

    //ESCUCHA AL BOTON CANCELAR
    cancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            userna.setText(" ");
            passwordText.setText(" ");
        }
        
    });

    //INGRESAR
    ingresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            String email = userna.getText();
            String password = new String(passwordText.getPassword());

            //VALIDAR CONTRASENA
            if(validatePassword(password)){
                try {
                    if(authenticate(email, password)){
                        JOptionPane.showMessageDialog(null, "AUTENTICACION EXITOSA");
                    }else{
                        JOptionPane.showMessageDialog(null, "AUTENTICACION FALLIDA ");
                    }
                } catch (HeadlessException | SQLException e1) {
                   e1.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "LA CONTRASENA NO CUMPLE CON LOS REQUISITOS");
            }
        }
    });
}

//VENTANA DE REGISTRO
public static void showRegisterForm(){
    JFrame registerFrame = new JFrame("REGISTRO");
    registerFrame.setLayout(null);
    registerFrame.setSize(600,500);
    Color bluee = new Color(227,252,255);
    registerFrame.getContentPane().setBackground(bluee);
    JLabel etiqueta1 = new JLabel("INGRESE SUS DATOS ;) ");
    Font newE = new Font("Arial", Font.TYPE1_FONT, 16);
    etiqueta1.setFont(newE);
    etiqueta1.setBounds(40,10,300,20);
    JLabel firstName = new JLabel("First Name:");
    JLabel lastName = new JLabel("Last Name: ");
    JLabel userName = new JLabel("Username: ");
    JLabel password = new JLabel("Password: ");
    JLabel password2 = new JLabel("Confirm Password: ");
    JLabel birthDate = new JLabel("BirthDate: ");
    JLabel address = new JLabel("Address: ");
    JTextField firstname = new JTextField();
    JTextField lastname = new JTextField();
    JTextField username = new JTextField();
    JTextField passworD = new JTextField();
    JTextField passworD2 = new JTextField();
    JTextField birthdate = new JTextField();
    JTextField addresS = new JTextField();
    JButton cancel = new JButton("Cancel");
    JButton ingresar = new JButton("Ingresar");

    firstName.setBounds(30,50,100,20);
    lastName.setBounds(30,80,100,20);
    userName.setBounds(30,110,100,20);
    password.setBounds(30,140,100,20);
    password2.setBounds(30,170,200,20);
    birthDate.setBounds(30,200,150,20);
    address.setBounds(30,230,200,20);

    firstname.setBounds(150,50,300,20);
    lastname.setBounds(150,80,300,20);
    username.setBounds(150,110,300,20);
    passworD.setBounds(150,140,300,20);
    passworD2.setBounds(150,170,300,20);
    birthdate.setBounds(150,200,300,20);
    addresS.setBounds(150,230,300,20);
    cancel.setBounds(300,400,100,30);
    ingresar.setBounds(420,400,100,30);

    registerFrame.add(etiqueta1);
    registerFrame.add(firstName);
    registerFrame.add(userName);
    registerFrame.add(lastName);
    registerFrame.add(password);
    registerFrame.add(password2);
    registerFrame.add(birthDate);
    registerFrame.add(address);

    registerFrame.add(firstname);
    registerFrame.add(lastname);
    registerFrame.add(username);
    registerFrame.add(passworD);
    registerFrame.add(passworD2);
    registerFrame.add(birthdate);
    registerFrame.add(addresS);
    registerFrame.add(cancel);
    registerFrame.add(ingresar);

    registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registerFrame.setVisible(true);
}

private static boolean authenticate(String email, String password) throws SQLException{
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String USER = "alumno";
        String PASSWORD = "alumnoPrueba1";
        email = "felix.jimenez@umich.mx";
        password = "Mony123?";
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String query = "SELECT * FROM progra2.users u WHERE u.email = ? AND u.password = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(8, email);
                preparedStatement.setString(11, password);


                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){
                    }else{
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return false;
}
private static boolean validatePassword(String password){
    //longitud>=8 mayusculas, minúsculas, número y caracter especial $,%&_#
    if(password.length() < 8){
        return false;
    }
    if(!password.matches(".*[A-Z].*")){
        return false;
    }
    if (!password.matches(".*[a-z].*")) {
        return false;
    }
    if (!password.matches(".*\\d.*")) {
        return false;
    }
    if (!password.matches(".*[!@#$%^&*()-+=?].*")) {
        return false;
    }
    return true;
}

}
