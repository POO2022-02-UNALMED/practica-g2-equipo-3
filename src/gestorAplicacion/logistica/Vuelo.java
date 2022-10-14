package gestorAplicacion.logistica;
import java.util.ArrayList;

public class Vuelo {
    int id_vuelo;
    Avion avion;
    Ciudad origen;
    Ciudad destino;
    String hora_salida;
    String hora_llegada;
    String fecha;
    int tarifa_base;
    String puerto;

    
    public Vuelo(int id_vuelo, Avion avion, Ciudad origen, Ciudad destino, String hora_salida, String hora_llegada, String fecha, int tarifa_base,String puerto) {
        this.id_vuelo = id_vuelo;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.fecha = fecha;
        this.tarifa_base = tarifa_base;
        this.puerto = puerto;
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
    public int getTarifa_base() {
        return tarifa_base;
    }
    public void setTarifa_base(int tarifa_base) {
        this.tarifa_base = tarifa_base;
    }
    public String getPuerto() {
        return puerto;
    }
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }
}
