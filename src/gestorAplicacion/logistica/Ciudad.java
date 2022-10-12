package gestorAplicacion.logistica;
class Ciudad{
    String nombre;
    String pais;
    public Ciudad(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    //getter and setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
}