/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internshipchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Abdeel
 */
public class Lista {

    private List<Double> listaNums;         /// numeros random
//    private List<Double> listaNumsOrd; ///numeros ordenados
    Random rand = new Random();
    public double pick; // variable de listado
    public Object[] doubles; // array para ordenar los datos
    private List<Object> lista2; // lista de los reordenados

    public Lista() {
        listaNums = new ArrayList<>();
    }

    public List<Double> getListaNums() {
        return listaNums;

    }

    public void generarNúmeros(int largo) {
        for (int tmp = 0; tmp < largo; tmp++) {
            pick = -300 + (300 + 300) * rand.nextDouble(); // elige número decimal al azar entre -300 y 300
            pick = Math.round(pick * 100.0) / 100.0; //reduce decimales
            listaNums.add(pick);
        }
    }

    public void mostrarLista() {
        for (Double tmp : listaNums) {
            System.out.println(tmp.toString());
        }
    }

    public void reordenarListaSort(int opt) {
        doubles = listaNums.toArray();

        if (opt == 1) {
            Arrays.sort(doubles);
            lista2 = Arrays.asList(doubles);
        } else if (opt == 2) {
            System.out.println("quicksort");
        } else if (opt == 3) {
//            Arrays.parallelSort(doubles);
            lista2 = Arrays.asList(doubles);
        } else if (opt == 4) {
            System.out.println("heap sort");
        } else if (opt == 5) {
            //////////
            
            ///////////////

        } else {
            System.out.println("Elija una opción válida.");
        }

    }

    public void mostrarListaReordenada() {
        try {
            for (Object tmp : lista2) {
                System.out.println(tmp.toString());
            }
        } catch (Exception e) {
            System.out.println("\nAún no ha reordenado la lista.");
        }
    }

    public List<Object> getListaReord() {
        return lista2;

    }

    public Object[] getArray() {
        return doubles;

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
