import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion("GET");
        String txtJson = con.sendGet();

        JsonObject jsonObject = new Gson().fromJson(txtJson, JsonObject.class);

        // Extraer información de distancia y duración
        String distanceText = jsonObject.getAsJsonArray("rows")
                .get(0).getAsJsonObject()
                .getAsJsonArray("elements")
                .get(0).getAsJsonObject()
                .getAsJsonObject("distance")
                .get("text").getAsString();

        String durationText = jsonObject.getAsJsonArray("rows")
                .get(0).getAsJsonObject()
                .getAsJsonArray("elements")
                .get(0).getAsJsonObject()
                .getAsJsonObject("duration")
                .get("text").getAsString();

        // Imprime la información
        System.out.println("Distancia: " + distanceText);
        System.out.println("Duración: " + durationText);
        
        
    }
}