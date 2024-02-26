/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 12:07PM
Fecha de edición: 26/02/2024*/


public class Circulo {
    private float radio;
    private float cx,cy;

    public void imprimeCirculo(float rad, float x, float y){
        System.out.printf("<circle cx=\"%f\" cy=\"%f\" fill=\"orange\" r=\"%f\"></circle>\n", x,y,rad);
    }
}
