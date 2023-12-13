/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici_13_arv;

/**
 *
 * @author antoni
 * @author ARV & KIB
 */
public class HeapSortImpl<E extends Comparable<E>> implements HeapSort<E> {



    /**
     * Este algoritmo ordena un array usando un montículo.
     *
     * @Orden de complejidad (CPU): O(n*log n), viene dado por la extracción de
     * los elementos del montículo, que es un for, de complejidad O(n) y dentro
     * de ese for hay una llamada (heapify), que es logarítmica ya que es la
     * altura del árbol de n elementos.
     * @Orden de complejidad (memoria): O(1), no requiere de memoria adicional
     * aparte del array que se utiliza.
     * @Optimizar uso de memoria: No se puede optimizar más el uso de memoria
     * porque ya es lo más eficiente posible en cuanto a uso de memoria.
     *
     * @param h array a procesar
     */
    @Override
    public void heapSort(E[] h) {
        int n = h.length;
        // Construir el montículo inicial
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapmoves(i,n,h);
        }
        // Extrae elementos del montículo uno por uno en orden ascendente
        for (int i = n - 1; i >= 0; i--) {
            E e = h[0];
            h[0] = h[i];
            h[i] = e;
            // Llama al método heapmoves() en el montículo reducido
            heapmoves( 0,i,h);
        }
    }



    /**
     * Ordena los nodos utilizando las reglas del montículo.
     *
     * @param i nodo a tratar
     * @param heapSize tamaño del montículo
     */
    private void heapmoves(int i, int heapSize, E[] h) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heapSize && h[left].compareTo(h[largest]) > 0) {
            largest = left;
        }
        if (right < heapSize && h[right].compareTo(h[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            E e = h[i];
            h[i] = h[largest];
            h[largest] = e;
            heapmoves(largest, heapSize,h);
        }
    }
}
