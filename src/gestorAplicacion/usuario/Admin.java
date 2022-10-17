package gestorAplicacion.usuario;
import java.util.*;
import java.math.*;
import gestorAplicacion.*;
import gestorAplicacion.logistica.Avion;
import gestorAplicacion.logistica.Ciudad;
import gestorAplicacion.logistica.Vuelo;

import java.io.*;

public class Admin implements Serializable{
    
    static File archivo = new File("");
    private int id;
    private String password;

    //constructores
    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
        try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
            "\\src\\baseDatos\\Administradores.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
        } catch (FileNotFoundException e) {} catch (IOException e) {}
    }

    //metodos

    public static void vuelos_random(int n){
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
                int mes =(int) (Math.random()*2+10);
                int p = (int) (Math.random()*5+1);
                Double tarifa = (double) (Math.random()*500000.+80000.);
                    if(origen!=destino){
                        String fecha = dia+"/"+mes+"/2022";
                        String puerto = String.valueOf(p);
                        String hora_salida = hora_s+":"+"00";
                        String hora_llegada = hora_l+":"+"00";
                        new Vuelo(aviones.get(avion), ciudades.get(origen), ciudades.get(destino), hora_salida, hora_llegada, fecha, tarifa, puerto);
                        loop = false;
                    }
            }
        }
    }

    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
