/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internshipchallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Abdeel
 */
public class Lista {

    private List<Double> listaNums; /// numeros random
    // private List<Double> listaNumsOrd; ///numeros ordenados
    Random rand = new Random();
    public double pick; // variable de listado
    private List<Double> lista2; // lista de los reordenados

    public Lista() {
        listaNums = new ArrayList<>();
        lista2 = new ArrayList<>();
    }

    public List<Double> getListaNums() {
        return listaNums;

    }

    public void generarNúmeros(int largo) {
        lista2.clear();// limpiar lista copiada en caso de existir previamente
        for (int tmp = 0; tmp < largo; tmp++) {
            pick = -300 + (300 + 300) * rand.nextDouble(); // elige número decimal al azar entre -300 y 300
            pick = Math.round(pick * 100.0) / 100.0; // reduce decimales
            listaNums.add(pick);
        }
    }

    public void mostrarLista() {
        for (Double tmp : listaNums) {
            System.out.println(tmp.toString());
        }
    }

    public void reordenarListaSort(int opt) {

        if (opt == 1) {

            lista2.clear();// limpiar lista en caso de ejecutar la funcion 2 veces
            lista2.addAll(listaNums); // copiar lista original
            Collections.sort(lista2); // ordenar lista copiada

        } else if (opt == 2) {
            lista2.clear();// limpiar lista en caso de ejecutar la funcion 2 veces
            lista2.addAll(listaNums); // copiar lista original
            int n = lista2.size();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (lista2.get(j) > lista2.get(j + 1)) {
                        double temp = lista2.get(j);
                        lista2.set(j, lista2.get(j + 1));
                        lista2.set((j + 1), temp);
                    }
                }
            }

        } else if (opt == 3) {
            System.out.println("Parallalel Sort");
            System.out.println("wip");
        } else if (opt == 4) {
            System.out.println("heap sort");
            System.out.println("wip");
        } else if (opt == 5) {

            ///////////////
            System.out.println("quicksort");
            System.out.println("wip");
        } else {
            System.out.println("Elija una opción válida.");
        }

    }

    public void mostrarListaReordenada() {
        if (lista2.size() > 0) {
            try {
                for (Double tmp : lista2) {
                    System.out.println(tmp.toString());
                }
            } catch (Exception e) {
                System.out.println("\nAún no ha reordenado la lista.");
            }
        } else {
            System.out.println("\nAún no ha reordenado la lista.");
        }
    }

    public List<Double> getListaReord() {
        return lista2;

    }

    public int buscarNúmero(Double dbl) {
        try {
            int index = lista2.indexOf(dbl);
            index = index + 1;
            return index;
        } catch (Exception e) {
            return -1;
        }
    }

}
