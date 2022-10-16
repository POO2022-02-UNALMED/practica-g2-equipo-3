package gestorAplicacion.logistica;
import java.io.*;

public abstract class CargaExtra implements Serializable{
    
    private Float precio;
    private String tamaño;

    //constructores
    public CargaExtra(Float precio, String tamaño) {
        this.precio = precio;
        this.tamaño = tamaño;
    }

     //getter and setter
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
