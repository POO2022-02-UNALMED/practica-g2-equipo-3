package gestorAplicacion.logistica;
import java.util.*;
import java.io.*;

public class Avion implements Serializable{
    
    static File archivo = new File("");
    private  static ArrayList<Avion> aviones = new ArrayList<Avion>();
    private  String modelo;
    private  int cantidadAsientos;
    private  ArrayList<Asiento> asientos = new ArrayList<Asiento>();


    //constructores
    public Avion(String modelo, int cantidad_asientos) {
        this.modelo = modelo;
        this.cantidadAsientos = cantidad_asientos;
        ArrayList<Integer> ls =  Avion.calcularasientos(cantidad_asientos);
        for(int i = 1; i<cantidad_asientos; i++){
            if(i<=ls.get(0)){
                this.asientos.add(new Asiento(i, this, Clase.PREMIUM));
            }else if(i<=ls.get(1)){
                this.asientos.add(new Asiento(i, this, Clase.EJECUTIVA));
            }else{
                this.asientos.add(new Asiento(i, this, Clase.ECONOMICA));
            }
        }
        aviones.add(this);
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Aviones.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }


    //metodos
    public static ArrayList<Integer> calcularasientos(int n){
        ArrayList<Integer> ls = new ArrayList<>();
        int premium;
        int ejecutiva;
        int economica;
        int numero_asientos = n;
        if (Math.ceil((numero_asientos/6))%2 == 0){
            premium = (int) Math.ceil((numero_asientos/6));
        }else{
            premium = (int) (Math.ceil((numero_asientos/6))+1);
        }
        if (Math.ceil((numero_asientos*2/6))%2 == 0){
            ejecutiva = (int) Math.ceil((numero_asientos*2/6));
        }else{
            ejecutiva = (int) (Math.ceil((numero_asientos*2/6))+1);
        }
        economica= numero_asientos - (premium+ejecutiva);
        ls.add(premium);
        ls.add(ejecutiva);
        ls.add(economica);
        return ls;
    }
    public ArrayList<Asiento> filtrarAsientos(Clase clase){
        ArrayList<Asiento> result = new ArrayList<Asiento>();
        for(Asiento asiento: this.getAsientos()){
            if(asiento.getClase().equals(clase)){
                result.add(asiento);
            }
        }
        return result;
    }


    //getter and setteri
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCantidadAsientos() {
        return cantidadAsientos;
    }
    public void setCantidadAsientos(int cantidad_asientos) {
        this.cantidadAsientos = cantidad_asientos;
    }
    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }
    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }
    public static ArrayList<Avion> getAviones() {
        return aviones;
    }
    public static void setAviones(ArrayList<Avion> aviones) {
        Avion.aviones = aviones;
    }
    public static File getArchivo() {
        return archivo;
    }
    public static void setArchivo(File archivo) {
        Avion.archivo = archivo;
    }
}
