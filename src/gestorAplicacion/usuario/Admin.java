package gestorAplicacion.usuario;
import java.util.*;

import gestorAplicacion.logistica.*;

public class Admin  extends Usuario{
    
    private static ArrayList<Admin> adminList = new ArrayList<Admin>();
    
    //constructores
    public Admin(String id, String password) {
        super(id, password, 0);
        adminList.add(this);
    }


    //metodos
    public static void vuelosRandom(int n){
        ArrayList<Ciudad> ciudades = Ciudad.getCiudades();
        ArrayList<Avion> aviones = Avion.getAviones();
        for(int i=0; i<n; i++){
            boolean loop = true;
            while(loop){
                int avion = (int) (Math.random()*aviones.size());
                int origen = (int) (Math.random()*ciudades.size());
                int destino = (int) (Math.random()*ciudades.size());
                int hora_s = (int) (Math.random()*21);
                int hora_l = (int) (Math.random()*2+hora_s+1);
                int dia = (int) (Math.random()*27+1);
                int mes =(int) (Math.random()+11);
                int p = (int) (Math.random()*5+1);
                int tarifa = (int) (Math.random()*300000+200000);
                    if(origen!=destino){
                        String fecha = dia+"/"+mes+"/2022";
                        if(dia<10){
                            fecha = "0"+dia+"/"+mes+"/2022";
                        }else{
                            fecha = dia+"/"+mes+"/2022";
                        }
                        String puerto = String.valueOf(p);
                        String horaSalida;
                        String horaLlegada;
                        if(hora_s<10){
                            horaSalida = "0"+hora_s+":"+"00";
                        }else{
                            horaSalida = hora_s+":"+"00";
                        }
                        if(hora_l<10){
                            horaLlegada = "0"+hora_l+":"+"00";
                        }else{
                            horaLlegada = hora_l+":"+"00";
                        }
                        new Vuelo(aviones.get(avion), ciudades.get(origen), ciudades.get(destino), horaSalida, horaLlegada, fecha, tarifa, puerto);
                        loop = false;
                    }
            }
        }
    }
    public void gestorSistema(){
        Scanner input = new Scanner(System.in);
        boolean inputNotNull = true;
        int eleccion = 0;
        System.out.println("\n1. Gestor de vuelos");
        System.out.println("2. Gestor de ciudades");
        System.out.println("3. Gestor de aviones");
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
        while (eleccion != 3 & eleccion != 1 & eleccion != 2 & eleccion != 0){
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
        switch(eleccion){
            case 1:{
                System.out.println("\n1. Agregar vuelo");
                System.out.println("2. Eliminar vuelo");
                System.out.println("3. Ver vuelos");
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
                while (eleccion != 0 & eleccion != 1 & eleccion != 2 & eleccion != 3){
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
                if(eleccion == 3){
                    for(Vuelo vuelo : Vuelo.getVuelos()){System.out.println(vuelo);}
                }else if(eleccion == 1){
                    int count = 1;
                    for(Ciudad ciudad: Ciudad.getCiudades()){
                        System.out.println(count+". "+ciudad);
                        count++;
                    }
                    System.err.println("\nSeleccione la ciudad de origen");
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
                    while ((eleccion-1)> Ciudad.getCiudades().size()){
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
                    Ciudad orgien = Ciudad.getCiudades().get(eleccion-1);
                    count = 1;
                    for(Ciudad ciudad: Ciudad.getCiudades()){
                        System.out.println(count+". "+ciudad);
                        count++;
                    }
                    System.err.println("\nSeleccione la ciudad de destino");
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
                    while ((eleccion-1)> Ciudad.getCiudades().size()){
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
                    Ciudad destino = Ciudad.getCiudades().get(eleccion-1);
                    count = 1;
                    for(Avion avion: Avion.getAviones()){
                    System.out.println(count+". "+avion);
                    count++;
                    }
                    System.err.println("\nSeleccione un avion");
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
                    while ((eleccion-1)> Avion.getAviones().size()){
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
                    Avion avion = Avion.getAviones().get(eleccion-1);
                    System.err.println("\nIngrese la fecha del vuelo DD/MM/AAAA");
                    String fecha = input.nextLine();
                    System.err.println("\nIngrese la hora de salida hh:mm");
                    String hs = input.nextLine();
                    System.err.println("\nIngrese la hora de llegada hh:mm");
                    String hl = input.nextLine();
                    System.err.println("\nIngrese la tarifa base del vuelo");
                    int tarifa = input.nextInt();
                    System.err.println("\nIngrese el puerto de embarque");
                    String puerto = input.nextLine();
                    Vuelo vuelo = new Vuelo(avion, orgien, destino, hs, hl, fecha, tarifa, puerto);
                    System.out.println("El vuelo: "+ vuelo);
                    System.out.println("Fue creado exitosamente");
                }else if(eleccion == 2){
                    int count = 1; 
                    for(Vuelo vuelo: Vuelo.getVuelos()){
                        System.out.println(count+". "+vuelo);
                        count++;
                    }
                    System.err.println("\nSeleccione el vuelo que desea eliminar");
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
                    while ((eleccion-1)> Vuelo.getVuelos().size()){
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
                    Vuelo.getVuelos().remove(eleccion-1);
                }
                break;
            }
            case 2:{
                System.out.println("\n1. Agregar nueva ciudad");
                System.out.println("2. Eliminar ciudad");
                System.out.println("3. Ver ciudades");
                System.out.println("0. Regresar");
                while (inputNotNull) {
                    try {
                        eleccion = input.nextInt();
                        inputNotNull = false;
        
                    }catch (InputMismatchException e) {
                        System.err.println("Solo ingrese Numeros");
                        input.nextLine();
                    }
                if(eleccion==1){
                    System.err.println("Ingrese el  nomebres");
                    String nombre = input.nextLine();
                    System.err.println("Solo ingrese Numeros");
                    String pais = input.nextLine();
                    new Ciudad(nombre, pais);
                }
                }
                inputNotNull = true;
                while (eleccion != 3 & eleccion != 1 & eleccion != 2 & eleccion != 0){
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
                if(eleccion == 3){
                    for(Ciudad ciudad : Ciudad.getCiudades()){System.out.println(ciudad);}
                }else if(eleccion == 1){
                    System.err.println("\nIngrese el nombre de la ciudad");
                    String nombre = input.nextLine();
                    System.err.println("\nIngrese el pais de la ciudad");
                    String Pais = input.nextLine();
                    new Ciudad(nombre, Pais);
                    System.err.println("\nCiudad creada exitosamente");
                }else if(eleccion == 2){
                    int count = 1; 
                    for(Ciudad ciudad: Ciudad.getCiudades()){
                        System.out.println(count+". "+ciudad);
                        count++;
                    }
                    System.err.println("\nSeleccione la ciudad que desea eliminar");
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
                    while ((eleccion-1)> Ciudad.getCiudades().size()){
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
                    Ciudad.getCiudades().remove(eleccion-1);
                }
                break;
            }
            case 3:{
                System.out.println("\n1. Agregar nuevo avion");
                System.out.println("2. Eliminar avion");
                System.out.println("3. Ver aviones");
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
                while (eleccion != 3 & eleccion != 1 & eleccion != 2 & eleccion != 0){
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
                if(eleccion == 3){
                    for(Avion avion : Avion.getAviones()){System.out.println(avion);}
                }if(eleccion == 1){
                    System.err.println("\nIngrese el modelo del avion");
                    String modelo = input.nextLine();
                    System.err.println("\nIngrese el numero de asientos");
                    int asientos = input.nextInt();
                    new Avion(modelo, asientos);
                    System.err.println("Avion creada exitosamente");
                }else if(eleccion == 2){
                    int count = 1; 
                    for(Avion avion: Avion.getAviones()){
                        System.out.println(count+". "+avion);
                        count++;
                    }
                    System.err.println("\nSeleccione el vuelo que desea eliminar");
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
                    while ((eleccion-1) > Avion.getAviones().size()){
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
                    Avion.getAviones().remove(eleccion-1);
                }
                break;
            }
            case 0:{
                return;
            }
        }
    }




    //getter and setter
    public static ArrayList<Admin> getAdminList() {
        return adminList;
    }
    public static void setAdminList(ArrayList<Admin> adminList) {
        Admin.adminList = adminList;
    }


}
