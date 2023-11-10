import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        /*Conexion con = new Conexion();
        String txtJson=con.sendGet();*/
        //System.out.println(txtJson);

        User u=new User(1, 0, "titulo texto", "usuario 0");
        String resJson;
        Serializar serial=new Serializar();
        resJson=serial.user(u);
        System.out.println(resJson);
        serial.userAdd(u);
        resJson=serial.lista_json();
        System.out.println(resJson);
        User u2=new User(2, 1, "titulo texto 2", "usuario 1");
        serial.userAdd(u2);
        resJson=serial.lista_json();
        System.out.println(resJson);


        /*Gson gson = new Gson();
        List<Userexample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("numero de registros: " + lista.size());

        for(Userexample user :lista){
            System.out.println(user.getId());
        }*/
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

