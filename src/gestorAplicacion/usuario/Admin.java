package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.*;
import java.io.*;

public class Admin implements Serializable{
    
    static File archivo = new File("");
    private int id;
    private String password;

    //constructores
    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Administradores.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
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
