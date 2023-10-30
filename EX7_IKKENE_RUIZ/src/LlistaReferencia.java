/**
 * Una clase que implementa una lista doblemente enlazada ordenada de elementos comparables.
 * Los elementos se organizan de menor a mayor.
 *
 * @param <E> el tipo de elementos que se almacenan en la lista, deben ser comparables entre sí.
 */
public class LlistaReferencia<E extends Comparable<E>> implements Lista<E> {


    private class Node {
        E data;
        Node anterior;
        Node siguiente;

        public Node(E data) {
            this.data = data;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;


    /**
     * Crea una nueva instancia de la lista doblemente enlazada ordenada.
     */
    public LlistaReferencia() {
        head = null;
        tail = null;
    }


    /**
     * Agrega un elemento a la lista de manera ordenada.
     *
     * @param e el elemento a agregar a la lista
     * @precondicion: El elemento e no debe ser nulo
     * @postcondicion: El elemento e se inserto correctamente en caso y se verifica que todos los nodos estan ordenados de forma creciente.
     * Si la lista estaba vacía, head y tail apuntan al nuevo nodo e.
     * Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     * donde "n" es el número de elementos en la lista, ya que en el peor caso, debe buscar
     * la posición correcta para insertar el nuevo elemento a lo largo de la lista.
     */
    @Override
    public void add(E e) {
        Node newNode = new Node(e);

        if (head == null) {
            // La lista está vacía
            head = newNode;
            tail = newNode;
        } else {
            Node current = head;
            Node prev = null;

            // Encuentra la ubicación para insertar el nuevo elemento de manera ordenada
            while (current != null && e.compareTo(current.data) > 0) {
                prev = current;
                current = current.siguiente;
            }

            if (prev == null) {
                // Insertar al principio
                newNode.siguiente = head;
                head.anterior = newNode;
                head = newNode;
            } else if (current == null) {
                // Insertar al final
                newNode.anterior = tail;
                tail.siguiente = newNode;
                tail = newNode;
            } else {
                // Insertar en el medio
                prev.siguiente = newNode;
                newNode.anterior = prev;
                newNode.siguiente = current;
                current.anterior = newNode;
            }
        }
        size++;
    }

    /**
     * Imprime los elementos de la lista en orden.
     * @pre La lista debe estar correctamente inicializada.
     * @post Se imprimen en consola todos los elementos de la lista en orden.
     * No modifica el estado de la lista ni de sus elementos.
     * El orden de impresión es de menor a mayor, reflejando el orden de los elementos en la lista.
     * Si la lista está vacía, no imprime nada.
     * Orden de Complejidad: Este método tiene una complejidad de tiempo de O(n),
     * donde "n" es el número de elementos en la lista, ya que recorre la lista
     * una vez e imprime cada elemento. El tiempo de ejecución es lineal con respecto al número de elementos en la lista.
     */

    public void printlist() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.siguiente;
        }
        System.out.println();
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     * @pre La lista debe estar correctamente inicializada.
     * @post Devuelve true si la lista está vacía, es decir, si su tamaño es igual a 0, false en caso contrario.
     * No modifica el estado de la lista.
     * Orden de Complejidad: Este método tiene una complejidad de tiempo constante O(1)
     * ya que simplemente verifica si el tamaño de la lista es igual a cero.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Borra todos los elementos de la lista.
     *@pre La lista debe estar correctamente inicializada.
     * @post borra todos los elementos de la lista.
     * Orden de Complejidad: Este método tiene una complejidad de tiempo constante O(1)
     * ya que simplemente asigna el valor nulo a las variables head y tail.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }


    /**
     * Verifica si la lista contiene un elemento específico.
     *
     * @param element el elemento a buscar en la lista
     * @return true si la lista contiene el elemento, false en caso contrario.
     * @pre La lista debe estar correctamente inicializada.
     * @post devuelve true si element existe en la lista, false ne caso contrario.No modifica nada.
     * Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     * ya que debe recorrer la lista en busca del elemento deseado.
     */
    @Override
    public boolean contains(E element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.siguiente;
        }
        return false;
    }


    /**
     * Elimina la primera ocurrencia de un elemento específico en la lista.
     *
     * @param element el elemento a eliminar de la lista.
     * @pre La lista debe estar correctamente inicializada.
     * @post Se elimina la 1a occurrencia de 'element' en la lista, si existe.Se reorganiza la lista para mantener el orden ascendiente
     * de sus elementos
     * Orden de Complejidad: En el peor caso, este método tiene una complejidad de tiempo de O(n),
     * ya que debe buscar y eliminar la primera ocurrencia del elemento en la lista.
     */
    @Override
    public void remove(E element) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                if (current.anterior == null && current.siguiente == null) {
                    // El nodo es el único en la lista
                    head = null;
                    tail = null;
                } else if (current.anterior == null) {
                    // El nodo es el primero en la lista
                    head = current.siguiente;
                    head.anterior = null;
                } else if (current.siguiente == null) {
                    // El nodo es el último en la lista
                    tail = current.anterior;
                    tail.siguiente = null;
                } else {
                    // El nodo está en medio de la lista
                    current.anterior.siguiente = current.siguiente;
                    current.siguiente.anterior = current.anterior;
                }
                return; // Elemento encontrado y eliminado
            }
            current = current.siguiente;
        }
        System.out.println("El elemento " + element + " no existe en la lista.");
    }

}
