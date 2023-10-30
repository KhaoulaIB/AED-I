/**
 * Una interfaz que define las operaciones básicas de una lista.
 *
 * @param <E> el tipo de elementos que se almacenan en la lista.
 */
public interface Lista<E> {

  /**
   * Agrega un elemento a la lista.
   *
   * @param e el elemento a agregar a la lista.
   * @throws LListaCursor.ListaCompleta Si la lista está llena y no se pueden insertar más elementos.
   */
  public void add(E e) throws LListaCursor.ListaCompleta;

  /**
   * Borra todos los elementos de la lista.
   */
  public void clear();

  /**
   * Verifica si la lista contiene un elemento específico.
   *
   * @param e el elemento a buscar en la lista.
   * @return true si la lista contiene el elemento, false en caso contrario.
   */
  public boolean contains(E e);

  /**
   * Verifica si la lista está vacía.
   *
   * @return true si la lista está vacía, false en caso contrario.
   */
  public boolean isEmpty();

  /**
   * Elimina la primera ocurrencia de un elemento específico en la lista.
   *
   * @param e el elemento a eliminar de la lista.
   */
  public void remove(E e);

  /**
   * Imprime los elementos de la lista en un orden específico.
   */
  public void printlist();
}
