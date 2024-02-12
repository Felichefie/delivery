//Nombre: Alexis Abraham Corona Meza
//Matricula: 1701450H
//Hora de edición: 12:52

import java.util.Scanner;
public class Leer2 {
        public static void main(String[]args){
            Scanner entrada = new Scanner(System.in);
            float A,B,C,D,E;
            System.out.print("Escribe el valor de A: \n"); A=entrada.nextFloat();
            System.out.print("Escribe el valor de B: \n"); B=entrada.nextFloat();
            System.out.print("Escribe el valor de C: \n"); C=entrada.nextFloat();
            System.out.print("Escribe el valor de D: \n"); D=entrada.nextFloat();
            E= A+B+C+D;
                        System.out.printf("%s %.3f %n", "E=",E);   
        }   
    }