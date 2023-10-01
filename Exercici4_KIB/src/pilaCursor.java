import java.util.EmptyStackException;
//
/**
 * Implementación de una pila con un cursor en Java.
 *
 * @param <E> El tipo de elementos que se almacenan en la pila.
 */
public class pilaCursor<E> implements stack<E> {

    private final int TAMANY; // Tamaño máximo de la pila.
    private final E[] pila; // Arreglo para almacenar los elementos de la pila.
    private int punter; // Índice que rastrea el último elemento en la pila.

    /**
     * Constructor de la clase.
     *
     * @param Tamany Tamaño máximo de la pila.
     * @throws pilaPuntero.TamanyInvalid Si el tamaño proporcionado es no válido (menor o igual a 0).
     * @author Khoaula
     */
    public pilaCursor(int Tamany) throws pilaPuntero.TamanyInvalid {
        if (Tamany <= 0) {
            throw new pilaPuntero.TamanyInvalid("Tamany no válido");
        }
        this.TAMANY = Tamany;
        pila = (E[]) new Object[TAMANY];
        punter = -1; // Inicialmente, la pila está vacía.
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param x El elemento que se va a agregar.
     * @throws pilaPuntero.PilaLlena Si la pila está llena y no se puede agregar más elementos.
     */
    @Override
    public void Push(E x) throws pilaPuntero.PilaLlena {
        if (punter == TAMANY - 1) {
            throw new pilaPuntero.PilaLlena("La pila está llena");
        }
        pila[++punter] = x; // Incrementa el puntero y agrega el elemento.
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía y no se puede realizar Pop.
     */
    @Override
    public E Pop() {
        if (punter == -1) {
            throw new EmptyStackException();
        }
        return pila[punter--]; // Devuelve el elemento y disminuye el puntero.
    }

    /**
     * Obtiene el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws pilaPuntero.PilaLlena Si la pila está vacía y no se puede obtener el elemento superior.
     */
    @Override
    public E top() throws pilaPuntero.PilaLlena {
        if (punter == -1) {
            throw new pilaPuntero.PilaLlena("La pila está vacía");
        }
        return pila[punter];
    }

    /**
     * Imprime todos los elementos de la pila en orden.
     */
    public void GetPila() {
        for (int i = 0; i <= punter; i++) {
            System.out.println(pila[i]);
        }
    }

    /**
     * Verifica si la pila está llena.
     *
     * @return `true` si la pila está llena, de lo contrario `false`.
     */
    @Override
    public boolean esPlena() {
        return punter == TAMANY - 1;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return `true` si la pila está vacía, de lo contrario `false`.
     */
    @Override
    public boolean esVacia() {
        return punter == -1;
    }
}
