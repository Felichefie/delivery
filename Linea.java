/*Nombre: Alexis Abraham Corona Meza
Matricula: 1701450H
Hora de edición: 12:07PM
Fecha de edición: 26/02/2024*/

public class Linea{
private float x1;
private float y1;
private float x2;
private float y2;

public void imprimeLinea(float x1, float y1, float x2, float y2){
    System.out.printf("<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"black\" stroke-width=\"2\"/>\n", x1, y1, x2, y2);

}
}