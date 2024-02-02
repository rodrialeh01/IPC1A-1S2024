/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class Clase2 {
    public static int[][] matriztabla = new int[8][8]; 
    public static boolean[][] penalizaciones = new boolean [8][8];
    public static String[][] movimientos = new String[8][8];
    public static void main(String[] args) {
        //ARRAY UNIDIMENSIONAL
        /*
        int[] arreglo_notas = new int[20];
        
        System.out.print("[");
        for (int i = 0; i < arreglo_notas.length; i++) {
            System.out.print(+arreglo_notas[i]+" | ");
        }
        System.out.print("]");
        */
        Scanner leer = new Scanner(System.in);
        
        int[] notas = new int[3];
        /*
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese una nota: ");
            int nota = leer.nextInt();
            notas[i] = nota;
        }
        
        //IMPRIMIR UN ARREGLO
        //FOR AUTOMATICO = FOR + TAB
        
        //[61,60,85]
        for (int i = 0; i < notas.length; i++) {
            System.out.println("notas[" + i + "] = " + notas[i] );
        }
        */
        /*String[] cadenas = new String[2];
        
        cadenas[0] = "Rodrigo";
        cadenas[1] = "Alejandro";
        cadenas[2] = "Hernández";
        System.out.println(cadenas[2]);
        */
        
        //MATRICES
        //[X][Y] = [FILAS][COLUMNAS] = [i][j]
        int[][] matriz = new int[6][6];
        //impresion por filas y luego columnas
        /*
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= matriz[i].length-1; j++) {
                System.out.print("[" + i + "," + j +"]  |");
            }
            System.out.println("");
        }
        
        System.out.println("-----------------------------------------");
        for (int i = matriz.length; i >= 0; i--) {
            for (int j = matriz[i].length-1; j >=0; j--) {
                System.out.print("[" + i + "," + j +"]  |");
            }
            System.out.println("");
        }
        */
        /*
        MATRIZ = [ [1,2] , [3,4] ]
        [[1,2],
         [3,4]]
        MATRIZ.LENGTH = 2 //FILAS
        MATRIZ[0].LENGTH = 2 //COLUMNAS
        */
        int contador = 1;
        for (int i = 0; i < matriztabla.length; i++) {
            for (int j = 0; j < matriztabla[i].length; j++) {
                matriztabla[i][j] = contador;
                contador++;
            }
        }
        
        
        for (int i = 0; i < matriztabla.length; i++) {
            for (int j = 0; j < matriztabla[i].length; j++) {
                System.out.print("[" + i + "," + j + "] = " + matriztabla[i][j] + "|");
            }
            System.out.println("");
        }
        
    }
    
}
