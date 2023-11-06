import java.util.Locale;
/**
 * Clase para realizar operaciones de matrices numéricas.
 *
 * @param <E> Tipo genérico que extiende de Number para los elementos de la matriz.
 * @author KIB
 */
public class Matrix<E extends Number> {

    Number[][] matrix;

    private int rows;


    private int columns;

    /**
     * Excepción personalizada para matrices no compatibles.
     */
    public static class NonCompatible extends Exception {
        public NonCompatible(String input) {
            super(input);
        }
    }

    /**
     * Obtiene un elemento en una posición específica de la matriz.
     *
     * @param x Índice de fila.
     * @param y Índice de columna.
     * @return El elemento en la posición (x, y).
     */
    public Number GetElement(int x, int y) {
        return matrix[x][y];
    }

    /**
     * Establece un elemento en una posición específica de la matriz.
     *
     * @param x      Índice de fila.
     * @param y      Índice de columna.
     * @param element Elemento a establecer en la posición (x, y).
     */
    public void SetElement(int x, int y, E element) {
        this.matrix[x][y] = element;
    }
    /**
     * Constructor de la clase que crea una matriz con el número de filas y columnas especificado.
     *
     * @param rows    Número de filas en la matriz.
     * @param columns Número de columnas en la matriz.
     */
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Number[this.rows][this.columns];
    }
/**
 * Constructor de la clase que crea una matriz a partir de una matriz 2D existente.
 *
 * @param matrix Matriz 2D con los elementos iniciales.
 */

    public Matrix(Number[][] matrix){

        this.matrix=matrix;
        this.rows=matrix.length;
        this.columns=matrix[0].length;
    }

    /**
     * Realiza la multiplicación de dos matrices y devuelve el resultado.
     *
     * @param m1 Primera matriz.
     * @param m2 Segunda matriz.
     * @return La matriz resultante de la multiplicación de m1 y m2.
     * @throws NonCompatible Si las matrices no son compatibles para la multiplicación.
     * Odren de complejidad:O(n^3) siendo n el numero de los elementos que procesa en un bucle for.
     * En terminos especificos O(m1.rows*m2.columns*m1.columns). y tenemos que times (numero de multiplicaciones)=m1.rows*m1.columns*m2.columns es decir el
     * orden de complejidad es equivalente al numero de multiplicaciones.
     */
    public static Matrix MatrixProduct(Matrix m1, Matrix m2) throws NonCompatible {
        Locale.setDefault(Locale.US); // Establecer la localización a una que use el punto como separador decimal

        if (m1.columns != m2.rows) {
            throw new NonCompatible("Incompatible matrices");
        }
        int times = 0;
        Matrix result = new Matrix(m1.rows, m2.columns);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m2.columns; j++) {
                double tmp = 0.0;
                for (int k = 0; k < m1.columns; k++) {
                    tmp += m1.GetElement(i, k).doubleValue() * m2.GetElement(k, j).doubleValue();
                    times++;
                }
                // Aplica el redondeo después de todas las sumas
                String s = String.format("%.2f", tmp);
                double roundedValue = Double.parseDouble(s);
                result.SetElement(i, j, roundedValue);
            }
        }
        System.out.println("se multiplican las celdas : " + times);
        return result;
    }



    /**
     * Imprime la matriz en la consola.
     */
    public String toString() {
        StringBuilder srt = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            srt.append("[");
            for (int j = 0; j < columns; j++) {
                srt.append(GetElement(i,j));
                if (j<columns-1){
                    srt.append(", ");
                }
            }
            srt.append("]");
            srt.append("\n");
        }
        return srt.toString();
    }
}
