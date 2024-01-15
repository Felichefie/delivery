package Extra;

import java.util.Scanner;

public class JuegoLudico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa una palabra o frase:");
        String entrada = scanner.nextLine();

        String resultado = jugar(entrada);
        System.out.println("Resultado: " + resultado);

        scanner.close();
    }

    public static String jugar(String entrada) {
        StringBuilder resultado = new StringBuilder();
        char[] caracteres = entrada.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            char letra = caracteres[i];

            if (esVocal(letra)) {
                resultado.append(letra).append('p').append(letra);
            } else {
                resultado.append(letra);
            }
        }

        return resultado.toString();
    }

    public static boolean esVocal(char letra) {
        return "aeiouAEIOU".indexOf(letra) != -1;
    }
}
