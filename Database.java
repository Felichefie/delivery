import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Database {
    public static void main(String[] args) {
        ResultSet resultSet = null;
        Connection conn = null;
        final String URL = "clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        final String dataBase = "progra2";
        final String user = "alumno";
        final String password = "alumnoPrueba1";

        final String insertSql = "INSERT INTO users (first_lastname, second_lastname, name) VALUES "
                + "('Dessiré', 'López', 'Monica');";

        try {
             conn = DriverManager.getConnection("jdbc:mysql://"
                + URL + "/" + dataBase + "?"
                + "user=" + user + "&" + "password=" + password);

            Statement statement = conn.createStatement();
            String selectSql = "SELECT * FROM users;";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getObject("id")
                    + " " + resultSet.getObject("first_lastname")
                    + " " + resultSet.getString(3)
                    + " " + resultSet.getString(4));
            }

            /*
            PreparedStatement prepsInsertProduct = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            resultSet = prepsInsertProduct.getGeneratedKeys();

            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
            */
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}