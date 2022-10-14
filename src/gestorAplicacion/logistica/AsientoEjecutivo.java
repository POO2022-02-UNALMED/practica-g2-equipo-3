package gestorAplicacion.logistica;

public class AsientoEjecutivo extends Asiento {
    static double multiplicador =  1.25;
    public AsientoEjecutivo(int numero_asiento, Avion avion) {
        super(numero_asiento, avion);
    }
	@Override
	public String toString() {
        String txt = this.numero_asiento +"EJ" ;
        return txt;
	}
    
    //getter and setter
    public static double getMultiplicador() {
        return multiplicador;
    }
    public static void setMultiplicador(double multiplicador) {
        AsientoEjecutivo.multiplicador = multiplicador;
    }
    
}
