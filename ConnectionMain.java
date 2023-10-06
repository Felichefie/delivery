
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class ConnectionMain {
    public static void main(String[] args) {
    Conexion con = new Conexion();
    String txtJson =  con.sendGet();
        System.out.println(txtJson);
    Gson gson = new Gson();
List<UserExample> lista = gson.fromJson(txtJson, new TypeToken<List<UserExample>>(){}.getType());

        System.out.println(lista.size());
    }
    }

