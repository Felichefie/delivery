import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
       // Conexion con = new Conexion();
        //String txtJson = con.sendGet();

//CREAR UN OBJETO SERIALIZADO

    User u = new User(1, 0, "TituloTexto", "Cuerpo");
    String resJson;
    Serializar serial = new Serializar();
    resJson = serial.serialUser(u);
    System.out.print(resJson);
    serial.UserAdd(u);
    resJson = serial.listaJson();
    System.out.print(resJson);

    User u1 = new User(1, 1, "OTRO USUSARIO", "CUAERPO 2");
    resJson = serial.serialUser(u1);
    serial.UserAdd(u1);
    System.out.println(resJson);




       
    }
}
