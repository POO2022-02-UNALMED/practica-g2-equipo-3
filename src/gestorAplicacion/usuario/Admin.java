package gestorAplicacion.usuario;
import java.util.*;
import gestorAplicacion.*;

public class Admin {
    private int id;
    private String password;

    //constructores
    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
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
            System.out.println("Origen");
            String origen = input.nextLine();
            while(){

            }
        }else if(eleccion == 2){

        }else{

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
}
