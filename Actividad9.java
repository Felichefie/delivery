/*Hacer un programa que imprime un circulo de color aleatorio en un rango de 0-255, y agregar
un borde aleatorio en un rango de 1 a 10 con la clase Circulo ya guardada.*/
/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 11:24AM
Fecha de edición: 28/02/2024*/

import java.util.Random;
import java.util.Scanner;

public class Actividad9 {
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    int X,Y,radio;
    System.out.println("Introduce el valor de X: "); X = entrada.nextInt();
    System.out.println("Introduce el valor de Y: "); Y = entrada.nextInt();
    System.out.println("Introduce el valor del radio: "); radio = entrada.nextInt();
    System.out.println("<svg width = \"1000\" height = \"1000\">");

    Circulo a= new Circulo();
    a.circuloColorAle(radio, X, Y, a.rA, a.gA, a.bA, a.rP, a.gP, a.bP, a.lin);

System.out.println("</svg>");
}
}