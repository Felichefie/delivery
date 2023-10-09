

import java.util.List;

import com.google.gson.Gson;
public class ConnectionMain {
    public static void main(String[] args){
        Conexion  con = new Conexion();
        String txtJson = con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        List<UserExample> lista = gson.fromJson(txtJson, List.class);
        System.out.println("numero de registros = " + lista.size());

        for(UserExample user: lista){
            System.out.println(user.getId());
        }


        
    }
    
}

