package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Visualizar_sessions {
    public static void main(String[] args) {
        Connection conexion;
        ResultSet resultado;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        String query = "SELECT * FROM progra2.sessions";

        try {
            conexion = DriverManager.getConnection(URL, user, pass);
            Statement statement = conexion.createStatement();
            resultado = statement.executeQuery(query);

            while (resultado.next()) {
                // Columnas
                System.out.println(resultado.getInt(1) // id
                        + " " + resultado.getInt(2) // id_user
                        + " " + resultado.getString(3) // session
                        + " " + resultado.getTime(4) // timeout
                        + " " + resultado.getTime(5) // created
                );
            }
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}