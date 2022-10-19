package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;

public class Mascota extends CargaExtra{

    private static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    //constructores
    public Mascota(int precio, String tamaño) {
        super(precio, tamaño);
        mascotas.add(this);
    }


    //getter and setter
    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    public static void setMascotas(ArrayList<Mascota> mascotas) {
        Mascota.mascotas = mascotas;
    }
}
