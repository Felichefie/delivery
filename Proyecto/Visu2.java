package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Visu2 {
    public static void main(String[] args) {
        Connection conexion;
        ResultSet resultado;

        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        int idUser = 154; // El id que quieres imprimir
        String query = "SELECT * FROM progra2.users WHERE id = " + idUser;
        String queryMaxId = "SELECT MAX(id) FROM progra2.users";

        try {
            conexion = DriverManager.getConnection(URL, user, pass);
            Statement statement = conexion.createStatement();
            resultado = statement.executeQuery(query);

            if (!resultado.next()) {
                System.out.println("ID no existente");
            } else {
                do {
                    System.out.println("");

                    // Columnas
                    System.out.println(resultado.getInt(1) // id
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
                } while (resultado.next());
            }

            resultado = statement.executeQuery(queryMaxId);
            if (resultado.next()) {
                int maxId = resultado.getInt(1);
                System.out.println("El ID máximo existente es: " + maxId);
                System.out.println("");
            }

            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}