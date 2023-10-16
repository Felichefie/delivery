import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("numero de registros: " + lista.size());


        //------------------------------------------------------------------------
        List<Integer> IdsUnicos = new ArrayList<Integer>();

        for (Userexample uex : lista) {
            if(!IdsUnicos.contains(uex.getUserId() ) )
            IdsUnicos.add(uex.getUserId());
        }
        System.out.println("userId" + IdsUnicos.toString());

        List<Integer> listado;

        for(Integer id : IdsUnicos)
        {
            listado = new ArrayList<Integer>();
            for(Userexample userX : lista)
            {
                if(id.equals(userX.getUserId()))
                listado.add(userX.getId());
            }
            System.out.println("listado para id: " + id);
            System.out.println(listado);
        }

        }        
    }
