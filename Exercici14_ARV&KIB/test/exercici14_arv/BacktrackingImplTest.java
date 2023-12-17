/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package exercici14_arv;

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
     * Test of knapSack method, of class BacktrackingImpl.
     */
    @Test
    public void testKnapSack() {
        System.out.println("knapSack");
        int W = 3;
        int w[] = {2, 3, 2, 1};
        int p[] = {3, 3, 1, 10};
        int[] expResult = {1, 0, 0, 1};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of knapSack method with null array, of class BacktrackingImpl.
     */
    @Test
    public void testKnapSackNull() {
        System.out.println("knapSackNull");
        int W = 5;
        int w[] = {};
        int p[] = {};
        int[] expResult = null;
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        int [] result2 = instance.iterativeKnapSack(W,w,p);

        assertArrayEquals(expResult, result);
        assertArrayEquals(expResult, result2);

    }

    /**
     * Test of knapSack method with not equal lenght array, of class
     * BacktrackingImpl.
     */
    @Test
    public void tesKnapSackNotEqualLength() {
        System.out.println("knapSackNotEqualLength");
        int W = 5;
        int w[] = {3, 4, 5, 6};
        int p[] = {3, 2};
        int[] expResult = null;
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        int [] result2 = instance.iterativeKnapSack(W,w,p);

        assertArrayEquals(expResult, result);
        assertArrayEquals(expResult, result2);

    }

    /**
     * Test of knapSack 4, of class BacktrackingImpl.
     */
    @Test
    public void tesKnapSack4() {
        System.out.println("knapSack4");
        int W = 6;
        int w[] = {3,5,0,3,2};
        int p[] = {10,2,3,5,7};
        int[] expResult = {1,0,1,0,1};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        int [] result2 = instance.iterativeKnapSack(W,w,p);
        assertArrayEquals(expResult, result);
        assertArrayEquals(expResult, result2);

    }

    
    /**
     * Test of knapSack 5, of class BacktrackingImpl.
     */
    @Test
    public void tesKnapSack5() {
        System.out.println("knapSack5");
        int W = 5;
        int w[] = {3,4,2,1,3,2};
        int p[] = {2,4,3,6,8,1};
        int[] expResult = {0,0,0,1,1,0};
        BacktrackingImpl instance = new BacktrackingImpl();
        int[] result = instance.knapSack(W, w, p);
        int [] result2 = instance.iterativeKnapSack(W,w,p);

        assertArrayEquals(expResult, result);
        assertArrayEquals(expResult, result2);

    }

}
