import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Serializar {
//LISTA QUE ALMACENA USUARIOS
    private List<User> usersLists;
    private Gson gson;

//CONSTRUCTOR.
    Serializar(){
        gson = new Gson();
        usersLists = new ArrayList<User>();
    }


//METODO QUE AGREGA UN USUARIO A LA LISTA

    void UserAdd(User userNew){
    usersLists.add(userNew);
    }

//METODO QUE REGRESA EL USUARIO SERIALIZADO.
    String serialUser(User u){
        String result;
        //SERIALIZANDO ELEMENTO
        result = gson.toJson(u);
        return result;
    }

//METODO QUE SERIALIZA LA LISTA.
    String listaJson(){
        String result;
        result = gson.toJson(usersLists);
        return result;
    }



}




