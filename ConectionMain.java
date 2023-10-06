import java.util.List;

import com.google.gson.Gson;

public class ConectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        System.out.println(txtJson);

        Gson gson = new Gson();
        List<UserExample> objectsUserExample = gson.fromJson(txtJson, List.class);

        System.out.println(objectsUserExample.size());

    }
}
