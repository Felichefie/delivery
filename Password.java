public class Password {
    boolean longitud = false;
    boolean may = false;
    boolean min = false;
    boolean num = false;
    boolean especial = false;
    String pass = "";

    Password(String password) {
        // Constructor vacío
    }

    void setPass(String pass) {
        this.pass = pass;
    }

    boolean size() {
        return pass.length() >= 8;
    }

    boolean haveUpcase() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                return true;
            }
        }
        return false;
    }

    boolean haveLowcase() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 97 && ascii <= 122) {
                return true;
            }
        }
        return false;
    }

    boolean haveNumber() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                return true;
            }
        }
        return false;
    }

    boolean haveSpecial() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            switch (ascii) {
                case '$':
                case '%':
                case '@':
                case '*':
                case '_':
                case '#':
                    return true;
            }
        }
        return false;
    }

    boolean isPasswordOk() {
        return size() && haveUpcase() && haveLowcase() && haveNumber() && haveSpecial();
    }

    public static void main(String[] args) {
        String contraseña = "NuevaPass123#";
        Password verificar = new Password(contraseña);
        verificar.setPass(contraseña);

        System.out.println(contraseña);
        System.out.println("Longitud:" + verificar.size());
        System.out.println("Mayusculas:" + verificar.haveUpcase());
        System.out.println("Minusculas:" + verificar.haveLowcase());
        System.out.println("Numeros:" + verificar.haveNumber());
        System.out.println("Especiales:" + verificar.haveSpecial());
    }
}
/*
 * String pass_encrip = BCrypt.hashpw(contraseña, BCrypt.gensalt());
 * System.out.println(pass_encrip);
 * 
 * if (BCrypt.checkpw(contraseña, pass_encrip) == true) {
 * System.out.println("Contraseña correcta");
 * } else {
 * System.out.println("Contraseña incorrecta");
 * }
 * 
 * 
 * String sesiontime = String.valueOf(System.currentTimeMillis()).substring(8,
 * 13);
 * String sesionuuid = UUID.randomUUID().toString().substring(1, 10);
 * String sesion = sesiontime + sesionuuid;
 * System.out.println(sesion + "jjj");
 * 
 * LocalDateTime nowdDate = LocalDateTime.now();
 * System.out.println(nowdDate);
 * LocalDateTime endTimeSesion = nowdDate.plusMinutes(20);
 * System.out.println(endTimeSesion);
 */