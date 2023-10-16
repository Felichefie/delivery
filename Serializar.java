import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson; 

public class Serializar {
    private List<User>usersList;
    private Gson gson;

    Serializar(){
        gson = new Gson();
        usersList = new ArrayList<User>();

    }

    void userAdd(User newUser){
        usersList.add(newUser);

    }

    String userSerial(User u){
        String res;
        res = gson.toJson(u);

        return res;
    }

    String list_maker(){
        String res;
        res = gson.toJson(usersList);
        
        return res;
    }
    
}
