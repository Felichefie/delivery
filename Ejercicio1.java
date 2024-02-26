/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 12:07PM
Fecha de edición: 26/02/2024*/



public class Ejercicio1 {
    public static void main(String[] args) {
 Circulo a= new Circulo(); 
 Linea b= new Linea();
  
 System.out.println("<svg width = \"1000\" height = \"1000\">");
 a.imprimeCirculo(100, 500, 100);
 a.imprimeCirculo(50, 800, 700);
 b.imprimeLinea(100, 100, 350, 500);
 b.imprimeLinea(500, 700, 100, 50);
 System.out.println("</svg>");          
    }
}    

