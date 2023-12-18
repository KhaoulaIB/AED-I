/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package exercici15_arv;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni
 * @author ARV & KIB
 */
public class BacktrackingImplTest {

    public BacktrackingImplTest() {
    }

    /**
     * Test of mapColor method, of class BacktrackingImpl. Parte recursiva e
     * iterativa.
     */
    @Test
    public void testMapColor() {
        System.out.println("mapColor");
        int[][] map = {{1, 3}, {0, 2, 3, 4}, {1, 4}, {0, 1}, {1, 2}};
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test 2 of mapColor method, of class BacktrackingImpl. Parte recursiva e
     * iterativa.
     */
    @Test
    public void testMapColor2() {
        System.out.println("mapColor2");
        int[][] map = {{1, 2, 3, 4}, {0, 2}, {1, 0, 3}, {0, 2}, {0}};
        //3 colores
        int nColors = 3;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = true;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
        //4 colores
        nColors = 2;
        expResult = false;
        result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
    }

    /**
     * Test 3 of mapColor method, of class BacktrackingImpl. Parte recursiva e
     * iterativa.
     */
    @Test
    public void testMapColor3() {
        System.out.println("mapColor3");
        int[][] map = {{2, 3}, {2, 3, 4}, {0, 1, 4}, {0, 1, 4}, {1, 2, 3}};
        //2 colores
        int nColors = 2;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
        //3 colores
        nColors = 3;
        expResult = true;
        result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
    }


    @Test
    public void testMapColor4() {
        System.out.println("mapColor3");
        int[][] map = {{3, 4,5}, {2, 5}, {1, 3}, {0, 2},{0}, {0,1}};
        //2 colores
        int nColors = 2;
        BacktrackingImpl instance = new BacktrackingImpl();
        boolean expResult = false;
        boolean result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
        //3 colores
        nColors = 3;
        expResult = true;
        result = instance.mapColor(map, nColors);
        assertEquals(expResult, result);
        result = instance.imapColor(map, nColors);
        assertEquals(expResult, result);
    }

}
