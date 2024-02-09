/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase3;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class Clase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        try{
            menu();
        }catch(Exception e){
            System.out.println("No ingrese algo que no sea un numero");
            menu();
        }
    }
    
    public static void menu(){
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("MENU!");
            System.out.println("1. opcion 1");
            System.out.println("2. opcion 2");
            System.out.println("3. Salir");
            opcion = leer.nextInt();
        }while(opcion != 3);
    }
    
}
