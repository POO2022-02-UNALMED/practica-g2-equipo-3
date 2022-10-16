package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;;

public class Usuario {
    private int id;
    private String password;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
    private int cartera;

    //constructores
    public Usuario(int id, String password,  int cartera, ArrayList<Tiquete> tiquetes) {
        this.id = id;
        this.password = password;
        this.cartera = cartera;
        this.tiquetes = tiquetes;
    }
    public Usuario(int id, String password, int cartera) {
        this(id,password,cartera,new ArrayList<>());
    }
    public Usuario(int id, String password) {
        this(id,password,0,new ArrayList<>());
    }
    
    //metodos
    public void ReservaTiquete(){
        Scanner input = new Scanner(System.in);
        System.out.println("Tipo de busqueda:");
        System.out.println("1. Origen-Destino");
        System.out.println("2. Origen-Destino y fecha");
        System.out.println("0. Regresar");
        int eleccion = input.nextInt();
        while (eleccion != 0 & eleccion != 1 & eleccion != 2){
            System.out.println("Ingrese una opcion valida");
            eleccion = input.nextInt();
        }
        if(eleccion == 1){

            System.out.println("Ingrese un origen: ");
            input.nextLine();
            String origen = input.nextLine();
            System.out.println("Ingrese un destino: ");
            String destino = input.nextLine();
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen, destino)){
                System.out.println(vuelo.toString());
            }

        }else if(eleccion == 2){

            System.out.println("Ingrese un origen: ");
            input.nextLine();
            String origen = input.nextLine();
            System.out.println("Ingrese un destino: ");
            String destino = input.nextLine();
            System.out.println("Fecha DD/MM/AAAA: ");
            String fecha = input.nextLine();
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen, destino, fecha)){
                System.out.println(vuelo.toString());
            }

        }else{
            return;
        }
    }
    public void Reembolsar(int tiquete){
            Tiquete tiqueteReembolsado = this.tiquetes.get(tiquete);
            this.cartera += tiqueteReembolsado.precio_total();
            this.tiquetes.remove(tiquete);
            tiqueteReembolsado = null;
    }
    public void Factura(Tiquete tiquete){
            double costoAsiento =tiquete.getVuelo().getTarifa_base()*tiquete.getAsiento().getClase().type;
            System.out.println("Costo Asiento: "+ costoAsiento);
            int contadorMascotas=0;
            int contadorEquipaje=0;
            if (tiquete.getCargaExtra().isEmpty() == false){
                for (CargaExtra carga : tiquete.getCargaExtra()){
                    if (carga instanceof Mascota){
                        contadorMascotas++;
                        System.out.println("Costo Mascota "+contadorMascotas+":"+ carga.getPrecio());
                    }
                    else if (carga instanceof Equipaje){
                        contadorEquipaje++;
                        System.out.println("Costo Equipaje "+contadorEquipaje+":"+ carga.getPrecio());
                    }
                }
            }
    }

    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Tiquete> getTiquetes() {
        return tiquetes;
    }

    public void setTiquetes(ArrayList<Tiquete> tiquetes) {
        this.tiquetes = tiquetes;
    }
    public int getCartera() {
        return cartera;
    }
    public void setCartera(int cartera) {
        this.cartera = cartera;
    }

}
