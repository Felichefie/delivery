import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson=con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);
        Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<Userexample> lista = gson.fromJson(txtJson, type);
        System.out.println("NUMERO DE REGISTROS: " + lista.size());

       // for(Userexample user : lista){
         //   System.out.println("USER ID: " + user.getUserId());

           // System.out.println("ID: " + user.getId());

        //.....PARTE PARA OBTENER SOLO LOS USER-ID DIFERENTES Y LOS ID'S DE CADA USER-ID.....//

                List<Integer> IU = new ArrayList<Integer>();

        for (Userexample uexa : lista) {
            if(!IU.contains(uexa.getUserId() ) )
            IU.add(uexa.getUserId());
        }
        System.out.println("\nLOS USER-ID (DISTINTOS) SON: " + IU.toString());

        List<Integer> listado;

        for(Integer id : IU)
        {
            listado = new ArrayList<Integer>();
            for(Userexample userM : lista)
            {
                if(id.equals(userM.getUserId()))
                listado.add(userM.getId());
            }
            System.out.println("\nLISTA DE ID'S DEL USER-ID: " + id);
            System.out.println(listado);
        }        
    }

}


