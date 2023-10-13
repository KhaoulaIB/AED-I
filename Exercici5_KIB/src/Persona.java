import java.util.Objects;

/**
 * Esta clase representa una persona con un nombre y una dirección.
 * Implementa la interfaz Comparable para permitir la comparación de objetos Persona.
 */
public class Persona implements Comparable<Persona> {
    private String nom;
    private String adreca;

    /**
     * Crea una nueva instancia de Persona con el nombre y la dirección especificados.
     *
     * @param nom    El nombre de la persona.
     * @param adreca La dirección de la persona.
     */
    public Persona(String nom, String adreca) {
        this.nom = nom;
        this.adreca = adreca;
    }

    /**
     * Compara esta persona con otra basándose en sus nombres en orden descendente.
     *
     * @param o La otra persona con la que comparar.
     * @return Un valor negativo si esta persona es menor que la otra, un valor positivo si es mayor y 0 si son iguales.
     */
    @Override
    public int compareTo(Persona o) {
        return o.getNom().compareTo(this.getNom());
    }

    /**
     * Comprueba si esta persona es igual a otro objeto.
     *
     * @param o El objeto con el que se compara.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(nom, persona.nom) && Objects.equals(adreca, persona.adreca);
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nom El nuevo nombre de la persona.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtiene la dirección de la persona.
     *
     * @return La dirección de la persona.
     */
    public String getAdreca() {
        return adreca;
    }

    /**
     * Establece la dirección de la persona.
     *
     * @param adreca La nueva dirección de la persona.
     */
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /**
     * Devuelve una representación en cadena de la persona en el formato "Persona{nom='nombre', adreca='dirección'}".
     *
     * @return Representación en cadena de la persona.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nom='" + nom + '\'' +
                ", adreca='" + adreca + '\'' +
                '}';
    }
}
