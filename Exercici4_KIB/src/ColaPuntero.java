import java.util.EmptyStackException;

/**
 * Implementación de una cola basada en punteros en Java.
 *
 * @param <E> El tipo de elementos que se almacenan en la cola.
 * @author Khaoula
 */
public class ColaPuntero<E> implements stack<E> {

    private int s;      // Tamaño máximo de la cola.
    private int punter; // Índice que rastrea el último elemento en la cola.

    // Nodos que representan el primero y el último elemento de la cola.
    private Node first;
    private Node top;

    /**
     * Constructor de la cola.
     *
     * @param size El tamaño máximo de la cola.
     * @throws IllegalArgumentException Si el tamaño proporcionado es no válido (menor o igual a 0).
     */
    public ColaPuntero(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Tamaño no válido");
        }
        this.s = size;
        punter = -1;
        first = null;
        top = null;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento El elemento a agregar.
     * @throws pilaPuntero.PilaLlena Si la cola está llena.
     */
    @Override
    public void Push(E elemento) throws pilaPuntero.PilaLlena {
        if (esPlena()) {
            throw new pilaPuntero.PilaLlena("La cola está llena");
        }

        Node tmp = new Node(elemento, null); // Crea un nuevo nodo.

        if (esVacia()) {
            first = tmp; // Si la cola está vacía, el nuevo nodo es el primero.
        } else {
            top.setNext(tmp); // Configura el siguiente nodo del último nodo de la cola.
        }

        top = tmp; // Actualiza la referencia al último nodo (top).
        punter++;
    }

    /**
     * Elimina y devuelve el elemento en el frente de la cola.
     *
     * @return El elemento en el frente de la cola.
     * @throws EmptyStackException Si la cola está vacía.
     */
    @Override
    public E Pop() {
        if (esVacia()) {
            throw new EmptyStackException();
        }

        E elemento = first.getE();
        first = first.getNext();
        punter--;
        return elemento;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return `true` si la cola está vacía, de lo contrario, `false`.
     */
    @Override
    public boolean esVacia() {
        return punter == -1;
    }

    /**
     * Verifica si la cola está llena.
     *
     * @return `true` si la cola está llena, de lo contrario, `false`.
     */
    @Override
    public boolean esPlena() {
        return punter == s - 1;
    }

    /**
     * Devuelve el elemento en el frente de la cola sin eliminarlo.
     *
     * @return El elemento en el frente de la cola.
     * @throws EmptyStackException Si la cola está vacía.
     */
    @Override
    public E top() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        return first.getE();
    }

    /**
     * Imprime los elementos de la cola por pantalla.
     */
    public void GetCola() {
        Node current = first;
        System.out.print("Cola: ");
        while (current != null) {
            System.out.print("\n" + current.getE() + " ");
            current = current.getNext();
        }
    }

    /**
     * Clase que representa un nodo en la cola.
     */
    public class Node {

        E e;          // El elemento almacenado en el nodo.
        Node next;    // El siguiente nodo en la cola.

        /**
         * Constructor de un nodo.
         *
         * @param e     El elemento a almacenar en el nodo.
         * @param next  El siguiente nodo en la cola.
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * Obtiene el elemento almacenado en el nodo.
         *
         * @return El elemento almacenado en el nodo.
         */
        public E getE() {
            return e;
        }

        /**
         * Establece el elemento almacenado en el nodo.
         *
         * @param e El elemento a establecer en el nodo.
         */
        public void setE(E e) {
            this.e = e;
        }

        /**
         * Obtiene el siguiente nodo en la cola.
         *
         * @return El siguiente nodo en la cola.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Establece el siguiente nodo en la cola.
         *
         * @param next El siguiente nodo a establecer.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }


}
