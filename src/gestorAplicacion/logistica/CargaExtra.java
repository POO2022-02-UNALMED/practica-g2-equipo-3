package gestorAplicacion.logistica;
import java.io.*;

import java.util.ArrayList;

public abstract class CargaExtra implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int precio;
    private String tamaño;
    private  static ArrayList<CargaExtra> cargas = new ArrayList<CargaExtra>();

    //constructores
    public CargaExtra(int precio, String tamaño) {
        this.precio = precio;
        this.tamaño = tamaño;
        cargas.add(this);
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
    public static ArrayList<CargaExtra> getCargas() {
        return cargas;
    }
    public static void setCargas(ArrayList<CargaExtra> cargas) {
        CargaExtra.cargas = cargas;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
