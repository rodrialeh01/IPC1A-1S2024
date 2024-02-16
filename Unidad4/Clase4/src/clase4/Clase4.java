
package clase4;

import java.util.LinkedList;
import java.util.Scanner;

import Clases.Jugador;
import Clases.Usuario;

public class Clase4 {
    public static int contador;
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String username;
        String nombre;
        String contrasenia;
        //INSTANCIA
        // NOMBRE_OBJETO nombre_variable = new NOMBRE_OBJETO(INSERTAN LOS PARAMETROS OBLIGATORIOS DEL CONSTRUCTOR);
        Usuario usuario1 = new Usuario("rodrialeh", "Rodrigo", "12345");
        usuario1.imprimir();
        /*
        System.out.println("-------REGISTRO DE USUARIOS----------");
        System.out.print("Ingese un username: ");
        username = leer.next();
        System.out.print("Ingrese su nombre: ");
        nombre = leer.next();
        System.out.println("Ingrese su nueva password: ");
        contrasenia = leer.next();
        Usuario user = new Usuario(username, nombre, contrasenia);
        user.imprimir();
        
        System.out.println("----- UPS, SE TE OLVIDO LA CONTRASEÑA, VEN A GENERAR UNA NUEVA ----");
        System.out.print("Ingrese su nueva contraseña: ");
        String nuevacontrasenia = leer.next();
        user.setPassword(nuevacontrasenia);
        user.imprimir();*/
        
        //CREAR UNA LISTA
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
        
        /*System.out.println("----- REGISTRO DE USUARIOS ------");
        for (int i = 0; i < 2; i++) {
            System.out.print("Ingrese un nuevo Username: ");
            String user = leer.next();
            System.out.print("Ingrese su Nombre: ");
            String name = leer.next();
            System.out.print("Ingrese una nueva Contrasenia: ");
            String pass = leer.next();
            
            //1. CREO EL OBJETO
            Usuario usuario = new Usuario(user,name,pass);
            //2. AÑADIR A LA LISTA
            usuarios.add(usuario);
            //AUMENTO EL CODIGO DEL CONTADOR
            contador++;
        }
        
        //MOSTRAR TODOS LOS USUARIOS REGISTRADOS
        for (int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).imprimir();
        }
        */
        
        //CREAR UN OBJETO JUGADOR
        Jugador player1 = new Jugador("rodriale", "Rodrigo", "holamundo123");
        player1.imprimir();
    }
    
}
