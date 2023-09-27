public class Quadrat implements  Figura{

    Double costat;

    public Quadrat(Double costat){
        this.costat=costat;
    }

    @Override
    public double area() {
        return costat*costat;
    }

    @Override
    public double perimetre() {
        return 2*(costat*2);
    }
}
