/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree;

import com.sun.source.tree.ReturnTree;
import org.w3c.dom.Node;

import java.text.Normalizer;

/**
 *
 * @author KIB
 */
public class BinaryTreeReference<E extends Comparable<E>> implements BinaryTree<E> {

    /**
     * Representación interna de un nodo en el árbol binario.
     */
    class NodeArbre {

        /** Elemento almacenado en el nodo. */
        E element;
        /** Hijo izquierdo del nodo. */
        NodeArbre left;
        /** Hijo derecho del nodo. */

        NodeArbre right;

        /**
         * Construye un nodo con el elemento dado.
         *
         * @param element Elemento que se almacenará en el nodo.
         */
        public NodeArbre(E element){
            this.element=element;
            left =null;
            right =null;
        }



    }
    /** Raíz del árbol binario. */

    NodeArbre root;
    /**
     * Constructor de un arbol binario vacío.
     */
    public BinaryTreeReference(){
        this.root=null;
    }

    /**
     * Verifica si el árbol binario está vacío.
     *
     * @return Verdadero si el árbol está vacío, falso en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return root ==null;
    }


    /**
     * Inserta un nuevo elemento en el árbol binario si aún no existe.
     *
     * @param e Elemento que se va a insertar.
     */
    @Override
    public void insert(E e) {
        if (!contains(e) ) {  //si el elemento no existe ya en el arbol
            root = Recursiveinsert(e, root);
        }
    }

    /**
     *  Metodo auxiliar recursivo para la inserción de un elemento nuevo en el arbol.
     *  Para decidir dónde realizar la inserción, comienza desde la raíz.
     * Si el elemento es menor, examina el subárbol izquierdo; si es mayor, explora el subárbol derecho.
     * Este proceso se repite de manera recursiva hasta llegar a la hoja correspondiente para realizar la inserción.
     * @param element Elemento que se va a insertar.
     * @param current   Nodo actual en el cual se considera la inserción
     * @return  El nodo actual después de realizar la inserción recursiva.

     */
    public NodeArbre Recursiveinsert(E element, NodeArbre current){
            if (current == null){
                    return new NodeArbre(element);
                }
            if (element.compareTo(current.element) < 0) {
            current.left=Recursiveinsert(element,current.left);

            } else {
                current.right=Recursiveinsert(element,current.right);
            }

        return current;

        }


    /**
     *
     * @param e element se quiere compreubar que existe en el árbol.
     * @return verdadero en caso que e existe en el árbol. Falso en caso contrario.
     */
    @Override
    public boolean contains(E e) {
       return containsRecursive(e,root);
    }

    /**
     * Verifica de manera recursiva si el árbol binario contiene el elemento dado a partir del nodo actual.
     *
     * @param element Elemento que se está buscando en el árbol.
     * @param current Nodo actual en el que se está realizando la búsqueda.
     * @return Verdadero si el elemento está presente en el árbol, falso en caso contrario.
     */
    public boolean containsRecursive(E element, NodeArbre current){
        /**
         * Si el nodo actual es nulo, el elemento no está presente en este subárbol.
         */
        if (current==null){
            return false;
        }
        /**
         * Compara el elemento con el elemento del nodo actual.
         * Si son iguales, el elemento se encuentra en este nodo y se devuelve verdadero.
         * Si el elemento es menor, la búsqueda continúa en el subárbol izquierdo.
         * Si el elemento es mayor, la búsqueda continúa en el subárbol derecho.
         */
        if (element.compareTo(current.element)==0){
            return true;
        }
        if (element.compareTo(current.element)<0){
            return containsRecursive(element,current.left);
        }else{
            return containsRecursive(element,current.right);
        }
    }

    /**
     * Obtiene la madre (nodo padre) del elemento dado en el árbol binario.
     *
     * @param e Elemento del cual se busca la madre.
     * @return El elemento de la madre del nodo que contiene el elemento dado.
     *         Devuelve nulo si el elemento no está presente o es la raíz del árbol.
     */
    @Override
    public E getMother(E e) {
        return  (contains(e)) ? getMotherRecursive(e, root) :null ;

    }

    /**
     * Obtiene la madre (nodo padre) del elemento dado de manera recursiva a partir del nodo actual.
     *
     * @param element Elemento del cual se busca la madre.
     * @param current Nodo actual en el que se está realizando la búsqueda de la madre.
     * @return El elemento de la madre del nodo que contiene el elemento dado.
     *         Devuelve nulo si el elemento no tiene madre o no está presente.
     */
    private E getMotherRecursive(E element, NodeArbre current) {
        /**
         * Si el nodo actual es nulo, el elemento no tiene madre en este subárbol.
         */
        if (current == null) {
            return null;
        }

            /**
             * Comprueba si el hijo izquierdo o derecho del nodo actual contiene el elemento buscado.
             * Si es así, devuelve el elemento del nodo actual como la madre.
             * Si no, continúa la búsqueda de manera recursiva en los subárboles izquierdo y derecho.
             */
            if ((current.left != null && element.compareTo(current.left.element) == 0) ||
                (current.right != null && element.compareTo(current.right.element) == 0)) {
            return current.element;
        }

        E leftResult = getMotherRecursive(element, current.left);
        if (leftResult != null) {
            return leftResult;
        }

        return getMotherRecursive(element, current.right);
    }




    /**
     * Calcula la longitud de la rama más larga en el árbol binario.
     *
     * @return La longitud de la rama más larga a partir del nodo actual.
     */
    @Override
    public int longestBranch() {
        return recursiveLongestBranch(root);
    }

    /**
     * Calcula de manera recursiva la longitud de la rama más larga a partir del nodo actual.
     *
     * @param current Nodo actual en el que se está calculando la longitud de la rama.
     * @return La longitud de la rama más larga a partir del nodo actual.
     */
    private int recursiveLongestBranch(NodeArbre current) {
        /**
         * Si el nodo actual es nulo o es una hoja, la longitud de la rama es 0.
         */
        if (current == null  || (current.left==null && current.right==null)) {
            return 0;
        }

        /**
         * Calcula de manera recursiva la longitud de las ramas izquierda y derecha.
         * Devuelve la longitud máxima entre las dos, más 1 para contar el nodo actual.
         */
        int leftDepth = recursiveLongestBranch(current.left);
        int rightDepth = recursiveLongestBranch(current.right);

        return Math.max(leftDepth, rightDepth)+1;
    }


    /**
     * Devuelve la raíz del árbol binario.
     * @return la raiz del árbol binario.
     */
    @Override
    public E getRoot() {
        return root.element;
    }

}
