import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class ConnectionSql {
    static Connection conn;
    static Connection conn2;
    /*public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        String url,singer="Mago de Oz",size,time,title,album="Ira Dei";
        url="ID_3.mp3"; size="10,6 MB"; time="00:09:00";    title="El amor brujo";
        String email = "Mago_de_Oz@gmail.com", albumb="Gaia 3", t="Mp3ReCli";
        int info;
        String[][] Information=new String[10][6];
        String[] information=new String[4];
        boolean infor;
        //String num = "4431234567";
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        infor=conBP.revision(url, title);
        //info=conBP.contadorArSQL(singer);
        //information=conBP.searchesArtistaSQL(singer, 0, 10); 
        //conBP.dataUser(email, t);
        //conBP.InsertMP3(url, singer, size, time, title, album);
        //Information=conBP.searchesCancionSQL(title);
        Information=conBP.searchesAlbumSQL(albumb, 0, 10);
        for (int x = 0; x < Information.length; x++) {
            // Recorrer las columnas para cada fila
            System.out.println(Information[x][0]
                + " | " + Information[x][1]
                + " | " + Information[x][2]
                + " | " + Information[x][3]
                + " | " + Information[x][4]
                + " | " + Information[x][5]
            );
        } 
        //info=conBP.contadorSQL(albumb);     

    }*/
    //conexion de la base de datos
    ConnectionSql(String URL, String user, String pass){
        try {
            conn = DriverManager.getConnection(URL, user, pass);
            //System.out.println("Ok");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    boolean checkSql(String email, String tipoUs, String pass){
        User user = new User();
        String query = "SELECT * FROM users WHERE email ='" + email + "' AND type_user ='" + tipoUs + "'";
        ResultSet rset;
        Statement statement;
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
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
                if(BCrypt.checkpw(pass, rset.getString(11))==true){
                    System.out.println("Son iguales");
                    return true;
                }
                else{
                    System.out.println("No son iguales");
                }return false;
                /*user.setId(Integer.parseInt(rset.getString(1)));
                user.setName(rset.getString(5));
                user.setUserName(rset.getString(2));*/
                
            }
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return false;
    }
    String dataUser(String email, String tipoUs){
        User user = new User();
        String query = "SELECT * FROM users WHERE email ='" + email + "' AND type_user ='" + tipoUs + "'";
        ResultSet rset;
        Statement statement;
        String iformacion="";
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            
            while(rset.next()){
                iformacion=rset.getString(1);
               
        

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
                
            }
            return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return iformacion;
    }
    User RecordSql(String nombre, String primer_apellido, String segundo_apellido, String NomberUs, 
    String cumpleaños, String email, String genero, String numroTelefono, String contraseña, String tipoUs){
        User user = new User();
        String query = "INSERT INTO users(type_user, user_name, first_lastname, second_lastname, name, birthday, email, gender, phone_number, password) VALUES ('"+tipoUs+"','"+NomberUs+"','"+primer_apellido+"','"+segundo_apellido+"','"+nombre+"','"+cumpleaños+"','"+email+"','"+genero+"','"+numroTelefono+"','"+contraseña+"')";
        System.out.println(query);
        //ResultSet rset;
        //Statement statement;
        try{
            PreparedStatement preState = conn.prepareStatement(query);
            preState.execute();

        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }/**/
        return user;
    }
    int repeatUsersSql(String tipoUs, String nameUs){
        User user = new User();
        String query= "SELECT * FROM users WHERE  type_user ='"+ tipoUs +"' AND user_name ='"+ nameUs +"'";
        ResultSet rset;
        Statement statement;
        int userEx=0;
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
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
                if (rset.getString(3) != null ) {
                    System.out.println("La variable tiene datos.");
                    userEx=1;
                }
            }
            return userEx;
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return 1;
    }
    int repeatGmailSql(String tipoUs, String email){
        User user = new User();
        String query= "SELECT * FROM users WHERE email ='" + email + "' AND type_user ='"+ tipoUs +"'";
        ResultSet rset;
        Statement statement;
        int userEx=0;
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
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
                if (rset.getString(3) != null && !rset.getString(3).isEmpty() && !rset.getString(3).trim().isEmpty()) {
                
                    System.out.println("La variable tiene datos.");
                    userEx=1;
                } 
            }
            return userEx; 
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return 1;
    }
    void InsertMP3(String URL, String singer, String size,String time,String title, String album){
        User user = new User();
        String query = "INSERT INTO mp3(url, singer_group, album, title, size, time) VALUES ('"+URL+"','"+singer+"','"+album+"','"+title+"','"+size+"','"+time+"')";
        System.out.println(query);
        try{
            PreparedStatement preState = conn.prepareStatement(query);
            preState.execute();

        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }/**/
        
    }
    String[][] searchesAlbumSQL(String Buscador, int Minimo, int Total){
        String cadena1 = String.valueOf(Minimo),cadena2 = String.valueOf(Total);
        User user = new User();  
        String query = "SELECT * FROM mp3 WHERE album ='" + Buscador + "' LIMIT " + cadena1 + "," + cadena2 + "";
        ResultSet rset;
        Statement statement;
        String[][] iformacion=new String[10][6];
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            int x=0;
            while(rset.next()){
                
                iformacion[x][0]=rset.getString(1);
                iformacion[x][1]=rset.getString(2);
                iformacion[x][2]=rset.getString(3);
                iformacion[x][3]=rset.getString(4);
                iformacion[x][4]=rset.getString(5);
                iformacion[x][5]=rset.getString(6);
                /*System.out.println("Datos del rset-----------------------------------------------" );
                System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                );
                System.out.println("Datos del areglo." );
                System.out.println(iformacion[x][0]
                    + " " + iformacion[x][1]
                    + " " + iformacion[x][2]
                    + " " + iformacion[x][3]
                    + " " + iformacion[x][4]
                    + " " + iformacion[x][5]
                );*/
                
                x++;
            }
            return iformacion;
            //return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return iformacion;
    }
    int contadorSQL(String Buscador){
        User user = new User();  
        String query = "SELECT COUNT(*) FROM mp3 WHERE album ='" + Buscador + "'";
        ResultSet rset;
        Statement statement;
        int c=0;
        
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            while(rset.next()){
                c= rset.getInt(1);
                System.out.println("el total es:"+c);  
            }
            
            return c;
            //return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return c;
    }
    String[] searchesArtistaSQL(String Buscador, int Minimo, int Total){
        String cadena1 = String.valueOf(Minimo),cadena2 = String.valueOf(Total);
        User user = new User();  
        String query = "SELECT DISTINCT album FROM mp3 WHERE singer_group ='" + Buscador + "' LIMIT " + cadena1 + "," + cadena2 + "";
        ResultSet rset;
        Statement statement;
        String[] iformacion=new String[4];
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            int x=0;
            while(rset.next()){
                
                iformacion[x]=rset.getString(1);
                
                /*System.out.println("Datos del rset-----------------------------------------------" );
                System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                );
                System.out.println("Datos del areglo." );
                System.out.println(iformacion[x][0]
                    + " " + iformacion[x][1]
                    + " " + iformacion[x][2]
                    + " " + iformacion[x][3]
                    + " " + iformacion[x][4]
                    + " " + iformacion[x][5]
                );*/
                System.out.println("Album:"+iformacion[x]);
                x++;
            }
            return iformacion;
            //return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return iformacion;
    }
    int contadorArSQL(String Buscador){
        User user = new User();  
        String query = "SELECT COUNT(DISTINCT album) FROM mp3 WHERE singer_group ='" + Buscador + "'";
        ResultSet rset;
        Statement statement;
        int c=0;
        
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            while(rset.next()){
                c= rset.getInt(1);
                System.out.println("el total es:"+c);  
            }
            
            return c;
            //return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return c;
    }
    String[][] searchesCancionSQL(String Buscador){
        User user = new User();  
        String query = "SELECT * FROM mp3 WHERE title ='"+ Buscador +"' LIMIT 1,1";
        ResultSet rset;
        Statement statement;
        String[][] iformacion=new String[10][6];
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            int x=0;
            while(rset.next()){
                
                iformacion[x][0]=rset.getString(1);
                iformacion[x][1]=rset.getString(2);
                iformacion[x][2]=rset.getString(3);
                iformacion[x][3]=rset.getString(4);
                iformacion[x][4]=rset.getString(5);
                iformacion[x][5]=rset.getString(6);
                /*System.out.println("Datos del rset-----------------------------------------------" );
                System.out.println(rset.getString(1)
                    + " " + rset.getString(2)
                    + " " + rset.getString(3)
                    + " " + rset.getString(4)
                    + " " + rset.getString(5)
                    + " " + rset.getString(6)
                );
                */System.out.println("Datos del areglo." );
                System.out.println(iformacion[x][0]
                    + " " + iformacion[x][1]
                    + " " + iformacion[x][2]
                    + " " + iformacion[x][3]
                    + " " + iformacion[x][4]
                    + " " + iformacion[x][5]
                );
                
                x++;
            }
            return iformacion;
            //return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return iformacion;
    }
    String dataUserSC(String email, String tipoUs){
        User user = new User();
        String query = "SELECT * FROM users WHERE email ='" + email + "' AND type_user ='" + tipoUs + "'";
        ResultSet rset;
        Statement statement;
        String iformacion="";
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            
            while(rset.next()){
                iformacion=rset.getString(3);    
            }
            return iformacion;    
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        return iformacion;
    }
    boolean revision(String url, String titulo){
        User user = new User();
        String query = "SELECT * FROM mp3 WHERE url ='" + url + "' OR title ='" + titulo + "'";
        ResultSet rset;
        Statement statement;
        String iformacion="";
        System.out.println(query);
        try{
            statement = conn.createStatement(); 
            rset = statement.executeQuery(query);
            System.out.println("ok");
            
            while(rset.next()){
                System.out.println(rset.getString(1)
                + " " + rset.getString(2)
                + " " + rset.getString(3)
                + " " + rset.getString(4)
                + " " + rset.getString(5)
                + " " + rset.getString(6)
                );
                iformacion=rset.getString(1);
                System.out.println(iformacion);
            }
            if(iformacion.isEmpty()){
                System.err.println("NO TIENE NADA");
                return true;
            }else{
                System.out.println("TIENE ALGO");
                return false;
            }
                
        }catch(SQLException e){
            System.out.println("Error en la querry");
            user.setId(1);
        }
        
        return true;
    }

}