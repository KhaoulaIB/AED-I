import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Conjunt {

    private int N;

    private final ArrayList<Integer> conjunto = new ArrayList<>(N);


    public Conjunt(int N) {
        this.N = N;
        GenerarElements();
        Collections.sort(conjunto);
    }

    public void GetConjunt() {
        for (int element = 0; element < N; element++) {
            System.out.println(conjunto.get(element));

        }
    }

    public void GenerarElements() {
        Random r = new Random();

        int index = 0;
        while (index < N) {
            int temp = r.nextInt(N);
            temp -= r.nextInt((int) Math.log(N));
            conjunto.add(temp);
            index++;
        }
    }


    int cercaBinaria(int x) {
        int result = Collections.binarySearch(conjunto, x);
        return result <0? -1:result;
    }
}
