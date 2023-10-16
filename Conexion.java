import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {

    
    private static final String  URL_GET = " https://jsonplaceholder.typicode.com/posts";
    private static final String  URL_PUT = " https://jsonplaceholder.typicode.com/posts/1";
    private static final String METHOD_HTTP_GET = "GET";
    private static final String METHOD_HTTP_PUT = "PUT";
    HttpURLConnection connection;

    //CREA EL CONSTRUCTOR
    Conexion(String type){
        try{
            if(type == METHOD_HTTP_GET){
            URL object_url = new URL(URL_GET);
            connection = (HttpURLConnection) object_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_GET);
        }else{
            URL object_url = new URL(URL_PUT);
            connection = (HttpURLConnection) object_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_PUT);

        }

        }catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   
String sendGet(){
    int response;
    String res = "";
    try {
        response = connection.getResponseCode();
        System.out.println(response);
        BufferedReader br = new BufferedReader( new InputStreamReader(connection.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            res += line;
        } 


    }catch(IOException e ){
        e.printStackTrace();
    }
    return res;
}


String sendPut(){

    String res = "";
    
}


}
