package uiMain;
import java.util.*;
import gestorAplicacion.logistica.*;
import gestorAplicacion.usuario.*;

public class Main {
    //TEST
    public static void main(String[] args) {
        Ciudad cucuta = new Ciudad("cucuta", "Colombia");
        Ciudad boyaca = new Ciudad("boyaca", "Colombia");
        Ciudad medellin  = new Ciudad("medellin", "Colombia");
        Ciudad cartagena = new Ciudad("cartagena", "Colombia");
        Ciudad cali = new Ciudad("cali", "Colombia");
        Ciudad ibague = new Ciudad("ibague", "Colombia");
        Ciudad barranquilla = new Ciudad("barranquilla", "Colombia");
        Ciudad barrancabermeja = new Ciudad("barrancabermeja", "Colombia");
        Ciudad leticia = new Ciudad("leticia", "Colombia");
        Ciudad pasto = new Ciudad("pasto", "Colombia");
        Ciudad bogota = new Ciudad("bogota", "Colombia");

        Avion A1 = new Avion("747", 50);
        Avion A2 = new Avion("420", 100);
        Avion A3 = new Avion("747", 200);
        Avion A4 = new Avion("420", 300);
        Avion A5 = new Avion("747", 366 );

        Admin.vuelosRandom(20);

        /*  
        Pasajero Alejandro = new Pasajero("Alejandro", 777);
        Tiquete barranca = new Tiquete(0001, Alejandro, mc, mc.getAvion().getAsientos().get(0));
        ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
        tiquetes.add(barranca);
        Alejandro.setTiquete(barranca);
        Pepito.setTiquetes(tiquetes);
        Pepito.Factura(barranca);
        Pepito.Reembolsar(0);        
        */

        //Real Main
        Usuario Pepito = new Usuario(123, "1235", 100000);
        boolean loop = true;
        Usuario user = Pepito;
        System.out.println("\n================================");
        System.out.println("AERO UNAL");
        System.out.println("================================");
        while (loop) {
            Scanner input = new Scanner(System.in);
            System.out.println("Servicios:");
            System.out.println("1. Ver todos los vuelos disponibles");
            System.out.println("2. Reserva tiquete");
            System.out.println("3. Mis tiquetes");
            System.out.println("0. Cerrar");
            int eleccion = input.nextInt();
            
            switch (eleccion) {
                case 0:{
                    loop=false;
                    break;
                }
                case 1:{
                    Funcion.verTodosLosVuelos();
                    break;
                    }
                case 2:{
                    Funcion.ReservaTiquete(user);
                    break;
                }
                case 3:{
                    Funcion.misTiquetes(user);
                    break;
                }
            }
            System.out.println("================================");
        }
    }
}