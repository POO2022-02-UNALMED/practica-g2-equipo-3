package gestorAplicacion.logistica;

public enum Clase {
	ECONOMICA(1.0),EJECUTIVA(1.25),PREMIUM(1.5);

	public Double type;

	private Clase(Double value) {
		this.type = value;
	}
}