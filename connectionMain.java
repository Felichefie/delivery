import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        // System.out.println(txtJson);
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);

        Type type = new TypeToken<List<User_example>>() {
        }.getType();
        List<User_example> lista = gson.fromJson(txtJson, type);
        System.out.println("numero de registros: " + lista.size());

        Set<Integer> uniqueUserIds = new HashSet<>();

        for (User_example user : lista) {
            // Si el userId no está en el set, lo añade y lo imprime.
            if (uniqueUserIds.add(user.getUserId())) {
                System.out.println("UserID:" + user.getUserId());
            }
            System.out.println(user.getId());

        }
    }
}