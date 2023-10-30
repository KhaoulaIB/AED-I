import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Una clase que implementa una lista ordenada utilizando cursores en un array.
 * Los elementos se almacenan de manera ordenada y el tamaño de la lista es limitado.
 *
 * @param <E> el tipo de elementos que se almacenan en la lista, deben ser comparables entre sí.
 */
public class LListaCursor<E extends Comparable<E>> implements Lista<E> {
    /**
     * Excepción personalizada para indicar que la lista está completa y no se pueden agregar más elementos.
     */
    public static class ListaCompleta extends Exception {
        public ListaCompleta(String o) {
            super(o);
        }
    }

    private E[] elements;
    private int[] next;
    private int firstCursor; // Puntero al primer elemento
    private int size;
    private int maxSize;

    /**
     * Crea una nueva instancia de la lista ordenada con un tamaño máximo específico.
     *
     * @param maxSize El tamaño máximo de la lista.
     * @throws IllegalArgumentException Si se proporciona un tamaño máximo negativo.
     */
    public LListaCursor(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("Tamaño negativo");
        }
        this.elements = (E[]) new Comparable[maxSize];
        this.next = new int[maxSize];
        this.firstCursor = -1;
        this.size = 0;
        this.maxSize = maxSize;
        Arrays.fill(next, -1);
    }
    /**
     * Agrega un elemento a la lista de manera ordenada.
     *
     * @param element El elemento a agregar a la lista.
     * @throws ListaCompleta Si la lista está completa y no se pueden insertar más elementos.
     * Oden de complejidad 0(n) donde n es el tamaño de elementos (en el peor de los casos).
     * @pre La lista no está completa (tamaño < maxSize) y element es un elemento válido.
     * @post El elemento se agrega a la lista de manera ordenada.
     */
    @Override
    public void add(E element) throws ListaCompleta {
        if (size >= maxSize) {
            throw new ListaCompleta("La lista esta completa. No puedes insertar más elementos!");

        }

        int newIndex = -1;
        int prevIndex = -1;
        int currentIndex = firstCursor;

        // Encuentra la posición adecuada para insertar el nuevo elemento
        while (currentIndex != -1 && elements[currentIndex] != null && element.compareTo(elements[currentIndex]) > 0) {
            prevIndex = currentIndex;
            currentIndex = next[currentIndex];
        }

        // Inserta el nuevo elemento en el array
        newIndex = getAvailableIndex();
        elements[newIndex] = element;

        if (prevIndex == -1) {
            // El nuevo elemento será el primero en la lista
            next[newIndex] = firstCursor;
            firstCursor = newIndex;
        } else {
            // El nuevo elemento estará entre prevIndex y currentIndex
            next[newIndex] = next[prevIndex];
            next[prevIndex] = newIndex;
        }

        size++;
    }
    /**
     * Elimina todos los elementos de la lista y restablece su estado inicial.
     *
     * @pre La lista contiene elementos.
     * @post La lista está vacía y en su estado inicial.
     * Orden de complejidad: este metodo tiene un orden de complejidad O(maxsize) (o O(n)) ya que recorre elementos[] una vez
     * y asigna nul a sus valores.
     */
    @Override
    public void clear() {
        if (elements == null) {
            throw new IllegalStateException("La lista está vacía.");
        }
        for (int i = 0; i < maxSize; i++) {
            elements[i] = null;
            next[i] = -1;
        }
        firstCursor = -1;
        size = 0;
    }
    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     * @pre La lista está inicializada.
     * @post Se devuelve true si la lista está vacía, false en caso contrario.
     * Orden de complejidad es O(1).
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Verifica si la lista contiene un elemento específico.
     *
     * @param element El elemento a buscar en la lista.
     * @return true si la lista contiene el elemento, false en caso contrario.
     * @pre La lista está inicializada.
     * @post Se devuelve true si la lista contiene el elemento, false en caso contrario.
     * Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     * ya que debe recorrer el arreglo en busca del elemento deseado.
     */
    @Override
    public boolean contains(E element) {
        int currentIndex = firstCursor;
        while (currentIndex != -1) {
            if (element.equals(elements[currentIndex])) {
                return true;
            }
            currentIndex = next[currentIndex];
        }
        return false;
    }
    /**
     * Elimina la primera ocurrencia de un elemento específico en la lista.
     *
     * @param element El elemento a eliminar de la lista.
     * @pre La lista está inicializada y contiene al menos un elemento.
     * @post La primera ocurrencia del elemento se elimina de la lista.
     *  Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     *  ya que debe buscar y eliminar la primera ocurrencia del elemento en elementos[].
     */
    @Override
    public void remove(E element) {
        if (isEmpty()) {
            throw new NullPointerException("la lista está vacía");
        }

        int prevIndex = -1;
        int currentIndex = firstCursor;

        while (currentIndex != -1) {
            if (element.equals(elements[currentIndex])) {
                if (prevIndex == -1) {
                    firstCursor = next[currentIndex];
                } else {
                    next[prevIndex] = next[currentIndex];
                }

                elements[currentIndex] = null;
                next[currentIndex] = -1;
                size--;
                return;
            }

            prevIndex = currentIndex;
            currentIndex = next[currentIndex];
        }
    }
    /**
     * Imprime todos los elementos de la lista en orden.
     * @pre La lista debe estar correctamente inicializada.
     * @post Imprime todos los elementos de la lista en orden.
     * No modifica el estado de la lista ni sus elementos.
     * El orden de impresión es el mismo que el orden en que se insertaron los elementos.
     * Si la lista está vacía, no imprime nada.
     * Orden de Complejidad: tiene una complejidad de tiempo de O(n),
     * donde "n" es el número de elementos en la lista, ya que recorre la lista
     * una vez e imprime cada elemento. El tiempo de ejecución es lineal con respecto al número de elementos en la lista.
     */
    @Override
    public void printlist() {
        int currentIndex = firstCursor;
        while (currentIndex != -1) {
            System.out.println(elements[currentIndex]);
            currentIndex = next[currentIndex];
        }

    }
    /**
     * Obtiene el índice disponible en el array de elementos para insertar un nuevo elemento.
     *
     * @return El índice disponible en el array de elementos o -1 si la lista está llena.
     * Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     * ya que debe buscar el primer indice disponible en elementos[].
     * @pre La lista debe estar correctamente inicializada.
     * @post Devuelve el primer índice disponible en el array de elementos (elements).
     * Si la lista está llena y no hay índices disponibles, devuelve -1 para indicar que no hay índices disponibles.
     * No modifica el estado de la lista ni sus elementos.
     */
    private int getAvailableIndex() {
        for (int i = 0; i < maxSize; i++) {
            if (elements[i] == null) {
                return i;
            }
        }
        return -1; // No hay índices disponibles (la lista está llena)
    }
}
