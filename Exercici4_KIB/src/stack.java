/**
 * Interfaz que define métodos para una estructura de datos tipo pila (stack) genérica.
 *
 * @param <E> El tipo de elementos que se almacenan en la pila.
 * @author Khaoula
 */
public interface stack<E> {

    /**
     * Agrega un elemento en la parte superior de la pila.
     *
     * @param elemento El elemento a agregar.
     * @throws pilaPuntero.PilaLlena Si la pila está llena (en el caso de la implementación de pilaPuntero).
     * @throws ColaCursor.ColaPlena Si la cola está llena (en el caso de la implementación de ColaCursor).
     */
    public void Push(E elemento) throws pilaPuntero.PilaLlena, ColaCursor.ColaPlena;

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento en la parte superior de la pila.
     */
    public E Pop();

    /**
     * Verifica si la pila está vacía.
     *
     * @return `true` si la pila está vacía, de lo contrario, `false`.
     */
    public boolean esVacia();

    /**
     * Verifica si la pila está llena.
     *
     * @return `true` si la pila está llena, de lo contrario, `false`.
     */
    public boolean esPlena();

    /**
     * Obtiene el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws pilaPuntero.PilaLlena Si la pila está llena (en el caso de la implementación de pilaPuntero).
     */
    public E top() throws pilaPuntero.PilaLlena;
}
