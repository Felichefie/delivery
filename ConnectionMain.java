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
        List<Integer> userIds = new ArrayList<>();
        List<List<Integer>> idLists = new ArrayList<>();
        
        for(UserExample user : lista){
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