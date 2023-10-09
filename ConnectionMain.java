import java.util.List;
import com.google.gson.Gson;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson=con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        List<Userexample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("numero de registros: " + lista.size());

        int i;
        for(i=0; i<lista.size(); i++){
            // lista.get(i) regresa un objeto de tipo UserExample
            Userexample objecto = lista.get(i);
            System.out.println(objecto);
        } 

    }
}
