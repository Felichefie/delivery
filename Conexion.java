import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Conexion {
    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts/1";
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
        String res = "";
        int response;
        try {
            response = connection.getResponseCode();
            System.out.println(response);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            do {
                line = br.toString();
                // System.out.println(line); Yano sirve porque ya se guardo en res
                // res = res + line; Significa lo mismo que lo de arriba
                res += line;
            } while (br.readLine() != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
