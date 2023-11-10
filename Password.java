import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        String pass = "343Industries";
        Password p = new Password(pass);
        System.out.println("Mayusculas: " + p.isUpCaseOk());
        System.out.println("Minisculas: " + p.isLowCaseOk());
        System.out.println("Numeros: " + p.isNumOk());
        System.out.println("Tamaño: " + p.isSizeOk());
        System.out.println("Carcater Especial: " + p.isEspOk());

        
    }


}
