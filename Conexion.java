import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    private static final String METHOD_HTTP_GET = "GET";
    HttpURLConnection connection;

    Conexion() {
        try {
            URL object_url = new URL(URL_GET);
            connection = (HttpURLConnection) object_url.openConnection();
            connection.setRequestMethod(METHOD_HTTP_GET);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String sendGet() {
        int response;
        String res = "";
        try {
            response = connection.getResponseCode();
            // System.out.println(response);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                res += line;
            }
            // System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}