import org.springframework.security.crypto.bcrypt.BCrypt;


public class password {
    boolean longitud = false;
    boolean mayusculas = false;
    boolean minusculas = false;
    boolean numero = false;
    boolean specialz = false;
    String pass;

    password(String pass){
        this.longitud=false;
        this.mayusculas=false;
        this.minusculas=false;
        this.numero=false;
        this.specialz=false;
        this.pass= pass;
    }
    
    boolean isSizeOk(){
        return pass.length()>=8 ? true : false; 
        
    }

    boolean isUpcaseOk(){
        for(int i = 0;i<pass.length();i++){
            int ascii = (int) pass.charAt(i);
            if (ascii >= 65 && ascii <= 90){
                return true;
            }
        }
        return false;
    }

    boolean isLowcaseOk(){
        int i=0;
        while (i<pass.length()){
             int ascii = (int) pass.charAt(i);
            if (ascii >= 97 && ascii <= 122)  return true;
            i++;   
        }
    return false;
    }

    boolean isNumOk(){
        int i=0;
        while (i<pass.length()){
             int ascii = (int) pass.charAt(i);
            if (ascii >= 48 && ascii <= 57)  return true;
            i++;   
        }
    return false;

    }

    boolean isSpecialzOK(){
                int i=0;
        while (i<pass.length()){
             int ascii = (int) pass.charAt(i);
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
        String pass = "Qwerty098";
        password p = new password(pass);
        System.out.println("Minsuculas " + p.isLowcaseOk());
        System.out.println("Numeros " + p.isNumOk());
        System.out.println("Tamaño " + p.isSizeOk());
        System.out.println("Caracter Especial " + p.isSpecialzOK());
        System.out.println("Mayusculas " + p.isUpcaseOk());
       
        String pwd_hash = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println(pwd_hash);

    }
}
