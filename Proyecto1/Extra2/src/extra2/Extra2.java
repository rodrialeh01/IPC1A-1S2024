/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extra2;
import GUI.VentanaAdmin;
import java.util.LinkedList;
import Clases.*;

/**
 *
 * @author rodri
 */

public class Extra2 {
    public static int codigo_general;
    public static LinkedList<Profesor> profesores = new LinkedList<Profesor>();
    public static LinkedList<Estudiante> estudiantes = new LinkedList<Estudiante>();
    public static LinkedList<Curso> cursos = new LinkedList<Curso>();
    
    public static void main(String[] args) {
        VentanaAdmin va = new VentanaAdmin();
    }
    
    //CRUD PROFESOR
    //CREAR (C)
    public static void añadirProfesor(Profesor profe){
        profesores.add(profe);
    }
    
    //OBTENER (R)
    public static Profesor mostrarProfesor(int codigo){
        for (int i = 0; i < profesores.size(); i++) {
            if(codigo == profesores.get(i).getCodigo()){
                return profesores.get(i);
            }
        }
        return null;
    }
    
    //ACTUALIZAR (U)
    public static void actualizarProfesor(int codigo, Profesor profe){
        for (int i = 0; i < profesores.size(); i++) {
            if(codigo == profesores.get(i).getCodigo()){
                profesores.set(i, profe);
            }
        }
    }
    
    //ELIMINAR (D)
    public static void eliminarProfesor(int codigo){
        for (int i = 0; i < profesores.size(); i++) {
            if(codigo == profesores.get(i).getCodigo()){
                profesores.remove(i);
            }
        }
    }
    
    //CRUD ESTUDIANTES
    //CREAR (C)
    public static void añadirEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    
    //OBTENER (R)
    public static Estudiante mostrarEstudiante(int codigo){
        for (int i = 0; i < estudiantes.size(); i++) {
            if(codigo == estudiantes.get(i).getCodigo()){
                return estudiantes.get(i);
            }
        }
        return null;
    }
    
    //ACTUALIZAR (U)
    public static void actualizarEstudiante(int codigo, Estudiante estudiante){
        for (int i = 0; i < estudiantes.size(); i++) {
            if(codigo == estudiantes.get(i).getCodigo()){
                estudiantes.set(i, estudiante);
            }
        }
    }
    
    //ELIMINAR (D)
    public static void eliminarEstudiante(int codigo){
        for (int i = 0; i < estudiantes.size(); i++) {
            if(codigo == estudiantes.get(i).getCodigo()){
                estudiantes.remove(i);
            }
        }
    }
    
    //CRUD CURSOS
    //CREAR (C)
    public static void añadirCurso(Curso curso){
        cursos.add(curso);
    }
    
    //OBTENER (R)
    public static Curso mostrarCurso(int codigo){
        for (int i = 0; i < cursos.size(); i++) {
            if(codigo == cursos.get(i).getCodigo()){
                return cursos.get(i);
            }
        }
        return null;
    }
    
    //ACTUALIZAR (U)
    public static void actualizarCurso(int codigo, Curso curso){
        for (int i = 0; i < cursos.size(); i++) {
            if(codigo == cursos.get(i).getCodigo()){
                cursos.set(i, curso);
            }
        }
    }
    
    //ELIMINAR (D)
    public static void eliminarCurso(int codigo){
        for (int i = 0; i < cursos.size(); i++) {
            if(codigo == cursos.get(i).getCodigo()){
                cursos.remove(i);
            }
        }
    }
    
    public static void MostrarCursos(){
        for (int i = 0; i < cursos.size(); i++) {
            cursos.get(i).mostrar();
        }
    }
}
