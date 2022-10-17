package uiMain;
import gestorAplicacion.logistica.*;
import gestorAplicacion.usuario.Pasajero;
import gestorAplicacion.usuario.Usuario;

import java.util.*;

public class Funcion implements PreciosExtra{

    public static void ReservaTiquete(Usuario usuario){
        ArrayList<Vuelo> v = new ArrayList<Vuelo>();
        Scanner input = new Scanner(System.in);
        System.out.println("\nTipo de busqueda:");
        System.out.println("1. Origen-Destino");
        System.out.println("2. Origen-Destino y fecha");
        System.out.println("3. Destinos disponibles");
        System.out.println("0. Regresar");
        int eleccion = input.nextInt();
        while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion !=3){
            System.out.println("Ingrese una opcion valida");
            eleccion = input.nextInt();
        }
        if(eleccion == 1){
            System.out.println("\nIngrese un origen: ");
            input.nextLine();
            String origen = input.nextLine();
            System.out.println("\nIngrese un destino: ");
            String destino = input.nextLine();
            while (Vuelo.filtroVuelos(origen, destino).size() == 0){
                System.out.println("\nNo hay vuelos disponibles");
                System.out.println("\nIngrese un origen: ");
                origen = input.nextLine();
                System.out.println("\nIngrese un destino: ");
                destino = input.nextLine();
            }
            int counter = 1;
            System.out.println("");
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen, destino)){
                System.out.println(counter+". "+vuelo.toString());
                counter ++;
            }
            v = Vuelo.filtroVuelos(origen, destino);
        }else if(eleccion == 2){
            System.out.println("\nIngrese un origen: ");
            String origen = input.nextLine();
            System.out.println("\nIngrese un destino: ");
            String destino = input.nextLine();
            System.out.println("\nFecha DD/MM/AAAA: ");
            String fecha = input.nextLine();

            while (Vuelo.filtroVuelos(origen, destino,fecha).size() == 0){
                System.out.println("\nNo hay vuelos disponibles");
                System.out.println("\nIngrese un origen: ");
                origen = input.nextLine();
                System.out.println("\nIngrese un destino: ");
                destino = input.nextLine();
                System.out.println("\nFecha DD/MM/AAAA: ");
                fecha = input.nextLine();
            }

            int counter = 1;
            System.out.println("");
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen, destino, fecha)){
                System.out.println(counter+". "+vuelo.toString());
                counter ++;
            }
            v = Vuelo.filtroVuelos(origen,destino,fecha);
        }else if(eleccion == 3){
            System.out.println("\nIngrese un origen: ");
            input.nextLine();
            String origen = input.nextLine();
            while (Vuelo.filtroVuelos(origen).size() == 0){
                System.out.println("\nNo hay vuelos disponibles");
                System.out.println("\nIngrese un origen: ");
                origen = input.nextLine();
            }
            int counter = 1;
            System.out.println("");
            for(Vuelo vuelo: Vuelo.filtroVuelos(origen)){
                System.out.println(counter+". "+vuelo.toString());
                counter ++;
            }
            v = Vuelo.filtroVuelos(origen);
        }else{
            return;
        }
        System.out.println("\nIngrese el numero de opcion del vuelo: ");
        eleccion = input.nextInt();
        while (eleccion-1>v.size()){
            System.out.println("\nOpcion invalida");
            System.out.println("\nIngrese el numero de opcion del vuelo: ");
            eleccion = input.nextInt();
        }
        Vuelo vuelo = v.get(eleccion-1);
        System.out.println("\nClase del asiento: ");
        System.out.println("1. Premium");
        System.out.println("2. Ejecutiva");
        System.out.println("3. Economica");
        System.out.println("0. Regresar");
        eleccion = input.nextInt();
        System.out.println("");
        while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion != 3){
            System.out.println("\nIngrese una opcion valida");
            eleccion = input.nextInt();
        }
        int counter = 1;
        ArrayList<Asiento> asientosdisp = new ArrayList<Asiento>();
        if(eleccion == 1){
            for(Asiento asiento : vuelo.getAvion().filtrarAsientos(Clase.PREMIUM)){
                if(asiento.getDisponibilidad()==true){
                    asientosdisp.add(asiento);
                    System.out.println(counter+". "+asiento);
                    counter++;  
                }
            }
        }else if(eleccion == 2){
            for(Asiento asiento : vuelo.getAvion().filtrarAsientos(Clase.EJECUTIVA)){
                if(asiento.getDisponibilidad()==true){
                    asientosdisp.add(asiento);
                    System.out.println(counter+". "+asiento);
                    counter++;
                }
            }
        }else if(eleccion == 3){
            for(Asiento asiento : vuelo.getAvion().filtrarAsientos(Clase.ECONOMICA)){
                if(asiento.getDisponibilidad()==true){
                    asientosdisp.add(asiento);
                    System.out.println(counter+". "+asiento);
                    counter++;
                }
            }
        }else{
            return;
        }
        System.out.println("\nIngrese el numero de opcion del asiento: ");
        eleccion = input.nextInt();
        while (eleccion-1>asientosdisp.size()){
            System.out.println("\nOpcion invalida");
            System.out.println("\nIngrese el numero de opcion del asiento: ");
            eleccion = input.nextInt();
        }
        Asiento asiento = asientosdisp.get(eleccion-1);

        System.out.println("\nIngrese el nombre del pasajero: ");
        input.nextLine();
        String nombre= input.nextLine();
        System.out.println("\nIngrese el numero de documento del pasajero: ");
        int identificacion = input.nextInt();
        asiento.setDisponibilidad(false);
        Tiquete tiquete = new Tiquete(new Pasajero(nombre, identificacion),vuelo,asiento);
        System.out.println("\nDesea agregar equipaje extra o mascotas?: ");
        System.out.println("1. Si");
        System.out.println("0. No");
        
        eleccion = input.nextInt();
        while (eleccion != 1 & eleccion != 0){
            System.out.println("Ingrese una opcion valida");
            eleccion = input.nextInt();
        }
        if(eleccion == 1){
            Funcion.agregarCargaExtra(tiquete);
        }
        System.out.println(tiquete.Factura(tiquete));
        System.out.println("\nConfirmacion de compra: ");
        System.out.println("1. Confirmar");
        System.out.println("0. rechazar");
        eleccion = input.nextInt();
        while (eleccion != 1 & eleccion != 0){
            System.out.println("Ingrese una opcion valida");
            eleccion = input.nextInt();
        }
        if(eleccion == 0){
            asiento.setDisponibilidad(true);
            tiquete=null;
            return;
        }
        System.out.println("\n<3 Reserva exitosa :3 <3");
        usuario.AddTiquete(tiquete);
        return;
    }


    public static void misTiquetes(Usuario usuario){
        System.out.println();
        for(Tiquete tiquete : usuario.getTiquetes()){
            System.out.println(tiquete.toString());
        }
        System.out.println();
    }


    public static void verTodosLosVuelos(){
        System.out.println("\nVuelos disponoibles:\n");
        for(Vuelo vuelo: Vuelo.getVuelos()){
            System.out.println(vuelo.toString());
        }
        System.out.println("");
    }


    public static void agregarCargaExtra(Tiquete tiquete){
        ArrayList<CargaExtra> cargas = new ArrayList<CargaExtra>();
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("\n1. Equipaje extra");
            System.out.println("2. Mascota");
            System.out.println("3. Siguiente");
            int eleccion = input.nextInt();
            while (eleccion != 3 & eleccion != 1 & eleccion != 2){
                System.out.println("Ingrese una opcion valida");
                eleccion = input.nextInt();
            }
            if(eleccion == 1){
                System.out.println("\n1. Equipaje de mano");
                System.out.println("2. Equipaje de bodega");
                System.out.println("0. Regresar");
                eleccion = input.nextInt();
                while (eleccion != 0 & eleccion != 1 & eleccion != 2){
                    System.out.println("Ingrese una opcion valida");
                    eleccion = input.nextInt();
                }
                if(eleccion == 1){
                    System.out.println("\nPrecio: $"+PreciosExtra.equipajeMano);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
                    eleccion = input.nextInt();
                    while (eleccion != 1 & eleccion != 0){
                        System.out.println("Ingrese una opcion valida");
                        eleccion = input.nextInt();
                    }
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.equipajeMano, "Equipaje de mano"));
                    }
                }else if(eleccion==2){
                    System.out.println("\nPrecio: $"+PreciosExtra.equipajeBodega);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
                    eleccion = input.nextInt();
                    while (eleccion != 1 & eleccion != 0){
                        System.out.println("Ingrese una opcion valida");
                        eleccion = input.nextInt();
                    }
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.equipajeBodega, "Equipaje de bodega"));
                    }
                }
            }
            if(eleccion == 2){
                System.out.println("\n1. Mascota Pequeña");
                System.out.println("2. Mascota Mediana");
                System.out.println("3. Mascota Grande");
                System.out.println("0. Regresar");
                eleccion = input.nextInt();
                while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion !=3){
                    System.out.println("Ingrese una opcion valida");
                    eleccion = input.nextInt();
                }
                if(eleccion == 1){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaP);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
                    eleccion = input.nextInt();
                    while (eleccion != 1 & eleccion != 0){
                        System.out.println("Ingrese una opcion valida");
                        eleccion = input.nextInt();
                    }
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaP, "Mascota pequeña"));
                    }
                }else if(eleccion==2){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaM);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
                    eleccion = input.nextInt();
                    while (eleccion != 1 & eleccion != 0){
                        System.out.println("Ingrese una opcion valida");
                        eleccion = input.nextInt();
                    }
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaM, "Mascota mediana"));
                    }
                }else if(eleccion==3){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaG);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
                    eleccion = input.nextInt();
                    while (eleccion != 1 & eleccion != 0){
                        System.out.println("Ingrese una opcion valida");
                        eleccion = input.nextInt();
                    }
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaG, "Mascota grande"));
                    }
                }
            }
            if(eleccion == 3){
                loop = false;
            }
        }
        tiquete.setCargaExtra(cargas);
    }
    
}
