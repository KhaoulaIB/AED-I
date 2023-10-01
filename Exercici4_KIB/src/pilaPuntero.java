import java.util.EmptyStackException;

/**
 * Implementación de una pila basada en punteros en Java.
 *
 * @param <E> El tipo de elementos que se almacenan en la pila.
 * @author Khaoula
 */
public class pilaPuntero<E> implements stack<E> {

    /**
     * Excepción personalizada para indicar que la pila está llena.
     */
    public static class PilaLlena extends Exception {
        public PilaLlena(String input) {
            super(input);
        }
    }

    /**
     * Excepción personalizada para indicar que el tamaño especificado no es válido.
     */
    public static class TamanyInvalid extends Exception {
        public TamanyInvalid(String o) {
            super(o);
        }
    }

    /**
     * Clase que representa un nodo en la pila.
     */
    public class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node top;   // Referencia al último nodo en la pila.
    private int s; // Tamaño máximo de la pila.
    private int punter;

    /**
     * Constructor de la pila.
     *
     * @param size El tamaño máximo de la pila.
     * @throws TamanyInvalid Si el tamaño proporcionado no es válido (menor o igual a 0).
     */
    public pilaPuntero(int size) throws TamanyInvalid {
        if (size <= 0) {
            throw new TamanyInvalid("Tamaño no válido");
        }
        this.s = size;
        punter = -1;
        top = null;
    }

    /**
     * Agrega un elemento en la parte superior de la pila.
     *
     * @param element El elemento a agregar.
     * @throws PilaLlena Si la pila está llena.
     */
    @Override
    public void Push(E element) throws PilaLlena {
        if (esPlena()) {
            throw new PilaLlena("La pila es llena");
        }
        Node aux = new Node(element, top);
        top = aux;
        punter++;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    @Override
    public E Pop() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        E elemento = top.getE();
        top = top.getNext();
        punter--;
        return elemento;
    }

    /**
     * Obtiene el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    public E top() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        return top.getE();
    }

    /**
     * Verifica si la pila está llena.
     *
     * @return `true` si la pila está llena, de lo contrario, `false`.
     */
    @Override
    public boolean esPlena() {
        return punter == s - 1;
    }

    /**
     * Imprime los elementos de la pila por pantalla.
     */
    public void GetPila() {
        Node current = top;
        System.out.print("Pila: ");
        while (current != null) {
            System.out.print(current.getE() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return `true` si la pila está vacía, de lo contrario, `false`.
     */
    @Override
    public boolean esVacia() {
        return punter == -1;
    }
}
