package Extra;

import java.util.Scanner;

public class RadioDecoding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cadena de palabras del alfabeto radiofónico:");
        String input = scanner.nextLine();

        System.out.println(deco2radio(input));

        scanner.close();
    }

    public static String deco2radio(String cadena) {
        String[] palabras = cadena.split(", ");
        char[] resultado = new char[palabras.length];

        for (int i = 0; i < palabras.length; i++) {
            resultado[i] = obtenerLetra(palabras[i]);
        }

        return new String(resultado);
    }

    public static char obtenerLetra(String palabra) {
        switch (palabra) {
            case "Alfa":
                return 'A';
            case "Bravo":
                return 'B';
            case "Charlie":
                return 'C';
            case "Delta":
                return 'D';
            case "Echo":
                return 'E';
            case "Foxtrot":
                return 'F';
            case "Golf":
                return 'G';
            case "Hotel":
                return 'H';
            case "India":
                return 'I';
            case "Juliett":
                return 'J';
            case "Kilo":
                return 'K';
            case "Lima":
                return 'L';
            case "Mike":
                return 'M';
            case "November":
                return 'N';
            case "Oscar":
                return 'O';
            case "Papa":
                return 'P';
            case "Quebec":
                return 'Q';
            case "Romeo":
                return 'R';
            case "Sierra":
                return 'S';
            case "Tango":
                return 'T';
            case "Uniform":
                return 'U';
            case "Victor":
                return 'V';
            case "Whiskey":
                return 'W';
            case "X-ray":
                return 'X';
            case "Yankee":
                return 'Y';
            case "Zulu":
                return 'Z';
            default:
                return ' ';
        }
    }
}

