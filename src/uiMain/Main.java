package uiMain;
import java.util.*;

import baseDatos.Persistencia;
import gestorAplicacion.usuario.*;

public class Main{
    //TEST
    public static void main(String[] args) {
        
        Persistencia.deserializar();

       /* Ciudad cucuta = new Ciudad("cucuta", "Colombia");
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

        Avion A1 = new Avion("747", 20);
        Avion A2 = new Avion("420", 100);
        Avion A3 = new Avion("747", 200);
        Avion A4 = new Avion("420", 240);
        Avion A5 = new Avion("747", 166 );

        Admin.vuelosRandom(200);*/

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
            while (eleccion != 0 &eleccion != 1 & eleccion != 2 & eleccion != 3){
                System.out.println("Ingrese una opcion valida");
                eleccion = input.nextInt();
            }
            switch (eleccion) {
                case 0:{
                    loop=false;
                    Persistencia.serializar();
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