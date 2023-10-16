import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Serializar {
    private List<UserExample> usersList;
    private Gson gson;

    // Constructor
    Serializar() {
        gson = new Gson();
        usersList = new ArrayList<UserExample>();
    }

    String User(UserExample u) {
        String res;
        res = gson.toJson(u);
        return res;
    }

    void userAdd(UserExample newUser) {
        usersList.add(newUser);
    }

    String lista_json() {
        String res;
        res = gson.toJson(usersList);
        return res;
    }
}
