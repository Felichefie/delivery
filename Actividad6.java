//Nombre: Alexis Abraham Corona Meza
//Matricula: 1701450H
//Hora de edición: 12:00PM
//Fecha: 14/02/2024

import java.lang.Math;
import java.util.Scanner;

public  class Actividad6
{
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        float X,Y,X2,Y2;
        System.out.print("Escribe el valor de X: \n"); X=entrada.nextFloat();
        System.out.print("Escribe el valor de Y: \n"); Y=entrada.nextFloat();
        double tan = Math.tan(45 * 3.1416 / 180);
        X2= X+10;
        Y2=(float) (10*tan+Y);
        System.out.printf("%s %.3f %n", "X2=",X2);
        System.out.printf("%s %.3f %n", "Y2=",Y2);
    }
}