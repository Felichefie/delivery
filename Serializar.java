import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Serializar {
    private List<User> usersList;
    private Gson gson;

    Serializar(){
        gson=new Gson();
        usersList=new ArrayList<User>();

    }
    void userAdd(User userNew){
        usersList.add(userNew);

    }
    String user(User u){
        String res;
        res=gson.toJson(u);
        return res;
    }
    String lista_json(){
        String res;
        res=gson.toJson(usersList);
         return res;

    }
}
