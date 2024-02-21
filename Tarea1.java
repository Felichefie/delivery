/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 20:38PM
Fecha de edición: 18/02/2024
Fecha de edicion 2: 21/02/2024*/

import java.util.Scanner;
import java.lang.Math;

public class Tarea1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double X,Y,DISTANCIA,RADIO,X2,Y2,ANGULO,RADIANES;

        System.out.print("Introduce el valor de X: \n"); X=entrada.nextDouble();
        System.out.print("Introduce el valor de Y: \n"); Y=entrada.nextDouble();
        System.out.print("\nIntroduce la distancia entre los dos puntos: \n"); DISTANCIA=entrada.nextDouble();
        System.out.print("\nIntroduce el radio de la circunferencia: \n"); RADIO=entrada.nextDouble();
        System.out.print("Introduce un angulo para el circulo: \n"); ANGULO=entrada.nextDouble();

        RADIANES = ANGULO * Math.PI / 180;

        X2 = X + DISTANCIA * Math.cos(RADIANES);
        Y2 = Y - DISTANCIA * Math.sin(RADIANES);


        System.out.println("<svg width = \"1000\" height = \"1000\">");
       System.out.printf("<circle cx = \"%.2f\" cy = \"%.2f\" fill = \"lightblue\" r = \"%.2f\"/>\n",X,Y,RADIO);
       System.out.printf("<circle cx=\"%.2f\" cy=\"%.2f\" fill=\"darkred\" r=\"%.2f\"/>\n",X2,Y2,RADIO);
       System.out.println("<line x1=\""+X+"\" y1=\""+Y+"\" x2=\""+X2+"\" y2=\""+Y2+"\" stroke=\"red\" stroke-width=\"10\"/>");
       System.out.println("<line x1= \""+X+"\" y1=\""+Y+"\" x2=\""+X2+"\" y2=\""+Y+"\" stroke=\"black\" stroke-width= \"5\"/>");
       System.out.println("<line x1=\""+X2+"\" y1=\""+Y2+"\" x2=\""+X2+"\" y2=\""+Y+"\" stroke=\"blue\" stroke-width=\"3\"/>");
       System.out.println("</svg>");
    }
}







        