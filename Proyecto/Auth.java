package Proyecto;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Auth {
    static String DB_URL;
    static String DB_USER;
    static String DB_PASS;

    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String dB_URL) {
        DB_URL = dB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public void setDB_USER(String dB_USER) {
        DB_USER = dB_USER;
    }

    public String getDB_PASS() {
        return DB_PASS;
    }

    public void setDB_PASS(String dB_PASS) {
        DB_PASS = dB_PASS;
    }
    //Constructor
    Auth() {
        DB_URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        DB_USER = "alumno";
        DB_PASS = "alumnoPrueba1";
    }

    String calculateToken() {
        SecureRandom sr = new SecureRandom();
        Base64.Encoder encoder64 = Base64.getUrlEncoder();
        byte[] randomBytes = new byte[24];
        sr.nextBytes(randomBytes);
        String token = encoder64.encodeToString(randomBytes);
        return token;
    }

    String calculateExpiration(int minutesToExpire) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateTime.format(myFormatObj);
        LocalDateTime expirationDate = dateTime.plusMinutes(minutesToExpire);

        // Aquí ajustamos la fecha de expiración a 20 minutos después de la creación
        expirationDate = expirationDate.plusMinutes(20);

        formattedDate = expirationDate.format(myFormatObj);
        return formattedDate;
    }

    static boolean reviewToken(Token localToken, Token dbToken) {
        if (localToken.getToken().contains(dbToken.getToken())) {
            String dbExpiration = dbToken.getExpiration();
            dbExpiration = dbExpiration.replace(' ', 'T');
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime dbDateTime = LocalDateTime.parse(dbExpiration);
            int diff = dbDateTime.compareTo(localDateTime);
            return diff > 0;
        }
        return false;
    }
}
