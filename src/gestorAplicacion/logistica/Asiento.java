package gestorAplicacion.logistica;

abstract class Asiento{
    int numero_asiento;
    Boolean disponibilidad;
    Avion avion;
    public Asiento(int numero_asiento, Avion avion) {
        this.numero_asiento = numero_asiento;
        this.disponibilidad = true;
        this.avion = avion;
    }
    abstract public String toString();
    //getter and setter
    public int getNumero_asiento() {
        return numero_asiento;
    }
    public void setNumero_asiento(int numero_asiento) {
        this.numero_asiento = numero_asiento;
    }
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public Avion getAvion() {
        return avion;
    }
    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
