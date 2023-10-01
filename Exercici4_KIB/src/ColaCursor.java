import java.util.EmptyStackException;

/**
 * Implementación de una cola basada en punteros en Java.
 *
 * @param <E> El tipo de elementos que se almacenan en la cola.
 */
public class ColaCursor<E> implements stack<E> {

    /**
     * Excepción personalizada para indicar que la cola está llena.
     */
    public static class ColaPlena extends Exception {
        public ColaPlena(String input) {
            super(input);
        }
    }

    private final int TAMANY; // Tamaño máximo de la cola.
    private final E[] cua;   // Arreglo que almacena los elementos de la cola.
    private int punter;      // Índice que rastrea el último elemento en la cola.

    /**
     * Constructor de la cola.
     *
     * @param tamany El tamaño máximo de la cola.
     * @throws IllegalArgumentException Si el tamaño proporcionado no es válido (menor o igual a 0).
     */
    public ColaCursor(int tamany) {
        if (tamany <= 0) {
            throw new IllegalArgumentException("Tamaño no válido");
        }
        this.TAMANY = tamany;
        cua = (E[]) new Object[TAMANY];
        punter = -1;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param elemento El elemento a agregar.
     * @throws ColaPlena Si la cola está llena.
     */
    @Override
    public void Push(E elemento) throws ColaPlena {
        if (esPlena()) {
            throw new ColaPlena("La cola está llena");
        }
        cua[++punter] = elemento;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la cola.
     *
     * @return El elemento en la parte superior de la cola.
     * @throws EmptyStackException Si la cola está vacía.
     */
    @Override
    public E Pop() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        E tmp = cua[0];
        ShiftToLeft();
        return tmp;
    }

    /**
     * Mueve todos los elementos de la cola un lugar hacia la izquierda.
     * Esto se utiliza después de Pop para mantener la cola ordenada.
     */
    public void ShiftToLeft() {
        for (int i = 0; i < punter; i++) {
            cua[i] = cua[i + 1];
        }
        cua[punter] = null; // Limpia el último elemento
        punter--;
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
        return punter == TAMANY - 1;
    }

    /**
     * Obtiene el elemento en la parte superior de la cola sin eliminarlo.
     *
     * @return El elemento en la parte superior de la cola.
     */
    @Override
    public E top() {
        if (esVacia()) {
            throw new EmptyStackException();
        }
        return cua[0];
    }

    /**
     * Imprime los elementos de la cola por pantalla.
     */
    public void GetCola() {
        for (int i = 0; i <= punter; i++) {
            System.out.println(cua[i]);
        }
    }
}
