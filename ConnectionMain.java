import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson=con.sendGet();
        System.out.println(txtJson);

        User u = new User(1, 0, "titulo texto", "txtJson");
        String resJson;
        Serializar serial = new Serializar();
        res.Json = serial.user(u);
        System.out.println (res.Json);
        serial.userAdd(u);
        res.Json=serial Lista_json();
        System.out.println (res.Json);
        


        Gson gson = new Gson();


        //List<Userexample> lista= gson.fromJson(txtJson, List.class);
        Type type =new TypeToken<List<Userexample>>() {}.getType();
        List<Userexample> lista = gson.fromJson(txtJson, type);
        //System.out.println(lista.size());
        System.out.println("numero de registro:" + lista.size());

        for(Userexample user : lista) {
            System.out.println ("USER ID: " + user.getUserId());
            System.out.println ("ID: " + user.getId());

        }
    }
}
