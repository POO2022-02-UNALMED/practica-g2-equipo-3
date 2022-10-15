package gestorAplicacion.logistica;
import java.util.*;
class Ciudad{
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    String nombre;
    String pais;

    //constructores
    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    //getter and setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public static ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
    public static void setCiudades(ArrayList<Ciudad> ciudades) {
        Ciudad.ciudades = ciudades;
    }
}