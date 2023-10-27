
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    private static final String URL_PUT = "https://jsonplaceholder.typicode.com/posts/1";

    private  static final String METHOD_HTTP_GET = "GET";
    private  static final String METHOD_HTTP_PUT= "PUT";

    HttpURLConnection connection;

    Conexion(String type){
        try {
            if(type==METHOD_HTTP_GET){
            URL obj_url = new URL(URL_GET);
            connection = (HttpURLConnection) obj_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_GET);
        }
        else if(type==METHOD_HTTP_PUT){
            URL obj_url = new URL(URL_PUT);
            connection = (HttpURLConnection) obj_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_PUT);
        }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    String sendGet(){
        String res = "";
        try {
            int response = connection.getResponseCode();
           
             BufferedReader br = new BufferedReader( new InputStreamReader (connection.getInputStream()));
            String line;
            while ((line= br.readLine())!= null) {
                res+=line;
                
            } 

        } catch  (IOException e) {
            e.printStackTrace();
        }
        return res;
        
    }
    String sendPut(){
        String res="";
        return res;
    }
}




//esta clase solo nos conecta