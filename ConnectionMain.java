import java.util.List;

import com.google.gson.Gson;

public class ConnectionMain {

    public static void main(String[] args){
        Conexion con = new Conexion();
        String txtJson = con.sendGet();
        //System.out.println(txtJson);

        Gson gson = new Gson();

        List<Userexample> lista = gson.fromJson(txtJson, List.class);

        System.out.println("NUMERO DE REGISTROS" + lista.size());
        int i;
        for( i=0; i<lista.size(); i++){

            //lista.get(i) regresa un objeto del tipo Userexample 
                        //Userexample objecto = (Userexample) lista.get(i);
            //System.out.println(lista.get(i).getUserId());

        }

    }
    
}
