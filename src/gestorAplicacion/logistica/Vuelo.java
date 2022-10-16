package gestorAplicacion.logistica;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Vuelo {

    private static ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
    private int id_vuelo;
    private Avion avion;
    private Ciudad origen;
    private Ciudad destino;
    private String hora_salida;
    private String hora_llegada;
    private String fecha;
    private Double tarifa_base;
    private String puerto;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();

    //constructores
    public Vuelo(int id_vuelo, Avion avion, Ciudad origen, Ciudad destino, String hora_salida, String hora_llegada, String fecha, Double tarifa_base, String puerto, ArrayList<Tiquete> tiquetes) {
        this.id_vuelo = id_vuelo;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.fecha = fecha;
        this.tarifa_base = tarifa_base;
        this.puerto = puerto;
        this.tiquetes = tiquetes;
        vuelos.add(this);
    }
    public Vuelo(int id_vuelo, Avion avion, Ciudad origen, Ciudad destino, String hora_salida, String hora_llegada, String fecha, Double tarifa_base,String puerto) {
        this(id_vuelo, avion, origen, destino, hora_salida, hora_llegada, fecha, tarifa_base, puerto,new ArrayList<>());
    }
    //metodos
    public static Object filtroVuelos(String origen){
        Predicate<Vuelo> byOrigen = vuelo -> vuelo.getOrigen().getNombre() == origen;
        var result = vuelos.stream().filter(byOrigen).collect(Collectors.toList());
        return result;
    }
    public static Object filtroVuelos(String origen,String destino){
        Predicate<Vuelo> byOrigen = vuelo -> vuelo.getOrigen().getNombre() == origen;
        Predicate<Vuelo> byDestino = vuelo -> vuelo.getOrigen().getNombre() == destino;
        var result = vuelos.stream().filter(byOrigen).collect(Collectors.toList());
        result = result.stream().filter(byDestino).collect(Collectors.toList());
        return result;
    }
    public static Object filtroVuelos(String origen,String destino,String fecha){
        Predicate<Vuelo> byOrigen = vuelo -> vuelo.getOrigen().getNombre() == origen;
        Predicate<Vuelo> byDestino = vuelo -> vuelo.getOrigen().getNombre() == destino;
        Predicate<Vuelo> byFecha = vuelo -> vuelo.getFecha() == fecha;
        var result = vuelos.stream().filter(byOrigen).collect(Collectors.toList());
        result = result.stream().filter(byDestino).collect(Collectors.toList());
        result = result.stream().filter(byFecha).collect(Collectors.toList());
        return result;
    }

    @Override
    public String toString() {
        return this.id_vuelo+" "+this.origen+"-"+this.destino+" "+this.fecha+" "+this.hora_salida+"-"+this.hora_llegada;
    }


    //getter and setter
    public int getId_vuelo() {
        return id_vuelo;
    }
    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
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
    public String getHora_salida() {
        return hora_salida;
    }
    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
    public String getHora_llegada() {
        return hora_llegada;
    }
    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Double getTarifa_base() {
        return tarifa_base;
    }
    public void setTarifa_base(Double tarifa_base) {
        this.tarifa_base = tarifa_base;
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
}
