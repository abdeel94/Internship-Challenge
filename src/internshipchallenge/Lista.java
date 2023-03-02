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
 *         //02-03-23
 */
public class Lista {

    Random rand = new Random();
    public double pick; // variable de listado
    private List<Double> listaNums = new ArrayList<>(); // numeros random
    private List<Double> lista2 = new ArrayList<>(); // lista de los reordenados

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

        lista2.clear();// limpiar lista en caso de ejecutar la funcion 2 veces
        lista2.addAll(listaNums); // copiar lista original

        if (opt == 1) { // collection sort
            long start = System.currentTimeMillis();
            Collections.sort(lista2); // ordenar lista copiada
            long end = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (end - start) + " ms.");

        } else if (opt == 2) { // bubble sort
            long start = System.currentTimeMillis();
            bubbleSort(lista2);
            long end = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (end - start) + " ms.");

        } else if (opt == 3) { //heap sort

            long start = System.currentTimeMillis();
            heapSort(lista2);
            long end = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (end - start) + " ms.");

        } else if (opt == 4) { // quick sort

            long start = System.currentTimeMillis();
            quickSort(lista2, 0, lista2.size() - 1);
            long end = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución: " + (end - start) + " ms.");

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

    private void bubbleSort(List<Double> list){
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set((j + 1), temp);
                }
            }
        }

    }

    private void quickSort(List<Double> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            double pivotValue = list.get(pivot);
            while (left <= right) {
                while (left <= to && pivotValue >= list.get(left)) {
                    left++;
                }
                while (right > from && pivotValue < list.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            quickSort(list, from, right - 1); 
            quickSort(list, right + 1, to);  
        }
    }

    private void heapSort(List<Double> list)
    {
        int n = list.size();
  
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);
  

        for (int i = n - 1; i >= 0; i--) {

            double temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i,temp);
  

            heapify(list, i, 0);
        }
    }
  

    private void heapify(List<Double> list, int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2;
  
 
        if (l < n && list.get(l) > list.get(largest))
            largest = l;
  
  
        if (r < n && list.get(r) > list.get(largest))
            largest = r;
  
  
        if (largest != i) {
            double swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);
  
            heapify(list, n, largest);
        }
    }
}
