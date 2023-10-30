import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LlistaReferenciaTest {

    @Test
    public  void Test1listaRef(){
        LlistaReferencia<Integer> listaRef = new LlistaReferencia<>();
        listaRef.add(-1);
        listaRef.add(-2);
        listaRef.add(5);
        listaRef.add(18);


        listaRef.remove(6);
        assertFalse(listaRef.contains(6));
        // System.out.println();
        assertFalse(listaRef.isEmpty());
        listaRef.clear();
        listaRef.add(0);
        listaRef.remove(0);
        assertFalse(listaRef.contains(0));
        //listaRef.printlist();

    }

    @Test
    public  void Test2listaRef() throws LListaCursor.ListaCompleta {
        LListaCursor <Integer> list3 = new LListaCursor<Integer>(10);
        list3.add(-43);
        list3.add(100);
        list3.add(178);
        list3.add(-24);
        list3.add(0);
        assertFalse(list3.contains(5));
        assertFalse(list3.isEmpty());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Llama al método que imprime la lista
        list3.printlist();

        // Restaura la salida estándar original
        System.setOut(originalOut);

        // Compara la salida generada con la salida esperada
        String expectedOutput = "-43"+ System.lineSeparator() +"-24"+ System.lineSeparator() +"0"+ System.lineSeparator() + "100"+ System.lineSeparator() + "178"+ System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

    }

}