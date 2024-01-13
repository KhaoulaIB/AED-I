/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtracking;

import java.util.Arrays;
import java.io.*;

/**
 * Clase que contiene la implementación de los métodos backtracking recursivo e
 * iterativo y la conversión de datos de un fichero a objetos de la clase
 * 'ElementMotxilla'.
 *
 * @author antoni
 * @author KIB & ARV
 */
public class MotxillaImpl implements Motxilla {

    private static double maxp;

    /**
     * Método que inicializa los parámetros del método auxiliar al que llamamos
     * para hacer todo el backtracking y devuelve la solución encontrada en ese
     * método.
     *
     * @orden O(2^n), donde n es el número de elementos del array
     * 'ElementMotxilla', ya que utiliza un método de fuerza bruta donde se repasan
     * todos con todos.
     * @param a array con los elementos 'ElementMotxilla'
     * @param W1 peso 1
     * @param W2 peso 2
     * @return el array con la solución del método backtracking.
     */
    @Override
    public ElementMotxilla[] recursiu(ElementMotxilla[] a, double W1, double W2) {
        int[] t = new int[a.length];
        Arrays.fill(t, -1);
        maxp = 0;
        int[] solucion = new int[a.length];
        recursiuAux(a, W1, W2, t, solucion, 0);
        return buildSolucion(solucion, a);
    }

    /**
     * Método auxiliar donde ampliamos el número de parámetros con el que
     * realizamos el algoritmo backtracking. Sumamos todos los atributos con
     * todos los atributos para obtener el máximo profit.
     *
     * @param a array con los elementos 'ElementMotxilla'
     * @param W1 peso 1
     * @param W2 peso 2
     * @param t array auxiliar para realizar todas las operaciones posibles
     * @param solucion devuelve el array con la solución temporal (una vez hecha
     * todas las operaciones puede ser la solución final)
     * @param k índice del array t y  nivel del arbol binario que se construye por el algoritmo
     */
    private void recursiuAux(ElementMotxilla[] a, double W1, double W2, int[] t, int[] solucion, int k) {
        t[k] = -1; //empezando por el primer nodo
        while (t[k] < 1) {
            t[k]++; //procesamos el nodo actual
            double sum1 = getSumWeight(a, k, true, t); //suma de pesos 1
            double sum2 = getSumWeight(a, k, false, t); //suma de pesos 2
            double profit = getProfit(a, t);
            if (sum1 <= W1 && sum2 <= W2 && k == a.length - 1) {
                if (profit > maxp) {
                    maxp = profit;
                    System.arraycopy(t, 0, solucion, 0, t.length);
                }
            } else if (sum1 <= W1 && sum2 <= W2 && k < a.length - 1) {
                recursiuAux(a, W1, W2, t, solucion, k + 1);//posible solucion
            }
        }
        t[k] = -1;
    }

    /**
     * Método que obtiene los profits de cada conjunto que hacemos de
     * backtracking para determinar cuál es el que tiene el mayor profit.
     *
     * @param a array con los elementos 'ElementMotxilla'
     * @param t array que representa los elementos que forman parte del arreglo de la solución
     * @return el profit de cada conjunto que hacemos de backtracking
     */
    private double getProfit(ElementMotxilla[] a, int[] t) {
        double p = 0.0;
        for (int i = 0; i < a.length; i++) {
            p += a[i].getProfit() * t[i];
        }
        return p;
    }

    /**
     * Este método usa la solución que está de formato 1/0 (es decir los elementos a incluir/no incluir)
     * para generar el arreglo de solucion.
     *
     * @param solucion array de enteros con la solución
     * @param a array con los elementos 'ElementMotxilla'
     * @return la solución de tipo 'ElementMotxilla'
     */
    private ElementMotxilla[] buildSolucion(int[] solucion, ElementMotxilla[] a) {
        int counter = 0;
        //calcularemos el numero de elementos de la solucion
        for (int j : solucion) {
            if (j == 1) {//si el elemento esta incluido en la solución
                counter++;
            }
        }
        ElementMotxilla[] result = new ElementMotxilla[counter];
        int index = 0;
        for (int i = 0; i < solucion.length; i++) {
            if (solucion[i] > 0) {
               // ElementMotxilla tmp = new ElementMotxilla<>(a[i].getElement(), a[i].getWeigth1(), a[i].getWeigth2(), a[i].getProfit());
                result[index] = new ElementMotxilla<>(a[i].getElement(), a[i].getWeigth1(), a[i].getWeigth2(), a[i].getProfit());
                index++;
            }
        }
        return result;
    }

    /**
     * Método que realiza la suma de los diferentes pesos de cada elemento. Si
     * weight1 es true suma los pesos 1, sino suma los pesos 2.
     *
     * @param a array con los elementos 'ElementMotxilla'
     * @param k índice de t
     * @param isWeight1 booleano para determinar que pesos sumar(peso1 o peso2)
     * @param t array que representa los elementos que forman parte del arreglo de la solución
     * @return sum la suma de cada conjunto que hacemos de backtracking
     */
    private double getSumWeight(ElementMotxilla[] a, int k, boolean isWeight1, int[] t) {
        double sum = 0.0;
        for (int i = 0; i <= k; i++) {
            sum += (isWeight1 ? a[i].getWeigth1() : a[i].getWeigth2()) * t[i];
        }
        return sum;
    }

    /**
     * Método que lleva a cabo el algoritmo de backtracking de la mochila de
     * manera iterativa.
     *
     * @orden O(2^n), no cambia el orden de complejidad del método recursivo.
     * @param a array con los elementos 'ElementMotxilla'
     * @param W1 peso 1
     * @param W2 peso 2
     * @return el array con la solución del método backtracking.
     */
    @Override
    public ElementMotxilla[] iteratiu(ElementMotxilla[] a, double W1, double W2) {
        int k = 0;
        double sum1 = 0, sum2 = 0, profit = 0;
        maxp = 0;
        int[] t = new int[a.length];
        Arrays.fill(t, -1);
        int[] solucion = new int[a.length];
        t[k] = -1; //empezando por el primer nodo
        while (k >= 0) {
            if (t[k] < 1) {
                t[k]++; //procesamos el nodo actual
                sum1 += a[k].getWeigth1() * t[k];
                sum2 += a[k].getWeigth2() * t[k];
                profit += a[k].getProfit() * t[k];
                if (sum1 <= W1 && sum2 <= W2 && k == a.length - 1) {
                    if (profit > maxp) {
                        maxp = profit;
                        System.arraycopy(t, 0, solucion, 0, t.length);
                    }
                } else if (sum1 <= W1 && sum2 <= W2 && k < a.length - 1) {
                    k++;
                }
            } else {
                sum1 -= a[k].getWeigth1() * t[k];
                sum2 -= a[k].getWeigth2() * t[k];
                profit -= a[k].getProfit() * t[k];
                t[k] = -1;
                k--;
            }

        }
        return buildSolucion(solucion, a);
    }

    /**
     * Recoge los datos del fichero CSV y los convierte en atributos de la clase
     * 'ElementMotxilla'. El fichero que hemos elegido es una base de datos con
     * jugadores del juego FIFA (hace unos 5 años) con sus estadísticas. Hay que
     * tener en cuenta que el primer atributo es un nombre (String), el segundo
     * corresponde al valor de mercado (double), el tercero corresponde a la
     * edad (double) y el último es la valoración del jugador concordando con
     * elemento, w1, w2 y el 'profit'.
     *
     * @param fichero fichero del que recogemos los datos. No puede tener
     * valores nulos y tiene que tener los correspondientes tipos de datos que
     * hemos citado.
     * @param nlineas número de lineas que escogemos del fichero. Empieza desde
     * la primera línea del fichero.
     * @return un array con objetos de la clase 'ElementMotxilla'.
     */
    public ElementMotxilla[] recogerDatosCSV(String fichero, int nlineas) {
        ElementMotxilla[] em = new ElementMotxilla[nlineas];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea = br.readLine();
            int contador = 0, index=0;
            //Convertimos las líneas del fichero en elementos de la clase 'ElementMotxilla'
            while ((linea != null) && (nlineas > contador)) {
                String[] separacion = linea.split(",");
                em[index++] = new ElementMotxilla(separacion[0], Double.parseDouble(separacion[1]),
                        Double.parseDouble(separacion[2]), Double.parseDouble(separacion[3]));
                contador++;
                linea = br.readLine();
            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return em;
    }

}
