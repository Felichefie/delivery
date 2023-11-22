import java.util.ArrayList;

public class lista1 {
    public static void main(String[] args) {
         ArrayList<renglon_tabla> al = new ArrayList<>();
            al.add(new renglon_tabla("1", "2", "3", "4", "5"));
            al.add(new renglon_tabla("hola", "adios", "dia", "noche", "tarde"));

          //  al.add(Arrays.asList("3", "4"));    
           // String str = "5, 6"; // <-- let's assume the user wants to add a 5 and 6
            //al.add(Arrays.asList(str.split(",\\s*")));
            System.out.println(al);
            renglon_tabla r = al.get(1);
            r.imprimir();
    }
}
