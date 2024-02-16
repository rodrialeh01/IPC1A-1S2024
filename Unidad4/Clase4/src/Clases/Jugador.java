/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rodri
 */
public class Jugador extends Usuario{
    
    private int vidas;
    
    public Jugador(String username, String nombre, String password) {
        super(username, nombre, password);
        this.vidas = 3;
    }
    
    //IMPRIMIR
    /*public void imprimir(){
        System.out.println("------- OBJETO JUGADOR -------");
        System.out.println("Código de usuario: " + this.getCodigo());
        System.out.println("Nombre de usuario: " + this.getUsername());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Contraseña: " + this.getPassword());
        System.out.println("Vidas: " +  this.vidas);
        System.out.println("------------------------------");
    }*/

    /**
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    
    
    
}
