package uiMain;
import java.util.*;

import baseDatos.Persistencia;
import gestorAplicacion.usuario.*;
import gestorAplicacion.logistica.*;

public class Main{
    //TEST
    public static void main(String[] args) {
        System.out.println("\nPara seleccionar una opcion ingrese el numero que antecede al punto.\nejemplo: \n2. Prueba \nPara acceder a Prueba ingrese 2");
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
            @SuppressWarnings("resource")
            Scanner inputmain = new Scanner(System.in);
            while(logloop){
                //Admin.vuelosRandom(101);
                //new Admin("admin", "admin");
                System.out.println("\n================================");
                System.out.println("\n1. Iniciar sesion");
                System.out.println("2. Crear cuenta");
                System.out.println("0. Cerrar programa");
                System.out.println("\n================================");
                int eleccion = 0;
                while (inputNotNull) {
                    try {
                        eleccion = inputmain.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        inputmain.nextLine();
                    }
                }
                inputNotNull = true;
                while (eleccion != 1 & eleccion != 2  & eleccion != 0){
                    System.out.println("Ingrese una opcion valida");
                    while (inputNotNull) {
                        try {
                            eleccion = inputmain.nextInt();
                            inputNotNull = false;
            
                        }catch (InputMismatchException e) {
                            System.err.println("Solo ingrese Numeros");
                            inputmain.nextLine();
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
                        System.out.println("\nHasta pronto!\n");
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
                System.out.println("4. Check-in");
                System.out.println("5. Ver todos los destinos");
                if(user instanceof Admin){
                    System.out.println("10. Gestionar el sistema");
                }
                System.out.println("0. Cerrar sesion");
                int eleccion = 0;
                while (inputNotNull) {
                    try {
                        eleccion = inputmain.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        inputmain.nextLine();
                    }
                }
                if((user instanceof Admin)==false & eleccion==10){eleccion=100;}
                inputNotNull = true;
                while (eleccion != 1 & eleccion != 2  & eleccion != 0 & eleccion !=5 & eleccion != 4 &  eleccion != 3 & eleccion != 10){
                    System.out.println("Ingrese una opcion valida");
                    while (inputNotNull) {
                        try {
                            eleccion = inputmain.nextInt();
                            inputNotNull = false;
            
                        }catch (InputMismatchException e) {
                            System.err.println("Solo ingrese Numeros");
                            inputmain.nextLine();
                        }
                        if((user instanceof Admin)==false & eleccion==5){eleccion=10;}   
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
                    case 4:{
                        Funcion.checkIn(user);
                        Persistencia.serializar();
                        break;
                    }
                    case 5:{
                        for(Ciudad c: Ciudad.getCiudades()){System.out.println(c);}
                        break;
                    }
                    case 10:{
                        ((Admin)user).gestorSistema();
                        Persistencia.serializar();
                        break;
                    }
                }
            }
        }
        Persistencia.serializar();
    }
}