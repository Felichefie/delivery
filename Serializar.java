import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Serializar {
    private List<TarjetaPanel> usersList;
    private Gson gson;

    Serializar(){
        gson=new Gson();
        usersList=new ArrayList<TarjetaPanel>();

    }
    void userAdd(TarjetaPanel userNew){
        usersList.add(userNew);

    }
    String user(TarjetaPanel u){
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
