package Proyecto;

public class Token {
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    String expiration;

    Token(String token, String expiration) {
        this.token = token;
        this.expiration = expiration;
    }

    Token() {
        this.token = "";
        this.expiration = "";
    }
}
