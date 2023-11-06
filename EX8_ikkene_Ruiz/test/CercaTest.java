import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
 *Clase de preubas (JUnit4) para las distintas funciones de busqueda : lineal y dicotomica en sus dos versiones (iterativa y recursiva).
 * @author KIB
 */
public class CercaTest {


    /**
     * Prueba de búsqueda lineal iterativa en un arreglo de cadenas.
     */
    @Test
    public void LinealSearchI() {
        String[] a = {"somos", "sentimientos", "y", "tenemos", "seres", "humanos"};
        String[] b = {"internal", "pointer", "variable"};
        assertEquals(0, Cerca.LinealSearchIterative(a, "somos"));
        assertEquals(-1, Cerca.LinealSearchIterative(a, "x"));
        assertEquals(2, Cerca.LinealSearchIterative(b, "variable"));
        assertEquals(-1, Cerca.LinealSearchIterative(new String[]{}, "hello"));

    }

    /**
     * Prueba de búsqueda lineal recursiva en un arreglo de números enteros.
     */
    @Test
    public void LinealSearchR() {
        Integer[] numeros = {9, -3, -5, 19, 8, 0, 23, 8};
        assertEquals(5, Cerca.LinealSearchRecursive(numeros, 0, 0, 0));
        assertEquals(-1, Cerca.LinealSearchRecursive(numeros, 2, 0, 0));
        assertEquals(2, Cerca.LinealSearchRecursive(numeros, -5, 0, 0));

    }

    /**
     * Prueba de búsqueda dicotómica iterativa en un arreglo de números decimales.
     */
    @Test
    public void BinarySearchL() {
        Double[] numeros = {9.0, 23.2, 4.5, 0.19, 8.0, 0.0, 2.3, 12.8};
        Arrays.sort(numeros);
        assertEquals(0, Cerca.cercaDicotomicaIterative(numeros, 0.0));
        assertEquals(-1, Cerca.cercaDicotomicaIterative(numeros, 2.20));
        assertEquals(3, Cerca.cercaDicotomicaIterative(numeros, 4.50));
        assertEquals(-1, Cerca.cercaDicotomicaIterative(new Double[]{}, 90.0));
    }

    /**
     * Prueba de búsqueda dicotómica recursiva en un arreglo de cadenas ordenadas.
     */
    @Test
    public void BinarySearchR() {
        String[] elements = {"series", "de", "palabras", "pseudo", "aleatorias", "cache", "libro", "gato", "sol", "arbol", "nevera", "huir", "repetir"};
        Arrays.sort(elements);
        assertEquals(4, Cerca.cercaDicotomicaRecursive(elements, "gato", 0, elements.length - 1, 0));
        assertEquals(-1, Cerca.cercaDicotomicaRecursive(elements, "ella", 0, elements.length - 1, 0));
        assertEquals(12, Cerca.cercaDicotomicaRecursive(elements, "sol", 0, elements.length - 1, 0));
        assertEquals(9, Cerca.cercaDicotomicaRecursive(elements, "pseudo", 0, elements.length - 1, 0));

    }

    /**
     * Prueba de búsqueda en un arreglo grande (de 10^6 elementos) y diversos métodos de búsqueda.
     */
    @Test
    public void GenerElements() {
    //no se llama al metodo de búsqueda lineal recursiva porque el conjunto de elementos es demasiado grande y genera un desbordamiento de la pila de recursividad (stackoverflowError)
        Integer[] array = new Integer[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int n = array.length - 1;
        int[] Buscados = {0, 100000};

        for (int i =0; i<2; i++){
            System.out.println("\nBusqueda del valor " + Buscados[i]);
            assertEquals(Buscados[i], Cerca.LinealSearchIterative(array, Buscados[i]));
            assertEquals(Buscados[i], Cerca.cercaDicotomicaIterative(array, Buscados[i]));
            assertEquals(Buscados[i], Cerca.cercaDicotomicaRecursive(array, Buscados[i], 0, n, 0));

        }

        System.out.println("\nBusqueda del valor 10^7");
        System.out.println("\nlineal iterativa");
        assertEquals(-1, Cerca.LinealSearchIterative(array, n + 2));
        System.out.println("\nbinary iterative");
        assertEquals(-1, Cerca.cercaDicotomicaIterative(array, n + 2));
        System.out.println("\nbinary recursive");
        assertEquals(-1, Cerca.cercaDicotomicaRecursive(array, n + 2, 0, n, 0));

    }

    /**
     * Prueba de búsqueda en un conjunto de 10 elementos y comparación de métodos.
     */
    @Test
    public void Conjunt10() {
        String arr[] = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = String.valueOf(i);

        }

        int [] Buscados = {3,5,7};

        for (int i =0; i<3;i++){
            System.out.println("\n---Busqueda del elemento " +Buscados[i] + " con los distintos metodos---");
            System.out.println("\nLineal iterativa");
            assertEquals(Buscados[i], Cerca.LinealSearchIterative(arr, String.valueOf(Buscados[i])));
            System.out.println("\nLineal recursiva");
            assertEquals(Buscados[i], Cerca.LinealSearchRecursive(arr, String.valueOf(Buscados[i]), 0, 0));
            System.out.println("\nDicotomica iterativa");
            assertEquals(Buscados[i], Cerca.cercaDicotomicaIterative(arr, String.valueOf(Buscados[i])));
            System.out.println("\nDicotomica recursiva");
            assertEquals(Buscados[i], Cerca.cercaDicotomicaRecursive(arr, String.valueOf(Buscados[i]), 0, 9, 0));

        }


        /*Por lo tanto si el conjunto de elementos es pequeño y los elementos estan ordenados la cerca dicotomica es más eficiente ya que su tiempo de ejeución es log(n) que es menor
        que el tiempo de ejecución de una busqueda lineal.
        */

    }


}