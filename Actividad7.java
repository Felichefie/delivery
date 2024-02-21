//Hacer un programa que recibe dos numeros, si los numeros son iguales, implementa la suma de esos numeros, si los numeros son diferentes, implementa la multiplicacion, y finalmente el programa me dice cual de los numeros es mayor. 
//Nombre: Alexis Abraham Corona Meza
//Matricula: 1701450H
//Hora de edición: 12:30PM
//Fecha: 14/02/2024


import java.util.Scanner;
public class Actividad7 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float A,B;
       System.out.print("Escribe el valor de A: \n"); A=entrada.nextFloat(); 
        System.out.print("Escribe el valor de B: \n"); B=entrada.nextFloat();

        if (A==B){
            System.out.println("La suma de los numeros es igual a: "+(A+B));
        }else{
            System.out.println("La multiplicacion de los numeros es igual a:"+(A*B));
        }

        if (A==B){
            System.out.printf("Los numeros son iguales. \n");  
        }else if (A>B){
            System.out.printf("El numero mayor es: %.3f \n",A);
        }else{
            System.out.printf("El numero mayor es: %.3f \n",B);
        }       
    }
}
    

