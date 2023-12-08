/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author antoni
 */
public class BacktrackingImplTest {
    
//        /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        int M = 5;
//        int a[] = {1, 3, 1, 5, 2};
//        //int a[] = {1, 5, 2};
//
//        //sumM(a, M);
//    }

    /**
     * Test of sumM method, of class BacktrackingImpl.
     */
    @Test
    public void testSumM() {
        System.out.println("sumM");
        int M = 5;
        int a[] = {1, 3, 1, 5, 2};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();
        
        ArrayList<Integer> s = new ArrayList<>();
        s.add(5);
        expResult.add(s);
        
        s = new ArrayList<>();
        s.add(3);s.add(2);
        expResult.add(s);
        
        s = new ArrayList<>();
        s.add(1);s.add(3);s.add(1);
        expResult.add(s);

        BacktrackingImpl instance = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instance.sumM(a, M);
        assertEquals(expResult, result);

    }

    @Test
    public void Test2(){
        int M = 1;
        int[] a = {10,7,2,0,9,1};
        ArrayList<ArrayList<Integer>> expResult = new ArrayList<>();

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        expResult.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(1);
        expResult.add(tmp);

        BacktrackingImpl instancia = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> result = instancia.sumM(a, M);
        assertEquals(expResult,result);

    }

    /* tests of empty sets of a*/
    @Test
    public void test3(){
        int a[]=new int[0];
        int M = 12;
        assertTrue(new BacktrackingImpl().sumM(a, M).isEmpty());

    }
    @Test
    public void Test4(){

        int M = 21;
        int[]a = {7,7,7,18,3,2};
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(7);
        tmp.add(7);
        tmp.add(7);
        sol.add(tmp);
        tmp=new ArrayList<>();
        tmp.add(18);
        tmp.add(3);
        sol.add(tmp);
         BacktrackingImpl s = new BacktrackingImpl();
        ArrayList<ArrayList<Integer>> sol2 = s.sumM(a,M);
        //oredenamos los subconjutos
        for (ArrayList<Integer> subset : sol) {
            Collections.sort(subset);
        }

        for (ArrayList<Integer> subset : sol2) {
            Collections.sort(subset);
        }
        assertTrue( sol.containsAll(sol2) && sol2.containsAll(sol));

    }

}
