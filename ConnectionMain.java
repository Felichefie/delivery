import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        System.out.println(txtJson);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<User>>(){}.getType();
        List<User> users = gson.fromJson(txtJson, listType);
        System.out.println(txtJson);
    }
}
