public class PilaPunter<E>  {


    /* Classe Node
        Cada element de la pila és un node:
        un element "e" i un punter que apunta al element previ.
     */
    public class Node {

       E e;
        Node next;

        public Node (E e, Node next){
            this.e = e;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    Node top;
    private int s;
    private int punter;



    public PilaPunter(int size) throws PilaCursor.TamanyInvalid {
        if (size <=0){
            throw new PilaCursor.TamanyInvalid("Tamany no valid!");
        }
        this.s = size;
        punter = -1;
        top = null;
    }

    public void Push (E element) throws PilaCursor.PilaPlena {
        if (punter== s-1){
            throw  new PilaCursor.PilaPlena("La pila és plena");
        }
        Node aux = new Node(element,top);
        top = aux;

        punter++;

    }

    public E Pop () throws PilaCursor.PilaBuida{
        if (punter == -1){
            throw new PilaCursor.PilaBuida("La pila és buida");
        }
        E elemento = top.getE();
        top = top.getNext();
        punter--;
        return elemento;

    }

    public E top ()throws PilaCursor.PilaBuida{
        if (punter == -1){
            throw new PilaCursor.PilaBuida("La pila és buida");
        }
        return top.getE();
    }

    public boolean esPlena(){
        return punter == s-1;
    }

    public void GetPila() {
        Node current = top;
        System.out.print("Pila: ");
        while (current != null) {
            System.out.print(current.getE() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


    public boolean esBuida(){
       return punter == -1;
    }




}
