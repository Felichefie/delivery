import java.util.Random;

public class CIrculoTodoAleatorio{

    Random ra = new Random();

    public float r = ra.nextFloat(950/2), cx = ra.nextFloat(951-2*475)+475, cy = ra.nextFloat(951-2*475)+475;
    public int rA = ra.nextInt(256), gA = ra.nextInt(256), bA = ra.nextInt(256);
    public int rP = ra.nextInt(256), gP = ra.nextInt(256), bP = ra.nextInt(256);
    public int lin = ra.nextInt(10)+1;
    void circuloColorAle(float r, float cx, float cy , int rA, int gA, int bA, int rP, int gP, int bP, int lin){
        System.out.printf("<circle cx=\"%f\" cy=\"%f\" r=\"%f\" fill=\"rgb(%d,%d,%d)\"  stroke=\"rgb(%d.%d,%d)\" stroke-width=\"%d\" ></circle> \n", cx, cy, r, rA, gA, bA, rP, gP, bP,lin);
    
}
}
