import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.*;

public class LListaCursorTest {

    @Test
    public void Test1LIstacursor() throws LListaCursor.ListaCompleta {

        LListaCursor<String> listaCursor = new LListaCursor<>(6);
        listaCursor.add("Dora!");
        listaCursor.add("soy");
        listaCursor.add("Hola");

        assertFalse(listaCursor.isEmpty());


        // Redirige la salida estándar a un PrintStream temporal
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Llama al método que imprime la lista
        listaCursor.printlist();

        // Restaura la salida estándar original
        System.setOut(originalOut);

        // Compara la salida generada con la salida esperada
        String expectedOutput = "Dora!"+ System.lineSeparator() +"Hola"+ System.lineSeparator() +"soy"+ System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        assertTrue(listaCursor.contains("soy"));

        listaCursor.remove("soy");
        assertFalse(listaCursor.contains("soy"));
        listaCursor.clear();
        assertTrue(listaCursor.isEmpty());



    }

    @Test
    public void Test2LIstacursor() throws LListaCursor.ListaCompleta {



        LListaCursor <Integer> list3 = new LListaCursor<Integer>(10);
        list3.add(-3);
        list3.add(5);
        list3.add(5);
        list3.add(0);
        assertTrue(list3.contains(5));
        assertFalse(list3.isEmpty());
        list3.remove(5);
        assertTrue(list3.contains(5));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Llama al método que imprime la lista
        list3.printlist();

        // Restaura la salida estándar original
        System.setOut(originalOut);

        // Compara la salida generada con la salida esperada
        String expectedOutput = "-3"+ System.lineSeparator() +"0"+ System.lineSeparator() +"5"+ System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());


    }


}