package baseDatos;
import java.io.*;
import java.util.*;
import gestorAplicacion.usuario.*;
import gestorAplicacion.logistica.*;

public class Persistencia {

    public static void serializar() {
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\vuelos.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Vuelo.getVuelos());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\aviones.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Avion.getAviones());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\ciudades.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Ciudad.getCiudades());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\usuarios.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Usuario.getUsuarios());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\admins.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Admin.getAdminList());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\pasajeros.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Pasajero.getPasajeros());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        try {
            FileOutputStream f = new FileOutputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\tiquetes.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(Tiquete.getTiquetes());
            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
    }

    public static void deserializar() {
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\vuelos.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Vuelo.setVuelos((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\aviones.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Avion.setAviones((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\ciudades.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Ciudad.setCiudades((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\usuarios.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Usuario.setUsuarios((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\admins.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Admin.setAdminList((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\pasajeros.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Pasajero.setPasajeros((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fi = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\baseDatos\\temp\\tiquetes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Tiquete.setTiquetes((ArrayList) oi.readObject());
            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
