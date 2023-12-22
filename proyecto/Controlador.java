import java.sql.ResultSet;

import javax.print.DocFlavor.STRING;

public class Controlador {
    private String user;
    private String pass;//---------------------------------------------- 
    //1).ingreso------------------------------------ 
    Controlador(String user, String pass){
        this.user=user;
        this.pass=pass;

    }
    boolean check(){
        String tipoUs="Mp3ReCli";
        //base de datos SQL(DaIn)--------
        String URLSQL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String userSQL = "alumno";
        String passSQL = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URLSQL, userSQL, passSQL);
        boolean checkB=conBP.checkSql(this.user, tipoUs, this.pass);
        if(checkB){
            return true;
        }
        return false;
    }
    //2).Reguistro----------------------------------
    private String nombre, primer_apellido, segundo_apellido, NomberUs, cumpleaños, email, genero, numroTelefono, contraseña;

    Controlador(String nombre, String primer_apellido, String segundo_apellido, String NomberUs, 
    String cumpleaños, String email, String genero, String numroTelefono, String contraseña){
        this.nombre=nombre;                 this.primer_apellido=primer_apellido;   this.segundo_apellido=segundo_apellido;
        this.NomberUs=NomberUs;             this.cumpleaños=cumpleaños;             this.email=email;
        this.genero=genero;                 this.numroTelefono=numroTelefono;       this.contraseña=contraseña;
    }
    boolean Record(){
        System.out.println("OK");
        String tipoUs="Mp3ReCli";
        if(this.genero=="H"){
            this.genero="Hombre";
        }else if(this.genero=="M"){this.genero="Mujer";}
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        System.out.println(this.email);
        System.out.println(tipoUs);
        if(this.genero.equals("H")){
            this.genero="Hombre";
        }else if(this.genero.equals("M")){this.genero="Mujer";}
        System.out.println(this.genero);
        System.out.println(this.NomberUs);
        System.out.println(this.contraseña);
        int repeatUsersB=conBP.repeatUsersSql(tipoUs, this.NomberUs);
        int repeatGmailB=conBP.repeatGmailSql(tipoUs, this.email);
        if(repeatUsersB==0 && repeatGmailB==0){
            System.out.println("OK");
            User RecordB=conBP.RecordSql(this.nombre, this.primer_apellido, this.segundo_apellido, this.NomberUs,
                    this.cumpleaños, this.email, this.genero, this.numroTelefono, this.contraseña, tipoUs);/**/
            return true;
        }else if(repeatUsersB==1 || repeatGmailB==1){
            System.out.println("Termino");     
        }return false;
    }    
    private String Busqueda; int total, minimo;
    //Para el buscador
    Controlador(String Busqueda){
        this.Busqueda=Busqueda;  
        total=10;
        minimo=0;
    }
    String[][] searchesAlbum(){
        String separador = "BusAl:";
        System.out.println("Ok");
        String[][] Information =new String[10][6];
        // Verificar si la cadena contiene el separador
        if (this.Busqueda.contains(separador)) {
            // Obtener la subcadena después del separador
            String nuevaCadena = this.Busqueda.substring(this.Busqueda.indexOf(separador) + separador.length());
            
            // Imprimir la nueva cadena
            System.out.println("Cadena original: " + this.Busqueda);
            System.out.println("Nueva cadena: " + nuevaCadena);
            //base de datos SQL(DaIn)--------
            String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
            String user = "alumno";
            String pass = "alumnoPrueba1";
            //-------------------------------
            ConnectionSql conBP = new ConnectionSql(URL, user, pass);
            
            Information=conBP.searchesAlbumSQL(nuevaCadena, minimo, total);
            
        } else {
            // Imprimir un mensaje si la cadena no contiene el separador
            System.out.println("La cadena no contiene el separador.");
        }

        return Information;
    }
    Controlador(String Busqueda,int minimo){
        this.Busqueda=Busqueda;  
        total=10;
        this.minimo=minimo;
    }
    String[][] VerificacionAumento(){
        String[][] Information =new String[10][6];  Information[0][0]="No lo logro";
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        int contador=conBP.contadorSQL(this.Busqueda);
        contador=contador-10;
        if(contador>this.minimo){
            this.minimo=this.minimo+10;
            Information=conBP.searchesAlbumSQL(this.Busqueda,this.minimo, total);
        }
        return Information;
    }
    String[][] VerificacionDecremento(){
        String[][] Information =new String[10][6];  Information[0][0]="No lo logro";
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        if(0!=this.minimo){
            this.minimo=this.minimo-10;
            Information=conBP.searchesAlbumSQL(this.Busqueda,this.minimo, total);
        }else{
            
        }
        return Information;
    }
    Controlador(String Busqueda,int minimo, int total){
        this.Busqueda=Busqueda;  
        this.total=total;
        this.minimo=minimo;
    }
    String[] searchesArtista(){
        String[] Information =new String[4];
        String separador = "BusAr:";
        System.out.println("Ok");
        
        // Verificar si la cadena contiene el separador
        if (this.Busqueda.contains(separador)) {
            // Obtener la subcadena después del separador
            String nuevaCadena = this.Busqueda.substring(this.Busqueda.indexOf(separador) + separador.length());
            
            // Imprimir la nueva cadena
            System.out.println("Cadena original: " + this.Busqueda);
            System.out.println("Nueva cadena: " + nuevaCadena);
            //base de datos SQL(DaIn)--------
            String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
            String user = "alumno";
            String pass = "alumnoPrueba1";
            //-------------------------------
            ConnectionSql conBP = new ConnectionSql(URL, user, pass);
            Information=conBP.searchesArtistaSQL(nuevaCadena, minimo, total);
            
            
        } else {
            // Imprimir un mensaje si la cadena no contiene el separador
            System.out.println("La cadena no contiene el separador.");
        }
        
        return Information;
    }
    String[] VerificacionAumentoAr(){
        String[] Information =new String[4];  Information[0]="No lo logro";
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        int contador=conBP.contadorArSQL(this.Busqueda);
        contador=contador-4;
        if(contador>this.minimo){
            this.minimo=this.minimo+4;
            Information=conBP.searchesArtistaSQL(this.Busqueda,this.minimo, total);
        }
        return Information;
    }
    String[] VerificacionDecrementoAr(){
        String[] Information =new String[4];  Information[0]="No lo logro";
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        if(0!=this.minimo){
            this.minimo=this.minimo-4;
            Information=conBP.searchesArtistaSQL(this.Busqueda,this.minimo, total);
        }
        return Information;
    }
    String[][] searchesCancion(){
        String separador = "BusCa:";
        System.out.println("Ok");
        String[][] Information =new String[10][6];
        // Verificar si la cadena contiene el separador
        if (this.Busqueda.contains(separador)) {
            // Obtener la subcadena después del separador
            String nuevaCadena = this.Busqueda.substring(this.Busqueda.indexOf(separador) + separador.length());
            
            // Imprimir la nueva cadena
            System.out.println("Cadena original: " + this.Busqueda);
            System.out.println("Nueva cadena: " + nuevaCadena);
            //base de datos SQL(DaIn)--------
            String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
            String user = "alumno";
            String pass = "alumnoPrueba1";
            //-------------------------------
            ConnectionSql conBP = new ConnectionSql(URL, user, pass);
            
            Information=conBP.searchesCancionSQL(nuevaCadena);
            
        } else {
            // Imprimir un mensaje si la cadena no contiene el separador
            System.out.println("La cadena no contiene el separador.");
        }

        return Information;
    }
    String[][] Albums(){
        String[][] Information =new String[10][6];  
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        Information=conBP.searchesAlbumSQL(this.Busqueda,this.minimo, this.total);
        return Information;
    }
    //---------------------------------------------- 
    String url, size, time, title, album;
    Controlador(String email, String url, String size,String time, String title, String album){
        this.email=email;   this.time=time;     this.url=url;  
        this.title=title;   this.album=album;   this.size=size;
    }
    String SubirCancion(){
        String respuesta="", Cantante, TipoUser="Mp3ReCli";
        //base de datos SQL(DaIn)--------
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com/progra2";
        String user = "alumno";
        String pass = "alumnoPrueba1";
        //-------------------------------
        ConnectionSql conBP = new ConnectionSql(URL, user, pass);
        Cantante=conBP.dataUserSC(this.email, TipoUser);
        boolean check=conBP.revision(this.url, this.title);
        if(check){
            System.out.println("La Url es:"+this.url);
            System.out.println("La banda o el cantante es:"+Cantante);
            System.out.println("El tamaño es:"+this.size);
            System.out.println("El tiempo:"+this.time);
            System.out.println("El titulo:"+this.title);
            System.out.println("El Album:"+this.album);
            
            conBP.InsertMP3(this.url, Cantante, this.size, this.time, this.title, this.album);
        }
        
        return respuesta;
    }
}
