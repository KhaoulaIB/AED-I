
/**
 * La clase Cerca proporciona métodos para realizar búsquedas en arreglos de elementos comparables.
 * Contiene métodos para la búsqueda lineal iterativa, búsqueda lineal recursiva y búsqueda dicotómica iterativa y recursiva.
 * Los métodos de búsqueda devuelven el índice del valor buscado si se encuentra en el arreglo o -1 si no se encuentra.
 * Además, los métodos registran la cantidad de elementos consultados durante la búsqueda.
 * @author KIB
 */

public class Cerca {


    /**
     * Realiza una búsqueda lineal iterativa en un arreglo de elementos comparables para encontrar un valor específico.
     *
     * @param <E>   El tipo de elementos en el arreglo, debe implementar la interfaz Comparable.
     * @param a     El arreglo de elementos comparables en el que se realizará la búsqueda.
     * @param value El valor que se desea encontrar en el arreglo.
     * @return El índice del valor en el arreglo si se encuentra, o -1 si no se encuentra.
     * Orden de complejidad: O(n) en el peor de los casos debera procesar todos los elementos (n).
     */
    public static <E extends Comparable<E>> int LinealSearchIterative(E[] a, E value) {
        //Verificar que a no tiene ningun elemento nulo
        for (E element : a) {
            if (element == null) {
                return -1;
            }

        }

        int contador = 0;
        if (a.length == 0) {
            // El arreglo está vacío, no tiene sentido buscar en él.
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            contador++;
            if (a[i].compareTo(value) == 0) {
                System.out.println("Se cosultaron " + contador + " elementos para econtrar el elemento : " + value);

                return i;
            }
        }

        System.out.println("Se consultaron " + contador + " elementos.");
        return -1;
    }

    /**
     * Realiza una búsqueda lineal recursiva en un arreglo de elementos comparables para encontrar un valor específico.
     *
     * @param <E>   El tipo de elementos en el arreglo, debe implementar la interfaz Comparable.
     * @param a     El arreglo de elementos comparables en el que se realizará la búsqueda.
     * @param value El valor que se desea encontrar en el arreglo.
     * @param index El índice actual en el arreglo.
     * @param times El número de elementos consultados hasta el momento.
     * @return El índice del valor en el arreglo si se encuentra, o -1 si no se encuentra.
     * Orden de complejidad: O(n)
     */
    public static <E extends Comparable<E>> int LinealSearchRecursive(E[] a, E value, int index, int times) {
        times++;
        if (index == a.length) {
            // hemos llegado al final sin encontrar el elemento.
            System.out.println("Se consultaron " + times + " elementos.");
            return -1;
        } else if (a[index].compareTo(value) == 0) {
            System.out.println("Se consultaron " + times + " elementos para encontrar el elemento: " + value);
            return index;
        } else {
            return LinealSearchRecursive(a, value, index + 1, times );
        }
    }


    /**
     * Realiza una búsqueda dicotómica recursiva en un arreglo de elementos comparables para encontrar un valor específico.
     *
     * @param <E>     El tipo de elementos en el arreglo, debe implementar la interfaz Comparable.
     * @param a       El arreglo de elementos comparables en el que se realizará la búsqueda.
     * @param value   El valor que se desea encontrar en el arreglo.
     * @param limitI  El límite inferior del rango de búsqueda.
     * @param limitS  El límite superior del rango de búsqueda.
     * @param times   El número de elementos consultados hasta el momento.
     * @return El índice del valor en el arreglo si se encuentra, o -1 si no se encuentra.
     * Orden de complejidad :log(n)
     */
    public static <E extends Comparable<E>> int cercaDicotomicaRecursive(E[] a, E value, int limitI, int limitS, int times) {
        for (E element : a) {
            if (element == null) {
                return -1;
            }

        }

        if (a.length == 0 || limitI > limitS) {
            // El arreglo está vacío o hemos llegado al final del rango sin encontrar el elemento.
            System.out.println("Se consultaron " + times + " elementos.");
            return -1;
        }


        int m = (limitI + limitS) / 2;
        times++;
        if (a[m].compareTo(value) == 0) {
            System.out.println("Se cosultaron " + times + " elementos para econtrar el elemento : " + value);

            return m;
        } else if (a[m].compareTo(value) < 0) {
            return cercaDicotomicaRecursive(a, value, m + 1, limitS, times);
        } else {
            return cercaDicotomicaRecursive(a, value, limitI, m - 1, times);
        }


    }


    /**
     * Realiza una búsqueda dicotómica iterativa en un arreglo de elementos comparables para encontrar un valor específico.
     *
     * @param <E>   El tipo de elementos en el arreglo, debe implementar la interfaz Comparable.
     * @param a     El arreglo de elementos comparables en el que se realizará la búsqueda.
     * @param value El valor que se desea encontrar en el arreglo.
     * @return El índice del valor en el arreglo si se encuentra, o -1 si no se encuentra.
     * Orden de complejidad: log(n)
     */

    public static <E extends Comparable<E>> int cercaDicotomicaIterative(E[] a, E value) {
        //Verificar que a no tiene ningun elemento nulo
        for (E element : a) {
            if (element == null) {
                return -1;
            }

        }

        if (a.length == 0) {
            // El arreglo está vacío, no tiene sentido buscar en él.
            return -1;
        }
        int times = 0;
        int i = 0;
        int f = a.length - 1;
        while (i <= f) {
            times++;
            int m = (i + f) / 2;
            if (a[m].compareTo(value) == 0) {
                System.out.println("Se cosultaron " + times + " elementos para econtrar el elemento : " + value);

                return m; // Se ha encontrado el valor
            }
            if (a[m].compareTo(value) > 0) f = m - 1; // El valor está en la mitad inferior del rango.
            else i = m + 1; // El valor está en la mitad superior del rango.
        }
        System.out.println("Se cosultaron " + times + " elementos.");
        return -1;// El valor no se encuentra en el arreglo

    }



}
