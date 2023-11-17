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

    Password (String pass){
        this.longitud = false;
        this.may = false;
        this.min = false;
        this.num = false;
        this.especial = false;
        this.pass = pass;
    }

    boolean isSizeOk(){
        return pass.length()>=8 ? true: false;
        //return res;
    }

    boolean isUpcaseOk(){
        for(int i=0; i<pass.length(); i++){
            int ascii=(int)pass.charAt(i);
            if(ascii >= 65 && ascii <= 90){
                return true;
            }
        }
        return false;
    }

    boolean isLowcaseOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
            if(ascii >= 97 && ascii <= 122)
                return true;
                i++;
    }
    return false;
}

    boolean isNumberOk(){
        for(int i=0; i<pass.length(); i++){
            int ascii=(int)pass.charAt(i);
            if(ascii >= 48 && ascii <= 57){
                return true;
            }
    }
    return false;
    }

    boolean isSpecialCharOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int)pass.charAt(i);
            switch(ascii){
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
            }
            i++;
        }
        return false;
    }
    public static void main(String[] args) {
        String p = "ddsfssdfD4";
        Password pass = new Password(p);
        System.out.println("minusculas: " + pass.isLowcaseOk());
        System.out.println("numeros: " +pass.isNumberOk());
        System.out.println("tamaño: " +pass.isSizeOk());
        System.out.println("especiales: " + pass.isSpecialCharOk());
        System.out.println("mayusculas: " + pass.isUpcaseOk());

        pass.isLowcaseOk();
        pass.isNumberOk();
        pass.isUpcaseOk();
        pass.isSizeOk();
        pass.isSpecialCharOk();

        String pwd_hash = BCrypt.hashpw(p, BCrypt.gensalt());
        System.out.println(pwd_hash);

        if(BCrypt.checkpw(p, pwd_hash)){
            System.out.println("coincide");
        }else{
            System.out.println("no coincide");
        }

        String sessiontime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
        String sessionuuid = UUID.randomUUID().toString().substring(1, 10);
        String session = sessiontime+sessionuuid;
        System.out.println(session);
        LocalDateTime nowdate = LocalDateTime.now();
        System.out.println(nowdate);
        LocalDateTime enDateTime = nowdate.plusMinutes(20);
        System.out.println(enDateTime);


    }
}
