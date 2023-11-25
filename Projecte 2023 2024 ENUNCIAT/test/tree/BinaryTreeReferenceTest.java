/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 *
 * @author antoni-KIB
 */
public class BinaryTreeReferenceTest {
    private BinaryTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinaryTreeReference();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(80);
    }

    /**
     * Test of isEmpty method, of class BinaryTreeReference.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinaryTree<Integer> instance = new BinaryTreeReference();
        assertEquals(true, instance.isEmpty());
        assertEquals(false, tree.isEmpty());
    }

    /**
     * Test of insert method, of class BinaryTreeReference.
     */
    @Test
    public void testInsertContains() {
        System.out.println("insertContains");
        assertEquals(false,tree.contains(25));
        tree.insert(25);
        assertEquals(true,tree.contains(25));
    }

    /**
     * Test of longestBranch and Insert method, of class BinaryTreeReference.
     */
    @Test
    public void testLongestBranchInsert() {
        System.out.println("longestBranchInsert");
        assertEquals(3, tree.longestBranch());
        tree.insert(25);
        assertEquals(3, tree.longestBranch());
        tree.insert(5);
        assertEquals(4, tree.longestBranch());
        tree.insert(81);
        tree.insert(82);
        tree.insert(83);
        assertEquals(5, tree.longestBranch());
    }

    /**
     * Test of getMother method, of class BinaryTreeReference.
     */
    @Test
    public void testGetMother() {
        System.out.println("getMother");
        assertEquals(null, tree.getMother(50));
        int i = tree.getMother(30);
        assertEquals(50, i);
        i = tree.getMother(70);
        assertEquals(50,i); 
        i = tree.getMother(10);
        assertEquals(20, i);
        assertEquals(null, tree.getMother(15));
        assertEquals(null, tree.getMother(tree.getRoot()));
    }

    /**
     * Test of getRoot method, of class BinaryTreeReference.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        int i = tree.getRoot();
        assertEquals(50, i);
    }

    /*
    Test of contains(), getMother(),insert(),getRoot(),isEmpty() methods
     */
    @Test
    public void Test2(){
        BinaryTreeReference<Integer> arbol=new BinaryTreeReference<>();

        arbol.insert(1);
        arbol.insert(6);
        arbol.insert(3);
        arbol.insert(65);
        arbol.insert(4);
        arbol.insert(0);
        assertTrue(arbol.contains(0));
        assertFalse(arbol.contains(12));
        Integer expected = 1;
        assertNull(arbol.getMother(1));

        assertEquals(expected,arbol.getRoot());
        assertEquals(expected,arbol.getMother(6));
        assertEquals(expected,arbol.getMother(0));
        expected = 3;
        assertEquals(expected,arbol.getMother(4));
        assertEquals(3,arbol.longestBranch());
        assertFalse(arbol.isEmpty());

    }

    /*
   Test of contains(), getMother(),insert(),getRoot(),isEmpty() methods
    */
    @Test
    public void Test3(){
        BinaryTreeReference<Integer> arbol=new BinaryTreeReference<>();
        assertTrue(arbol.isEmpty());
        arbol.insert(100);
        arbol.insert(56);
        arbol.insert(72);
        assertEquals(2,arbol.longestBranch());
        arbol.insert(9);
        arbol.insert(2);
        assertEquals(3,arbol.longestBranch());

        arbol.insert(0);
        assertFalse(arbol.contains(99));
        assertTrue(arbol.contains(100));

        assertEquals(4,arbol.longestBranch());
        assertEquals(Integer.valueOf(56),arbol.getMother(72));

        assertEquals(Integer.valueOf(2),arbol.getMother(0));
        assertNull(arbol.getMother(100));
        assertEquals(Integer.valueOf(100),arbol.getRoot());
        assertFalse(arbol.isEmpty());
    }
}
