
package Clases;
import clase4.Clase4;
public class Usuario {
    //ATRIBUTOS
    private int codigo;
    private String username;
    private String nombre;
    private String password;
    
    //CONSTRUCTOR
    public Usuario(String username, String nombre, String password) {
        this.codigo = Clase4.contador;
        this.username = username;
        this.nombre = nombre;
        this.password = password;
    }
    
    //MÉTODOS
    
    public void imprimir(){
        System.out.println("------- OBJETO USUARIO -------");
        System.out.println("Código de usuario: " + this.codigo);
        System.out.println("Nombre de usuario: " + this.username);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Contraseña: " + this.password);
        System.out.println("------------------------------");
    }
    
    //ENCAPSULAMIENTO

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
