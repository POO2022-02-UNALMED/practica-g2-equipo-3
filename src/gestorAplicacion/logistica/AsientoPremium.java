package gestorAplicacion.logistica;

public class AsientoPremium extends Asiento {
    static double multiplicador =  1.5;
    public AsientoPremium(int numero_asiento, Avion avion) {
        super(numero_asiento, avion);
    }
	@Override
	public String toString() {
        String txt = this.numero_asiento+"PR";
        return txt;
	}
    
}
