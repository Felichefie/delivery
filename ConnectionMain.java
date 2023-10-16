import java.lang.reflect.Type;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Userexample>>() {}.getType();
        List<Userexample> lista = gson.fromJson(txtJson, type);

        // Utiliza un conjunto para almacenar userId únicos
        Set<Integer> uniqueUserIds = new HashSet<>();

        for (Userexample user : lista) {
            uniqueUserIds.add(user.getUserId());
        }

        for (int userId : uniqueUserIds) {
            System.out.println("userId = " + userId);
            for (Userexample user : lista) {
                if (user.getUserId() == userId) {
                    System.out.println(user.getId());
                }
            }
        }
    }
}

