public class Response {
    private boolean status;
    private int idUser;
    private String sesion;


    Response(boolean ststus, int idUser, String sesion){
        this.idUser = idUser;
        this.status = ststus;
        this. sesion = sesion;
    }

    Response(){
        this.idUser = -1;
        this.status = false;
        this. sesion = "";
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
