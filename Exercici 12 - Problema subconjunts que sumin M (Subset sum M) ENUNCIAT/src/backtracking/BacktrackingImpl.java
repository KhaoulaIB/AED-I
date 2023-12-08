/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Classe implementació Backtracking
 *
 * @author antoni- KIB & ARV
 */
public class BacktrackingImpl implements Backtracking {

    /**
     * Soluciona el problea de los subconjuntos que suman M.
     * @Orden de complejidad O(2^n).
     * @param a conjunt númeric. Tots els elements a són >=0
     * @param M Resultat suma dels subconjunts. M>=0
     * @return
     */
    @Override
    public ArrayList<ArrayList<Integer>> sumM(int[] a, int M) {
        if (a.length==0){
            return new ArrayList<ArrayList<Integer>>();
        }
        int[] t = new int[a.length];

        int rmd = 0;
        for (int j : a) {
            rmd += j;
        }
        ArrayList<ArrayList<Integer>> solucio = new ArrayList<>();
        return suM3(a,t,0,M,0,rmd,solucio);
    }


    /**
     * @Especificacio
     * El algoritmo se basa en la tecnica del backtracking para encontrar todos los
     * posibles subconjuntos cuya suma es igual a M.
     * @pre Los elementos del conjunto a deben ser mayores estrictamente que cero. M debe ser >=0.
     * @post solucio debe contener todos los posibles conjuntos formados a partir de los elementos del conjunto a que
     * suman M.
     * @Analisis de casos
     *Case base: if (sum == M) or else if (sum + rmd == M) son los cases validos que indican que hemos
     * llegado a una solución optima y esta se añade al arraylist solucio.
     * case recursvio: se llama a la funcion misma otra vez si (sum < M) && (sum + rmd > M), es decir que
     * la suma actual es menor que el numero M y la sum+rmd <M ya que solo en este caso se puede ir buscando
     * nuevas combinaciones a probar para encontrar los seguientes que sumanrán a M.
     *
     * @Proof
     * @Syntactic_check:
     *  Las llamadas a los subprogramas "suM3" y "esMatrizSimetricaAux" se realizan correctamente
     * con los tipos de parámetros adecuados (int []a, int [] t, int k, int M, int sum, int rmd, ArrayList<ArrayList<Integer>> solucio).
     *  @Semantic_check:
     *  @Precondition && @Correctness_without_recursion::
     *  - Se cubren todos los estados especificados en @pre.
     *   - Los casos base se maneja correctamente, asegurando el algoritmo cubra la condición en la que se ha encontrado una solución valida al problema y
     *      la añade al conjunto de soluciones (solucio).
     *
     *  @Parameter_values_for_recursive_calls:
     *     - Las llamadas recursivas se realizan con valores ajustados (k+1) para avanzar al seguiente nivel del arbol binario de soluciones
     *       que estamos creando internamente.
     *
     * @Orden_de_complejidad:
     * Como que el algoritmo explora todas las posibles combinaciones de subconjuntos del conjunto
     * a[], tomando decisiones binarias para incluir o no cada elemento, el orden de complejidad es
     *  O(2^n), donde la base 2 refleja las dos opciones disponibles para cada elemento (ser incluido o no), y
     * n es el número de elementos en el conjunto a.
     * Comparando con el orden de complejidad de un arbol binario O(log2n), el algoritmo suM3 es menos eficiente y tiene
     * un crecimiento exponencial bastante rapido, ya que explora todas las posibles combinaciones para encontrar el conjunto valido de soluciones.
     *
     * @param a conjunto númerico. Todos los elements a son >=0
     * @param t array "binaria" que representa los elemento incluidos (1) o no(0) en la solucion del conjunto a
     * @param k nivel del arbol binario que se construye por el algoritmo
     * @param M el numero que deben sumar los subconjunots de a
     * @param sum   la suma de los elementos incluidos
     * @param rmd   la suma total de los elementos de a - sum
     * @param solucio   ArrayList<ArrayList<Integer>> para guardar todas las posibles soluciones
     * @return  esolucio con las solucions del problema
     */

        private static ArrayList<ArrayList<Integer>> suM3(int []a, int [] t, int k, int M, int sum, int rmd, ArrayList<ArrayList<Integer>> solucio ){
            t[k]=-1;
            rmd-=a[k];
            while (t[k]<1) {
                t[k]++;
                sum += a[k] * t[k];
                if (sum == M) {
                    complete(t, k + 1, 0);
                    solucio.add(addToArray(a, t));

                } else if (sum + rmd == M) {
                    complete(t, k + 1, 1);
                    solucio.add(addToArray(a, t));
                } else if ((sum < M) && (sum + rmd > M)) {
                    suM3(a, t, k + 1, M,sum,rmd,solucio);
                }
                sum += a[k] * t[k];
            }
            rmd-=a[k];
            t[k]=-1;
            return solucio;
        }



    /**
     * Completa el array 't' desde la posición 'start' con el valor especificado.
     *
     * @param t     Array binario que se completa.
     * @param start Posición desde la cual se inicia la completación.
     * @param value Valor con el cual se completa el array ('0' o '1').
     */
    private static void complete(int[] t, int start, int value) {
        for (int i = start; i < t.length; i++) {
            t[i] = value;
        }
    }

    /**
     * Crea y devuelve un ArrayList de enteros con los elementos del array 'a' que están marcados como '1' en el array 't'.
     *
     * @param a Array de enteros original.
     * @param t Array binario que indica la inclusión (1) o exclusión (0) de elementos.
     * @return ArrayList que contiene los elementos marcados como '1' en 't'.
     */
    private static ArrayList<Integer> addToArray(int[] a, int[] t) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (t[i] == 1) {
                tmp.add(a[i]);
            }
        }
        return tmp;
    }



}
