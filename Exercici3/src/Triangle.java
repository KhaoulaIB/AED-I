public class Triangle implements  Figura{

    /*
        Aquesta classe només representa triangles equilaters. ja que a l'hora
        de la seva generació en el Main es pot evitar facilment  arees negatives causades
        per mesures invalides dels costats del triangle
     */
    Double a;

    public Triangle(Double a ){
        this.a=a;

    }

    @Override
    public double area() {

       return (this.a * this.a * Math.sqrt(3)) / 4;
    }

    @Override
    public double perimetre() {
        return a*3;
    }
}
