package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;;

public class Usuario {
    int id;
    String password;
    ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();

    public Usuario(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
