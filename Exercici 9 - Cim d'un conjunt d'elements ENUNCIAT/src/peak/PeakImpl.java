package peak;

import java.awt.Point;

/**
 *
 * @author antoni
 * @authhor KIB & ARV
 */
public class PeakImpl implements Peak {


    /**  Los elementos de a estan ordenados de forma creciente hasta el indice de la cima (id) y luego se decrecen.
        No hay elementos repetidos.Y existe una unica cima en el arreglo a.
     *@pre ∀i 1<=i<=id     a[i]>(a[i-1])> Λ ∀i id<i<a.length a[i]<0 Λ id>0 Λ id<a.length-1.
     *
     *@post 0<id<a.length-1  Λ a[id]=cima --> Λ 0<i<a.length if (i!=id) a[id]>a[i] el indice de la cima no esta en los extremos y ademas es diferente de -1.
     * Busca y devuelve un punto que representa la cima en un arreglo de enteros.
     *
     * @param a Un arreglo de enteros en el que se buscará la cima.
     * @return Un objeto Point que contiene la coordenada (x, y) de la cima, donde 'x' es el valor de la cima y 'y' es su índice en el arreglo.
     *         Si no se encuentra una cima, se devuelve null.
     *Orden de complejidad: log2(n) donde n = a.length ya que el while se reduce por cociente.
     **/
    @Override
    public Point peak (int[] a)  {
        //como que la cima no esta en los extremos no estara incluido en el rango de busqueda
        int left = 1;
        int right = a.length - 1;
        while (left <= right) {
            int medio = (left + right) / 2;
            if (a[medio] > a[medio - 1] && a[medio] > a[medio + 1]) {
                return new Point(a[medio], medio);
            } else if (a[medio] > a[medio - 1]) { // el cim esta en la parte izquierda
                left = medio+1;
            } else {
                right = medio-1;// el cim esta en la parte derecha
            }

        }
        return null;


    }
}

