/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package backtracking;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Conjunto de tests de la clase 'MotxillaImpl'.
 *
 * @author antoni
 * @author KIB & ARV
 */
public class MotxillaImplTest {

    private ElementMotxilla<String>[] a, a1, a4, a5;
    private ElementMotxilla<Integer>[] a2;
    private ElementMotxilla<Character>[] a3;
    private Motxilla m;

    /**
     * Inicializa el array de los 'ElementMotxilla' y los rellena.
     */
    @Before
    public void setUp() {
        a = new ElementMotxilla[5];
        a[0] = new ElementMotxilla<>("A", 1.0, 2.0, 3.0);
        a[1] = new ElementMotxilla<>("B", 3.0, 1.0, 7.0);
        a[2] = new ElementMotxilla<>("C", 2.0, 1.0, 5.0);
        a[3] = new ElementMotxilla<>("D", 2.0, 1.0, 6.0);
        a[4] = new ElementMotxilla<>("E", 1.0, 2.0, 5.0);

        m = new MotxillaImpl();
        a1 = new ElementMotxilla[6];
        a1[0] = new ElementMotxilla<>("Ditto", 2.5, 5.0, 7.3);
        a1[1] = new ElementMotxilla<>("Arbok", 5.5, 2.0, 4.0);
        a1[2] = new ElementMotxilla<>("Kakuna", 1.5, 5.3, 3.9);
        a1[3] = new ElementMotxilla<>("Metapod", 2.2, 1.0, 2.6);
        a1[4] = new ElementMotxilla<>("Unown", 1.45, 6.0, 3.4);
        a1[5] = new ElementMotxilla<>("Klefki", 0.5, 0.75, 1.7);

        a2 = new ElementMotxilla[4];
        a2[0] = new ElementMotxilla<>(9, 2.0, 2.5, 4.4);
        a2[1] = new ElementMotxilla<>(3, 3.1, 1.3, 5.2);
        a2[2] = new ElementMotxilla<>(17, 4.7, 3.2, 3.9);
        a2[3] = new ElementMotxilla<>(11, 1.2, 1.0, 1.6);

        a3 = new ElementMotxilla[5];
        a3[0] = new ElementMotxilla<>('U', 3.2, 5.2, 3.0);
        a3[1] = new ElementMotxilla<>('L', 1.4, 7.2, 4.0);
        a3[2] = new ElementMotxilla<>('T', 3.6, 4.7, 2.4);
        a3[3] = new ElementMotxilla<>('I', 6.2, 2.2, 6.7);
        a3[4] = new ElementMotxilla<>('M', 5.0, 1.3, 3.5);

        MotxillaImpl mi = new MotxillaImpl();
        a4 = mi.recogerDatosCSV("ficheroModificado.csv", 10);

        a5 = mi.recogerDatosCSV("ficheroModificado.csv", 20);

    }

    /**
     * Test que contiene un conjunto de pruebas del método recursivo de
     * backtracking.
     */
    @Test
    public void testRecursiu() {
        System.out.println("recursiu");
        test(m.recursiu(a, 3.0, 5.0));
        test1(m.recursiu(a1, 4.7, 6.0));
        test2(m.recursiu(a2, 3.0, 4.0));
        test3(m.recursiu(a3, 10.0, 8.7));
        testFichero(m.recursiu(a4, 100000000.0, 60.0));
        testFichero1(m.recursiu(a5, 165000000.0, 85.0));
    }

    /**
     * Test que contiene un conjunto de pruebas del método iterativo de
     * backtracking.
     */
    @Test
    public void testIteratiu() {
        System.out.println("iteratiu");
        test(m.iteratiu(a, 3.0, 5.0));
        test1(m.iteratiu(a1, 4.7, 6.0));
        test2(m.iteratiu(a2, 3.0, 4.0));
        test3(m.iteratiu(a3, 10.0, 8.7));
        testFichero(m.iteratiu(a4, 100000000.0, 60.0));
        testFichero1(m.iteratiu(a5, 165000000.0, 85.0));
    }

    /**
     * Conjunto de resultados con los datos del array 'a' de tipo String. Test
     * del profesor.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void test(ElementMotxilla[] result) {
        assertEquals(3.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(3.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(11.0, ElementMotxilla.profit(result), 0.0);
        assertEquals(2, result.length);
        assertEquals("D", result[0].getElement());
        assertEquals("E", result[1].getElement());
    }

    /**
     * Conjunto de resultados con los datos del array 'a1' de tipo String.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void test1(ElementMotxilla[] result) {
        assertEquals(4.7, ElementMotxilla.w1(result), 0.0);
        assertEquals(6.0, ElementMotxilla.w2(result), 0.0);
        assertEquals(9.9, ElementMotxilla.profit(result), 0.0);
        assertEquals(2, result.length);
        assertEquals("Ditto", result[0].getElement());
        assertEquals("Metapod", result[1].getElement());
    }

    /**
     * Conjunto de resultados con los datos del array 'a2' de tipo Integer.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void test2(ElementMotxilla[] result) {
        assertEquals(2.0, ElementMotxilla.w1(result), 0.0);
        assertEquals(2.5, ElementMotxilla.w2(result), 0.0);
        assertEquals(4.4, ElementMotxilla.profit(result), 0.0);
        assertEquals(1, result.length);
        assertEquals(9, result[0].getElement());
    }

    /**
     * Conjunto de resultados con los datos del array 'a3' de tipo Character.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void test3(ElementMotxilla[] result) {
        assertEquals(9.4, ElementMotxilla.w1(result), 0.0);
        assertEquals(7.4, ElementMotxilla.w2(result), 0.0);
        assertEquals(9.7, ElementMotxilla.profit(result), 0.0);
        assertEquals(2, result.length);
        assertEquals('U', result[0].getElement());
        assertEquals('I', result[1].getElement());
    }

    /**
     * Conjunto de resultados con los datos del array 'a4' de tipo String que
     * contiene las 10 primeras líneas del fichero que le pasamos.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void testFichero(ElementMotxilla[] result) {
        assertEquals(9.75E7, ElementMotxilla.w1(result), 0.0);
        assertEquals(59, ElementMotxilla.w2(result), 0.0);
        assertEquals(177, ElementMotxilla.profit(result), 0.0);
        assertEquals(2, result.length);
        assertEquals("V. van Dijk", result[0].getElement());
        assertEquals("M. Neuer", result[1].getElement());
    }

    /**
     * Conjunto de resultados con los datos del array 'a4' de tipo String que
     * contiene las 20 primeras líneas del fichero que le pasamos.
     *
     * @param result método recursivo o iterativo con los límites establecidos
     */
    private void testFichero1(ElementMotxilla[] result) {
        assertEquals(1.63E8, ElementMotxilla.w1(result), 0.0);
        assertEquals(82, ElementMotxilla.w2(result), 0.0);
        assertEquals(267, ElementMotxilla.profit(result), 0.0);
        assertEquals(3, result.length);
        assertEquals("Sergio Busquets", result[0].getElement());
        assertEquals("T. Courtois", result[1].getElement());
        assertEquals("M. ter Stegen", result[2].getElement());
    }

}
