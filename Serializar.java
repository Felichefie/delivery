import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Serializar {
    
    private List<UserExample> usersList;
    private Gson gson;

    Serializar(){

        usersList = new ArrayList<UserExample>();
        gson = new Gson();

    }
    
    void userAdd(UserExample newUser){

        usersList.add(newUser);

    }

    String serialUser(UserExample u){
        //Gson gson = new Gson();
        String res = gson.toJson(u);
        
        return res;
    }

    String lista_json(){
        String res;
        //Gson gson = new Gson();
        res = gson.toJson(usersList);

        return res;
    }

}
