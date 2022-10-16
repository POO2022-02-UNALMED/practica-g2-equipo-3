package gestorAplicacion.logistica;
import java.util.*;
import java.io.*;

public class Pasajero implements Serializable{
    
    static File archivo = new File("");
    private static ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
    private String nombre;
    private int identificacion;
    private Tiquete tiquete;

    //constructores
    public Pasajero(String nombre, int identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tiquete = null;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Pasajeros.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    //getter and setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    public Tiquete getTiquete() {
        return tiquete;
    }
    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }
    public static ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }
    public static void setPasajeros(ArrayList<Pasajero> pasajeros) {
        Pasajero.pasajeros = pasajeros;
    }
}
