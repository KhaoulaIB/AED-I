/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package hanoi;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoni-KIB & ADRV
 */
public class HanoiImplTest {

    private Stack<Integer> a;
    private Stack<Integer> b;
    private Stack<Integer> c;
    private Stack<Integer> copyAInit;
    private int h;

    @Before
    public void setUp() {
        a = new Stack();
        b = new Stack();
        c = new Stack();
        h = 5;
        for (int i = h; i > 0; i--) {
            a.push(i);
        }
        copyAInit = (Stack<Integer>) a.clone();
    }

    /**
     * Test of recursiuHanoi method, of class HanoiImpl.
     * Pensau que passi aquest test, no vol dir que el Hanoi funcioni bé,
     * ja que bastaria que el mètode fes swap(a,c). 
     * Afegiu nous tests
     */
    @Test
    public void testRecursiuHanoi() {
        System.out.println("recursiuHanoi");
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi pHanoi = new HanoiImpl();
        pHanoi.recursiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

    /**
     * Test of iteratiuHanoi method, of class HanoiImpl.
     * Pensau que passi aquest test, no vol dir que el Hanoi funcioni bé,
     * ja que bastaria que el mètode fes swap(a,c). 
     * Afegiu nous tests
     */
    @Test
    public void testIteratiuHanoi() {
        System.out.println("iteratiuHanoi");
        assertEquals(true, a.equals(copyAInit));
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.isEmpty());
        Hanoi pHanoi = new HanoiImpl();
        pHanoi.iteratiuHanoi(h, a, b, c);
        assertEquals(true, a.isEmpty());
        assertEquals(true, b.isEmpty());
        assertEquals(true, c.equals(copyAInit));
    }

    /*
    Test to verify the base case
     */
    @Test
    public void Test2(){
        a = new Stack();
        b = new Stack();
        c = new Stack();
        h = 1;
       a.push(1);
       Hanoi hanoi = new HanoiImpl();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        hanoi.recursiuHanoi(h,a,b,c);
        System.setOut(originalOut);
        String expected = "a: []"+ System.lineSeparator()+ "b: []" + System.lineSeparator()+ "c: [1]"+System.lineSeparator()+System.lineSeparator() ;
       assertEquals(expected,outputStream.toString());
        a.push(1);
        c.pop();
        hanoi.iteratiuHanoi(h,a,b,c);
        System.setOut(originalOut);
        assertEquals(expected,outputStream.toString());


    }

    @Test
    public void Test3(){
        Stack<Integer> a2= new Stack<>();
        Stack<Integer> b2= new Stack<>();
        Stack<Integer> c2= new Stack<>();


       int h = 10;
        for (int i = h; i > 0; i--) {
            a2.push(i);
        }
        Stack <Integer> copyOfA= (Stack<Integer>) a2.clone();
        Hanoi hanoit = new HanoiImpl();
        hanoit.recursiuHanoi(h,a2,b2,c2);
        assertEquals(c2,copyOfA);


    }

}
