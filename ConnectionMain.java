import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson=con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);
        Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<Userexample> lista = gson.fromJson(txtJson, type);
        //System.out.println("numero de registros: " + lista.size());

        List<Integer> userIds = new ArrayList<>();
        List<List<Integer>> idLists = new ArrayList<>();
        
        for(Userexample user : lista){
            int userId = user.getUserId();
            int id = user.getId();
            // Revisa si el userId ya existe en la lista
            int index = userIds.indexOf(userId);
            // Si no existe, agrega el userId a la lista de userIds y crea una nueva lista de ids
            if(index == -1){
                userIds.add(userId);
                idLists.add(new ArrayList<Integer>());
                // Actualiza el index del ultimo elemento
                index = idLists.size() - 1;
            }
            // Si existe, obtiene la lista de userids y agrega el id
            idLists.get(index).add(id);
        }
        
        System.out.println("userId" + userIds.toString());
        
        for(int i = 0; i < userIds.size(); i++){
            int userId = userIds.get(i);
            List<Integer> ids = idLists.get(i);
            System.out.println("userId =" + userId + ", id" + ids.toString());
        }
    }
}
