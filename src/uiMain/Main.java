package uiMain;

import java.lang.Math;
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

        Admin.vuelos_random(50);

        Usuario Pepito = new Usuario(123, "1235", 100000);
        //Pasajero Alejandro = new Pasajero("Alejandro", 777);
        //Tiquete barranca = new Tiquete(0001, Alejandro, mc, mc.getAvion().getAsientos().get(0));
        //ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
        //tiquetes.add(barranca);
        //Alejandro.setTiquete(barranca);
        //Pepito.setTiquetes(tiquetes);
        //Pepito.Factura(barranca);
        //Pepito.Reembolsar(0);


        //Real Main
        System.out.println("\n================================");
        System.out.println("AERO UNAL");
        System.out.println("================================");
        boolean loop = true;
        while (loop) {
            Scanner input = new Scanner(System.in);
            System.out.println("Servicios:");
            System.out.println("1. Ver todos los vuelos disponibles");
            System.out.println("2. Reserva tiquete");
            System.out.println("0. Cerrar");
            int eleccion = input.nextInt();
            
            switch (eleccion) {
                case 0:{
                    loop=false;
                    break;
                }
                case 1:{
                    Usuario.ver_todos_los_vuelos();
                    break;
                    }
                case 2:{
                    Pepito.ReservaTiquete();
                    break;
                }
            }
            System.out.println("================================");
        }
    }
}