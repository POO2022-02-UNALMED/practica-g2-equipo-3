package uiMain;
import java.util.*;

import baseDatos.Persistencia;
import gestorAplicacion.usuario.*;
import gestorAplicacion.logistica.*;

public class Main{
    //TEST
    public static void main(String[] args) {

        boolean loop = true;
        boolean logloop = true;
        boolean mainloop = true;
        boolean inputNotNull = true;
        Usuario user = null;
        while(mainloop){
            
            loop = true;
            logloop = true;
            mainloop = true;
            Persistencia.deserializar();
            Scanner input = new Scanner(System.in);
            while(logloop){
                System.out.println("\n================================");
                System.out.println("\n1. Iniciar sesion");
                System.out.println("2. Crear cuenta");
                System.out.println("0. Cerrar programa");
                System.out.println("\n================================");
                int eleccion = 0;
                while (inputNotNull) {
                    try {
                        eleccion = input.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        input.nextLine();
                    }
                }
                inputNotNull = true;
                while (eleccion != 1 & eleccion != 2  & eleccion != 0){
                    System.out.println("Ingrese una opcion valida");
                    while (inputNotNull) {
                        try {
                            eleccion = input.nextInt();
                            inputNotNull = false;
            
                        }catch (InputMismatchException e) {
                            System.err.println("Solo ingrese Numeros");
                            input.nextLine();
                        }
                    }
                    inputNotNull = true;
                }
                switch (eleccion) {
                    case 1:{
                        user = Funcion.login();
                        break;
                        }
                    case 2:{
                        user = Funcion.crearUsuario();
                        loop = true;
                        Persistencia.serializar();
                        break;
                        }
                    case 0:{
                        logloop = false;
                        loop = false;
                        mainloop = false;
                        break;
                        }
                }
                if(user != null){logloop=false;}
            }





            while (loop) {
                System.out.println("\n================================");
                System.out.println("AERO UNAL");
                System.out.println("================================");
                System.out.println("Servicios:");
                System.out.println("1. Ver todos los vuelos disponibles");
                System.out.println("2. Reservar tiquete");
                System.out.println("3. Mis tiquetes");
                System.out.println("0. Cerrar sesion");
                int eleccion = 0;
                while (inputNotNull) {
                    try {
                        eleccion = input.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        input.nextLine();
                    }
                }
                inputNotNull = true;
                while (eleccion != 0 &eleccion != 1 & eleccion != 2 & eleccion != 3){
                    System.out.println("Ingrese una opcion valida");
                    while (inputNotNull) {
                        try {
                            eleccion = input.nextInt();
                            inputNotNull = false;
            
                        }catch (InputMismatchException e) {
                            System.err.println("Solo ingrese Numeros");
                            input.nextLine();
                        }
                    }
                    inputNotNull = true;
                }
                switch (eleccion) {
                    case 0:{
                        loop=false;
                        Persistencia.serializar();
                        break;
                    }
                    case 1:{
                        Funcion.verTodosLosVuelos();
                        Persistencia.serializar();
                        break;
                        }
                    case 2:{
                        Funcion.ReservaTiquete(user);
                        Persistencia.serializar();
                        break;
                    }
                    case 3:{
                        Funcion.misTiquetes(user);
                        Persistencia.serializar();
                        break;
                    }
                }
            }
        }
        Persistencia.serializar();
    }
}