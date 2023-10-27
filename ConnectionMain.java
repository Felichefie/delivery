import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class ConnectionMain {
      public static void main(String[] args){
        //Conexion con = new Conexion();
        //String txtJson = con.sendGet();

        User u = new User(1, 0, "titulo_texto", "este es el usario cero");
        
        String resJson;
        Serializar serial = new Serializar();
        resJson=serial.user(u);
        System.out.println(resJson);
        serial.userAdd(u);
        resJson=serial.lista_json();
        resJson=serial.lista_json();
        User u2 = new User(2, 0, "titulo_texto", "este es el usario uno"); 
         serial.userAdd(u2);
         resJson=serial.lista_json();
         System.out.println(resJson);




        /*Gson gson = new Gson();
        Type type = new TypeToken<List<UserExample>>(){}.getType();
        List<UserExample>lista=gson.fromJson(txtJson, type);
        System.out.println(lista.size());

        Hashtable<Integer,Integer>
          Idp = new Hashtable<Integer,Integer>();
          for(UserExample user: lista){
           // System.out.println(user.getId());
           
            int z = user.getUserId();
           Idp.put(z,z) ;
           
        }
        
        Enumeration <Integer> Idz = Idp.keys();
        while (Idz.hasMoreElements()) {
            Integer UserIdz = Idz.nextElement();
            System.out.println("UserId " + UserIdz);
          

        }

        List<Integer>listaIds; //= new ArrayList<Integer>();
        Hashtable<Integer, List<Integer>>
         Mapa = new Hashtable<Integer, List<Integer>>();
        
         //la llave del mapa es el userid y el valor del mapa es la lista de ids
         

        for(UserExample user: lista){
           // System.out.println(user.getId());
           
            int x = user.getUserId();
            int y = user.getId();
           
            listaIds = Mapa.get(x);
            if(listaIds==null){
                listaIds=new ArrayList<Integer>();
                Mapa.put(x,listaIds);
            }
            listaIds.add(y);
           //System.out.println("UserId "+x);
                       

                 


        }
        System.out.println(Mapa.size());
        Enumeration <Integer> Ids = Mapa.keys();
        while (Ids.hasMoreElements()) {
            Integer UserId = Ids.nextElement();
            
    
            

            System.out.println("UserId " + UserId
                               + " is: " + Mapa.get(UserId));
          


        }*/
        

        }
        
         
        }
    
