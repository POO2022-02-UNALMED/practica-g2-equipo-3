package gestorAplicacion.logistica;
import java.util.*;
import java.io.*;

public class Ciudad implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    private String nombre;
    private String pais;


    //constructores
    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        ciudades.add(this);
    }


    //metodos
    @Override
    public String toString() {return this.nombre;}
    public void EliminarCiudad(){
        for(Vuelo vuelo: Vuelo.getVuelos()){
            if(vuelo.getOrigen().equals(this) || vuelo.getDestino().equals(this)){vuelo.eliminarVuelo();}
        }
        ciudades.remove(this);
    }


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
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}