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
    public void creador_de_Viajes(){
        Scanner input = new Scanner(System.in);
        boolean inputNotNull = true;
        int eleccion = 0;
        System.out.println("1. Gestor de vuelos");
        System.out.println("2. Gestor de ciudades");
        System.out.println("3. Gestor de aviones");
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
        switch(eleccion){
            case 1:{
                System.out.println("1. Agregar vuelo");
                System.out.println("2. Eliminar vuelo");
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
                break;
            }
            case 2:{
                System.out.println("1. Agregar nueva ciudad");
                System.out.println("2. Eliminar ciudad");
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
                break;
            }
            case 3:{
                System.out.println("1. Agregar nuevo avion");
                System.out.println("2. Eliminar avion");
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
                
                break;
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
