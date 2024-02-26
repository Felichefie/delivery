/*El usuario indica cuantos renglones y cuantos circulos POR renglón se dibujarán en una imagen de 1000x1000, 
distribuirlos de manera que entren en la imagen según el número de circulos y renglones, y dibujar lineas 
que unan los centros de todos los circulos por renglón */
import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {
        
        int renglones;
        int circulos;
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el número de renglones: "); renglones = entrada.nextInt();
        System.out.println("Introduce el número de circulos por renglón: "); circulos = entrada.nextInt();
        
        int distanciaX = 1000 / (circulos + 1);
        int distanciaY = 1000 / (renglones + 1);
        System.out.println("<svg width = \"1000\" height = \"1000\">");
        
        
        for (int i = 1; i <= renglones; i++) {
            for (int j = 1; j <= circulos; j++) {
                int diametro = 1000 / (circulos);
                int radio = diametro / 2;
                int x = 1 + (j * distanciaX);
                int y = 1 + (i * distanciaY);
                System.out.printf("<circle cx=\"%d\" cy=\"%d\" fill=\"orange\" r=\"%d\"/>\n", x, y, radio);
            }
        }
        for (int i = 1; i <= renglones; i++) {
            for (int j = 1; j < circulos; j++) {
                int x = 1 + (j * distanciaX);
                int y = 1 + (i * distanciaY);
                System.out.printf("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"black\" stroke-width=\"2\"/>\n", x, y, x + distanciaX, y);
            }
       
    }
    System.out.println("</svg>");
}
}
