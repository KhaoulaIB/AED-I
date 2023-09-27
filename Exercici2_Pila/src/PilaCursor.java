/*
 *
 */
public class PilaCursor<E>{



    public static class TamanyInvalid extends Exception  {
        public TamanyInvalid (String o){
            super(o);
        }
    }

    public static class PilaPlena extends Exception {

        public PilaPlena(String e) {
            super(e);
        }
    }

    public static class PilaBuida extends Exception {

        public PilaBuida(String e) {
            super(e);
        }
    }
   private final int TAMANY ;
    private E[] pila ;
    private int punter ;


    public PilaCursor(int Tamany) throws TamanyInvalid {
        if (Tamany <=0){
            throw new TamanyInvalid("Tamany no valid!");
        }
        this.TAMANY = Tamany;
        pila = (E[]) new Object [TAMANY];
        punter = -1;
    }

    public void Push(E x) throws PilaPlena {
        if (punter == TAMANY - 1) {
            throw new PilaPlena("La pila está plena");
        }
            pila[++punter] = x;

    }

    public E Pop () throws  PilaBuida{
        if (punter == 0) {
            throw new PilaBuida("No hi ha elments per encuar");
        }

            return pila[punter--];

    }

    public E Top () throws PilaBuida{
         if (punter == 0){
             throw new PilaBuida("La pila está buida");
         }
        return pila[punter];
    }

    public void GetPila(){
        for (int i = 0; i<=punter; i++){
            System.out.println(pila[i]);
        }
    }

    public boolean EsPlena(){
        return punter == TAMANY-1;
    }

    public boolean EsBuida(){
        return punter==-1;
    }

}
