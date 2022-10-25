package gestorAplicacion.logistica;
import gestorAplicacion.usuario.*;
import java.util.*;
import java.io.*;

public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    private static int totalCreado;
    private int idVuelo;
    private Avion avion;
    private Ciudad origen;
    private Ciudad destino;
    private String horaSalida;
    private String horaLlegada;
    private String fecha;
    private int tarifaBase;
    private String puerto;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();


    //constructores
    public Vuelo(Avion avion, Ciudad origen, Ciudad destino, String horaSalida, String horaLlegada, String fecha, int tarifaBase, String puerto, ArrayList<Tiquete> tiquetes) {
        this.idVuelo = totalCreado;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.fecha = fecha;
        this.tarifaBase = tarifaBase;
        this.puerto = puerto;
        this.tiquetes = tiquetes;
        vuelos.add(this);
        totalCreado++;
    }
    public Vuelo(Avion avion, Ciudad origen, Ciudad destino, String horaSalida, String horaLlegada, String fecha, int tarifaBase,String puerto) {
        this(avion, origen, destino, horaSalida, horaLlegada, fecha, tarifaBase, puerto,new ArrayList<>());
    }


    //metodos
    public static ArrayList<Vuelo> filtroVuelos(String origen){
        ArrayList<Vuelo> result = new ArrayList<Vuelo>();
        for(Vuelo vuelo: Vuelo.vuelos){
            if(vuelo.getOrigen().getNombre().equals(origen)){
                result.add(vuelo);
            }
        }
        return result;
    }
    public void agregarTiquete(Tiquete tiquete){
        this.tiquetes.add(tiquete);
    }
    public void eliminarVuelo(){
        for(Tiquete tiquete: Tiquete.getTiquetes()){
            if(tiquete.getVuelo().getIdVuelo() ==this.getIdVuelo()){
                for(Usuario u:Usuario.getUsuarios()){
                    for(int i = 0;i < u.getTiquetes().size(); i++)
                        if(u.getTiquetes().get(i).getIdTiquete()==(tiquete.getIdTiquete())){
                            System.out.println("tiquete reembolsado");
                            u.Reembolsar(i);
                        }
                }
                tiquete = null;
            }
        }
        vuelos.remove(this);
    }
    public static ArrayList<Vuelo> filtroVuelos(String origen,String destino){
        ArrayList<Vuelo> base = filtroVuelos(origen);
        ArrayList<Vuelo> result = new ArrayList<Vuelo>();
        for(Vuelo vuelo: base){
            if(vuelo.getDestino().getNombre().equals(destino)){
                result.add(vuelo);
            }
        }
        return result;
    }
    public static ArrayList<Vuelo> filtroVuelos(String origen,String destino,String fecha){
        ArrayList<Vuelo> base = filtroVuelos(origen,destino);
        ArrayList<Vuelo> result = new ArrayList<Vuelo>();
        for(Vuelo vuelo: base){
            if(vuelo.getFecha().equals(fecha)){
                result.add(vuelo);
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return " | Id: "+this.idVuelo+" | Origen: "+this.origen+" | Destino: "+this.destino+" | Fecha: "+this.fecha+" | Hora De Salida: "+this.horaSalida+" | Hora De Llegada: "+this.horaLlegada;
    }


    //getter and setter
    public int getIdVuelo() {
        return idVuelo;
    }
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    public Ciudad getOrigen() {
        return origen;
    }
    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }
    public Ciudad getDestino() {
        return destino;
    }
    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
    public String getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public String getHoraLlegada() {
        return horaLlegada;
    }
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getTarifaBase() {
        return tarifaBase;
    }
    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    public String getPuerto() {
        return puerto;
    }
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
    public static ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
    public static void setVuelos(ArrayList<Vuelo> vuelos) {
        Vuelo.vuelos = vuelos;
    }
    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }
    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }
    public static int getTotalCreado() {
        return totalCreado;
    }
    public static void setTotalCreado(int totalCreado) {
        Vuelo.totalCreado = totalCreado;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}