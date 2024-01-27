
package ejemplo1;
import java.util.Scanner;
/**
 *
 * @author rodri
 */
public class Ejemplo1 {

    public static void main(String[] args) {
        // Este es el primer ejemplo de un comentario simple
        /*
            HOY ES:
                26 DE ENERO DE 2024
            CLASE:
                INTRODUCCION A JAVA CON UN EJEMPLO DE COMENTARIO MULTILINEA
        */
        
        //DECLARACIÓN DE VARIABLES
        //NÚMEROS
        /*int numero1 = 10;
        double numero2 = 10.0;
        //CARACTERES
        char caracter = 'a';
        String cadena = "Hola mundo \n \t ";
        
        double total = numero1 + numero2;
        
        //sout + TAB
        System.out.print("El total es " + total);
        System.out.println("Hola Mundo!");
        
        //clase SCANNER
        Scanner leer = new Scanner(System.in);
        try{
            System.out.println("Ingrese un numero: ");
            int num1 = leer.nextInt();
            System.out.println("Ingrese otro numero: ");
            int num2 = leer.nextInt();
            int totalinput = num1 + num2;
            System.out.println("El total de la suma es: " + totalinput);
        }catch(Exception e){
            System.out.println("Ingresaste un decimal :C");   
        }
        */
        //IF
        /*
        if (5 > 6) {
            System.out.println("Incorrecto");
            if(true){
                if(false){
                    System.out.println("6");
                }
            }
        }else if("Holaaaaa".equals("Hola")){
            System.out.println("Hola mundo!");
        }else{
            System.out.println("No cumple ninguna de las anteriores");
        }
        */
        //SWITCH
        /*int x = 5;
        
        switch(x){
            case 1:
                System.out.println("uno");
                break;
            case 2:
                System.out.println("dos");
                break;
            case 3:
                System.out.println("tres");
                break;
            case 4:
                System.out.println("cuatro");
                break;
            case 5:
                System.out.println("cinco");
                break;
            default:
                System.out.println("es mayor que cinco");
                break;
        }*/
        
        //WHILE
        /*
        int contador = 0;
        while(contador <= 10){
            System.out.println(contador);
            //ASIGNACION
            //contador = contador + 1;
            //contador += 1;
            //INCREMENTO
            contador++;
        }
        */
        Scanner leer = new Scanner(System.in);
        //DO WHILE
        int opcion =3;
        do{
            System.out.println("========MENU===========");
            System.out.println("1. SUMA");
            System.out.println("2. RESTA");
            System.out.println("4. MULTI");
            System.out.println("3. SALIR");
            System.out.print("Escoge una opcion: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    metodoSuma();
                    break;
                case 2:
                    System.out.println("---------RESTA-----------");
                    System.out.print("Ingrese un numero");
                    int nume1 = leer.nextInt();
                    System.out.print("Ingrese otro numero");
                    int nume2 = leer.nextInt();
                    System.out.println("El resultado de la resta es: " + funcionResta(nume1,nume2));
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("---------MULTI-----------");
                    System.out.print("Ingrese un numero");
                    int numer1 = leer.nextInt();
                    System.out.print("Ingrese otro numero");
                    int numer2 = leer.nextInt();
                    multiplicacion(numer1,numer2);
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
        }while(opcion != 3);
        
        
        //for
        /*int contador = 0;
        for (contador = 0; contador < 10; contador++) {
            
        }
        for (int i = 0; i <=10; i++) {
            System.out.println(i);
        }*/
    }
    
    //METODO SUMA
    public static void metodoSuma(){
        Scanner leer = new Scanner(System.in);
        System.out.println("-----------SUMA---------------");
        System.out.print("Ingrese un numero");
        int num1 = leer.nextInt();
        System.out.print("Ingrese otro numero");
        int num2 = leer.nextInt();
        System.out.println("El resultado es: " + (num1+num2));
    }
    public static void multiplicacion(int num1, int num2){
        int total = num1 * num2;
        System.out.println("El resultado es: " + total);
    }
    
    //FUNCION DE RESTA
    public static int funcionResta(int num1, int num2){
        int total = num1 - num2;
        return total;
    }
}
