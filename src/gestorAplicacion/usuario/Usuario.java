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
            String origen = input.nextLine();
            input.nextLine();
            Object vuelos =  Vuelo.filtroVuelos(origen);
            System.out.println(vuelos);
            System.out.println("Ingrese un destino: ");
            String destino = input.nextLine();
            input.nextLine();
            vuelos =  Vuelo.filtroVuelos(destino);
            System.out.println(vuelos);
            //funcion motras vuelos con este origen y destino
        }else if(eleccion == 2){
            System.out.println("Origen");
            String origen = input.nextLine();
            System.out.println("Destino");
            String destino = input.nextLine();
            System.out.println("Fecha DD/MM");
            String fecha = input.nextLine();
            //funcion motras vuelos con este origen,destino y fecha
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
