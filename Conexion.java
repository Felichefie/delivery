import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Identity;

import javax.imageio.stream.ImageInputStream;

public class Conexion {

    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    private static final String METHOD_HTTP_GET = "GET";
    HttpURLConnection connection;

//CREAMOS EL CONSTRUCTOR.
    Conexion(){
        try{
            URL object_url = new URL(URL_GET);
            connection = (HttpURLConnection) object_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_GET);


        } catch (MalformedURLException e) {
            //TODO AUTO-GENERATED CATCH BLOCK.
            e.printStackTrace();
        } catch (IOException e) {
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

        do{
            line = br.toString();
            //res = res + line;
            res += line;
            //System.out.println(line);
        }while(br.readLine() != null);
        res += line;
    }catch(IOException e){
        e.printStackTrace();
    }
    return res;
}
}
