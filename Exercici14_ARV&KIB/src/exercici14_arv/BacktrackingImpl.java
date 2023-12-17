/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici14_arv;

import java.util.Arrays;

/**
 *
 * @author antoni
 * @author ARV & KIB
 */
public class BacktrackingImpl implements Backtracking {

    private static int maxp;

    /**
     * Algoritmo que devuelve la solución óptima teniendo en cuenta todos los
     * pesos, profits y el peso máximo que se puede alcanzar.
     *
     * @pre array no nulo de pesos, con la misma longitud del array de pesos que
     * de profit. El peso máximo: W tiene que ser mayor a 0.
     * @post array que indica en cada índice si ese peso y ese profit se utiliza
     * o no (con un '0' o con un '1'). Si es nulo el array de pesos devuelve
     * null y si el array de pesos es diferente que el array de profits también
     * devuelve null.
     * @analisi de casos:
     * @base caso: miramos que los arrays sean correctos y de mismo tamaño, sino
     * devolvemos null.
     * @recursivo caso: vamos llamando recursivamente a la función para que vaya
     * recorriendo todas las posibilidades que hay para dar con la solución
     * óptima.
     * @orden de complejidad: O(2^n), donde n es la longitud del array de pesos,
     * ya que cada elemento de puede tomar 2 valores y este algoritmo tiene en
     * cuenta todas las posibles opciones para encontrar la solución óptima.
     * @proof en el mètode com a comentaris (syntactic/semantic checks)
     * @param W peso máximo
     * @param w lista de pesos
     * @param p lista de profit
     * @return array relleno de '0' y/o '1's dependiendo de si se utiliza ese
     * peso con ese profit o no
     */
    @Override
    public int[] knapSack(int W, int[] w, int[] p) {
        // Verificación sintáctica: el nombre de parámetros corresponde a la especificación
        maxp = 0;
        if (w.length == 0 || w.length != p.length) {
            return null;
        }
        // Verificación semántica: el algoritmo es correcto si no hay llamadas recursivas
        int[] t = new int[w.length];
        int[] solucio = new int[w.length];
        Arrays.fill(t, -1);
        // Verificación sintáctica: el subprograma se llama con su forma correcta
        knapSack(W, w, p, t, solucio, 0);
        return solucio;
    }



    /**
     * Backtracking recursivo adaptado para la mochila.
     * @param W peso que no se puede superar
     * @param w array de pesos
     * @param p array de profits
     * @param t array que procesa todos los elementos entre todos
     * @param solucio solución óptima
     * @param k índice de t
     */
    private static void knapSack(int W, int[] w, int[] p, int[] t, int[] solucio, int k) {
        t[k] = -1;
        while (t[k] < 1) {
            t[k]++;
            if ((weight(w, t, k) <= W) && (k == t.length - 1)) {
                if (profit(p, t, k) > maxp) {
                    maxp = profit(p, t, k);
                    System.arraycopy(t, 0, solucio, 0, t.length);
                   // System.out.println(Arrays.toString(t)); Visualisación de la solución
                }
            } else if ((weight(w, t, k) <= W) && (k < t.length - 1)) {
                // Verificación semántica: el tamaño de los parámetros se hace más pequeño: k+1
                knapSack(W, w, p, t, solucio, k + 1);
            }
        }
        t[k] = -1;
    }

    /**
     * Resuelve el problema de la mochila de forma iterativa.
     *
     * @Orden de complejidad idéntico al de la versión recursiva del algoritmo.
     * @param W El peso máximo que la mochila puede soportar.
     * @param w array de pesos de los objetos.
     * @param p array de beneficios de los objetos.
     * @return Un array que representa la solución óptima, donde cada elemento
     * indica cuántas veces se ha incluido el objeto correspondiente.
     * Retorna `null` si los arrays `w` y `p` no tienen la misma longitud
     * o si `w` tiene longitud 0.
     */
    public int[] iterativeKnapSack(int W, int[] w, int[] p) {
        maxp = 0;
        if (w.length == 0 || w.length != p.length) {
            return null;
        }

        int[] t = new int[w.length];
        int[] solucion = new int[w.length];
        Arrays.fill(t, -1);
        return iterativeAux(W, w, p, t, solucion, 0);
    }

    /**
     * Método auxiliar para resolver el problema de la mochila 0/1 de forma iterativa.
     *
     * @param W Peso máximo que la mochila puede soportar.
     * @param w Array de pesos de los objetos.
     * @param p Array de beneficios de los objetos.
     * @param t Array que representa la cantidad de veces que se ha tomado cada objeto.
     * @param solucion Array que contendrá la solución óptima.
     * @param k Índice actual en los arrays `w` y `p`.
     * @return Un array que representa la solución óptima.
     */

    private static int[] iterativeAux(int W, int[] w, int[] p, int[] t, int[] solucion, int k) {
        int weight = 0;
        int profit = 0;

        while (k >= 0) {
            if (t[k] < 1) {
                t[k]++;
                weight += w[k] * t[k];
                profit += p[k] * t[k];

                if (weight <= W && k == w.length - 1) {
                    if (profit > maxp) {
                        maxp = profit;
                        System.arraycopy(t, 0, solucion, 0, t.length);
                        //System.out.println(Arrays.toString(t)); Visualisación de la solución
                    }
                } else if (weight <= W && k < w.length - 1) {
                    k++;
                }
            } else {
                weight -= w[k] * t[k];
                profit -= p[k] * t[k];
                t[k] = -1;
                k--;
            }
        }
        return solucion;
    }


    /**
     * Calcula cada uno de los pesos.
     *
     * @param w array de pesos
     * @param t array que calcula
     * @param k indice de t
     * @return el peso de cada array de elementos
     */
    private static int weight(int[] w, int[] t, int k) {
        int weight = 0;
        for (int i = 0; i <= k; i++) {
            weight += w[i] * t[i];
        }
        return weight;
    }


    /**
     * Calcula cada uno de los profits.
     *
     * @param p array de profits
     * @param t array que calcula
     * @param k índice de t
     * @return el profit de cada array de elementos
     */
    private static int profit(int[] p, int[] t, int k) {
        int profit = 0;
        for (int i = 0; i <= k; i++) {
            profit += p[i] * t[i];
        }
        return profit;
    }

}
