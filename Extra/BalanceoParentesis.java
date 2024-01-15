package Extra;

import java.util.Scanner;

public class BalanceoParentesis {
    public static boolean verificarBalanceo(String frase) {
        int contador = 0;

        for (char caracter : frase.toCharArray()) {
            if (caracter == '(') {
                contador++;
            } else if (caracter == ')') {
                contador--;
            }

            // Si en algún momento el contador es negativo, no está balanceado
            if (contador < 0) {
                return false;
            }
        }

        // Verificar si el contador es cero al final
        return contador == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la frase para verificar el balanceo de paréntesis:");
        String frase = scanner.nextLine();

        scanner.close();

        System.out.println("¿La frase está balanceada? " + verificarBalanceo(frase));
    }
}

