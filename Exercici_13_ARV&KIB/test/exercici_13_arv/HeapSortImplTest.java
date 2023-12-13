/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package exercici_13_arv;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 * @author ARV & KIB
 */
public class HeapSortImplTest {

    public HeapSortImplTest() {
    }

    /**
     * Test of heapSort method, of class HeapSortImpl.
     */
    @Test
    public void testHeapSort() {
        System.out.println("heapSort");
        Integer a[] = new Integer[100];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test 2 of heapSort method, of class HeapSortImpl. Pruebo con un array
     * ordenado de forma inversa.
     */
    @Test
    public void testHeapSort2() {
        System.out.println("heapSort2");
        Integer a[] = new Integer[6];

        int j = 6;
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;
        }

        HeapSortImpl<Integer> hs = new HeapSortImpl<>();
        hs.heapSort(a);

        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        assertEquals(true, result);
    }

    /**
     * Test 3 of heapSort method, of class HeapSortImpl. Pruebo con un array de
     * tipo string.
     */
    @Test
    public void testHeapSort3() {
        System.out.println("heapSort3");
        String s[] = new String[4];

        String s0 = "Hola";
        String s1 = "Mi";
        String s2 = "Casa";
        String s3 = "Soy";
        String strings[] = {s0, s1, s2, s3};

        for (int i = 0; i < strings.length; i++) {
            s[i] = strings[i];
        }

        HeapSortImpl<String> hs = new HeapSortImpl<>();
        hs.heapSort(s);

        boolean result = true;
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].compareTo(s[i + 1]) > 0) {
                result = false;
            }
        }
        assertEquals(true, result);
    }
}
