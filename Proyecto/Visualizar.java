package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//
public class Visualizar {
    public static void main(String[] args) {
        Connection conexion;
        ResultSet resultado;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.users";
        // String queryInsert = "INSERT INTO progra2.address(id_user, street, number,
        // number_two, neighborhood, city, state, country, postal_code, gps_lat,
        // gps_lon)";

        try {
            conexion = DriverManager.getConnection(URL, user, pass);
            Statement statement = conexion.createStatement();
            resultado = statement.executeQuery(query);

            while (resultado.next()) {
                // Columnas
                System.out.println(resultado.getInt(1) // id_user
                        + " " + resultado.getString(2) // type_user
                        + " " + resultado.getString(3) // user_name
                        + " " + resultado.getString(4) // first_lastname
                        + " " + resultado.getString(5) // second_lastname
                        + " " + resultado.getString(6) // name
                        + " " + resultado.getDate(7) // birthday
                        + " " + resultado.getString(8) // email
                        + " " + resultado.getString(9) // gender
                        + " " + resultado.getString(10)// phone_number
                        + " " + resultado.getString(11)// password
                        + " " + resultado.getDate(12) // created
                );
            }
            // Escriben en la base de dato, como estan comentadas, solo lee
            // PreparedStatement prepState = conn.prepareStatement(queryInsert);
            // prepState.execute();

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}