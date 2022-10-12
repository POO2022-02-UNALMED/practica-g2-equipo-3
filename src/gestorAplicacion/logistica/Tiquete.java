package gestorAplicacion.logistica;
import gestorAplicacion.usuario.Pasajero;

public class Tiquete {
    int id_tiquete;
    Pasajero Pasajero;
    Vuelo vuelo;
    Asiento asiento;
    int precio;
    public Tiquete(int id_tiquete, Vuelo vuelo, Asiento asiento, int precio) {
        this.id_tiquete = id_tiquete;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.precio = precio;
        this.Pasajero = null;
    }
    //getter and setter
    public int getId_tiquete() {
        return id_tiquete;
    }
    public void setId_tiquete(int id_tiquete) {
        this.id_tiquete = id_tiquete;
    }
    public Pasajero getPasajero() {
        return Pasajero;
    }
    public void setPasajero(Pasajero pasajero) {
        Pasajero = pasajero;
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
