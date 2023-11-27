/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package matriu;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author antoni-KIB & ARV
 */
public class MatriuImplTest {
    private MatriuImpl<Integer> m1;
    private MatriuImpl<Integer> m2;
    private MatriuImpl<Integer> m3;
    private MatriuImpl<String> m4;
    private MatriuImpl<Double> m5;
    private MatriuImpl <Character> m6;

    @Before
    public void setUp() throws Exception {
        Integer matriu1[] = {0,1,2,1,1,2,2,2,3};
        Integer matriu2[] = {0,1,2,3,1,2,2,2,3};
        Integer matriu3[] = {0,1,2,1,1,2};
        String matriu4[]={"never","gonna","give","gonna","you","up","give","up","!"};
        Double matriu5[]={1.1};
        Character matriu6[] = {'A','B','C','D','B','E','K','H','C','K','F','L','D','H','L','G'};
        m1 = new MatriuImpl<>(matriu1,3,3);
        m2 = new MatriuImpl<>(matriu2,3,3);
        m3 = new MatriuImpl<>(matriu3,2,3);
        m4 = new MatriuImpl<>(matriu4,3,3);
        m5 = new MatriuImpl<>(matriu5,1,1);
        m6 = new MatriuImpl<>(matriu6,4,4);
    }

    
    /**
     * Test of isSymmetricalRecursiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalRecursiu() {
        System.out.println("isSymmetricalRecursiu");
        assertEquals(true, m1.isSymmetricalRecursiu());
        assertEquals(false, m2.isSymmetricalRecursiu());
        assertEquals(false, m3.isSymmetricalRecursiu());
        assertTrue(m4.isSymmetricalRecursiu());
        assertTrue(m5.isSymmetricalRecursiu());
        assertTrue(m6.isSymmetricalRecursiu());
    }

    /**
     * Test of isSymmetricalIteratiu method, of class MatriuImpl.
     */
    @Test
    public void testIsSymmetricalIteratiu() {
        System.out.println("isSymmetricalIteratiu");
        assertEquals(true, m1.isSymmetricalIteratiu());
        assertEquals(false, m2.isSymmetricalIteratiu());
        assertEquals(false, m3.isSymmetricalIteratiu());
        assertTrue(m4.isSymmetricalIteratiu());
        assertTrue(m5.isSymmetricalIteratiu());
        assertTrue(m6.isSymmetricalIteratiu());
    }   
}
