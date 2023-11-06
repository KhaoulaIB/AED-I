import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Clase que contiene pruebas unitarias para la clase Matrix.
 * @author KIB
 */
public class MatrixTest {

    /**
     * Prueba la multiplicación de matrices de tipo Double.
     *
     * @throws Matrix.NonCompatible Si las matrices no son compatibles para la multiplicación.
     */
    @Test
    public void Test1() throws Matrix.NonCompatible {
        // Definir matrices de tipo Double
        Double[][] matrix0 = {{1.0, 5.7, -6.6}, {18.0, 3.6, 17.4}, {10.3, -2.9, 16.0}};
        Double[][] matrix20 = {{5.9, -1.4, 11.3, 4.5}, {10.2, 0.0, 12.2, 3.4}, {0.0, 4.2, -1.1, -1.1}};

        // Crear instancias de la clase Matrix con las matrices de prueba
        Matrix<Double> array = new Matrix<Double>(matrix0);
        Matrix<Double> array2 = new Matrix<Double>(matrix20);

        // Realizar la multiplicación de matrices
        Matrix<Double> result = Matrix.MatrixProduct(array, array2);

        // Definir el resultado esperado
        Double[][] Resultadomanual = {{64.04, -29.12, 88.1, 31.14}, {142.92, 47.88, 228.18, 74.1}, {31.19, 52.78, 63.41, 18.89}};
        Matrix expectedResult = new Matrix<>(Resultadomanual);

        // Verificar si el resultado coincide con el esperado
        assertEquals(result.toString(), expectedResult.toString());
    }

    /**
     * Prueba la multiplicación de matrices de tipo Integer.
     *
     * @throws Matrix.NonCompatible Si las matrices no son compatibles para la multiplicación.
     */
    @Test
    public void Test2() throws Matrix.NonCompatible {
        // Definir matrices de tipo Integer
        Integer[][] matrix = {{1, 5, 6}, {18, 3, 17}};
        Integer[][] matrix2 = {{5}, {10}, {0}};

        // Crear instancias de la clase Matrix con las matrices de prueba
        Matrix<Integer> array = new Matrix<Integer>(matrix);
        Matrix<Integer> array2 = new Matrix<Integer>(matrix2);

        // Realizar la multiplicación de matrices
        Matrix result0 = Matrix.MatrixProduct(array, array2);

        // Definir el resultado esperado
        Double[][] expectedResult = {{55.0}, {120.0}};

        // Verificar si el resultado coincide con el esperado
        assertEquals(result0.toString(), new Matrix<>(expectedResult).toString());
    }

    /**
     * Prueba la multiplicación de dos matrices de tipo BigInteger.
     *
     * @throws Matrix.NonCompatible Si las matrices no son compatibles para la multiplicación.
     */
    @Test
    public void Test3() throws Matrix.NonCompatible {
        BigInteger[][] a = {{new BigInteger("123456764321")}, {new BigInteger("90843626472874645452")}};
        BigInteger[][] b = {{new BigInteger("1898476537567")}, {new BigInteger("099574756847358")}};
        // Crear instancias de la clase Matrix con las matrices de prueba

        Matrix ma = new Matrix<>(a);
        Matrix mb = new Matrix<>(b);
        // Utiliza assertThrows para verificar que se lanza una excepción de tipo Matrix.NonCompatible

        assertThrows(Matrix.NonCompatible.class, () ->
                Matrix.MatrixProduct(ma, mb));
    }

    /**
     * Prueba la multiplicación de dos matrices de tipo BigInteger que son incompatibles para la multiplicación.
     * Debería lanzar una excepción de tipo Matrix.NonCompatible.
     */
    @Test
    public void Test4() {
        // Matriz con 1 fila y 1 columna
        BigInteger[][] arr1 = {{new BigInteger("18784568276715667")}};

        // Matriz con 2 filas y 1 columna
        BigInteger[][] arr2 = {{new BigInteger("18784568276715667")}, {new BigInteger("87428356374562")}};

        // Utiliza assertThrows para verificar que se lanza una excepción de tipo Matrix.NonCompatible
        assertThrows(Matrix.NonCompatible.class, () -> Matrix.MatrixProduct(new Matrix<>(arr1), new Matrix<>(arr2)));
    }
}
