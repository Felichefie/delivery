import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Pasword {
    boolean longitud = false;
    boolean mayus = false;
    boolean min = false;
    boolean numero = false;
    boolean carEsp = false;
    String pass;

    Pasword (String pass){
        this.longitud = false;
        this.mayus = false;
        this.min = false;
        this.numero = false;
        this.carEsp = false;
        this.pass = pass;
    }

    boolean haveSize (){
       return pass.length() >= 8 ? true : false;
    }

    boolean haveUpCase (){
        for (int i = 0;i<pass.length(); i++){
            int ascii = (int)pass.charAt(i);
            if (ascii >= 65 && ascii <=90){
                return true;
            }
        }
        return false;
    }
    boolean haveLowerCase (){
        int i = 0;
        while(i<pass.length()){
          int ascii = (int)pass.charAt(i);
            if (ascii >= 97 && ascii <=122) return true;
            i++;
        }
        return false;
    }           

    boolean haveNum (){
         for (int i = 0;i<pass.length(); i++){
            int ascii = (int)pass.charAt(i);
            if (ascii >= 48 && ascii <= 57){
                return true;
            }
        }
        return false;
    }   

    boolean haveCarEsp (){
        int i = 0;
        while(i<pass.length()){
          int ascii = (int)pass.charAt(i);
            switch (ascii) {
                case '$':
                    return true;
                case '%':
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
                    break;
            }
            i++;
        }
        return false;
    } 
    public static void main(String[] args) {
        String p = "elenaGabriel123#";
        System.out.println(p);
        Pasword userPass = new Pasword(p);
        System.out.println("Carácter especial: " + userPass.haveCarEsp());
        System.out.println("Mayúsculas: " + userPass.haveLowerCase());
        System.out.println("Números: " + userPass.haveNum());
        System.out.println("Longitud: " + userPass.haveSize());
        System.out.println("Mayúsculas: " + userPass.haveUpCase());
       
        String pwd_hash = BCrypt.hashpw(p, BCrypt.gensalt());
        System.out.println(pwd_hash);

        if(BCrypt.checkpw(p, pwd_hash)){
            System.out.println("Coincide");
        }else{
            System.out.println("No coincide ");
        }

        String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8,13);
        String sessionUUID = UUID.randomUUID().toString().substring(1,10);
        String session = sessionTime + sessionUUID;
        System.out.println(session);

        LocalDateTime nowDate = LocalDateTime.now();
        System.out.println(nowDate);

        LocalDateTime endTimeSession = nowDate.plusMinutes(20);
        System.out.println(endTimeSession);
    }

}
