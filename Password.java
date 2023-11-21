import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Password {
    boolean longitud = false;
    boolean may = false;
    boolean min = false;
    boolean num = false;
    boolean especial = false;
    String pass;
    

    Password(String pass){
        this.longitud = false;
        this.may = false;
        this.min = false;
        this.num = false;
        this.especial = false;
        this.pass = pass;
    }
//si la longitud de password es >= 8 regreesa un cierto, si no, regresa un falso
   boolean isSizeOk(){
       return  pass.length() >= 8 ? true : false;
    }

    // SIE ES MAYUSCULAS RECORRE CADA UNA DE ELLAS Y LAS VERIFICA
    boolean isUpCaseOk(){
        for(int i=0; i<pass.length(); i++){
           int ascci = (int) pass.charAt(i);
           if(ascci >= 65 && ascci <=90){
            return true;
           }  
        }
        return false;
    }

    // SIE ES MINUSCULAS RECORRE CADA UNA DE ELLAS Y LAS VERIFICA
    boolean isLowCaseOk(){
        int i =0 ;
        while (i<pass.length()) {
            int ascci = (int) pass.charAt(i);
            if(ascci >= 97 && ascci <= 122) return true;
            i++;       
        }
        return false;
    }

    boolean isNumberOk(){
        int i = 0;
        while(i < pass.length()){
            int ascci = (int) pass.charAt(i);
            if(ascci >= 97 && ascci <= 122) return true;
            i++;       
        }
        return false;
    }

    boolean isEspecialCaracter(){
        int i = 0;
        while(i < pass.length()){
            int ascci = (int) pass.charAt(i);
            switch (ascci) {
            case '$':
            return true;
            case '&':
            return true;
            case '@':
            return true;
            case '*':
            return true;
            case '_':
            return true;
            case '#':
            return true;
            default:
            }   
            i++;   
        }
        return false;

    }
    public static void main(String[] args) {
        String pass = "Perla1#";
        System.out.println(pass);
        Password p = new Password(pass);
        System.out.println("MINUSCULAS " + p.isLowCaseOk());
        System.out.println("MAYUSCULAS " + p.isUpCaseOk());
        System.out.println("NUMEROS " + p.isNumberOk());
        System.out.println("CARACTERES ESPECIALES " + p.isEspecialCaracter());
       // BcryptPasswordEncoder

       String pwd_hash = BCrypt.hashpw(pass, BCrypt.gensalt());
       System.out.println(pwd_hash);

       if(BCrypt.checkpw(pass, pwd_hash)){
        System.out.println("coincide");
       }else{
        System.out.println("no coincide");
       }
       
       String sesiontime = String.valueOf(System.currentTimeMillis()).substring(8,13);
       String sesionuuid = UUID.randomUUID().toString().substring(1,10);
       String sesion = sesiontime + sesionuuid;


       System.out.println(sesion);

       LocalDateTime nowdate = LocalDateTime.now();

       System.out.println(nowdate);

       LocalDateTime endSesion = nowdate.plusMinutes(20);
       
       System.out.println(endSesion);

    }
}
