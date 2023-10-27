import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.*;

public class User {
    private JLabel lbl_userName, lbl_first, lbl_second, lbl_name, lbl_birth, lbl_email, lbl_phone;
    private JButton btn_cancel, btn_register, btn_direccion, btn_buscar;
    private JFrame frm_User;
    private JTextField txt_userName, txt_first, txt_second, txt_name, txt_birth, txt_email, txt_phone;
    private Dbconnection dbConn;

    User() {
        frm_User = new JFrame();


        btn_cancel = new JButton("Cancelar");
        btn_cancel.setBounds(10, 600, 100, 50);
        btn_register = new JButton("Aceptar");
        btn_register.setBounds(275, 600, 100, 50);
        btn_direccion = new JButton("Direccion");
        btn_direccion.setBounds(145, 600, 100, 50);
        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(145, 530, 100, 50);


        lbl_userName = new JLabel("Nombre de usuario:");
        lbl_userName.setBounds(10,20,300,30);
        lbl_userName.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_first = new JLabel("Primer apellido:");
        lbl_first.setBounds(10,90,300,30);
        lbl_first.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_second = new JLabel("Segundo apellido:");
        lbl_second.setBounds(10,160,300,30);
        lbl_second.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_name = new JLabel("Nombre:");
        lbl_name.setBounds(10,230,300,30);
        lbl_name.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_birth = new JLabel("Fecha de nacimiento:");
        lbl_birth.setBounds(10,300,300,30);
        lbl_birth.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_email = new JLabel("Email:");
        lbl_email.setBounds(10,370,300,30);
        lbl_email.setFont(new Font("Arial", Font.PLAIN, 18));
        lbl_phone = new JLabel("Número de telefono:");
        lbl_phone.setBounds(10,440,300,30);
        lbl_phone.setFont(new Font("Arial", Font.PLAIN, 18));
        

        txt_userName = new JTextField();
        txt_userName.setBounds(10, 50, 250, 25);
        txt_first = new JTextField();
        txt_first.setBounds(10, 120, 250, 25);
        txt_second = new JTextField();
        txt_second.setBounds(10, 190, 250, 25);
        txt_name = new JTextField();
        txt_name.setBounds(10, 260, 250, 25);
        txt_birth = new JTextField();
        txt_birth.setBounds(10, 330, 250, 25);
        txt_email = new JTextField();
        txt_email.setBounds(10, 400, 250, 25);
        txt_phone = new JTextField();
        txt_phone.setBounds(10, 470, 250, 25);


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

                Userexample u = dbConn.getUser(Email, Phone);
        
                if(u.getUserId() == 0){
                    System.out.println("NO EXISTE");
        
                }else{

                    JOptionPane.showMessageDialog(btn_buscar,"Usuario encontrado");
                    txt_userName.setText(u.getUserName());
                    txt_first.setText(u.getFirst_lastname());
                    txt_second.setText( u.getSecond_lastname());
                    txt_name.setText(u.getName());
                    txt_birth.setText(u.getBirthday());
                    txt_email.setText(u.getEmail());
                    txt_phone.setText(u.getPhone_number());

                    Address a = dbConn.getAddress(u.getUserId());

                    if(a.getId() == 0){
                        JOptionPane.showMessageDialog(btn_buscar,"Usuario sin direcciones");
                        System.out.println("El usuario no tiene direcciones");
                        // dbConn.InsertNewAddress(u);

                    }else{

                        System.out.println(a.getStreet());
                        System.out.println(a.getNumber());
                        Direccion dir = new Direccion();
                        JOptionPane.showMessageDialog(btn_buscar,"Encontradas direcciones del usuario");
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
                JOptionPane.showMessageDialog(btn_register,"Datos Ingresados");
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
                Direccion dir = new Direccion();
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
