public class Response {
    private boolean status;
    private int iduserr;
    private String sesion;
    
    Response(boolean status, int iduserr, String sesion){
        this.status = status;
        this.iduserr =iduserr;
        this.sesion = sesion;
    }

    Response(){
        this.status = false;
        this.iduserr = -1;
        this.sesion = "";
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIduserr() {
        return iduserr;
    }

    public void setIduserr(int iduserr) {
        this.iduserr = iduserr;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }
    
}
