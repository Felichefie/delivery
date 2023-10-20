import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Serializar {
    private List<Userexample> usersList;
    private Gson gson;

    // Constructor
    Serializar() {
        gson = new Gson();
        usersList = new ArrayList<Userexample>();
    }

    String User(Userexample u) {
        String res;
        res = gson.toJson(u);
        return res;
    }

    void userAdd(Userexample newUser) {
        usersList.add(newUser);
    }

    String lista_json() {
        String res;
        res = gson.toJson(usersList);
        return res;
    }
}


