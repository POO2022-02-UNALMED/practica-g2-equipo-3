package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;

public class Equipaje extends CargaExtra {

    private static ArrayList<Equipaje> equipajes = new ArrayList<Equipaje>();

    //constructores
    public Equipaje(int precio, String tamaño) {
        super(precio, tamaño);
        agregar();
    }

    @Override
    public void agregar() {
        equipajes.add(this);
        
    }

    //getter and setter
    public static ArrayList<Equipaje> getEquipajes() {
        return equipajes;
    }
    public static void setEquipajes(ArrayList<Equipaje> equipaje) {
        Equipaje.equipajes = equipaje;
    }
}
