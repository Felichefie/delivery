import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Gui {

    public static void main(String[] args) {
        JFrame f_login;
        JLabel l_password, l_usuario, l_autenticacion, l_session;
        JTextField txt_password, txt_usuario;
        JButton btn_buscar, btn_cancelar, btn_dar_de_alta;

        f_login = new JFrame("GUI");
        f_login.setSize(600, 500);
        l_usuario = new JLabel("User");
        l_usuario.setBounds(20, 170, 180, 20);
        txt_usuario = new JTextField("freddy51@gmail.com");
        txt_usuario.setBounds(200, 170, 180, 20);

        l_password = new JLabel("Password");
        l_password.setBounds(20, 200, 180, 20);
        txt_password = new JTextField(
                "uFtut72wEYwhms4Gwtjfr5ys9UyJRhAfhdDtzeDsEOy1jmSJMYQc8K/g8vPu2LBf+RgMmBQqDUK64w2T35aEgGI0ACmKeWjw/vuWJAWXxug");
        txt_password.setBounds(200, 200, 180, 20);

        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(20, 360, 80, 20);
        btn_cancelar = new JButton("Cancelar");
        btn_cancelar.setBounds(150, 360, 80, 20);
        btn_dar_de_alta = new JButton("Autenticar");
        btn_dar_de_alta.setBounds(280, 360, 80, 20);

        l_autenticacion = new JLabel("");
        l_autenticacion.setBounds(20, 230, 380, 20);
        l_session = new JLabel("");
        l_session.setBounds(20, 260, 180, 20);

        f_login.add(btn_cancelar);
        f_login.add(btn_buscar);
        f_login.add(l_password);
        f_login.add(txt_password);
        f_login.add(txt_usuario);
        f_login.add(l_usuario);
        f_login.add(l_autenticacion);
        f_login.add(l_session);
        f_login.add(btn_dar_de_alta);

        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dbconnection dbconnection = new Dbconnection(
                        "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno",
                        "alumnoPrueba1");
                Connection conn = dbconnection.getConn();
                Response r = dbconnection.logAuth(txt_usuario.getText(), txt_password.getText(), conn);

            }
        });

        btn_dar_de_alta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = txt_password.getText();

                // longitud>=8, mayusculas, minúsculas, número y caracter especial $,%&_#
                if (t.length() < 8) {
                    l_autenticacion.setText(" el password no cumple con las longitud minima");
                    return;
                }
                int i;
                boolean mayusculas = false;
                boolean minúsculas = false, numeros = false, simbolos = false;// son banderas, y al terminar el for
                                                                              // todas tienen que ser verdaderas sino no
                                                                              // se cumple las politicas del password

                for (i = 0; i < t.length(); i++) {
                    if (t.charAt(i) >= 'A' && t.charAt(i) <= 'Z') {
                        mayusculas = true;
                    }
                    if (t.charAt(i) >= 'a' && t.charAt(i) <= 'z') {
                        minúsculas = true;
                    }
                    if (t.charAt(i) >= '0' && t.charAt(i) <= '9') {
                        numeros = true;
                    }
                    if (t.charAt(i) == '$' || t.charAt(i) == ',' || t.charAt(i) == '%' || t.charAt(i) == '&'
                            || t.charAt(i) == '_' || t.charAt(i) == '#' || t.charAt(i) == '*') {
                        simbolos = true;
                    }
                }

                if (!mayusculas && !minúsculas && !numeros && !simbolos) {
                    l_autenticacion.setText("el password no cumple con los tipos de caracteres");
                    return;
                }

                String psw_hash = BCrypt.hashpw(t, BCrypt.gensalt());
                System.out.println(psw_hash);

                Dbconnection dbconnection = new Dbconnection(
                        "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com", "alumno",
                        "alumnoPrueba1");
                Connection conn = dbconnection.getConn();
                User u1 = new User(0, 0, psw_hash, psw_hash);
                u1.setemail(txt_usuario.getText());
                u1.setUserName("Freddy");
                u1.setName("Alfredo");
                u1.setFirst_lastname("Pineda");
                u1.setFirst_lastname("Prado");
                u1.setBirthday("2003-05-01");
                u1.setPassword(psw_hash);
                dbconnection.insertNewUser(u1, psw_hash);

                try {
                    conn.close();
                } catch (SQLException q) {
                    q.printStackTrace();
                }

            }
        });

        f_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_login.setLayout(null);
        f_login.setVisible(true);
    }
}
