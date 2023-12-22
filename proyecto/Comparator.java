import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Comparator {
    boolean longutud=false;
    boolean may=false;
    boolean min=false;
    boolean num=false;
    boolean espesial=false; 
    String pass;
    Comparator(String pass){
        this.longutud   =false;
        this.may        =false;
        this.min        =false;
        this.num        =false;
        this.espesial   =false;
        this.pass       =pass; 
    }
    //Tamaño_contraseña-------------------------------
    boolean isSizeOk(String pass){
        boolean res = pass.length()>=8 ? true : false;
        if(res==true){
            System.out.println("Size:Correcto");
        }
        else if(res==false){
            System.out.println("Size:Incorrecto");
        }
        return res;
    }
    //Numero----------------------------------------------- 
    boolean isNumberOk(String pass){
        for(int i=0; i<pass.length(); i++){
            int ascii = pass.charAt(i);
            if(ascii >= 48  && ascii <= 57){
                System.out.println("Number:Correcto");
                return true;
            }
        }
        System.out.println("Number:Incorrecto");
        return false;
    }
    //Minusculas----------------------------------------
    boolean isMinOk(String pass){
        for(int i=0; i<pass.length(); i++){
            int ascii = pass.charAt(i);
            if(ascii >= 97  && ascii <= 122){
                System.out.println("Minusculas:Correcto");
                return true;
            }
        }
        System.out.println("Minusculas:Incorrecto");
        return false;
    }
    //Mayusculas--------------------------------------------
    boolean isMayOk(String pass){
        for(int i=0; i<pass.length(); i++){
            int ascii = pass.charAt(i);
            if(ascii >= 65  && ascii <= 90){
                System.out.println("Mayusculas:Correcto");;
                return true;
            }
        }
        System.out.println("Mayusculas:Incorrecto");
        return false;
    }
    //Caracteres_espesiales-------------------------------
    boolean isEspesialOk(String pass){
        for(int i=0; i<pass.length(); i++){
            int ascii = pass.charAt(i);
            if(ascii >= 42 && ascii <= 47){
                System.out.println("Espesial:Correcto");
                return true;
            }
        }
        System.out.println("Espesial:Incorrecto");
        return false;
    }
    boolean isGmail(String args) {
        String correo =args;

        // Verificar si la cadena termina con "@gmail.com"
        if (correo.endsWith("@gmail.com")) {
            System.out.println("El correo es de Gmail.");
            return true;
        } else {
            System.out.println("El correo no es de Gmail.");
        }
        return false;
    }
    boolean isGender(String args) {
        String cadena =args;

        // Verificar si la cadena contiene solo "H" o "M"
        if (cadena.equals("H") || cadena.equals("M")) {
            System.out.println("La cadena contiene solo 'H' o 'M'.");
            return true;
        } else {
            System.out.println("La cadena no cumple con la condición.");
        }
        return false;
    }
    boolean isNumCell(String args) {
        String cadena =args;

        // Verificar si la cadena contiene solo números enteros
        if (cadena.matches("\\d+")) {
            System.out.println("La cadena contiene solo números enteros.");
            return true;
        } else {
            System.out.println("La cadena no contiene solo números enteros.");
        }
        return false;
    }
    boolean isFech(String args) {
        String cadena = args; 

        // Verificar que la cadena tenga exactamente 10 caracteres
        if (cadena.length() == 10) {
            System.out.println("La cadena tiene exactamente 10 caracteres.");
        } else {
            System.out.println("La cadena no tiene exactamente 10 caracteres.");
            return false; // Salir del programa si no tiene exactamente 10 caracteres
        }

        // Verificar que la cadena tenga del primer al cuarto dato
        String subcadena1 = cadena.substring(0, 4);
        System.out.println("Subcadena del primer al cuarto dato: " + subcadena1);

        // Verificar que la cadena tenga del sexto al séptimo dato
        String subcadena2 = cadena.substring(5, 7);
        System.out.println("Subcadena del sexto al séptimo dato: " + subcadena2);

        // Verificar que la cadena tenga del noveno al décimo dato
        String subcadena3 = cadena.substring(8, 10);
        System.out.println("Subcadena del noveno al décimo dato: " + subcadena3);
        return true;
    }
    boolean isEmpty(String args,String args2,String args3,String args4) {
        String miCadena =args;
        String miCadena2 =args2;
        String miCadena3 =args3;
        String miCadena4 =args4; 
        // Verificación usando isEmpty()
        if (!miCadena.isEmpty()&&!miCadena2.isEmpty()&&!miCadena3.isEmpty()&&!miCadena4.isEmpty()) {
            System.out.println("La cadena no está vacía (isEmpty()).");
            return true;
        } else {
            System.out.println("La cadena está vacía (isEmpty()).");
        }
        return false;

    }

    public static void main(String[] args){
        String pass="ghRTjs12efr";
        Comparator p=new Comparator(pass);
        p.isSizeOk(pass);
        //p.isUpcaseOk(pass);
        p.isNumberOk(pass);
        p.isMinOk(pass);
        p.isMayOk(pass);
        String pwd_hash=BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println(pwd_hash);
        
        if(BCrypt.checkpw(pass, pwd_hash)==true){
            System.out.println("Son iguales");
        }
        else{
            System.out.println("No son iguales");
        }
        String sesion_time=String.valueOf(System.currentTimeMillis()).substring(8, 13);
        String sesion_uuid=UUID.randomUUID().toString().substring(1, 10);
        String sesion=sesion_time+sesion_uuid;
        System.out.println(sesion);
        LocalDateTime nowdate=LocalDateTime.now();
        System.out.println(nowdate);
        LocalDateTime end_time_sesion=nowdate.plusMinutes(20);
        System.out.println(end_time_sesion);
    }
}
