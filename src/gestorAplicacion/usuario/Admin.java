package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.*;
import java.io.*;

public class Admin implements Serializable{
    private int id;
    private String password;

    //constructores
    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
    }

    //metodos

    //getter and setter
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
