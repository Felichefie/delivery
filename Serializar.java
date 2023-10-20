import java.util.List;

public class Serializar {
    private List <User> usersList;
    private User user1, user2, user3;

    /**
     * 
     */
    Serializar(){
        gson = newGson();
        usersList=new List<user>{}
    }
    void userAdd (User userNew){
        userList.add(userNew);
    }

    
    String user (User u){
        String res;
        res = gson.toJson(u);
        return res;
    }
    String todo (User u){
        String res;
        res=gson.toJson;
        return res;
    }
    String Lista_json(){
        String res;
        res=gson.toJson(usersList);

    }
}