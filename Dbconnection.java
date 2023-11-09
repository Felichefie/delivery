import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.lang.model.util.ElementScanner6;



public class Dbconnection{

    static Connection conn= null;
    public static void main (String [] args) {
    
    //ResultSet rset;

    String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    String user = "alumno";
    String password ="alumnoPrueba1";
    String email = "1578947d@umich.mx";
    String phone = "4432286692";
    int idUser = 1;
    String street = "Nicolas Leon";
    int number = 109;
    Dbconnection dbConn = new Dbconnection(URL, user, password);

    //System.out.println("Conectando a la base...");
    
    JFrame ventana = new JFrame("Usuarios Registrados");
    ventana.setLayout(null);
    JLabel etiqueta = new JLabel("...Ingresa sus datos...");
    etiqueta.setBounds(180, 10, 300, 20);
    ventana.add(etiqueta);

    JButton buscarDatos = new JButton("Buscar Datos");
    buscarDatos.setBounds(250, 250, 200, 20);
    ventana.add(buscarDatos);
    JTextArea ResultArea = new JTextArea(10,20);
    ResultArea.setEditable(false);
    ventana.add(ResultArea);
    JTextField inputText = new JTextField(20);

    buscarDatos.addActionListener(new ActionListener() {
        
        @Override

        public void actionPerformed(ActionListener e) {

            String input = inputText.getText();
            UserExample userResult = dbConn.getUser(input, input);
            if(userResult != null){
                System.out.println("Usuario no ha sido encontrado");
                System.out.println("ID" + userResult.getId());
                System.out.println("nombre del usuario" + userResult.getUsername());
                Address UserAddress = dbConn.getAddress(idUser, street, number);

                if(UserAddress != null){
                    System.out.println("Direccion no ha sido encontrada.");
                    System.out.println("ID"+ UserAddress.setStreet());
                }
            }

        }

    });

    JLabel id = new JLabel("ID:");
    id.setBounds(10, 60, 100, 20);
    JTextField idT = new JTextField("  ");
    idT.setBounds(250,60,200,20);
    ventana.add(id);
    ventana.add(idT);

    JLabel user_names = new JLabel("USER NAME: ");
    user_names.setBounds(10, 85, 200, 20);
    JTextField user_nameT = new JTextField("  ");
    user_nameT.setBounds(250, 85, 200, 20);
    ventana.add(user_names);
    ventana.add(user_nameT);

    JLabel first_lastName = new JLabel("FIRST LAST NAME: ");
    first_lastName.setBounds(10, 110, 200, 20);
    JTextField first_lastNameT = new JTextField("  ");
    first_lastNameT.setBounds(250, 110, 200, 20);
    ventana.add(first_lastName);
    ventana.add(first_lastNameT);

    JLabel second_lastName = new JLabel("SECOND LAST NAME: ");
    second_lastName.setBounds(10, 135, 200, 20);
    JTextField second_lastNameT = new JTextField("  ");
    second_lastNameT.setBounds(250, 135, 200, 20);
    ventana.add(second_lastName);
    ventana.add(second_lastNameT);

    JLabel birthday = new JLabel("BIRTHDAY: ");
    birthday.setBounds(10,160,200,20);
    JTextField birthdayT = new JTextField(" ");
    birthdayT.setBounds(250,160,200,20);
    ventana.add(birthday);
    ventana.add(birthdayT);

    JLabel emails = new JLabel("EMAIL: ");
    emails.setBounds(10,185,200,20);
    JTextField emailT = new JTextField(" ");
    emailT.setBounds(250,185,200,20);
    ventana.add(emails);
    ventana.add(emailT);

    JLabel phones = new JLabel("PHONE NUMBER: ");
    phones.setBounds(10,210,200,20);
    JTextField phoneT = new JTextField(" ");
    phoneT.setBounds(250,210,200,20);
    ventana.add(phones);
    ventana.add(phoneT);
    JLabel resultLabel = new JLabel("Resultado: ");
    resultLabel.setBounds(10, 70, 200, 20);
    ventana.add(resultLabel);
    ventana.setSize(500,500);
    ventana.setVisible(true);


    String query = "SELECT * FROM progra2.users";
    //Dbconnection dbConn = new Dbconnection(URL, user, pass);
    UserExample u = dbConn.getUser(email, phone);
    Address a = dbConn.getAddress(u.getId(), query, number);

    if (u.getId()== 0){
        System.out.println("No existe");
        dbConn.insertnewUser (u);
    }else{
            System.out.println(u.getId());
            System.out.println(u.getUsername());
        }

    if(a.getId() == 0){
            System.out.println("Este usurio no tiene direccion: ");
            dbConn.insertNewDireccion(u);
        }else{
            System.out.println(a.getId());
            System.out.println(a.getcalle());
            System.out.println(a.getnumero());
        }
        try {
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    boolean InsertnewUser (UserExample user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                        + "VALUES('"+ user.getUserName() +"','Pantaleon','Bedolla','"+ user.getName() +"','2023-10-20','"+ user.getEmail() + "' )";
                        PreparedStatement preState;

                        try {
                            PreparedStatement preStatement = conn.prepareStatement(queryInsert);
                            preState.execute();
                            System.out.println("Se ha creado un nuevo usuario");
                            return true;
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("No se ha podido crear un nuevo usuario");
                                return false;
                                }
}
    
    boolean InsertNewAddress(UserExample user){

        String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, city, state, country, postal_code, gps_lat, gps_lon)"
        + "VALUES (" + user.getId() + ", 'Diego Ramirez' , 100, '','Nicolas', 'morelia', 'michoacan', 'mexico', '58080', 1.2, 2.3)";
        System.out.println(queryInsert);
        PreparedStatement preState;

        try {
                            preState = conn.prepareStatement(queryInsert);
                            preState.execute();
                            System.out.println("Se ha creado una nueva direccion");
                            return true;

                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("No se ha podido crear un nuevo usuario");
                            }
                                return false;
                                
    }

    /*try{
        conn = DriverManager.getConnection(URL, user, pass);
        Statement statement =conn.createStatement();
        rset = statement.executeQuery(query);
        while(rset.next()){
                            System.out.println(rset.getString(1)
                            + " " + rset.getString(2)
                            + " " + rset.getString(3)
                            + " " + rset.getString(4)
                            + " " + rset.getString(5)
                            + " " + rset.getString(6)
                            + " " + rset.getString(7)
                            );
        }
        PreparedStatement preState = conn.prepareStatement(queryInsert);
        preState.execute();
        
        conn.close();
        }
        
        catch (SQLException e) {
        e.printStackTrace();
        }
}*/

Dbconnection(String URL, String user, String password){
    try{
        conn = DriverManager.gerConnection(URL, user pass);
    } 
    catch (SQLException e) {
        e.printStackTrace();
    }

}

UserExample getUser(String email, String phone){
    UserExample user = new UserExample();
    String query = " SELECT * FROM progra2.users u WHERE u.email = '" + email + "' OR u.phone_number ='" + numero + "'";
    Statement statement;
    ResultSet rset;
    
    
    try{ 
        statement = conn.createStatement();
        rset = statement.executeQuery(query);
    
    while (rset.next ()){
        System.out.println(rset.getString(1)
        + " " + rset.getString(2)
        + " " + rset.getString(3)
        + " " + rset.getString(4)
        + " " + rset.getString(5)
        + " " + rset.getString(6)
        + " " + rset.getString(7)
        + " " + rset.getString(8)
        + " " + rset.getString(9)
        );

        user.setId(Integer.parseInt(rset.getString(1)));
        user.setUsername(rset.getString(2));
        user.setFirts_lastname(rset.getString(3));
        user.setSecond_lastname(rset.getString(4));
        user.setName(rset.getString(5));
        user.setName(rset.getString(6));
        user.setEmail(rset.getString(7));
        user.setGender(rset.getString(8));
        user.setPhone_number(rset.getString(9));
        
    }
}
    catch(SQLException e){
        System.out.print("Error en query");
        user.setId(1);
    }
    return user;
}

Direccion getAddress (int idUser, String calle, int numero){

    Direccion direc = new direc ();
    String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser + "AND a.street = ' Nicolas Leon ' AND a.number = 109";
    System.out.println(query);
    ResultSet rset;
    Statement statement;

    try{ 
        statement = conn.createStatement();
        rset = statement.executeQuery(query);

        while (rset.next ()){
        System.out.println(rset.getString(1)
        + " " + rset.getString(2)
        + " " + rset.getString(3)
        + " " + rset.getString(4)
        + " " + rset.getString(5)
        + " " + rset.getString(6)
        + " " + rset.getString(7)
        + " " + rset.getString(8)
        + " " + rset.getString(9)
        );

        address.setId(Integer.parseInt(rset.getString(1)));
        address.setIdUser(Integer.getString(2));
        address.setStreet(rset.getString(3));
        address.setNumber(Integer.getString(4));
        address.setNumber_two(rset.getString(5));
        address.setNeighborhood(rset.getString(6));
        address.setCity(rset.getString(7));
        address.setState(rset.getString(8));
        address.setCountry(rset.getString(9));
        address.setPostal_code(rset.getString(10));
        address.setGps_lat(rset.getString(11));
        address.setGPs_lon(rset.getString(12));
    }
}
catch (Exception e){
    System.out.println("Error en query");
    address.setId(1);
}
}
}