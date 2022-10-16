package gestorAplicacion.logistica;
import java.util.*;

public class Ciudad{
    
    private static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    private String nombre;

    //constructores
    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {return this.nombre;}
    
    //getter and setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
    public static void setCiudades(ArrayList<Ciudad> ciudades) {
        Ciudad.ciudades = ciudades;
    }
}