import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
       // Conexion con = new Conexion();
        //String txtJson = con.sendGet();

//CREAR UN OBJETO SERIALIZADO
    User u = new User(1, 0, "TituloTexto", "Cuerpo");
    String resJson;
    Serializar serial = new Serializar();
    resJson = serial.serialUser(u);
    System.out.print(resJson);
    serial.UserAdd(u);
    resJson = serial.listaJson();
    System.out.print(resJson);

    User u1 = new User(1, 1, "OTRO USUSARIO", "CUAERPO 2");
    resJson = serial.serialUser(u1);
    serial.UserAdd(u1);
    System.out.println(resJson);




         /* 
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
        }*/
    }
}
