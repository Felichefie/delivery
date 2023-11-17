public class Response {
    private boolean status;
    private int idUser;
    private String session;

    Response(boolean status, int idUser, String session) {
        this.idUser = idUser;
        this.status = status;
        this.session = session;
    }

    Response() {
        this.idUser = -1;
        this.status = false;
        this.session = "";
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

}