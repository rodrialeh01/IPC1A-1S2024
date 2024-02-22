/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extra1;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class Extra1 {

    /**
     * @param args the command line arguments
     */
    
    public static int[][] tablero = new int[8][8];
    public static String[][] movimientos = new String[8][8];
    public static String[][] penalizaciones = new String[8][8];
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int pos_tablero = 64;
        
        //llenar tablero de juego con numeros
        //PRIMER FOR: ES PARA FILAS
        for (int i = 0; i < 8; i++) {
            //ES PAR
            if(i%2== 0){
                for (int j = 0; j <=7; j++) {
                    tablero[i][j] = pos_tablero;
                    pos_tablero--;
                }
            //IMPAR
            }else{
                for (int j = 7; j >= 0; j--) {
                    tablero[i][j] = pos_tablero;
                    pos_tablero--;
                }
            }
        }
        
        //LLENAR TABLERO DE MOVIMIENTOS Y PENALIZACIONES
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                movimientos[i][j] = " ";
                penalizaciones[i][j] = " ";
            }
        }
        
        
        
        
        
        //llenar mi tablero de penalizaciones
        for (int i = 0; i < 8; i++) {
            //FORMA 1: CREAR UN VECTOR Y GENERAR LOS NUMEROS ENTRE 0 Y 7 Y SE FORMA ALEATORIA
            int[] random_nums = {6,3,4,5,2,1,7,0};
            //GENERE UN NUMERO RANDOM ENTRE 2 Y 4
            int random_iteraciones = 3;
            for (int j = 0; j < random_iteraciones; j++) {
                int posicion_j = random_nums[j];
                penalizaciones[i][posicion_j] = "#";
            }
        }
        
        //PRIMERO POSICIONAR LA FICHA INICIAL
        movimientos[7][0] = "@";
        int numero = 0;
        int posicion = 1;
        do{
            //MOSTRAR TABLERO
            for (int i = 0; i < 8; i++) {
                //IMPRIMIR NUMERO Y PENALIZACION
                for (int j = 0; j < 8; j++) {
                    if (tablero[i][j]<= 9) {
                        System.out.print("|" +  tablero[i][j] + penalizaciones[i][j] + " \t");
                    }else{
                        System.out.print("|" +  tablero[i][j] + penalizaciones[i][j] + "\t");
                    }
                }
                //IMPRIMIR FICHA 
                System.out.println("|");
                for (int j = 0; j < 8; j++) {
                    System.out.print("|" + movimientos[i][j]  + "  \t");
                }
                System.out.println("|");
            }
            System.out.print("Ingresa la cantidad de posiciones que quieras mover: ");
            numero = leer.nextInt();
            int[] posicion_anterior = posicion_tab(posicion);
            int x_anterior = posicion_anterior[0];
            int y_anterior = posicion_anterior[1];
            movimientos[x_anterior][y_anterior] = " ";
            
            //CALCULO DE NUEVA POSICION
            posicion = posicion + numero;
            int[] posiciones_nuevas = posicion_tab(posicion);
            int x_nuevo = posiciones_nuevas[0];
            int y_nuevo = posiciones_nuevas[1];
            movimientos[x_nuevo][y_nuevo] = "@";
            
            //VALIDO PENALIZACIONES
            if(penalizaciones[x_nuevo][y_nuevo] == "#"){
                if (x_nuevo == 7 || x_nuevo == 6) {
                    //VOY A PENALIZACION FACIL
                    System.out.println("FACIL");
                }else if(x_nuevo == 5 || x_nuevo == 4 || x_nuevo == 3){
                    //VOY A PENALIZACION INTERMEDIA
                    System.out.println("INTERMEDIA");
                }else if(x_nuevo == 2 || x_nuevo == 1 || x_nuevo == 0){
                    //VOY A PENALIZACION AVANZADA
                    System.out.println("AVANZADA");
                }
            }
        }while(numero >0);
    }
    
    //FUNCION PARA RETORNAR POSICION DE UN CUADRO DEL TABLERO
    public static int[] posicion_tab(int posicion){
        int[] vectorpos = new int[2]; 
        switch(posicion){
            case 1:
                vectorpos[0] = 7;
                vectorpos[1] = 0;
                return vectorpos;
            case 2:
                vectorpos[0] = 7;
                vectorpos[1] = 1;
                return vectorpos;
            case 3:
                vectorpos[0] = 7;
                vectorpos[1] = 2;
                return vectorpos;
            case 4:
                vectorpos[0] = 7;
                vectorpos[1] = 3;
                return vectorpos;
            case 5:
                vectorpos[0] = 7;
                vectorpos[1] = 4;
                return vectorpos;
            case 6:
                vectorpos[0] = 7;
                vectorpos[1] = 5;
                return vectorpos;
            case 7:
                vectorpos[0] = 7;
                vectorpos[1] = 6;
                return vectorpos;
            case 8:
                vectorpos[0] = 7;
                vectorpos[1] = 7;
                return vectorpos;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 41:
                break;
            case 42:
                break;
            case 43:
                break;
            case 44:
                break;
            case 45:
                break;
            case 46:
                break;
            case 47:
                break;
            case 48:
                break;
        }
        return null;
    }
}
