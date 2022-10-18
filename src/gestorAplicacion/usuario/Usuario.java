package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;
import java.io.*;

public class Usuario implements Serializable,PreciosExtra{
    private static final long serialVersionUID = 1L;
    private int id;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private String password;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
    private int cartera;

    
    //constructores
    public Usuario(int id, String password,  int cartera, ArrayList<Tiquete> tiquetes) {
        this.id = id;
        this.password = password;
        this.cartera = cartera;
        this.tiquetes = tiquetes;
        usuarios.add(this);
    }
    public Usuario(int id, String password, int cartera) {
        this(id,password,cartera,new ArrayList<Tiquete>());
    }
    
    
    //metodos

    public void Reembolsar(int tiquete){
            Tiquete tiqueteReembolsado = this.tiquetes.get(tiquete);
            this.cartera += tiqueteReembolsado.precioTotal();
            this.tiquetes.remove(tiquete);
    }

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
    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }
    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }
    public int getCartera() {
        return cartera;
    }
    public void setCartera(int cartera) {
        this.cartera = cartera;
    }
    public void AddTiquete(Tiquete tiquete){
        this.tiquetes.add(tiquete);
    }
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Usuario.usuarios = usuarios;
    }
}