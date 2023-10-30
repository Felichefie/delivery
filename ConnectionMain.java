import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
       // Conexion con = new Conexion();
        //String txtJson = con.sendGet();

//CREAR UN OBJETO SERIALIZADO

    User u = new User(1, 0, "TituloTexto", "Cuerpo");
    String resJson;
    Serializar serial = new Serializar();
    resJson = serial.serialUser(u);
    System.out.print(resJson);
    serial.UserAdd(u);
    resJson = serial.listaJson();
    System.out.print(resJson);

    User u1 = new User(1, 1, "OTRO USUSARIO", "CUAERPO 2");
    resJson = serial.serialUser(u1);
    serial.UserAdd(u1);
    System.out.println(resJson);

        
       
    }
}

 
     //CREA ITERFAZ
    /*JFrame ventana = new JFrame("USUARIOS REGISTRADOS");
    ventana.setLayout(null);
    JLabel etiqueta = new JLabel(".....INGRESE SUS DATOS.....");
    etiqueta.setBounds(180,10,300,20);
    ventana.add(etiqueta);
    
    JButton buscarDatos = new JButton("Buscar Datos");
    buscarDatos.setBounds(250, 250, 200,20);
    ventana.add(buscarDatos);
    
    //CREA CUADRO DE TEXTO ID
    JLabel id = new JLabel("ID: ");
    id.setBounds(10, 60, 100, 20);
    JTextField idT = new JTextField("  ");
    idT.setBounds(250,60,200,20);
    ventana.add(id);
    ventana.add(idT);

    //CREA CUADRO DE TEXTO USER_NAME
    JLabel user_name = new JLabel("USER NAME: ");
    user_name.setBounds(10,85,200,20);
    JTextField user_nameT = new JTextField(" ");
    user_nameT.setBounds(250, 85, 200, 20);
    ventana.add(user_name);
    ventana.add(user_nameT);

    //CREA CUADRO DE TEXTO FIRST_LASTNAME
    JLabel first_lastName = new JLabel("FIRST LAST NAME: ");
    first_lastName.setBounds(10,110,200,20);
    JTextField first_lastNameT = new JTextField(" ");
    first_lastNameT.setBounds(250,110,200,20);
    ventana.add(first_lastName);
    ventana.add(first_lastNameT);

    //CREA CUADRO DE TEXTO SECOND_LASTNAME
    JLabel second_lastName = new JLabel("SECOND LAST NAME: ");
    second_lastName.setBounds(10,135,200,20);
    JTextField second_lastNameT = new JTextField(" ");
    second_lastNameT.setBounds(250,135,200,20);
    ventana.add(second_lastName);
    ventana.add(second_lastNameT);

    //CREA CUADRO DE TEXTO BIRTHDAY
    JLabel birthday = new JLabel("BIRTHDAY: ");
    birthday.setBounds(10,160,200,20);
    JTextField birthdayT = new JTextField(" ");
    birthdayT.setBounds(250,160,200,20);
    ventana.add(birthday);
    ventana.add(birthdayT);

    //CREA CUADRO DE TEXTO EMAIL
    JLabel email = new JLabel("EMAIL: ");
    email.setBounds(10,185,200,20);
    JTextField emailT = new JTextField(" ");
    emailT.setBounds(250,185,200,20);
    ventana.add(email);
    ventana.add(emailT);

    //CREA CUADRO DE TEXTO PHONE_NUMBER
    JLabel phone = new JLabel("PHONE NUMBER: ");
    phone.setBounds(10,210,200,20);
    JTextField phoneT = new JTextField(" ");
    phoneT.setBounds(250,210,200,20);
    ventana.add(phone);
    ventana.add(phoneT);

    ventana.setSize(500,500);
    ventana.setVisible(true); */