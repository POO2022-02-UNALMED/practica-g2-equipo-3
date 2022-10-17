package gestorAplicacion.logistica;
import java.io.*;

public abstract class CargaExtra implements Serializable{
    
    private int precio;
    private String tamaño;


    //constructores
    public CargaExtra(int precio, String tamaño) {
        this.precio = precio;
        this.tamaño = tamaño;
    }


     //getter and setter
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
