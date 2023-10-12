import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson=con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);
        Type type = new TypeToken<List<UserExample>>() {}.getType(); 
        List<UserExample> lista = gson.fromJson(txtJson, type);
        System.out.println("numero de registros: " + lista.size());

        for(UserExample user : lista){
            System.out.println(user.getUserId());
        }        
    }
}