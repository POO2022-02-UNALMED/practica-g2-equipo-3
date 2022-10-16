package gestorAplicacion.logistica;
import java.util.*;
import java.io.*;

public class Tiquete implements Serializable{
    
    static File archivo = new File("");
    private static ArrayList<Tiquete>tiquetes = new ArrayList<Tiquete>();
    private static int total_creado;
    private int id_tiquete;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Asiento asiento;
    private ArrayList<CargaExtra> cargaExtra = new ArrayList<>();

    //constructores
    public Tiquete(int id_tiquete, Pasajero pasajero, Vuelo vuelo, Asiento asiento, ArrayList<CargaExtra> cargaExtra) {
        this.id_tiquete = id_tiquete;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.cargaExtra = cargaExtra;
        tiquetes.add(this);
        total_creado++;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Tiquetes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    public Tiquete(int id_tiquete, Pasajero pasajero, Vuelo vuelo, Asiento asiento) {
        this.id_tiquete = id_tiquete;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.cargaExtra = new ArrayList<CargaExtra>();
        tiquetes.add(this);
        total_creado++;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Tiquetes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    public Tiquete() {
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Tiquetes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    //metodos
    public Double precio_total(){
        Double p= this.vuelo.getTarifa_base()*this.asiento.getClase().type;
        if(this.cargaExtra != null){
            for(CargaExtra extra : this.cargaExtra){
                p+=extra.getPrecio();
            }
        }
        return p;
    }
    public String toString(){
        return ("Tiquete #"+ this.getId_tiquete() +"  Pasajero: "+ this.pasajero.getNombre() +"\nVuelo #"+ this.vuelo.getId_vuelo() +
        "  Asiento #"+ this.getAsiento().getNumero_asiento() + "\nCarga Extra Permitida: "+ this.cargaExtra.size());
    }

    //getter and setter
    public int getId_tiquete() {
        return id_tiquete;
    }
    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    public Asiento getAsiento() {
        return asiento;
    }
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    public ArrayList<CargaExtra> getCargaExtra() {
        return cargaExtra;
    }
    public void setCargaExtra(ArrayList<CargaExtra> cargaExtra) {
        this.cargaExtra = cargaExtra;
    }
    public Pasajero getPasajero() {
        return pasajero;
    }
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public static File getArchivo() {
        return archivo;
    }

    public static void setArchivo(File archivo) {
        Tiquete.archivo = archivo;
    }

    public static int getTotal_creado() {
        return total_creado;
    }

    public static void setTotal_creado(int total_creado) {
        Tiquete.total_creado = total_creado;
    }

    public static ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public static void setTiquetes(ArrayList<Tiquete> tiquetes) {
        Tiquete.tiquetes = tiquetes;
    }
}
