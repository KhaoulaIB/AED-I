import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * Esta clase genera, ordena y muestra listas de personas, estudiantes y profesores.
 * @author Khaoula
 */
public class Exercici5 {
    public static final int TAMANY = 1000000;
    public static final int NOMBRE = 10;

    /**
     * Enumeración de nombres aleatorios.
     */
    public enum Noms {
        SARA, LAURA, LAUREN, ISABEL, MIGUEL, LUCIA, PAULA, MARTA, SERGIO, JOSE, ANDRES, ALEJANDRO, YUE
    }

    /**
     * Enumeración de direcciones aleatorias.
     */
    public enum Adreces {
        SANT_LLORENC, SINEU, INCA, MARRATXI, MAGALUF, MANACOR, CAMPOS, VILAFRANCA, VALLDEMOSA, FORNALUTX, MONTUIR, BENISALEM
    }

    /**
     * Enumeración de áreas académicas aleatorias.
     */
    public enum Area {
        MATEMATICAS, FISICA, INFORMATICA, BIOLOGIA, QUIMICA, ECONOMIA, HISTORIA, INGENIERIA_CIVIL, PSICOLOGIA, ARQUITECTURA, LENGUA_Y_LITERATURA, MUSICA
    }

    public static void main(String[] args) {
        ArrayList<Persona> persones = GenerarPersonas();
       // MostrarPersonas(persones);
        System.out.println("\n Las 10 primeras personas ordenadas por nombre en orden descendente son:");
        OrdenarPersonas(persones);

        ArrayList<Estudiant> estudiants = ObtenerEstudiants(persones);
        ArrayList<Professor> professors = ObtenerProfessors(persones);

        System.out.println("\n Los 10 primeros estudiantes ordenados por nombre en orden descendente son:");
        OrdenarPersonas(estudiants);

        System.out.println("\n Los 10 primeros profesores ordenados por nombre en orden descendente son:");
        OrdenarPersonas(professors);

        System.out.println("\n Los 10 primeros estudiantes ordenados por programa en orden descendente son:");
        OrdenarPorCampo(estudiants, Comparator.comparing(Estudiant::getPrograma));

        System.out.println("\n Los 10 primeros profesores ordenados por área en orden descendente son:");
        OrdenarPorCampo(professors, Comparator.comparing(Professor::getArea));
    }

    /**
     * Genera una lista de personas con datos aleatorios.
     *
     * @return Una lista de personas generada aleatoriamente.
     */
    private static ArrayList<Persona> GenerarPersonas() {
        ArrayList<Persona> persones = new ArrayList<>(TAMANY);
        Random rn = new Random();

        for (int i = 0; i < TAMANY; i++) {
            Noms nom = Noms.values()[rn.nextInt(Noms.values().length)];
            Adreces adreca = Adreces.values()[rn.nextInt(Adreces.values().length)];

            if (rn.nextBoolean()) {
                Area a = Area.values()[rn.nextInt(Area.values().length)];
                int sou = rn.nextInt(1000, 3000);
                persones.add(new Professor(nom.toString(), adreca.toString(), a.toString(), sou));
            } else {
                int curs = rn.nextInt(1, 5);
                int quota = rn.nextInt(800, 1500);
                persones.add(new Estudiant(nom.toString(), adreca.toString(), Area.values()[i % Area.values().length].toString(), curs, quota));
            }
        }

        return persones;
    }

    /**
     * Ordena una lista de personas en orden descendente por nombre.
     *
     * @param persones Lista de personas a ordenar.
     * @param <T>      Tipo de persona.
     */
    public static <T extends Persona> void OrdenarPersonas(ArrayList<T> persones) {
        // El método toma como argumento una lista de personas (persones) y la ordena en orden descendente
        // según el atributo "nombre" de cada persona. Se utiliza una expresión lambda para comparar los nombres.
        persones.sort((o1, o2) -> o2.getNom().compareTo(o1.getNom()));
        // Se muestran solo las 10 primeras personas en orden descendiente
        for (int i = 0; i < NOMBRE; i++) {
            System.out.println(persones.get(i));
        }
    }

    /**
     * Muestra una lista de elementos en la consola.
     *
     * @param elementos La lista de elementos a mostrar.
     * @param <T>       El tipo de elementos en la lista.
     */
    private static <T> void MostrarPersonas(ArrayList<T> elementos) {
        elementos.forEach(System.out::println);

    }

    /**
     * Ordena una lista de elementos por un campo específico en orden descendente.
     *
     * @param elements         La lista de elementos a ordenar.
     * @param campoComparator  El comparador que define cómo ordenar los elementos por campo.
     * @param <T>              El tipo de elementos en la lista.
     */
    private static <T> void OrdenarPorCampo(ArrayList<T> elements, Comparator<T> campoComparator) {
        // Este método ordena de forma descnediente los elementos (que pueden ser profesores o estudiantes) utilizando el comparador de campo
        // proporcionado como parámetro. Esto permite ordenar estudiantes por programa y profesores por área.
        elements.sort(campoComparator.reversed());
        // A continuación, se muestran las NOMBRE primeras personas ordenadas en la consola.
        // Se muestra una sublista de 10 elementos del ArrayList ya ordenado.
        MostrarPersonas(new ArrayList<>(elements.subList(0, NOMBRE)));
    }

    /**
     * Obtiene una lista de estudiantes a partir de una lista de personas dada.
     *
     * @param persones La lista de personas de la que se deben obtener los estudiantes.
     * @return Una lista que contiene únicamente objetos de tipo Estudiant extraídos de la lista de personas.
     */

    private static ArrayList<Estudiant> ObtenerEstudiants(ArrayList<Persona> persones) {
        return FiltrarPorClase(persones, Estudiant.class);
    }

    /**
     * Obtiene una lista de profesores a partir de una lista de personas dada.
     *
     * @param persones La lista de personas de la que se deben obtener los profesores.
     * @return Una lista que contiene únicamente objetos de tipo Professor extraídos de la lista de personas.
     */
    private static ArrayList<Professor> ObtenerProfessors(ArrayList<Persona> persones) {
        return FiltrarPorClase(persones, Professor.class);
    }

    /**
     * Filtra una lista de personas por una clase específica.
     *
     * @param persones La lista de personas a filtrar.
     * @param clase    La clase por la que se debe filtrar la lista.
     * @param <T>      El tipo de clase por la que filtrar.
     * @return Una lista filtrada que contiene solo elementos de la clase especificada.
     */
    private static <T extends Persona> ArrayList<T> FiltrarPorClase(ArrayList<Persona> persones, Class<T> clase) {
        ArrayList<T> resultado = new ArrayList<>();
        // El método recorre la lista de personas (persones) y verifica si cada persona es una instancia de la clase especificada.
        // Si es así, se agrega a la lista resultado utilizando el método cast para convertirlo al tipo T.
        for (Persona p : persones) {
            if (clase.isInstance(p)) {
                resultado.add(clase.cast(p));
            }
        }

        return resultado;
    }
}
