/* 
 * El programa te pedira un email o un numero de telefono para buscar un usuario en la base de datos,
 *  una vez encontrado te mostrara los datos del usuario y su direccion si es que la tiene registrada.
 */

import java.util.Scanner;

public class ConnectionMain {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://clase-progra2.cii6bjvpag5z.us-east-2.rds.amazonaws.com";
        String user = "alumno";
        String pass = "alumnoPrueba1";

        Dbconnection dbConn = new Dbconnection(URL, user, pass);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un email o numero de telefono:");
            String input = scanner.nextLine();

            User userResult = dbConn.getUser(input, input);

            if (userResult != null) {
                System.out.println("Usuario encontrado:");
                System.out.println("ID: " + userResult.getId());
                System.out.println("Nombre de usuario: " + userResult.getUserName());
                Address userAddress = dbConn.getAddress(userResult.getId());
                if (userAddress != null) {
                    System.out.println("\nDireccion encontrada:");
                    System.out.println("ID de usuario: " + userAddress.getId_user());
                    System.out.println("Calle: " + userAddress.getStreet());
                    System.out.println("Numero: " + userAddress.getNumber());
                } else {
                    System.out.println("\nDireccion no encontrada para este usuario.");
                }
            } else {
                System.out.println("Usuario no encontrado.");
            }
        }

        dbConn.closeConnection();
    }
}
