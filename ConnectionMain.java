import java.awt.Component;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mysql.cj.xdevapi.JsonString;


public class ConnectionMain {
   //ArrayList<String> a = new ArrayList<String>();
   String d;
   String time;

  
    public ConnectionMain(String origen, String destino) {
        Conexion con = new Conexion("GET",origen,destino);
        String txtJson=con.sendGet();
        //System.out.println(txtJson);
        
        JsonParser parser; //= new JsonParser();

        // Obtain 
        JsonElement jsonelement = JsonParser.parseString(txtJson);
        JsonObject jsonobject = jsonelement.getAsJsonObject();
         
        JsonElement dest = jsonobject.get("destination_addresses");
        JsonArray destinos = dest.getAsJsonArray();
        for (JsonElement d : destinos) {
            // Object of array
            String sdire = d.getAsString();
            //System.out.println(sdire);
        }

        JsonElement orig = jsonobject.get("origin_addresses");
        JsonArray origenes = orig.getAsJsonArray();
        for (JsonElement o : origenes) {
            // Object of array
            String sorig = o.getAsString();
           // System.out.println(sorig);
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
               d = l.getAsString();
             JsonElement j1 = dist.get("duration");
             JsonObject k1 = j1.getAsJsonObject();
             JsonElement l1 = k1.get("text");
               time = l1.getAsString();
            }
         
          
        }
       
        

    }
 

  public String getd(){
   return d;
  }
  public String gettime(){
   return time;
  }
  
 
  
}
     

