public class Response {
    private boolean status;
    private int idUser;
    private String sesion;

    Response(boolean status, int idUser, String sesion){
        this.status = status;
        this.idUser = idUser;
        this.sesion = sesion;
    }

    Response(){
        this.status = false;
        this.idUser = -1;
        this.sesion = "";
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

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

}