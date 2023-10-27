/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici6_ultimversion;

import java.util.Arrays;

/**
 *
 * @author h
 */
public class BinarySearch {
        /**
     * @author Khaoula
     * Realiza una búsqueda binaria en un arreglo de elementos comparables para encontrar un valor específico.
     *
     * @param <E>   El tipo de elementos en el arreglo, debe implementar la interfaz Comparable.
     * @param a     El arreglo de elementos comparables ordenado en el que se realizará la búsqueda.
     * @param value El valor que se desea encontrar en el arreglo.
     * @return El índice del valor en el arreglo si se encuentra, o -1 si no se encuentra.
     * 
     * Precondition: P
     * []a debe estar ordenada ascendietemente y puede contene elementos repetidos :∀i 0≤i<a.length-1; a[i].compareTo[a+1]<=0
     *  Condition: private static <E extends Comparable<? super E>> int cercaDicotomica (E[] a,  E value) (int k)
     *   Postcondition: Si value existe en a[], k debe ser igual a su indice, en caso ocntrario k debe valer -1.
     * ∀i 0≤i<a.length; (a[i].compareTo(value)==0 Λ i.compareTo(k)==0 )U (a[i].compareTo(value)!=0 Λ k.compareTo(-1)==0)
     */

    public static  <E extends Comparable<E>> int cercaDicotomica (E[] a,  E value) {
        //Verificar que a no tiene ningun elemento nulo
        for (E element:a) {
            if (element == null){
                 return -1;
        }

        }

        if (a.length == 0) {
            // El arreglo está vacío, no tiene sentido buscar en él.
            return -1;
        }
        int i = 0;
        int f = a.length-1;
        while (i<=f){
            int m = (i+f)/2;
            if(a[m].compareTo(value)==0) return m; // Se ha encontrado el valor
            if(a[m].compareTo(value)>0) f = m-1; // El valor está en la mitad inferior del rango.
            else i = m+1; // El valor está en la mitad superior del rango.
        }
        return -1;// El valor no se encuentra en el arreglo
    }





}
