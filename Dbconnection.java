
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

public class Dbconnection {

    static Connection conn =null;
    public static void main(String[] args) {
        //Connection conn;
       // ResultSet rset;
       String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String password = "alumnoPrueba1";
        String email = "felix.jimenez@umich.mx";
        String  phone = "4431234567";
        int idUser = 1;
        String street = "Privada Jacarandas";
        int number = 109;
        Dbconnection dbConn = new Dbconnection(URL, user, password);
         
    //CREA ITERFAZ
    JFrame ventana = new JFrame("USUARIOS REGISTRADOS");
    ventana.setLayout(null);
    JLabel etiqueta = new JLabel(".....INGRESE SUS DATOS.....");
    etiqueta.setBounds(180,10,300,20);
    ventana.add(etiqueta);
    
    JButton buscarDatos = new JButton("Buscar Datos");
    buscarDatos.setBounds(250, 250, 200,20);
    ventana.add(buscarDatos);
    JTextArea ResultArea = new JTextArea(10,20);
    ResultArea.setEditable(false);
    ventana.add(ResultArea);
    JTextField inputText = new JTextField(20);

    buscarDatos.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
       
            String input = inputText.getText();
            UserExample userResult = dbConn.getUser(input, input);
            if(userResult != null){
                System.out.println("USUARION NO HA SIDO ENCONTRADO.");
                System.out.println("ID" + userResult.getId());
                System.out.println("nombre del usuario" + userResult.getUserName());
                Address userAddress = dbConn.getAddress(idUser, street, number);

                if(userAddress != null){
                System.out.println("DIRECCION NO HA SIDO ENCONTRADO.");
                System.out.println("ID" + userAddress.setStreet());
                }
            }
        }
        
    });


    
    //CREA CUADRO DE TEXTO ID
    JLabel id = new JLabel("ID: ");
    id.setBounds(10, 60, 100, 20);
    JTextField idT = new JTextField("  ");
    idT.setBounds(250,60,200,20);
    ventana.add(id);
    ventana.add(idT);

    //CREA CUADRO DE TEXTO USER_NAME
    JLabel user_names = new JLabel("USER NAME: ");
    user_names.setBounds(10,85,200,20);
    JTextField user_nameT = new JTextField(" ");
    user_nameT.setBounds(250, 85, 200, 20);
    ventana.add(user_names);
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
    JLabel emails = new JLabel("EMAIL: ");
    emails.setBounds(10,185,200,20);
    JTextField emailT = new JTextField(" ");
    emailT.setBounds(250,185,200,20);
    ventana.add(emails);
    ventana.add(emailT);

    //CREA CUADRO DE TEXTO PHONE_NUMBER
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

    



        

       //System.out.println("CONECTANDO A LA BASE DE DATOS...");

        String query = "SELECT * FROM progra2.users";
        //Dbconnection dbConn = new Dbconnection(URL, user, password);
        UserExample u = dbConn.getUser(email, phone);
        Address a = dbConn.getAddress(u.getId(), query, number);

        //User u = dbConn.getUser("felix.jimenez@umich.mx");
        if(u.getId() == 0){
            System.out.print("NO EXISTE");
            dbConn.InsertnewUser(u);
        }else{
            System.out.println(u.getId());
            System.out.println(u.getUserName());
        
        }

        if(a.getId() ==0 ){
            System.out.println("EL USUARIO NO TIENE DIRECCIONES :() ");
            dbConn.InsertNewAddress(u);
        }else{
            System.out.println(a.getId());
            System.out.println(a.getStreet());
            System.out.println(a.getNumber());
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
//INSERTA UN NUEVO USUARIO
    boolean InsertnewUser(UserExample user){
        String queryInsert = "INSERT INTO progra2.users(user_name, first_lastname, second_lastname, name, birthday, email)"
                + "VALUES('" + user.getUserName() + "', 'Chabelo', 'Monster', '" + user.getName() + "', '2023-10-22', '" + user.getEmail() + "' )";
            PreparedStatement preState;

        try {
            PreparedStatement preStatement = conn.prepareStatement(queryInsert);
            preStatement.execute();
            System.out.println("SE HA INSERTADO UN NUEVO USUARIO!!!!!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NO SE HA PODIDO INSERTAR EL NUEVO USUARIO :() ");
            return false;
        }
    }


    //INSERTA DIRECCION
    boolean InsertNewAddress(UserExample user){
        String queryInsert = "INSERT INTO progra2.address(id_user, street, number, number_two, neighborhood, city, state, country, postal_code, gps_lat, gps_lon)"
        + "VALUES(" + user.getId() + ", 'Aldasoro Suarez', 100, '', 'Jardines', 'moreliaa', 'michoacan', 'mexico', '58322', 1.2, 2.3)";
        System.out.println(queryInsert);
        PreparedStatement preState;
        try {
            
            preState = conn.prepareStatement(queryInsert);
            preState.execute();
            System.out.println("LA DIRECCION HA SIDO INSERTADA CON EXITO!");
            return true;


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR AL INSERTAR LA DIRECCION :()");
        }

        return false;
    }


    Dbconnection(String URL, String user,String password){       
        try {
            conn = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
                e.printStackTrace();
        }        

    }

    //OBTIONE UN NUEVO USUARIO
    UserExample getUser(String email, String phone ){
        UserExample user = new UserExample();

        String query = "SELECT *  FROM progra2.users u WHERE u.email = '" + email + "' OR u.phone_number ='" + phone + "'";
        ResultSet rset;
        Statement statement;

        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);
            
            
            while(rset.next()){
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
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));
                user.setFirst_lastname(rset.getString(3));
                user.setSecond_lastname(rset.getString(4));
                user.setName(rset.getString(6));
                user.setEmail(rset.getString(7));
                user.setPhone_number(rset.getString(9));
                user.setGender(rset.getString(8));
            }
        }catch(SQLException e){    
            System.out.print("Error en la query");
            user.setId(1);
        }
        return user;
    }


    //ONBITIENE NUEVA DIRECCION
    Address getAddress(int idUser, String street, int number){
        Address address = new Address();
        String query = "SELECT * FROM progra2.address a WHERE a.id_User = " + idUser + " AND a.street = 'Privada Jacarandas' AND a.number = 109";
        System.out.println(query);
        ResultSet rset;
        Statement statement;

        try{
            statement = conn.createStatement();
            rset = statement.executeQuery(query);


            while(rset.next()){
                System.out.println(rset.getString(1)
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)
                + " " + rset.getString(7)
                + " " + rset.getString(8)
                + " " + rset.getString(9)
                + " " + rset.getString(10)
                + " " + rset.getString(11)
                + " " + rset.getString(12)
                );

                address.setId(Integer.parseInt(rset.getString(1)));
                address.setIdUser(Integer.parseInt(rset.getString(2)));
                address.setStreet(rset.getString(3));
                address.setNumber(Integer.parseInt(rset.getString(4)));
                address.setNumber_two(rset.getString(5));
                address.setNeighborhood(rset.getString(6));
                address.setCity(rset.getString(7));
                address.setState(rset.getString(8));
                address.setCountry(rset.getString(9));
                address.setPostal_code(rset.getString(10));
                address.setGps_lat(rset.getString(11));
                address.setGps_lon(rset.getString(12));
            }

        } catch (Exception e){
            System.out.println("Error en la query");
            address.setId(1);
        }

        return address;




        
    }
    


    
   
}