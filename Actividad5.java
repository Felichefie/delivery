import java.util.Scanner;

public class Actividad5 {
    public static void main(String[] args) {
        
        Scanner entrada2 = new Scanner(System.in);
        float p,r,q,w,y,z;
        System.out.print("Escribe el valor de p: \n"); p=entrada2.nextFloat();
        System.out.print("Escribe el valor de r: \n"); r=entrada2.nextFloat();
        System.out.print("Escribe el valor de q: \n"); q=entrada2.nextFloat();
        System.out.print("Escribe el valor de w: \n"); w=entrada2.nextFloat();
        System.out.print("Escribe el valor de y: \n"); y=entrada2.nextFloat(); 

        z = ((p*r)%q)+((w/4)-y);

        System.out.printf("%s %.3f %n", "z=",z);
    }
}
