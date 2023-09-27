public class Main {

    /*
      - Exercici2: Fer una implementació d'una pila genèrica
         utilitzant punters i d'una pila genèrica utilitzant cursors.
      - Data: 18/09/23
      - Author: khaoula ikkene
     */

    public static void main(String[] args)  {

        try {
            PilaCursor<String> pila2 = new PilaCursor<>(9);
            pila2.Push("Nous");
            pila2.Push("sommes");
            pila2.Push("vendredi");
            System.out.println(pila2.Top());
            System.out.println(pila2.EsBuida());
            pila2.GetPila();
            System.out.println();


        } catch (PilaCursor.TamanyInvalid | PilaCursor.PilaPlena | PilaCursor.PilaBuida e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------------");
        try{
            PilaPunter<Integer> pcursor = new PilaPunter<>(1);
            pcursor.Push(2954);
            System.out.println( pcursor.top());
            System.out.println((pcursor).Pop());
            PilaPunter <String> pila2 = new PilaPunter<>(6);
            pila2.Push("");
            System.out.println(pcursor.esBuida());


        } catch (PilaCursor.TamanyInvalid | PilaCursor.PilaPlena e) {
            System.out.println(e.getMessage());

        } catch (PilaCursor.PilaBuida e) {
            throw new RuntimeException(e);
        }
    }
}