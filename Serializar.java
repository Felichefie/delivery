import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;


public class Serializar {
    private List<UserExample> usersList; 
    private Gson gson;

    Serializar(){
        gson = new Gson();
        usersList = new ArrayList<UserExample>();
    }

void userAdd (UserExample newUser){
    usersList.add(newUser);}


   String user(UserExample u){
        String res;
        res = gson.toJson(u);
        return res;
   }
     
    String lista_json(){
        String res;
        res = gson.toJson(usersList);
        return res; 
    }
}


