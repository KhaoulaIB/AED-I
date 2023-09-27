public class Rectangle implements Figura{

    Double a, b;

    public Rectangle(Double a, Double b){
        this.a= a;
        this.b=b;
    }

    @Override
    public double area() {

        return a*b;
    }

    @Override
    public double perimetre() {
        return 2*(a+b);
    }


}
