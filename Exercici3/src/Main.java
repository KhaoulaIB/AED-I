import java.util.*;

/**
 * Classe principal que realitza diverses operacions amb figures geomètriques.
 */
public class Main {

    /**
     * Métode principal del programa.
     *
     */
    public static void main(String[] args) {

        final int TAMANY = 10000;
        // Genera una llista de figures amb un tamany constant
        List<Figura> figures = GenerFig(TAMANY);
        // Classes de figures que volem analitzar
        Class<?>[] classes = new Class<?>[] { Cercle.class, Triangle.class, Quadrat.class, Rectangle.class };
        // Llistes per emmagatzemar les àrees i perímetres de les figures
        List <Double> arres = new ArrayList<>();
        List <Double> perimeters = new ArrayList<>();

        // Calcula la suma de les àrees i perímetres de totes les figures
        Suma (figures, arres, perimeters);
        // Calcula la suma de les àrees i perímetres per cada classe de figura
        areesiperims(figures, classes);
        // Troba les àrees màxima i mínima de totes les figures
        MaxMinArees(arres, "figures");
        // Troba les àrees màxima i mínima per cada classe de figura
        MaxMinFigura(figures, classes);
        // Troba i mostra les 10 primeres figures ordenades per àrea i perímetre
        PrimerDeu(arres, perimeters);

    }

    /**
     * Calcula la suma global d'àrees i perímetres i emmagatzema les àrees i perímetres en dues llistes.
     *
     * @param llista La llista de figures a analitzar.
     * @param Arees La llista d'àrees a emmagatzemar.
     * @param Perimetres La llista de perímetres a emmagatzemar.
     */
    public static void Suma(List<Figura> llista, List<Double> Arees, List<Double> Perimetres){
        double SumArea = 0;
        double SumPerms = 0;
        for (Figura figura : llista) {
            SumArea += figura.area();
            Arees.add(figura.area());
            SumPerms += figura.perimetre();
            Perimetres.add(figura.perimetre());
        }
        System.out.println("\nLa suma global de les àrees és : "+ SumArea);
        System.out.println("\nLa suma global dels perímetres és : "+ SumPerms);
    }

    /**
     * Calcula la suma d'àrees i perímetres per cada classe de figura.
     *
     * @param llista La llista de figures a analitzar.
     * @param classes Les classes de figures per les quals cal calcular la suma.
     */
    public static void areesiperims(List<Figura> llista, Class<?>[] classes ){
        for (Class<?> classe : classes) {
            SumaperFig(llista, classe);
        }
    }

    /**
     * Calcula la suma d'àrees i perímetres per una classe de figura especificada.
     *
     * @param llista La llista de figures a analitzar.
     * @param tmp La classe de figura per la qual cal calcular la suma.
     */
    public static void SumaperFig (List<Figura> llista, Class<?> tmp){
        double Area = 0;
        double perimeter = 0;
        for (Figura figura : llista) {
            if (tmp.isInstance(figura)) {
                Area += figura.area();
                perimeter += figura.perimetre();
            }
        }

        System.out.println("\nLa suma de les àrees de "+ tmp.getName()+ " és : "+ Area  );
        System.out.println("La suma dels perímetres de "+ tmp.getName()+ " és : "+ perimeter  );
    }

    /**
     * Troba l'àrea màxima i mínima de totes les figures.
     *
     * @param Ars La llista d'àrees a analitzar.
     * @param clase El nom de la classe de figures.
     */
    public static void MaxMinArees(List<Double> Ars, String clase){
        System.out.println("\nL'àrea màxima de "+ clase+" és: "+ Collections.max(Ars));
        System.out.println("L'àrea mínima de "+ clase+ " és: "+ Collections.min(Ars));
    }

    /**
     * Troba l'àrea màxima i mínima per cada classe de figura.
     *
     * @param llista La llista de figures a analitzar.
     * @param classes Les classes de figures per les quals cal trobar l'àrea màxima i mínima.
     */
    public static void MaxMinFigura(List<Figura> llista,  Class<?>[] classes ){
        for (Class<?> classe : classes) {
            MaxMinArees(AreaFigura(llista,classe), classe.getName());
        }
    }

    /**
     * Obté una llista d'àrees per una classe de figura especificada.
     *
     * @param llista La llista de figures a analitzar.
     * @param tmp La classe de figura per la qual cal obtenir les àrees.
     * @return Una llista d'àrees per la classe de figura especificada.
     */
    public static List<Double> AreaFigura(List<Figura> llista, Class<?> tmp){
        List<Double> sol = new ArrayList<>();
        for (Figura figura : llista) {
            if (tmp.isInstance(figura)) {
                sol.add(figura.area());
            }
        }
        return sol;
    }

    /**
     * Troba i mostra les 10 primeres figures ordenades per àrea i perímetre.
     *
     * @param lista La llista d'àrees de les figures.
     * @param pers La llista de perímetres de les figures.
     */
    public static void PrimerDeu ( List<Double> lista, List<Double> pers ){
        Collections.sort(lista);
        Collections.sort(pers);

        System.out.println("\nLes 10 primeres figures ordenades ascendentment per àrea són : " );
        for (int i =0; i<10; i++){
            System.out.println(lista.get(i));
        }

        System.out.println("\nLes 10 primeres figures ordenades ascendentment per perímetre són: " );
        for (int i =0; i<10; i++){
            System.out.println(pers.get(i));
        }
    }

    /**
     * Genera una llista de figures aleatòries amb una longitud especificada.
     *
     * @param T La longitud de la llista de figures.
     * @return Una llista de figures aleatòries.
     */
    public static List <Figura> GenerFig(int T){
        List<Figura> figueres = new ArrayList<>(T);
        Random rn = new Random();
        int index =0;
        while (index <T) {
            int fig = rn.nextInt(4);

            switch (fig) {
                case 0 -> figueres.add(new Triangle(rn.nextDouble() * 124.0));
                case 1 -> figueres.add(new Quadrat(rn.nextDouble()* 7060.6));
                case 2 -> figueres.add(new Cercle(rn.nextDouble() * 2190.78));
                case 3 -> figueres.add(new Rectangle(rn.nextDouble() * 8047.8, rn.nextDouble() * 5305.4));
            }
            index++;
        }
        return figueres;
    }
}
