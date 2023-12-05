import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class User extends JPanel{
    private JLabel lbl_tipo, lbl_nom, lbl_userName, lbl_first, lbl_second, lbl_name, lbl_birth, lbl_email, lbl_phone;
    private JButton btn_cancel, btn_register, btn_direccion, btn_buscar;
    private JTextField txt_userName, txt_first, txt_second, txt_name, txt_birth, txt_email, txt_phone;
    private Dbconnection dbConn;

    User() {
        setLayout(null);


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


        add(lbl_tipo);
        add(lbl_nom);
        add(lbl_userName);
        add(lbl_first);
        add(lbl_second);
        add(lbl_name);
        add(lbl_birth);
        add(lbl_email);
        add(lbl_phone);
        add(txt_userName);
        add(txt_first);
        add(txt_second);
        add(txt_name);
        add(txt_birth);
        add(txt_email);
        add(txt_phone);
        add(btn_register);
        add(btn_cancel);
        add(btn_direccion);
        add(btn_buscar);
    
        btn_buscar.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {

                String Email = txt_email.getText();
                int Phone = Integer.parseInt(txt_phone.getText());

                Userexample u = dbConn.getUser(Email, Phone);
        
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
     public void show() {
        if(!isVisible()){
        setVisible(true);
    }
}

    void close(){
    }
    
}
