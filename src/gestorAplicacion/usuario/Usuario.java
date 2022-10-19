package gestorAplicacion.usuario;
import java.util.*;
import java.io.*;

public class Usuario implements Serializable,PreciosExtra{
    
    private static final long serialVersionUID = 1L;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static int totalUsuarios = usuarios.size();
    protected String id;
    private String password;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
    private int cartera;

    
    //constructores
    public Usuario(String id, String password,  int cartera, ArrayList<Tiquete> tiquetes) {
        this.id = id;
        this.password = password;
        this.cartera = cartera;
        this.tiquetes = tiquetes;
        usuarios.add(this);
        totalUsuarios = usuarios.size();
    }
    public Usuario(String id, String password, int cartera) {
        this(id,password,cartera,new ArrayList<Tiquete>());
    }
    public Usuario(){};
    
    
    //metodos
    public void Reembolsar(int tiquete){
            Tiquete tiqueteReembolsado = this.tiquetes.get(tiquete);
            this.cartera += tiqueteReembolsado.precioTotal();
            this.tiquetes.remove(tiquete);
    }
    public static boolean isUsuarioExist(String user){
        for(Usuario u : Usuario.getUsuarios()){
            if(u.getId().equals(user)){
                return true;
            }
        }
        return false;
    }


    //getter and setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public static void setTotalUsuarios(int totalUsuarios) {
        Usuario.totalUsuarios = totalUsuarios;
    }
    public static int getTotalUsuarios() {
        return totalUsuarios;
    }
}