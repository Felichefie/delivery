package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisualizarTablaProducts {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.products";

        try {
            Connection conexion = DriverManager.getConnection(URL, user, pass);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()) {
                java.sql.Date created = resultado.getDate("created");
                String description = resultado.getString("description");
                int id = resultado.getInt("id");
                String image = resultado.getString("image");
                double price = resultado.getDouble("price");
                double size_x = resultado.getDouble("size_x");
                double size_y = resultado.getDouble("size_y");
                double size_z = resultado.getDouble("size_z");
                int stock = resultado.getInt("stock");

                System.out.println("Created: " + created + ", ID: " + id + ", Description: " + description
                        + ", Image: " + image + ", Price: " + price + ", Size X: " + size_x + ", Size Y: " + size_y
                        + ", Size Z: " + size_z + ", Stock: " + stock);
            }

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}