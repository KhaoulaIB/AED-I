/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici15_arv;

/**
 * Clase que contiene el coloreado de mapas en backtracking tanto de forma
 * recursiva como iterativa.
 *
 * @author antoni
 * @author ARV & KIB
 */
public class BacktrackingImpl implements Backtracking {

    /**
     * Método que se expande al método principal de backtracking, donde se
     * aumenta el número de atributos.
     *
     * @pre map es un array de arrays y los nodos de este array deben tener
     * sentido ya que si 0 está conectado con 2 en el array(nodo) 0, en el
     * array(nodo) 2, estará conectado con 0. La cantidad de arrays dentro del
     * array definen los números disponibles que se pueden dentro del mapa. Por
     * ejemplo: si hay 5 arrays, el mapa puede contener números del 0 al 4 (5
     * números). El número de colores debe ser mayor a 0.
     * @post devuelve verdadero si dado el mapa de conexiones, se pueden
     * conectar con los colores que pasen por parámetro, falso en caso
     * contrario.
     * @Analisi de casos:
     * @caso base: representa la parte donde se han visitado todos los nodos y
     * se ha podido representar el mapa con los colores dados por parámetro.
     * Seria esta parte: if ((isValid(map, t, k)) & (k == t.length - 1)).
     * @caso recursivo: representa a las llamadas recursivas que se van haciendo
     * dentro de los métodos para poder visitar todos los nodos con todos los
     * colores posibles. Estas 2 son las llamadas recursivas: return
     * mapColor(map, nColors, t, 0); if (mapColor(map, nColors, t, k + 1)).
     * @orden de complejidad: O(n^m), donde n es el número de nodos y m es el
     * número de colores, ya que exploras todos los nodos probando todos los
     * posibles colores para cada uno de ellos. Esto seria el peor caso porque
     * se podría encontrar antes la solución. Esto se podría interpretar como un
     * árbol donde cada hoja es un nodo y en cada nodo se prueban todos los
     * colores, en el árbol binario se va dividiendo la búsqueda y aquí se va
     * expandiendo el árbol.
     * @proof está escrito en los métodos como comentarios de código.
     * @param map mapa que contiene las conexiones de cada nodo
     * @param nColors número de colores disponibles para dibujar el mapa
     * @return verdadero si se ha podido dibujar el mapa con los colores
     * disponibles, falso en caso contrario.
     */
    @Override
    public boolean mapColor(int[][] map, int nColors) {
        //Check sintáctico: el nombre de parámetros corresponde a la especificación
        int[] t = new int[map.length];
        //Check sintáctico: se llama correctamente a la función recursiva
        return mapColor(map, nColors, t, 0);
    }

    /**
     * Método recursivo backtracking que conlleva todos los pasos realizados en
     * el árbol que se expande para comprobar todos los nodos con todos los
     * colores posibles.
     *
     * @param map mapa que contiene las conexiones de cada nodo
     * @param nColors número de colores disponibles para dibujar el mapa
     * @param t array que contiene el nodo a visitar
     * @param k índice de t
     * @return verdadero si se ha podido dibujar el mapa con los colores
     * disponibles, falso en caso contrario.
     */
    private static boolean mapColor(int[][] map, int nColors, int[] t, int k) {
        t[k] = -1;
        //Check semántico: todos los estados de la @pre están cubiertos.
        while (t[k] < nColors - 1) {
            t[k]++;
            if ((isValid(map, t, k)) & (k == t.length - 1)) {
                return true;
            } else if ((isValid(map, t, k)) & (k < t.length - 1)) {
                //Check semántico: llamar recursivamente satisface la @post.
                //Check semántico: el tamaño se vuelve cada vez más pequeño: k+1.
                //Check semántico: el valor de los parámetros siempre satisfacen la @pre.
                if (mapColor(map, nColors, t, k + 1)) {
                    return true;
                }
            }
        }
        //Check semántico: el algoritmo es correcto si no hay llamadas recursivas.
        t[k] = -1;
        return false;
    }

    /**
     * Método iterativo backtracking que comprueba que todos los nodos se puedan
     * dibujar con los colores dados por parámetro de forma que los vecinos
     * adyacentes no tengan los mismos colores.
     *
     * @param map mapa que contiene las conexiones de cada nodo
     * @param nColors número de colores disponibles para dibujar el mapa
     * @return verdadero si se ha podido dibujar el mapa con los colores
     * disponibles, falso en caso contrario.
     */
    public boolean imapColor(int[][] map, int nColors) {
        int[] t = new int[map.length];
        int k = 0;
        //se inicializa a -1 todo el array.
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }
        //se visitan todos los nodos.
        while (k >= 0) {
            //se comprueban todos los posibles colores.
            if (t[k] < nColors - 1) {
                t[k]++;
                //se ha encontrado una solución válida.
                if ((isValid(map, t, k)) & (k == t.length - 1)) {
                    return true;
                    //se visitan más nodos.
                } else if ((isValid(map, t, k)) & (k < t.length - 1)) {
                    k++;
                }
            } else {
                t[k] = -1;
                k--;
            }
        }
        //se ha probado todo y no se ha encontrado solución.
        return false;
    }

    /**
     * Método que comprueba que el dibujado del mapa sea válido para cada
     * elemento del array.
     *
     * @param map mapa que contiene las conexiones de cada nodo
     * @param t array que contiene el nodo a visitar
     * @param k índice de t
     * @return verdadero si el nodo a visitar es válido, falso en caso
     * contrario.
     */
    private static boolean isValid(int[][] map, int[] t, int k) {
        //Cubre todas las conexiones de un array de arrays
        for (int i = 0; i < map[k].length; i++) {
            if (map[k][i] < k) {
                //se mira si un vecino tiene el mismo color
                if (t[k] == t[map[k][i]]) {
                    return false;
                }
            }
        }
        return true;
    }
}
