import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Password {
    boolean longitud  = false;
    boolean may = false;
    boolean min = false;
    boolean numero = false;
    boolean especial = false;
    String pass;

    Password(String pass){
        this.longitud = false;
        this.may = false;
        this.min=false;
        this.numero=false;
        this.especial=false;
        this.pass = pass;

    }

    boolean isSizeOk(){
       return pass.length()>=8 ? true : false;
      
    }

    boolean isUpcaseOk(){
        for(int i=0;i<pass.length();i++){
            int ascci = (int) pass.charAt(i);
            if(ascci >= 65 && ascci<=90){
                return true;
            }
        }
        return false;
    }

    boolean isLowcaseOk(){
        int i = 0;
        while(i<pass.length()){
        int ascci = (int) pass.charAt(i);
         if(ascci >= 97 && ascci<=122)
                return true;
                i++;
            
        }
        return false;
        
    }
     boolean isNumberOk(){
        for(int i=0;i<pass.length();i++){
            int ascci = (int) pass.charAt(i);
            if(ascci >= 48 && ascci<=57){
                return true;
            }
        }
        return false;
    }
    boolean isSpecialCharacteOk(){
        int i = 0;
        while(i<pass.length()){
            int ascci= (int) pass.charAt(i);
            switch (ascci) {
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
        return true;
    }

    public static void main(String[] args) {
        String pass = "Anibal123#";
        Password p1 = new Password(pass);
        System.out.println("minusculas " + p1.isLowcaseOk());
        System.out.println("masyusculas " + p1.isUpcaseOk());
        System.out.println("numeros " + p1.isNumberOk());
        System.out.println("tamano " + p1.isSizeOk());
        System.out.println("caracter " + p1.isSpecialCharacteOk());

      String psw_hash = BCrypt.hashpw(pass, BCrypt.gensalt());
      System.out.println(psw_hash);
      
      if(BCrypt.checkpw(pass, psw_hash)==true){
        System.out.println("Coincide ");
      }else{
        System.out.println("No coincide ");
      }

      String sessiontime = String.valueOf(System.currentTimeMillis()).substring(8,13);
      String sessionuuid = UUID.randomUUID().toString().substring(1,10);
      String session = sessiontime + sessionuuid;
      System.out.println(session);
      LocalDateTime nowdate = LocalDateTime.now();
      System.out.println(nowdate);
      LocalDateTime endtimesession = nowdate.plusMinutes(30);
      System.out.println(endtimesession);


    }
}

