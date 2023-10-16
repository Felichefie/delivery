import java.util.List;
import com.google.gson.Gson;
public class ConnectionMain {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
       String txtJson=conexion.sendGet();
        //System.out.println(txtJson);// para ver el los datos

        Gson gson = new Gson();
        List<Userexample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("lista de registros: " + lista.size());// para ver el numero de datos que llegan

        for(Userexample user:lista){
           System.out.println(user.getUserId());
           //imprimir solo los ID difetentes
           //imprimir los Id que pertenecia a los Id diferente
           
    }
}
}