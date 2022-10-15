package gestorAplicacion.logistica;

public abstract class CargaExtra {
    Float precio;
    String tamaño;
    public CargaExtra(Float precio, String tamaño) {
        this.precio = precio;
        this.tamaño = tamaño;
    }
    public CargaExtra(String tamaño){
        this(definir_precio(tamaño), tamaño);
    }
    public static Float definir_precio(String tamaño);
    
}
