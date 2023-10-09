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
}
}
