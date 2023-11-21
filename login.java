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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        String email = "felix.jimenez@umich.mx";
        String password = "Mony123?";
        createGUI();



//CONECTAR A LA BASE DE DATOS
        Dbconnection dbconnection = new Dbconnection(URL, user, pass);
        Connection conn = dbconnection.getConn();
        Response r = dbconnection.LogAuth(email, password);


        if(r.isStatus() == true){
            System.out.println("USUARIO  AUTENTIFICADO! ");
            System.out.println("SESION " + r.getSesion());

        }else{

            System.out.println("USUARIO NO AUTENTIFICADO ");
            System.out.println("SESION " + r.getSesion());

        };
        
    }


    //CREATE GUI
    public static void createGUI(){
        JFrame window = new JFrame("INICIO DE SESION O REGISTRO ");
        window.setSize(600,600);
        window.setVisible(true);
        Color bluee = new Color(227,252,255);
        window.getContentPane().setBackground(bluee);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//etiqueta
        JLabel etiqueta1 = new JLabel("HAGA CLICK PARA INICIAR SESION REGISTRARSE");
        etiqueta1.setBounds(30,50,400,100);
//fuente
        Font newE = new Font("Arial", Font.TYPE1_FONT, 16);
        etiqueta1.setFont(newE);
//botones
        JButton InicioSesion = new JButton("iniciar sesion");
        JButton registro = new JButton("Registrar");
        InicioSesion.setBounds(130, 200, 200, 60);
        registro.setBounds(340, 200, 200, 60);
//anade
        window.add(InicioSesion);
        window.add(registro);
        window.add(etiqueta1);

//escucha boton INICIO SESION
        InicioSesion.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                window.dispose();
                showInicioSesion();
            }
        });
//escucha al boton REGISTRO
        registro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                window.dispose();
                showRegistro();

            }
        });
    }


//ventana INICION DE SESION
        public static void showInicioSesion(){
            JFrame InicioSesionFrame = new JFrame("INICIO DE SESION");
            InicioSesionFrame.setSize(400, 400);
            Color bluee = new Color(227,252,255);
            InicioSesionFrame.getContentPane().setBackground(bluee);
            InicioSesionFrame.setLayout(null); 

            JButton cancelar = new JButton("Cancelar ");
            JButton ingresar = new JButton("Ingresar");
            JLabel Etiquetaemail = new JLabel("Email: ");
            JLabel EtiquetaPassword = new JLabel("Password: ");
            JTextField emailT = new JTextField();
            JPasswordField passwordText = new JPasswordField(20);
            

            cancelar.setBounds(150,250,100,20);
            ingresar.setBounds(240,250,100,20);
            Etiquetaemail.setBounds(30,100,80,20);
            EtiquetaPassword.setBounds(30, 130, 80, 20);
            emailT.setBounds(120, 100, 200, 20);
            passwordText.setBounds(120,130,200,25);

            InicioSesionFrame.setVisible(true);
            InicioSesionFrame.add(cancelar);
            InicioSesionFrame.add(ingresar);
            InicioSesionFrame.add(Etiquetaemail);
            InicioSesionFrame.add(EtiquetaPassword);
            InicioSesionFrame.add(emailT);
            InicioSesionFrame.add(passwordText);

//ESCUCHA AL BOTON CANCELAR
    cancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            emailT.setText(" ");
            passwordText.setText(" ");
        }
        
    });
//escucha al boton ingresar
    ingresar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            String email = emailT.getText();
            String password = new String(passwordText.getPassword());

            //VALIDAR CONTRASENA
            if(validatePassword(password)){
                try {
                    if(authenticate(email, password)){
                        JOptionPane.showMessageDialog(null, "AUTENTICACION EXITOSA");
                    }else{
                        JOptionPane.showMessageDialog(null, "AUTENTICACION FALLIDA ");
                    }
                } catch (HeadlessException e1) {
                   e1.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "LA CONTRASENA NO CUMPLE CON LOS REQUISITOS");
            }
        }
    });
}

//ventana de REGISTRO
    public static void showRegistro(){
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






//Autentifica contrasena
    private static boolean authenticate(String email, String password){
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String USER = "alumno";
        String PASSWORD = "alumnoPrueba1";
        email = "felix.jimenez@umich.mx";
        password = "Mony123?";


        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String query =  "SELECT * FROM progra2.users u WHERE u.email = ? AND u.password = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setString(8, email);
                preparedStatement.setString(11, password);
                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    if(resultSet.next()){           
                    }else{
                    }
                }
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    return false;
    }

//Condiciones para la contrasena 
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