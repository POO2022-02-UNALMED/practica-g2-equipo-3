package gestorAplicacion.usuario;

public class Admin {
    int id;
    String password;

    public Admin(int id, String password) {
        this.id = id;
        this.password = password;
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
