package Proyecto;

public class VerifyPwd {
    private String pass;

    public VerifyPwd(String pass) {
        this.pass = pass;
    }

    public String verificarContrasena() {
        String errores = "";

        if (!haveSize()) {
            errores += "La contraseña debe tener al menos 8 caracteres.\n";
        }
        if (!haveUpCase()) {
            errores += "La contraseña debe contener al menos una letra mayúscula.\n";
        }
        if (!haveLowerCase()) {
            errores += "La contraseña debe contener al menos una letra minúscula.\n";
        }
        if (!haveNum()) {
            errores += "La contraseña debe contener al menos un número.\n";
        }
        if (!haveCarEsp()) {
            errores += "La contraseña debe contener al menos un carácter especial ($, %, @, *, _, #).\n";
        }

        if (errores.isEmpty()) {
            return pass; // Contraseña válida, retornarla
        } else {
            return errores; // Retornar los errores encontrados
        }
    }

    boolean haveSize() {
        return pass.length() >= 8 ? true : false;
    }

    boolean haveUpCase() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                return true;
            }
        }
        return false;
    }

    boolean haveLowerCase() {
        int i = 0;
        while (i < pass.length()) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 97 && ascii <= 122)
                return true;
            i++;
        }
        return false;
    }

    boolean haveNum() {
        for (int i = 0; i < pass.length(); i++) {
            int ascii = (int) pass.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                return true;
            }
        }
        return false;
    }

    boolean haveCarEsp() {
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
                    break;
            }
            i++;
        }
        return false;
    }
}