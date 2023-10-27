package exercici6_ultimversion;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;




public class BinarySearchTest {



        @Test
       public void Test1(){
            //caso de que value existe en a[]
            String [] a= { "Good","morning","and","in", "case","I", "don't", "see", "you", "good","bye", "good",
                    "afternoon", "good", "evening", "and", "good", "night" };
            Arrays.sort(a);
            int index = BinarySearch.cercaDicotomica(a,"good");
            assertEquals(index,10);
             index = BinarySearch.cercaDicotomica(a,"I");
            assertEquals(index,1);

            //caso de que value no existe en a[]
            index = BinarySearch.cercaDicotomica(a,"Error404");
            assertEquals(index,-1);

            index = BinarySearch.cercaDicotomica(a,"random");
            assertEquals(index,-1);

            //otro ejemplo de un array de enteros

            Integer [] arr = {9,-2,5,-3,2,0,3,19};
            Arrays.sort(arr);
            int i = BinarySearch.cercaDicotomica(arr,0);
            assertEquals(i,2);

            i = BinarySearch.cercaDicotomica(arr,19);
            assertEquals(i,arr.length-1);

        }
        @Test
        public void Test2(){
            // caso que a.length==0
            Double[] a =new Double[0];
            int index = BinarySearch.cercaDicotomica(a,0.92);
            boolean condition = (index==-1);
            assertTrue(condition);

            String [] elementos = new String[3];
            index = BinarySearch.cercaDicotomica(elementos,"alpha");
            assertEquals(-1, index);

        }


}