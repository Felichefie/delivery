import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCrypt;

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

    Auth() {
        DB_URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        DB_USER = "alumno";
        DB_PASS = "alumnoPrueba1";
    }

    String calculateToken(){
        SecureRandom sr = new SecureRandom();
            Base64.Encoder encoder64 = Base64.getUrlEncoder();
            byte[] randomBytes = new byte[24];
            sr.nextBytes(randomBytes);
            String token = encoder64.encodeToString(randomBytes);
            return token;
    }

    String calculateExpiration(int minutesToExpire){
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateTime.format(myFormatObj);
            LocalDateTime  expirationDate = dateTime.plusMinutes(minutesToExpire);
            formattedDate = expirationDate.format(myFormatObj);
            return formattedDate;
    }

    boolean reviewToken(Token localToken, Token dbToken){
        // review token
        if(localToken.token.contains(dbToken.token)){
            // review date
            String dbExpiration = dbToken.expiration;
            dbExpiration = dbExpiration.replace(' ', 'T');
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime dbDateTime = LocalDateTime.parse(dbExpiration);
            int diff = dbDateTime.compareTo(localDateTime);
            if(diff > 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Auth auth = new Auth();

        // This data get from GUI
        final String userEmail = "felix.jimenez@umich.mx";
        // pass felichito in hash DB $2a$10$M7MqVZ4aTYUO./u.eTneCe.NL00eoBZPt2Xgufk6AitPIKC8ugvkm
        final String userPassword = "felichito";
        final Token tokenLocal = new Token("CDu_dhmdjDZkG22_sw_tvhr4zmLdBvOC", "2023-12-15 00:48:59");

        // connection to database
        Dbconnection dbConn = new Dbconnection(DB_URL, DB_USER, DB_PASS);
        // get user by email
        User u = dbConn.getUser(userEmail);

        // if already have token
        // get Token an expiration date & hour
        Token t = dbConn.getToken(u.getUserId());
        System.out.println(t.token + " " + t.expiration);
        if (auth.reviewToken(t, tokenLocal)){
            System.out.println("valido");
        } else {
            // Password in plain text is equal to Hash password ??
            if (BCrypt.checkpw(userPassword, u.getPassword()) == true){
                System.out.println("It matches");

                // calculate token and expiration
                String token = auth.calculateToken();
                String expiration = auth.calculateExpiration(60*48);

                // update session & expiration
                dbConn.deleteToken(u.getUserId());
                dbConn.updateToken(u.getUserId(), token, expiration);
            } else {
                System.out.println("It does not match");
            }
        }

    }
}
