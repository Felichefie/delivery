import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Password {
    boolean longitud = false;
    boolean may = false;
    boolean min = false;
    boolean num = false;
    boolean especial = false;
    String pass = "";

    Password(String pass) {
        this.longitud = false;
        this.may = false;
        this.min = false;
        this.num = false;
        this.especial = false;
        this.pass = pass;
    }

    boolean size() {
        return pass.length() >= 8 ? true : false;
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
        int i = 0;
        while (i < pass.length()) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 97 && ascii <= 122)
                return true;
            i++;
        }
        return false;
    }

    boolean haveNumber() {
        int i = 0;
        while (i < pass.length()) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 48 && ascii <= 57)
                return true;
            i++;
        }
        return false;
    }

    boolean haveSpecial() {
        int i = 0;
        while (i < pass.length()) {
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
                    i++;
            }
        }
        return false;
    }

    boolean isPasswordOk() {
        return size() && haveUpcase() && haveLowcase() && haveNumber() && haveSpecial();
    }

    public static void main(String[] args) {
        String pass = "Quesadilla51*";
        Password userPass = new Password(pass);

        System.out.println(pass);
        System.out.println("Longitud:" + userPass.size());
        System.out.println("Mayusculas:" + userPass.haveUpcase());
        System.out.println("Minusculas:" + userPass.haveLowcase());
        System.out.println("Numeros:" + userPass.haveNumber());
        System.out.println("Especiales:" + userPass.haveSpecial());

        String pwd_hash = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.println(pwd_hash);

        if (BCrypt.checkpw(pass, pwd_hash) == true) {
            System.out.println("Contraseña correcta");
        } else {
            System.out.println("Contraseña incorrecta");
        }

        String sesiontime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
        String sesionuuid = UUID.randomUUID().toString().substring(1, 10);
        String sesion = sesiontime + sesionuuid;
        System.out.println(sesion);

        LocalDateTime nowdDate = LocalDateTime.now();
        System.out.println(nowdDate);
        LocalDateTime endTimeSesion = nowdDate.plusMinutes(20);
        System.out.println(endTimeSesion);
    }
}