/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package peak;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 * @author ARV & KIB
 */
public class PeakImplTest {
    
    /**
     * Test of peak method, of class PeakImpl.
     */
    @Test
    public void testPeak() {
        System.out.println("peak");
        int[] a = {1, 3, 5, 7, 8, 5, 2, 1};
        Point expResult = new Point(8, 4);
        Peak p = new PeakImpl();
        long start = System.nanoTime();
        Point result = p.peak(a);
        long end = System.nanoTime();
        System.out.println("Time execution in nano seconds: "+ (end-start));
        assertEquals(expResult, result);
    }

    /**
     * Test 2 of peak method, of class PeakImpl.
     * Array con solo 3 elementos.
     */
    @Test
    public void testPeak2() {
        System.out.println("peak");
        int[] a2 = {0, 4, 1};
        Point expResult = new Point(4, 1);
        Peak p = new PeakImpl();
        long start = System.nanoTime();
        Point result = p.peak(a2);
        long end = System.nanoTime();
        System.out.println("Time execution in nano seconds: "+ (end-start));

        assertEquals(expResult, result);
    }

    /**
     * Test 3 of peak method, of class PeakImpl.
     * Array con longitud impar y peak justo en medio.
     */
    @Test
    public void testPeak3() {
        System.out.println("peak");
        int[] a3 = {2, 3, 5, 8, 6, 4, 1};
        Point expResult = new Point(8, 3);
        Peak p = new PeakImpl();
        long start = System.nanoTime();
        Point result = p.peak(a3);
        long end = System.nanoTime();
        System.out.println("Time execution in nano seconds: "+ (end-start));
        assertEquals(expResult, result);
    }

    /**
     * Test 4 of peak method, of class PeakImpl.
     * Array con longitud par y peak en medio izquierda.
     */
    @Test
    public void testPeak4() {
        System.out.println("peak");
        int[] a4 = {0, 1, 6, 9, 7, 4, 3, 2};
        Point expResult = new Point(9, 3);
        Peak p = new PeakImpl();
        long start = System.nanoTime();
        Point result = p.peak(a4);
        long end = System.nanoTime();
        System.out.println("Time execution in nano seconds: "+ (end-start));
        assertEquals(expResult, result);

    }

    /**
     * Test 5 of peak method, of class PeakImpl.
     * Array con peak en la izquierda
     */
    @Test
    public void testPeak5() {
        System.out.println("peak");
        int[] a4 = {0, 1, 9, 8, 7, 4, 3, 2};
        Point expResult = new Point(9, 2);
        Peak p = new PeakImpl();

        long start = System.nanoTime();
        Point result = p.peak(a4);
        long end = System.nanoTime();

        System.out.println("Time execution in nanoseconds: " + (end - start));
       assertEquals(expResult, result);
    }


    /**
     * Test 6 of peak method, of class PeakImpl.
     * Array con peak en la derecha
     */
    @Test
    public void testPeak6() {
        System.out.println("peak");
        int[] a4 = {0, 1, 6, 7, 8, 9, 3, 2};
        Point expResult = new Point(9, 5);
        Peak p = new PeakImpl();
        long start = System.nanoTime();
        Point result = p.peak(a4);
        long end = System.nanoTime();
        System.out.println("Time execution in nano seconds: "+ (end-start));
        assertEquals(expResult, result);
    }
}
