/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.LinkedList;
import Clases.Curso;
/**
 *
 * @author rodri
 */
public class Estudiante extends Usuario{
    private String carrera;
    private LinkedList<Curso> cursos;

    public Estudiante(String carrera, LinkedList<Curso> cursos, String nombres, String apellidos, String password, String genero, int edad) {
        super(nombres, apellidos, password, genero, edad);
        this.carrera = carrera;
        this.cursos = cursos;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the cursos
     */
    public LinkedList<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(LinkedList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void agregarCurso(Curso curso){
        this.cursos.add(curso);
    }
    
}
