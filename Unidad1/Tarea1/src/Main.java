import java.util.Scanner;
import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        do {
            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            // to see how IntelliJ IDEA suggests fixing it.
            System.out.println("===================================");
            System.out.println("       MENU PRINCIPAL TAREA 1");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Tablas de multiplicar");
            System.out.println("2. Área del triángulo");
            System.out.println("3. Cálculo de IVA");
            System.out.println("4. Numero aleatorio");
            System.out.println("5. Información del programador");
            System.out.println("6. Salir");
            System.out.print("> ");
            opcion = leer.nextInt();
            System.out.println("");
            switch (opcion){
                case 1:
                    System.out.print("Ingresa el numero que quieras mostrar las tablas de multiplicar: ");
                    int numero = leer.nextInt();
                    TablasMultiplicar(numero);
                    break;
                case 2:
                    System.out.print("Ingrese la base del triángulo (no decimales): ");
                    int base = leer.nextInt();
                    System.out.print("Ingrese la altura del triángulo (no decimales): ");
                    int altura = leer.nextInt();
                    System.out.println("El área del triángulo es: " + AreaTriangulo(base, altura) + " unidades cuadradas");
                    break;
                case 3:
                    IVA();
                    break;
                case 4:
                    NumeroRandom();
                    break;
                case 5:
                    Presentacion();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("[ERROR] Ingresó una opción invalida");
                    break;
            }
        }while(opcion != 6);
        System.out.println("Gracias por usar mi programa, Adiós! :D");
    }

    public static void TablasMultiplicar(int numero){
        System.out.println("------------------------------------------");
        System.out.println("   TABLAS DE MULTIPLICAR DEL NUMERO " + numero);
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " * " + i + " = " + (numero*i));
        }
    }

    public static double AreaTriangulo(int base, int altura){
        return (base*altura)/2;
    }

    public static void IVA(){
        Scanner leer2 = new Scanner(System.in);
        System.out.print("Ingrese el precio de su producto: ");
        double precio = leer2.nextDouble();
        double total = precio + (precio *0.12);
        System.out.println("-------------------------");
        System.out.println("El precio sin IVA es: Q" + precio);
        System.out.println("El precio con IVA es: Q" + total);
        System.out.println("-------------------------");
    }

    public static void NumeroRandom(){
        Scanner leer2 = new Scanner(System.in);
        System.out.print("Ingrese desde qué número quiere su número random: ");
        int desde = leer2.nextInt();
        System.out.print("Ingrese hasta qué numero quiere su número random: ");
        int hasta = leer2.nextInt();
        int numrandom = new Random().nextInt(hasta - desde + 1) +  desde;
        System.out.println("-------------------------------------------");
        System.out.println("Su número aleatorio entre " + desde +  " hasta " + hasta + " es: " +  numrandom);
        System.out.println("-------------------------------------------");
    }

    public static void Presentacion(){
        System.out.println("========================================================");
        System.out.println("= Nombre: Rodrigo Alejandro Hernández de León          =");
        System.out.println("= Carnet: 201900042                                    =");
        System.out.println("= Curso: Introducción a la Programación y Computación 1=");
        System.out.println("= Sección: A                                           =");
        System.out.println("= Semestre: Primer Semestre de 2024                    =");
        System.out.println("========================================================");
    }
}

