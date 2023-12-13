
package exercici_13_arv;

/**
 * Interfície base per implementar algorisme d'ordenació basat amb un monticle
 * @author antoni
 */
public interface HeapSort <E extends Comparable<E>> {
    
    /**
     * Donat un conjunt de dades h, l'ordena
     * @param h conjunt de dades que s'ordenarà
     */
    public void heapSort(E[] h);
}
