import java.util.List;
import com.google.gson.Gson;


public class Serializar{
    //crear varios objetos del tipo user 
    private List<User> usersList;
   // private User user1, user2, user3; //son las propiedades
    private Gson gson;
    //Constructor, metodo constructor
    Serializar(){
    gson = new Gson();
    }
    void UserAdd(User userNew){
        usersList.add(userNew);
    }
    //metodo
    String user(User u){
        //crear un objeto de tipo string
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



