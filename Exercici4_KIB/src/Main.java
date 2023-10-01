import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Queue;



public class Main {


    /*
     * El algoritmo de burbuja mejorada es una variante optimizada
     * del algoritmo de burbuja tradicional. Compara y reordena
     * elementos adyacentes en el array hasta que todos los elementos
     * estén ordenados en orden ascendente.
     */

    /*
     * Ordena un array de elementos utilizando el algoritmo de burbuja y el interfaz Comparable.
     *
     * @param array El array a ordenar.
     * @param <T>   El tipo de elementos en el array que implementa Comparable.
     * @author Khaoula
     */
    public static<T extends java.lang.Comparable<T>>  void burbujaUsandoComparable(T[] array) {
        final int N = array.length;
        T x;
        int i = 0;
        while (i < N - 1) {
            int lj = N;
            for (int j = N - 2; j >= i; j--) {
                if (array[j + 1].compareTo(array[j]) < 0) {
                    x = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = x;
                    lj = j;
                }
            }
            i = lj + 1;
        }
    }


    /**
     * Ordena un array de elementos utilizando el algoritmo de burbuja y un Comparator personalizado.
     *
     * @param array      El array a ordenar.
     * @param comparador El comparador personalizado para comparar los elementos.
     * @param <T>        El tipo de elementos en el array.
     */
    public static <T> void burbujaUsandoComparator (T [] array, Comparator<T> comparador) {
        final int N = array.length;
        T x;
        int i = 0;
        while (i < N - 1) {
            int lj = N;
            for (int j = N - 2; j >= i; j--) {
                if (comparador.compare(array[j + 1],(array[j])) < 0) {
                    x = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = x;
                    lj = j;
                }
            }
            i = lj + 1;
        }
    }




    public static void main(String[] args) throws pilaPuntero.PilaLlena, ColaCursor.ColaPlena {
        String[] elementos = {"d", "g", "a", "a", "r"};
        Double [] numbers = {-0.1, 5.7, 9.6, 9.2, 10.0, 0.0};

        burbujaUsandoComparable(elementos);
        burbujaUsandoComparator(numbers, Comparator.comparingDouble(Double::doubleValue));
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(elementos));


        ColaCursor<String> colacurs = new ColaCursor<>(9);
        colacurs.Push("Never");
        colacurs.Push("gonna");
        colacurs.Push("give");
        colacurs.Push("you");
        colacurs.Push("up");

        colacurs.GetCola();
        System.out.println(colacurs.esPlena());
        System.out.println(colacurs.Pop());
       colacurs.Push("by");



        ColaPuntero<String> colaPuntero = new ColaPuntero<>(9);
        colaPuntero.Push("Ejercicio");
        colaPuntero.Push("de");
        colaPuntero.Push("TAD");
        System.out.println(colaPuntero.top());
        colaPuntero.GetCola();


    }
}




