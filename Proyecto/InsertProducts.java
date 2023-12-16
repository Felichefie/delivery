package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProducts {
    // Estos son los detalles de tu base de datos
    private static final String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
    private static final String USER = "alumno";
    private static final String PASS = "alumnoPrueba1";

    // Este método inserta un producto en la base de datos
    public void insertProduct(java.sql.Date created, String description, String image, double price, double size_x,
            double size_y, double size_z, int stock) {
        // Esta es la consulta SQL que insertará el producto
        String query = "INSERT INTO progra2.products (created, description, image, price, size_x, size_y, size_z, stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Aquí se establece la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            // Aquí se prepara la consulta SQL
            PreparedStatement statement = conexion.prepareStatement(query);
            // Aquí se establecen los valores de los parámetros de la consulta SQL
            statement.setDate(1, created);
            statement.setString(2, description);
            statement.setString(3, image);
            statement.setDouble(4, price);
            statement.setDouble(5, size_x);
            statement.setDouble(6, size_y);
            statement.setDouble(7, size_z);
            statement.setInt(8, stock);

            // Aquí se ejecuta la consulta SQL y se inserta el producto
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Un nuevo producto fue insertado exitosamente!");
            }

            // Aquí se cierra la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            // Si hay un error al insertar el producto, se imprime el error
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crear una instancia de InsertProducts
        InsertProducts inserter = new InsertProducts();

        // Crear los detalles del producto
        java.sql.Date created = java.sql.Date.valueOf("2022-01-01");
        String description = "Cigarros Marlboro rojo:";
        String image = "https://grupoelvalor.com/wp-content/uploads/2018/12/marlboro-14.png";
        double price = 75;
        double size_x = 2;
        double size_y = 10;
        double size_z = 4;
        int stock = 148;

        // Insertar el producto
        inserter.insertProduct(created, description, image, price, size_x, size_y, size_z, stock);
    }
}