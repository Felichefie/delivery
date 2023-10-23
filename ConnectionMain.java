public class ConnectionMain {
    public static void main(String[] args) {
        /*Conexion con = new Conexion();
        String txtJson=con.sendGet();*/
        //System.out.println(txtJson);
        
        User u = new User(1, 0,"titulo texto", "Usuario 0");
        String resJson;
        Serializar serial = new Serializar();
        resJson= serial.user(u);
        System.out.println(resJson);
        serial.userAdd(u);
        resJson = serial.lista_json();
        System.out.println(resJson);

        /*Gson gson = new Gson();
        List<UserExample> lista= gson.fromJson(txtJson, List.class);
        System.out.println(lista.size());
   
        for (UserExample userExample : lista) {
           System.out.println(userExample.getId());
        }   
    }
}*/
    }
}

