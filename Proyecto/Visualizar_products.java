package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Visualizar_products {
    public static void main(String[] args) {
        Connection conexion;
        ResultSet resultado;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.products";

        try {
            conexion = DriverManager.getConnection(URL, user, pass);
            Statement statement = conexion.createStatement();
            resultado = statement.executeQuery(query);

            while (resultado.next()) {
                // Columnas
                System.out.println(resultado.getInt(1) // id
                        + " " + resultado.getDouble(2) // price
                        + " " + resultado.getString(3) // image
                        + " " + resultado.getString(4) // description
                        + " " + resultado.getDouble(5) // size_x
                        + " " + resultado.getDouble(6) // size_y
                        + " " + resultado.getDouble(7) // size_z
                      //  + " " + resultado.getTimestamp(8) // created // no puedo imprimir :(
                );
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}