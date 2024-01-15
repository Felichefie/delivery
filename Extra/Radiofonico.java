package Extra;

import java.util.Scanner;

public class Radiofonico {

    public static String code2radio(String secuencia) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < secuencia.length(); i++) {
            char letra = Character.toUpperCase(secuencia.charAt(i)); //Recorrido letras
            resultado.append(obtenerLetra(letra));

            // Agrega una coma y un espacio después de cada palabra, excepto la última
            if (i < secuencia.length() - 1) {
                resultado.append(", ");
            }
        }

        return resultado.toString();
    }

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la secuencia de letras: ");
        String entradaUsuario = scanner.nextLine();

        String resultado = code2radio(entradaUsuario);
        System.out.println(resultado);

        scanner.close();
    }

    public static String obtenerLetra(char letra) {
        switch (letra) {
            case 'A':
                return "Alfa";
            case 'B':
                return "Bravo";
            case 'C':
                return "Charlie";
            case 'D':
                return "Delta";
            case 'E':
                return "Echo";
            case 'F':
                return "Foxtrot";
            case 'G':
                return "Golf";
            case 'H':
                return "Hotel";
            case 'I':
                return "India";
            case 'J':
                return "Juliett";
            case 'K':
                return "Kilo";
            case 'L':
                return "Lima";
            case 'M':
                return "Mike";
            case 'N':
                return "November";
            case 'O':
                return "Oscar";
            case 'P':
                return "Papa";
            case 'Q':
                return "Quebec";
            case 'R':
                return "Romeo";
            case 'S':
                return "Sierra";
            case 'T':
                return "Tango";
            case 'U':
                return "Uniform";
            case 'V':
                return "Victor";
            case 'W':
                return "Whiskey";
            case 'X':
                return "X-ray";
            case 'Y':
                return "Yankee";
            case 'Z':
                return "Zulu";
            default:
                // Si la letra no es reconocida, simplemente la agrega sin traducción
                return String.valueOf(letra);
        }
    }

}

