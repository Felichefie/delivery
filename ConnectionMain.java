import java.util.List;
import com.google.gson.Gson;

public class ConnectionMain {
    public static void main(String[] args){
        Conexion con = new Conexion();
        String txtJson = con.sendGet();

        User u = new User(0, 0, "", "");
        String resJson;
        Serializar serial = new Serializar();
        resJson = serial.userSerial(u);
        System.out.println(resJson);
        serial.userAdd(u);
        resJson = serial.list_maker();
        System.out.println(resJson);

        User u2 = new User(2, 1, "", "");
        serial.userAdd(u2);
        resJson = serial.list_maker();
        System.out.println(resJson);

        Gson gson = new Gson();
        List<UserExample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("numero de registros:" + lista.size());

        for(UserExample user: lista){
            System.out.println(user.getUserId());
            //Imprimir solo usersId diferentes e imprimir los Id que pertenecen
            //a los Id diferentes// 
        }
    }
}
