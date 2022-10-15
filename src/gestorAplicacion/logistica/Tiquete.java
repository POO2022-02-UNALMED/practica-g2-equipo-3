package gestorAplicacion.logistica;
import java.util.*;

public class Tiquete {
    int id_tiquete;
    Pasajero pasajero;
    Vuelo vuelo;
    Asiento asiento;
    ArrayList<CargaExtra> cargaExtra = new ArrayList<>();

    //constructores
    public Tiquete(int id_tiquete, gestorAplicacion.logistica.Pasajero pasajero, Vuelo vuelo, Asiento asiento, ArrayList<CargaExtra> cargaExtra) {
        this.id_tiquete = id_tiquete;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.cargaExtra = cargaExtra;
    }

    public Tiquete() {
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
}
