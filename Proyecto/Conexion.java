package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
    // private static final String URL_GET =
    // "https://jsonplaceholder.typicode.com/posts/1";
    private static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    private static final String URL_PUT = "https://jsonplaceholder.typicode.com/posts/1";

    // MAPS
    // https://maps.googleapis.com/maps/api/distancematrix/json?destinations=New%20York%20City%2C%20NY&origins=Washington%2C%20DC&key=YOUR_API_KEY
    private static final String MAPS_GET = "https://maps.googleapis.com/maps/api/distancematrix/json";

    // coloquen su propia API key, esta está incompleta !!!!!
    private static final String API_KEY_MAP_STRING = "AIzaSyCIJxbs3HWrKXxClHVhD-2lmbScrWeJYQU";

    String origin = "Morelia,%20Mexico";
    // "Vancouver%20BC%7CSeattle";
    // "New%20York%20City%20NY";
    String destination = "Uruapan,%20Mexico";
    // "San%20Francisco%7CVictoria%20BC";
    // "Washington%20DC";
    String URL_MAPS_GET;// = MAPS_GET + "?destinations=" + this.destino + "&origins=" + this.origen +
                        // "&key=" + API_KEY_MAP_STRING;

    private static final String METHOD_HTTP_GET = "GET";
    private static final String METHOD_HTTP_PUT = "PUT";
    HttpURLConnection connection;

    String origen, destino;

    Conexion(String type, String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        URL_MAPS_GET = MAPS_GET + "?destinations=" + this.destino + "&origins=" + this.origen + "&key="
                + API_KEY_MAP_STRING;
        System.out.println(this.destino);
        System.out.println(this.origen);

        System.out.println(URL_MAPS_GET);
        try {
            if (type == METHOD_HTTP_GET) {
                // URL object_url = new URL(URL_GET);
                URL object_url = new URL(URL_MAPS_GET);
                // URL object_url = new URL(URL);
                connection = (HttpURLConnection) object_url.openConnection();
                connection.setRequestMethod(METHOD_HTTP_GET);
            } else {
                URL object_url = new URL(URL_PUT);
                connection = (HttpURLConnection) object_url.openConnection();
                connection.setRequestMethod(METHOD_HTTP_PUT);
            }
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

    String sendPut() {
        String res = "";

        return res;
    }
}// a