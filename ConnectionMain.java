public class ConnectionMain {
    public static void main(String[] args) {
        Conexion con = new Conexion();
        String txtJson = con.sendGet();


        //crear un objeto serializaru
        User u = new User(1, 1, "titulo", "Usuario uno");
        String resJson;

        Serializar serial = new Serializar();
        resJson = serial.user(u);
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