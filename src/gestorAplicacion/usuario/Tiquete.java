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
    private int descuento;
    private ArrayList<CargaExtra> cargaExtra = new ArrayList<>();
    private boolean checkIn = false;


    //constructores
    public Tiquete(Pasajero pasajero, Vuelo vuelo, Asiento asiento, ArrayList<CargaExtra> cargaExtra, int descuento) {
        this.idTiquete = totalCreado;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.cargaExtra = cargaExtra;
        this.descuento = descuento;
        tiquetes.add(this);
        vuelo.agregarTiquete(this);
        totalCreado++;
    }
    public Tiquete(Pasajero pasajero, Vuelo vuelo, Asiento asiento) {
        this(pasajero,vuelo,asiento,new ArrayList<CargaExtra>(),0);
    }
    public Tiquete(Pasajero pasajero, Vuelo vuelo, Asiento asiento, int descuento) {
        this(pasajero,vuelo,asiento,new ArrayList<CargaExtra>(),descuento);
    }
    public Tiquete() {
        tiquetes.add(this);
    }


    //metodos
    public int precioTotal(){
        int p= (int) (this.vuelo.getTarifaBase()*this.asiento.getClase().type);
        if(this.cargaExtra != null){
            for(CargaExtra extra : this.cargaExtra){
                p+=extra.getPrecio();
            }
        p = p - this.descuento;
        }
        return p;
    }
    public String toString(){
        return ("Tiquete No.: "+ this.getIdTiquete() +"  Pasajero: "+ this.pasajero.getNombre() +"  Vuelo No.: "+ this.vuelo.getIdVuelo() +"  "+this.vuelo.getOrigen()+" - "+this.vuelo.getDestino()+"  Asiento: "+ this.getAsiento().toString()+ "  Carga Extra: "+ this.cargaExtra.size() + "  Fecha: "+ this.vuelo.getFecha()+" Hora de salida: "+this.vuelo.getHoraSalida() +" Hora de llegada: "+this.vuelo.getHoraLlegada() +" Precio: $"+this.precioTotal()+"  Check-in realizado? "+ this.isCheckIn());
    }
    
    public static String Factura(Tiquete tiquete){
        int costoAsiento =(int)(tiquete.getVuelo().getTarifaBase()*tiquete.getAsiento().getClase().type);
        String str = "\nAsiento: $"+ costoAsiento;
        if (tiquete.getCargaExtra() != null){
            for (CargaExtra carga : tiquete.getCargaExtra()){
                str = str + "\n" + carga.getTama??o() + ": $" + carga.getPrecio();
            }
        }
        if(tiquete.descuento!=0){str = str + "\n" +"descuento: -$" +tiquete.getDescuento();}
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
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public boolean isCheckIn() {
        return checkIn;
    }
    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }
}
