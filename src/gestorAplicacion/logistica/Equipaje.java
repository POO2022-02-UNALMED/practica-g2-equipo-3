package gestorAplicacion.logistica;
import java.util.*;

public class Equipaje extends CargaExtra {
    private static ArrayList<Equipaje> equipajes = new ArrayList<Equipaje>();
    private static final long serialVersionUID = 1L;
    public Equipaje(int precio, String tamaño) {
        super(precio, tamaño);
        equipajes.add(this);
    }
    public static ArrayList<Equipaje> getEquipajes() {
        return equipajes;
    }
    public static void setEquipajes(ArrayList<Equipaje> equipaje) {
        Equipaje.equipajes = equipaje;
    }
}
