import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        Gson gson = new Gson();
        Type type = new TypeToken<List<UserExample>>() {}.getType(); 
        List<UserExample> lista = gson.fromJson(txtJson, type);
        System.out.println("Número de registros: " + lista.size());

        
        List<Integer> UserIdUnicos = new ArrayList<>();
        List<List<Integer>> userIdsAndIds = new ArrayList<>();

        //recorre cada elemento de "Lista" que esta en User Example y asigna nombre a la variable user.
        for (UserExample user : lista) {
            int userId = user.getUserId();
            int id = user.getId();

            // Si el userId no está en la lista IdsUnicos, lo agrega.
            if (!UserIdUnicos.contains(userId)) {
                UserIdUnicos.add(userId);
                List<Integer> idsFromUser = new ArrayList<>();
                idsFromUser.add(id);
                userIdsAndIds.add(idsFromUser);
            } else {
                // si el userId ya esta en la lista de IdsUnicos no lo agrega. agrega un Id a la lista de Id asociado a un UserId.
                int index = UserIdUnicos.indexOf(userId);
                userIdsAndIds.get(index).add(id);
            }
        }
        System.out.println("UserIds diferentes: " + UserIdUnicos); //imprime los diferentes UserId que esta almacenado en la variable UserIdUnicos.
        for (int i = 0; i < UserIdUnicos.size(); i++) {
            int userId = UserIdUnicos.get(i);
            List<Integer> ids = userIdsAndIds.get(i);
            System.out.println("userId = " + userId + ", id" + ids);
        }
    }
}
