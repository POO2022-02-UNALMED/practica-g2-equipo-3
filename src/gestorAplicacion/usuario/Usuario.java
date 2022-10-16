package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.logistica.*;;

public class Usuario {
    private int id;
    private String password;
    private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>(); 

    //constructores
    public Usuario(int id, String password, ArrayList<Tiquete> tiquetes) {
        this.id = id;
        this.password = password;
        this.tiquetes = tiquetes;
    }
    public Usuario(int id, String password) {
        this(id,password,new ArrayList<>());
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
            int count = 0;
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen, destino, fecha)){
                System.out.println(count+" "+vuelo.toString());
                count++;
            }
        }else{
            return;
        }
        System.out.println("Ingrese el numero de opcion del vuelo: ");
        eleccion = input.nextInt();
        Vuelo vuelo = Vuelo.getVuelos().get(eleccion);
        System.out.println("Clase del asiento: ");
        System.out.println("1. Premium");
        System.out.println("2. Ejecutiva");
        System.out.println("3. Economica");
        System.out.println("0. Regresar");
        eleccion = input.nextInt();
        while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion != 3){
            System.out.println("Ingrese una opcion valida");
            eleccion = input.nextInt();
        }
        if(eleccion == 1){
            System.out.println(vuelo.getAvion().filtrar_Asientos(Clase.PREMIUM));
        }else if(eleccion == 2){
            System.out.println(vuelo.getAvion().filtrar_Asientos(Clase.EJECUTIVA));
        }else if(eleccion == 3){
            System.out.println(vuelo.getAvion().filtrar_Asientos(Clase.ECONOMICA));
        }else{
            return;
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

}
