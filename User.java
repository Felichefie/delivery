import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class User {
    private JLabel lbl_tipo, lbl_nom, lbl_userName, lbl_first, lbl_second, lbl_name, lbl_birth, lbl_email, lbl_phone;
    private JButton btn_cancel, btn_register, btn_direccion, btn_buscar;
    private JFrame frm_User;
    private JTextField txt_userName, txt_first, txt_second, txt_name, txt_birth, txt_email, txt_phone;
    private Dbconnection dbConn;

    User() {
        frm_User = new JFrame();


        btn_cancel = new JButton("CANCEL");
        btn_cancel.setBounds(10, 600, 100, 50);
        btn_register = new JButton("ACCEPT");
        btn_register.setBounds(145, 600, 100, 50);
        btn_direccion = new JButton("ADDRESS");
        btn_direccion.setBounds(275, 600, 100, 50);
        btn_buscar = new JButton("SEARCH");
        btn_buscar.setBounds(400, 600, 100, 50);


        lbl_tipo = new JLabel("INTERFAZ USUARIO.");
        lbl_tipo.setBounds(0,0,300,30);
        lbl_nom = new JLabel("Hernandez Marin Maria Itzel.");
        lbl_nom.setBounds(150,645,300,30);
        lbl_userName = new JLabel("USER NAME:");
        lbl_userName.setBounds(140,20,300,30);
        lbl_userName.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_first = new JLabel("FIRST LASTNAME:");
        lbl_first.setBounds(140,90,300,30);
        lbl_first.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_second = new JLabel("SECOND LASTNAME:");
        lbl_second.setBounds(140,160,300,30);
        lbl_second.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_name = new JLabel("NAME:");
        lbl_name.setBounds(140,230,300,30);
        lbl_name.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_birth = new JLabel("BIRTHDAY:");
        lbl_birth.setBounds(140,300,300,30);
        lbl_birth.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_email = new JLabel("EMAIL:");
        lbl_email.setBounds(140,370,300,30);
        lbl_email.setFont(new Font("Impact", Font.PLAIN, 14));
        lbl_phone = new JLabel("PHONE NUMBER:");
        lbl_phone.setBounds(140,440,300,30);
        lbl_phone.setFont(new Font("Impact", Font.PLAIN, 14));
        

        txt_userName = new JTextField();
        txt_userName.setBounds(140, 50, 250, 25);
        txt_first = new JTextField();
        txt_first.setBounds(140, 120, 250, 25);
        txt_second = new JTextField();
        txt_second.setBounds(140, 190, 250, 25);
        txt_name = new JTextField();
        txt_name.setBounds(140, 260, 250, 25);
        txt_birth = new JTextField();
        txt_birth.setBounds(140, 330, 250, 25);
        txt_email = new JTextField();
        txt_email.setBounds(140, 400, 250, 25);
        txt_phone = new JTextField();
        txt_phone.setBounds(140, 470, 250, 25);


        frm_User.add(lbl_tipo);
        frm_User.add(lbl_nom);
        frm_User.add(lbl_userName);
        frm_User.add(lbl_first);
        frm_User.add(lbl_second);
        frm_User.add(lbl_name);
        frm_User.add(lbl_birth);
        frm_User.add(lbl_email);
        frm_User.add(lbl_phone);
        frm_User.add(txt_userName);
        frm_User.add(txt_first);
        frm_User.add(txt_second);
        frm_User.add(txt_name);
        frm_User.add(txt_birth);
        frm_User.add(txt_email);
        frm_User.add(txt_phone);
        frm_User.add(btn_register);
        frm_User.add(btn_cancel);
        frm_User.add(btn_direccion);
        frm_User.add(btn_buscar);
       
                
        frm_User.setSize(400, 700);
        frm_User.setLayout(null);
        frm_User.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_buscar.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {

                String Email = txt_email.getText().toString();
                String Phone = txt_phone.getText().toString();

                Usuario u = dbConn.getUser(Email, Phone);
        
                if(u.getId() == 0){
                    JOptionPane.showMessageDialog(btn_buscar,"DATOS DE USUARIO INGRESADOS NO LOCALIZADOS.");
                    System.out.println("NO EXISTE.");
        
                }else{

                    JOptionPane.showMessageDialog(btn_buscar,"DATOS DE USUARIO YA REGISTRADO ENCONTRADOS.");
                    txt_userName.setText(u.getUserName());
                    txt_first.setText(u.getFirst_lastname());
                    txt_second.setText( u.getSecond_lastname());
                    txt_name.setText(u.getName());
                    txt_birth.setText(u.getBirthday());
                    txt_email.setText(u.getEmail());
                    txt_phone.setText(u.getPhone_number());

                    Address a = dbConn.getAddress(u.getId());

                    if(a.getId() == 0){
                        JOptionPane.showMessageDialog(btn_buscar,"ESTE USUARIO NO HA AGREGADO ALGUNA DIRECCIÓN.");
                        System.out.println("USUARIO SIN DIRECCIONES.");
                        // dbConn.InsertNewAddress(u);

                    }else{

                        System.out.println(a.getStreet());
                        System.out.println(a.getNumber());
                        Dir dir = new Dir();
                        JOptionPane.showMessageDialog(btn_buscar,"ESTE USUARIO HA AGREGADO DIRECCIONES.");
                        dir.mostrar(a.getStreet(), a.getNumber(), a.getNumber_two(), a.getNeighborhood(), a.getCity(), a.getState(), a.getCountry(), a.getPostal_code());
                        dir.show();

            
                    }
                }

            }
        });

        btn_register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //dbConn.InsertNewUser(u);
                JOptionPane.showMessageDialog(btn_register,"DATOS DE NUEVO USUARIO INGRESADOS DE MANERA CORRECTA");
            }
        });

        btn_cancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txt_userName.setText("");
                txt_first.setText("");
                txt_second.setText("");
                txt_name.setText("");
                txt_birth.setText("");
                txt_email.setText("");
                txt_phone.setText("");
            }
        });

        btn_direccion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Dir dir = new Dir();
                dir.show();
            }
        });
    }

    public void setDbConn(Dbconnection dbConn) {
        this.dbConn = dbConn;
    }

    String EmailPhone(){
        String correo = txt_email.getText().toString();
        int phone = Integer.parseInt(txt_phone.getText());
        return correo + phone;
    }
    
    void show() {
        frm_User.setVisible(true);
    }

    void close(){
    }
    
}
