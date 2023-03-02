/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internshipchallenge;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Abdeel
 */
public class InternshipChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (
        Scanner scan = new Scanner(System.in)) {
            boolean salir = false; // variable para el loop while
            int opcion; //variable para las opciones en el menú
            int opt; //variable para seleccion de reordenamiento
            Double ind; //variable para index de lista reordenada
            int largoLista;
            Lista lista1 = new Lista();

            ///variables str para opciones
            String opcion0 = "0 - Opciones menú";
            String opcion1 = "1 - Generar nueva lista";
            String opcion2 = "2 - Leer lista generada";
            String opcion3 = "3 - Ordenar lista";
            String opcion4 = "4 - Leer lista ordenada";
            String opcion5 = "5 - Buscar número en lista ordenada.";
            String opcion6 = "6 - Salir";

            ///print menú inicial
            System.out.println("\n--- Internship Challenge ---");
            System.out.println("----------------------------");
            System.out.println(opcion0);
            System.out.println(opcion1);
            System.out.println(opcion2);
            System.out.println(opcion3);
            System.out.println(opcion4);
            System.out.println(opcion5);
            System.out.println(opcion6);
            System.out.println("----------------------------");

            while (!salir) {

                try {

                    System.out.print("\nIngresar opción del menú principal (0 para mostrar opciones): ");
                    opcion = scan.nextInt();
                    switch (opcion) {
                        case 0: // imprimir opciones
                            System.out.println(opcion0);
                            System.out.println(opcion1);
                            System.out.println(opcion2);
                            System.out.println(opcion3);
                            System.out.println(opcion4);
                            System.out.println(opcion5);
                            System.out.println(opcion6);
                            break;
                        case 1: // 
                            System.out.print("\nIngrese la cantidad de número que quiere generar: ");
                            largoLista = scan.nextInt();
                            if (largoLista > 0) {
                                lista1.getListaNums().clear(); /// reiniciar lista
                                lista1.generarNúmeros(largoLista);
                                System.out.println("\nLa lista ha sido creado correctamente");
                            } else {
                                System.out.println("\nLa lista no ha podido ser creada, por favor ingrese un número válido.");
                            }
                            break;
                        case 2:
                            if (lista1.getListaNums().size() > 0) {
                                System.out.println("\nLista: ");
                                lista1.mostrarLista();
                            } else {
                                System.out.println("\nNinguna lista no ha sido creada.");
                            }

                            break;
                        case 3:
                            try {
                            if (lista1.getListaNums().size() > 0) {
                                System.out.println("\nElija el tipo de reordenamiento: ");
                                System.out.println("1- Collections Sort");
                                System.out.println("2- Bubble Sort");
                                System.out.println("3- Parallalel Sort");
                                System.out.println("4- Heap Sort");
                                System.out.println("5- Quick Sort");
                                System.out.print("\nIngrese su opción: ");
                                opt = scan.nextInt();

                                switch (opt) {
                                    case 1:
                                        System.out.println("\nOrdenamiento Collections Sort");
                                        lista1.reordenarListaSort(opt);
                                        break;
                                    case 2:
                                        lista1.reordenarListaSort(opt);
                                        System.out.println("\nBubble Sort");
                                        break;
                                    case 3:
                                        lista1.reordenarListaSort(opt);
                                        break;
                                    case 4:
                                        lista1.reordenarListaSort(opt);
                                        break;
                                    case 5:
                                        lista1.reordenarListaSort(opt);
                                        break;
                                    default:
                                        System.out.println("\nElija opciones entre 1 y 5.");
                                        break;
                                }

                            } else {
                                System.out.println("\nNinguna lista no ha sido creada.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.print("\nDebes elegir una opción.\n");
                            scan.next();
                        }
                        break;
                        case 4:
                            if (lista1.getListaNums().size() > 0) {
                                lista1.mostrarListaReordenada();

                            } else {
                                System.out.println("\nAún no ha reordenado la lista.");
                            }
                            break;
                        case 5:
                            System.out.print("\nIngresar número para buscar en lista ordenada: ");
                            ind = scan.nextDouble();
                            if (lista1.buscarNúmero(ind) > 0) {
                                System.out.println("\nEl número " + ind + " está en la posición " + lista1.buscarNúmero(ind));
                            } else if(lista1.buscarNúmero(ind) == 0){
                                
                                System.out.println("\nEl número no existe en la lista.");
                            }else{
                                System.out.println("\nLa lista no existe o aún no la ha reordenado.");
                            }
                            break;
                        case 6:
                            System.out.println("\nAdiós");
                            salir = true;
                            break;
                        default:
                            System.out.println("\nElija opciones entre 1 y 6.");
                    }

                } catch (InputMismatchException e) {
                    System.out.print("\nDebes elegir una opción.\n");
                    scan.next();

                }
            }
        }

    }

}
