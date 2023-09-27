public class Main {


    /*
    Volem crear un conjunt amb N (per exemple N = 10000) elements,
    ordenar-lo i cercar (si existeix) la posició d’un element determinat.

     */


    public void Start(){
        Conjunt conj = new Conjunt(1000);
        conj.GetConjunt();
        System.out.println( conj.cercaBinaria(999));


    }


    
    public static void main(String[] args) {
        new Main().Start();
    }
}