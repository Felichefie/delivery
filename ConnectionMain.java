public class ConnectionMain {
    public static void main(String[] args) {
       // Conexion con = new Conexion();
        //String txtJson = con.sendGet();

//CREAR UN OBJETO SERIALIZADO
    User u = new User(1, 0, "TituloTexto", "Cuerpo");
    String resJson;
    Serializar serial = new Serializar();
    resJson = serial.serialUser(u);
    System.out.print(resJson);
    serial.UserAdd(u);
    resJson = serial.listaJson();
    System.out.print(resJson);

    User u1 = new User(1, 1, "OTRO USUSARIO", "CUAERPO 2");
    resJson = serial.serialUser(u1);
    serial.UserAdd(u1);
    System.out.println(resJson);


       /* Gson gson = new Gson();
        Type type = new TypeToken<List<Userexample>>() {}.getType();
        List<Userexample> lista = gson.fromJson(txtJson, type);

        // Utiliza un conjunto para almacenar userId únicos
        Set<Integer> uniqueUserIds = new HashSet<>();

        for (Userexample user : lista) {
            uniqueUserIds.add(user.getUserId());
        }

        for (int userId : uniqueUserIds) {
            System.out.println("userId = " + userId);
            for (Userexample user : lista) {
                if (user.getUserId() == userId) {
                    System.out.println(user.getId());
                }
            }
        }*/
    }
}

// tener varios usuarios, asignar las propiedades, serializar y enviar a internet 