package gestorAplicacion.logistica;
import java.util.*;

public class Pasajero {
    static ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
    String nombre;
    int identificacion;
    Tiquete tiquete;

    //constructores
    public Pasajero(String nombre, int identificacion, Tiquete tiquete) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tiquete = null;
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
