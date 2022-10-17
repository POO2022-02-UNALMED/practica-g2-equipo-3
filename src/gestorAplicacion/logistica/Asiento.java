package gestorAplicacion.logistica;
import java.io.*;

public class Asiento implements Serializable{
    
    static File archivo = new File("");
    private int numeroAsiento;
    private Boolean disponibilidad;
    private Avion avion;
    private Clase clase;


    //constructores
    public Asiento(int numero_asiento, Avion avion, Clase clase){
        this.numeroAsiento = numero_asiento;
        this.disponibilidad = true;
        this.avion = avion;
        this.clase = clase;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Asientos.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    
    //methods
    @Override
	public String toString() {
        if(this.clase == Clase.PREMIUM){
            String txt = this.numeroAsiento+"PR";
            return txt;
        }else if(this.clase == Clase.EJECUTIVA){
            String txt = this.numeroAsiento +"EJ" ;
            return txt; 
        }else{
            String txt = this.numeroAsiento+"EC";
            return txt;
        }
	}
    

    //getter and setter
    public int getNumeroAsiento() {
        return numeroAsiento;
    }
    public void setNumeroAsiento(int numero_asiento) {
        this.numeroAsiento = numero_asiento;
    }
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public static File getArchivo() {
        return archivo;
    }
    public static void setArchivo(File archivo) {
        Asiento.archivo = archivo;
    }
}
