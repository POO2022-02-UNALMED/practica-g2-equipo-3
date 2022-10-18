package gestorAplicacion.logistica;
import java.util.*;

public class Mascota extends CargaExtra{
    private static final long serialVersionUID = 1L;
    private static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    public Mascota(int precio, String tamaño) {
        super(precio, tamaño);
        mascotas.add(this);
    }
    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    public static void setMascotas(ArrayList<Mascota> mascotas) {
        Mascota.mascotas = mascotas;
    }
}
