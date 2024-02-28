/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 12:07PM
Fecha de edición: 26/02/2024*/

import java.util.Random;

public class Circulo {
    private float radio;
    private float cx,cy;

    /*public void imprimeCirculo(float rad, float x, float y){
        System.out.printf("<circle cx=\"%f\" cy=\"%f\" fill=\"orange\" r=\"%f\"></circle>\n", x,y,rad);
    }*/

    
    Random ra = new Random();

public int rA = ra.nextInt(256), gA = ra.nextInt(256), bA = ra.nextInt(256);
public int rP = ra.nextInt(256), gP = ra.nextInt(256), bP = ra.nextInt(256);
public int lin = ra.nextInt(10)+1;
    
    void circuloColorAle(float r, float cx, float cy , int rA, int gA, int bA, int rP, int gP, int bP, int lin){
        System.out.printf("<circle cx=\"%f\" cy=\"%f\" r=\"%f\" fill=\"rgb(%d,%d,%d)\"  stroke=\"rgb(%d.%d,%d)\" stroke-width=\"%d\" ></circle> \n", cx, cy, r, rA, gA, bA, rP, gP, bP,lin);
    }
}
