import java.util.Objects;

/**
 * Esta clase representa a un profesor, que es una persona con un nombre, dirección, área de enseñanza y salario.
 * Extiende la clase Persona y hereda sus propiedades y métodos.
 */
public class Professor extends Persona {
    private String area;
    private int sou;

    /**
     * Crea una nueva instancia de Professor con el nombre, dirección, área de enseñanza y salario especificados.
     *
     * @param nom   El nombre del profesor.
     * @param adreca La dirección del profesor.
     * @param area  El área de enseñanza del profesor.
     * @param sou   El salario del profesor.
     */
    public Professor(String nom, String adreca, String area, int sou) {
        super(nom, adreca);
        this.area = area;
        this.sou = sou;
    }

    /**
     * Obtiene el área de enseñanza del profesor.
     *
     * @return El área de enseñanza del profesor.
     */
    public String getArea() {
        return area;
    }

    /**
     * Establece el área de enseñanza del profesor.
     *
     * @param area El nuevo área de enseñanza del profesor.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Obtiene el salario del profesor.
     *
     * @return El salario del profesor.
     */
    public int getSou() {
        return sou;
    }

    /**
     * Establece el salario del profesor.
     *
     * @param sou El nuevo salario del profesor.
     */
    public void setSou(int sou) {
        this.sou = sou;
    }

    /**
     * Compara este profesor con otro objeto para verificar si son iguales.
     *
     * @param o El objeto con el que se compara.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor professor)) return false;
        return sou == professor.sou && Objects.equals(area, professor.area);
    }

    /**
     * Devuelve una representación en cadena de los atributos del profesor.
     *
     * @return Representación en cadena de los atributos del profesor.
     */
    @Override
    public String toString() {
        return "Professor{" +
                "Nom = " + getNom() +
                ", adreça = " + getAdreca() +
                ", area = " + area +
                ", sou = " + sou +
                "}";
    }
}
