/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 20:38PM
Fecha de edición: 18/02/2024
Fecha de edicion 2: 21/02/2024*/

import java.util.Scanner;

public class Ciclos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double X,Y,X2,Y2,NUMCIRCULOS,RADIO;
        System.out.print("Introduce el numero de circulos: \n"); NUMCIRCULOS=entrada.nextDouble();
        System.out.println("<svg width = \"1000\" height = \"1000\">");
        System.out.print("Introduce el valor de X: \n"); X=entrada.nextDouble();
        System.out.print("Introduce el valor de Y: \n"); Y=entrada.nextDouble();
        System.out.print("Introduce el radio de la circunferencia: \n"); RADIO=entrada.nextDouble();
        System.out.printf("<circle cx=\"%.2f\" cy=\"%.2f\" fill=\"darkred\" r=\"%.2f\"/>\n",X,Y,RADIO);
        for (int i = 1; i < NUMCIRCULOS; i++) {
            System.out.print(("Introduce el valor de X2: \n")); X2=entrada.nextDouble();
            System.out.print("Introduce el valor de Y2: \n"); Y2=entrada.nextDouble();
            System.out.print("Introduce el radio de la circunferencia: \n"); RADIO=entrada.nextDouble();

            System.out.printf("<circle cx=\"%.2f\" cy=\"%.2f\" fill=\"darkred\" r=\"%.2f\"/>\n",X2,Y2,RADIO);
            System.out.println("<line x1=\""+X+"\" y1=\""+Y+"\" x2=\""+X2+"\" y2=\""+Y2+"\" stroke=\"red\" stroke-width=\"10\"/>");
            System.out.println("<line x1= \""+X+"\" y1=\""+Y+"\" x2=\""+X2+"\" y2=\""+Y+"\" stroke=\"black\" stroke-width= \"5\"/>");
            System.out.println("<line x1=\""+X2+"\" y1=\""+Y2+"\" x2=\""+X2+"\" y2=\""+Y+"\" stroke=\"blue\" stroke-width=\"3\"/>");

        }
       System.out.println("</svg>");
    }
}
