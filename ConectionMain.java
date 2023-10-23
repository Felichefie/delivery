import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        Gson gson = new Gson();
        Type type = new TypeToken<List<UserExample>>() {}.getType(); 
        List<UserExample> lista = gson.fromJson(txtJson, type);
        System.out.println("Número de registros: " + lista.size());

        // Lista para almacenar los userId diferentes
        List<Integer> diferentesUserIds = new ArrayList<>();

        // Lista de listas para almacenar los id correspondientes a cada userId
        List<List<Integer>> userIdsAndIds = new ArrayList<>();

        for (UserExample user : lista) {
            int userId = user.getUserId();
            int id = user.getId();

            // Si el userId no está en la lista diferentesUserIds, agregarlo y crear una nueva lista para ese userId
            if (!diferentesUserIds.contains(userId)) {
                diferentesUserIds.add(userId);
                List<Integer> idsForUser = new ArrayList<>();
                idsForUser.add(id);
                userIdsAndIds.add(idsForUser);
            } else {
                // Si el userId ya está en la lista distinctUserIds, encontrar la lista correspondiente y agregar el id a esa lista
                int index = diferentesUserIds.indexOf(userId);
                userIdsAndIds.get(index).add(id);
            }
        }

        System.out.println("UserIds diferentes: " + diferentesUserIds);

        // Imprimir los userId y sus id correspondientes
        for (int i = 0; i < diferentesUserIds.size(); i++) {
            int userId = diferentesUserIds.get(i);
            List<Integer> ids = userIdsAndIds.get(i);
            System.out.println("userId = " + userId + ", id" + ids);
        }
    }
}
