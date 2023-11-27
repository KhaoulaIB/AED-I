/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriu;

/**
 *
 * @author antoni-KIB&ARV
 * @param <E>
 */
public class MatriuImpl<E extends Comparable<E>> implements Matriu<E> {
    private E matriu[];
    private int rows;
    private int cols;

    /**
     * Es crea una matriu representada en un array per files
     *Ordre de complexitat : O(1) perqué són només operacions d'assignació de valors.
     * @param cols
     * @param rows
     */
    public MatriuImpl(int rows, int cols) {
        matriu= (E[]) new Object [cols*rows];
        this.rows=rows;
        this.cols=cols;
    }

    /**
     * Es crea una matriu representada en un array per files
     *Ordre de complexitat: O(1) perqué són només operacions d'assignació de valors.
     * @param matriu
     * @param cols
     * @param rows
     */
    public MatriuImpl(E[] matriu, int rows, int cols) {
        this.matriu=matriu;
        this.rows=rows;
        this.cols=cols;

    }

    /**
     * Inserta un element en la matriu
     *Ordre de complexitat: O(1) ja que és una operació d'assignació de valor.
     * @param e element a insertar
     * @param row fila
     * @param col columna
     */
    @Override
    public void set(E e, int row, int col) {
        matriu[row * cols+col]=e;
    }

    /**
     * Obtener un element de la matriu a partir de la fila i columna dades.
     *Ordre de complexitat: O(1) perqué és una simple operació d'acces a un valor determinat
     * de la matriu
     * @param row fila
     * @param col columna
     * @return
     */
    @Override
    public E get(int row, int col) {
    return matriu[row * cols + col];
    }

    /**
     * @Especificació
     *  Indica si la matriu és simètrica. Crida al metode recursiu auxiliar esMatrizSimetricaAux.
     * @pre la matriu ha de ser cuadrada ja que només en aquest cas es pot determinar si és simetrica o no.
     * i no ha de ser buida.
     * En llenguatge de predicats tenim: matriu.rows == matriu.cols && rols>0 && cols>0
     * @Anàlisi_de_Casos & Composicio
     * Case base:if (i == this.rows-1 && j == this.cols-1) quan ha processat totes les files i totes les columnes acaba l'algoritme.
     * Case recursiu:avanza a la seguent posició de la matriu incrementant la fila i columna quan toca, és a dir
     * quan procesa tots els elements d'una fila/columna. I crida recusivament al metode per verficar la simetria d'aqustes noves posicions passats per paramtere.
     *
     @Proof
      *   @Syntactic_check:
     *     Las llamadas a los subprogramas "isSymmetricalRecursiu" y "esMatrizSimetricaAux" se realizan correctamente
     *     con los tipos de parámetros adecuados (int i, int j).
     *   @Semantic_check:
     *     @Precondition:
     *       - Se cubren todos los estados especificados en @pre. 
     *       - El caso base (i == this.rows-1 && j == this.cols-1) se maneja correctamente, asegurando que
     *         el algoritmo cubra la condición en la que se han procesado todas las posiciones de la matriz.
     *     @Correctness_without_recursion:
     *       - Para el caso base, se verifica correctamente si los elementos simétricos son iguales.
     *     @Parameter_values_for_recursive_calls:
     *       - Las llamadas recursivas se realizan con valores ajustados (i, j+1) para avanzar a la siguiente posición de la matriz.
     *       - El orden de los parámetros (i, j) se ajusta en las llamadas recursivas para indicar el movimiento adecuado
     *         a través de las filas y columnas de la matriz.
     *     @Postcondition:
     *       - La postcondición se cumple para cada llamada recursiva, ya que la verificación de simetría y el avance
     *         a la siguiente posición de la matriz se manejan correctamente.
     * Ordre de complexitat : O(n^2) on n és el nombre de files o columnes de la matriu, ja que és el métode
     * recorre totes les posicions de la matriu en una forma recursiva un pic.
     * En quant a la relació d'aquest ordre de complexitat amb el d'arbres binaris es pot afirmar que
     * l'ordre de coplexitat dels arbres binaris és millor -en termes d'eficiencia- que l'ordre de complexitat de la simetria de matriu.
     * Ja que O(log n) és menos complex que O(n^2).
     * @return vertader si és simètrica, false en cas contrari
     */
    @Override
    public boolean isSymmetricalRecursiu() {

    return esMatrizSimetricaAux(0,0);
    }


    /**
     *
     * Ordre de complexitat: O(n^2) on n és el nombre de files o columnes de la matriu, ja que és el métode.
     * recorre totes les posicions de la matriu en una forma recursiva un pic.
     * Verifica de forma recursiva si la matriu és simetrica. Verficiant en cada
     *  cridada si els elements simetrics de la matriu són iguals.
     * @param i fila de l'element de la matriu
     * @param j columna de l'element de la matriu
     * @return  true si la matriu és simetrica. Fals en cas contrari.
     */
    private boolean esMatrizSimetricaAux( int i, int j) {
        if (this.rows!=this.cols){
            return false;//no es cuadrada
        }
        // Caso base: si hem arribat al final de la matriu, és simétrica
        if (i == this.rows-1 && j == this.cols-1) {
            return true;
        }

        // Verificar si els elements simétrics són iguales
        if (get(i,j).compareTo(get(j,i)) != 0) {
            return false;
        }

        // Avanzar a la següent posició de la matriu
        if (j == this.cols - 1) {
            // Avançar a la següent fila
            return esMatrizSimetricaAux(  i + 1, 0);
        } else {
            // Avançar a la següent columna
            return esMatrizSimetricaAux( i, j + 1);
        }
    }

    /**
     * Indica si la matriu és simètrica. Procesa de forma iterativa totes els elements
     * simetrics de la matriu i si no són igauls retorna false. En cas contrari retorna vertader.
     * Orden de complejidad O(n^2) ja que tenim dos bules de for anidats, i n representa el nombre de files o columnes de
     * la matriu dada.També passa lo mateix que en l'algoritme recursiu, els arbres binaris són més eficiente i menos complexos que aquest algoritme de simetria iterativa.
     * @return vertader si és simètrica, false en cas contrari.
     */
    @Override
    public boolean isSymmetricalIteratiu() {
        if (this.rows!=this.cols){
            return false;
        }
        for (int i =0; i<this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (get(i, j).compareTo(get(j, i)) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
