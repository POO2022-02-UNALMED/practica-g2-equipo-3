package uiMain;
import gestorAplicacion.logistica.*;
import gestorAplicacion.usuario.*;
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
        int eleccion = 0;
        boolean inputNotNull = true;
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
        while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion !=3){
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
            input.nextLine();
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
        while (eleccion-1>v.size()){
            System.out.println("\nOpcion invalida");
            System.out.println("\nIngrese el numero de opcion del vuelo: ");
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
        Vuelo vuelo = v.get(eleccion-1);
        System.out.println("\nClase del asiento: ");
        System.out.println("1. Premium");
        System.out.println("2. Ejecutiva");
        System.out.println("3. Economica");
        System.out.println("0. Regresar");
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
        System.out.println("");
        while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion != 3){
            System.out.println("\nIngrese una opcion valida");
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
        while (eleccion-1>asientosdisp.size()){
            System.out.println("\nOpcion invalida");
            System.out.println("\nIngrese el numero de opcion del asiento: ");
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
        Asiento asiento = asientosdisp.get(eleccion-1);

        System.out.println("\nIngrese el nombre del pasajero: ");
        input.nextLine();
        String nombre= input.nextLine();
        System.out.println("\nIngrese el numero de documento del pasajero: ");
        int identificacion = 0;
        while (inputNotNull) {
            try {
                identificacion = input.nextInt();
                inputNotNull = false;

            }catch (InputMismatchException e) {
                System.err.println("Solo ingrese Numeros");
                input.nextLine();
            }
        }
        inputNotNull = true;
        asiento.setDisponibilidad(false);
        Tiquete tiquete = new Tiquete(new Pasajero(nombre, identificacion),vuelo,asiento);
        System.out.println("\nDesea agregar equipaje extra o mascotas?: ");
        System.out.println("1. Si");
        System.out.println("0. No");
        
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
        while (eleccion != 1 & eleccion != 0){
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
        if(eleccion == 1){
            Funcion.agregarCargaExtra(tiquete);
        }
        if(usuario.getCartera()>tiquete.precioTotal()){
            tiquete.setDescuento(tiquete.precioTotal());
            usuario.setCartera(usuario.getCartera()-tiquete.precioTotal());
        }else{
            tiquete.setDescuento(usuario.getCartera());
            usuario.setCartera(0);
        }
        System.out.println(Tiquete.Factura(tiquete));
        System.out.println("\nConfirmacion de compra: ");
        System.out.println("1. Confirmar");
        System.out.println("0. rechazar");
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
        while (eleccion != 1 & eleccion != 0){
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
        if(eleccion == 0){
            asiento.setDisponibilidad(true);
            tiquete=null;
            return;
        }
        System.out.println("\nReserva exitosa");
        usuario.AddTiquete(tiquete);
        return;
    }

//Siguiene Funcion

    public static void misTiquetes(Usuario usuario){
        System.out.println();
        Scanner input = new Scanner(System.in);
        int counter = 1;
        int numero = 0;
        boolean inputNotNull = true;
        for(Tiquete tiquete : usuario.getTiquetes()){
            System.out.println(counter+". "+tiquete.toString());
            counter++;
        }
        System.out.println("\n1. Remmbolsar tiquete");
        System.out.println("2. Ver cartera");
        System.out.println("3. Agregar carga extra");
        System.out.println("0. regresar");
        while (inputNotNull) {
            try {
                numero = input.nextInt();
                inputNotNull = false;

            }catch (InputMismatchException e) {
                System.err.println("Solo ingrese Numeros");
                input.nextLine();
            }
        }
        inputNotNull = true;
        while (numero != 1 & numero != 2 & numero != 0 & numero != 3){
            System.out.println("Ingrese una opcion valida");
            while (inputNotNull) {
                try {
                    numero = input.nextInt();
                    inputNotNull = false;
    
                }catch (InputMismatchException e) {
                    System.err.println("Solo ingrese Numeros");
                    input.nextLine();
                }
            }
            inputNotNull = true;
        }
        inputNotNull = true;
        if(numero==2){
            System.out.println("Cartera: $"+usuario.getCartera());
        }else if(numero==1){
            System.err.println("Ingrese la opcion del numero del tiquete");
            while (inputNotNull) {
                try {
                    numero = input.nextInt();
                    inputNotNull = false;
    
                }catch (InputMismatchException e) {
                    System.err.println("Solo ingrese Numeros");
                    input.nextLine();
                }
            }
            inputNotNull = true;
            while (numero < 0 || numero > usuario.getTiquetes().size()){
                System.out.println("Ingrese una opcion valida");
                while (inputNotNull) {
                    try {
                        numero = input.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        input.nextLine();
                    }
                }
                inputNotNull = true;
            }
            inputNotNull = true;
            usuario.Reembolsar(numero-1);
            System.out.println("Reembolso exitoso");
        }else if(numero == 3){
            System.err.println("Ingrese la opcion del numero del tiquete");
            while (inputNotNull) {
                try {
                    numero = input.nextInt();
                    inputNotNull = false;
    
                }catch (InputMismatchException e) {
                    System.err.println("Solo ingrese Numeros");
                    input.nextLine();
                }
            }
            inputNotNull = true;
            while (numero < 0 || numero > usuario.getTiquetes().size()){
                System.out.println("Ingrese una opcion valida");
                while (inputNotNull) {
                    try {
                        numero = input.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        input.nextLine();
                    }
                }
                inputNotNull = true;
            }
            inputNotNull = true;
            if (usuario.getTiquetes().get(numero-1).isCheckIn()==true){
                System.out.println("Ya se hizo Chek-in en este tiquete, no se puede reembolsar");
                return;
            }
            Funcion.agregarCargaExtra(usuario.getTiquetes().get(numero-1));
        }
    }

//Siguiente Funcion

    public static void checkIn(Usuario usuario){
        Scanner input = new Scanner(System.in);
        int numero = -1;
        int confirmacion = -1;
        boolean inputNotNull = true;
        System.out.println("\nPor favor, escoja el numero del tiquete para el cual desea realizar Check-in:\n");
        for (Tiquete tiquete : usuario.getTiquetes()){
            System.out.println(tiquete);
        }
        while (inputNotNull) {
            try {
                numero = input.nextInt();
                inputNotNull = false;

            }catch (InputMismatchException e) {
                System.err.println("Solo ingrese Numeros");
                input.nextLine();
            }
        }
        inputNotNull = true;
        while (numero < 0 || numero > usuario.getTiquetes().size()){
            System.out.println("Ingrese una opcion valida");
            while (inputNotNull) {
                try {
                    numero = input.nextInt();
                    inputNotNull = false;
    
                }catch (InputMismatchException e) {
                    System.err.println("Solo ingrese Numeros");
                    input.nextLine();
                }
            }
            inputNotNull = true;
        }
        inputNotNull = true;
        Tiquete tiquete = usuario.getTiquetes().get(numero);
        System.out.println("\nUsted ha escogido su tiquete #"+ numero +", asociado al vuelo "+ tiquete.getVuelo().getIdVuelo()+", el cual partira el "+ tiquete.getVuelo().getFecha() +" A las "+  tiquete.getVuelo().getHoraSalida()+"\n");
        System.out.println("Desea realizar su Check-in para este vuelo? No podra realizar mas cambios en su tiquete ni solicitar reembolsos");
        System.out.println("1. Confirmar");
        System.out.println("0. Rechazar");
        while (inputNotNull) {
            try {
                confirmacion = input.nextInt();
                inputNotNull = false;
            }catch (InputMismatchException e) {
                System.err.println("Solo ingrese Numeros");
                input.nextLine();
            }
        }
        inputNotNull = true;
        while (confirmacion != 0 & confirmacion!=1){
            System.out.println("Ingrese una opcion valida");
            while (inputNotNull) {
                try {
                    numero = input.nextInt();
                    inputNotNull = false;
                }catch (InputMismatchException e) {
                    System.err.println("Solo ingrese Numeros");
                    input.nextLine();
                }
            }
            inputNotNull = true;
        }
        if (confirmacion==1){
            tiquete.setCheckIn(true);
            System.out.println("\nCheck-in realizado con exito, disfrute su vuelo!");
        }
        else{
            System.out.println("\nProceso anulado, por favor recuerde realizar su Check-in con anticipacion");
        }
    }

//Siguiente Funcion

    public static void verTodosLosVuelos(){
        System.out.println("\nVuelos disponoibles:\n");
        for(Vuelo vuelo: Vuelo.getVuelos()){
            System.out.println(vuelo.toString());
        }
        System.out.println("");
    }

//Siguiente Funcion

    public static void agregarCargaExtra(Tiquete tiquete){
        ArrayList<CargaExtra> cargas = new ArrayList<CargaExtra>();
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        if (tiquete.isCheckIn()==true){
            System.out.println("Ya se hizo Chek-in en este tiquete, no se puede agregar carga extra");
            return;
        }
        while(loop){
            System.out.println("\n1. Equipaje extra");
            System.out.println("2. Mascota");
            System.out.println("3. Siguiente");
            int eleccion = 0;
            boolean inputNotNull = true;
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
            while (eleccion != 3 & eleccion != 1 & eleccion != 2){
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
            if(eleccion == 1){
                System.out.println("\n1. Equipaje de mano");
                System.out.println("2. Equipaje de bodega");
                System.out.println("0. Regresar");
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
                while (eleccion != 0 & eleccion != 1 & eleccion != 2){
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
                if(eleccion == 1){
                    System.out.println("\nPrecio: $"+PreciosExtra.equipajeMano);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
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
                    while (eleccion != 1 & eleccion != 0){
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
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.equipajeMano, "Equipaje de mano"));
                    }
                }else if(eleccion==2){
                    System.out.println("\nPrecio: $"+PreciosExtra.equipajeBodega);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
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
                    while (eleccion != 1 & eleccion != 0){
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
                while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion !=3){
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
                if(eleccion == 1){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaP);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
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
                    while (eleccion != 1 & eleccion != 0){
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
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaP, "Mascota pequeña"));
                    }
                }else if(eleccion==2){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaM);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
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
                    while (eleccion != 1 & eleccion != 0){
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
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaM, "Mascota mediana"));
                    }
                }else if(eleccion==3){
                    System.out.println("\nPrecio: $"+PreciosExtra.mascotaG);
                    System.out.println("1. Confirmar");
                    System.out.println("0. Rechazar");
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
                    while (eleccion != 1 & eleccion != 0){
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
                    if(eleccion == 1){
                        cargas.add(new Equipaje(PreciosExtra.mascotaG, "Mascota grande"));
                    }
                }
            }
            if(eleccion == 3){
                loop = false;
                tiquete.setCargaExtra(cargas);
                return;
            }
        }
    }

//Siguiente Funcion

    public static Usuario login(){
        System.out.println("\nUsuario: ");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        Usuario prov = null;
        if(!Usuario.isUsuarioExist(username)){
            System.out.println("\nUsuario inexistente");
            return null;
        }
        for(Usuario u : Usuario.getUsuarios()){
            if(u.getId().equals(username)){
                prov = u;
                break;
            }
        }
        System.out.println("\nContraseña: ");
        String password = input.nextLine();
        if(password.equals(prov.getPassword())){return prov;}
        System.out.println("\nContraseña incorrecta");
        return null;
    }
    public static Usuario crearUsuario(){
        System.out.println("\nIngrese un nombre de Usuario: ");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        while(Usuario.isUsuarioExist(username)){
            System.out.println("\nUsuario existente");
            System.out.println("\nIngrese su nombre de Usuario: ");
            input = new Scanner(System.in);
            username = input.nextLine();
        }
        System.out.println("\nIngrese una Contraseña: ");
        String password = input.nextLine();
        return new Usuario(username,password,0);
    }
    
}