package gestorAplicacion.logistica;
import java.util.ArrayList;

public class Avion {
    String modelo;
    int cantidad_asientos;
    ArrayList<Asiento> asientos = new ArrayList<>();

    public Avion(String modelo, int cantidad_asientos) {
        this.modelo = modelo;
        this.cantidad_asientos = cantidad_asientos;
        ArrayList<Integer> ls =  Avion.calcularasientos(cantidad_asientos);
        for(int i = 1; i<cantidad_asientos; i++){
            if(i<=ls.get(0)){
                this.asientos.add(new AsientoPremium(i, this));
            }else if(i<=ls.get(1)){
                this.asientos.add(new AsientoEjecutivo(i, this));
            }else{
                this.asientos.add(new AsientoEconomico(i, this));
            }
        }
    }

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

    //getter and setter
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCantidad_asientos() {
        return cantidad_asientos;
    }
    public void setCantidad_asientos(int cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }
    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }
    public void setAsientos(ArrayList<Asiento> asientos) {
        this.asientos = asientos;
    }
}
