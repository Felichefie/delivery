import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class ConnectionMain {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
       String txtJson=conexion.sendGet();
        //System.out.println(txtJson);// para ver el los datos

        Gson gson = new Gson();
        
        /*List<Userexample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("lista de registros: " + lista.size());// para ver el numero de datos que llegan

        for(Userexample user:lista){
           System.out.println(user.getUserId());
           //imprimir solo los ID difetentes
           //imprimir los Id que pertenecia a los Id diferente*/ // lo que ya no me sirve para las id
Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<Userexample> lista = gson.fromJson(txtJson, type);
        List<Integer> userIds = new ArrayList<>();
        List<List<Integer>> idLists = new ArrayList<>();
        
        for(Userexample user : lista){
         int userId = user.getUserId();
         int id = user.getId();
         int index = userIds.indexOf(userId);
           
            if(index == -1){
                userIds.add(userId);
                idLists.add(new ArrayList<Integer>());
                index = idLists.size() - 1;
            }
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