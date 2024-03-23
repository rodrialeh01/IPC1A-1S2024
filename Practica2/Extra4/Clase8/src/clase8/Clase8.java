/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase8;

import Clases.Curso;
import Clases.Estudiante;
import Clases.Profesor;
import GUI.VAuth;
import GUI.VentanaAdmin;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.JLabel;

/**
 *
 * @author rodri
 */
public class Clase8 {

    public static int codigo_general;
    public static LinkedList<Profesor> profesores = new LinkedList<Profesor>();
    public static LinkedList<Estudiante> estudiantes = new LinkedList<Estudiante>();
    public static LinkedList<Curso> cursos = new LinkedList<Curso>();

    //VARIABLES PARA SERIALIZACION
    public static ObjectInputStream oisc;
    public static ObjectOutputStream oosc;
    
    public static void main(String[] args) {
        //ABRIR ARCHIVO SERIALIZADO DE CURSOS
        cursos = (LinkedList<Curso>) DesserializarCursos();
        if(cursos != null){
            System.out.println("Si hay cursos guardados");
            for (Curso c: cursos) {
                System.out.println("------------------------------");
                System.out.println(c.getCodigo());
                System.out.println(c.getCreditos());
                System.out.println(c.getNombre());
            }
        }else{
            System.out.println("NO HAY CURSOS");
            cursos = new LinkedList<Curso>();
        }
        
        VentanaAdmin va = new VentanaAdmin();
        //VAuth ba = new VAuth();
    }

    //--------------------------SERIALIZACION--------------------------------
    
    //1. METODO PARA CREAR EL ARCHIVO BINARIO PARA LA SERIALIZACION DE LOS CURSOS
    public static void SerializarCursos(){
        try{
            oosc = new ObjectOutputStream(new FileOutputStream("Serializados/Cursos.bin"));
            oosc.writeObject(cursos);
            oosc.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //2. METODO PARA DESSERIALIZAR EL ARCHIVO BINARIO DE LOS CURSOS
    public static Object DesserializarCursos(){
        try{
            oisc = new ObjectInputStream(new FileInputStream("Serializados/Cursos.bin"));
            LinkedList<Curso> cursostemp = (LinkedList<Curso>) oisc.readObject();
            oisc.close();
            return cursostemp;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //CRUD PROFESOR
    //CREAR (C)
    public static void añadirProfesor(Profesor profe) {
        profesores.add(profe);
    }

    //OBTENER (R)
    public static Profesor mostrarProfesor(int codigo) {
        for (int i = 0; i < profesores.size(); i++) {
            if (codigo == profesores.get(i).getCodigo()) {
                return profesores.get(i);
            }
        }
        return null;
    }

    //ACTUALIZAR (U)
    public static void actualizarProfesor(int codigo, Profesor profe) {
        for (int i = 0; i < profesores.size(); i++) {
            if (codigo == profesores.get(i).getCodigo()) {
                profesores.set(i, profe);
            }
        }
    }

    //ELIMINAR (D)
    public static void eliminarProfesor(int codigo) {
        for (int i = 0; i < profesores.size(); i++) {
            if (codigo == profesores.get(i).getCodigo()) {
                profesores.remove(i);
            }
        }
    }

    //CRUD ESTUDIANTES
    //CREAR (C)
    public static void añadirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    //OBTENER (R)
    public static Estudiante mostrarEstudiante(int codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (codigo == estudiantes.get(i).getCodigo()) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    //ACTUALIZAR (U)
    public static void actualizarEstudiante(int codigo, Estudiante estudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (codigo == estudiantes.get(i).getCodigo()) {
                estudiantes.set(i, estudiante);
            }
        }
    }

    //ELIMINAR (D)
    public static void eliminarEstudiante(int codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (codigo == estudiantes.get(i).getCodigo()) {
                estudiantes.remove(i);
            }
        }
    }

    //CRUD CURSOS
    //CREAR (C)
    public static void añadirCurso(Curso curso) {
        cursos.add(curso);
        SerializarCursos();
    }

    //OBTENER (R)
    public static Curso mostrarCurso(int codigo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (codigo == cursos.get(i).getCodigo()) {
                return cursos.get(i);
            }
        }
        return null;
    }

    //ACTUALIZAR (U)
    public static void actualizarCurso(int codigo, Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (codigo == cursos.get(i).getCodigo()) {
                cursos.set(i, curso);
            }
        }
    }

    //ELIMINAR (D)
    public static void eliminarCurso(int codigo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (codigo == cursos.get(i).getCodigo()) {
                cursos.remove(i);
            }
        }
    }

    public static void MostrarCursos() {
        for (int i = 0; i < cursos.size(); i++) {
            cursos.get(i).mostrar();
        }
    }

    public static Object[][] convertirTablaCurso() {
        Object[][] cursostabla = new Object[cursos.size()][4];
        for (int i = 0; i < cursos.size(); i++) {
            cursostabla[i][0] = cursos.get(i).getCodigo();
            cursostabla[i][1] = cursos.get(i).getNombre();
            cursostabla[i][2] = cursos.get(i).getCreditos();
            JLabel nuevo = new JLabel("Accion");
            nuevo.setName("VerMas,"+String.valueOf(cursos.get(i).getCodigo()));
            cursostabla[i][3] = nuevo;
        }
        return cursostabla;
    }

    public static boolean AutenticacionProfesores(int codigo, String password) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getCodigo() == codigo && profesores.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean AutenticacionEstudiantes(int codigo, String password) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo() == codigo && estudiantes.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static Curso[] ordenamientoCursos() {
        Curso[] arreglo_cursos = new Curso[cursos.size()];
        for (int i = 0; i < cursos.size(); i++) {
            arreglo_cursos[i] = cursos.get(i);
        }
        try{
            for (int i = 1; i < arreglo_cursos.length; i++) {
                Curso aux =  arreglo_cursos[i];
                int j = i - 1;
                while((j>=0) && (aux.getCreditos() > arreglo_cursos[j].getCreditos())){
                    arreglo_cursos[j+1] = arreglo_cursos[j];
                    j--;
                }
                arreglo_cursos[j+1] = aux;
            }
            return arreglo_cursos;
        }catch(Exception e){
            return arreglo_cursos;
        }
    }

}
