import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.xdevapi.JsonString;



public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion("GET");
        String txtJson=con.sendGet();


        System.out.println(txtJson);
        
        JsonParser parser; //= new JsonParser();

        // Obtain 
        JsonElement jsonelement = JsonParser.parseString(txtJson);
        JsonObject jsonobject = jsonelement.getAsJsonObject();

        JsonElement dest = jsonobject.get("destination_addresses");
        JsonArray destinos = dest.getAsJsonArray();
        for (JsonElement d : destinos) {
            // Object of array
            String sdire = d.getAsString();
            System.out.println(sdire);
        }

        JsonElement orig = jsonobject.get("origin_addresses");
        JsonArray origenes = orig.getAsJsonArray();
        for (JsonElement o : origenes) {
            // Object of array
            String sorig = o.getAsString();
            System.out.println(sorig);
        }

        JsonElement row = jsonobject.get("rows");

        JsonArray rows = row.getAsJsonArray();
         for (JsonElement r : rows) {
            // Object of array
            JsonObject er = r.getAsJsonObject();
            JsonElement dd = er.get("elements");
            JsonArray e = dd.getAsJsonArray();
            for(JsonElement el : e){
             JsonObject dist = el.getAsJsonObject();
             JsonElement j = dist.get("distance");
             JsonObject k = j.getAsJsonObject();
             JsonElement l = k.get("text");
             System.out.println(l);

             JsonElement j1 = dist.get("duration");
             JsonObject k1 = j1.getAsJsonObject();
             JsonElement l1 = k1.get("text");
             System.out.println(l1);



            }
           // JsonObject distance = e.getAsJsonObject();
            /*for(JsonElement e  : elements ){
               JsonObject distancia = e.getAsJsonObject();

            }*/
            //System.out.println(srow);
        }

        /*JsonElement orig = jsonobject.get("origin_addresses");
        JsonArray origenes = orig.getAsJsonArray();

        JsonElement row = jsonobject.get("rows");
        JsonArray  rows = row.getAsJsonArray();

        JsonElement element = jsonobject.get("elements");
        JsonArray  rows = row.getAsJsonArray();*/



        // for each element of array
        
        
         /* 
            // Primitives elements of object
            
            JsonArray destination_addresses = gsonObj.get("destination_addresses").getAsJsonArray();
             List listdestination = new ArrayList();
            for (JsonElement dest : destination_addresses) {
                listdestination.add(dest.getAsString());
            }
            JsonArray origin_addresses = gsonObj.get("origin_addresses").getAsJsonArray();
             List listorigin = new ArrayList();
            for (JsonElement origin : origin_addresses) {
                listorigin.add(origin.getAsString());
            }
            JsonArray rows = gsonObj.get("rows").getAsJsonArray();
             List listrows = new ArrayList();
            for (JsonElement row : rows) {
                listrows.add(row.getAsString());
            }
            System.out.println(destination_addresses);
            System.out.println(origin_addresses);
            System.out.println(rows);
            //String name = gsonObj.get("name").getAsString();
           // String team = gsonObj.get("team").getAsString();

            // List of primitive elements
            */
        
    }
}
        /*
        Gson gson = new Gson();
        // List<Userexample> lista = gson.fromJson(txtJson, List.class);
        Type type = new TypeToken<List<Userexample>>() {}.getType(); 
        List<Userexample> lista = gson.fromJson(txtJson, type);
        System.out.println("numero de registros: " + lista.size());

        for(Userexample user : lista){
            System.out.println(user.getUserId());
        }*/       
    //}
//}


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