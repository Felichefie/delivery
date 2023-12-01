import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Authpassword {
    private String pass;

    Authpassword(String pass) {
        this.pass = pass;
    }

    boolean isSizeOk() {
        return pass.length() >= 8;
    }

    boolean isUpcaseOk() {
        return !pass.equals(pass.toLowerCase());
    }

    boolean haveLowerCase() {
        return !pass.equals(pass.toUpperCase());
    }

    boolean isNumberOk() {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    boolean isSpecialCharacterOk() {
        Pattern pattern = Pattern.compile(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String p = "DORIsss123$.";
        Authpassword userPass = new Authpassword(p);

        System.out.println("Tamaño: " + userPass.isSizeOk());
        System.out.println("Mayúsculas: " + userPass.isUpcaseOk());
        System.out.println("Minúsculas: " + userPass.haveLowerCase());
        System.out.println("Número: " + userPass.isNumberOk());
        System.out.println("Carácter especial: " + userPass.isSpecialCharacterOk());

        String pwd_hash = BCrypt.hashpw(p, BCrypt.gensalt());
        System.out.println("Contraseña: " + pwd_hash);

        if (BCrypt.checkpw(p, pwd_hash)) {
            System.out.println("Coinciden");
        } else {
            System.out.println("No coinciden");
        }

        String sessionTime = String.valueOf(System.currentTimeMillis()).substring(8, 13);
        String sessionUUID = UUID.randomUUID().toString().substring(1, 10);
        String session = sessionTime + sessionUUID;

        System.out.println(session);

        LocalDateTime nowDate = LocalDateTime.now();

        System.out.println(nowDate);

        LocalDateTime endTimeSession = nowDate.plusMinutes(20);

        System.out.println(endTimeSession);
    }
}
