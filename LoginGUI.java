
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI {

    public static void main(String[] args) {
        createGUI(); 
    }

    public LoginGUI() {
    }

    public static void createGUI() {
        JFrame Window  = new JFrame("Inicio de sesion o Registro");
       
        Window.setLayout(null);
        Window.setSize(600,400);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel etiqueta1 = new JLabel("Haga click para iniciar sesion o registrarse");
        etiqueta1.setBounds(40,40,260,40);

        JButton btnInicio = new JButton("INICIAR SESION");
        btnInicio.setBounds(60,150,200,40);

        JButton btnRegistro = new JButton("REGISTRARSE ");
        btnRegistro.setBounds(310, 150, 200, 40);

        Window.add(btnInicio);
        Window.add(btnRegistro);
        Window.add(etiqueta1);
        Window.setVisible(true);


//boton INICIAR SESION
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Window.dispose();
                showInicioSesion();
                }
        });
//boton REGISTRARSE
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Window.dispose();
                showRegistro();
                }
        });

       
    }

    public static void showRegistro(){
        JFrame Registrar = new JFrame("REGISTRAR");
        Registrar.setVisible(true);
        Registrar.setSize(500, 500);
        Registrar.setLayout(null);
        Registrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        JLabel usuario1 = new JLabel("Usuario: ");
        usuario1.setBounds(30,100,100,20);
        JLabel contrasena1 = new JLabel("Contrasena: ");
        contrasena1.setBounds(30,150,100,20);
      
        JTextField txt_UsuarioRegistro = new JTextField();
        txt_UsuarioRegistro.setBounds(120,100,190,30);
        JPasswordField txt_ContraseñaRegistro = new JPasswordField();
        txt_ContraseñaRegistro.setBounds(150,150,190,30);

        JButton Btn_Registro = new JButton("Registrarse");
        Btn_Registro.setBounds(200,200,200,40);

        Btn_Registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//L PARA REGISTRARSE
                char[] password = ((JPasswordField) txt_ContraseñaRegistro).getPassword();
                String contraseña = new String(password);
                if (validarContraseña(password)) {
                    JOptionPane.showMessageDialog(null, "Contraseña válida: " + contraseña);

                    char[] password2 = ((JPasswordField) txt_ContraseñaRegistro).getPassword();
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
    

        Registrar.add(usuario1);
        Registrar.add(contrasena1);
        Registrar.add(txt_UsuarioRegistro);        
        Registrar.add(txt_ContraseñaRegistro);
        Registrar.add(Btn_Registro);
    }


    public static void showInicioSesion(){
        JFrame Iniciar = new JFrame("Iniciar SESION");
        Iniciar.setVisible(true);
        Iniciar.setSize(400,400);
        Iniciar.setLayout(null);
        Iniciar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //etiqueta usuario y contrasena
        JLabel usuario = new JLabel("Usuario ");
        usuario.setBounds(60,50,100,20);

        JLabel contrasena = new JLabel("Contrasena");
        contrasena.setBounds(60,120,100,20);

        JTextField tfUsuario = new JTextField();
        tfUsuario.setBounds(180,50,190,30);
        
        JPasswordField tPContraseña = new JPasswordField();
        tPContraseña.setBounds(180,120,190,30);
       

        
        JButton Btn_Login = new JButton("Iniciar Sesión");
        Btn_Login.setBounds(100,200,200,40);
        Btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí va la lógica de inicio de sesión
                String usuario = tfUsuario.getText();
                char[] password = tPContraseña.getPassword();
                String contraseña = new String(password);
                 
                Login login = new Login(usuario, contraseña);

                if(login.inicioSesion()){
                    JOptionPane.showMessageDialog(null, "Se ha iniciado sesion EXITOSAMENTE");
                }else{
                    JOptionPane.showMessageDialog(null, "NO SE HA PODIDO INICIAR SESION");
                }

            }
        });

        Iniciar.add(usuario);
        Iniciar.add(contrasena);
        Iniciar.add(tfUsuario);
        Iniciar.add(tPContraseña);
        Iniciar.add(Btn_Login);

    }


    private static boolean validarContraseña(char[] contraseña) {
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
        
        if (!contraseñaStr.matches(".*[$,%&_#?].*")) {
            return false;
        }
        
        return true;
    }

}
