/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author rodri
 */
public class Curso {
    private int codigo;
    private String nombre;
    private int creditos;

    public Curso(int Codigo, String nombre, int creditos) {
        this.codigo = Codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void mostrar(){
        System.out.println("====CURSO===");
        System.out.println("CODIGO: " + this.codigo);
        System.out.println("NOMBRE: " + this.nombre);
        System.out.println("CREDITOS: " + this.creditos);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * @return the creditos
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * @param creditos the creditos to set
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    
}
