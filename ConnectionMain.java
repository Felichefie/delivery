

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.reflect.TypeToken;
public class ConnectionMain {
    int id;
    public static <Userexample, UserrId> void main(String[] args){
        Conexion  con = new Conexion();
        String txtJson = con.sendGet();
        //System.out.println(txtJson);
        Gson gson = new Gson();
        
        Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<UserExample> lista = gson.fromJson(txtJson, type);
        System.out.println("numero de registros = " + lista.size());

        System.out.println(txtJson);  //IMPRIME TODOS LOS DATOS DE LA LISTA
        System.out.println("ID 1: " + lista.get(userId));
        
        for(int userId=0; userId <=9; userId++){
            System.out.println("USER ID: " + userId);
        }
        Set<UserExample> conjunto = new HashSet<>(lista); //en conjunto para que no permita elementos duplicados
        for(UserExample user: lista){
            conjunto.add(user);                   
        }
        

        
    }
    
}

