import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Distancia {
    
    private Address address;

    private static final String MAPS_GET = "https://maps.googleapis.com/maps/api/distancematrix/json";

    // coloquen su propia API key, esta está incompleta !!!!!
    private static final String API_KEY_MAP_STRING = "AIzaSyCIJxbs3HWrKXxClHVhD-2lmbScrWeJYQU";
    
    private static final String METHOD_HTTP_GET = "GET";
    HttpURLConnection connection;

    Distancia(String type, Address address){
        this.address = address;
        String origin = "";
        String destination = "";
        try{
            origin = URLEncoder.encode("Universidad Michoacana de San Nicolás de Hidalgo Avenida Francisco J. Múgica,Morelia,MX", "UTF-8");
            destination = URLEncoder.encode(address.getNumber() + " " + address.getStreet() + ",Morelia,MX", "UTF-8");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String URL_MAPS_GET =  MAPS_GET + "?destinations=" + destination + "&origins=" + origin + "&key=" + API_KEY_MAP_STRING;
        System.out.println(URL_MAPS_GET);    
        try {
            if(type==METHOD_HTTP_GET){
                URL object_url = new URL(URL_MAPS_GET);
                //URL object_url = new URL(URL);
                connection = (HttpURLConnection) object_url.openConnection();
                connection.setRequestMethod(METHOD_HTTP_GET);
            }
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
            response = connection.getResponseCode();
            //System.out.println(response);

            BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = br.readLine()) != null){
                res += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    String sendPut(){
        String res="";
        
        return res;
    }
}