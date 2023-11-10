import javax.swing.text.AbstractDocument.BranchElement;

public class Password {
    
    boolean longitud = false;
    boolean mayus = false;
    boolean minus = false;
    boolean espec = false;
    String pass;
    
    Password (String pass){
        this.longitud = false;
        this.mayus = false;
        this.minus = false;
        this.espec = false;
        this.pass =  pass;
    }
    boolean longit(){
        return pass.length()>=8 ? true : false;
    } 

    boolean isUpcaseOk(){
        for (int i = 0; i<pass.length(); i++){
            int ascii = (int)pass.charAt(i);
            if(ascii >= 65 & ascii<= 90){
                return true;
            }

        }
        return false;
    }
    boolean isLowcaseOk (){
        int i = 0; 
        while ( i<pass.length()){
            int ascii = (int)pass.charAt(i);
            if(ascii >= 97 & ascii<= 122)    return true;
            i++;
        }
        return false;
    }
    boolean isNumcaseOk (){
        int i = 0; 
        while ( i<pass.length()){
            int ascii = (int)pass.charAt(i);
            if(ascii >= 48 & ascii<= 57)    return true;
            i++;
        }
        return false;
    }
    boolean isEspCharcaseOk(){
        for (int i = 0; i<pass.length(); i++){
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

                default:
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pass = "Feliche1*";
        Password P = new Password(pass);
        System.out.println("minusculas: " +P.isLowcaseOk());
        System.out.println("mayusculas: " +P.isUpcaseOk());
        System.out.println("numeros: " +P.isNumcaseOk());
        System.out.println("caracteres especiales: " +P.isEspCharcaseOk());
        System.out.println("longitud: " +P.longit());
    }
}
