

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
        return pass.length()>=8 ? true : false;
    }

    boolean isUpcaseOk(){
        for(int i=0; i<pass.length(); i++){
            int ascii = (int) pass.charAt(i);
            if(ascii >= 65 && ascii<=90){
                return true;
            }
        }
        return false;
    }

    boolean haveLowerCase(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
            if(ascii >= 97 && ascii<=122) return true;
            i++;
        }
        return false;
    }

    boolean isNumberOk(){
        for(int i=0; i<pass.length(); i++){
            int ascii = (int) pass.charAt(i);
            if(ascii >= 48 && ascii<=57){
                return true;
            }
        }
        return false;
    }

    boolean isSpecialCharacterOk(){
        int i = 0;
        while(i<pass.length()){
            int ascii = (int) pass.charAt(i);
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
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String p = "Ghdksj45%";
        Password userPass = new Password(p);
        System.out.println("minusculas: " + userPass.haveLowerCase());
        System.out.println("numeros: " + userPass.isNumberOk());
        System.out.println("tamaño: " + userPass.isSizeOk());
        System.out.println("caracter especial: " + userPass.isSpecialCharacterOk());
        System.out.println("mayusculas: " + userPass.isUpcaseOk());

    }
}
