import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
       // System.out.println(txtJson);

        Gson gson = new Gson();
        Type type = new TypeToken<List<UserExample>>() {}.getType();
        List<UserExample> objectsUserExample = gson.fromJson(txtJson, type);

        System.out.println("Numero de registros: " + objectsUserExample.size());
        int aux = 0;
        for(UserExample objeto : objectsUserExample){
            if(objeto.getUserId() != aux){
                System.out.print("User Id = " + objeto.getUserId());
                System.out.print(" Id = [");
                aux = objeto.getUserId();
                for(UserExample objeto2 : objectsUserExample){
                    if(objeto.getUserId() == objeto2.getUserId())
                    System.out.print(objeto2.getId() + ", ");
                }
                System.out.println("]");
            } 
        }
            //imprimir solo userId diferentes
            //imprimir los id que perteneen a los Id diferentes
            //user ID = 1 ids[1,2,3,4,5]
            //user ID = 2 ids[6,7]
            //user ID = 3 ids[8,9,10,11,12]
        
    }
}
