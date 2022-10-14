package gestorAplicacion.logistica;

public class AsientoEconomico extends Asiento {
    static double multiplicador =  1;
    public AsientoEconomico(int numero_asiento, Avion avion) {
        super(numero_asiento, avion);
    }
    @Override
    public String toString() {
        String txt = this.numero_asiento+"EC";
        return txt;
    }
    
    //getter and setter
    public static double getMultiplicador() {
        return multiplicador;
    }
    public static void setMultiplicador(double multiplicador) {
        AsientoEconomico.multiplicador = multiplicador;
    }
    
}
