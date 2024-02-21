//Nombre: Alexis Abraham Corona Meza
//Matricula: 1701450H
//Hora de edición: 11:30AM
//Fecha: 14/02/2024

import java.util.Scanner;

public class Actividad4 {
    public static void main(String[]args){
        Scanner entrada = new Scanner(System.in);
        float A,B,C,D,E;
        System.out.print("Escribe el valor de A: \n"); A=entrada.nextFloat();
        System.out.print("Escribe el valor de B: \n"); B=entrada.nextFloat();
        System.out.print("Escribe el valor de C: \n"); C=entrada.nextFloat();
        System.out.print("Escribe el valor de D: \n"); D=entrada.nextFloat();
        E= (A+B+C+D)/5;

        Scanner entrada2 = new Scanner(System.in);
        float p,r,q,w,y,z;
        System.out.print("Escribe el valor de p: \n"); p=entrada2.nextFloat();
        System.out.print("Escribe el valor de r: \n"); r=entrada2.nextFloat();
        System.out.print("Escribe el valor de q: \n"); q=entrada2.nextFloat();
        System.out.print("Escribe el valor de w: \n"); w=entrada2.nextFloat();
        System.out.print("Escribe el valor de y: \n"); y=entrada2.nextFloat(); 

        z = ((p*r)%q)+((w/E)-y);

        System.out.printf("%s %.3f %n", "z=",z);
     
    }
}
