/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.Stack;

/**
 * Implementación de la clase HanoiImpl que implementa la interfaz Hanoi.
 * Se proporcionan métodos recursivos e iterativos para realizar los movimientos de los discos entre las pilas.
 *
 * @author antoni-KIB &ARV
 */
public class HanoiImpl<E extends Comparable<E>> implements Hanoi<E> {

    /**
     * @param h Número de discos.
     * @param a Pila de origen.
     * @param b Pila auxiliar.
     * @param c Pila de destino.
     *          Orden de complejidad: O(2^h) siendo h el numero de discos del problema
     * @Specifiation Resuelve el problema de las Torres de Hanoi de forma recursiva.
     * @pre las torres de hanoi deben ser on orden creciente en la pila a mienstras que las pilas
     * b y c deben estar vacías. y el numero de torres(a.size()) debe ser mayor o igual que 1
     * @post despues de aplicar el algoritmo la pila c debe ser igual a la pila a en el estado de inicio
     * y la pila auxiliar b debe estar vacía.
     * @Case_analysis && Composition:
     * Caso base (h == 1):
     * Si el número de discos (h) es igual a 1, mueva el disco superior directamente desde la pila de origen (a)
     * a la pila de destino (c).
     * Imprime el estado de las tres pilas usando la función printPiles.
     * <p>
     * Caso recursivo (h > 1):
     * Si número de discos es mayor que 1, el problema se divide en subproblemas:
     * Mueva de forma recursiva los discos h-1 superiores de la pila de origen (a) a la pila
     * auxiliar (b), utilizando la pila de destino (c) como área de retención temporal.
     * Mueva el disco más grande de la pila de origen (a) a la pila de destino (c).
     * Imprime el estado de las tres pilas.
     * Mueva recursivamente los discos h-1 desde la pila auxiliar (b) a la pila objetivo (c), utilizando
     * la pila fuente (a) como área de retención temporal.
     * @Proof
     * @Syntactic check:
     * Los subprogramas "recursiuHanoi"se llaman correctamente con el tipo de parametro adecuado (int h,Stack<E>a,Stack<E>b,Stack<E>b).
     * @Semantic check:
     * Precondition :
     * Todos los estados especificados en @pre están cubiertos. El caso base (h == 1) se maneja explícitamente, asegurando
     * que el algoritmo cubra la condición en la que solo hay un disco para mover.
     * <p>
     * Corrección del algoritmo sin recursividad:
     * Para el caso base (h == 1), el algoritmo mueve correctamente el disco de la pila de origen a la pila de destino e imprime las pilas.
     * <p>
     * Valores de parámetros para llamadas recursivas:
     * Las llamadas recursivas se realizan con valores ajustados (h-1) para la altura de la torre, asegurando
     * que las llamadas recursivas muevan una torre más pequeña.
     * El orden de los parámetros (a, b, c) se ajusta en las llamadas recursivas, indicando el movimiento adecuado
     * de los discos entre las pilas de origen, auxiliar y de destino.
     * La poscondición se cumple para cada llamada recursiva, ya que los movimientos del disco y el estado de las pilas se manejan correctamente.
     */
    @Override
    public void recursiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {
        if (h == 1) {
            moveDisk(a, c);
            printPiles(a, b, c);

        } else {
            recursiuHanoi(h - 1, a, c, b);
            moveDisk(a, c);
            printPiles(a, b, c);
            recursiuHanoi(h - 1, b, a, c);

        }

        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     * Mueve un disco de una pila a otra.
     *
     * @param source Pila de origen.
     * @param target Pila de destino.
     */

    private void moveDisk(Stack<E> source, Stack<E> target) {
        target.push(source.pop());
    }


    /**
     * Resuelve el problema de las Torres de Hanoi de forma iterativa.
     *
     * @param h Número de discos.
     * @param a Pila de origen.
     * @param b Pila auxiliar.
     * @param c Pila de destino.
     * @Orden de complejidad: O(n) siendo n el numero de movimientos a realizar (2^numerdeDiscos - 1)
     */
    @Override
    public void iteratiuHanoi(int h, Stack<E> a, Stack<E> b, Stack<E> c) {

            // Calcula el número total de movimientos necesarios
            int totalMoves = (int) Math.pow(2, h) - 1;

            // Itera sobre cada movimiento
            for (int move = 1; move <= totalMoves; move++) {
                System.out.println("Move " + move + ":");
                printPiles(a, b, c);

                // Decide la acción a realizar en función del movimiento actual
                if (move % 3 == 1) {
                    // Movimiento cuando el residuo es 1
                    if (!a.isEmpty() && (c.isEmpty() || a.peek().compareTo(c.peek()) < 0)) {
                        moveDisk(a, c);
                        System.out.println("Move disk from a to c");
                    } else {
                        moveDisk(c, a);
                        System.out.println("Move disk from c to a");
                    }
                } else if (move % 3 == 2) {
                    // Movimiento cuando el residuo es 2
                    if (!a.isEmpty() && (b.isEmpty() || a.peek().compareTo(b.peek()) < 0)) {
                        moveDisk(a, b);
                        System.out.println("Move disk from a to b");
                    } else {
                        moveDisk(b, a);
                        System.out.println("Move disk from b to a");
                    }
                } else {
                    // Movimiento cuando el residuo es 0 (divisible por 3)
                    if (!c.isEmpty() && (b.isEmpty() || c.peek().compareTo(b.peek()) < 0)) {
                        moveDisk(c, b);
                        System.out.println("Move disk from c to b");
                    } else {
                        moveDisk(b, c);
                        System.out.println("Move disk from b to c");
                    }
                }
            }

            // Imprime el estado final de las pilas
            System.out.println("Final state:");
            printPiles(a, b, c);
    }

    /**
     * Imprime el estado de las pilas.
     *
     * @param source    Pila de origen.
     * @param auxiliary Pila auxiliar.
     * @param target    Pila de destino.
     */
    public void printPiles(Stack<E> source, Stack<E> auxiliary, Stack<E> target) {
        System.out.println("a: " + source);
        System.out.println("b: " + auxiliary);
        System.out.println("c: " + target);
        System.out.println();
    }
}


