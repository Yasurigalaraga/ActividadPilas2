import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {

        //Creo las dos pilas
        Stack<String> almacenDeDatos = new Stack<>();
        Stack<String> reciclajeDeDatos = new Stack<>();

        //Creo el scanner para capturar los datos por consola
        Scanner scan = new Scanner(System.in);

        //Creacion menu de opciones
        String menu = ">> MENU DE OPCIONES <<\n" +
            "\t1. Escribir texto\n" +
            "\t2. Deshacer\n" +
            "\t3. Rehacer\n" +
            "\t4. Mostrar texto actual\n" +
            "\t5. Salir\n";

        String elegirOpcion = "Elige una opcion: ";
        String escribirTexto = ">> Escriba un texto: ";

        String opcion = "";

        do {
            //mostrar menu
            System.out.println("\n" + menu);
            System.out.print(elegirOpcion);

            //elegir opcion
            opcion = scan.nextLine();

            // control de opciones de menu
            switch (opcion) {
                case "1":
                    //almacenando texto en una pila
                    System.out.print(escribirTexto);
                    String texto = scan.nextLine();
                    almacenDeDatos.push(texto);
                    break;
                case "2":
                    // eliminando texto de una pila y almacenandola en otra
                    if(almacenDeDatos.empty()){
                        System.out.println("No hay nada que deshacer.");
                    } else{
                        String desecho = almacenDeDatos.pop();
                        reciclajeDeDatos.push(desecho);
                        System.out.println("Eliminado.");
                    }
                    break;
                case "3":
                    //rehaciendo el texto eliminado
                    if(reciclajeDeDatos.empty()){
                        System.out.println("No hay nada para rehacer.");
                    }else{
                        String rehacer = reciclajeDeDatos.pop();
                        almacenDeDatos.push(rehacer);
                        System.out.println("Realizado.");
                    }
                    break;
                case "4":
                    // mostrando el texto en la parte superios de la pila
                    if(almacenDeDatos.empty()){
                        System.out.println("No hay nada que mostrar.");
                    }else {
                        System.out.println("Texto actual es: " + almacenDeDatos.peek());
                    }
                    break;
                case "5":
                    // fin del programa
                    System.out.println("\n>>     FIN DEL PROGRAMA     <<");
                    break;
                default:
                    // Opciones no validas
                    System.out.println("[Error] - Opcion " + opcion + " no es valido.");
                    System.out.println("Elija una opcion valida.");
            }

            // Tiempo de espera para volver a mostrar el menú
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (!opcion.equals("5"));

        System.out.println("Datos almacenados: " + almacenDeDatos);
        System.out.println("Datos Reciclados:  " + reciclajeDeDatos);
        System.out.println("\n");
        System.out.println("\n======================================================================");
        System.out.println("                            YASURY HERRERA");
        System.out.println("======================================================================");

    }

}