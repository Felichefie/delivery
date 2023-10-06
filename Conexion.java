import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts/1";
    private static final String METHOD_HTTP_GET = "GET";
    HttpURLConnection conection;

    Conexion(){
        try {

            URL object_url = new URL(URL_GET);
            conection = (HttpURLConnection) object_url.openConnection();
            conection.setRequestMethod(METHOD_HTTP_GET);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    String sendGet(){
        int response;
        String res = "";
        try {
            response = conection.getResponseCode();
            System.out.println(response);

            BufferedReader br = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            String line;

            do{
                line = br.toString();
                //res = res + line;
                res += line;
                //System.out.println(line);
            }while(br.readLine() != null);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
