import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LogInPizza {
   
    public static void LogInPizza(){
        JFrame lp = new JFrame("LOGIN");
        lp.setSize(1000,600);
        lp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lp.setLocationRelativeTo(lp);
        lp.setLayout(new BorderLayout());
        lp.setResizable(false);

        JLabel la = new JLabel("INGRESE SUS DATOS");
        la.setForeground(Color.black);
        la.setHorizontalAlignment(SwingConstants.CENTER);
        la.setPreferredSize(new Dimension(1000,30));
        lp.add(la, BorderLayout.NORTH);


        JPanel panelLOgIn = new JPanel(new FlowLayout());

        panelLOgIn.setBackground(Color.white);
        panelLOgIn.setBounds(530,70,300,100);

        JLabel usuario = new JLabel("Usuario ");
        usuario.setForeground(Color.lightGray);
        JTextField tfUsuario = new JTextField(24);


        JLabel contrasena = new JLabel("Contrasena");
        contrasena.setForeground(Color.lightGray);
        JPasswordField tfContrasena = new JPasswordField(22);


        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(new Color(229,97,84));


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                
            }
        });

        panelLOgIn.add(usuario);
        panelLOgIn.add(tfUsuario);
        panelLOgIn.add(contrasena);
        panelLOgIn.add(tfContrasena);
        panelLOgIn.add(btnLogin);


        lp.add(panelLOgIn);

        ImageIcon imagenFonde = new ImageIcon("37831bbf0e27cdf2992cd8730b6bfcf6.jpg");
        JLabel LabelFonde = new JLabel(imagenFonde);
        LabelFonde.setBounds(100,30,500,500);
        lp.add(LabelFonde);
        
        JPanel panelPrincipal = new JPanel();
        Color ye1 = new Color(254,185,67);
        panelPrincipal.setBackground(ye1);
        panelPrincipal.setBounds(10, 10, 960, 530);

        lp.add(panelPrincipal);
        lp.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                 LogInPizza();
            }
    
        });
    
    }

}
