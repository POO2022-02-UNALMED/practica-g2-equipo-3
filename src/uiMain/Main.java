package uiMain;

import java.lang.Math;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import gestorAplicacion.logistica.*;
import gestorAplicacion.usuario.*;

public class Main {
    //TEST
    public static void main(String[] args) {
        Ciudad cucuta = new Ciudad("Cucuta", "Colombia");
        Ciudad boyaca = new Ciudad("Boyaca", "Colombia");
        Ciudad medellin  = new Ciudad("Medellin", "Colombia");
        Ciudad bogota = new Ciudad("Bogota", "Colombia");
        Avion circular_coonatra = new Avion("747", 50);
        Avion bus_unal = new Avion("420", 100);
        Vuelo mc = new Vuelo(1, bus_unal, medellin, cucuta, "12:30", "13:20", "20/10/2022", 200000., "3C");
        Vuelo bb = new Vuelo(2, circular_coonatra, boyaca, bogota, "05:00", "06:00", "20/10/2022", 70000., "4A");
        Usuario Pepito = new Usuario(123, "1235");
        System.out.println("Vuelos disponoibles:");
        for(Vuelo vuelo: Vuelo.getVuelos()){
            System.out.println(vuelo.toString());
        }
        System.out.println("\n");
        System.out.println(Vuelo.getVuelos());
        System.out.println("\n");
        Predicate<Vuelo> byOrigen = vuelo -> vuelo.getOrigen().getNombre() == "Bogota";
        System.out.println(Vuelo.getVuelos().stream().filter(byOrigen).collect(Collectors.toList()));
        //Pepito.ReservaTiquete();
    }
}