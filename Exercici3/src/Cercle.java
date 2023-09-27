public class Cercle implements  Figura{

    Double radi;


    public Cercle (Double radi){
        this.radi=radi;
    }

    @Override
    public double area() {
        return Math.PI*this.radi*this.radi;
        }

    @Override
    public double perimetre() {
        return 2*Math.PI*this.radi;
    }
}
