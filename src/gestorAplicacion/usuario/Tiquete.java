package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;

import java.io.*;

public class Tiquete implements Serializable{

    private static final long serialVersionUID = 1L;
    private static ArrayList<Tiquete>tiquetes = new ArrayList<Tiquete>();
    private static int totalCreado;
    private int idTiquete;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private Asiento asiento;
    private ArrayList<CargaExtra> cargaExtra = new ArrayList<>();


    //constructores
    public Tiquete(Pasajero pasajero, Vuelo vuelo, Asiento asiento, ArrayList<CargaExtra> cargaExtra) {
        this.idTiquete = totalCreado;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.cargaExtra = cargaExtra;
        tiquetes.add(this);
        totalCreado++;
    }
    public Tiquete(Pasajero pasajero, Vuelo vuelo, Asiento asiento) {
        this(pasajero,vuelo,asiento,new ArrayList<CargaExtra>());
    }
    public Tiquete() {
        tiquetes.add(this);
        totalCreado++;
    }


    //metodos
    public int precioTotal(){
        int p= (int) (this.vuelo.getTarifaBase()*this.asiento.getClase().type);
        if(this.cargaExtra != null){
            for(CargaExtra extra : this.cargaExtra){
                p+=extra.getPrecio();
            }
        }
        return p;
    }
    public String toString(){
        return ("Tiquete No.: "+ this.getIdTiquete() +"  Pasajero: "+ this.pasajero.getNombre() +"  Vuelo No.: "+ this.vuelo.getIdVuelo() +"  "+this.vuelo.getOrigen()+" - "+this.vuelo.getDestino()+"  Asiento: "+ this.getAsiento().toString()+ "  Carga Extra: "+ this.cargaExtra.size()) + "  Fecha: "+ this.vuelo.getFecha();
    }
    
    public static String Factura(Tiquete tiquete){
        int costoAsiento =(int)(tiquete.getVuelo().getTarifaBase()*tiquete.getAsiento().getClase().type);
        String str = "\nAsiento: $"+ costoAsiento;
        if (tiquete.getCargaExtra() != null){
            for (CargaExtra carga : tiquete.getCargaExtra()){
                str = str + "\n" + carga.getTamaño() + ": $" + carga.getPrecio();
            }
        }
        str = str + "\n-------------------\n" +"Total: $"+tiquete.precioTotal();
        return str;
    }


    //getter and setter
    public int getIdTiquete() {
        return idTiquete;
    }
    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
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
    public static int getTotalCreado() {
        return totalCreado;
    }
    public static void setTotalCreado(int totalCreado) {
        Tiquete.totalCreado = totalCreado;
    }
    public static ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }
    public static void setTiquetes(ArrayList<Tiquete> tiquetes) {
        Tiquete.tiquetes = tiquetes;
    }
}
