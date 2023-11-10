import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        /*Conexion con = new Conexion();
        String txtJson=con.sendGet();
        System.out.println(txtJson);*/

        User u = new User(1, 0, "TituloTexto", "Cuerpo");
        String resJson;
        Serializar serial = new Serializar();
        resJson = serial.serialUser(u);
        System.out.print(resJson);
        serial.UserAdd(u);
        resJson = serial.listaJson();
        System.out.print(resJson);

        User u1 = new User(1, 1, "Otro Usuario", "Cuerpo2");
        resJson = serial.serialUser(u1);
        serial.UserAdd(u1);
        System.out.println(resJson);

        


        /*Gson gson = new Gson();


        List<Userexample> lista= gson.fromJson(txtJson, List.class);
        Type type =new TypeToken<List<Userexample>>() {}.getType();
        List<Userexample> lista = gson.fromJson(txtJson, type);
        System.out.println(lista.size());
        System.out.println("numero de registro:" + lista.size());

        for(Userexample user : lista) {
            System.out.println ("USER ID: " + user.getUserId());
            System.out.println ("ID: " + user.getId());*/

        }
    }
