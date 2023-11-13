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
    boolean isSizeOk(){
         return pass.length()>=8 ? true: false;
    }

    boolean isUpCaseOk(){
        for(int i=0; i<pass.length(); i++){
           int ascii = (int) pass.charAt(i);
           if(ascii >= 65 && ascii <= 90){
                return true;
           }
        }
        return false;
    }

    boolean isLowCaseOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
           if(ascii >= 97 && ascii <= 122) return true;
           i++;
                
        }
        return false;
    }

    boolean isNumOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
            if(ascii >= 48 && ascii <= 57) return true;
           i++;
                
        }
        return false;
    }

    boolean isEspOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
            switch (ascii){
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
            }
           i++;
                
        }
        return false;
    }

    public static void main(String[] args) {
        String p = "343Industries";
        Password userPass = new Password(p);
        System.out.println("Mayusculas: " + userPass.isUpCaseOk());
        System.out.println("Minisculas: " + userPass.isLowCaseOk());
        System.out.println("Numeros: " + userPass.isNumOk());
        System.out.println("Tamaño: " + userPass.isSizeOk());
        System.out.println("Carcater Especial: " + userPass.isEspOk());

        String pwd_hash = BCrypt.hashpw(p, BCrypt.gensalt());
        System.out.println(pwd_hash);

        if(BCrypt.checkpw(p, pwd_hash)){
            System.out.println("Coinciden las credenciales");
        }else{
            System.out.println("Las credenciales no coinciden");
        }

        String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
        String sessionUUID = UUID.randomUUID().toString().substring(1, 10);
        String session = sessionTime + sessionUUID;
        System.out.println(session);

        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime endTimeSession = nowDate.plusMinutes(20);
        System.out.println(endTimeSession);
        System.out.println(nowDate);


    }

}
