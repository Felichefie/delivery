import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Serializar {
    private List <User> usersList;
    //private User user1, user2, user3;
    private Gson gson;

    /**
     * 
     */
    Serializar(){
        gson = new Gson();
        usersList=new ArrayList<User>();
    }
    void UserAdd (User userNew){
        usersList.add(userNew);
    }

    String serialUser(User u){
        String result;
        result = gson.toJson(u);
        return result;
    }
    
    /*String user (User u){
        String res;
        res = gson.toJson(u);
        return res;
    }
    String todo (User u){
        String res;
        res=gson.toJson;
        return res;
    }/* */

    String listaJson(){
        String result;
        result=gson.toJson(usersList);
        return result;

    }
}