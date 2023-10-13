import java.util.Objects;

/**
 * Esta clase representa a un estudiante, que es una persona con un nombre, dirección, programa académico,
 * curso y cuota.
 * Extiende la clase Persona y hereda sus propiedades y métodos.
 */
public class Estudiant extends Persona {
    private String programa;
    private int curs;
    private int quota;

    /**
     * Crea una nueva instancia de Estudiant con el nombre, dirección, programa académico, curso y cuota especificados.
     *
     * @param nom      El nombre del estudiante.
     * @param adreca   La dirección del estudiante.
     * @param programa El programa académico del estudiante.
     * @param curs     El curso en el que está inscrito el estudiante.
     * @param quota    La cuota que paga el estudiante.
     */
    public Estudiant(String nom, String adreca, String programa, int curs, int quota) {
        super(nom, adreca);
        this.programa = programa;
        this.curs = curs;
        this.quota = quota;
    }

    /**
     * Obtiene el programa académico del estudiante.
     *
     * @return El programa académico del estudiante.
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Establece el programa académico del estudiante.
     *
     * @param programa El nuevo programa académico del estudiante.
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * Obtiene el curso en el que está inscrito el estudiante.
     *
     * @return El curso del estudiante.
     */
    public int getCurs() {
        return curs;
    }

    /**
     * Establece el curso en el que está inscrito el estudiante.
     *
     * @param curs El nuevo curso del estudiante.
     */
    public void setCurs(int curs) {
        this.curs = curs;
    }

    /**
     * Obtiene la cuota que paga el estudiante.
     *
     * @return La cuota del estudiante.
     */
    public int getQuota() {
        return quota;
    }

    /**
     * Establece la cuota que paga el estudiante.
     *
     * @param quota La nueva cuota del estudiante.
     */
    public void setQuota(int quota) {
        this.quota = quota;
    }

    /**
     * Compara este estudiante con otro objeto para verificar si son iguales.
     *
     * @param o El objeto con el que se compara.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiant estudiant)) return false;
        return curs == estudiant.curs && quota == estudiant.quota && Objects.equals(programa, estudiant.programa);
    }

    /**
     * Devuelve una representación en cadena de los atributos del estudiante.
     *
     * @return Representación en cadena de los atributos del estudiante.
     */
    @Override
    public String toString() {
        return "Estudiant{" +
                "Nom = " + getNom() +
                ", adreça = " + getAdreca() +
                ", programa = " + programa +
                ", curs = " + curs +
                ", quota = " + quota +
                '}';
    }
}
