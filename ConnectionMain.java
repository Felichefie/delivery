import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion("GET");
        String txtJson=con.sendGet();


        System.out.println(txtJson);
        
        /* 
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);
        Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<Userexample> lista = gson.fromJson(txtJson, type);
        System.out.println("numero de registros: " + lista.size());

        for(Userexample user : lista){
            System.out.println(user.getUserId());
        }*/       
    }
}


// tipo de JSON de MAPS, de este hay que construir el objeto para poder
// leer los datos
/*
 {
   "destination_addresses" : 
   [
      "Washington D. C., Distrito de Columbia, EE. UU."
   ],
   "origin_addresses" : 
   [
      "Nueva York, EE. UU."
   ],
   "rows" : 
   [
      {
         "elements" : 
         [
            {
               "distance" : 
               {
                  "text" : "364 km",
                  "value" : 363636
               },
               "duration" : 
               {
                  "text" : "3 h 51 min",
                  "value" : 13864
               },
               "status" : "OK"
            }
         ]
      }
   ],
   "status" : "OK"
}
 */